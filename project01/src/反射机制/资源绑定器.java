package 反射机制;

import java.util.ResourceBundle;

/**
 * @date 2021/4/16 -11:36
 * java.util包下提供了一个资源绑定器，便于获取属性配置文件中的内容。
 * 使用以下方式的时候，属性配置文化xxx.properties必须放到类路径下的。
 * 只能绑定xxx.properties文件。路径后面的扩展名不能写
 */
public class 资源绑定器 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("classinfo");
        String value = resourceBundle.getString("name");
        System.out.println(value);
    }
}
