package 反射;

import 反射.类.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author shkstart
 * @create 2021-12-19-16:43
 */
public class MethodTest {
    public static void main(String[] args) {
        Class clazz= Person.class;
//        getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        System.out.println("------------------------");
//        getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m:declaredMethods){
            System.out.println(m);
        }
        System.out.println("------------------------");
//        权限修饰符 返回值类型 方法名（参数类型1 形参名1，……）throws xxxException{}
        for(Method m:declaredMethods){
//            获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a:annotations){
                System.out.println(a);
            }
//            权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");
//            返回值类型
            System.out.print(m.getReturnType().getName()+"\t");
//            方法名
            System.out.print(m.getName()+"(");
//            形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes==null&&parameterTypes.length==0)){
                for(int i=0;i<parameterTypes.length;i++){
                    if(i==parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName()+"\t"+"args_"+i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+"\t"+"args_"+i+",");
                }

            }

            System.out.print(")");
            //        抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length>0)
                System.out.print("throw");
            for(int i=0;i<exceptionTypes.length;i++){
                if(i==exceptionTypes.length-1){
                    System.out.print(exceptionTypes[i].getName());
                    break;
                }
                System.out.print(exceptionTypes[i].getName()+",");
            }
            System.out.println();
        }


    }
}
