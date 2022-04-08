package 反射;

import sun.security.jca.GetInstance;

import java.util.Random;

/**
 * @author shkstart
 * @create 2021-12-19-15:36
 */
//反射的动态性
public class ClassLoaderTest2 {
    public static Object getInstance(String classPath) throws Exception{
        Class clazz=Class.forName(classPath);
        return clazz.newInstance();
    }
    public static void main(String[] args) {
        int num=new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                classPath="java.lang.Object";
                break;
            case 2:
                classPath="输入输出流.Person";
                break;
        }
        Object object = null;
        try {
            object = getInstance(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(object);
    }
}
