package itu.prom16.ERPNextClient;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import itu.prom16.ERPNextClient.model.SalarySlip;
import itu.prom16.ERPNextClient.service.SalarySlipService;

/**
 *
 * @author Fanou
 */
@SpringBootTest
public class SalarySlipServiceTest {

    @Autowired
    private SalarySlipService salarySlipService;

    @Test
    public void testGetAllSalarySlips() {
        List<SalarySlip> slips = salarySlipService.getAllSalarySlips();
        slips.forEach(System.out::println);
        Assertions.assertNotNull(slips);
    }
}
