package itu.prom16.ERPNextClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itu.prom16.ERPNextClient.model.SalarySlip;

/**
 *
 * @author Fanou
 */
public interface SalarySlipRepository extends JpaRepository<SalarySlip, String> {
    
    // Custom query methods can be defined here if needed
    // For example:
    // List<SalarySlip> findByEmployee(String employee);
    
    // Or any other specific queries related to SalarySlip
    
}
