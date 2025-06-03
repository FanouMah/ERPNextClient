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

import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Service
public class SalarySlipService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public List<String> getSalarySlipPrintFormat(String sid) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"doc_type\",\"=\",\"Salary Slip\"]]", StandardCharsets.UTF_8);

            String url = baseUrl + "/api/resource/Print%20Format"
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
                    throw new CSRFTokenException("CSRF token error while retrieving Print Format for Salary Slip : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Print Format for Salary Slip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            // Extract the "name" field from each object in the data array
            List<String> printFormatNames = new java.util.ArrayList<>();
            if (dataNode.isArray()) {
                for (JsonNode node : dataNode) {
                    String name = node.path("name").asText();
                    if (name != null && !name.isEmpty()) {
                        printFormatNames.add(name);
                    }
                }
            }
            return printFormatNames;

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Print Format for Salary Slip : " + e.getMessage(), e);
        }
    }

    public List<SalarySlipDTO> getSalarySlipsByEmployee(String sid, String employee) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Salary%20Slip"
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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlips by employee "+employee+" : " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlips by employee "+employee+", HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalarySlipDTO>>() {});

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips by employee "+employee+" : " + e.getMessage(), e);
        }
    }

    public List<SalarySlipDTO> getSalarySlips(String sid) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Salary%20Slip"
                    + "?fields=" + fieldsParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlips : " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlips, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalarySlipDTO>>() {});

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips : " + e.getMessage(), e);
        }
    }

    public List<SalarySlipDTO> getSalarySlipsByMonth(String sid, String filterMonth) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // filterMonth is expected in "YYYY-MM" format, e.g., "2025-03"
            // We'll filter for posting_date between "YYYY-MM-01" and the last valid day of the month

            // Parse year and month
            String[] parts = filterMonth.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);

            // Calculate last day of the month using java.time.YearMonth
            java.time.YearMonth yearMonth = java.time.YearMonth.of(year, month);
            int lastDay = yearMonth.lengthOfMonth();

            // Always use a valid last day for the month (e.g., 2025-04-30, not 2025-04-31)
            String fromDate = String.format("%04d-%02d-01", year, month);
            String toDate = String.format("%04d-%02d-%02d", year, month, lastDay);

            // Frappe expects a "between" filter for dates as: ["between", ["YYYY-MM-01", "YYYY-MM-last"]]
            String filter = String.format("{\"posting_date\":[\"between\",[\"%s\",\"%s\"]]}", fromDate, toDate);
            String filtersParam = URLEncoder.encode(filter, StandardCharsets.UTF_8.toString());
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Salary%20Slip"
                    + "?fields=" + fieldsParam
                    + "&filters=" + filtersParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlips by month: " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlips by month, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalarySlipDTO>>() {});

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips by month " + filterMonth + " : " + e.getMessage(), e);
        }
    }
}
