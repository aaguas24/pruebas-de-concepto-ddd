package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T09:17:13-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toProductoDTO(Producto cliente) {
        if ( cliente == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setCategoria( cliente.getCategoria() );
        productoDTO.setCodigoProducto( cliente.getCodigoProducto() );
        productoDTO.setDescipcion( cliente.getDescipcion() );
        productoDTO.setDescuento( cliente.getDescuento() );
        productoDTO.setEsExento( cliente.getEsExento() );
        productoDTO.setFechaIngreso( cliente.getFechaIngreso() );
        productoDTO.setFechaVencimiento( cliente.getFechaVencimiento() );
        productoDTO.setId( cliente.getId() );
        productoDTO.setIdProveedor( cliente.getIdProveedor() );
        productoDTO.setImpuesto( cliente.getImpuesto() );
        productoDTO.setLote( cliente.getLote() );
        productoDTO.setMarca( cliente.getMarca() );
        productoDTO.setModelo( cliente.getModelo() );
        productoDTO.setNombre( cliente.getNombre() );
        productoDTO.setOrigen( cliente.getOrigen() );
        productoDTO.setPrecioUnitario( cliente.getPrecioUnitario() );
        productoDTO.setUnidadMedida( cliente.getUnidadMedida() );

        return productoDTO;
    }

    @Override
    public Producto toProducto(ProductoDTO cliente) {
        if ( cliente == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( cliente.getCategoria() );
        producto.setCodigoProducto( cliente.getCodigoProducto() );
        producto.setDescipcion( cliente.getDescipcion() );
        producto.setDescuento( cliente.getDescuento() );
        producto.setEsExento( cliente.getEsExento() );
        producto.setFechaIngreso( cliente.getFechaIngreso() );
        producto.setFechaVencimiento( cliente.getFechaVencimiento() );
        producto.setId( cliente.getId() );
        producto.setIdProveedor( cliente.getIdProveedor() );
        producto.setImpuesto( cliente.getImpuesto() );
        producto.setLote( cliente.getLote() );
        producto.setMarca( cliente.getMarca() );
        producto.setModelo( cliente.getModelo() );
        producto.setNombre( cliente.getNombre() );
        producto.setOrigen( cliente.getOrigen() );
        producto.setPrecioUnitario( cliente.getPrecioUnitario() );
        producto.setUnidadMedida( cliente.getUnidadMedida() );

        return producto;
    }

    @Override
    public List<ProductoDTO> toProductoDTO(List<Producto> cliente) {
        if ( cliente == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( cliente.size() );
        for ( Producto producto : cliente ) {
            list.add( toProductoDTO( producto ) );
        }

        return list;
    }
}
