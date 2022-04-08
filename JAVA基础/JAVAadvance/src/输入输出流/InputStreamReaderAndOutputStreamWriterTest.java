package 输入输出流;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-12-15-16:53
 */
//InputStreamReader:将一个字节的输入流转化为字符的输入流
//OutputStreamWriter:将一个字符的输出流转化为字节的输出流
public class InputStreamReaderAndOutputStreamWriterTest {
    public static void main(String[] args) {
//        InputStreamReader isr= null;
//        try {
//            FileInputStream fis=new FileInputStream("HelloWorld.txt");
//            isr = new InputStreamReader(fis,"UTF-8");
//            char cbuf[]=new char[1024];
//            int len;
//            while ((len=isr.read(cbuf))!=-1){
//                String str=new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(isr!=null)
//            isr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        }
//        System.out.println("--------------------");
        OutputStreamWriter osw= null;
        InputStreamReader isr1=null;
        try {
            FileInputStream fis=new FileInputStream("HelloWorld.txt");
            FileOutputStream fos=new FileOutputStream("qwer.txt");
           isr1=new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"gbk");
            char[] cbuf=new char[20];
            int len;
            while ((len=isr1.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(isr1!=null)
                isr1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(osw!=null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
