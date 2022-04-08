package 反射;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2021-12-18-15:18
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
//        FileInputStream fis=new FileInputStream("E:\\IDEA 2021\\JAVA代码缓存\\JAVAadvance\\hello.properties");
//        properties.load(fis);
        ClassLoader classLoader= ClassLoaderTest1.class.getClassLoader();
        InputStream is=classLoader.getResourceAsStream("hello.properties");
        properties.load(is);
        String str=properties.getProperty("str");
        System.out.println(str);
    }
}
