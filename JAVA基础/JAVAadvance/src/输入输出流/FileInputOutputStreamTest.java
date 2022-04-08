package 输入输出流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-12-15-8:49
 */
//对于文本文件（.txt,.java,.c,.cpp）使用字符流处理，对于非文本文件(.jpg,.mp3,.avi……)使用字节流处理
//纯英文的txt文件字符流和字节流都可以使用，并不影响最后的输出效果
public class FileInputOutputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis= null;
        try {
            File file=new File("HelloWorld.txt");
            fis = new FileInputStream(file);
            byte[] data=new byte[5];
            int len;
            while ((len=fis.read(data))!=-1){
                String str=new String(data,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(fis!=null)
                fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("------------------------------");
        FileInputStream fileinputstream= null;
        FileOutputStream fileoutputstream= null;
        try {
            File inputfile=new File("QAQ.jpg");
            File outputfile=new File("qwer.jpg");
            fileinputstream = new FileInputStream(inputfile);
            fileoutputstream = new FileOutputStream(outputfile);
            byte[] pt=new byte[5];
            int len;
            while ((len=fileinputstream.read(pt))!=-1){
                fileoutputstream.write(pt,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(fileinputstream!=null)
                fileinputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(fileoutputstream!=null)
                    fileoutputstream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
