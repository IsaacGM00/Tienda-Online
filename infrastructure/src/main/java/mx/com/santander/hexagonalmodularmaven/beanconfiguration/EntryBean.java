package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import mx.com.santander.hexagonalmodularmaven.entry.port.repository.EntryRepository;
import mx.com.santander.hexagonalmodularmaven.entry.service.EntryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntryBean {
    @Bean
    public EntryService createEntry(EntryRepository repository){
        return new EntryService(repository);
    }
}
