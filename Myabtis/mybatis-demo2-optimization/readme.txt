https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases
优化mybatis


需要掌握
MyBatis 的配置文件
    configuration（配置）
        properties（属性）动态获取连接数据库的属性
        settings（设置）
        typeAliases（类型别名）为需要填写全类名 提供一个别名
        environments（环境配置）配置多个数据库，但最终只能实现一个数据库

其他配置只需要了解即可
typeHandlers（类型处理器）
objectFactory（对象工厂）
plugins（插件）

映射器
在自动查找资源方面，Java 并没有提供一个很好的解决方案，
所以最好的办法是直接告诉 MyBatis 到哪里去找映射文件。
 你可以使用相对于类路径的资源引用，或完全限定资源定位符（包括 file:/// 形式的 URL），或类名和包名等


 作用域（Scope）和生命周期
 不同作用域和生命周期类别是至关重要的，因为错误的使用会导致非常严重的并发问题。

 SqlSessionFactoryBuilder
 一旦创建了 SqlSessionFactory，就不再需要它了
 所以应该把它放在局部变量

 SqlSessionFactory （可以创建多个，但是没用，浪费内存资源）
 可以想象为：数据库连接池 （等待别人的连接）
 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。
 最佳实践是在应用运行期间不要重复创建多次，
最佳作用域是应用作用域 即全局变量
最简单的就是使用单例模式或者静态单例模式。

SqlSession
连接到连接池的一个请求
SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
用完之后需要赶紧关闭，否则资源被占用

SqlSessionFactory---->SqlSession--->Mapper
一个Mapper 代表一个具体业务

别名 需要在核心配置文件xml文件中配置
<!--    第一种：alias:写的是别名，可以随便写 type:写的指导包的路径-->
    <typeAliases>
    <typeAlias alias="User" type="mybatis.pojo.Student"/>
</typeAliases>
<!--    第二种 指定一个包名 使用在指定类上添加注解@Alias("User") 为包名 起别名-->
<!--   <typeAliases>-->
<!--       <package name="mybatis.pojo.Student"/>-->
<!--   </typeAliases>-->
