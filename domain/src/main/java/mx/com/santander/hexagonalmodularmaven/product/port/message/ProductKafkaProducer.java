package mx.com.santander.hexagonalmodularmaven.product.port.message;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

public interface ProductKafkaProducer {
    void mensajeProductoCreado(Product product);
}