package mx.com.santander.hexagonalmodularmaven.sale.port.dao;

public interface DaoClientValidation {
    boolean existingClient(Long clienteId);
}