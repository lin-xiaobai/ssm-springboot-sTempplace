package ChckCode;

import java.util.Random;

/**
 * @date 2021/7/5 -16:03
 */
public class numnum {
    public static void main(String[] args) {
        Random ran = new Random();
        int num = ran.nextInt(10000) + 1000;
        System.out.println(num);
    }
}
