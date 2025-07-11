package mx.com.santander.hexagonalmodularmaven.sale.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.SaleEntity;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;

@Component
public class MapperSale {
        public Sale toDomain(SaleEntity saleEntity){
        if(saleEntity == null){
            return null;
        }
        return new Sale(
            saleEntity.getId(),
            saleEntity.getClienteId(),
            saleEntity.getDetalles(),
            saleEntity.getPrecioTotal(),
            saleEntity.getFechaCompra()
        );
    }

    public SaleEntity toEntity(Sale sale){
        if(sale == null){
            return null;
        }
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setClienteId(sale.getClienteId());
        saleEntity.setDetalles(sale.getDetalles());
        saleEntity.setPrecioTotal(sale.getPrecioTotal());
        saleEntity.setFechaCompra(sale.getFechaCompra());
        return saleEntity;
    }
}