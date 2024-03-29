

# 															 JavaWeb学习笔记



## Java/JavaWeb/Javase的区别和联系

* JavaScript
* javase：

```
就是java基础技术栈，做java相关开发的基础，比如javaweb、javaee开发都是必备javase基础
回顾javase目录基础和知识点
```

* javaweb：

```
使用java开发网站相关技术，比如Servlet、JDBC、Tomcat、Session/Cookie等技术栈，
javaweb里面很多技术，但有部分慢慢被弃用了，比如JSP等技术点企业很少用了

前端基础：HTML、css、js
数据库基础：MySQL

```

* javaee：

```
全称java platform Enterprise Edition，可以构建企业级的面向对象体系结构（Service-oriented architecture,SOA）
微服务，组件等的技术，更多的是框架层面的开发和构建大型应用

主流框架（当然现在还有少数公司用老旧项目）;
```



# 1 JDBC

## 1.1 JDBC 简介

JDBC概念：

* JDBC 就是使用Java语言操作关系型数据库的一套API
* 全称：（Java DataBase Connectivity）Java 数据库连接

![image-20230205205048017](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205205048017.png)



<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230306201824455.png" alt="image-20230306201824455" style="zoom:200%;" />

JDBC 本质：

* 官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口
* 各个数据厂商去实现这套接口，提供数据库驱动jar包
* 我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类
* 提供了一种接口基准，可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序
* 应用程序一般不能直接访问数据库，需要通过相应的数据库驱动程序才行

JDBC 好处：

* 各数据库厂商使用相同的接口，Java代码不需要针对不同数据库分别开发
* 可随时替换底层数据库，访问数据库的Java代码基本不变



* JDBC连接mysql相关概念
  * 数据库驱动：不同数据库开发商(比如Oracle mysql等)为了某一种开发语言能够实现统一的数据库调用而开发的一个程序，作用相当于一个翻译人员，将某个语言(比如java)中对数据库的调用通过这个翻译成各个种类的数据库，自己的数据库语言
  * Connection连接：特定数据库的连接(会话)，在连接上下文中执行sql语句并返回结果
  * Statement 语句：创建执行SQL语句的statement，有好几种实现类，用于执行对应的sql
  * ResultSet结果集：SQL查询返回的结果信息



* 使用java连接MYSQL数据库的步骤
  * 加载JDBC驱动程序
  * 建立数据库连接Connection
  * 创建执行SQL的语句Statement
  * 处理执行结果ResultSet
  * 释放连接资源



## 1.2 JDBC 快速入门

0.创建工程，导入驱动jar包

![image-20230205210452881](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205210452881.png)

1.  注册驱动

   ```java
   Class.forName("com.mysql.jdbc.Driver");
   ```

2.  获取连接

   url基本格式如下:
   连接地址+ssl连接关闭+字符集为utf-8+时区设置

   ```java
   Connection conn = DriverManager.getConnection(url,username,password);
   ```

   演示：

   ```java
   String url="jdbc:mysql://127.0.0.1:3306/itheima?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
   ```

3.  定义SQL语句

   ```java
   String sql = "update...";
   ```

4.  获取执行SQL对象

   ```java
   Statement stmt = conn.createStatement();
   ```

5.  执行SQL

   ```java
   stmt.executeUpdate(sql);
   ```

6.  处理返回结果

7.  释放资源

![image-20230205210423357](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205210423357.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133049532.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133243664.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133311879.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133402377.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021052613344633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133521408.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133557348.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133711591.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1pyaXBlblll,size_16,color_FFFFFF,t_70)

测试代码：

Class.forName("com.mysql.jdbc.Driver");
System.out.println("成功加载MySQL驱动！");
String url = "jdbc:mysql://localhost:3306/mine?useSSL=false";//JDBC的URL
String rootName = "root";
String pwd = "root";

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526133939448.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021052613400024.png)



## 1.3 JDBC API 详解

### 1.3.1 DriverManager

* DriverManager(驱动管理类)作用：
  1. 注册驱动
  2. 获取数据库连接

1. 注册驱动

```
Class.forName("com.mysql.jdbc.Driver");   //可以省略不写
```

* 查看Driver类源码

```
static {
	try{
		DriverManger.registerDriver(new Driver());
	}catch (SQLException var1){
		throw new RuntimeException("can't register driver!");
	}
}
```

提示：

* **MySQL 5 之后的驱动包，可以省略注册驱动的步骤**
* **自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类**

2. 获取连接

```
static Connection      getConnection(String url,String user,string password)
```

* 参数

  1. url连接路径

  ```
  语法:jdbc:mysql://ip地址(域名):端口号/数据库名称?参数键值对1&参数键值对2...
  示例: jdbc:mysql://127.0.0.1:3306/db1
  细节:
  ·如果连接的是本机mysal服务器，并且mysl服务默认端口是3306，则ur可以简写为: jdbcmysal://数据库名称?参数键值对
  ·配置useSSL=false 参数，禁用安全连接方式，解决警告提示
  ```

  2. user：用户名
  3. password：密码



### 1.3.2 Connection

* Connection(数据库连接对象)作用
  1. 获取执行SQL对象
  2. 管理事务

1. 获取执行SQL对象

* 普通执行SQL对象

```
Statement createStatement()
```

* 预编译SQL的执行SQL对象:防止SQL注入

  ```
  PreparedStatement prepareStatement (sql)
  ```

* 执行存储过程的对象

  ```
  CallableStatement prepareCall (sql)
  ```

2. 事务管理功能

* 事务管理功能

```
开启事务: BEGIN;/START TRANSACTION;
提交事务:COMMIT;
回滚事务: ROLLBACK;

MySQL默认自动提交事务
```

* JDBC事务管理：Connection接口中定义了3个对应的方法

```
开启事务: setAutoCommit(boolean autoCommit): true为自动提交事务;false为手动提交事务，即为开启事务
提交事务:commit()
回滚事务: rollback()
```

代码演示：

```java
        //2. 获取连接
        String url="jdbc:mysql:///itheima";
        String username ="root";
        String password ="ljy040226";

        Connection coon = DriverManager.getConnection(url,username,password);
        //3，定义sql
        String sql1 = "update account set money = 3000 where id = 1 ";
        String sql2= "update account set money = 3000 where id = 2 ";
        //4，获取执行sqL的对象 Statement
        Statement stmt = coon.createStatement();

        try {
//            coon.setAutoCommit(false);
            //5，执sql1
            int count1 =stmt.executeUpdate(sql1);//受影响的行数
            //6，处理结果
            System.out.println(count1);
            int i = 3/0;

            //5，执sql2
            int count2 =stmt.executeUpdate(sql2);//受影响的行数
            //6，处理结果
            System.out.println(count2);

            //提交事务
//            coon.commit();
        } catch (Exception e) {
            //回滚事务
//            coon.rollback();

            throw new RuntimeException(e);
        }

        //7，释放资源
        stmt.close();
        coon.close();
```



### 1.3.3 Statement

* Statement作用：
  1. 执行SQL语句
* 执行SQL语句

```
int executeUpdate(sql): 执行DML、DDL语句
6
>返回值:(1)DML语句影响的行数(2)DDL语执行后，执行成功也可能返回0
```

```
ResultSet executeQuery(sql): 执行DQL 语句
1
> 返回值: ResultSet 结果集对象
```



### 1.3.4 ResultSet

* ResultSet(结果集对象)作用：

  1. 封装了DQL查询语句的结果

  ```
  ResultSet stmt.executeQuery(sql): 执行DQL 语句，返回 ResultSet 对象
  ```

* 获取查询结果

```
boolean next():(1)将光标从当前位置向前移动一行(2)判断当前行是否为有效行
>返回值:
·true:有效行，当前行有数据
·false:无效行，当前行没有数据
```

```
xxx getXxx(参数):获取数据
xxx:数据类型;如: int getlnt(参数);String getString(参数)
参数:
·int:列的编号，从1开始
·String:列的名称
```

* 使用步骤：
  1. 游标向下移动一行，并判断该行是否有数据：next()
  2. 获取数据：getXxx(参数)

```
//循环判断游标是否是最后一行末尾
while(rs.next())
//获取数据
rs.getXxx(参数);
}
```

代码演示：

```java
        //2. 获取连接
        String url="jdbc:mysql:///itheima";
        String username ="root";
        String password ="ljy040226";

        Connection coon = DriverManager.getConnection(url,username,password);
        //3，定义sql
        String sql = "select * from account";
        //4，获取执行sqL的对象 Statement
        Statement stmt = coon.createStatement();
        //5，执sql
        ResultSet rs = stmt.executeQuery(sql);//受影响的行数
        //6，处理结果
//        while (rs.next()){
//            //获取数据
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double money = rs.getDouble(3);
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//            System.out.println("------------------");
//        }

        //创建集合
        ArrayList<Account> arr = new ArrayList<>();

        while (rs.next()){
            Account acc = new Account();
            //获取数据
            acc.setId( rs.getInt("id"));
            acc.setName( rs.getString("name") );
            acc.setMoney(rs.getDouble("money"));
            arr.add(acc);
        }
        for (Account a : arr){
            System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getMoney());
        }

        //7，释放资源
        rs.close();
        stmt.close();
        coon.close();

```



### 1.3.5 PrepareStatement

*  PrepareStatement作用：

  1. 预编译SQL语句并执行：预防SQL注入问题

  * 获取 PrepareStatement对象

  ```
  //SQL语句中的参数值，使用? 占位符替代
  String sql = "select * from user where username = ? and password = ?"
  // 通过Connection对象获取，并传入对应的sql语句
  PreparedStatement pstmt = conn.prepareStatement(sql);
  ```

  * 设置参数值

  ```
  PreparedStatement对象: setXxx(参数1，参数2): 给?赋值
  >   Xxx:数据类型; 如setlnt(参数1，参数2)
  参数:
  口 参数1:  ?的位置编号，从1开始
  口 参数2:  ?的值
  ```

  * 执行SQL

  ```java
  executeUpdate(); /executeQuery(); ：不需要再传递sql
  ```

* SQL注入

  * SQL注入是通过操作输入来修改事先定义好的SQL语句，用以达到执行代码对服务器进行攻击的方法
  * 可以执行恶意SQL语句，将任意SQL代码插入数据库查询，使用SQL注入来添加、修改和删除数据库中的记录




* PreparedStatement原理：

  * PreparedStatement 好处：
    1. 预编译SQL，性能更高
    2. 防止SQL注入：将敏感字符进行转义
  * PreparedStatement 预编译功能开启：useServerPrepStmts = true
  * 配置MySQL执行日志(重启mysql服务器后生效)

  ```
  log-output=FILE
  general-log=1
  general log file="D: mysqllog
  slow-query-log=1
  slow_query_log file=“D:mysql slow.log"
  long query time=2
  ```

  * PreparedStatement 原理：

  1. 在获取PreparedStatement对象时，将sql语句发送给mysql服务器
     进行检查，编译(这些步骤很耗时)
  2. 执行时就不用再进行这些步骤了，速度更快
  3. 如果sql模板一样，则只需要进行一次检查、编译

![image-20230206221757832](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230206221757832.png)



### 1.3.6 JDBC控制MYSQL事务

* 事务：
  * 一个最小的不可再分的工作单元，通常一个事务对应一个完整的业务
  * 例如银行账户转账业务，该业务就是一个最小的工作单元
* 四大特性：
  * 原子性(A)：事务是最小单位，不可考核
  * 一致性(C)：事务要求所有的DML语句操作的时候，必须保证同时成功或者同时失败
  * 隔离性(I)：事务A和事务B之间具有隔离性
  * 持久性(D)：是事务的保证，事务终结的标志(内存的数据持久到硬盘文件中)



* 事务的一些术语：
  * 开启事务：Start Transaction
  * 事务结束：End Transaction
  * 提交事务：Commit Transaction
  * 回滚事务：Rollback Transaction

