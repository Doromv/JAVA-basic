package 输入输出流;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2021-12-15-9:20
 */

public class CopyWay {
    public static void copyPictureFile(String srcpath,String destpath){
        FileInputStream fileinputstream= null;
        FileOutputStream fileoutputstream= null;
        try {
            File inputfile=new File(srcpath);
            File outputfile=new File(destpath);
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
    public static void bufferedcopyPictureFile(String srcpath,String destpath){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            File input=new File(srcpath);
            File output=new File( destpath);
            FileInputStream fis=new FileInputStream(input);
            FileOutputStream fos=new FileOutputStream(output);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer=new byte[5];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void WordCount(String srcpath,String destpath){
        //统计一篇文章中各个字出现的字数
        FileReader fr= null;
        BufferedWriter bw= null;
        try {
            Map<Character,Integer> map=new HashMap<>();
            fr = new FileReader(srcpath);
            bw = new BufferedWriter(new FileWriter(destpath));
            int c=0;
            while ((c=fr.read())!=-1){
                char ch=(char)c;
                if(map.get(ch)==null){
                    map.put(ch,1);
                }else {
                    map.put(ch,map.get(ch)+1);
                }
            }
            Set<Map.Entry<Character,Integer>> entrySet=map.entrySet();
            for(Map.Entry<Character,Integer>entry:entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键="+entry.getValue());
                        break;
                    case'\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw!=null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        CopyWay.copyPictureFile("D:\\qaq.jpg","D:\\qwer.jpg");
        CopyWay.bufferedcopyPictureFile("D:\\qaq.jpg","D:\\qwer.jpg");
        CopyWay.WordCount("美文.txt","美文各个字出现次数的统计.txt");
    }
}
