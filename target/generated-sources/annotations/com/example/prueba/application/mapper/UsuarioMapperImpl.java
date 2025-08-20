package com.example.prueba.application.mapper;

import com.example.prueba.application.dto.DetalleFacturaDTO;
import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.dto.UsuarioDTO;
import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.entity.Usuario;
import com.example.prueba.shared.enums.TipoIdentificacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T09:17:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario cliente) {
        if ( cliente == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setApellidos( cliente.getApellidos() );
        usuarioDTO.setCorreo( cliente.getCorreo() );
        usuarioDTO.setDireccion( cliente.getDireccion() );
        usuarioDTO.setFacturas( facturaListToFacturaDTOList( cliente.getFacturas() ) );
        usuarioDTO.setFechaActualizacion( cliente.getFechaActualizacion() );
        usuarioDTO.setFechaRegistro( cliente.getFechaRegistro() );
        usuarioDTO.setId( cliente.getId() );
        usuarioDTO.setIdentificacion( cliente.getIdentificacion() );
        usuarioDTO.setNombres( cliente.getNombres() );
        usuarioDTO.setTelefono( cliente.getTelefono() );
        if ( cliente.getTipoIdentificacion() != null ) {
            usuarioDTO.setTipoIdentificacion( Enum.valueOf( TipoIdentificacion.class, cliente.getTipoIdentificacion() ) );
        }

        return usuarioDTO;
    }

    @Override
    public Usuario toUsuario(UsuarioDTO cliente) {
        if ( cliente == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setApellidos( cliente.getApellidos() );
        usuario.setCorreo( cliente.getCorreo() );
        usuario.setDireccion( cliente.getDireccion() );
        usuario.setFacturas( facturaDTOListToFacturaList( cliente.getFacturas() ) );
        usuario.setFechaActualizacion( cliente.getFechaActualizacion() );
        usuario.setFechaRegistro( cliente.getFechaRegistro() );
        usuario.setId( cliente.getId() );
        usuario.setIdentificacion( cliente.getIdentificacion() );
        usuario.setNombres( cliente.getNombres() );
        usuario.setTelefono( cliente.getTelefono() );
        if ( cliente.getTipoIdentificacion() != null ) {
            usuario.setTipoIdentificacion( cliente.getTipoIdentificacion().name() );
        }

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toListUsuarioDTO(List<Usuario> cliente) {
        if ( cliente == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( cliente.size() );
        for ( Usuario usuario : cliente ) {
            list.add( toUsuarioDTO( usuario ) );
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

    protected FacturaDTO facturaToFacturaDTO(Factura factura) {
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

    protected List<FacturaDTO> facturaListToFacturaDTOList(List<Factura> list) {
        if ( list == null ) {
            return null;
        }

        List<FacturaDTO> list1 = new ArrayList<FacturaDTO>( list.size() );
        for ( Factura factura : list ) {
            list1.add( facturaToFacturaDTO( factura ) );
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

    protected Factura facturaDTOToFactura(FacturaDTO facturaDTO) {
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

        return factura;
    }

    protected List<Factura> facturaDTOListToFacturaList(List<FacturaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Factura> list1 = new ArrayList<Factura>( list.size() );
        for ( FacturaDTO facturaDTO : list ) {
            list1.add( facturaDTOToFactura( facturaDTO ) );
        }

        return list1;
    }
}