```
//建立数据库连接
ConnectionString username s "root";
String password = "xdclass.net";
//协议:子协议://ip:端口/数据库名称?参数1=值16参数2=值2
String url = "jdbc:mysgl://127.0.0,1:3306/xd web7useUnicode=trueacharacterEncoding=utf-8&useSSL=false";

Connection connection = DriverManagergetConnection(url, username, password);

try( 
Preparedstatement psl = connection.preparestatement("insert into user(username,pwd) value(?,?)");
Preparedstatement ps2 = connection.preparestatement("insert into user(username, pwd) value(?,?)")){

//JDBC中默认事务是自动提交的，false就不会自动提交
psl.setstring("tranc ps 1二当家小D”);
ps1.setstring("123456");

ps2. setstring("tranc ps 2二当家小D“);
ps2. setstring("123456");

psl.execute();

ps2.execute);

} catch (Exception e) {
e.printstackTrace();

//事务回滚
connection.rollback();
} finally {
//事务提交
connection.commit();
connection.close();
}
```





## 1.4 数据库连接池

### 1.4.1 简介

* 数据库连接池是个容器，负责分配、管理数据库连接(Connection)
* 他允许应用程序重复使用一个现有的数据库连接，而不是再重新创建一个
* 释放空闲时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏
* 好处：
  * 资源重用
  * 提升系统响应速度
  * 避免数据库连接遗漏



### 1.4.2 数据库连接池实现

* 标准接口：DataSource

  * 官方(SUN)提供的数据库连接池标准接口，由第三方组织实现此接口
  * 功能：获取连接

  ```
  Connection getConnection()
  ```

* 常见的数据库连接池：

  * DBCP
  * C3P0
  * Druid

* Druid(德鲁伊)

  * Durid连接池是阿里巴巴开源的数据库连接池项目
  * 功能强大，性能优秀，是Java语言最好的数据库连接池之一



### 1.4.3 Durid使用步骤

1. 导入jar包 druid-1.1.12.jar
2. 定义配置文件
3. 加载配置文件
4. 获取数据库连接池对象
5. 获取连接

代码演示：

```java
        //1.导入jar包

        //2.定义配置文件
        
//        3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\JDBC-Demo\\src\\druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
```



## 1.5 JDBC环境准备

完成商品品牌数据的增删改查操作

* 查询：查询所有数据
* 添加：添加品牌
* 修改：根据id修改
* 删除：根据id删除

代码：

```java
     public static void testSelectAll() throws Exception {
   //1.获取Connection
    Properties prop = new Properties();
    prop.load(new FileInputStream("E:\\JDBC-Demo\\src\\druid.properties"));

    //4.获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    //5.获取数据库连接Connection
    Connection conn = dataSource.getConnection();

    //2定义sql语句
    String sql = "select * from tb_brand;";

    //3.获取pstmt对象
    PreparedStatement pstmt = conn.prepareStatement(sql);

    //4.设置参数

    //5.执行sql
    ResultSet rs = pstmt.executeQuery();


    //6.处理结果 List<Brand> 封装Brand对象，装载List集合
    Brand b = null;
    List<Brand> brands = new ArrayList<>();
    while (rs.next()) {
        //获取数据
        int id = rs.getInt("id");
        String companyName = rs.getString("company_name");
        String brandName = rs.getString("brand_name");
        int ordered = rs.getInt("ordered");
        String description = rs.getString("description");
        int status = rs.getInt("status");
        //封装Brand对象
        b = new Brand();
        b.setId(id);
        b.setBrandName(brandName);
        b.setCompanyName(companyName);
        b.setDescription(description);
        b.setOrder(ordered);
        b.setStatus(status);

        //装载集合
        brands.add(b);
    }
    System.out.println(brands);

    //释放资源
    rs.close();
    pstmt.close();
    conn.close();
}

public static void insert() throws Exception {
String brandName = "香飘飘";
String company_Name = "香飘飘";
int ordered = 1;
String description = "绕地球一圈";
int status = 1;

    //1.获取Connection
    Properties prop = new Properties();
    prop.load(new FileInputStream("E:\\JDBC-Demo\\src\\druid.properties"));

    //4.获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    //5.获取数据库连接Connection
    Connection conn = dataSource.getConnection();

    //2定义sql语句
    String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values (?,?,?,?,?);";

    //3.获取pstmt对象
    PreparedStatement pstmt = conn.prepareStatement(sql);

    //4.设置参数
    pstmt.setString(1,brandName);
    pstmt.setString(2,company_Name);
    pstmt.setInt(3,ordered);
    pstmt.setString(4,description);
    pstmt.setInt(5,status);

    //5.执行sql
    int count = pstmt.executeUpdate();

    //6.处理结果
    System.out.println(count>0);


    //释放资源
    pstmt.close();
    conn.close();
}

public static void Update() throws Exception {
    String brandName = "香飘飘";
    String company_Name = "香飘飘";
    int ordered = 1000;
    String description = "绕地球三圈";
    int status = 1;
    int id = 4;

    //1.获取Connection
    Properties prop = new Properties();
    prop.load(new FileInputStream("E:\\JDBC-Demo\\src\\druid.properties"));

    //4.获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    //5.获取数据库连接Connection
    Connection conn = dataSource.getConnection();

    //2定义sql语句
    String sql = "update tb_brand set brand_name = ?,company_name=?,ordered = ? ,description = ? ,status = ? where id = ?;";

    //3.获取pstmt对象
    PreparedStatement pstmt = conn.prepareStatement(sql);

    //4.设置参数
    pstmt.setString(1,brandName);
    pstmt.setString(2,company_Name);
    pstmt.setInt(3,ordered);
    pstmt.setString(4,description);
    pstmt.setInt(5,status);
    pstmt.setInt(6,id);

    //5.执行sql
    int count = pstmt.executeUpdate();

    //6.处理结果
    System.out.println(count>0);

    //释放资源
    pstmt.close();
    conn.close();
}

public static void delete() throws Exception {
    int id = 4;

    //1.获取Connection
    Properties prop = new Properties();
    prop.load(new FileInputStream("E:\\JDBC-Demo\\src\\druid.properties"));

    //4.获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    //5.获取数据库连接Connection
    Connection conn = dataSource.getConnection();

    //2定义sql语句
    String sql = "delete from tb_brand where id = ? ;";

    //3.获取pstmt对象
    PreparedStatement pstmt = conn.prepareStatement(sql);

    //4.设置参数
    pstmt.setInt(1,id);

    //5.执行sql
    int count = pstmt.executeUpdate();

    //6.处理结果
    System.out.println(count>0);

    //释放资源
    pstmt.close();
    conn.close();
}
```



# 2 Maven

* Maven是专门用于管理和构建Java项目的工具，他的主要功能有：
  * 提供了一套标准化的项目结构
  * 提供了一套标准化的构建流程(编译，测试，打包，发布)
  * 提供了一套依赖管理机制
* 标准化的项目结构

Maven提供了一套标准化的项目结构，所有IDE使用Maven构建的项目结构完全一样，所有IDE创建的Maven项目可以通用

![image-20230206222556129](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230206222556129.png)

* 标准化的构建流程

![image-20230208124422012](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208124422012.png)

* 提供了一套依赖管理机制
  * 依赖管理：其实就是管理项目所依赖的第三方资源(jar包、插件...)

![image-20230208124628613](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208124628613.png)

![image-20230208124854775](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208124854775.png)



## 2.1 Maven 简介

* Apache Maven 是一个项目管理和构建工具，它基于项目对象模型(POM)的概念，通过一小段描述信息来管理项目的构建、报告和文档
* 官网：http://maven.apache.org/
* Maven模型：
  * 项目对象模型(Project Object Model)
  * 依赖管理模型(Dependency)
  * 插件(Plugin)

![image-20230208125557627](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208125557627.png)

* 仓库分类：
  * 本地仓库：自己计算机上的一个目录 .m2/repository/
  * 中央仓库：由Maven团队维护的全球唯一的仓库
    * 地址：https://repo1.maven.org/maven2/
  * 远程仓库(私服)：一般由公司团队搭建的私有仓库
    * 中央仓库
    * 私服

![image-20230208145929177](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208145929177.png)



* 添加依赖包后
  * maven检查 pom.xml文件
  * 确定哪些依赖下载
  * 第一步：Maven 将从本地资源库获得 Maven 的本地资源库依赖资源
  * 第二步：如果没有找到，然后把他会从默认的 Maven 中央存储库

<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230308162923287.png" alt="image-20230308162923287" style="zoom:200%;" />



* 当项目中使用坐标引入对应依赖jar包后，首先会查找本地仓库中是否有对应的jar包：
  * 如果有，则在项目直接引用；
  * 如果没有，则去中央仓库下载对应的jar包到本地仓库
* 还可以搭建远程仓库，将来jar包的查找顺序则变为
  * 本地仓库 —> 远程仓库—> 中央仓库



## 2.3 Maven基本使用

### 2.3.1 Maven 常用命令以及目录结构

* src
  * main
    * java - java文件
    * resource - 资源库
    * webapp
      * WEB-INF
        * index.jsp
      * css、js、html等静态文件
  * test
    * java - java测试文件
    * resource - 测试资源库
* target：存放项目构建后的文件和目录，比如jar包，war包，编译的class文件等



* Maven常用命令
  * compile：编译
  * clean：清理项目
  * test：测试
  * package：打包项目
  * mvn dependency:tree 线上maven依赖树
  * install：安装项目到本地仓库
  * install 和 package的区别
    * Maven package只是把包打在自己的项目下
    * maven install 会把包打在maven本地仓库下，可以给依赖他的其他项目调用
* maven常用参数
  * -D 指定参数，-Dmaven.test.skip=true 跳过单元测试
    * maven install -Dmaven.test.skip=true  
  * -p 指定profile配置，用于区分环境
* web项目命令
  * mvn tomcat:run  启动Tomcat



### 2.3.2 Maven生命周期

* 对所有的构建过程进行抽象和统一，包括项目清理、初始化、编译、测试、打包、验证和部署等几乎全部步骤

* Maven构建项目生命周期描述的是一次构建过程经历了多少个事件
* Maven对项目构建的生命周期划分为三套
  * clean：清理工作
  * default：核心工作，例如编译，测试，打包，安装等
  * site：产生报告，发布站点等
* 三个标准生命周期：
  * clean 清理项目
  * build 构建处理项目
    * 验证 validate -> 编译 compile -> 测试 Test -> 包装package -> 检查 verify -> 安装 install -> 部署 deploy
  * site项目文档创建处理



![image-20230208165121166](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208165121166.png)



### 2.3.3 Maven坐标

* 什么是坐标？
  * Maven中的坐标是资源的唯一标识
  * 使用坐标来定义项目或引入项目中需要的依赖
* Maven坐标主要组成
  * groupld：定义当前Maven项目隶属组织名称（通常是域名反写，例如：com.itheima）
  * artifactld：定义当前Maven项目名称（通常是模块名称，例如order-service/goods-service）
  * version：定义当前项目版本号

![image-20230208170211543](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208170211543.png)



### 2.3.4 导入项目

![image-20230208204832862](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208204832862.png)

![image-20230208210350335](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208210350335.png)

![image-20230208210608074](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208210608074.png)



### 2.3.5 依赖管理

使用坐标导入jar包

1. 在pom.xml中编写<dependencies>标签
2. 在<dependencies>标签中使用<dependency>引入坐标
3. 定义坐标的groupld,artifactld,version
4. 点击刷新按钮，使坐标生效

![image-20230208211411410](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208211411410.png)



![image-20230208221026892](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208221026892.png)

![image-20230208221052835](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208221052835.png)



### 2.3.6 依赖管理

* 通过设置坐标的依赖范围(scope),可以设置对应jar包的作用范围：编译环境、测试环境、运行环境

![image-20230208221317877](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230208221317877.png)

* <scope>默认值：compile



2.3.7 Maven核心配置文件pom.xml

* pom.xml文件 

  全称：Project Object Model，项目对象模型，是一个XML文件，包含了项目的基本信息，用于描述项目如何构建，声明项目依赖等

