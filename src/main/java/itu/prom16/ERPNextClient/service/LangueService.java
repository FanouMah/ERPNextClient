package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
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

import itu.prom16.ERPNextClient.DTO.LangueDTO;
import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class LangueService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public List<LangueDTO> getLanguesEnabled(String sid) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"enabled\",\"=\",\"1\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"language_code\",\"language_name\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Language"
                    + "?filters=" + filters
                    + "&fields=" + fieldsParam;

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Cookie", "sid=" + sid)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while retrieving Language : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Language, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<LangueDTO>>() {});

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Language : " + e.getMessage(), e);
        }
    }
}
