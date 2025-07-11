package mx.com.santander.hexagonalmodularmaven.sale.port.dao;

public interface DaoProductValidation {
    boolean existingProduct(Long productoId);
}