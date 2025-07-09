package mx.com.santander.hexagonalmodularmaven.entry.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.entry.model.Entry;
import mx.com.santander.hexagonalmodularmaven.entry.port.dao.EntryDao;
import mx.com.santander.hexagonalmodularmaven.entry.port.repository.EntryRepository;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
@RequiredArgsConstructor
public class EntryService {
    private final EntryRepository entryRepository;
    public Entry createEntry(User user){
        Entry entryToMongo = new Entry();
        entryToMongo.setAge(user.getAge());
        entryToMongo.setCountry(user.getCountry());
        entryToMongo.setName(user.getName());
        Entry entryFromMongo = entryRepository.create(entryToMongo);
        return entryFromMongo;
    }
}
