package 输入输出流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author shkstart
 * @create 2021-12-16-13:30
 */
//1.既可以作为输入流也可以作为输出流
//2.如果RandomAccessFile作为输出流时，写的文件如果不存在，则在执行的过程中自动创建，
//如果写出到的文件夹存在，则会对原有文件的内容进行覆盖（默认情况下，从头覆盖）
public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("qaq.jpg"),"r");
            raf2 = new RandomAccessFile(new File("qaq1.jpg"),"rw");
            byte[] buffer=new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(raf1!=null)
                raf1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(raf2!=null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------------------");
        RandomAccessFile randomAccessFile1= null;
        try {
            randomAccessFile1 = new RandomAccessFile("hello.txt","rw");
//            randomAccessFile1.seek("hello.txt".length());
            randomAccessFile1.seek(3);/*从第四个字符开始覆盖*/

            randomAccessFile1.write("hello1".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            randomAccessFile1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }
}
