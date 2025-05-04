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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.PaymentEntryDTO;

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

            String json = mapper.writeValueAsString(paymentEntry);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/resource/Payment%20Entry"))
                .header("Content-Type", "application/json")
                .header("Cookie", "sid=" + sid)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to create Payment Entry, HTTP status code: " + response.statusCode() + ", Response: " + response.body());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);
            Object data = responseMap.get("data");
            String dataJson = objectMapper.writeValueAsString(data);
            PaymentEntryDTO createdPaymentEntry = objectMapper.readValue(dataJson, PaymentEntryDTO.class);

            return createdPaymentEntry;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Payment Entry : " + e.getMessage(), e);
        }
    }

    public void submitPaymentEntry(String sid, String paymentEntryName) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/resource/Payment%20Entry/" + paymentEntryName + "?run_method=submit"))
                .header("Content-Type", "application/json")
                .header("Cookie", "sid=" + sid)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to submit Payment Entry, HTTP status code: " + response.statusCode() + ", Response: " + response.body());
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Payment Entry : " + e.getMessage(), e);
        }
    }
}
