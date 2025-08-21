package com.example.prueba.infrastructure.service;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.prueba.application.port.PdfGeneratorService;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService{
	
	private final TemplateEngine templateEngine;

    public PdfGeneratorServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

	@Override
	public byte[] generatePdf(String templateName, Map<String, Object> dataModel) throws RuntimeException {
		Context context = new Context();
        context.setVariables(dataModel);

        String htmlContent = templateEngine.process(templateName, context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(outputStream);
            builder.run();

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF", e);
        }
	}

}