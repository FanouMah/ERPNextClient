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

import itu.prom16.ERPNextClient.DTO.PurchaseOrderDTO;
import itu.prom16.ERPNextClient.DTO.SupplierQuotationDTO;
import itu.prom16.ERPNextClient.DTO.SupplierQuotationItemDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;


/**
 *
 * @author Fanou
 */
@Service
public class PurchaseOrderService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public List<PurchaseOrderDTO> getPurchaseOrdersBySupplier(String sid, String supplierName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"supplier\",\"=\",\"" + supplierName + "\"]]", StandardCharsets.UTF_8);
            String fields = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8);

            String url = baseUrl + "/api/resource/Purchase%20Order"
                       + "?filters=" + filters
                       + "&fields=" + fields;
    
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
                throw new RuntimeException("Failed to fetch Purchase Order, HTTP status code: " + response.statusCode() + " - " + response.body());
            }
    
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");
    
            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<PurchaseOrderDTO>>() {});
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Purchase Order : " + e.getMessage(), e);
        }
    }

    public PurchaseOrderDTO createPurchaseOrder(String sid, SupplierQuotationDTO supplierQuotation) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO();
            purchaseOrder.setSupplier(supplierQuotation.getSupplier());
            purchaseOrder.setSupplierName(supplierQuotation.getSupplierName());
            for (SupplierQuotationItemDTO i : supplierQuotation.getItems()) {
                i.setScheduleDate(java.time.LocalDate.now());
            }
            purchaseOrder.setItems(supplierQuotation.getItems());

            purchaseOrder.setScheduleDate(java.time.LocalDate.now());

            String requestBody = objectMapper.writeValueAsString(purchaseOrder);

            String url = baseUrl + "/api/resource/Purchase%20Order";

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
                    throw new CSRFTokenException("CSRF token error while creating Purchase Order: " + response.body());
                }
                throw new RuntimeException("Failed to create Purchase Order, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, PurchaseOrderDTO.class);
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Purchase Order: " + e.getMessage(), e);
        }
    }
}
