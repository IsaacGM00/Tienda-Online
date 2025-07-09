package mx.com.santander.hexagonalmodularmaven.entry.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("entries")
public class EntryEntity {
    @Id
    private String id;
    private String name;
    private byte age;
    private String country;
}
