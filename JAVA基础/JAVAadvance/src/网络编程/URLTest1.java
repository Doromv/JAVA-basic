package 网络编程;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author shkstart
 * @create 2021-12-17-16:29
 */
public class URLTest1 {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://localhost:8080/examples/qaq.jpg");
            System.out.println(url.getProtocol());/*协议名*/
            System.out.println(url.getHost());/*主机名*/
            System.out.println(url.getPort());/*端口号*/
            System.out.println(url.getPath());/*文件路径*/
            System.out.println(url.getFile());/*文件名*/
            System.out.println(url.getQuery());/*查询名*/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
