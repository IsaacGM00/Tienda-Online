package mx.com.santander.hexagonalmodularmaven.product.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.product.adapter.entity.ProductEntity;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@Component
public class MapperProduct {
    public Product toDomain(ProductEntity productEntity){
        if(productEntity == null){
            return null;
        }
        return new Product(
            productEntity.getId(),
            productEntity.getNombre(),
            productEntity.getPrecio(),
            productEntity.getStock()
        );
    }

    public ProductEntity toEntity(Product product){
        if(product == null){
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setNombre(product.getNombre());
        productEntity.setPrecio(product.getPrecio());
        productEntity.setStock(product.getStock());
        return productEntity;
    }
}