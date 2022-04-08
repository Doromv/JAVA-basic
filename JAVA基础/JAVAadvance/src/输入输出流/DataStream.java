package 输入输出流;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-12-16-10:20
 */
//将文件中存储的基本数据类型和字符串读取到内存中，保存在变量中
//注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据顺序一致！
public class DataStream {
    public static void main(String[] args) {
        DataOutputStream dos= null;
        try {
            dos = new DataOutputStream(new FileOutputStream("hello.txt"));
            dos.writeUTF("小明");
            dos.flush();
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("-----------------------");
        DataInputStream dis= null;
        try {
            dis = new DataInputStream(new FileInputStream("hello.txt"));
            String str= dis.readUTF();
            int age=dis.readInt();
            boolean ismale=dis.readBoolean();
            System.out.println(str);
            System.out.println(ismale);
            System.out.println(age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("-----------------------");

    }
}
