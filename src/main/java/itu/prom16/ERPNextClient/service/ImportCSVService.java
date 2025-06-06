package itu.prom16.ERPNextClient.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Fanou
 */
@Service
public class ImportCSVService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    /**
     * Importe les données de trois fichiers CSV pour l'import HR.
     * 
     * @param file1 Contenu du fichier 1 (employés)
     * @param file2 Contenu du fichier 2 (structures de salaire)
     * @param file3 Contenu du fichier 3 (salaires mensuels)
     * @return Un objet contenant les statistiques d'import (créés, erreurs, etc.)
     */
    public Map<String, Object> importCSV(String sid, InputStream file1, InputStream file2, InputStream file3) throws IOException {
        // Appelle une API Python (Frappe/ERPNext) qui prend les 3 fichiers et retourne un JSON de stats d'import
        // L'API attend un POST multipart/form-data avec les 3 fichiers
        String apiUrl = baseUrl + "/api/method/hrms.api.data_import_hr.import_all";
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // On doit convertir les InputStream en fichiers temporaires pour l'envoi multipart
        Path tempFile1 = Files.createTempFile("import1-", ".csv");
        Path tempFile2 = Files.createTempFile("import2-", ".csv");
        Path tempFile3 = Files.createTempFile("import3-", ".csv");
        Files.copy(file1, tempFile1, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(file2, tempFile2, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(file3, tempFile3, StandardCopyOption.REPLACE_EXISTING);

        String boundary = "----ERPNextImportBoundary" + System.currentTimeMillis();
        var byteArrays = new ArrayList<byte[]>();

        // Helper pour construire le multipart
        try {
            String CRLF = "\r\n";
            StringBuilder sb = new StringBuilder();

            // File 1
            sb.append("--").append(boundary).append(CRLF);
            sb.append("Content-Disposition: form-data; name=\"file1\"; filename=\"file1.csv\"").append(CRLF);
            sb.append("Content-Type: text/csv").append(CRLF).append(CRLF);
            byteArrays.add(sb.toString().getBytes());
            byteArrays.add(Files.readAllBytes(tempFile1));
            byteArrays.add(CRLF.getBytes());
            sb.setLength(0);

            // File 2
            sb.append("--").append(boundary).append(CRLF);
            sb.append("Content-Disposition: form-data; name=\"file2\"; filename=\"file2.csv\"").append(CRLF);
            sb.append("Content-Type: text/csv").append(CRLF).append(CRLF);
            byteArrays.add(sb.toString().getBytes());
            byteArrays.add(Files.readAllBytes(tempFile2));
            byteArrays.add(CRLF.getBytes());
            sb.setLength(0);

            // File 3
            sb.append("--").append(boundary).append(CRLF);
            sb.append("Content-Disposition: form-data; name=\"file3\"; filename=\"file3.csv\"").append(CRLF);
            sb.append("Content-Type: text/csv").append(CRLF).append(CRLF);
            byteArrays.add(sb.toString().getBytes());
            byteArrays.add(Files.readAllBytes(tempFile3));
            byteArrays.add(CRLF.getBytes());
            sb.setLength(0);

            // End boundary
            sb.append("--").append(boundary).append("--").append(CRLF);
            byteArrays.add(sb.toString().getBytes());

            // Concaténer tous les bytes
            int totalLength = byteArrays.stream().mapToInt(b -> b.length).sum();
            byte[] multipartBody = new byte[totalLength];
            int pos = 0;
            for (byte[] arr : byteArrays) {
                System.arraycopy(arr, 0, multipartBody, pos, arr.length);
                pos += arr.length;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(apiUrl))
                    .header("Cookie", "sid=" + sid)
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .POST(HttpRequest.BodyPublishers.ofByteArray(multipartBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Nettoyage des fichiers temporaires
            Files.deleteIfExists(tempFile1);
            Files.deleteIfExists(tempFile2);
            Files.deleteIfExists(tempFile3);

            // Vérification du code retour
            if (response.statusCode() != 200) {
                Map<String, Object> error = new HashMap<>();
                error.put("status", "error");
                error.put("error", "Error HTTP " + response.statusCode());
                error.put("response", response.body());
                return error;
            }

            // On parse le JSON retourné
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            Map<String, Object> responseMap = mapper.readValue(response.body(), Map.class);
            @SuppressWarnings("unchecked")
            Map<String, Object> result = (Map<String, Object>) responseMap.get("message");
            return result;
            

        } catch (Exception e) {
            // Nettoyage en cas d'erreur
            try { Files.deleteIfExists(tempFile1); } catch (Exception ignore) {}
            try { Files.deleteIfExists(tempFile2); } catch (Exception ignore) {}
            try { Files.deleteIfExists(tempFile3); } catch (Exception ignore) {}

            Map<String, Object> error = new HashMap<>();
            error.put("status", "error");
            error.put("error", "Erreur lors de l'appel à l'API Python : " + e.getMessage());
            return error;
        }
    }
}
