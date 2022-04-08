package 反射;

import 反射.类.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author shkstart
 * @create 2021-12-19-16:19
 */
//获取运行时类的属性结构
public class FiledTest {
    public static void main(String[] args) {
     Class clazz= Person.class;
//     getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("-----------------------");
//        getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f:declaredFields){
//            1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
//            2.数据类型
            Class type = f.getType();
            System.out.print(type.getName()+"\t");
//            3.变量名
            String name = f.getName();
            System.out.println(name);
        }
        System.out.println("-----------------------");

    }
}
