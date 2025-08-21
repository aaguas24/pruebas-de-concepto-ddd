package com.example.prueba.application.port;

import java.util.Map;

public interface PdfGeneratorService {
    byte[] generatePdf(String templateName, Map<String, Object> dataModel) throws RuntimeException;
}
