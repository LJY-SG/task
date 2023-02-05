

# 							MySQL学习笔记



## 1 MySQL的概述：

* #### 数据库相关概念：

  * 数据库：存储数据的仓库，数据是有组织得进行存储，简称：DataBase(DB)

  * 数据库管理系统：操纵和管理数据库的大型软件，简称：DataBase Management System (DBMS)

  * SQL：操作关系型数据库的编程语言，定义了一套操作关系型数据库统一标准，简称：Structured Query Language(SQL)

    ![image-20230202232247876](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230202232247876.png)

  * 主流的关系型数据管理系统

  * ![image-20230202233116143](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230202233116143.png)



总结：

* 1.数据库
  * 数据存储的仓库
* 2.数据管理系统
  * 操纵和管理数据库的大型软件
* 3.SQL
  * 操作关系型数据库的编程语言，是一套标准



* #### MySQL数据库：

  * 启动与停止

    * 启动

      net start mysql80

    * 停止

      net stop mysql80

  * 客户端链接

    * 方式一：MySQL提供的客户端命令行工具

    * 方式二：系统自带的命令行工具执行指令

      mysql [-h 127.0.01] [-P 3306] -u root -p
      
      -h指定连接地址，-P指定连接端口，-u指定连接用户名，-p指定密码



* 关系型数据库（RDBMS）

  * 概念：建立在关系模型基础上，由多张相互连接的二维表组成的数据库
  * 特点：
    * 使用表存储数据，格式统一，便于维护
    * 使用SQL语言操作，标准统一，使用方便

* 数据模型

  ![image-20230203122504051](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230203122504051.png)



## 2 SQL

### 2.1 SQL通用语法

* SQL语句可以单行或多行书写，以分号结尾
* SQL语句可以使用 空格/缩进 来增强语句的可读性
* MySQL数据库的SQL语句不区分大小写，关键字建议使用大写
* 注释：
  * 单行注释：--注释内容 或 #注释内容（MySQL特有）
  * 多行注释：/* 注释内容 */



### 2.2 SQL分类

| 分类 | 全称                       | 说明                                                   |
| ---- | -------------------------- | ------------------------------------------------------ |
| DDL  | Data Definition Language   | 数据定义语言，用来定义数据库对象（数据库，表，字段）   |
| DML  | Data Manipulation Language | 数据操作语言，用来对数据库表中的数据进行增删改         |
| DQL  | Data Query Language        | 数据查询语言，用来查询数据库中表的记录                 |
| DCL  | Data Control Language      | 数据控制语言，用来创建数据库用户、控制数据库的访问权限 |



#### 2.2.1 DDL

##### DDL-数据库操作

* 查询

  * 查询所有数据库

    ```sql
    SHOW DATABASES;
    ```

  * 查询当前数据库

    ```sql
    SELECT DATABASE();
    ```

* 创建

  ```sql
  CREATE DATABASE [IF NOT EXISTS] 数据库名 [DEFAULT CHARSET 字符集] [COLLATE 排序规则];
  ```

* 删除

  ```sql
  DROP DATABASE [IF EXIST] 数据库名;
  ```

* 使用

  ```sql
  USE 数据库名;
  ```



##### DDL-表操作

###### DDL-表操作-查询

* 查询当前数据库所有表

  ```sql
  SHOW TABLES;
  ```

* 查询表结构

  ```sql
  DESC 表名;
  ```

* 查询指定表的建表语句

  ```sql
  SHOW CREATE TABLE 表名;
  ```



###### DDL-表操作-创建

```sql
CREATE TABLE 表名(
	字段1 字段1类型[COMMENT 字段1注释],
	字段2 字段2类型[COMMENT 字段2注释],
	字段3 字段3类型[COMMENT 字段3注释],
	......
	字段n 字段n类型[COMMENT 字段n注释]
)[COMMENT 表注释];
```

**注意：[......]为可选参数，最后一个字段后面没有逗号**

字符串类型：varchar(字符串长度)



###### DDL-表操作-数据类型

MySQL中的数据类型有很多，主要分为三类：数值类型，字符串类型，日期时间类型。

数值类型：

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230203134353485.png" alt="image-20230203134353485" style="zoom:150%;" />

使用decimal要指定精度和标度，例：123.45

