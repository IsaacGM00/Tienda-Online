package mx.com.santander.hexagonalmodularmaven.entry.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entry {
    private String id;
    private String name;
    private byte age;
    private String country;
}
