package com.example.prueba.application.service;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class PdfGeneratorApplicationServiceDefault implements PdfGeneratorApplicationService {

    private final TemplateEngine templateEngine;

    public PdfGeneratorApplicationServiceDefault(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public byte[] generatePdf(String templateName, Map<String, Object> dataModel) {
        try {
            Context context = new Context();
            context.setVariables(dataModel);

            String htmlContent = templateEngine.process(templateName, context);

            return generatePdfFromHtml(htmlContent);
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF", e);
        }
    }

    private byte[] generatePdfFromHtml(String htmlContent) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF desde HTML", e);
        }
    }
}
