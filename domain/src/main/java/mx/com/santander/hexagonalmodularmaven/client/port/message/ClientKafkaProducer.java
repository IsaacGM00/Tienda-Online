package mx.com.santander.hexagonalmodularmaven.client.port.message;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

public interface ClientKafkaProducer {
    void mensajeClienteCreado(Client client);
}