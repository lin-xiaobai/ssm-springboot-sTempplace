package 集合.Map接口;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @date 2021/4/9 -12:19
 */
public class 重写equals和hashCode方法 {
    public static void main(String[] args) {
//        创建对象
        student s1 = new student("zhang");
        student s2 = new student("zhang");
//        没重写student类中equals方法时，比较的是两对象的内存地址
//        System.out.println(s1.equals(s2));
//        重写后
        System.out.println(s1.equals(s2));
//        创建一个集合
//        s1和s2元素是相同的，如果往HashSet集合中放元素时，只能放一个
//        因为HashSet集合特点是：无序不可重复
        Set<student> s = new HashSet<>();
        s.add(s1);
        s.add(s2);

        System.out.println(s.size());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        for (student student : s) {
            System.out.println(student);
        }

    }
}

class student {
    private String name;

    public student() {

    }

    public student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
//    public boolean equals(Object obj){
//        if(obj==null ||!(obj instanceof student)) return false;
//        if (obj==this.name) return true;
//        student s=(student)obj;
//        return this.name.equals(s.name);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}