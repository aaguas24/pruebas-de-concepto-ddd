package com.example.prueba.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.domain.entity.Factura;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
	FacturaDTO toFacturaDTO(Factura cliente);
	
	Factura toFactura(FacturaDTO cliente);
	
	List<FacturaDTO> toFacturaDTO(List<Factura> cliente);
}
