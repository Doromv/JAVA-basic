package 反射.类;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2021-12-19-15:59
 */
public class Creature <T>implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
