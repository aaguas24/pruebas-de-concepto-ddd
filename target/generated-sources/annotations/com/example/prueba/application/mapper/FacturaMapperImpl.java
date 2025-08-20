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
    date = "2025-08-20T09:17:14-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class FacturaMapperImpl implements FacturaMapper {

    @Override
    public FacturaDTO toFacturaDTO(Factura cliente) {
        if ( cliente == null ) {
            return null;
        }

        FacturaDTO facturaDTO = new FacturaDTO();

        facturaDTO.setDetalleFacturas( detalleFacturaListToDetalleFacturaDTOList( cliente.getDetalleFacturas() ) );
        facturaDTO.setEstado( cliente.getEstado() );
        facturaDTO.setFechaEmision( cliente.getFechaEmision() );
        facturaDTO.setId( cliente.getId() );
        facturaDTO.setImpuestos( cliente.getImpuestos() );
        facturaDTO.setSubTotal( cliente.getSubTotal() );
        facturaDTO.setTotal( cliente.getTotal() );
        facturaDTO.setTotalPagado( cliente.getTotalPagado() );

        return facturaDTO;
    }

    @Override
    public Factura toFactura(FacturaDTO cliente) {
        if ( cliente == null ) {
            return null;
        }

        Factura factura = new Factura();

        factura.setDetalleFacturas( detalleFacturaDTOListToDetalleFacturaList( cliente.getDetalleFacturas() ) );
        factura.setEstado( cliente.getEstado() );
        factura.setFechaEmision( cliente.getFechaEmision() );
        factura.setId( cliente.getId() );
        factura.setImpuestos( cliente.getImpuestos() );
        factura.setSubTotal( cliente.getSubTotal() );
        factura.setTotal( cliente.getTotal() );
        factura.setTotalPagado( cliente.getTotalPagado() );

        return factura;
    }

    @Override
    public List<FacturaDTO> toFacturaDTO(List<Factura> cliente) {
        if ( cliente == null ) {
            return null;
        }

        List<FacturaDTO> list = new ArrayList<FacturaDTO>( cliente.size() );
        for ( Factura factura : cliente ) {
            list.add( toFacturaDTO( factura ) );
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

        detalleFactura.setCantidad( detalleFacturaDTO.getCantidad() );
        detalleFactura.setId( detalleFacturaDTO.getId() );
        detalleFactura.setPrecioUnitario( detalleFacturaDTO.getPrecioUnitario() );
        detalleFactura.setProducto( productoDTOToProducto( detalleFacturaDTO.getProducto() ) );
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
}
