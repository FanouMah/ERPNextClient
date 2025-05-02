package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.SupplierDTO;

import java.net.URLEncoder;

/**
 *
 * @author Fanou
 */
@Service
public class SupplierService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public List<SupplierDTO> getSuppliers(String sid) {
        try {
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Supplier?fields=" + fieldsParam;

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
                    .header("Cookie", "sid=" + sid)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to fetch suppliers, HTTP status code: " + response.statusCode());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<SupplierDTO>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch suppliers : " + e.getMessage(), e);
        }
    }
}
