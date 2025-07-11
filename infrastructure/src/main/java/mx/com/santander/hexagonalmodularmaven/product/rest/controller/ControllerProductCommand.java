package mx.com.santander.hexagonalmodularmaven.product.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.product.command.CreateProductHandler;
import mx.com.santander.hexagonalmodularmaven.product.command.DeleteProductHandler;
import mx.com.santander.hexagonalmodularmaven.product.command.UpdateProductHandler;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@RequestMapping("api/products")
@RestController
public class ControllerProductCommand {
    private final CreateProductHandler createProductHandler;
    private final DeleteProductHandler deleteProductHandler;
    private final UpdateProductHandler updateProductHandler;

    public ControllerProductCommand(CreateProductHandler createProductHandler, 
    DeleteProductHandler deleteProductHandler, UpdateProductHandler updateProductHandler){
        this.createProductHandler = createProductHandler;
        this.deleteProductHandler = deleteProductHandler;
        this.updateProductHandler = updateProductHandler;
    }

    @PostMapping
    public DtoProduct addProduct(@RequestBody CreateProductCommand createProductCommand){
        return createProductHandler.execute(createProductCommand);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        deleteProductHandler.execute(id);
    }

    @PutMapping("{id}")
    public DtoProduct updaDtoProduct(@PathVariable("id") Long id, @RequestBody Product updateProduct){
        return updateProductHandler.execute(id, updateProduct);
    }
}