package 网络编程;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.*;
/**
 * @author shkstart
 * @create 2021-12-17-13:57
 */
public class TCPTest1 {
       public static void cilent(){
        Socket socket= null;
        OutputStream os= null;
        try {
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(socket!=null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(os!=null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void server(){
        ServerSocket ss = null;
        Socket socket= null;
        InputStream is = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
//            不建议这样写
//            byte[] data=new byte[200];
//            int len;
//            while ((len=is.read(data))!=-1){
//                String str=new String(data,0,len);
//                System.out.println(str);
//            }
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] data=new byte[5];
            int len;
            while((len=is.read(data))!=-1){
                baos.write(data,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(ss!=null)
                ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

    }

}
