package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.SaleEntity;
import mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.SpringSaleRepository;
import mx.com.santander.hexagonalmodularmaven.sale.adapter.mapper.MapperSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.model.exception.SaleNotFound;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;

@Repository
public class SaleRepositoryJpa implements SaleRepository {

    private final SpringSaleRepository springSaleRepository;
    private final MapperSale mapperSale;

    public SaleRepositoryJpa(SpringSaleRepository springSaleRepository, MapperSale mapperSale) {
        this.springSaleRepository = springSaleRepository;
        this.mapperSale = mapperSale;
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return springSaleRepository.findById(id)
                .map(mapperSale::toDomain);
    }

    @Override
    public Sale save(Sale sale) {
        SaleEntity saleEntitySaved = springSaleRepository.save(mapperSale.toEntity(sale));
        return mapperSale.toDomain(saleEntitySaved);
    }

    @Override
    public void deleteById(Long id) {
        springSaleRepository.deleteById(id);
    }

    @Override
    public List<Sale> findAll() {
        return springSaleRepository.findAll()
                .stream()
                .map(mapperSale::toDomain)
                .toList();
    }

    @Override
    public Sale update(Long id, Sale sale) {
        Optional<SaleEntity> existingEntityOpt = springSaleRepository.findById(id);
        if (existingEntityOpt.isPresent()) {
            SaleEntity existingEntity = existingEntityOpt.get();

            existingEntity.setClienteId(sale.getClienteId());
            existingEntity.setPrecioTotal(sale.getPrecioTotal());
            existingEntity.setFechaCompra(sale.getFechaCompra());
            existingEntity.setDetalles(mapperSale.toEntityList(sale.getDetalles())); // ← conversión necesaria

            SaleEntity updatedEntity = springSaleRepository.save(existingEntity);
            return mapperSale.toDomain(updatedEntity);
        } else {
            throw new SaleNotFound("Venta con id " + id + " no encontrada");
        }
    }
}