* 一个基础的pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  
  <!-- 模型版本 -->
  <modelVersion>4.0.0</modelVersion>

 <!-- 公司或组织得唯一标志，一般是网站名称反过来写 -->
  <groupId>org.example</groupId>
  
   <!-- 项目的唯一ID，一个groupId下面可能多个项目，就是靠artfactId来区分的 -->
  <artifactId>web02</artifactId>
  
   <!-- 项目版本号 -->
  <version>1.0-SNAPSHOT</version>
  
   <!-- 项目打包形式，常见的是war、jar -->
  <packaging>war</packaging>
  
   <!-- 项目名称 -->
   <name>xd_video</name>
   
    <!-- 项目描述 -->
	<description>Demo project for Spring Boot</description>
    
     <!-- 依赖 -->
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
</dependencies>
```

* 依赖查找地址：https://mvnrepository.com/















# 3 MyBatis

## 3.1 简介

什么是MyBstis？

* MyBatis是一款优秀的持久层框架，用于简化JDBC开发
* MyBatis本是Apache的一个开源项目iBatis，2010年这个项目由apache software foundation 迁移到了google code,并且改名为MyBatis.2013年11月迁移到Github
* 官网：http://mybatis.org/mybatis-3/zh/index.html



持久层

* 负责将数据保存到数据库的那一层代码
* JavaEE三层架构：表现层、业务层、持久层

表现层：做页面展示

业务层：做逻辑处理

持久层：对数据进行持久化，保存到数据库



框架：

* 框架就是一个半成品软件，是一套可重用的、通用的、软件基础代码模型
* 在框架的基础之上构建软件编写更加高效、规范、通用、可拓展



JDBC缺点：

1. 硬编码
   * 注册驱动，获取连接
   * SQL语句
2. 操作繁琐
   * 手动设置参数
   * 手动封装结果集



## 3.2 快速入门

UserMapper.xml文件：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--
    namespace:名称空间
-->
<mapper namespace="test">
    <select id="selectAll" resultType="pojo01.User">
        select * from tb_user;
    </select>
</mapper>
```

mybatis-config.xml文件：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库连接信息-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/itheima?useSSL=false&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="ljy040226"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--加载SQL映射文件-->
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```

class文件：

```
//1.加载mybatis的核心配置文件，获取sqlSessionFactory
String resource = "mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//2.获取sqlSession对象，用他来执行sql
SqlSession sqlSession = sqlSessionFactory.openSession();

//3.执行sql
List<Object> users = sqlSession.selectList("test.selectAll");

System.out.println(users);

//释放资源
sqlSession.close();
```



解决SQL映射文件的警告提示

* 产生原因：Idea和数据库没有建立连接，不识别表信息
* 解决方式：在Idea中配置MySQL数据库连接

![image-20230209140347598](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209140347598.png)



## 3.3 Mapper 代理开发

* 目的
  * 解决原生方式中的硬编码
  * 简化后期执行SQL

![image-20230209141936351](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209141936351.png)

* Mapper代理方式：
  * 定义与SQL映射文件同名的Mapper接口，并且将Mapper接口与SQL映射文件放置在同一目录下
  * 设置SQL映射文件的namespace属性为Mapper接口全限定名
  * 在Mapper接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
  * 编码
    1. 通过SqlSession的getMapper方法获取Mapper接口的代理对象
    2. 调用对应方法完成sql的执行

细节：如果Mapper接口名称和SQL映射文件名称相同，并在同一目录下，则可以使用包扫描的方式简化SQL映射文件的加载

![image-20230209144313677](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209144313677.png)

代码演示：

class文件：

```
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，用他来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
//        List<Object> users = sqlSession.selectList("test.selectAll");
        //3.1获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);

        //释放资源
        sqlSession.close();
```

接口：

```
public interface UserMapper {
    List<User> selectAll();
}
```

UserMapper.xml：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--
    namespace:名称空间
-->
<mapper namespace="mapper.UserMapper">
    <select id="selectAll" resultType="pojo01.User">
        select * from tb_user;
    </select>
</mapper>
```



mybatis-config.xml：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库连接信息-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/itheima?useSSL=false&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="ljy040226"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--加载SQL映射文件-->
       <!-- <mapper resource="mapper/UserMapper.xml"/> -->

        <!--Mapper代理方式-->
        <package name="mapper"/>

    </mappers>
</configuration>
```



## 3.4 MyBatis核心配置文件

![image-20230209150534759](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209150534759.png)







## 3.5 配置文件完成增删改查

* 查询所有数据：

  1. 编写接口方法：Mapper接口			List<Brand> selectAll();

  * 参数：无
  * 结果：List<Brand>                                        <select id = "selectAll" resultType="brand">		

  2. 编写SQL语句：SQL映射文件                                    select * from tb_brand
  3. 执行方法：测试                                                  </select>









# 4 JavaWeb

## 4.1 基本概念

### 4.1.1 C/S架构的概念

* C/S架构（Client/Server，客户端/服务器模式），是一种比较早的软件体系结构，也是生活中很常见的结构，这种结构将需要处理的的业务合理地分配到客户端和服务器端，客户端通常负责完成与用户的交互任务，服务器通常负责数据的管理
* C/S架构的主要优点：
  * 客户端的界面和功能可以很丰富
  * 应用服务器的负荷较轻    （应用服务器：安装在服务器硬件设备上的服务器软件）
  * 响应速度较快
* C/S架构的主要缺点：
  * 适用面窄，用户群固定
  * 维护和升级的成本高，所有的客户端都需要更新版本
  * 缺少通用性，系统维护、升级需要重新设计和开发，增加了维护和管理的难度

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230220091028530.png" alt="image-20230220091028530" style="zoom: 200%;" />



### 4.1.2 B/S架构的概念

* B/S架构（Browser/Server，浏览器/服务器模式），是互联网兴起后的软件体系结构，该结构将系统功能实现的主要业务逻辑集中到服务器端，极少数业务逻辑在浏览器实现，浏览器通常负责完成与用户的交互任务，服务器通常负责数据的管理
* B/S架构的主要优点：
  * 无需安装客户端，只要有浏览器即可
  * 适用面广，用户群不固定
  * 通过权限控制实现多客户访问的目的，交互性较强
  * 维护和升级的成本低，无需更新所有客户端版本
  * 统一了客户端，将系统功能的核心部分集中到服务器上，简化了系统的开发、维护和使用
* B/S架构的主要缺点：
  * 应用服务器的负荷较重
  * 浏览器的界面和功能想要达到客户端的丰富程度需要花费大量的成本
  * 在跨浏览器上不尽人意，适配比较麻烦

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230220091119154.png" alt="image-20230220091119154" style="zoom:200%;" />



### 4.1.3 JavaWeb的概念

* web本意为网页的含义，这里表示互联网上供外界访问的资源
* 互联网上供外界访问的资源主要分为以下两种：
  * 静态资源：主要指web页面中供人们浏览的数据始终是不变
  * 动态资源：主要指web页面中供人们浏览的数据由程序产生，不同时间点访问页面看到的内容各不相同
* JavaWeb主要指使用Java语言进行动态Web资源开发技术的统称，是解决相关Web互联网领域的技术总和
* 早期B/S架构

![image-20230209190509234](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209190509234.png)



### 什么是URL（统一资源定位符，获取服务器资源的一种）

* 标准格式：协议://服务器IP:端口/路径1/路径N? key1=value1 & key2=value2
  * 协议：不同的协议有不同的解析方式
  * 服务器ip：网络中存在无数的主机，要访问哪一台，通过公网ip区分
  * 端口：一台主机上运行着很多的进程，为了区分不同进程，一个端口对应一个进程，http默认的端口是80
  * 路径：资源N多种，为了更进一步区分资源所在路径（后端接口，一般称为“接口路径”，“接口”）



## 4.2 HTTP协议

* ### 协议

  * 协议是一种约定，规定好的一种信息格式，如果发送的方式按照这种请求格式发送信息，那么接收端就要按照这样的格式解析数据，这就是协议
  * json协议

  ```json
  {
  	"name":"jack",
  	"age":23
  }
  ```

  * xml协议

  ```xml
  <xml>
  	<user>
  		<name> jack </name>
  		<age> 234 </age>
  	</user>
  </xml>
  ```

  * http文本传输协议

### 4.2.1 HTTP协议的概念

* HTTP协议（HyperText Transfer Protocol，超文本传输协议）是由W3C（万维网联盟）组织制定的一种应用协议，是用来规范浏览器和web服务器之间如何通讯的数据格式，主要涉及浏览器的发请求格式和服务器的响应格式
* HTTP连接最显著的特点是客户端发送的每次请求都需要服务器回送响应，从建立连接到关闭连接的过程，称为”一次连接“
* HTTP协议通常承载于TCP协议之上，再承载于TLS或SSL协议层之上的协议就是常说的HTTPS协议
* HTTP默认的端口号为80，HTTPS默认的端口号为443

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209192131568.png" alt="image-20230209192131568" style="zoom:150%;" />

* 响应码：
  * 1xx：信息 
  * 2xx：成功 200 OK，请求正常
  * 3xx：重定向
  * 4xx：客户端错误404 Not Found   服务器无法找到被请求的页面
  * 5xx：服务器错误503 Service Unavailable，服务器挂了或者不可用
* 和HTTPS的关系：
  * Hyper Text Transfer Protocol over SecureScoket Layer
  * 主要由两部分组成：HTTP + SSL / TLS
  * 比HTTP协议更安全，可防止数据在传输过程中不被窃取、改变、确保数据的完整性，增加破解成本
  * 缺点：相同网络环境下，HTTPS协议会使页面的加载时间延长近50%，增加额外的计算资源消耗，增加10%到20%的耗电等；不过利大于弊，所以HTTPS是趋势，相关资源损耗也在持续下降
  * 如果做软件压测：直接压测内网ip，通过压测公网域名，不管是HTTP还是HTTPS，都会带来额外的损耗导致结果不精确



### 4.2.2 HTTP请求格式

*  客户端发送一个HTTP请求到服务器的请求消息主要包括：请求行、请求头、空白行、请求体
   * 请求行：
     * 请求方法
     * URL地址
     * 协议名
   * 请求头：
     * 报文头包含若干个属性 格式为“属性名：属性值”,
     * 服务端据此获取客户端的基本信息
   * 请求体：
     * 请求的参数，可以是json对象，也可以是前端表单生成的key=value & key=value的字符串

```
请求行用来说明请求类型和要访问的资源以及所使用的HTTP版本，格式如下：
	请求类型 请求的路径 协议的版本(1.1)
请求头是紧接着请求行（即第一行）之后的部分，用来说明服务器要使用的附加信息，格式(key:value)如下：
	主机 请求长度 请求的浏览器相关信息
空白行就是请求头部的空行，即使后面的请求数据为空则必须有空行

请求体也叫请求数据，可以添加任意的其他数据
```

* 举例：

```
"posT /task01_deso01/de-ot.html HTTP/1.1     //请求行
Host: localhost;8088
Content-Length:21
Cache-Control: max-age=0
User*Agent : Mozi11a/5.0 (windaw NT 6.1: WOW64)
												//空白行
name = scott&pwd-123456                    //请求体
```



### 4.2.3 HTTP响应格式

* 通常情况下服务器接收并处理客户端发过来的请求后会返回一个HTTP的响应消息，主要包括：响应行、响应头、空白行、响应体

  * 响应行：
    * 报文协议及版本、状态码
  * 响应头：
    * 报文头包含着若干个属性 格式为“属性名：属性值”
  * 响应正文：
    * 响应报文体，我们需要的内容，多种形式比如html，json，图片，视频文件等

  ```
  响应行用未说明HTTP协议版本号和状杰码以及状态消息，格式如下：
  	协议的版本(1.01) 状态码 (200 成功 404 路径错误 500 般务错误)状态信息
  响应头用来说明含户续要使用的一些附加信息，格式(key:value)
  空白行就是响应头部的空行，即快后面的请求数据为空则必须有空行。
  
  响应体用来服务器返回给客户端的文本信息。
  ```

* 举例如下：

```
HTTP/1.1 200 0K				//响应行
Content-Type: text/htm1
Content-Length:588
Date: Thu，08 Sep 2021 12:59:54 GMT
												//空白行
