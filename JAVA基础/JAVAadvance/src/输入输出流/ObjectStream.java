package 输入输出流;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;

/**
 * @author shkstart
 * @create 2021-12-16-11:16
 */
public class ObjectStream {
    public static void main(String[] args) {
//        序列化：
//        自定义类满足以下要求才可以序列化：
//        1.需要实现接口：Serializable,
//        2.需要当前类提供一个全局常量：SerialVersionUID
//        3.还要保证类的内部所有的属性是可序列化的（基本数据类型默认可序列化）
//        4.不能序列化static/ transient修饰的成员变量
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new java.lang.String("我爱北京"));
            oos.flush();
            oos.writeObject(new Person("王明",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos!=null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----------------------");
//        反序列化：
        ObjectInputStream ois= null;
        try {

            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            String str=(String)ois.readObject();
            Person person=(Person)ois.readObject();
            System.out.println(str);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
