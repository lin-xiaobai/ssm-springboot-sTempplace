package String;

/**
 * @date 2021/3/20 -18:04
 */
public class 方法 {
    public static void main(String[] args) {
        char c = "中国人".charAt(1);//"中国人“是一个String类型的对象”
        System.out.println(c);

//        字符串之间比较大小不能直接使用大于号或者小于号，需要使用compareTo方法。
//        例如：
//        拿着字符串第一个字母与后面字符串的第一个字母比较。能分胜负就不再比较了。
        System.out.println("xyz".compareTo("yxz"));//第一个字符串的首个字母比第二个字符串的首个字母校
//        所以，返回-1；如果相同，则返回0


//        判断字符串中是否有包含某些单词,返回值为Boolean值
        System.out.println("hello.java".contains(".java"));


        //判断两个字符串内容是否相等，（忽略大小写）
        System.out.println("abc".equalsIgnoreCase("Abc"));


//        判断当前字符串是否以某个字符串结尾的
        System.out.println("java.text".endsWith(".txt"));


//        将字符串对象转换成字节数组
        byte[] b2 = "abcdef".getBytes();
        for (int i = 0; i < b2.length; i++) {
            System.out.print(b2[i] + " ");
        }

//        判断某个字符串在当前字符串中第一次出现处的索引（下标）。
        System.out.println("jadhajdhahaifhiahfaihfaifiafiahfahf".indexOf("fa"));


        //    判断某个字符串是否为“空字符串”
        System.out.println("".isEmpty());

//        判断数组的长度是length属性，判断字符串长度是length();
        System.out.println("avc".length());


//        判断某个子字符串在当前字符串中最后一次出现的索引（下标）
        System.out.println("javaisposiva".lastIndexOf("va"));

//        替换某段字符串
        String newString = "http://www.baidu.com".replace("baidu", "guge");
        System.out.println(newString);


//        拆分字符串
//        以“&”为分隔符进行拆分
        String[] param = "name=zhangsan&psd=123&age=13".split("&");
        for (int i = 0; i < param.length; i++) {
            System.out.println(param[i]);

//            提取字符串
            System.out.println("http://www.baidu.com".substring(10));
            System.out.println("http://www.baidu.com".substring(0, 3));

//            将字符串转换成char数组
            char[] chars = "baidu.com".toCharArray();
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j] + " ");
            }

//            转换成小写
            System.out.println("aDAJDHAHDA".toLowerCase());
//            转换成大写
            System.out.println("dajhdaadkjkajdk".toUpperCase());

//            去除字符串前后空白
            System.out.println("    h    w  o".trim());


//            将"非字符串"转换成“字符串”；
            String s1 = String.valueOf(100);
            System.out.println(s1);
//            如果valueOf里面是一个对象的话，如果没有重写tostring方法的话，
//            会默认调用tostring方法打印出对象的内存地址。
            String s2 = String.valueOf(new vip());
            System.out.println(s2.toString());

        }


    }


}

class vip {
    //    重写toString方法
    public String toString() {
        return "SB";
    }
}
