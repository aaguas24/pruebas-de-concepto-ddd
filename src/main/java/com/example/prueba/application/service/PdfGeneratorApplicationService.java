package com.example.prueba.application.service;

import java.util.Map;

public interface PdfGeneratorApplicationService {
	public byte[] generatePdf(String templateName, Map<String, Object> dataModel);
}
