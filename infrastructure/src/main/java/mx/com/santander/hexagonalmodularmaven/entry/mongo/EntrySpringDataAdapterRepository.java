package mx.com.santander.hexagonalmodularmaven.entry.mongo;

import mx.com.santander.hexagonalmodularmaven.entry.entity.EntryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EntrySpringDataAdapterRepository extends MongoRepository<EntryEntity,String> {
}