精度是整个数字长度为5，标度是指小数部分为2

例：age TINYINT UNSIGNED

score double(4,1)表名精度为5，小数位数为1



字符串类型：

![image-20230203135730819](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230203135730819.png)

char 和 varchar 后都跟(指定最多能存储的字符串长度)，char一个字符也会占用是个字符的空间，未占用的字符，其他空间用空格补位，而varchar，存储一个字符就占用一个字符空间，2个字符就占用2个字符空间，根据你所存储的内容去计算当前所占用的空间是多少。

**char性能高，varchar相对于char性能较差，原因：varchar需要根据你所存储的内容去计算当前所占用的空间**



日期时间类型：

![image-20230203140445456](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230203140445456.png)



案例：根据需求创建表（要求设计合理的数据类型、长度）

设计一张员工表，要求：

1.编号（纯数字）

2.员工工号(字符串类型，长度不超过10位)

3.员工姓名(字符串类型，长度不超过10位)

4.性别(男/女，存储一个汉字)

5.年龄(正常人年龄，不可能存储负数)

6.身份证号(二代身份证号均为18位，身份证中有X这样的字符)

7.入职时间(取值年月日即可)

![image-20230203141709798](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230203141709798.png)



###### DDL-表操作-修改

* 添加字段

  ```sql
  ALTER TABLE 表名 ADD 字段名 类型(长度) [COMMENT 注释] [约束];
  ```

* 修改数据类型

  ```sql
  ALTER TABLE 表名 modify 字段名 新数据类型(长度);
  ```

* 修改字段名和字段类型

  ```sql
  ALTER TABLE 表名 CHANGE 旧字段名 新字段名 类型(长度) [COMMENT 注释] [约束];
  ```

* 删除字段

  ```sql
  ALTER TABLE 表名 DROP 字段名;
  ```

* 修改表名

  ```sql
  ALTER TABLE 表名 RENAME TO 新表名;
  ```



###### DDL-表操作-删除

* 删除表

  ```sql
  DROP TABLE [IF EXISTS] 表名;
  ```

* 删除指定表，并重新创建该表

  ```sql
  TRUNCATE TEBLE 表名;
  ```

注意：在删除表时，表中的全部数据也会被删除。



#### 2.2.2 DML

* 介绍：

  DML 英文全称是Data Manipulation Language(数据操作语言)，用来对数据库表中的数据进行增删改操作。

* 增加数据(INSERT)

* 修改数据(UPDATE)

* 删除数据(DELETE)



##### DML-添加数据

* 给指定字段添加数据

  ```sql
  INSERT INTO 表名 (字段名1，字段名2，...) VALUES (值1，值2，...);
  ```

* 给全部字段添加数据

  ```sql
  INSERT INTO 表名 VALUES (值1，值2，...);
  ```

* 批量添加数据

  ```sql
  INSERT INTO 表名 (字段名1，字段名2，...) VALUES(值1，值2，...),(值1，值2，...),(值1，值2，...);
  ```

  ```sql
  INSERT INTO 表名 VALUES (值1，值2，...),(值1，值2，...),(值1，值2，...);
  ```

**注意：**

* **插入数据时，指定的字段顺序需要与值的顺序是一一对应的。**
* **字符串和日期类型数据应该包含在引号中**
* **插入的数据大小，应该在字段的规定范围内。**



##### DML-修改数据

* 修改数据

  ```sql
  UPDATE 表名 SET 字段名1 = 值1,字段名2 = 值2, ...[WHERE 条件]; 
  ```

  **注意：修改语句的条件可以有，也可以没有，如果没有条件，则会修改整张表的所有数据。**



##### DML-删除数据

* 删除数据

  ```sql
  DELETE FROM 表名 [WHERE 条件];
  ```

注意：

* DELETE语句的条件可以有，也可以没有，如果没有则会删除整张表的所有数据
* DELETE语句不能删除某一个字段的值(可以使用UPDATE)。



#### 2.2.3 DQL

* 介绍：

  DQL英文全称是Data Query Language(数据查询语言)，数据查询语言，用来查询数据库中表的记录。

  

  查询关键字：SELECT

  

