package 网络编程;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author shkstart
 * @create 2021-12-17-16:39
 */
public class URLTest2 {
    public static void main(String[] args) {
        HttpURLConnection urlConnection= null;
        InputStream is = null;
        FileOutputStream fos= null;
        try {
            URL url=new URL("http://localhost:8080/examples/qaq.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("qaqaq.jpg");
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(is!=null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(urlConnection!=null)
        urlConnection.disconnect();;
    }



}
