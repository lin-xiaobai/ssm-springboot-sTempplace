package mybatis.pojo;


/**
 * @date 2021/10/13 -18:32
 */
//为类名起别名
//    @Alias("User")
//    数据库中的pwd字段名与User类中的password属性名不一样
//实体类
public class User {
    private int id;
    private String name;

    private String password;
    public User() {
    }
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
  this.password=password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
