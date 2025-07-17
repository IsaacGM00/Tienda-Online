package mx.com.santander.hexagonalmodularmaven.product.model.entity;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.UpdateProductCommand;

@NoArgsConstructor
public class Product {
    
    private ProductId id;
    private ProductNombre nombre;
    private ProductPrecio precio;
    private ProductStock stock;

    // Constructor completo
    public Product(Long id, String nombre, Double precio, Integer stock) {
        this.id = new ProductId(id);
        this.nombre = new ProductNombre(nombre);
        this.precio = new ProductPrecio(precio);
        this.stock = new ProductStock(stock);
    }

    public Product requestToCreateProduct(CreateProductCommand createProductCommand){
        this.nombre = new ProductNombre(createProductCommand.getNombre());
        this.precio = new ProductPrecio(createProductCommand.getPrecio());
        this.stock = new ProductStock(createProductCommand.getStock());
        return this;
    }

    public Product requestToUpdateProduct(UpdateProductCommand updateProductCommand){
        this.nombre = new ProductNombre(updateProductCommand.getNombre());
        this.precio = new ProductPrecio(updateProductCommand.getPrecio());
        this.stock = new ProductStock(updateProductCommand.getStock());
        return this;
    }

    // Getters 
    public Long getId() {
        return id.getId();
    }
    public String getNombre() {
        return nombre.getNombre();
    }
    public Double getPrecio() {
        return precio.getPrecio();
    }
    public Integer getStock() {
        return stock.getStock();
    }

}