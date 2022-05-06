package com.spring5.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2021/8/1 -12:03
 * 完全注解方式：
 */

@Configuration //配置类
@ComponentScan(basePackages = "com.spring5.bank")//组件扫描 里面写要扫描的包
@EnableTransactionManagement //开启事务
public class TxConfig {

    //    创建数据库连接池 德鲁伊连接池
    @Bean
    public DruidDataSource getDruidDataSource() throws IOException {
//        实例化连接池
        DruidDataSource dataSource = new DruidDataSource();

        Properties properties = new Properties();
//        使用classLoader加载properties配置文件生成对应的输入流
        InputStream in = TxConfig.class.getClassLoader().getResourceAsStream("bank.properties");
//        properties对象加载输入流
        properties.load(in);
//根据key获取value
        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClass"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.userName"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        return dataSource;
    }

    //    创建jdbcTemplate对象
//    由于在上面的方法已经获取德鲁伊连接池对象DataSource对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
//        到ioc容器中根据类型找到DataSource对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        注入datasource数据源对象
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //    创建事务管理器
    @Bean
//    到ioc容器中根据类型找到DataSource对象
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        事务管理器中设置数据源
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
