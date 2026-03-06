package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Producto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T14:10:36-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class DetalleFacturaMapperImpl implements DetalleFacturaMapper {

    @Override
    public DetalleFactura toEntity(DetalleFacturaDTO detalleFacturaDTO) {
        if ( detalleFacturaDTO == null ) {
            return null;
        }

        DetalleFactura detalleFactura = new DetalleFactura();

        detalleFactura.setId( detalleFacturaDTO.getId() );
        detalleFactura.setProducto( productoDTOToProducto( detalleFacturaDTO.getProducto() ) );
        detalleFactura.setCantidad( detalleFacturaDTO.getCantidad() );
        detalleFactura.setPrecioUnitario( detalleFacturaDTO.getPrecioUnitario() );
        detalleFactura.setSubTotal( detalleFacturaDTO.getSubTotal() );

        return detalleFactura;
    }

    @Override
    public DetalleFacturaDTO toDto(DetalleFactura detalleFactura) {
        if ( detalleFactura == null ) {
            return null;
        }

        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();

        detalleFacturaDTO.setCantidad( detalleFactura.getCantidad() );
        detalleFacturaDTO.setId( detalleFactura.getId() );
        detalleFacturaDTO.setPrecioUnitario( detalleFactura.getPrecioUnitario() );
        detalleFacturaDTO.setProducto( productoToProductoDTO( detalleFactura.getProducto() ) );
        detalleFacturaDTO.setSubTotal( detalleFactura.getSubTotal() );

        return detalleFacturaDTO;
    }

    @Override
    public DetalleFactura partialUpdate(DetalleFacturaDTO detalleFacturaDTO, DetalleFactura detalleFactura) {
        if ( detalleFacturaDTO == null ) {
            return detalleFactura;
        }

        if ( detalleFacturaDTO.getId() != null ) {
            detalleFactura.setId( detalleFacturaDTO.getId() );
        }
        if ( detalleFacturaDTO.getProducto() != null ) {
            if ( detalleFactura.getProducto() == null ) {
                detalleFactura.setProducto( new Producto() );
            }
            productoDTOToProducto1( detalleFacturaDTO.getProducto(), detalleFactura.getProducto() );
        }
        if ( detalleFacturaDTO.getCantidad() != null ) {
            detalleFactura.setCantidad( detalleFacturaDTO.getCantidad() );
        }
        if ( detalleFacturaDTO.getPrecioUnitario() != null ) {
            detalleFactura.setPrecioUnitario( detalleFacturaDTO.getPrecioUnitario() );
        }
        if ( detalleFacturaDTO.getSubTotal() != null ) {
            detalleFactura.setSubTotal( detalleFacturaDTO.getSubTotal() );
        }

        return detalleFactura;
    }

    protected Producto productoDTOToProducto(ProductoDTO productoDTO) {
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

    protected ProductoDTO productoToProductoDTO(Producto producto) {
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

    protected void productoDTOToProducto1(ProductoDTO productoDTO, Producto mappingTarget) {
        if ( productoDTO == null ) {
            return;
        }

        if ( productoDTO.getCategoria() != null ) {
            mappingTarget.setCategoria( productoDTO.getCategoria() );
        }
        if ( productoDTO.getCodigoProducto() != null ) {
            mappingTarget.setCodigoProducto( productoDTO.getCodigoProducto() );
        }
        if ( productoDTO.getDescipcion() != null ) {
            mappingTarget.setDescipcion( productoDTO.getDescipcion() );
        }
        if ( productoDTO.getDescuento() != null ) {
            mappingTarget.setDescuento( productoDTO.getDescuento() );
        }
        if ( productoDTO.getEsExento() != null ) {
            mappingTarget.setEsExento( productoDTO.getEsExento() );
        }
        if ( productoDTO.getFechaIngreso() != null ) {
            mappingTarget.setFechaIngreso( productoDTO.getFechaIngreso() );
        }
        if ( productoDTO.getFechaVencimiento() != null ) {
            mappingTarget.setFechaVencimiento( productoDTO.getFechaVencimiento() );
        }
        if ( productoDTO.getId() != null ) {
            mappingTarget.setId( productoDTO.getId() );
        }
        if ( productoDTO.getIdProveedor() != null ) {
            mappingTarget.setIdProveedor( productoDTO.getIdProveedor() );
        }
        if ( productoDTO.getImpuesto() != null ) {
            mappingTarget.setImpuesto( productoDTO.getImpuesto() );
        }
        if ( productoDTO.getLote() != null ) {
            mappingTarget.setLote( productoDTO.getLote() );
        }
        if ( productoDTO.getMarca() != null ) {
            mappingTarget.setMarca( productoDTO.getMarca() );
        }
        if ( productoDTO.getModelo() != null ) {
            mappingTarget.setModelo( productoDTO.getModelo() );
        }
        if ( productoDTO.getNombre() != null ) {
            mappingTarget.setNombre( productoDTO.getNombre() );
        }
        if ( productoDTO.getOrigen() != null ) {
            mappingTarget.setOrigen( productoDTO.getOrigen() );
        }
        if ( productoDTO.getPrecioUnitario() != null ) {
            mappingTarget.setPrecioUnitario( productoDTO.getPrecioUnitario() );
        }
        if ( productoDTO.getUnidadMedida() != null ) {
            mappingTarget.setUnidadMedida( productoDTO.getUnidadMedida() );
        }
    }
}
