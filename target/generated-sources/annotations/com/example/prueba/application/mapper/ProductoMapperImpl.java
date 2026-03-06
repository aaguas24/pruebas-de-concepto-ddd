package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.Producto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T14:10:36-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public Producto toEntity(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( productoDTO.getCategoria() );
        producto.setCodigoProducto( productoDTO.getCodigoProducto() );
        producto.setDescipcion( productoDTO.getDescipcion() );
        producto.setDescuento( productoDTO.getDescuento() );
        producto.setEsExento( productoDTO.getEsExento() );
        producto.setFechaIngreso( productoDTO.getFechaIngreso() );
        producto.setFechaVencimiento( productoDTO.getFechaVencimiento() );
        producto.setId( productoDTO.getId() );
        producto.setIdProveedor( productoDTO.getIdProveedor() );
        producto.setImpuesto( productoDTO.getImpuesto() );
        producto.setLote( productoDTO.getLote() );
        producto.setMarca( productoDTO.getMarca() );
        producto.setModelo( productoDTO.getModelo() );
        producto.setNombre( productoDTO.getNombre() );
        producto.setOrigen( productoDTO.getOrigen() );
        producto.setPrecioUnitario( productoDTO.getPrecioUnitario() );
        producto.setUnidadMedida( productoDTO.getUnidadMedida() );

        return producto;
    }

    @Override
    public ProductoDTO toDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setCategoria( producto.getCategoria() );
        productoDTO.setCodigoProducto( producto.getCodigoProducto() );
        productoDTO.setDescipcion( producto.getDescipcion() );
        productoDTO.setDescuento( producto.getDescuento() );
        productoDTO.setEsExento( producto.getEsExento() );
        productoDTO.setFechaIngreso( producto.getFechaIngreso() );
        productoDTO.setFechaVencimiento( producto.getFechaVencimiento() );
        productoDTO.setId( producto.getId() );
        productoDTO.setIdProveedor( producto.getIdProveedor() );
        productoDTO.setImpuesto( producto.getImpuesto() );
        productoDTO.setLote( producto.getLote() );
        productoDTO.setMarca( producto.getMarca() );
        productoDTO.setModelo( producto.getModelo() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setOrigen( producto.getOrigen() );
        productoDTO.setPrecioUnitario( producto.getPrecioUnitario() );
        productoDTO.setUnidadMedida( producto.getUnidadMedida() );

        return productoDTO;
    }

    @Override
    public Producto partialUpdate(ProductoDTO productoDTO, Producto producto) {
        if ( productoDTO == null ) {
            return producto;
        }

        if ( productoDTO.getCategoria() != null ) {
            producto.setCategoria( productoDTO.getCategoria() );
        }
        if ( productoDTO.getCodigoProducto() != null ) {
            producto.setCodigoProducto( productoDTO.getCodigoProducto() );
        }
        if ( productoDTO.getDescipcion() != null ) {
            producto.setDescipcion( productoDTO.getDescipcion() );
        }
        if ( productoDTO.getDescuento() != null ) {
            producto.setDescuento( productoDTO.getDescuento() );
        }
        if ( productoDTO.getEsExento() != null ) {
            producto.setEsExento( productoDTO.getEsExento() );
        }
        if ( productoDTO.getFechaIngreso() != null ) {
            producto.setFechaIngreso( productoDTO.getFechaIngreso() );
        }
        if ( productoDTO.getFechaVencimiento() != null ) {
            producto.setFechaVencimiento( productoDTO.getFechaVencimiento() );
        }
        if ( productoDTO.getId() != null ) {
            producto.setId( productoDTO.getId() );
        }
        if ( productoDTO.getIdProveedor() != null ) {
            producto.setIdProveedor( productoDTO.getIdProveedor() );
        }
        if ( productoDTO.getImpuesto() != null ) {
            producto.setImpuesto( productoDTO.getImpuesto() );
        }
        if ( productoDTO.getLote() != null ) {
            producto.setLote( productoDTO.getLote() );
        }
        if ( productoDTO.getMarca() != null ) {
            producto.setMarca( productoDTO.getMarca() );
        }
        if ( productoDTO.getModelo() != null ) {
            producto.setModelo( productoDTO.getModelo() );
        }
        if ( productoDTO.getNombre() != null ) {
            producto.setNombre( productoDTO.getNombre() );
        }
        if ( productoDTO.getOrigen() != null ) {
            producto.setOrigen( productoDTO.getOrigen() );
        }
        if ( productoDTO.getPrecioUnitario() != null ) {
            producto.setPrecioUnitario( productoDTO.getPrecioUnitario() );
        }
        if ( productoDTO.getUnidadMedida() != null ) {
            producto.setUnidadMedida( productoDTO.getUnidadMedida() );
        }

        return producto;
    }
}
