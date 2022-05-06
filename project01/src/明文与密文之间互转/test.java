package 明文与密文之间互转;

/**
 * @date 2021/6/23 -18:13
 */
public class test {
    public static void main(String[] args) {
        char c[] = "44522119991123495XFHAGFUAGAGFU".toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 'Q');//将明文转换成密文
        }
        String string = new String(c, 0, c.length);
        System.out.println("密文：" + string);
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 'Q');//将密文还原为明文
        }
        String string1 = new String(c, 0, c.length);
        System.out.println("明文：" + string1);


        System.out.println("-------");


    }
}
