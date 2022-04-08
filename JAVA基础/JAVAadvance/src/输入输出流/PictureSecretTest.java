package 输入输出流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-12-15-15:12
 */
public class PictureSecretTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("qaq.jpg");
            fos = new FileOutputStream("qaqscreat.jpg");
            byte[] buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
    //            对字节数据进行修改，以实现加密,使得图片要经过解密才能查看
    //            将加密图片再次用此方法复制一次即可解密
                    for(int i=0;i<len;i++){
                        buffer[i]=(byte)(buffer[i]^5);
                    }
                    fos.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(fos!=null)
                fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
