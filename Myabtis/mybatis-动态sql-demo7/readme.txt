动态 SQL 在拼接sql语句，保证sql的正确性，按照sql的格式，去排列组合即可
是 MyBatis 的强大特性之一
根据不同条件生成不同的SQL 语句
例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。

建议：在mysql中写出完整的SQL，再对应的去修改成为动态sql实现通过

元素种类
if：这条语句提供了可选的查找文本功能。
如果不传入 “title”，那么所有处于 “ACTIVE” 状态的 BLOG 都会返回；
如果传入了 “title” 参数，那么就会对 “title” 一列进行模糊查找并返回对应的 BLOG 结果

choose (when, otherwise)
trim (where, set)
foreach


自定义 trim 元素来定制 where 元素的功能。比如，和 where 元素等价的自定义 trim 元素为：
<trim prefix="WHERE" prefixOverrides="AND |OR ">
  ...
</trim>
prefixOverrides 属性会忽略通过管道符分隔的文本序列（注意此例中的空格是必要的）。
上述例子会移除所有 prefixOverrides 属性中指定的内容，并且插入 prefix 属性中指定的内容。


 开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn -->
原因：数据库中出现create_time字段名 而实体类中的属性名是驼峰命名法 createTime -->
在mybatis的核心配置文件中开启这个，可以让列名A_COLUMN 对应 实体类中  aColumn-->
<setting name="mapUnderscoreToCamelCase" value="true"/>



SQL片段
 在Mapper.xml文件将一些功能的部分抽取出来，方便复用
 eg:修改和查询中有一些代码是相同的，这时就可以<sql />标签抽取出来，并且设置id
 <!--抽取sql语句中代码重复 使用sql标签抽取，并且设置id名 一般使用if where set标签较多-->
 <!--    在对应的sql语句中使用<include refid="if-title-author-"></include>
     refid：抽取重复代码的sql标签的id属性值
     代替sql语句中抽取的代码

步骤：1.使用sql标签抽取公共的部分
2在需要使用的地方使用include标签引用即可

注意事项：
1.最好基于单表来定义sql片段
2.在sql标签里不要出现 where标签，因为where标签会在子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。


对集合进行遍历（尤其是在构建 IN 条件语句的时候）
foreach 元素的功能非常强大，它允许你指定一个集合，
声明可以在元素体内使用的集合项（item）和索引（index）变量。
它也允许你指定开头与结尾的字符串以及集合项迭代之间的分隔符。

//    查询id为1，2,3的数据并且将讲id的数据存储在集合中，
//    在mapper.xml文件中使用foreach遍历集合获取集合中的值，然后进行拼接sql语句

查询 id为1,2,3的数据
查询多条数据
select *from user where 1=1 and (id=1 or id=2 or id=3)



