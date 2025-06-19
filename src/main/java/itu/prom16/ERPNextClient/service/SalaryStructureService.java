package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.SalaryStructureDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.exception.ValidationException;

/**
 *
 * @author Fanou
 */
@Service
public class SalaryStructureService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public SalaryStructureDTO submitSalaryStructure(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Slip/" + URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20") + "?run_method=submit";

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "sid=" + sid)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while submitting Salary Structure : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while submitting Salary Structure : " + message);
                    }
                }
                throw new RuntimeException("Failed to submit Salary Structure, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalaryStructureDTO.class);

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Salary Structure : " + e.getMessage(), e);
        }
    }

    public SalaryStructureDTO createSalaryStructure(String sid, SalaryStructureDTO salaryStructure) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Structure";

            HttpClient httpClient = HttpClient.newHttpClient();

            String requestBody = objectMapper.writeValueAsString(salaryStructure);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "sid=" + sid)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = objectMapper.readTree(response.body());

            if (response.statusCode() != 200) {
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while creating Salary Structure : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while creating Salary Structure : " + message);
                    }
                }
                throw new RuntimeException("Failed to create Salary Structure, HTTP status code : " + response.statusCode() + " - " + response.body());
            }

            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalaryStructureDTO.class);

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Salary Structure : " + e.getMessage(), e);
        } 
    }

    public SalaryStructureDTO getSalaryStructure(String sid) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String url = baseUrl + "/api/resource/Salary%20Structure";

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                return objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalaryStructureDTO>>() {}).get(0);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Salary Structure Assignment : " + e.getMessage(), e);
        }
    }
}