<html><head><title>示例1</title></head>
<body><h1>这是一个HTML页面</h1></body>>
</htm1>
```



### 4.2.4 HTTP请求方法

* http 1.0定义了三种：
  * GET：向服务器获取资源，比如常见的查询请求
  * POST：向服务器提交数据而发送的请求
  * Head：和get类似，返回的响应中没有具体的内容，用于获取报头
* http 1.1 定义了六种：
  * PUT：一般是用于更新请求，比如更新个人信息、商品信息全量更新
  * PATCH：PUT方法的补充，更新指定资源的部分数据
  * DELETE：用于删除指定的资源
  * OPTIONS：获取服务器支持的HTTP请求方法，服务器性能，跨域检查等
  * CONNECT：方法的作用就是把服务器作为跳板，让服务器代替用户去访问其他网页，之后把数据原原本本地返回给用户，网页开发基本不用这个方法，如果是HTTP代理就会使用这个，让服务器代理用户去访问其他网页，类似中介
  * TRACE：回显服务器收到的请求，主要用于测试或诊断



### 4.2.5 HTTP常见响应状态码

* 浏览器向服务器请求时，服务端响应的消息头里面有状态码，表示请求结果的状态

* 分类：

  * 1xx：收到请求，需要请求者继续执行操作，比较少用

  * 2xx：请求成功，常用的200

  * 3xx：重定向，浏览器在拿到服务器返回的这个状态码后会自动跳转到一个新的URL地址，这个地址可以从响应的Location首部中获取：

    * 好处：网站改版、域名迁移等，多个域名指向同一个主站导流

    * 必须记住：

      301：永久性跳转，比如域名过期，换个域名

      302：临时性跳转

  * 4xx：客服端出错，请求包含语法错误或者无法完成请求

    * 必须记住：

      400：请求出错

      403：没有权限访问

      404：找不到这个路径对应的接口或者文件

      405：不允许此方法进行提交，Method not allowed，比如接口一定要POST方式，而你是用了GET

  * 5xx：服务器出错，服务器在处理请求的过程中发生了错误

    * 必须记住：

      500：服务器内部报错了，完成不了这次请求

      503：服务器宕机



### 4.2.5 http请求头

* http请求分为三部分：请求行，请求头，请求体

* 请求头：

  * 报文头包含若干个属性 格式为“属性名：属性值”，
  * 服务端据此获取客户端的基本信心

* 常见的请求头：

  * **Accept**：浏览器支持的MIME媒体类型，比如text/html,application/json,imgage/web0./等

  * Accept-Encoding：浏览器发给服务器，声明浏览器支持的编码类型：gzip，deflate

  * Accept-Language：客户端接受的语言格式，比如zh-CN

  * **Connection**：Keep-alive，开启http持久连接

  * Host：服务器的域名

  * **Origin**：告诉服务器请求从哪里发起的，仅包括协议和域名

    CORS跨域请求中可以看到response有对应的header，Access-Control-Allow-Origin 

  * **Referer**：告诉服务器请求的原始资源的URL，其用于所有类型的请求，并且包括：协议+域名+查询参数；很多抢购服务会用到这个做限制，必须通过某个入来进来才有效

  * User-Agent：服务器通过这个请求头判断用户的软件的应用类型、操作系统、软件开发商以及版本号、浏览器内核信息等；

    风控系统、反作弊系统、反爬虫系统等基本会采集这类信息做参考

  * **Cookie**：表示服务器给客户端传的http请求状态，也是多个key=value形式组合，比如登录后的令牌等

  * **Content-Type**：http请求提交的内容类型，一般只有post提交时才需要设置，比如文件上传，表单提交等

  

### 4.2.6 http响应头

* 响应头
  * 报文头包含若干个属性 格式为“属性名：属性值”
* 常见的响应头
  * Allow：服务器支持哪些技术
  * Content-Length：响应体的字节长度
  * Content-Type：响应体的MIME类型
  * Content-Encoding：设置数据使用的编码类型
  * Date：设置消息发送的日期和时间
  * Expires：设置响应体的过期时间，一个GMT时间，表示该缓存的有效时间
  * cache-control：Expires的作用一致，都是指明当前资源的有效期，控制浏览器是否直接从浏览器缓存取数据库还是重新发送请求到服务器取数据，优先级高于Expires，控制粒度更细，如max-age=240，即4分钟
  * Location：表示客户应到哪里去获取资源，一般同时设置状态代码为3xx
  * Server：服务器名称
  * Transfer-Encoding：chunked 表示输出的内容长度不能确定，静态网页一般没，基本出现在动态网页里面
  * Access-Control-Allow-Origin：定哪些站点可以参与跨站资源共享



### 4.2.7 HTTP里的content-type媒体类型

* content-type：用来指定不同格式的请求响应信息，俗称MIME媒体类型
* 常见的取值：
  * text/html：HTML格式
  * text/plain：纯文本格式
  * text/xml：XML格式
  * img/gif：gif图片格式
  * img/jpg：jpg图片格式
  * img/png：png图片格式
  * application/json：JSON数据格式
  * application/pdf：pdf格式
  * application/octet-stream：二进制流数据，一般是文件下载
  * application/x-www-form-urlencoded：form表单默认的提交数据的格式，会编码成key=value格式
  * multipart/form-data：表单中需要上传文件的文件格式类型
  * HTTP知识加深文档：https://developer.mozilla.org/zh-CN/docs/Web/HTTP



## 4.3 Tomcat服务器

* 什么是服务器？
  * 远程的一个电脑，里面安装服务器程序监听对应的端口对外提供服务，可以根据用户的请求去获取对应的数据并返回给调用方
  * 我们说的Web服务器和应用服务器是指服务器电脑上安装的软件

```
Web服务器和应用服务器是有很大的交集，没有很严格的区别，更多的是Web服务器处理的是http协议，应用服务器还可以处理其他协议

web服务器：Apache、IIS、Nginx

应用服务器：Tomcat、Jboss
```



### 4.3.1 基本概念

* Tomcat本意为公猫的含义，最初由Sun公司的软件架构师詹姆斯·邓肯·戴维森开发的，后来他帮助将其变为开源项目并由Sun公司贡献给Apache软件基金会
* Tomcat服务器是一个开源的轻量级Web应用服务器，在中小型系统和并发量小的场合下被普遍使用，是开发和调试Servlet、JSP程序的首选

### 4.3.2 安装方式

* 下载地址：http://tomcat.apache.org/



### 4.3.3 目录结构

* bin                    主要存放二进制可执行文件和脚本。

```
启动和关闭Tomcat脚本
startup.sh/startup.bat
shutdown.sh/shutdown.bat
```

* conf                  主要存放各种配置文件。

```
存放配置文件
server.xml:配置整个服务器信息 比如修改端口号，添加虚拟机
```

* lib                     主要用来存放Tomcat运行需要加载的jar包。

```
存放Tomcat运行需要的第三方包，这个目录中的jar所有项目都可以共享
如果需要添加Tomcat都依赖的jar文件，可以把它放到这个目录中
```

* logs                  主要存放Tomcat在运行过程中产生的日志文件

```
运行的相关日志文件，Tomcat启动和关闭的信息，如果启动Tomcat时有错误
Catalina.out运行日志文件，即标准输出和标准出错，也包含Tomcat运行自己输出的日志以及应用里向console输出的日志
```

* temp                主要存放Tomcat在运行过程中产生的临时文件，
* webapps         主要存放应用程序，当Tomcat启动时会去加载该目录下的应用程序

```
Tomcat的主要web发布目录，存放web项目，其中每一个文件夹都是一个项目
其中ROOT是一个特殊的项目，在地址栏中没有给出项目目录时，对应的就是ROOT项目
```

* work                主要存放tomcat在运行时的编译后文件，例如ISP编译后的文件

一个网站只能监听一个端口，如果端口已经在使用了，再次使用会报Address already in use的错误



### 4.3.4 启动和关闭

* 启动方式
  使用bin目录下的批处理文件startup.bat米启动Tomcat服务器，若出现一个套秒数说明启动成功

* 关闭方式
  使用bin目录下的批处理文件shutdown.bat来关闭Tomcat服务器。

* 注意事项
  启动之前首先安装]DK并配置环境变量JAVA HOME，若希望Tomcat服务器可以在任意路径启动，则需要配置环境变量CATALINA_HOME。

  启动信息乱码的处现方式:loggingproperties文件修改为avautil.logging.ConsoleHandlerencoding=GBK

* 访问(http://localhost:8080/)



### 4.3.5 配置文件

* serverxml文件是服务器的主配置文件，可以设置端口号、设置域名或IP、默认加载的项目、请求编码等。

```
<Connector port="8888” protocol="HTTP/1.1"
		connectionTimeout="20000"
		redirectport="8443”/>
```

* tomcat-user.xml文件用来配置管理Tomcat服务器的用户与权限

```
<role rolename="manager-gui"/>
<user username="admin" password="123456" roles="manager-gui"/>
```



### 4.3.6 Tomcat服务器中项目的部署

1. 在webapps下新建文件夹，里面存放动态资源或静态文件
2. 默认访问root目录



### 4.3.7 IDEA创建Web项目的方式

参考：[(3条消息) IntelliJ IDEA创建maven web项目（IDEA新手适用）_小跟班大智慧的博客-CSDN博客](https://blog.csdn.net/czc9309/article/details/80304074)

![image-20230221172659585](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230221172659585.png)

![image-20230221172759101](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230221172759101.png)

![image-20230209222154070](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209222154070.png)

![image-20230209222222810](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230209222222810.png)



# 5 Servlet

## 5.1 基本概念：

* 简介：是JavaServie的简称，用java编写的运行在Web服务器或应用服务器上的程序，具有独立于平台和协议的特性，主要功能在于交互地浏览和生成动态web内容
* 作用：接收用户通过浏览器传来的表单数据，或者读取数据库信息返回给浏览器查看，创建动态网页
* 接口路径：package javax.servlet
* 有两个常见的子类：HttpServlet、GenericServlet
* javaweb Servlet文档：https://tomcat.apache.org/tomcat-9.0-doc/servletapi/index.html
* 创建一个Servlet程序



Maven导入servlet-api的jar包

```
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-web-api</artifactId>
    <version>7.0</version>
    <scope>provided</scope>
</dependency>
```

1. 创建class，继承HttpServlet
2. 重写doGet方法，返回HTML内容

```java
public class TestServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应实战内容
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter= resp.getWriter();

        printWriter.write("<div> 小滴课堂 xdclass.net 你好，让技术不再难学 </div");
    }
}
```

3. 配置web.xml

```xml
  <servlet>
    <servlet-name>testServlet01</servlet-name>
    <servlet-class>TestServlet01</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>testServlet01</servlet-name>
    <url-pattern>/testServlet01</url-pattern>
  </servlet-mapping>
```

4. 启动Tomcat，进行访问



## 5.2 重写doGet和doPost方法作用

* doGet方法：

  * http用get方式提交的请求就会进入到此方法

* doPost方法：

  * http用post方式提交的请求就会进入到此方法
  * postman工具：
    * 作用：专门用来模拟Http多种方式提交的工具，开发测试必备利器
    * 提供安装包直接安装使用
    * 选择post方式提交

* 还有其他的doHead、doDelete等，一样的都是根据http提交Method来区分

* Servlet访问URL使用路径映射（注意：一定要加 / 开头）

  * url-pattern：以"/"开头，可以用/ xxx* /来区分模块，*是通配符，最好用模块区分，防止通配符都映射成

    但不同优先级导致问题



## 5.3 Servlet生命周期

* Servlet 接口里面有5个方法，其中三个生命周期方法和两个普通方法
  * 实例化 -> 使用构造方法创建对象
  * 初始化 -> 执行init方法：Servlet 的生命周期中，仅执行一次init()方法，它是在服务器装入Servlet 时执行的，即第一次访问这个Servlet才执行
  * 服务 -> 执行Service方法，service() 方法是Servlet 的核心，每当一个客户请求一个HttpServlet 对象，该对象的service()方法就要被调用
  * 销毁 -> 执行destroy() 方法仅执行一次，即在服务器停止且卸装 Servlet 时执行该方法

第一次启动Tomcat会调用init方法初始化，后续不管多少次请求都会调用我们的service方法，最后Tomcat终止之后就会调用destroy方法

```
    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet init");
    }
```

* 查看继承和实现关系 XXXServlet -> HttpService -> GenericServlet -> implements Servlet

* HttpServlet里面实现了service方法，里面会根据不同的http method调用不同的方法，所以我们自定义servlet只要重写对应的doXXX方法即可



5.4 新版Servlet和旧版Servlet配置的区别

* 旧版Servlet，在XML里面配置类目和路径，比较不方便
* 新版Servlet，也就是3.0之后，支持注解的方式

```java
@WebServlet(name = "testServlet01",urlPatterns = {"/user1","/user2","/testServlet01"})
```



* 配置项：

```java
//Servlet 名称，若不确定，则为Servlet的完整类名
String name() default "";

//路径映射，配置多个，需要/开头
String [] value() default{};

//路径映射，支持配置多个，需要/开头
String[] urlPatterns() default {};

