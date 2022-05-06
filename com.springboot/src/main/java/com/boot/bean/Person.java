package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/11/14 -17:07
 */
/**
 * 使用yaml配置文件配置经常需要改变的数据
绑定数据的好处：将经常需要改变的值写在配置类中
跟配置文件application.yaml绑定数据，前缀名为person
 **/
@Component//将组件注册在IOC容器中
@ConfigurationProperties(prefix = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pett pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pett>> allPets;
}
