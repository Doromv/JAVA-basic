package 反射.类;

/**
 * @author shkstart
 * @create 2021-12-19-15:59
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
     private String name;
     int age;
     public int id;

    public Person() {
    }
@MyAnnotation(value = "abc")
   private Person(String name) {
        this.name = name;
    }

     Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String str){
        System.out.println("我的国籍是"+str);
        return str;
    }
    public String display(String interests,int age)throws NullPointerException,ClassCastException{
        return interests+age;
    }
    public void info(){
        System.out.println("我是一个人");
    }
    @Override
    public int compareTo(String s) {
        return 0;
    }

}
