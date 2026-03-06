package com.example.prueba.infrastructure.mapper;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.infrastructure.repository.entity.ProductoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T15:46:05-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductoEntityMapperImpl implements ProductoEntityMapper {

    @Override
    public ProductoEntity toEntity(Producto domain) {
        if ( domain == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setCategoria( domain.getCategoria() );
        productoEntity.setCodigoProducto( domain.getCodigoProducto() );
        productoEntity.setDescipcion( domain.getDescipcion() );
        productoEntity.setDescuento( domain.getDescuento() );
        productoEntity.setEsExento( domain.getEsExento() );
        productoEntity.setFechaIngreso( domain.getFechaIngreso() );
        productoEntity.setFechaVencimiento( domain.getFechaVencimiento() );
        productoEntity.setId( domain.getId() );
        productoEntity.setIdProveedor( domain.getIdProveedor() );
        productoEntity.setImpuesto( domain.getImpuesto() );
        productoEntity.setLote( domain.getLote() );
        productoEntity.setMarca( domain.getMarca() );
        productoEntity.setModelo( domain.getModelo() );
        productoEntity.setNombre( domain.getNombre() );
        productoEntity.setOrigen( domain.getOrigen() );
        productoEntity.setPrecioUnitario( domain.getPrecioUnitario() );
        productoEntity.setUnidadMedida( domain.getUnidadMedida() );

        return productoEntity;
    }

    @Override
    public Producto toDomain(ProductoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( entity.getCategoria() );
        producto.setCodigoProducto( entity.getCodigoProducto() );
        producto.setDescipcion( entity.getDescipcion() );
        producto.setDescuento( entity.getDescuento() );
        producto.setEsExento( entity.getEsExento() );
        producto.setFechaIngreso( entity.getFechaIngreso() );
        producto.setFechaVencimiento( entity.getFechaVencimiento() );
        producto.setId( entity.getId() );
        producto.setIdProveedor( entity.getIdProveedor() );
        producto.setImpuesto( entity.getImpuesto() );
        producto.setLote( entity.getLote() );
        producto.setMarca( entity.getMarca() );
        producto.setModelo( entity.getModelo() );
        producto.setNombre( entity.getNombre() );
        producto.setOrigen( entity.getOrigen() );
        producto.setPrecioUnitario( entity.getPrecioUnitario() );
        producto.setUnidadMedida( entity.getUnidadMedida() );

        return producto;
    }
}
