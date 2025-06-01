package itu.prom16.ERPNextClient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fanou
 */
@Service
public class ImportCSVService {
    @Value("${erpnext.api.base-url}")
    private String baseUrl;

    /**
     * Importe les données de trois fichiers CSV pour l'import HR.
     * 
     * @param file1 Contenu du fichier 1 (employés)
     * @param file2 Contenu du fichier 2 (structures de salaire)
     * @param file3 Contenu du fichier 3 (salaires mensuels)
     * @return Un objet contenant les statistiques d'import (créés, erreurs, etc.)
     */
    public java.util.Map<String, Object> importCSV(
            java.io.InputStream file1,
            java.io.InputStream file2,
            java.io.InputStream file3
    ) throws java.io.IOException {
        long start = System.currentTimeMillis();
        java.util.Map<String, Object> stats = new java.util.HashMap<>();
        int createdDocuments = 0;
        int createdEmployee = 0;
        int createdCompany = 0;
        int createdHolidayList = 0;
        int createdSalaryStructures = 0;
        int createdSalaryComponents = 0;
        int createdSalaryStructureAssignment = 0;
        int createdPayrollEntry = 0;
        int createdSalarySlip = 0;
        int createdJournalEntry = 0;
        java.util.List<String> errors = new java.util.ArrayList<>();

        // On utilise une transaction pour simuler le comportement de rollback en cas d'erreur critique
        // (En vrai, il faudrait une vraie transaction DB, ici on simule la logique)
        boolean criticalError = false;
        String criticalErrorMessage = null;

        try {
            // --- Fichier 1 : Employés ---
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(file1))) {
                String line = reader.readLine(); // header
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    lineNum++;
                    String[] cols = line.split(",", -1);
                    if (cols.length < 7) {
                        errors.add("Fichier 1: Ligne invalide (ligne " + lineNum + "): " + line);
                        continue;
                    }
                    try {
                        // Exemples de traitement
                        String ref = cols[0].trim();
                        String nom = cols[1].trim();
                        String prenom = cols[2].trim();
                        String genre = cols[3].trim();
                        String dateEmbauche = cols[4].trim();
                        String dateNaissance = cols[5].trim();
                        String company = cols[6].trim();

                        // Simuler la création d'un employé et d'une compagnie
                        // Si une erreur d'insertion critique survient, on lève une exception
                        if (ref.isEmpty() || nom.isEmpty()) {
                            throw new RuntimeException("Donnée employé manquante (ref ou nom vide)");
                        }
                        createdEmployee++;
                        createdCompany++;
                        createdDocuments++;
                    } catch (Exception e) {
                        // Erreur critique d'insertion
                        criticalError = true;
                        criticalErrorMessage = "Erreur critique lors de l'insertion d'un employé (ligne " + lineNum + "): " + e.getMessage();
                        throw e;
                    }
                }
            } catch (RuntimeException ex) {
                // On laisse passer l'exception pour rollback global
                throw ex;
            } catch (Exception ex) {
                // Erreur mineure de lecture
                errors.add("Erreur lors de la lecture du fichier 1: " + ex.getMessage());
            }

            // --- Fichier 2 : Structures de salaire ---
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(file2))) {
                String line = reader.readLine(); // header
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    lineNum++;
                    String[] cols = line.split(",", -1);
                    if (cols.length < 6) {
                        errors.add("Fichier 2: Ligne invalide (ligne " + lineNum + "): " + line);
                        continue;
                    }
                    try {
                        String salaryStructure = cols[0].trim();
                        String name = cols[1].trim();
                        String abbr = cols[2].trim();
                        String type = cols[3].trim();
                        String valeur = cols[4].trim();
                        String remarque = cols[5].trim();

                        // Simuler la création de structure et composant de salaire
                        if (salaryStructure.isEmpty() || name.isEmpty()) {
                            throw new RuntimeException("Donnée structure de salaire manquante (structure ou nom vide)");
                        }
                        createdSalaryStructures++;
                        createdSalaryComponents++;
                        createdDocuments++;
                    } catch (Exception e) {
                        criticalError = true;
                        criticalErrorMessage = "Erreur critique lors de l'insertion d'une structure de salaire (ligne " + lineNum + "): " + e.getMessage();
                        throw e;
                    }
                }
            } catch (RuntimeException ex) {
                throw ex;
            } catch (Exception ex) {
                errors.add("Erreur lors de la lecture du fichier 2: " + ex.getMessage());
            }

            // --- Fichier 3 : Salaires mensuels ---
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(file3))) {
                String line = reader.readLine(); // header
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    lineNum++;
                    String[] cols = line.split(",", -1);
                    if (cols.length < 4) {
                        errors.add("Fichier 3: Ligne invalide (ligne " + lineNum + "): " + line);
                        continue;
                    }
                    try {
                        String mois = cols[0].trim();
                        String refEmploye = cols[1].trim();
                        String salaireBase = cols[2].trim();
                        String salaryStructure = cols[3].trim();

                        // Simuler la création d'une fiche de paie, d'une affectation, etc.
                        if (mois.isEmpty() || refEmploye.isEmpty()) {
                            throw new RuntimeException("Donnée salaire mensuel manquante (mois ou ref employé vide)");
                        }
                        createdSalaryStructureAssignment++;
                        createdPayrollEntry++;
                        createdSalarySlip++;
                        createdJournalEntry++;
                        createdDocuments++;
                    } catch (Exception e) {
                        criticalError = true;
                        criticalErrorMessage = "Erreur critique lors de l'insertion d'un salaire mensuel (ligne " + lineNum + "): " + e.getMessage();
                        throw e;
                    }
                }
            } catch (RuntimeException ex) {
                throw ex;
            } catch (Exception ex) {
                errors.add("Erreur lors de la lecture du fichier 3: " + ex.getMessage());
            }

            // Si tout s'est bien passé, on retourne les stats
            stats.put("created_documents", createdDocuments);
            stats.put("created_employee", createdEmployee);
            stats.put("created_company", createdCompany);
            stats.put("created_holiday_list", createdHolidayList);
            stats.put("created_salary_structures", createdSalaryStructures);
            stats.put("created_salary_components", createdSalaryComponents);
            stats.put("created_salary_structure_assignment", createdSalaryStructureAssignment);
            stats.put("created_payroll_entry", createdPayrollEntry);
            stats.put("created_salary_slip", createdSalarySlip);
            stats.put("created_journal_entry", createdJournalEntry);
            stats.put("duration_seconds", (System.currentTimeMillis() - start) / 1000.0);
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            stats.put("end_time", java.time.LocalDateTime.now().format(formatter));
            stats.put("error_count", errors.size());
            stats.put("errors", errors);

            return stats;

        } catch (Exception critical) {
            // Rollback simulé : on retourne une erreur critique et on n'enregistre rien
            // (En vrai, il faudrait annuler la transaction DB)
            java.util.Map<String, Object> errorResult = new java.util.HashMap<>();
            errorResult.put("status", "error");
            errorResult.put("error", criticalErrorMessage != null ? criticalErrorMessage : critical.getMessage());
            errorResult.put("created_documents", 0);
            errorResult.put("created_employee", 0);
            errorResult.put("created_company", 0);
            errorResult.put("created_holiday_list", 0);
            errorResult.put("created_salary_structures", 0);
            errorResult.put("created_salary_components", 0);
            errorResult.put("created_salary_structure_assignment", 0);
            errorResult.put("created_payroll_entry", 0);
            errorResult.put("created_salary_slip", 0);
            errorResult.put("created_journal_entry", 0);
            errorResult.put("duration_seconds", (System.currentTimeMillis() - start) / 1000.0);
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            errorResult.put("end_time", java.time.LocalDateTime.now().format(formatter));
            errorResult.put("error_count", 1);
            java.util.List<String> errorList = new java.util.ArrayList<>();
            errorList.add(criticalErrorMessage != null ? criticalErrorMessage : critical.getMessage());
            errorResult.put("errors", errorList);
            return errorResult;
        }
    }
}
