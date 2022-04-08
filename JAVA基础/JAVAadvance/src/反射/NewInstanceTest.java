package 反射;

import 输入输出流.Person;

/**
 * @author shkstart
 * @create 2021-12-18-15:37
 */
public class NewInstanceTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<Person> clazz= Person.class;
        Person obj = (Person)clazz.newInstance();
        System.out.println(obj);

    }
}
