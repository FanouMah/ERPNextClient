package itu.prom16.ERPNextClient.service;

import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;

/**
 *
 * @author Fanou
 */
@Service

public class PDFGeneratorService {
    @Autowired
    private ResourceLoader resourceLoader;
    
    private final TemplateEngine templateEngine;
    
    public PDFGeneratorService() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        
        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
    }

    public byte[] generateSalarySlipPDF(SalarySlipDTO salarySlip) {
        try {
            // Vérifier que le template existe
            Resource templateResource = resourceLoader.getResource("classpath:templates/salary-slip-pdf.html");
            if (!templateResource.exists()) {
                throw new FileNotFoundException("Template salary-slip-pdf.html not found in classpath:templates/");
            }
            
            // Préparation des données
            Context context = new Context();
            context.setVariable("salarySlip", salarySlip);
            context.setVariable("monthName",     Month.of(salarySlip.getPostingDate().getMonthValue())
            .getDisplayName(TextStyle.FULL, Locale.ENGLISH)
            + " " + salarySlip.getPostingDate().getYear());
            
            // Génération du HTML
            String html = templateEngine.process("salary-slip-pdf", context);
            
            // Conversion en PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            
            // Configuration pour supporter les caractères UTF-8
            renderer.getFontResolver().addFontDirectory("/usr/share/fonts", true);
            
            try {
                renderer.setDocumentFromString(html);
                renderer.layout();
                renderer.createPDF(outputStream);
                outputStream.close();
                
                byte[] pdfBytes = outputStream.toByteArray();
                
                return pdfBytes;
                
            } catch (Exception pdfException) {
                pdfException.printStackTrace();
                throw new RuntimeException("Error during HTML to PDF conversion", pdfException);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Salary slip template not found", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during PDF generation", e);
        }
    }
}
