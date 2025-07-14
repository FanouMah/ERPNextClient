package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import itu.prom16.ERPNextClient.DTO.SalaryStructureAssignmentDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.exception.ValidationException;

/**
 *
 * @author Fanou
 */
@Service
public class SalaryStructureAssignmentService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public SalaryStructureAssignmentDTO createSalaryStructureAssignment(String sid, SalaryStructureAssignmentDTO salaryStructureAssignment) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String requestBody = objectMapper.writeValueAsString(salaryStructureAssignment);

            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment";

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
                    throw new CSRFTokenException("CSRF token error while creating Salary Structure Assignment: " + response.body());
                } 
                if ("ValidationError".equals(excType) || "DuplicateAssignment".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while creating Salary Structure Assignment: " + message);
                    }
                }
                throw new RuntimeException("Failed to create Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalaryStructureAssignmentDTO.class);
        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Salary Structure Assignment: " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO submitSSA(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment/" + URLEncoder.encode(name, StandardCharsets.UTF_8) + "?run_method=submit";

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
                    throw new CSRFTokenException("CSRF token error while submitting Salary Structure Assignment: " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while submitting Salary Structure Assignment: " + message);
                    }
                }
                throw new RuntimeException("Failed to submit Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalaryStructureAssignmentDTO.class);
        } 
        catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to submit Salary Structure Assignment: " + e.getMessage(), e);
        }
    }

    public void deleteSSSA(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment/" + URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20");

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
                    throw new CSRFTokenException("CSRF token error while deleting Salary Structure Assignment : " + response.body());
                }
                if ("ValidationError".equals(excType)) {
                    String message = root.path("exception").asText();
                    if (message != null && !message.isEmpty()) {
                        throw new ValidationException("Error while deleting Salary Structure Assignment: " + message);
                    }
                }
                throw new RuntimeException("Failed to delete Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

        } catch (CSRFTokenException | ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete Salary Structure Assignment : " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO getLastSalaryStructureAssignmentByEmployeeAndPostingDate(String sid, String employee, String date) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"from_date\",\"<\",\"" + date + "\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment" + "?filters=" + filters + "&fields=" + fieldsParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure Assignment : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                List<SalaryStructureAssignmentDTO> dtoList = objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalaryStructureAssignmentDTO>>() {});
                return dtoList.get(0);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch ssa : " + e.getMessage(), e);
        }
    }
    public SalaryStructureAssignmentDTO getLastSalaryStructureAssignmentByEmployeeAndPostingDateEgale(String sid, String employee, String date) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"from_date\",\"=\",\"" + date + "\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment" + "?filters=" + filters + "&fields=" + fieldsParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure Assignment : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                List<SalaryStructureAssignmentDTO> dtoList = objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalaryStructureAssignmentDTO>>() {});
                return dtoList.get(0);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch ssa : " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO getSalaryStructureAssignmentByEmployeeAndFromDate(String sid, String employee, String fromDate) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"from_date\",\"=\",\"" + fromDate + "\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment" + "?filters=" + filters + "&fields=" + fieldsParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure Assignment : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                List<SalaryStructureAssignmentDTO> dtoList = objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalaryStructureAssignmentDTO>>() {});
                dtoList.sort(Comparator.comparing(SalaryStructureAssignmentDTO::getFromDate).reversed());
                return dtoList.get(0);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Salary Structure Assignment : " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO cancelSSAtByEmployeeAndfromDate(String sid, String employee, String fromDate) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"],[\"from_date\",\"=\",\"" + fromDate + "\"],[\"docstatus\",\"=\",\"1\"]]", StandardCharsets.UTF_8);
            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment" + "?filters=" + filters;

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure Assignment : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (!dataNode.isArray() || dataNode.isEmpty()) {
                return null;
            } else {
                String name = dataNode.get(0).path("name").asText();
                return cancelSalaryStructureAssignment(sid, name);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to cancel Salary Structure Assignment : " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO cancelSalaryStructureAssignment(String sid, String name) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment/" + URLEncoder.encode(name, StandardCharsets.UTF_8) + "?run_method=cancel";

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
                    throw new CSRFTokenException("CSRF token error while cancelling Salary Structure Assignment: " + response.body());
                }
                throw new RuntimeException("Failed to cancel Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            return objectMapper.treeToValue(dataNode, SalaryStructureAssignmentDTO.class);
        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to cancel Salary Structure Assignment: " + e.getMessage(), e);
        }
    }

    public SalaryStructureAssignmentDTO getLastSalaryStructureAssignmentByEmployee(String sid, String employee) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filters = URLEncoder.encode("[[\"employee\",\"=\",\"" + employee + "\"]]", StandardCharsets.UTF_8);
            String fieldsParam = URLEncoder.encode("[\"*\"]", StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/api/resource/Salary%20Structure%20Assignment" + "?filters=" + filters + "&fields=" + fieldsParam;

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
                    throw new CSRFTokenException("CSRF token error while retrieving Salary Structure Assignment : " + response.body());
                }
                throw new RuntimeException("Failed to fetch Salary Structure Assignment, HTTP status code: " + response.statusCode() + " - " + response.body());
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode root = objectMapper.readTree(response.body());
            JsonNode dataNode = root.path("data");

            if (dataNode.isEmpty()) {
                return null;
            } else {
                List<SalaryStructureAssignmentDTO> dtoList = objectMapper.readValue(dataNode.toString(), new TypeReference<List<SalaryStructureAssignmentDTO>>() {});
                dtoList.sort(Comparator.comparing(SalaryStructureAssignmentDTO::getFromDate).reversed());
                return dtoList.get(0);
            }

        } catch (CSRFTokenException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Salary Structure Assignment : " + e.getMessage(), e);
        }
    }
}
