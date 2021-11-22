import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class APP {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> list=new ArrayList<String>();
        ConfigurationParser configurationParser=new ConfigurationParser(list);
        Configuration configuration=configurationParser.parseConfiguration
                (Resources.getResourceAsReader("generatorConfig.xml"));
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator
                (configuration,new DefaultShellCallback(true),list);
        myBatisGenerator.generate(null);
    }
}