* DQL-语法（编写顺序）

  ```sql
  SELECT
  		字段列表
  		
  FROM 
  		表名列表
  
  WHERE 
  		条件列表
  		
  GROUP BY
  		分组字段列表
  	
  HAVING
  		分组后条件列表
  		
  ORDER BY
  		排序字段列表
  		
  LIMIT 
  		分页参数
  ```



##### 基本查询

* 查询多个字段

  ```sql
  SELECT 字段1,字段2,字段3 ... FROM 表名;
  ```

  ```sql
  SELECT * FROM 表名;
  ```

* 设置别名

  ```sql
  SELECT 字段1[AS 别名1],字段2 [AS 别名2] ... From 表名;
  ```

* 去除重复记录

  ```sql
  SELECT DISTINCT 字段列表 FROM 表名;
  ```



##### 条件查询(WHERE)

* 语法

  ```sql
  SELECT 字段列表 FROM 表名 WHERE 条件列表;
  ```

* 条件

  | 比较运算符         | 功能                                     |
  | ------------------ | ---------------------------------------- |
  | >                  | 大于                                     |
  | >=                 | 大于等于                                 |
  | <                  | 小于                                     |
  | <=                 | 小于等于                                 |
  | =                  | 等于                                     |
  | <> 或 !=           | 不等于                                   |
  | BETWEEN ...AND ... | 在某个范围之内(含最小、最大值)           |
  | IN(...)            | 在in之后的列表中的值，多选一             |
  | LIKE 占位符        | 模糊匹配(_匹配单个字符，%匹配任意个字符) |
  | IS NULL            | 是NULL                                   |

  | 逻辑运算符 | 功能                       |
  | ---------- | -------------------------- |
  | AND 或 &&  | 并且(多个条件同时成立)     |
  | OR 或 \|\| | 或者(多个条件任意一个成立) |
  | NOT 或 !   | 非，不是                   |

  

##### 聚合函数(count、max、min、avg、sum)

* 介绍：将一列数据作为整体，进行纵向计算



* 常见聚合函数

  | 函数  | 功能     |
  | ----- | -------- |
  | count | 统计数量 |
  | max   | 最大值   |
  | min   | 最小值   |
  | avg   | 平均值   |
  | sum   | 求和     |



* 语法：

  ```sql
  SELECT 聚合函数(字段列表) FROM 表名;
  ```

**注意：null值不参与所有聚合函数运算。**



##### 分组查询(GROUP BY)

* 语法：

  ```sql
  SELECT 字段列表 FROM 表名 [WHERE 条件] GROUP BY 分组字段名 [HAVING 分组后过滤条件];
  ```

* where 和 having区别

  * 执行时机不同：where是分组之前进行过滤，不满足where条件，不参与分组；而having是分组之后对结果进行过滤。
  * 判断条件不同：where 不能对聚合函数进行判断，而having可以。



注意：

* 执行顺序：where > 聚合函数 > having
* 分组之后，查询的字段一般为聚合函数和分组字段，查询其他字段无任何意义。



##### 排序查询(ORDER BY)

* 语法：

  ```sql
  SELECT 字段列表 FROM 表名 ORDER BY 字段1 排序方式1，字段2 排序方式2;
  ```

* 排序方式：

  * ASC：升序（默认值）
  * DESC：降序

注意：如果是多字段排序，当第一个字段值相同时，才会根据第二个字段进行排序



##### 分页查询(LIMIT)

* 语法：

  ```sql
  SELECT 字段列表 FROM 表名 LIMIT 起始索引，查询记录数
  ```

* 注意：

  * 起始索引从0开始，起始索引 = (查询页码 - 1) * 每页显示记录数
  * 分页查询是数据库的方言，不同的数据库有不同的实现，MySQL中是LIMIT
  * 如果查询的是第一页数据，起始索引可以省略，直接简写为limit 10.



##### DQL-执行顺序

```sql
FROM 					
		表名列表

WHERE 					
		条件列表
		
GROUP BY				
		分组字段列表
		
HAVING					
		分组后条件列表
		
SELECT					
		字段列表
	
ORDER BY				
		排序字段列表
		
LIMIT 					
		分页参数
```

​																					

#### 2.2.4 DCL

* 介绍：DCL英文全称是Data Control Language(数据控制语言)，用来创建数据库用户、控制数据库的访问权限



