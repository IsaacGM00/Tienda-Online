package mx.com.santander.hexagonalmodularmaven.sale.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.port.dao.DaoClientValidation;

@Component
@RequiredArgsConstructor

public class ValidationClientHandler {
    private final DaoClientValidation daoClientValidation;

    public boolean execute(Long id){
        return daoClientValidation.existingClient(id);
    }

}