//标记容器是否在启动应用时就加载Servlet，默认或数值为负数时表示第一次请求Servlet时再加载；0或正数表示启动应用或加载
int loadOnStartup() default -1;

//配置初始参数
WebInitParam[] initParams() default{};

//是否支持异步操作模式
boolean asyncSupported() default false;
```



# 6 应用上下文和JSP核心知识

## 6.1 JavaWeb作用域对象介绍和ServletContext

* 什么是作用域对象？
  * 就是对象的生命周期，在javaweb开发里面有多个不同生命周期的对象
  * 比如：PageContext，ServletRequest、HttpSession，ServletContext;
  * 对象里面包含属性和对应的数据，所以不同作用域对象使用场景会不同



* ServletContext：

  * 它代表了Servlet环境的上下文，相当于一个全局存储空间
  * 同一个WEB应用程序中，所有的Servlet和JSP都可以共享同一个区域，是最大的作用域对象(webapps下的每个目录就是一个应用程序)

  <img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230222160620114.png" alt="image-20230222160620114" style="zoom:200%;" />

  * 四大作用域对象-用于存取数据(举个形象的例子)：
    * PackageContext(页面) -> ServletRequest(请求) -> HttpSession(会话) -> [ServletContext] (应用)：
  * 生命周期：在WEB服务器启动时创建，服务器关闭时销毁



* 加载应用默认参数
  * web.xml

```java
  <context-param>
    <param-name>url</param-name>
    <param-value>xdclass.net</param-value>
  </context-param>

  <context-param>
    <param-name>username</param-name>
    <param-value>jack</param-value>
  </context-param>
```

* 获取api

```java
       ServletContext servletContext = req.getServletContext();
        String url = servletContext.getInitParameter("url");
        System.out.println(url);

        servletContext.setAttribute("TestServlet appInfo","xdclass.net info");
```

* 存储全局数据（只要是同一个应用，都可以共享这些数据，类似map结构）

```java
servletContext.setAttribute("TestServlet appInfo","xdclass.net info");


        String appInfo = (String)servletContext.getAttribute("appInfo");
        System.out.println("appInfo="+appInfo);
```



## 6.2 JSP与Servlet的关系

* 什么是JSP：全称java Server Pages，是一种动态网页技术：
  * 使用JSP标签在HTML网页中插入java相关代码，标签通常以<%开头 以%>结束
  * JSP本身就是一种**Servlet**，JSP在第一次被访问的时候会被编译为HttpJspPage类，是HttpServlet的一个子类
  * 为什么用这个：和原生的Servlet相比JSP可以很方便的编写HTML网页而不去大量的用println语句输出html代码
  * 通俗来说：JSP就是在html里面写java代码，servlet就是在java里面写html代码
* 添加jsp-api-jar到项目里，和添加servlet-api-jar一样的步骤
* JSP内置了9个对象可以直接调用（先简单知道就行）：out、session、response、request、config、page、application、pageContext、exception

```
request	 HttpServletRequest类的实例

response 	HttpServletResponse类的实例

out 	PrintWriter类的实例，用于把结果输出至网页上

session 	HttpSession类的实例

application 	ServletContext类的实例，与应用上下文有关

config	 ServletConfig类的实例

pageContext	 	PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问

page 	java类中的this关键字

Exception	 Exception类的对象，代表发生错误的JSP页面中对应的异常对象  
```

* JSP脚本程序

  <% 代码片段 %>

```
<%
out.println("IP address is"+request.getRemoteAddr());
%>
```



* JSP表达式的语法格式：（不能用分号结束）

<%=表达式 %>

```
<%=request.getRequestURL()%>
```



* 中文编码问题，顶部添加这些信息（部分）

```
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
```

```java
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>

<body>
<div>小滴课堂</div>
<div>
    <%
        out.println("getRequestURL " + request.getRequestURL());
        out.println("xdclass.net ");
    %>
</div>
</body>
</html>
```



# 7 Http请求

## 7.1 HttpServletRequest 请求对象

* 怎样添加servlet-api源码
  * 下载：[Apache Tomcat® - Apache Tomcat 8 Software Downloads] (https://tomcat.apache.org/download-80.cgi)，选择Source Code Distribution
  * 添加：解压包，然后idea选择chose source code，选择java这层包就行
* HttpServletRequest对象
  * 简介：代表浏览器客户端的请求，当客户端通过HTTP协议访问服务器时，HTTP请求中的所有信息都封装在这个对象中，通过这个对象提供的方法可以获得请求的所有信息
  * 查看源码和类继承结构
* API测试：

```java
//http://127.0.0.1:8080/request?userName=jack&age=11&sport=ball&sport=sleep 
//客户端请求信息
System.out.println(“应用上下文路径getContextPath=“ + request.getContextPath());
 
 System.out.println("客户端发出请求时的完整URL, getRequestURL=" + request.getRequestURL());
 
System.out.println("请求行中的资源名部分 getRequestuRI="+request.getRequestURI());

System.out.println("请求行中的参数部分 getQuerystring=" + request.getQueryString());

System.out.println("发出请求的客户机的IP地址 getRemoteAddr=" + request.getRemoteAddr());

System.out.println("客户机发请求使用的网络端口号 getRemotePort=" + request.getRemotePort());

//获取请求头
System.out.println("获取请求头 getHeader(Accept)=" + request.getHeader(“Accept"));

//获取请求参数
System.out.println("客户端请求参数 getParameter=" + request.getParameter("userName"));

String[] sport = request.getParameterValues("sport");

System.out.println("客户端请求参数列表,多个值 getParametervalues=" + sport.tostring());

Map<string,String[]> map = request.getParameterMap();

System.out.println("客户端请求参数封装成的map类型 getParameterMap=" + map.toString());
```



* 四大作用域对象：PageContext -> [ServletRequest] -> HttpSession -> ServletContext；

```
//ServletRequest作用域:对象生命周期存在一次请求里面
//存储java对象到request作用域
request.setAttribute("name","jack");
```



## 7.2 HttpServletRequest和用户登录表单提交

* 使用jsp编写form表单提交
* UserServlet，doPost里面调用doGet

```java
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");

        if (userName.equals("xdclass") && pwd.equals("123")){
            resp.getWriter().write("登录成功");
        }else {
            resp.getWriter().write("账号密码错误");
        }
    }
```

```html
<body>
<div>小滴课堂</div>
    <form action="/test01/login" method="post">
        <div>用户名:<input type="text" name="userName"/></div>
        <div>密码:<input type="password" name="pwd"/></div>
        <div> <input type="submit" value="登录"> </div>
    </form>
</body>
```



* 关于乱码问题：

```
//POST方式遇到中文版，如果客户端是以UTF-8字符编码，需要服务器以UTF-8的代码接收数据
req.setCharacterEncoding("UTF-8");

//对于以get方式传输的中文乱码需要另外一种方式，默认的还是使用ISO8859-1这个字符编码来接收数据
//办法：对接收到的原始数据的字节数组，然后通过字节数组以指定的编码构建字符串解决乱码问题

String name = request.getParameter("name"); //接收数据

name = new String(name.getBytes("ISO8859-1"),"UTF-8");
```



* 乱码问题解决的核心：通过字节数组以指定的编码构建字符串，这里指定的编码是根据客户端那边提交数据时，使用字节编码来定



## 7.3 HttpServletResponse对象

* HttpServletResponse对象

  简介:代表服务器的响应，封装了向客户端发送数据、发送响应头，发送响应状态码的方法

* 常见API：

```
//设置有多个值的http响应头，参数name表示响应头名称，参数value表示响应头的值，
//比如:response.addHeader("name","java");response.addHeader("xxx","spring");
addHeader(String name,String value);

//设置只有一个值的http响应头，参数name表示响应头名称，参数value表示响应头的值
setHeader(String name,String value)

//设置http状态码
response.setStatus(200);
```



* getOutputStream()：
  * 创建的字节输出流对象，可以按字节形式输出响应正文，直接输出字节数组中的二进制数据,更多用于下载输出文件流

```
//设置编码格式为UTF-8

response.setCharacterEncoding("uTF-8");

//通过设置响应头控制浏览器以UTFE-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
response.setHeader("content-Type”,"text/html;charset=utf-8”);

String data=”小滴课堂java高级工程师成长系列”;

//获取Outputstream输出流
OutputStream outputStream = response.getOutputStream();
//将字符转换成字节数组，指定以UTF-8编码进行转换
byte[] dataByteArr = data.getBytes("UTF-8”)

//使用Outputstream流向客户端输出字节数组
outputStream.write(dataByteArr);
```

代码演示：

```java
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setCharacterEncoding("UTF-8");

//        resp.addHeader("name","java");
//        resp.addHeader("name","spring");
//        resp.setHeader("age","23");
//        resp.setStatus(200);
        //设置响应头为utf-8，不然浏览器会显示乱码
        resp.setHeader("Content-Type","text/html;charset=utf-8");

        String data = "小滴课堂java高级工程师成长系列";

        OutputStream outputStream = resp.getOutputStream();

        byte[] bytes = data.getBytes("utf-8");

        outputStream.write(bytes);
    }
```



* getWriter()：
  * 创建的字符输出流对象，可以按字符形式输出响应正文，只能输出字符文本内容，和上面的互斥

```java
//设置编码格式为UTF-8
response.setCharacterEncoding("UTF-8");

//通过设置响应头控制浏览器以utf-8的编码显示数据，如果不加这句话，那么浏览器显示的将会是乱码
response.setHeader("content-Type","text/html;charset=utf-8");
String data = "小滴课堂java高级工程师成长系列";

//获取PrintWriter输出流
PrintWriter writer = resp.getWriter();

//使用PrintWriter流向客户端输出字符
writer.write(data);
```



# 8 转发-重定向和EL表达式

## 8.1 请求转发RequestDispatcher

* 什么是请求转发：

  ```
  request.getRequestDispatcher(URL地址).forward(request,response);
  ```

  * 客户端发送请求，Servlet做出业务逻辑处理
  * Servlet调用forward()方法，服务器Servlet把目标资源返回给客户端浏览器
  * 可以访问WEB-INF下的文件，WEB-INF的文件一般是需要一定的权限才可以访问
  * 例子：req.getRequestDispatcher("//WEB-INF/admin/admin.jsp").forward(req,resp);



* 注意点：在浏览器地址栏中不会显示出转发后的地址，属于服务器内部转发，整个过程处于同一个请求当中，所以转发中数据的存取可以用request作用域

```java
//存储java对象到request作用域，转发后一样可以获取到值，具体怎么获取？JSP或者EL表达式
request.setAttribute("name","jack");
```



## 8.2 EL表达式-让JSP访问JavaBean中的数据更简单

* 什么是EL表达式：全称Expression Language，让JSP写起来更加简单，表达式语言的灵感来自于ECMScript 和 XPath 表达式语言，它提供了在JSP中简化表达式的方法，让JSP的代码更加简化
* 在要使用EL表达式的jsp中加入  <%@ page isELIgnored="false" %>    ,加在顶部
* 语法：

```
EL表达式的格式都是以${ }表示，例如$ {userinfo}代表获取量userinfo的值，$(对象，属性)，可以有多层操作

当EL表达式中的变量不给定范围时，则默认在page范围查找，然后依次在request、session、application范围查找，如果找不到不再继续找下去，但是假如全部的范围都没有找到时，就回传""

可以用范围作为前缀表示属于那个范围的变量，例如：$(pageScope.userinfo)表示访问page范围中的userinfo变量
```

* 属性范围在EL中的名称

```
【jsp中】		【EL表达式中】
 page			pageScope
 
 request 		requestScope
 
 Session		sessionScope
 
 Application	applicationScope
```

* 对比：

```
jsp name = <%= (String) request.getAttribute("name")%>
<hr>
el name = ${name}
```

* 案例：在request中设置值，然后在请求转发到页面，使用EL表达式取值

```
//        req.setAttribute("name","xdclass");
        User user = new User();
        user.setHost("https://xdclass.net");
        user.setId(1);
        user.setName("老王");
//        req.setAttribute("user",user);

        req.setAttribute("name","jack");

        req.getRequestDispatcher("index.jsp").forward(req,resp);
        
        
        
name = ${user.name}
<hr>
id = ${user.id}
<hr>
host = ${user.host}
```



## 8.3 请求重定向

* 什么是请求重定向
  * 客户端发送请求，Servlet做出业务逻辑处理
  * Servlet调用response.sendRedirect("xxx.jsp")方法，把要访问的目标资源作为response响应信息发给客户端浏览器
  * 客户端浏览器重新访问服务器资源xx.jsp，服务器再次对客户端浏览器做出响应
  * 请求重定向，不能访问WEB-INF下的文件，浏览器上的窗口地址会改版，可以用于跳转第三方地址或者应用里面其他Servlet、jsp等
  * 例子：response.sendRedirect("WEB-INF/admin.jsp");
* 注意点：
  * 重定向是取不到request中的存储的数据，如果当前servlet是重定向，浏览器可以看到两个请求
    * 案例测试：在request中设置值，然后在请求转发到页面，使用EL表达式取值
  * 调用sendRedirect()方法，会在响应中设置Location响应报头，这个过程对于用户来说是透明的，浏览器会自动完成新的访问
  * 重定向路径问题：如果没有加http开头，则认为是当前应用里面的servlet重定向，默认加上应用上下文：如果有加http则会使用配置的全路径进行跳转
  * 如果请求转发可以满足需要时，尽量使用请求转发，而不是重定向，效率性能更好 



# 9 cookie和session

## 9.1 cookie

* cookie介绍：

  * 背景：HTTP协议是无状态协议，无状态指每次request请求之前是相互独立的，当前请求并不会记录它的上一次请求信息

    存在这样的问题，既然无状态，那完成一套完整的业务逻辑，需要发送多次请求，那么怎么标识这些请求都是同一个浏览器操作呢？

  * 解决方案：

    * 浏览器发送request请求到服务器，服务器除了返回请求的response之外，还给请求分配一个唯一标识ID和response一并返回给浏览器

    * 服务器在本地创建一个map结构，专门以key-value存储这个ID标识和浏览器的关系

    * 当浏览器的第一次请求后已经分配一个ID，当第二次访问时会自动带上这个标识ID，服务器会获取这个标识ID去map里面找上一次request的信息状态且做对应的更新操作

      服务端生成这个全局的唯一标识，传递给客户端用于标记这次请求就是cookie

      服务器创建的那个map结构就是session

    * cookies由服务端生成，用于标记客户端的唯一标识，在每次网络请求中，都会被传送

    * session服务端自己维护的一个map数据结构，记录key-Object上下文内容状态

    * 核心：它用于告知服务端两个请求是否来自同一浏览器，如保持用户的登录状态。Cookie使基于无状态的HTTP协议记录稳定的状态信息成为了可能。

      浏览器查看多个站点的cookie



* cookie的属性：
  * Name：名称
  * Value：值
  * Domain：表示当前cookie所属于哪个域或子域下面
  * Expires/Max-age：表示了cookie的有效期，是一个时间，过了这个时间，该cookie就失效了
  * Path：表示cookie的所属路径
  * size：大小，多数浏览器都是4000多个字节
  * http-only：表示这个cookie不能被客户端使用js读到，是不公开的cookie
    * (chrome 调试器的 console 中输入 document.cookie 将得不到标记为 HttpOnly 的字段)
  * secure：标记为 Secure 的 Cookie 只应通过被HTTPS协议加密过的请求发送给服务器，从Chrome 52 和 Firefox 52 开始，不安全的站点（http:）无法使用Cookie的 Secure 标记
  * SameSite(特有的，可以忽略)



* Cookie的缺陷：
  * cookie会被附加在每一个HTTP请求中，增加了流量
  * 在HTTP请求中的cookie是明文传递的，所以安全性成问题，除非用HTTPS
  * Cookie的大小有限制，对于复杂的存储需求来说不满足
  * 如果cookie泄露，会发生什么问题？ （别人会伪造你信息，例如伪造你信息发帖子发文章）



* 浏览器允许每个域名所包含的cookie数量？

  * 多数浏览器允许最多50个，部分浏览器是30或20；
  * 满后会有多种剔除策略，比如LRU，权重等

* Cookie的现状：

  * Cookie曾一度用于客户端数据的存储，因当时并没有其他合适的存储办法而作为唯一的存储手段

  * 现代浏览器开始支持各种各样的存储方式，Cookie渐渐被少用了，新的浏览器API已经允许开发者直接将数据存储到本地，比如localStorage、SessionStorage等

    参考：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Cookies



## 9.2 javaweb操作浏览器cookie（cookie实战）

* 获取请求的cookie

```java
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            cookie.getDomain();
        }
        
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }



