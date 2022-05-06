package 反射机制;

/**
 * @date 2021/4/15 -21:29
 */
public class user {
    int no;
    String name;
    boolean sex;
    int age;

    public user(int no) {
        this.no = no;
    }

    public user(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public user(int no, String name, boolean sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    public user(int no, String name, boolean sex, int age) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
