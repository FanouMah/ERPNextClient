package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

            String json = mapper.writeValueAsString(paymentEntry);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/resource/Payment%20Entry"))
                .header("Content-Type", "application/json")
                .header("Cookie", "sid=" + sid)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to create Payment Entry, HTTP status code: " + response.statusCode());
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
}
