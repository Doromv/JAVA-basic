package 输入输出流;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2021-12-16-11:40
 */
public class Person implements Serializable {
    public static final long serialVersionUID=1231414L;
    private  String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