##### DCL-管理用户

* 查询用户

  ```sql
  USE mysql;
  ```

  ```sql
  SELECT * FROM user;
  ```

* 创建用户

  ```sql
  CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
  ```

* 修改用户密码

  ```sql
  ALTER USER '用户名'@'主机名' INENTIFIED WITH mysql_native_password BY '新密码';
  ```

* 删除用户

  ```sql
  DROP USER '用户名'@'主机名';
  ```



##### DCL-权限控制

* MySQL中定义了很多种权限，但是常用的就以下几种：

  | 权限               | 说明               |
  | ------------------ | ------------------ |
  | ALL,ALL PRIVILEGES | 所有权限           |
  | SELECT             | 查询数据           |
  | INSERT             | 插入数据           |
  | UPDATE             | 修改数据           |
  | DELETE             | 删除数据           |
  | ALTER              | 修改表             |
  | DROP               | 删除数据库/表/视图 |
  | CREATE             | 创建数据库/表      |



* 查询权限：

  ```sql
  SHOW GRANTS FOR '用户名'@'主机名';
  ```

* 授予权限：

  ```sql
  GRANT 权限列表 ON 数据库名.表名 TO '用户名'@'主机名';
  ```

* 撤销权限：

  ```sql
  REVOKE 权限列表 ON 数据库名.表名 FROM '用户名'@'主机名';
  ```



注意：

* 多个权限之间，使用逗号分隔
* 授权时，数据库名和表名可以使用*进行通配，代表所有





## 3 函数

函数：是指一段可以直接被另一程序调用的程序或代码。



### 3.1 字符串函数

MySQL中内置了很多字符串函数，常用的几个如下：

| 函数                     | 功能                                                      |
| ------------------------ | --------------------------------------------------------- |
| CONCAT(S1,S2,...Sn)      | 字符串拼接，将S1,S2,...Sn拼接成一个字符串                 |
| LOWER(str)               | 将字符串str全部转为小写                                   |
| UPPER(str)               | 将字符串str全部转为大写                                   |
| LAPD(str,n,pad)          | 左填充，用字符串pad对str的左边进行填充，达到n个字符串长度 |
| RPAD(str,n,pad)          | 右填充，用字符串pad对str的右边进行填充，达到n个字符串长度 |
| TRIM(str)                | 去掉字符串头部和尾部的空格                                |
| SUBSTRING(str,start,len) | 返回从字符串str从start位置起的len个长度的字符串           |

代码演示：

```sql
select concat('hello','MySQL');

select upper('Hello');

select lpad('01',5,'-');

select rpad('01',5,'-');

select trim(' Hello MySQL ');

select substring('Hello MySQL',7,11);

select lpad('01',5,'0');

update employee set workno = lpad(workno,5,'0');
```



### 3.2 数值函数

常见的数值函数如下：

| 函数       | 功能                               |
| ---------- | ---------------------------------- |
| CEIL(x)    | 向上取整                           |
| FLOOR(x)   | 向下取整                           |
| MOD(x,y)   | 返回x/y的模                        |
| RAND()     | 返回0~1内的随机数                  |
| ROUND(x,y) | 求参数x的四舍五入的值，保留y位小数 |

代码演示：

```sql
select ceil(1.5);

select floor(1.5);

select mod(7,4);

select rand();

select round(2.344,2);

select lpad(round(rand() * 1000000,0),6,'0');
```



### 3.3 日期函数

常见的日期函数如下：

| 函数                              | 功能                                              |
| --------------------------------- | ------------------------------------------------- |
| CURDATE()                         | 返回当前日期                                      |
| CURTIME()                         | 返回当前时间                                      |
| NOW()                             | 返回当前日期和时间                                |
| YEAR(date)                        | 获取指定的date的年份                              |
| MONTH(date)                       | 获取指定的data的月份                              |
| DAY(date)                         | 获取指定的data的日期                              |
| DATE_ADD(date,INTERVAL expr type) | 返回一个日期/时间值加上一个时间间隔expr后的时间值 |
| DATEDIFF(date1,date2)             | 返回起始时间 date1 和 结束时间 date2 之间的天数   |



### 3.4 流程函数

流程函数也是很常用的一类函数，可以在SQL语句中实现条件筛选，从而提高语句的效率

