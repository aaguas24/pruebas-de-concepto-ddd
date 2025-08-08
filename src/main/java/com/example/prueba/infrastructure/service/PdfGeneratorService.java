package com.example.prueba.infrastructure.service;

import java.util.Map;

public interface PdfGeneratorService {
	public byte[] generatePdf(String templateName, Map<String, Object> dataModel);
}
