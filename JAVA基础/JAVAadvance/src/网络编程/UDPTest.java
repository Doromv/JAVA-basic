package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author shkstart
 * @create 2021-12-17-16:08
 */
public class UDPTest {
    public void sender() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        String str="我是UDP";
        InetAddress inet=InetAddress.getLocalHost();
        byte[] data=str.getBytes();
        DatagramPacket dp = new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(dp);
        socket.close();

    }
    public void receiver() throws IOException {
        DatagramSocket socket=new DatagramSocket(9090);
        byte[] buffer=new byte[100];
        DatagramPacket dp = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));
    }
}
