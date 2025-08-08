package com.example.prueba.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
	ProductoDTO toProductoDTO(Producto cliente);
	
	Producto toProducto(ProductoDTO cliente);
	
	List<ProductoDTO> toProductoDTO(List<Producto> cliente);
}
