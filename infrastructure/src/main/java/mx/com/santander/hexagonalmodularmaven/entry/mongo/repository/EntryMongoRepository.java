package mx.com.santander.hexagonalmodularmaven.entry.mongo.repository;

import lombok.AllArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.entry.mapper.EntryDbMapper;
import mx.com.santander.hexagonalmodularmaven.entry.mongo.EntrySpringDataAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.entry.model.Entry;
import mx.com.santander.hexagonalmodularmaven.entry.port.repository.EntryRepository;
import org.springframework.stereotype.Repository;
@AllArgsConstructor
@Repository
public class EntryMongoRepository implements EntryRepository {

    private final EntrySpringDataAdapterRepository entrySpringDataAdapterRepository;
    private final EntryDbMapper mapper;

    @Override
    public Entry create(Entry entry) {
        return mapper.toDomain(entrySpringDataAdapterRepository.save(mapper.toDboCreate(entry)));
    }
}
