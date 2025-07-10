package mx.com.santander.hexagonalmodularmaven.product.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.service.DeleteProductService;

@Component
@RequiredArgsConstructor
public class DeleteProductHandler {
    private final DeleteProductService deleteProductService;

    public void execute(Long id){
        deleteProductService.execute(id);
    }

}