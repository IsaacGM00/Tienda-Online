package mx.com.santander.hexagonalmodularmaven.product.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.query.ProductByIdHandler;
import mx.com.santander.hexagonalmodularmaven.product.query.ProductHandler;

@RequestMapping("api/products")
@RestController
public class ControllerProductQuery {
    private final ProductHandler productHandler;
    private final ProductByIdHandler productByIdHandler;

    public ControllerProductQuery(ProductHandler productHandler, ProductByIdHandler productByIdHandler){
        this.productHandler = productHandler;
        this.productByIdHandler = productByIdHandler;
    }

    @GetMapping("{id}")
    public DtoProduct getByIdProduct(@PathVariable("id") Long id){
        return productByIdHandler.execute(id);
    }

    @GetMapping
    public List<DtoProduct> getAllProducts(){
        return productHandler.execute();
    }
}