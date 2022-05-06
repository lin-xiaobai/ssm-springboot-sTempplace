/**
 * @date 2021/3/18 -15:22
 */
//模拟一个系统，如果要使用这个系统，必须输入用户名和密码
public class test03 {
    public static void main(String[] args) {
//        如果输入的三个参数则报错
        if (args.length != 2) {
            System.out.println("请您输入正确的密码和账号");
        }
//        正确的密码和账号
        String username = args[0];
        String pwd = args[1];
//        这样编写可以避免空指针异常。
        if ("zhangsan".equals(username) && "123".equals(pwd)) {
            System.out.println("欢迎" + username + "回来");
        } else {
            System.out.println("请您输入正确");
        }
    }
}
