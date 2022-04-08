package 网络编程;



import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shkstart
 * @create 2021-12-17-15:39
 */
public class TCPTest3 {
    public static void cilent(){
        Socket socket= null;
        OutputStream os= null;
        FileInputStream fis= null;
        ByteArrayOutputStream baos=null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            fis = new FileInputStream("qaq.jpg");
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
             baos=new ByteArrayOutputStream();
            byte[] bufferr=new byte[20];
            int lenn;
            while((lenn=fis.read(bufferr))!=-1){
               baos.write(buffer,0,lenn);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os!=null)
                    os.close();
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
                if(baos!=null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos= null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream("qaq2.jpg");
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            OutputStream os = socket.getOutputStream();
            os.write("收到".getBytes());

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
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        TCPTest3.server();
        TCPTest3.cilent();
    }
}
