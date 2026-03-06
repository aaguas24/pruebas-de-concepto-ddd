package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T14:10:36-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class FacturaMapperImpl implements FacturaMapper {

    @Override
    public Factura toEntity(FacturaDTO facturaDTO) {
        if ( facturaDTO == null ) {
            return null;
        }

        Factura factura = new Factura();

        factura.setDetalleFacturas( detalleFacturaDTOListToDetalleFacturaList( facturaDTO.getDetalleFacturas() ) );
        factura.setEstado( facturaDTO.getEstado() );
        factura.setFechaEmision( facturaDTO.getFechaEmision() );
        factura.setId( facturaDTO.getId() );
        factura.setImpuestos( facturaDTO.getImpuestos() );
        factura.setSubTotal( facturaDTO.getSubTotal() );
        factura.setTotal( facturaDTO.getTotal() );
        factura.setTotalPagado( facturaDTO.getTotalPagado() );

        linkDetalleFacturas( factura );

        return factura;
    }

    @Override
    public FacturaDTO toDto(Factura factura) {
        if ( factura == null ) {
            return null;
        }

        FacturaDTO facturaDTO = new FacturaDTO();

        facturaDTO.setDetalleFacturas( detalleFacturaListToDetalleFacturaDTOList( factura.getDetalleFacturas() ) );
        facturaDTO.setEstado( factura.getEstado() );
        facturaDTO.setFechaEmision( factura.getFechaEmision() );
        facturaDTO.setId( factura.getId() );
        facturaDTO.setImpuestos( factura.getImpuestos() );
        facturaDTO.setSubTotal( factura.getSubTotal() );
        facturaDTO.setTotal( factura.getTotal() );
        facturaDTO.setTotalPagado( factura.getTotalPagado() );

        return facturaDTO;
    }

    @Override
    public Factura partialUpdate(FacturaDTO facturaDTO, Factura factura) {
        if ( facturaDTO == null ) {
            return factura;
        }

        if ( factura.getDetalleFacturas() != null ) {
            List<DetalleFactura> list = detalleFacturaDTOListToDetalleFacturaList( facturaDTO.getDetalleFacturas() );
            if ( list != null ) {
                factura.getDetalleFacturas().clear();
                factura.getDetalleFacturas().addAll( list );
            }
        }
        else {
            List<DetalleFactura> list = detalleFacturaDTOListToDetalleFacturaList( facturaDTO.getDetalleFacturas() );
            if ( list != null ) {
                factura.setDetalleFacturas( list );
            }
        }
        if ( facturaDTO.getEstado() != null ) {
            factura.setEstado( facturaDTO.getEstado() );
        }
        if ( facturaDTO.getFechaEmision() != null ) {
            factura.setFechaEmision( facturaDTO.getFechaEmision() );
        }
        if ( facturaDTO.getId() != null ) {
            factura.setId( facturaDTO.getId() );
        }
        if ( facturaDTO.getImpuestos() != null ) {
            factura.setImpuestos( facturaDTO.getImpuestos() );
        }
        if ( facturaDTO.getSubTotal() != null ) {
            factura.setSubTotal( facturaDTO.getSubTotal() );
        }
        if ( facturaDTO.getTotal() != null ) {
            factura.setTotal( facturaDTO.getTotal() );
        }
        if ( facturaDTO.getTotalPagado() != null ) {
            factura.setTotalPagado( facturaDTO.getTotalPagado() );
        }

        linkDetalleFacturas( factura );

        return factura;
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

    protected DetalleFactura detalleFacturaDTOToDetalleFactura(DetalleFacturaDTO detalleFacturaDTO) {
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

    protected List<DetalleFactura> detalleFacturaDTOListToDetalleFacturaList(List<DetalleFacturaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFactura> list1 = new ArrayList<DetalleFactura>( list.size() );
        for ( DetalleFacturaDTO detalleFacturaDTO : list ) {
            list1.add( detalleFacturaDTOToDetalleFactura( detalleFacturaDTO ) );
        }

        return list1;
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

    protected DetalleFacturaDTO detalleFacturaToDetalleFacturaDTO(DetalleFactura detalleFactura) {
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

    protected List<DetalleFacturaDTO> detalleFacturaListToDetalleFacturaDTOList(List<DetalleFactura> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFacturaDTO> list1 = new ArrayList<DetalleFacturaDTO>( list.size() );
        for ( DetalleFactura detalleFactura : list ) {
            list1.add( detalleFacturaToDetalleFacturaDTO( detalleFactura ) );
        }

        return list1;
    }
}
