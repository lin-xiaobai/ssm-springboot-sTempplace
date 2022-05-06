package com.spring5;

/**
 * @date 2021/7/4 -18:46
 * 3.使用有参数构造注入属性
 * <p>
 * <p>
 * 在spring配置文件中配置
 */
public class orders {
    private String id;
    private String addres;

    public orders(String id, String addres) {
        this.id = id;
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "orders{" +
                "id='" + id + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
