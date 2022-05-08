package com.doromv;

import java.io.*;

/**
 * @author Doromv
 * @create 2022-05-08-9:41
 */
public class 文件复制 {
    public static void main(String[] args) {
        copyFile(new File("F:\\1"),new File("F:\\2"));
    }
    public static void copyDir(File srcDir,File destDir){
        if(srcDir.exists()&&srcDir.isDirectory()){
            destDir.mkdir();
            File[] files = srcDir.listFiles();
            if(files!=null&&files.length>0){
                for (File file : files) {
                    if(file.isFile()){
                        copyFile(file,new File(destDir,file.getName()));
                    }else {
                        copyFile(file,new File(destDir,file.getName()));
                    }
                }
            }
        }
    }
    public static void copyFile(File srcFile,File destFile){
        try (
                InputStream is = new FileInputStream(srcFile);
                BufferedInputStream bis=new BufferedInputStream(is);
                OutputStream os=new FileOutputStream(destFile);
                BufferedOutputStream bos=new BufferedOutputStream(os);
        ) {
            int len;
            byte[] buffer=new byte[1024];
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
