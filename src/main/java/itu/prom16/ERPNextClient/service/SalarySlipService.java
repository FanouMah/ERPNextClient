package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.exception.ValidationException;
import itu.prom16.ERPNextClient.model.SalarySlip;
import itu.prom16.ERPNextClient.repository.SalarySlipRepository;

/**
 *
 * @author Fanou
 */
@Service
public class SalarySlipService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    @Autowired
    private SalarySlipRepository salarySlipRepository;

    public List<SalarySlip> getAllSalarySlips() {
        return salarySlipRepository.findAll();
    }

    public void deleteSalarySlip(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Slip/" + URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20");

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "sid=" + sid)
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 202) {
                JsonNode root = objectMapper.readTree(response.body());
                String excType = root.path("exc_type").asText();
                if ("CSRFTokenError".equals(excType)) {
                    throw new CSRFTokenException("CSRF token error while deleting Salary Slip : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while deleting Salary Slip: " + message);
                    }
                }
                throw new RuntimeException("Failed to delete Salary Slip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete Salary Slip : " + e.getMessage(), e);
        }
    }

    public SalarySlipDTO submitSalarySlip(String sid, String name) {
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
                    throw new CSRFTokenException("CSRF token error while submitting Salary Slip : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while submitting Salary Slip: " + message);
                    }
                }
                throw new RuntimeException("Failed to submit Salary Slip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalarySlipDTO.class);

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Salary Slip : " + e.getMessage(), e);
        }
    }

    public SalarySlipDTO createSalarySlip(String sid, SalarySlipDTO salarySlip) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Slip";

            HttpClient httpClient = HttpClient.newHttpClient();

            String requestBody = objectMapper.writeValueAsString(salarySlip);

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
                    throw new CSRFTokenException("CSRF token error while creating Salary Slip : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while creating Salary Slip: " + message);
                    }
                }
                throw new RuntimeException("Failed to create Salary Slip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalarySlipDTO.class);

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Salary Slip : " + e.getMessage(), e);
        } 
    }

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
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"status\",\"=\",\"Submitted\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"name\", \"employee\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Salary%20Slip"
                    + "?filters=" + filters
                    + "&fields=" + fieldsParam
                    + "&order_by=posting_date%20asc"
                    + "&limit_page_length=none";

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

            List<SalarySlipDTO> slips = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String name = node.path("name").asText();
                SalarySlipDTO slip = getSalarySlip(sid, name);
                slips.add(slip);
            }

            return slips;

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips by employee "+employee+" : " + e.getMessage(), e);
        }
    }

    public SalarySlipDTO getSalarySlip(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20");

            String url = baseUrl + "/api/resource/Salary%20Slip/" + encodedName;

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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlip : " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                return objectMapper.readValue(dataNode.toString(), new TypeReference<SalarySlipDTO>() {});
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlip : " + e.getMessage(), e);
        }
    }

    public SalarySlipDTO getSalarySlipByEmployeeDate(String sid, String employee, String date) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"posting_date\",\"=\",\"" + date + "\"]]", StandardCharsets.UTF_8);
            String url = baseUrl + "/api/resource/Salary%20Slip?filters="+filters;

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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlip : " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                List<SalarySlipDTO> dtoList = objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalarySlipDTO>>() {});
                SalarySlipDTO  ss = dtoList.get(0);
                return getSalarySlip(sid, ss.getName()); 
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlip : " + e.getMessage(), e);
        }
    }

    public List<SalarySlipDTO> getSalarySlips(String sid) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String filters = URLEncoder.encode("[[\"status\",\"=\",\"Submitted\"]]", StandardCharsets.UTF_8);

            String url = baseUrl + "/api/resource/Salary%20Slip?limit_page_length=none&filters=" + filters
                    + "&order_by=posting_date%20asc";

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

            List<SalarySlipDTO> slips = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String name = node.path("name").asText();
                SalarySlipDTO slip = getSalarySlip(sid, name);
                slips.add(slip);
            }
    
            return slips;

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
            // Add status = Submitted filter in addition to posting_date between
            String filter = String.format("{\"posting_date\":[\"between\",[\"%s\",\"%s\"]],\"status\":\"Submitted\"}", fromDate, toDate);
            String filtersParam = URLEncoder.encode(filter, StandardCharsets.UTF_8.toString());
            String fieldsParam = URLEncoder.encode("[\"name\", \"posting_date\"]", StandardCharsets.UTF_8.toString());

            String url = baseUrl + "/api/resource/Salary%20Slip"
                    + "?fields=" + fieldsParam
                    + "&filters=" + filtersParam
                    + "&limit_page_length=none";

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

            List<SalarySlipDTO> slips = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String name = node.path("name").asText();
                SalarySlipDTO slip = getSalarySlip(sid, name);
                slips.add(slip);
            }
    
            return slips;

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips by month " + filterMonth + " : " + e.getMessage(), e);
        }
    }

    public List<SalarySlipDTO> getSalarySlipsByYear(String sid, String filterYear) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
    
            // Parse year (e.g. "2025")
            int year;
            if (filterYear == null || filterYear.trim().isEmpty()) {
                year = java.time.Year.now().getValue();
            } else {
                year = Integer.parseInt(filterYear.trim());
            }
    
            // Dates from 1st Jan to 31st Dec of that year
            String fromDate = String.format("%04d-01-01", year);
            String toDate = String.format("%04d-12-31", year);
    
            // Frappe expects a "between" filter for dates
            String filter = String.format("{\"posting_date\":[\"between\",[\"%s\",\"%s\"]]}", fromDate, toDate);
            String filtersParam = URLEncoder.encode(filter, StandardCharsets.UTF_8.toString());
            String fieldsParam = URLEncoder.encode("[\"name\", \"posting_date\"]", StandardCharsets.UTF_8.toString());
    
            String url = baseUrl + "/api/resource/Salary%20Slip"
                    + "?fields=" + fieldsParam
                    + "&filters=" + filtersParam
                    + "&limit_page_length=none";
    
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
                    throw new CSRFTokenException("CSRF token error while retrieving SalarySlips by year: " + response.body());
                }
                throw new RuntimeException("Failed to fetch SalarySlips by year, HTTP status code: " + response.statusCode() + " - " + response.body());
            }
    
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");
    
            List<SalarySlipDTO> slips = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String name = node.path("name").asText();
                SalarySlipDTO slip = getSalarySlip(sid, name);
                slips.add(slip);
            }
    
            return slips;
    
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch SalarySlips by year " + filterYear + " : " + e.getMessage(), e);
        }
    }  
    
    public SalarySlipDTO cancelSalarySlip(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Slip/" + URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20") + "?run_method=cancel";

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
                    throw new CSRFTokenException("CSRF token error while cancelling Salary Slip : " + response.body());
                }
                throw new RuntimeException("Failed to cancel Salary Slip, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalarySlipDTO.class);

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to cancel Salary Slip : " + e.getMessage(), e);
        }
    }
}
