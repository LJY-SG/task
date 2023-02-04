

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







