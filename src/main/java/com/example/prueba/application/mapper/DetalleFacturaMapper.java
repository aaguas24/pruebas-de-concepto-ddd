package com.example.prueba.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.domain.entity.DetalleFactura;

@Mapper(componentModel = "spring")
public interface DetalleFacturaMapper {
	
	DetalleFacturaDTO toDetalleFacturaDTO(DetalleFactura cliente);
	
	DetalleFactura toDetalleFactura(DetalleFacturaDTO cliente);
	
	List<DetalleFacturaDTO> toDetalleFacturaDTO(List<DetalleFactura> cliente);
}
