解决数据库中的字段名与POJO中的类的属性名不一致问题

resultMap 元素是 MyBatis 中最重要最强大的元素。
ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。
 ResultMap 的优秀之处——你完全可以不用显式地配置它们

数据库中pwd字段名与pojo包下的user类中password属性名不一样
解决方法：
方式一.为数据库的字段名 起别名
    <select id="getUserById" parameterType="int" resultType="User">
          select id,name,pwd as password from user.t_user  where id=#{id}
      </select>
<!--
   解决方法二：结果集映射 -->
<!--    id里面的值需要与对应的标签（select）中的resultMap的值 对应-->
    <resultMap id="UserMap" type="User">
<!--        将数据库中的字段名映射到pojo类属性名 -->
<!--      column数据库中的字段名 property实体类中属性  -->
<!--     result 可以只映射 数据库中的字段名与实体类属性名不一样 -->
        <result column="id" property="id"/>
        <result column="name" property="name"/>
        <result column="pwd" property="password"></result>
    </resultMap>
<!--   resultMap的值 可以任意取 ，只是起到一个标识作用 -->
    <select id="getUserById" parameterType="int" resultType="User" resultMap="UserMap">
        select * from user.t_user  where id=#{id}
    </select>



    日志工厂
    如果数据库中出现异常，需要排错，日志就是最好的助手
    曾经：sout debug
    现在 ：日志工厂

    mybatis内置（官方文档中setting中的 logImpl）在核心配置文件xml文件中设置日志工厂
    指定 MyBatis 所用日志的具体实现，未指定时将自动查找。
    工具如下
    SLF4J
    LOG4J [掌握]
    LOG4J2
    JDK_LOGGING
    COMMONS_LOGGING
    STDOUT_LOGGING [掌握]
     NO_LOGGING

在mybatis中具体使用那个 --日志实现，在设置中设定
STDOUT_LOGGING 标准日志输出

Log4j:
通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件，甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护进程等；
可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程。
通过一个配置文件来灵活地进行配置，而不需要修改应用的代码。

简单使用Log4j 自定义异常信息
1.在要使用Log4j类中导入包  org.apache.log4j.Logger 要apache下的包
2.日志对象，参数为当前类的class
3.日志级别


分页：减少数据的处理量

使用limit分页
语法 SELECT * from user limit startIndex,pageSize;
eg:SELECT * from user limit 0,2; 查询 索引为0 的数据，一页2条数据
SELECT * FROM user limit 3; 【0,n]查询前n条数据 从0到n条数据

步骤：
1.接口
2.Mappper.xml文件
3.mybatis.dao.test