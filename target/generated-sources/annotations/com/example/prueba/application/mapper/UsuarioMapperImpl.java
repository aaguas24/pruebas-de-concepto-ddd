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
    date = "2026-03-06T14:10:35-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setApellidos( usuarioDTO.getApellidos() );
        usuario.setCorreo( usuarioDTO.getCorreo() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setFacturas( facturaDTOListToFacturaList( usuarioDTO.getFacturas() ) );
        usuario.setFechaActualizacion( usuarioDTO.getFechaActualizacion() );
        usuario.setFechaRegistro( usuarioDTO.getFechaRegistro() );
        usuario.setId( usuarioDTO.getId() );
        usuario.setIdentificacion( usuarioDTO.getIdentificacion() );
        usuario.setNombres( usuarioDTO.getNombres() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        if ( usuarioDTO.getTipoIdentificacion() != null ) {
            usuario.setTipoIdentificacion( usuarioDTO.getTipoIdentificacion().name() );
        }

        linkFacturas( usuario );

        return usuario;
    }

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setApellidos( usuario.getApellidos() );
        usuarioDTO.setCorreo( usuario.getCorreo() );
        usuarioDTO.setDireccion( usuario.getDireccion() );
        usuarioDTO.setFacturas( facturaListToFacturaDTOList( usuario.getFacturas() ) );
        usuarioDTO.setFechaActualizacion( usuario.getFechaActualizacion() );
        usuarioDTO.setFechaRegistro( usuario.getFechaRegistro() );
        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setIdentificacion( usuario.getIdentificacion() );
        usuarioDTO.setNombres( usuario.getNombres() );
        usuarioDTO.setTelefono( usuario.getTelefono() );
        if ( usuario.getTipoIdentificacion() != null ) {
            usuarioDTO.setTipoIdentificacion( Enum.valueOf( TipoIdentificacion.class, usuario.getTipoIdentificacion() ) );
        }

        return usuarioDTO;
    }

    @Override
    public Usuario partialUpdate(UsuarioDTO usuarioDTO, Usuario usuario) {
        if ( usuarioDTO == null ) {
            return usuario;
        }

        if ( usuarioDTO.getApellidos() != null ) {
            usuario.setApellidos( usuarioDTO.getApellidos() );
        }
        if ( usuarioDTO.getCorreo() != null ) {
            usuario.setCorreo( usuarioDTO.getCorreo() );
        }
        if ( usuarioDTO.getDireccion() != null ) {
            usuario.setDireccion( usuarioDTO.getDireccion() );
        }
        if ( usuario.getFacturas() != null ) {
            List<Factura> list = facturaDTOListToFacturaList( usuarioDTO.getFacturas() );
            if ( list != null ) {
                usuario.getFacturas().clear();
                usuario.getFacturas().addAll( list );
            }
        }
        else {
            List<Factura> list = facturaDTOListToFacturaList( usuarioDTO.getFacturas() );
            if ( list != null ) {
                usuario.setFacturas( list );
            }
        }
        if ( usuarioDTO.getFechaActualizacion() != null ) {
            usuario.setFechaActualizacion( usuarioDTO.getFechaActualizacion() );
        }
        if ( usuarioDTO.getFechaRegistro() != null ) {
            usuario.setFechaRegistro( usuarioDTO.getFechaRegistro() );
        }
        if ( usuarioDTO.getId() != null ) {
            usuario.setId( usuarioDTO.getId() );
        }
        if ( usuarioDTO.getIdentificacion() != null ) {
            usuario.setIdentificacion( usuarioDTO.getIdentificacion() );
        }
        if ( usuarioDTO.getNombres() != null ) {
            usuario.setNombres( usuarioDTO.getNombres() );
        }
        if ( usuarioDTO.getTelefono() != null ) {
            usuario.setTelefono( usuarioDTO.getTelefono() );
        }
        if ( usuarioDTO.getTipoIdentificacion() != null ) {
            usuario.setTipoIdentificacion( usuarioDTO.getTipoIdentificacion().name() );
        }

        linkFacturas( usuario );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toDto( usuario ) );
        }

        return list;
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
}
