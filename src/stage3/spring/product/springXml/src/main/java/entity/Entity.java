package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entity {
    private String name;
    private String[] names;
    private List<?> nameList;
    private Set<?> nameSet;
    private Map<?,?> nameMap;
    private Properties namePro;

    public Entity(String name) {
        this.name = name;
    }
}
