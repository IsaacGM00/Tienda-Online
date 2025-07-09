package mx.com.santander.hexagonalmodularmaven.entry.mapper;

import mx.com.santander.hexagonalmodularmaven.entry.entity.EntryEntity;
import mx.com.santander.hexagonalmodularmaven.entry.model.Entry;
import org.springframework.stereotype.Component;
@Component
public class EntryDbMapper {

    public EntryEntity toDbo(Entry domain){
        if(domain == null){
            return null;
        }
        return new EntryEntity(domain.getId(), domain.getName(), domain.getAge(), domain.getCountry());
    }
    public EntryEntity toDboCreate(Entry domain){
        if(domain == null){
            return null;
        }
        return new EntryEntity(domain.getId(),domain.getName(), domain.getAge(), domain.getCountry());
    }



    public Entry toDomain(EntryEntity entity){
        if(entity == null){
            return null;
        }
        return new Entry(entity.getId(), entity.getName(), entity.getAge(), entity.getCountry());
    }

}
