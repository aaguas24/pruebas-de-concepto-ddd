package com.example.prueba.infrastructure.mapper;

import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.infrastructure.repository.entity.DetalleFacturaEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T15:46:05-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class DetalleFacturaEntityMapperImpl implements DetalleFacturaEntityMapper {

    @Autowired
    private ProductoEntityMapper productoEntityMapper;

    @Override
    public DetalleFacturaEntity toEntity(DetalleFactura domain) {
        if ( domain == null ) {
            return null;
        }

        DetalleFacturaEntity detalleFacturaEntity = new DetalleFacturaEntity();

        detalleFacturaEntity.setId( domain.getId() );
        detalleFacturaEntity.setProducto( productoEntityMapper.toEntity( domain.getProducto() ) );
        detalleFacturaEntity.setCantidad( domain.getCantidad() );
        detalleFacturaEntity.setPrecioUnitario( domain.getPrecioUnitario() );
        detalleFacturaEntity.setSubTotal( domain.getSubTotal() );

        return detalleFacturaEntity;
    }

    @Override
    public DetalleFactura toDomain(DetalleFacturaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DetalleFactura detalleFactura = new DetalleFactura();

        detalleFactura.setId( entity.getId() );
        detalleFactura.setProducto( productoEntityMapper.toDomain( entity.getProducto() ) );
        detalleFactura.setCantidad( entity.getCantidad() );
        detalleFactura.setPrecioUnitario( entity.getPrecioUnitario() );
        detalleFactura.setSubTotal( entity.getSubTotal() );

        return detalleFactura;
    }
}
