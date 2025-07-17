package mx.com.santander.hexagonalmodularmaven.sale.adapter.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.DetailSaleEntity;
import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.SaleEntity;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;

@Component
public class MapperSale {
        public SaleEntity toEntity(Sale sale){

        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setClienteId(sale.getClienteId());
        saleEntity.setPrecioTotal(sale.getPrecioTotal());
        saleEntity.setFechaCompra(sale.getFechaCompra());


        List<DetailSaleEntity> detalles = sale.getDetalles().stream().map(p ->{
            DetailSaleEntity detalleSaleEntity = new DetailSaleEntity();
            detalleSaleEntity.setProductoId(p.getProductoId());
            detalleSaleEntity.setNombre(p.getNombre());
            detalleSaleEntity.setCantidad(p.getCantidad());
            detalleSaleEntity.setPrecioUnitario(p.getPrecioUnitario());
            return detalleSaleEntity;
        }).toList();
        saleEntity.setDetalles(detalles);
        return saleEntity;
    }

    public Sale toDomain(SaleEntity saleEntity){
        Sale sale = new Sale();
        sale.setId(saleEntity.getId());
        sale.setClienteId(saleEntity.getClienteId());
        sale.setPrecioTotal(saleEntity.getPrecioTotal());
        sale.setFechaCompra(saleEntity.getFechaCompra());

        List<DetailSale> detalles = saleEntity.getDetalles().stream().map(p->{
            DetailSale detailSale = new DetailSale();
            detailSale.setProductoId(p.getProductoId());
            detailSale.setNombre(p.getNombre());
            detailSale.setCantidad(p.getCantidad());
            detailSale.setPrecioUnitario(p.getPrecioUnitario());
            return detailSale;
        }).toList();

        sale.setDetalles(detalles);
        return sale;
    }
}