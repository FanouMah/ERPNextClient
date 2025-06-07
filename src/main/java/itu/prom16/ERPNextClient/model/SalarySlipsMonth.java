package itu.prom16.ERPNextClient.model;

import java.math.BigDecimal;
import java.util.List;

import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;

/**
 *
 * @author Fanou
 */
public class SalarySlipsMonth {
    private String month;
    private BigDecimal totalEarnings;
    private BigDecimal totalDeductions;
    private BigDecimal totalNetPay;
    private List<SalarySlipDTO> salarySlips;

    public SalarySlipsMonth() { }

    public SalarySlipsMonth(String month, BigDecimal totalEarnings, BigDecimal totalDeductions, BigDecimal totalNetPay, List<SalarySlipDTO> salarySlips) {
        this.month = month;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.totalNetPay = totalNetPay;
        this.salarySlips = salarySlips;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public BigDecimal getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(BigDecimal totalEarnings) { this.totalEarnings = totalEarnings; }

    public BigDecimal getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(BigDecimal totalDeductions) { this.totalDeductions = totalDeductions; }

    public BigDecimal getTotalNetPay() { return totalNetPay; }
    public void setTotalNetPay(BigDecimal totalNetPay) { this.totalNetPay = totalNetPay; }

    public List<SalarySlipDTO> getSalarySlips() { return salarySlips; }
    public void setSalarySlips(List<SalarySlipDTO> salarySlips) { this.salarySlips = salarySlips; } 
}
