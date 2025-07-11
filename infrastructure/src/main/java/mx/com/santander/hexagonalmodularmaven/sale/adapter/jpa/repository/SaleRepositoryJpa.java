package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.SaleEntity;
import mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.JpaSaleRepository;
import mx.com.santander.hexagonalmodularmaven.sale.adapter.mapper.MapperSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;

@Repository
public class SaleRepositoryJpa implements SaleRepository{
    private final JpaSaleRepository jpaSaleRepository;
    private final MapperSale mapperSale;

    public SaleRepositoryJpa(JpaSaleRepository jpaSaleRepository, MapperSale mapperSale){
        this.jpaSaleRepository = jpaSaleRepository;
        this.mapperSale = mapperSale;
    }

    @Override
    public Optional<Sale> findById(Long id){
        return jpaSaleRepository.findById(id)
        .map(mapperSale::toDomain);
    }

    @Override
    public Sale save(Sale sale) {
        SaleEntity entity = mapperSale.toEntity(sale);
        SaleEntity saved = jpaSaleRepository.save(entity);
        return mapperSale.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaSaleRepository.deleteById(id);
    }

    @Override
    public List<Sale> findAll() {
        return jpaSaleRepository.findAll()
            .stream()
            .map(mapperSale::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Sale update(Long id, Sale sale) {
        Optional<SaleEntity> existingEntityOpt = jpaSaleRepository.findById(id);
        if (existingEntityOpt.isPresent()) {
            SaleEntity existingEntity = existingEntityOpt.get();

            existingEntity.setClienteId(sale.getClienteId());
            existingEntity.setDetalles(sale.getDetalles());
            existingEntity.setPrecioTotal(sale.getPrecioTotal());
            existingEntity.setFechaCompra(sale.getFechaCompra());

            SaleEntity updatedEntity = jpaSaleRepository.save(existingEntity);
            return mapperSale.toDomain(updatedEntity);
        } else {
            throw new RuntimeException("Venta con id " + id + "no encontrada");
        }
    }
}