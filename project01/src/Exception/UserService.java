package Exception;

/**
 * @date 2021/4/1 -22:27
 * 注册检验方法
 * 用户名和密码的长度小于6和大于14则报出异常
 */
public class UserService {
    public void register(String username, String password) throws ZiDingYiLei {
        if (username == null || username.length() < 6 || username.length() > 14) {
            throw new ZiDingYiLei("注册失败，账号格式不正确");

        }
        if (password.length() < 6 || password.length() > 14) {
            throw new ZiDingYiLei("密码格式不对");
        }
    }
}
