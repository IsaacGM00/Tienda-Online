package mx.com.santander.hexagonalmodularmaven.entry.port.repository;

import mx.com.santander.hexagonalmodularmaven.entry.model.Entry;

public interface EntryRepository {
    Entry create(Entry entry);
}