| 函数                                                      | 功能                                                        |
| --------------------------------------------------------- | ----------------------------------------------------------- |
| IF(value,t,f)                                             | 如果value为true，则返回t，否则返回f                         |
| IFNULL(value1,value2)                                     | 如果value不为空，返回value1，否则返回value2                 |
| CASE WHEN [val1] THEN [res1] ...ELSE [default] END        | 如果 val1 为 true，返回res1，...否则返回default默认值       |
| CASE [expr] WHEN [val1] THEN [res1] ...ELSE [default] END | 如果 expr 的值等于 val1，返回res1，...否则返回default默认值 |



## 4 约束

### 4.1 概述

* 概念：约束是作用于表中字段上的规则，用于限制存储在表中的数据

* 目的：保证数据库中数据的正确、有效性和完整性

* 分类：

  | 约束                     | 描述                                                     | 关键字      |
  | ------------------------ | -------------------------------------------------------- | ----------- |
  | 非空约束                 | 限制该字段的数据不能为null                               | NOT NULL    |
  | 唯一约束                 | 保证该字段的所有数据都是唯一、不重复的                   | UNIQUE      |
  | 主键约束                 | 主键是一行数据的唯一标识，要求非空且唯一                 | PRIMARY KEY |
  | 默认约束                 | 保存数据时，如果未指定该字段的值，则采用默认值           | DEFAULT     |
  | 检查约束(8.0.16版本之后) | 保证字段值满足某一个条件                                 | CHECK       |
  | 外键约束                 | 用来让两张表的数据之间建立连接，保证数据的一致性和完整性 | FOREIGN KEY |



### 4.2 约束演示

```sql
create table user (
    id int primary key auto_increment comment '主键',
    name varchar(10) not null unique comment '姓名',
    age int check ( age > 0 && age <= 120 ) comment '年龄',
    status char(1) default '1' comment '状态',
    gender char(1) comment '性别'
)comment '用户表';

insert into user (name, age, status, gender) values ('Tom1',19,'1','男'),('Tom2',25,'0','男');

insert into user (name, age, status, gender) values ('Tom3',19,'1','男');

insert into user (name, age, status, gender) values ('Tom4',80,'1','男');

insert into user (name, age, gender) values ('Tom5',120,'男');
```



### 4.3 外键约束

* 概念：

  外键用来让两张表的数据之间建立连接，从而保证数据的一致性和完整性。

* 语法

  * 添加外键

  ```sql
  CREATE TABLE 表名(
  		字段名 数据类型
  		...
  		[CONSTRAINT] [外键名称] FOREIGN KEY(外键字段名) REFERENCES 主表 (主表列明);
  )
  ```

  ```sql
  ALTER TABLE 表名 ADD CONSTRAINT 外键名称 KEY(外键字段名) REFERENCES 主表 (主表列表);
  ```

  代码演示：

  ```sql
  alter table emp add constraint fk_emp_dept_id foreign key (dept_id) references depy(id);
  ```

  * 删除外键

    ```sql
    ALTER TABLE 表名 DROP FOREIGN KEY 外键名称
    ```

    代码演示：

    ```sql
    ALTER TABLE emp DROP FOREIGN KEY fk_emp_dept_id;
    ```

 

* 删除/更新行为

  | 行为        | 说明                                                         |
  | ----------- | ------------------------------------------------------------ |
  | NO ACTION   | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有则不允许删除/更新。(与RESTRAIN一致) |
  | RESTRAIN    | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有则不允许删除/更新。(与NO ACTION一致) |
  | CASCASE     | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有，则也删除/更新外键在子表中的记录 |
  | SET NULL    | 当在父表中删除对应记录时，首先检查该记录是否有对应外键，如果有则设置子表中该外键值为null(这就要求该外键允许取null) |
  | SET DEFAULT | 父表有变更时，子表将外键列设置成一个默认值(Innodb不支持)     |

```sql
ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段) REFERENCES 主表名 (猪表字段名) ON UPDATE CASCADE ON DELETE CASCADE;
```



## 5 多表查询

### 5.1 多表关系

