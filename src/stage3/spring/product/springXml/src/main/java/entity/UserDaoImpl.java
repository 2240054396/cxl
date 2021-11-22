package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDaoImpl implements UserDao{
    private String name;

    public void method() {
        System.out.println("hello "+name);
    }
}
