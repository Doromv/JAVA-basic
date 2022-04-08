package 输入输出流;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * @author shkstart
 * @create 2021-12-15-0:17
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
//            输入流
            FileReader fr= null;
            try {
                File file=new File("HelloWorld.txt");
                fr = new FileReader(file);
                int data;
                while ((data=fr.read())!=-1){
                    System.out.print((char)data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fr!=null)
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("--------------------------------------");
        FileReader fr1= null;
        try {
            File file1=new File("HelloWorld.txt");
            fr1 = new FileReader(file1);
            char [] data=new char[5];
            int len;
            while ((len=fr1.read(data))!=-1){
                for(int i=0;i<len;i++){
                    System.out.print(data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr1!=null)
                fr1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------------------------");
//        输出流
        FileWriter fw= null;
        try {
            File file2=new File("HelloWorld1");
            fw = new FileWriter(file2,true);
            fw.write("I have a dream!");
            fw.write("\nAEIOU");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null)
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("--------------------------------------");
//输入输出流结合使用
        FileReader fileReader= null;
        FileWriter fileWriter= null;
        try {
            File rfile=new File("HelloWorld.txt");
            File wfile=new File("HelloWorld1.txt");
            fileReader = new FileReader(rfile);
            fileWriter = new FileWriter(wfile);
            char [] cbuf=new char[5];
            int len;
            while ((len=fileReader.read(cbuf))!=-1){
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!=null)
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileReader!=null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
