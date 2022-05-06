多表查询

mysql添加外键：

为已经添加好的数据表添加外键：
key 是数据库的物理结构
  KEY `fktid` (`tid`),#是索引（辅助查询用的）
语法:alter table 表名 add constraint `fktid` foreign key(你的外键字段名) REFERENCES 外表表名(对应的表的主键字段名)；
CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)

student添加外键
是用于建立和加强两个表数据之间的链接的一列或多列。
通过将保存表中主键值的一列或多列添加到另一个表中，可创建两个表之间的链接。这个列就成为第二个表的外键。


查询所有的学生属性，包括对应的老师的信息
查询两张表 student中设置了一个外键 tid=teacher.id
sql语句：select * from student s,teacher t  where s.tid=t.id
   方式一：按照 嵌套查询 （子查询）处理-->