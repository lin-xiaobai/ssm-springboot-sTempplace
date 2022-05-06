package com.spring5.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/7/9 -19:14
 * IOC操作Bean管理（xml注入集合属性）
 * <p>
 * 1.注入数组类型属性
 * <p>
 * 2.注入List集合类型属性
 * <p>
 * 3.注入Map集合类型属性
 */
public class collectionTypeBean {
    /**
     * 1.数组类型属性
     */
    private String[] courses;
    /**
     * //    2.list类型属性,加上object约束
     */
//    定义学生所属的课程，用list集合
    private List<collectionTypeOject> listCourse;

    public void setListCourse(List<collectionTypeOject> listCourse) {
        this.listCourse = listCourse;
    }

    //    定义学生所属的课程，用map集合
    private Map<Object, collectionTypeOject> mapcouser;

    public void setMapcouser(Map<Object, collectionTypeOject> mapcouser) {
        this.mapcouser = mapcouser;
    }

    private List<Object> list;
    //  3.map类型属性
    private Map<String, Object> mao;
    //    4.set类型属性
    private Set<Object> set;


    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setMao(Map<String, Object> mao) {
        this.mao = mao;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void show() {
//        这个方法是遍历数组
        System.out.println(Arrays.toString(courses));
        System.out.println(mao);
        System.out.println(list);
        System.out.println(set);
        System.out.println(listCourse);
        System.out.println(mapcouser);
    }
}
