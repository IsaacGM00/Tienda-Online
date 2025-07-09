package mx.com.santander.hexagonalmodularmaven.entry.port.dao;

import mx.com.santander.hexagonalmodularmaven.entry.model.Entry;

public interface EntryDao {
    Entry retrieve(Long id);
}