* 概述：项目开发中，在进行数据库表结构设计时，会根据业务需求及业务模块之间的关系，分析并设计表结构，由于业务之间相互关联，所以各个表结构之间也存在着各种联系，基本上分为3种 ：

  * 一对多(多对一)
  * 多对多
  * 一对一

* 一对多(多对一)

  * 案例：部门与员工的关系
  * 关系：一个部门对应多个员工，一个员工对应一个部门
  * 实现：在多的一方建立外键，指向一的一方的主键

  ![image-20230204191148879](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204191148879.png)

* 多对多

  * 案例：学生与课程的关系

  * 关系：一个学生可以选修多门课程，一门课程也可以供多个学生选择

  * 实现：建立第三张中间表，中间表至少包含两个外键，分别关联两方主键

    ![image-20230204191434965](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204191434965.png)

![image-20230204192802162](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204192802162.png)



* 一对一
  * 案例：用户与用户详情的关系
  * 关系：一对一关系，多用于单表拆分，将一张表的基础字段放在一张表中，其他详情字段放在另一张表中，以提升操作效率
  * 实现：在任意一方加入外键，关联另一方的主键，并且设置外键为唯一的(UNIQUE)

![image-20230204193441164](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204193441164.png)



### 5.2 多表查询概述

* 概述：指从多张表中查询数据
* 笛卡尔积：笛卡尔乘积是指在数学中，两个集合 A集合和B集合的所有组合情况。(在多表查询时，需要消除无效的笛卡尔积)

* 多表查询分类
  * 内连接：相当于查询A、B交集部分数据
  * 外连接：
    * 左外连接：查询左表所有数据，以及两张表交集部分数据
    * 右外连接：查询右表所有数据，以及两张表交集部分数据
  * 自连接：当前表与自身的连接查询，自连接必须使用表别名

![image-20230204213110436](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204213110436.png)

* 子查询



### 5.3 内连接

* 语法：

  * 隐式内连接

  ```sql
  SELECT 字段列表 FROM 表1，表2 WHERE 条件...;
  ```

  * 显式内连接

  ```sql
  SELECT 字段列表 FROM 表1 [INNER] JOIN 表2 ON 连接条件...;
  ```

* 内连接查询的是两张表交集的部分

![image-20230204213110436](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230204213110436.png)

### 5.4 外连接

* 语法

  * 左外连接：查询左表所有数据，以及两张表交集部分数据

    ```sql
    SELECT 字段列表 FROM 表1 LEFT [OUTER] JOIN 表2 ON 条件...;
    ```

    相当于查询表1(左表)的所有数据 包含 表1和表2交集部分的数据

  * 右外连接：查询右表所有数据，以及两张表交集部分数据

    ```sql
    SELECT 字段列表 FROM 表1 RIGHT [OUTER] JOIN 表2 ON 条件...;
    ```

    相当于查询表2(右表)的所有数据 包含 表1和表2交集部分的数据

  

### 5.5 自连接

* 语法：

  ```sql
  SELECT 字段列表 FROM 表A 别名A JOIN 表A 别名B ON 条件...;
  ```

  自连接查询，可以是内连接查询，也可以是外连接查询



### 5.6 联合查询

* 联合查询-union，union all

  对于union查询，就是把多次查询的结果合并起来，形成一个新的查询结果集。

  ```sql
  SELECT 字段列表 FROM 表A ...
  UNION [ALL]
  SELECT 字段列表 FROM 表B;
  ```

  * 对于联合查询的多张表的列数必须保持一致，字段类型也需要保持一致。

  * union all 会将全部的数据直接合并在一起，union 会对合并之后的数据去重。



### 5.7 子查询

* 概念：SQL语句中嵌套SELECT语句，称为嵌套查询，又称子查询

```sql
SELECT * FROM t1 WHERE column1 = (SELECT column1 FROM t2);
```

子查询外部的语句可以是INSERT / UPDATE / DELETE / SELECT 的任何一个

* 根据子查询结果不同，分为：
  * 标量子查询(子查询结果为单个值)
  * 列子查询(子查询结果为一列)
  * 行子查询(子查询结果为一行)
  * 表子查询(子查询结果为多行多列)

* 根据子查询位置，分为：WHERE 之后、FROM之后、SELECT之后。



* 标量子查询：

  * 子查询返回的结果是单个值(数字、字符串、日期等)，最简单的形式，这种子查询称为标量子查询
  * 常用的操作符：=     <>   >   >=   <   <=

