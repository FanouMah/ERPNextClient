package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fanou
 */
@Service
public class SalarySlipService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;
}