private final String name;
private String value;
private int version = 0; // ;Version=1 .. means RFC 2109 style

//
// Attributes encoded in the header's cookie fields.
//
private String comment; // ;Comment=VALUE .describes cookie's useprivate 
private String domain; // ;Domain=VALUE . domain that sees cookie
private int maxAge=-l;// ;Max-Age=VALUE ..cookies auto-expire
private String path; // ;Path=VALUE .·.URLs that see the cookie
private boolean secure; // ;Secure ...e.g.use SSL
private boolean httpOnly; // Not in cookie specs, but supported by browsers
```



* 响应返回的cookie

```java
Cookie cookie = new Cookie("token","asdfghjkl");
//20秒过期时间，过期后不会自动携带过去
cookie.setMaxAge(20);

response.addCookie(cookie);

request.getRequestDispatcher("/index.jsp").forward(request,response);
```

* js获取cookie，可以获取token，但是获取不到SESSIONID，因为http-only原因



## 9.3 session

* 什么是Session
  * 背景：HTTP协议作是无状态协议，无状态指每次request请求之前是相互独立的，当前请求并不会记录它的上一次请求信息
  * 存在这样的问题，既然无状态，那完成一套完整的业务逻辑，需要发送多次请求，那么怎么标识这些请求都是同个浏览器操作呢？
  * cookie 和 session 都是为了弥补http协议的无状态特性，对servlet端来说无法知道两次http请求是否来自同一个用户，利用cookie 和 session就可以让server端知道多次http请求是否来自同一个用户

 

* 生成和使用流程（和Cookie知识点一样，两者互相配合）
  * 浏览器第一次发送request请求到服务器，服务器除了返回请求的response之外，还给请求分配一个唯一标识sessionid 和 response一并返回给浏览器
  * 服务器在本地创建一个map结构，专门以key-value存储这个sessionid和浏览器的关系
  * 当浏览器的第一次请求后已经分配一个sessionid，当第二次访问时会自动带上这个标识sessionid
  * 服务器通过查找这个sessionid就知道用户状态了，并更新sessionid的最后访问时间
  * 注意：Session是有时限的；比如如果30分钟内某个session都没有被更新，服务器就会删除这个它
* 总结：
  * 服务端生成这个全局的唯一标识，传递给客户端用于标记这次请求就是cookie
  * 服务器创建的那个map结构就是session
  * cookie 由服务端生成，用于标记客户端的唯一标识，在每次网络请求中，都会被传送
  * session 服务端自己维护的一个map数据结构，记录key-Object 上下文内容状态
  * 总言之cookie是保存在客户端，session是存在服务器，session依赖于cookie
  * cookie里面存储的就是JSESSIONID



* 使用场景：记录用户的登录状态、权限等



* session的现状：
  * session 是存储在服务端的内存中，在javaweb里面叫 HttpSession 也是一个作用域
  * PageContext(当前页面) -> ServletRequest(一次请求) -> 【HttpSession】(一个会话) -> ServletContext(一个应用)
  * 是可以存储很多key-value的，作用域比较广，所以也不能存储过多内容，因为内存是有限制的，互联网企业使用比较少，传统IT公司使用比较多



* 知识延伸：
  * 服务端是单机情况下session是可以很用的使用的，但是分布式(多台机器)情况下就存在不能共享的问题
  * 用户A在当前机器登录，突然某次请求到B机器，由于B服务器不存在这个用户的登录信息，所以就会提示重新登录
  * 这个场景下就会用到分布式存储方案，比如Redis



## 9.4 HttpSession用户登录实战

* HttpSession 类操作api介绍：

```
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //获取sessionid，java里面叫jsessionid
        System.out.println("sessionid = "+session.getId());
        //创建时间戳，毫秒
        System.out.println("CreationTime = " +session.getCreationTime());

        //是否是初次创建,记得清空浏览器的cookie，验证sessionid
        System.out.println("isNew = "+session.isNew());

        //往session存储东西
        session.setAttribute("name","小滴课堂 xdclass.net");

        session.invalidate();
    }
```



* 登录Servlet实战

```
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if (name.equals("xdclass") && pwd.equals("123")){
            User user = new User();
            user.setId(121);
            user.setName(name);
            user.setHost("xdclass.net");
            req.getSession().setAttribute("loginUser",user);
            req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","账号密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
```



* 登录页面

```
<body>
<form action="<%=request.getContextPath()%>/loginServlet" method="post">

    名称:<input type="text" name="name"/>
    <br>
    密码:<input type="password" name="pwd"/>

    <input type="submit" value="登录">

    消息提示 ${msg}
</form>
</body>
```



* 登录成功页面

```
<body>
id:${loginUser.id}
<br>
name:${loginUser.name}
<a href="/logout_servlet">退出</a>
</body>
```



* 退出登录实现方式：session.invalidate();     //销毁session，服务器分配一个新的sessionid
* 过期时间配置web.xml，单位分钟

```
<session-config>
	<session-timeout>30</session-timeout>
</session-config>
```



# 10 Servlet过滤器Filter

## 10.1 过滤器Filter

* 什么是过滤器：（检验是否符合要求，或者对内容做二次处理，设置编码响应等）

  * filter 简单理解：人 ----> 检票员（filter） -----> 景点

* Servlet里面的过滤器作用

  * 动态地拦截请求和响应，变换或使用包含在请求或响应中的信息
  * 在客户端的请求访问后端资源之前，拦截这些请求
  * 在服务器的响应发送回客户端之前，处理这些响应

* Filter 的生命周期

  * init(FilterConfig filterConfig) //只容器初始化的时候调用一次，即应用启动的时候加载一次

  * doFilter(ServletRequest request,ServletResponse response,FilterChain chain)

    只要命中过滤规则就触发，可以在filter中根据条件决定是否调用chain.doFilter(request,response)方法

    法，即是否让目标资源执行

  * destroy()  //只容器销毁的时候调用一次，即应用停止的时候调用一次

* 元注解：@WebFilter

```
//该Filter是否支持异步操作模式
asyncSupported 

//指定Filter对那种dispatcher模式进行过滤  该属性支持 Async,Error,Forward,include,request
dispatcherType

//Filter 显示的名称
displayName

//Filter的名称
filterName

//Filter的配置参数
initParams

//过滤的Servlet可以指定多个，表示对这几个特定的servlet 进行过滤
servletName

//指定 Filter 拦截的URL，和上面的servletName配置一样，用*可以表示通配符，但是不用字母后加*，应该按照模块划分，比如/user/*
urlPatterns/value
```



* 过滤器实战

```java
@WebFilter(filterName = "xxx",urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("CustomFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter");

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        
        //让请求继续往下走
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }
}
```



## 10.2 Servlet Filter 配置参数详解

* FilterConfig类：
  * 过滤器配置类，可以通过这个获取过滤器基本信息



* dispatchType 参数
  * 指定Filter对那种dispatch模式进行过滤，不符合的则不进行过滤
    * **REQUEST：默认值，浏览器直接请求的资源会被过滤器拦截**
    * **FORWARD：转发访问资源会被过滤器拦截**
    * INCLUDE：包含访问资源
    * ERROR：错误跳转资源
    * ASYNC：异步访问资源
* 实操：

```java
@WebFilter(filterName = "xxx",urlPatterns = {"/*"},initParams = {
        @WebInitParam(name = "encoding",value="UTF-8"),
        @WebInitParam(name = "loginPage",value="/login.jsp"),
},dispatcherTypes = {DispatcherType.FORWARD})

public class CustomFilter implements Filter {
    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;


    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("CustomFilter init");
        this.filterConfig = filterConfig;

        String filterName = filterConfig.getFilterName();
        System.out.println("filterName = "+filterName);

