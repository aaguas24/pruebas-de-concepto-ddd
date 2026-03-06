package com.example.prueba.infrastructure.mapper;

import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.entity.Factura;
import com.example.prueba.infrastructure.repository.entity.DetalleFacturaEntity;
import com.example.prueba.infrastructure.repository.entity.FacturaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T15:46:05-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class FacturaEntityMapperImpl implements FacturaEntityMapper {

    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;
    @Autowired
    private DetalleFacturaEntityMapper detalleFacturaEntityMapper;

    @Override
    public FacturaEntity toEntity(Factura domain) {
        if ( domain == null ) {
            return null;
        }

        FacturaEntity facturaEntity = new FacturaEntity();

        facturaEntity.setDetalleFacturas( detalleFacturaListToDetalleFacturaEntityList( domain.getDetalleFacturas() ) );
        facturaEntity.setEstado( domain.getEstado() );
        facturaEntity.setFechaEmision( domain.getFechaEmision() );
        facturaEntity.setId( domain.getId() );
        facturaEntity.setImpuestos( domain.getImpuestos() );
        facturaEntity.setSubTotal( domain.getSubTotal() );
        facturaEntity.setTotal( domain.getTotal() );
        facturaEntity.setTotalPagado( domain.getTotalPagado() );
        facturaEntity.setUsuario( usuarioEntityMapper.toEntity( domain.getUsuario() ) );

        linkEntityDetails( facturaEntity, domain );

        return facturaEntity;
    }

    @Override
    public Factura toDomain(FacturaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Factura factura = new Factura();

        factura.setDetalleFacturas( detalleFacturaEntityListToDetalleFacturaList( entity.getDetalleFacturas() ) );
        factura.setEstado( entity.getEstado() );
        factura.setFechaEmision( entity.getFechaEmision() );
        factura.setId( entity.getId() );
        factura.setImpuestos( entity.getImpuestos() );
        factura.setSubTotal( entity.getSubTotal() );
        factura.setTotal( entity.getTotal() );
        factura.setTotalPagado( entity.getTotalPagado() );
        factura.setUsuario( usuarioEntityMapper.toDomain( entity.getUsuario() ) );

        linkDomainDetails( factura, entity );

        return factura;
    }

    protected List<DetalleFacturaEntity> detalleFacturaListToDetalleFacturaEntityList(List<DetalleFactura> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFacturaEntity> list1 = new ArrayList<DetalleFacturaEntity>( list.size() );
        for ( DetalleFactura detalleFactura : list ) {
            list1.add( detalleFacturaEntityMapper.toEntity( detalleFactura ) );
        }

        return list1;
    }

    protected List<DetalleFactura> detalleFacturaEntityListToDetalleFacturaList(List<DetalleFacturaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleFactura> list1 = new ArrayList<DetalleFactura>( list.size() );
        for ( DetalleFacturaEntity detalleFacturaEntity : list ) {
            list1.add( detalleFacturaEntityMapper.toDomain( detalleFacturaEntity ) );
        }

        return list1;
    }
}
