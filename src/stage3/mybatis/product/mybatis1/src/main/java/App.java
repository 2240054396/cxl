
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

public class App {
    public static void main(String[] args) throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("applicationContext.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsReader);
        System.out.println(sqlSessionFactory.openSession().selectOne("com.zlt.entity.User.selectByUid",1));
    }
}