        String encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter");

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        //让请求继续往下走
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }
}
```



10.3 过滤器实战之Filter用户登录访问个人页面拦截

* 开发登录Servlet

```java
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if (name.equals("xdclass") && pwd.equals("123")){
            User user = new User();
            user.setId(121);
            user.setName(name);
            user.setHost("xdclass.net");
            req.getSession().setAttribute("loginUser",user);
            req.getRequestDispatcher("/user/user.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","账号密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
```



* 开发登录过滤器

```java
@WebFilter(filterName = "loginFilter",urlPatterns = {"/user/*"},initParams = {
        @WebInitParam(name = "encoding",value="UTF-8"),
        @WebInitParam(name = "loginPage",value="/login.jsp"),
})

public class LoginFilter implements Filter {
    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("CustomFilter init");
        this.filterConfig = filterConfig;

        this.encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter");

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        if (httpServletRequest.getSession().getAttribute("loginUser") != null) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            httpServletRequest.setAttribute("msg","非法访问，请登录");
            httpServletRequest.getRequestDispatcher(loginPage).forward(httpServletRequest,httpServletResponse);
        }

        //让请求继续往下走
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }
}
```



* 登录界面 login.jsp

```html
<body>
<form action="<%=request.getContextPath()%>/loginServlet" method="post">

    名称:<input type="text" name="name"/>
    <br>
    密码:<input type="password" name="pwd"/>

    <input type="submit" value="登录">

    消息提示 ${msg}
</form>
</body>
```



# 11 Listener监听器

## 11.1 Listener监听器简介

* 什么是监听器：
  * 监听器是一个实现了特定接口的普通java类，用于监听其他对象的创建和销毁，监听其他对象的方法执行和属性改变
  * 声控灯开关

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230228164657892.png" alt="image-20230228164657892" style="zoom: 150%;" />



* java里面的监听器：

  * 作用：监听域对象的创建和销毁，比如request / session / context
  * 分类：
    * ServletContextListener
    * HttpSessionListener
    * ServletRequestListener

* 监听器的实现步骤：

  （1）创建一个普通的java类

  （2）让该类实现监听器接口

  （3）在该类中实现监听器接口的方法

  （4）旧版的在web.xml中通过 <listener> 标签来配置监听器，新版使用@WebListener



## 11.2 实战-自定义ServletContext监听器

* 使用场景：加载全局变量，初始化项目信息
* web.xml配置

```xml
  <context-param>
    <param-name>url</param-name>
    <param-value>https://xdclass.net</param-value>
  </context-param>

  <context-param>
    <param-name>topic</param-name>
    <param-value>小滴课堂java高级工程师成长专题视频</param-value>
  </context-param>
```

* 监听器开发

```java
@WebListener()
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener contextInitialized");
        ServletContext servletContext = sce.getServletContext();
        String url = servletContext.getInitParameter("url");
        String topic = servletContext.getInitParameter("topic");

        Config config = new Config();
        config.setTopic(topic);
        config.setUrl(url);

        servletContext.setAttribute("config",config);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener contextDestroyed");
    }
}
```



## 11.3 监听器实战-HttpSessionListener统计在线人数

* session使用场景
  * 和session相关操作，比如统计网站在线人数，当前服务器的负载情况等
* ContextListener配置

```
//获取上下文对象
ServletContext sc = sce.getServletContext();
sc.setAttribute("onlineNum",0);
```

* HttpSessionListener 开发

```java
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener sessionCreated");

        ServletContext servletContext = se.getSession().getServletContext();

        //获取在线人数
        Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");

        //新增1
        servletContext.setAttribute("onlineNum",++onlineNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener sessionDestroyed");

        ServletContext servletContext = se.getSession().getServletContext();

        //获取在线人数
        Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");

        //减少1
        servletContext.setAttribute("onlineNum",--onlineNum);
    }
}
```

* add.jsp

```html
<body>
<hr>
近30分钟在线人数: ${ applicationScope.onlineNum }

</body>
```

* delete.jsp

```java
<body>
销毁session
<hr>
<% request.getSession().invalidate(); %>
</body>
```

* 注意：
  * 关闭启动Tomcat自动打开浏览器，因为会触发会触发多个session
  * 使用多个浏览器测试 粗略统计，如果是多机器分布式情况，需要用到分布式缓存



## 11.4 实战ServletRequestListener 统计网站请求量

* ContextListener配置

```java
//获取上下文对象
ServletContext sc = sce.getServletContext();
sc.setAttribute("onlineNum",0);
sc.setAttribute("totalVisit",0);
```



* RequestListener开发

```java
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener sessionCreated");

        ServletContext servletContext = se.getSession().getServletContext();

        //获取在线人数
        Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");

        //新增1
        servletContext.setAttribute("onlineNum",++onlineNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener sessionDestroyed");

        ServletContext servletContext = se.getSession().getServletContext();

        //获取在线人数
        Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");

        //减少1
        servletContext.setAttribute("onlineNum",--onlineNum);
    }
}
```



```java
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("RequestListener requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("RequestListener requestInitialized");

        Integer totalVisit = (Integer) sre.getServletContext().getAttribute("totalVisit");
        System.out.println("历史总访问次数:"+ totalVisit);
        totalVisit++;
        sre.getServletContext().setAttribute("totalVisit",totalVisit);
    }
}
```



* add.jsp

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>小滴课堂javaweb统计在线人数</title>
</head>
<body>
<hr>
近30分钟在线人数: ${ applicationScope.onlineNum }
<hr>
应用服务器启动后总访问次数: ${ totalVisit }
</body>
</html>
```



# 12 javaweb文件上传

## 12.1 javaweb文件上传

* javaweb文件上传
  * Web应用系统开发中，文件上传和下载功能是非常常用的功能，浏览器在上传的过程中是将文件以流的形式提交到服务器端的



* 前端开发
  * 表单的提交方式必须是post
  * 需要声明是一个文件上传组件 <input type="file" name="img"/>
  * 必须设置表单的enctype="multipart/form-data"

```java
<body>
<form action="<%=request.getContextPath()%>/fileUpload" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username">
    头像:<input type="file" name="img">
    <input type="submit" value="提交">
</form>
</body>
```

* 后端开发

```java
@WebServlet("/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        System.out.println("username=" + username);


        Part part = request.getPart("img");

        //获取真实文件名称
        String header = part.getHeader("content-disposition");

        System.out.println(header);

        String realFileName = header.substring(header.indexOf("filename=")+10,header.length()-1);

        System.out.println("realFileName=" + realFileName);

        //获取真实的文件内容
        InputStream is = part.getInputStream();

        //WEB-INF目录外界不能直接访问，如果文件机密性强则放这里
        //String dir = this.getServletContext().getRealPath("/WEB-INF/file");

        String dir = this.getServletContext().getRealPath("/file");

        File dirFile = new File(dir);

        //如果目录上不存在，则创建
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }

        String uniqueName = UUID.randomUUID() + realFileName;

        //文件流拷贝
//        File file = new File(dir,realFileName);

        File file = new File(dir, uniqueName);

        FileOutputStream out = new FileOutputStream(file);

        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            out.write(buf,0,len);
        }
        out.close();
        is.close();
        //图片访问
        request.getRequestDispatcher("/file/" + uniqueName).forward(request,response);
    }
}
```



* 注意点：
  * 考虑文件上传存储的目录
  * 防止文件重名覆盖，防止一个目录下面出现太多文件，限制上传文件的最大值，上传的文件判断后缀名是否合法



* 互联网公司里面的文件服务器：
  * 基本很少互联网公司把文件存储在javaweb项目里面，一个是性能，一个是成本
  * 多数是会搭建专门的文件服务器，或者使用第三方的CDN，比如阿里云的OSS，高级架构课程会讲这块知识点



12.2 javaweb文件下载

* javaweb文件下载
  * 网站下载文件，这块也是很常用的，javaweb如何实现文件下载呢？
  * 只需通过超链接即可实现，就是通过超链接，在连接地址里写上文件的路径，浏览器会自动打开该文件
  * 普通的文本，图片等浏览器能直接显示内容的浏览器都能直接打开并显示
  * 如果是浏览器无法打开的文件，比如exe等浏览器就会提示你下载改文件或者使用当前系统自带的工具打开该文件
* 后端开发
  * 客户端发送请求给服务端告诉服务端需要下载的文件，服务端读取该文件转换为输入流，在通过outputstream响应给客户端，需要设置response的头信息

```
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //客户端传递需要下载的文件名
        String file = req.getParameter("file");

        //获取图片在项目中的路径
        String path = req.getServletContext().getRealPath("/file/");

        String filepath = path + file;

        FileInputStream fis = new FileInputStream(filepath);

        resp.setCharacterEncoding("UTF-8");

        //指明响应的配置信息，包含附件
        resp.setHeader("Content-Disposition","attachment; filename=" + file);

        //如果文件包含中文名称，需要进行编码转换
//        resp.setHeader("Content-Disposition","attachment; filename=" + new String(file.getBytes("gb2312"),"ISO-8859-1"));

        ServletOutputStream out = resp.getOutputStream();

        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1){
            out.write(buf,0,len);
        }
        out.close();
    }
}
```



* 前端开发

```

```



# 13 javaweb三层目录结构和MVC知识

## 13.1 Model-视图View-控制器Controllor模型

* 什么是MVC
  * Model 模型
    * 承载数据用的Bean，即java对象，比如实体类User/Order，或者Service、Dao层对象
  * View 视图
    * 页面比如jsp，为用户提供使用界面，与用户直接进行交互
  * Conrollor 控制器
    * 将用户请求转发给相应的 Model 进行处理，并根据 Model 的计算结果向用户提供相应响应，比如Servlet、Controller等

<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230306124910828.png" alt="image-20230306124910828" style="zoom:200%;" />



## 13.2 三层结构

* 三层结构
  * 软件包划分：
    * 分别完成不同的功能
    * 降低各层的耦合度，在三层架构程序设计中，采用面向抽象编程
    * 上层对下层的调用，是通过接口实现的
    * 下层对上层的真正服务提供者，是下层接口的实现类
  * 视图层 View也叫web层
    * 接收用户提交请求的代码
  * 服务层 Service
    * 系统的业务逻辑
  * 持久层 Dao
    * 操作数据库的代码

![image-20230306130530177](C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230306130530177.png)

<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230306130638227.png" alt="image-20230306130638227" style="zoom:200%;" />



## 13.3 src目录结构

<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230306132637203.png" alt="image-20230306132637203" style="zoom:200%;" />



* controller放servlet文件
* service放一些接口和实现类
* dao放数据库操作代码



# 15 数据库操作和池化思想

## 15.1 数据库工具类自定义DButils封装

简介：自定义DButils工具类封装

* 优化JDBC操作，提高效率

* javaweb项目中，使用JDBC需要添加mysql启动到Tomcat里面

```
@WebServlet("/jdbc")
public class TestJDBCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instr = req.getParameter("id");
        int id = Integer.parseInt(instr);
        try {
            Connection connection = CustomDBUtils.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from jdbc.user where id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println("名字:" + resultSet.getString("name") + "微信号:" + resultSet.getString("wechat"));
            }
            CustomDBUtils.close(resultSet, ps, connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
```

```java
public class CustomDBUtils {
    private static String url ;
    private static String username ;
    private static String password ;
    private static String driver ;

    static {
        try {
            //使用类加载器获取当前类路径
            //获取类加载器对象
//            ClassLoader classLoader = CustomDBUtils.class.getClassLoader();
//            //通过类加载器的getResource()找到指定名称的资源
//            URL resource = classLoader.getResource("db.properties");
//            String path = resource.getPath();

            Properties properties = new Properties();

            properties.load(CustomDBUtils.class.getClassLoader().getResourceAsStream("db.properties"));

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //加载JDBC驱动程序
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭数据库资源
     * @param resultSet
     * @param ps
     * @param connection
     */
    public static void close(ResultSet resultSet, PreparedStatement ps, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
```

```properties
url=jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8
username=root
password=ljy040226
driver=com.mysql.jdbc.Driver
```





## 15.2 数据库连接池化思想

* 为什么要用连接池
  * 数据库建立Connection比较耗时，频繁的创建和释放连接引起的大量性能开销
  * 如果数据库连接得到重用，避免这些开销，也提高了系统稳定
  * 数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于池中备用，对于业务请求处理而言，直接利用现有可用连接，缩减了系统整体响应时间
  * 统一的连接管理，缩减了系统整体响应时间
* 同类对比其他池化思想
  * java线程池
  * Tomcat连接池
  * 对象池(SpringIOC容器)



