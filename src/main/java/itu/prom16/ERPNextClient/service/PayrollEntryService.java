package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.PayrollEntryDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class PayrollEntryService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public PayrollEntryDTO createPayrollEntry(String sid, PayrollEntryDTO payrollEntry) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String requestBody = objectMapper.writeValueAsString(payrollEntry);

            String url = baseUrl + "/api/resource/Payroll%20Entry";

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "sid=" + sid)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while creating Payroll Entry: " + response.body());
                }
                throw new RuntimeException("Failed to create Payroll Entry, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, PayrollEntryDTO.class);
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Payroll Entry: " + e.getMessage(), e);
        }
    }

    public PayrollEntryDTO submitPayrollEntry(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Payroll%20Entry/" + URLEncoder.encode(name, StandardCharsets.UTF_8) + "?run_method=submit";

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
                    throw new CSRFTokenException("CSRF token error while submitting Payroll Entry: " + response.body());
                }
                throw new RuntimeException("Failed to submit Payroll Entry, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, PayrollEntryDTO.class);
        } 
        catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Payroll Entry: " + e.getMessage(), e);
        }
    }
}
