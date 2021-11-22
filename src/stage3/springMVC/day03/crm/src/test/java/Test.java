import com.zlt.utils.MD5Util;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {

    @org.junit.Test
    public void test() {
        System.out.println(MD5Util.md5("123456", "asdf", 10));
    }
}
