package itu.prom16.ERPNextClient.service;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class CompanyService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public String getDefaultAccount(String sid, String companyName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String fieldsParam = URLEncoder.encode("[\"default_bank_account\"]", StandardCharsets.UTF_8.toString());
            String filtersParam = URLEncoder.encode("[[\"Company\",\"name\",\"=\",\"" + companyName + "\"]]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Company?fields=" + fieldsParam + "&filters=" + filtersParam;

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
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
                throw new RuntimeException("Failed to fetch company accounts, HTTP status code: " + response.statusCode() + " - " + response.body());
            }
            
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isArray() && dataNode.size() > 0) {
                JsonNode companyNode = dataNode.get(0);
                return companyNode.path("default_bank_account").asText("");
            }
            throw new RuntimeException("No default account found for company " + companyName);

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch default account: " + e.getMessage(), e);
        }
    }

    public Map<String, String> getDefaultAccounts(String sid, String companyName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String fieldsParam = URLEncoder.encode("[\"default_bank_account\",\"default_cash_account\"]", StandardCharsets.UTF_8.toString());
            String filtersParam = URLEncoder.encode("[[\"Company\",\"name\",\"=\",\"" + companyName + "\"]]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Company?fields=" + fieldsParam + "&filters=" + filtersParam;

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
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
                throw new RuntimeException("Failed to fetch company accounts, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            Map<String, String> result = new HashMap<>();
            if (dataNode.isArray() && dataNode.size() > 0) {
                JsonNode companyNode = dataNode.get(0);
                result.put("default_bank_account", companyNode.path("default_bank_account").asText(""));
                result.put("default_cash_account", companyNode.path("default_cash_account").asText(""));
            }
            return result;
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch default accounts: " + e.getMessage(), e);
        }
    }

    public String getDefaultAccountByModePaymentName(String sid, String companyName, String modePaymentName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String url = baseUrl + "/api/resource/Mode%20of%20Payment/" + URLEncoder.encode(modePaymentName, StandardCharsets.UTF_8);

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
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
                throw new RuntimeException("Failed to fetch company accounts, HTTP status code: " + response.statusCode()+ " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
    
            JsonNode accounts = root.path("data").path("accounts");
    
            for (JsonNode account : accounts) {
                if (companyName.equals(account.path("company").asText())) {
                    return account.path("default_account").asText();
                }
            }
    
            throw new RuntimeException("No default account found for company " + companyName + " and mode of payment " + modePaymentName);

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch default accounts: " + e.getMessage(), e);
        }
    }

}