## 15.3 常见的DB工具类和数据库连接池

* 数据库工具类：Apache comments dbutils
  * Apache 组织提供的一个开源JDBC工具库，它是对JDBC的简单封装，能极大简化jdbc编码的工作量，同时也不会影响程序的性能
  * 地址：https://commons.apache.org/proper/commons-dbutils/
  * 导入
    * 可以添加到Tomcat的lib包
    * 可以添加到web-inf的lib包

```
<dependency>
	<groupId>commons-dbutils</groupId>
	<artifactId>commons-dbutils</artifactId>
	<version>1.6</version>
</dependency>

<dependency>
	<groupId>com.mchange</groupId>
	<artifactId>c3p0</artifactId>
	<version>0.9.5.2</version>
</dependency>
```



* 数据库连接池：c3p0、druid、dbcp
  * dbcp：全称 DataBase connection pool，数据库连接池是 apache 上的一个java连接项目
  * 地址：http://commons.apache.org/proper/commons-dbcp

```java
<dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>8.0.22</version>
 </dependency>
 <dependency>
     <groupId>commons-dbcp</groupId>
     <artifactId>commons-dbcp</artifactId>
     <version>1.4</version>
 </dependency>
 <dependency>
     <groupId>commons-pool</groupId>
     <artifactId>commons-pool</artifactId>
     <version>1.6</version>
 </dependency>
```



# 16 数据库连接池和Apache DBUtils实战

## 16.1 数据库连接池

简介：Apache dbcp数据库连接池封装DataSourceUtils实战

* 配置：

```java
driverClassName = com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8
username=root
password=ljy040226

initialSize=2     //连接池建立时创建的连接的数量
maxActive=15	//连接池同一时间内最多能够分配的活动连接的数量
```

* 工具类开发

```java
/**
 * 数据库连接池工具类
 */
public class DataSourceUtil {

    private static DataSource dataSource;

    static {

        try{
            InputStream in = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties p = new Properties();
            p.load(in);

            dataSource = BasicDataSourceFactory.createDataSource(p);

        }catch (Exception e){
            e.printStackTrace();
            throw  new ExceptionInInitializerError("初始化DBPC失败");
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
```



## 16.2 Apache dbutils工具快速入门实战

* DbUtils 中的核心类/接口
  * QueryRunner
    * 查询执行器，提供对sql语句操作的API
    * update(String sql,Object...params)可执行 增-INSERT、 删-DELETE、 改-UPDATE
    * query(String sql,ResultSetHandler<T> rsh,Object...params) 可执行查询-SELECT
  * ResultSetHandler
    * 结果集处理类，执行处理一个结果集对象，将数据转变并处理为任何一种形式
      * BeanHandler 结果集中的第一行数据封装到一个对应的javaBean实例
      * BeanListHandler 结果集中的每一行数据都封装到一个对应的javaBean实例中，存放到List里
      * MapHandler 结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值
      * MapListHandler 结果集中的每一行数据都封装到一个Map里，然后再存放到List
      * ScalarHandler 结果集中第一行数据指定列的值，常用来进行单值查询



* 例子：

```java
QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

public User findById(int id){
    String sql = "select * from user where id = ?";
    User user = null;
    try {
        user = queryRunner.query(sql,new BeanHandler<>(User.class.processor,id));
    }catch(SQLException e){
        e.printStackTrace();
    }
    return user;
}
```



## 16.3 BeanHandler和BeanListHandler多个结果集处理实战

导入依赖：

```java
<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.2</version>
		</dependency>
    
<dependency>
   <groupId>org.apache.commons</groupId>
   <artifactId>commons-pool2</artifactId>
   <version>2.4.2</version>
</dependency>
```



```java
    private static DataSource dataSource = null;
    static {

        try{
            InputStream in = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties p = new Properties();
            p.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(p);
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBCP失败,请检查配置文件");
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
```



* BeanHandler：结果集中的第一行数据封装到一个对应的JavaBean实例

```

```



* 开启驼峰映射：数据库字段映射java类

```java
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(bean);

    public User findById(int id){

        String sql = "select * from jdbc.user where id = ?";

        User user = null;
        try {
            user =  queryRunner.query(sql,new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> list(){
        String sql = "select * from jdbc.user";
        List<User> list = null;
        try {
            list =  queryRunner.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
```



* BeanListHandler：结果集中的每一行数据都封装到一个对应的javaBean实例中，存放到List里

```java
    public List<User> list(){
        String sql = "select * from jdbc.user";
        List<User> list = null;
        try {
            list =  queryRunner.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
```

DataSourceUtils、UserDao、UserService、database.properties



## 16.4 MapHandler和ScalarHandler结果处理集实战

* MapHandler：结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值

```
    public Map<String,Object> findByIdWithMap(int id){
        String sql = "select * from jdbc.user where id = ?";

        Map<String,Object> map = null;
        try {
            map =  queryRunner.query(sql,new MapHandler(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    
    
            if (method.equals("findByIdWithMap")){
            String idStr = req.getParameter("id");
            int userId = Integer.parseInt(idStr);

            Map<String,Object> map = userService.findByIdWithMap(userId);
            System.out.println(map.toString());
        }
```



* MapListHandler：结果集中的每一行数据都封装到一个Map里，然后再存放到List

```
    public List<Map<String,Object>> listWithMap(){
        String sql = "select * from jdbc.user where id = ?";

        List<Map<String,Object>> list = null;
        try {
            list =  queryRunner.query(sql,new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
            if (method.equals("listWithMap")){
            List<Map<String,Object>> list = userService.listWithMap();
            System.out.println(list.toString());
        }
```



* ScalarHandler：结果集中第一行数据指定列的值，常用来进行单值查询

```java
    public int countUser(){
        String sql = "select count(*) from jdbc.user";

        Long count = null;

        try{
            count = (Long) queryRunner.query(sql,new ScalarHandler<>());
        }catch (Exception e){
            e.printStackTrace();
        }
        return count.intValue();
    }
    
    
            if (method.equals("count")){
            int total = userService.countUser();

            System.out.println("user表行数 ="+total);
        }
```



## 16.5 QueryRunner新增update语法实战

* update新增

```java
    public int save(User user){
        String sql = "insert into jdbc.user (name,wechat) values (?,?)";

        Object [] params = {
                user.getName(),
                user.getWechat()
        };
        int i = 0;
        try {
            i = queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    
            if (method.equals("save")){
            User user = new User();
            user.setName("老王");
            user.setWechat("222222");

            int row = userService.save(user);
            System.out.println("row="+row);
            if (row == 1){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        }
```



# 17 互联网公司软件开发流程

## 17.1 概述

* 软件开发流程
  * 需求分析
  * 设计
    * UI设计
    * 架构设计
  * 开发
    * 前端开发
    * 后端开发
  * 测试
    * 功能测试
    * 性能测试
    * 安全测试
  * 上线
    * 预发布环境
    * 灰度
    * 全量
  * 多次迭代更新



## 17.2 小滴课堂开发者论坛效果演示和需求分析

* 演示功能，后续开发不演示功能
* 分类列表功能
* 主题列表功能-分页
* 主题详情功能-分页
* 注册登录
* 回复盖楼功能
* 练手项目，从javaweb基础整合进阶，学完再继续跟着路线学习综合项目



# 18 javaweb项目实战之小滴课堂开发者论坛数据库设计

## 18.1 小滴课堂开发者论坛数据库ER关系图设计

* 什么是ER图
  * 实体关系图，是一种提供了实体，属性和联系的方法，用来描述现实世界的概念模型
* 实体
  * 现实世界中的对象，可以具体到人、事、物，比如学生、教师、商品、订单、主题、菜单等
  * ER图里面 用矩形表示，矩形框内写明实体名
* 属性
  * 实体所具有的一个特性称为属性，在E-R图中属性用来描述实体，比如商品实体，有标题、价格、图片等属性
  * ER图里面用椭圆形或圆角矩形表示、并用无向边将其与相应的实体连接起来
* 关系
  * 任何事物都不是孤立存在的，事物内部和事物之间都有了联系的，实体之间的联系通常有3种类型：一对一联系，一对多联系，多对多联系：比如商品和订单的关系、班级和学生的关系、主题和评论的关系
  * ER图里用菱形表示，菱形框内写明联系名，并用无向边分别与有关实体联系起来
    * 1对1关系在两个实体连线方向写1：
    * 1对多关系在1的一方写1，多的一方写N：
    * 多对多关系则是在两个实体连线方向各写N,M

<img src="C:%5CUsers%5CAdministrator%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20230308214845942.png" alt="image-20230308214845942" style="zoom:200%;" />



## 18.2 小滴课堂开发者论坛数据库设计

* cateogry分类表

```
CREATE TABLE `category`(
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`name` varchar(128) DEFAULT NULL,
`weight`~ int(11) DEFAULT NULL,
`create_time` datetime DEFAULT NULL,
PRIMARY KEY (`id`),
)ENGINE=InNODB AUTO_INCREMENT=5 DEFAULT CHARSET-utf8mb4;
```



* topic主题表

```
CREATE TABLE`topic` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`c_id` int(11) DEFAULT NULL COMMENT `分类`,
`title` varchar(128) DEFAULT NULL COMMENT `标题`,
`content` varchar(1024) DEFAULT NULL COMMENT `内容,`
`pv` int(11) DEFAULT NULL COMMENT `浏览量`,
`user_id` int(11) DEFAULT NULL,
`username` varchar(64) DEFAULT NULL,
`user_img` varchar(128) DEFAULT NULL,
`create_time` datetime DEFAULT NULL,
`update_time` datetime DEFAULT NULL,
`hot` int(2) DEFAULT '0' COMMENT '是否热门 1是热门',
`delete` int(11) DEFAULT 'O' COMMENT '0是未删除，1是一件删除',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
```



* User表

```
CREATE TABLE user (
`id` int(11) unsigned NOT NULL AUTO_INCRENENT
`phone` varchar(32) DEPAULT NULL,
`pwd` varehar(128) DEFAULT NULL,
`sex` int(2) DEFAULT NULL,
`img` varchar(128) DEFAULT NULL,
`create_time` datetime DEFAULT NULL,
`role` int(11) DEFAULT NULL COMMENT '1是普通用户，2是管理员',
`username` varchar(128) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE-INNODB AUTO_INCREMENT=1 DEFAULT CHARSET-utf8mb4:
```



* reply表

```
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`topic_id` int(11) DEFAULT NULL,
`floor` int(11) DEFAULT NULL COMMENT '楼层编号，回复是不能删除的',
`content` varchar(524) DEFAULT NULL COMMENT '回复内容',
`user_id` int(11) DEFAULT NULL,
'username' varchar(64) DEFAULT NULL COMMENT '回复人名称' ,
'user_img' varchar(128) DEFAULT NULL COMMENT '回复人头像',
`create time` datetime DEFAULT NULL,
`update_time` datetime DEFAULT NULL,
`delete` int(11) DEFAULT NULL COMMENT '0是正常，1是禁用'
```



# 19 Maven3x创建小滴课堂开发者论坛项目和配置tomcat

## 19.1 项目配置

* 简介:IDEA+Maven3x创建javaweb项目配置tocmat9

  * 创建Maven3.x +Javaweb项目

  * 提高创建速度，会在本地优先查找资源，本地找不到再去下载

    Name: archetypeCatalog

    Value : internal

  * 如何导入课程项目



## 19.2 开发者论坛maven依赖包和基础实体类开发

* maven依赖包添加

```xml
  <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-web-api</artifactId>
      <version>7.0</version>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.32</version>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>commons-dbutils</groupId>
      <artifactId>commons-dbutils</artifactId>
      <version>1.7</version>
    </dependency>

    <dependency>
      <groupId>commons-dbcp</groupId>
      <artifactId>commons-dbcp</artifactId>
      <version>1.4</version>
    </dependency>
    <dependency>
      <groupId>commons-pool</groupId>
      <artifactId>commons-pool</artifactId>
      <version>1.6</version>
    </dependency>

    <dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>1.2</version>
    </dependency>

    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-pool2</artifactId>
      <version>2.4.2</version>
    </dependency>

    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.5.2</version>
    </dependency>
```

* 包结构创建
* 实体类开发
* 工具类开发
  * 连接池开发

```xml
    <!--专门用于打包配置文件到类路径-->
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
```

