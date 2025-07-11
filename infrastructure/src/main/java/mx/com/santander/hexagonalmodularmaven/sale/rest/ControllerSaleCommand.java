package mx.com.santander.hexagonalmodularmaven.sale.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.command.CreateSaleHandler;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.DtoSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;

@Controller
@RequestMapping("api/sale")
@RequiredArgsConstructor

public class ControllerSaleCommand {
    private final CreateSaleHandler createSaleHandler;

    @PostMapping
    public ResponseEntity<DtoSale> createSale(@RequestBody CreateSaleCommand createSaleCommand){
        DtoSale dtoSale = createSaleHandler.execute(createSaleCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSale);
    }
}