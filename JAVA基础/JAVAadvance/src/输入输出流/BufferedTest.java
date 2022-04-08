package 输入输出流;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-12-15-10:31
 */
public class BufferedTest {
    public static void main(String[] args) {
//        BufferedInputStream bis= null;
//        BufferedOutputStream bos= null;
//        try {
//            File input=new File("D:\\qaq.jpg");
//            File output=new File("D:\\sss.jpg");
//            FileInputStream fis=new FileInputStream(input);
//            FileOutputStream fos=new FileOutputStream(output);
//            bis = new BufferedInputStream(fis);
//            bos = new BufferedOutputStream(fos);
//            byte[] buffer=new byte[5];
//            int len;
//            while ((len=bis.read(buffer))!=-1){
//                bos.write(buffer,0,len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//            if(bis!=null){
//                bis.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//            try {
//                if(bos!=null){
//                    bos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("-------------------------------");
//        使用BufferedReader和BufferWriter实现文本的复制
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            br = new BufferedReader(new FileReader(new File("HelloWorld.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello.txt")));
              //   方法一：
//            int len;
//            char [] data=new char[1024];
//            while ((len=br.read(data))!=-1){
//                bw.write(data,0,len);
//            }
            //   方法二：
            String data;
            while ((data=br.readLine())!=null){
                bw.write(data+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(br!=null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(bw!=null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