* 列子查询

  * 子查询返回的结果是一列(可以是多行)，这种子查询称为列子查询

  * 常用操作符：IN、NOT IN、ANY、SOME、ALL

    | 操作符 | 描述                                   |
    | ------ | -------------------------------------- |
    | IN     | 在指定的集合范围之内，多选一           |
    | NOT IN | 不在指定的集合范围之内                 |
    | ANY    | 子查询返回列表中，有任意一个满足即可   |
    | SOME   | 与ANY等同，使用SOME的地方都可以使用ANY |
    | ALL    | 子查询返回列表的所有值都必须满足       |

  演示：

  ```sql
  select * from emp where salary > any (select salary from emp where dept_id = (select id from depy where name = '研发部'));
  ```

* 行子查询

  * 子查询返回的结果是一行(可以是多列)，这种子查询称为行子查询
  * 常用的操作符： = 、<>、IN、NOT IN

  演示：

  ```sql
  select * from emp where (salary,managerid) = (select salary,managerid from emp where name = '张无忌');
  ```

* 表子查询

  * 子查询返回的结果是多行多列，这种子查询称为表子查询
  * 常用操作符：IN

  ```sql
  select e.*,depy.* from (select * from emp where entrydate > '2006-01-01') e left join depy on e.dept_id = depy.id;
  ```



## 6 事务

### 6.1 事务简介

事务是一组操作的集合，他是一个不可分割的工作单位，事务会把所有的操作作为一个整体一起向系统提交或撤销操作请求，即这些操作要么同时成功，要么同时失败。

![image-20230205154159967](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205154159967.png)

默认MySQL的事务是自动提交的，也就是说，当执行一条DML语句，MySQL会立即隐式地提交事务。



### 6.1 事务操作

* 查看/设置事务提交方式

  ```sql
  SELECT @@autocommit;
  ```

  ```sql
  SET @@autocommit = 0;
  ```

* 提交事务

  ```sql
  COMMIT;
  ```

* 回滚事务

  ```sql
  ROLLBACK;
  ```



* 开启事务

  ```sql
  START TRANSACTION 或 GEGIN;
  ```

* 提交事务

  ```sql
  COMMIT;
  ```

* 回滚事务

  ```sql
  ROLLBACK;
  ```



事务控制可以有两种方式：

* 关闭事务的自动提交，改为手动，通过commit提交以及rollback回滚
* 通过指令start transaction 或 begin 显示地来开启事务，执行成功就commit，失败则rollback.



### 6.2 事务四大特性(ACID)

*  原子性(Atomicity)：事务是不可分割的最小操作单元，要么全部成功，要么全部失败。
* 一致性(Consistency)：事务完成时，必须使所有的数据都保持一致状态。
* 隔离性(Isolation)：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行。
* 持久性(Durability)：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的。



### 6.3 并发事务问题

| 问题       | 描述                                                         |
| ---------- | ------------------------------------------------------------ |
| 脏读       | 一个事务读到另一个事务还没有提交的数据                       |
| 不可重复读 | 一个事务先后读取同一条记录，但两次读取的数据不同，称之为不可重复读 |
| 幻读       | 一个事务按照条件查询数据时，没有对应的数据行，但是在插入数据时，又发现这行数据已经存在，好像出现了”幻影“ |

![image-20230205162048453](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205162048453.png)

![image-20230205162511773](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205162511773.png)

![image-20230205162745180](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205162745180.png)



### 6.4 事务隔离级别

| 隔离级别              | 脏读 | 不可重复读 | 幻读 |
| --------------------- | ---- | ---------- | ---- |
| Read uncommited       | √    | √          | √    |
| Read commited         | ×    | √          | √    |
| Repeatable Read(默认) | ×    | ×          | √    |
| Serializable          | ×    | ×          | ×    |

* 查看事务隔离级别

  ```sql
  SELECT @@TRANSACTION_ISOLATION;
  ```

* 设置事务隔离级别

  ```sql
  SET [SESSION|GLOBAL] TRANSACTION ISOLATION {READ UNCOMMITTED | READ COMMITTED | REPEATABLE READ | SERIALIZABLE}
  ```