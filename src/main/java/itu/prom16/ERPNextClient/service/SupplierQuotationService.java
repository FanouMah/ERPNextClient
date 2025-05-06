package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.SupplierQuotationDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class SupplierQuotationService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public SupplierQuotationDTO getRequestForQuotationsByName(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String url = baseUrl + "/api/resource/Supplier%20Quotation/" + URLEncoder.encode(name, StandardCharsets.UTF_8);

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
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to fetch Supplier Quotation, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SupplierQuotationDTO.class);

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Supplier Quotation: " + e.getMessage(), e);
        }
    }

    public List<SupplierQuotationDTO> getRequestForQuotationsBySupplier(String sid, String supplierName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"supplier\",\"=\",\"" + supplierName + "\"]]", StandardCharsets.UTF_8);

            String url = baseUrl + "/api/resource/Supplier%20Quotation"
                    + "?filters=" + filters;

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
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to fetch Supplier Quotation list, HTTP status code : " + response.statusCode() + " - " + response.body());
            }
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            List<SupplierQuotationDTO> fullQuotations = new ArrayList<>();

            for (JsonNode node : dataNode) {
                String name = node.path("name").asText();
                fullQuotations.add(getRequestForQuotationsByName(sid, name));
            }

            return fullQuotations;

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Supplier Quotations with items: " + e.getMessage(), e);
        }
    }
    
    public void updateSupplierQuotationItem(String sid, String itemName, double qty, double rate) {
        try {
            String url = baseUrl + "/api/resource/Supplier%20Quotation%20Item/" + URLEncoder.encode(itemName, StandardCharsets.UTF_8);
            
            ObjectMapper mapper = new ObjectMapper();
            HttpClient httpClient = HttpClient.newHttpClient();

            String requestBody = mapper.writeValueAsString(Map.of("qty", qty, "rate", rate));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Cookie", "sid=" + sid)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                JsonNode root = mapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to update Supplier Quotation Item, HTTP status code: " + response.statusCode() + " - " + response.body());
            }
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update Supplier Quotation Item: " + e.getMessage(), e);
        }
    }

    public void submitSupplierQuotation(String sid, String quotationName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/resource/Supplier%20Quotation/" + quotationName + "?run_method=submit"))
                    .header("Cookie", "sid=" + sid)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to submit Supplier Quotation, HTTP status code: " + response.statusCode() + " - " + response.body());
            }
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Supplier Quotation: " + e.getMessage(), e);
        }
    }
}
