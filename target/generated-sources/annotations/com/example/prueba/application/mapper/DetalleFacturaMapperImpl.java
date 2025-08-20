package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.DetalleFactura;
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
public class DetalleFacturaMapperImpl implements DetalleFacturaMapper {

    @Override
    public DetalleFacturaDTO toDetalleFacturaDTO(DetalleFactura cliente) {
        if ( cliente == null ) {
            return null;
        }

        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();

        detalleFacturaDTO.setCantidad( cliente.getCantidad() );
        detalleFacturaDTO.setId( cliente.getId() );
        detalleFacturaDTO.setPrecioUnitario( cliente.getPrecioUnitario() );
        detalleFacturaDTO.setProducto( productoToProductoDTO( cliente.getProducto() ) );
        detalleFacturaDTO.setSubTotal( cliente.getSubTotal() );

        return detalleFacturaDTO;
    }

    @Override
    public DetalleFactura toDetalleFactura(DetalleFacturaDTO cliente) {
        if ( cliente == null ) {
            return null;
        }

        DetalleFactura detalleFactura = new DetalleFactura();

        detalleFactura.setCantidad( cliente.getCantidad() );
        detalleFactura.setId( cliente.getId() );
        detalleFactura.setPrecioUnitario( cliente.getPrecioUnitario() );
        detalleFactura.setProducto( productoDTOToProducto( cliente.getProducto() ) );
        detalleFactura.setSubTotal( cliente.getSubTotal() );

        return detalleFactura;
    }

    @Override
    public List<DetalleFacturaDTO> toDetalleFacturaDTO(List<DetalleFactura> cliente) {
        if ( cliente == null ) {
            return null;
        }

        List<DetalleFacturaDTO> list = new ArrayList<DetalleFacturaDTO>( cliente.size() );
        for ( DetalleFactura detalleFactura : cliente ) {
            list.add( toDetalleFacturaDTO( detalleFactura ) );
        }

        return list;
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
}
