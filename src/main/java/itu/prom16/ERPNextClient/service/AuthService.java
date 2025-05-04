package itu.prom16.ERPNextClient.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import itu.prom16.ERPNextClient.exception.HttpUnauthorizedException;

/**
 *
 * @author Fanou
 */
@Service
public class AuthService {
     @Value("${erpnext.api.base-url}")
    private String baseUrl;

    public List<String> login(String username, String password) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(Map.of("usr", username, "pwd", password));
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/method/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            if (response.statusCode() == 200) {
                return response.headers().map().get("set-cookie");
            } else if (response.statusCode() == 401) {
                JsonNode body = mapper.readTree(response.body());
                String message = body.path("message").asText("");
                throw new HttpUnauthorizedException(message);
            } else {
                throw new RuntimeException("HTTP error : " + response.statusCode() + " - " + response.body());
            }

        } catch (HttpUnauthorizedException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error while logging in: " + e.getMessage(), e);
        }
    }

    public List<String> logout() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/method/logout"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            if (response.statusCode() == 200) {
                List<String> cookies = response.headers().map().get("set-cookie");
                return cookies;
            } else {
                throw new RuntimeException("HTTP error when logging out : " + response.statusCode()+ " - " + response.body());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error during logout : " + e.getMessage(), e);
        }
    }

    public boolean isLoggedIn(String sid) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/method/frappe.auth.get_logged_user"))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "sid=" + sid) 
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            return response.statusCode() == 200;

        } catch (Exception e) {
            throw new RuntimeException("Error checking connection status : " + e.getMessage(), e);
        }
    }
}
