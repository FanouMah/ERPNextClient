package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.PaymentEntryDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class PaymentEntryService {

    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public PaymentEntryDTO createPaymentEntry(String sid, PaymentEntryDTO paymentEntry) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
            String json = mapper.writeValueAsString(paymentEntry);
    
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/resource/Payment%20Entry"))
                .header("Content-Type", "application/json")
                .header("Cookie", "sid=" + sid)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
            if (response.statusCode() != 200) {
                JsonNode root = mapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to create Payment Entry, HTTP status code: " + response.statusCode() + ", Response: " + response.body());
            }
    
            Map<String, Object> responseMap = mapper.readValue(response.body(), Map.class);
            Object data = responseMap.get("data");
            String dataJson = mapper.writeValueAsString(data);
            return mapper.readValue(dataJson, PaymentEntryDTO.class);
    
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Payment Entry : " + e.getMessage(), e);
        }
    }
    

    public void submitPaymentEntry(String sid, String paymentEntryName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/resource/Payment%20Entry/" + paymentEntryName + "?run_method=submit"))
                .header("Content-Type", "application/json")
                .header("Cookie", "sid=" + sid)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while updating Supplier Quotation Item: " + response.body());
                }
                throw new RuntimeException("Failed to submit Payment Entry, HTTP status code: " + response.statusCode() + ", Response: " + response.body());
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Payment Entry : " + e.getMessage(), e);
        }
    }
}
