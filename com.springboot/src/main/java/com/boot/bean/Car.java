package com.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @date 2021/11/11 -21:19
     * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 *  把经常需要改变的数据写入到 Properties配置文件 中 如：数据库的配置信息。。
 * */
//1.配置绑定:Java读取到properties文件中的内容，并且把它封装到JavaBean中，以供随时使用；
//    作用：可以从多个配置信息中获取 前缀名一致的键值对，并且可以随便修改配置信息
//    方式一：@Component+ @ConfigurationProperties
//(1)将该类注册到容器中
//    @Component 普通注解：将组件注册到容器中
//     @ConfigurationProperties(prefix = "mycar")
//  从 Properties配置文件 中 找到 前缀名为mycar的键值对，然后进行数据绑定

//    方式二：@EnableConfigurationProperties + @ConfigurationProperties
//    （1）在配置类中开启car配置绑定，把car组件自动注册到容器中

    @ConfigurationProperties(prefix = "mycar")
    public class Car {

        private String brand;
        private Integer price;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
