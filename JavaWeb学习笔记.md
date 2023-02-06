# 							JavaWeb学习笔记

## 1 JDBC

### 1.1 JDBC 简介

JDBC概念：

* JDBC 就是使用Java语言操作关系型数据库的一套API
* 全称：（Java DataBase Connectivity）Java 数据库连接

![image-20230205205048017](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230205205048017.png)

JDBC 本质：

* 官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口
* 各个数据厂商去实现这套接口，提供数据库驱动jar包
* 我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类

JDBC 好处：

* 各数据库厂商使用相同的接口，Java代码不需要针对不同数据库分别开发
* 可随时替换底层数据库，访问数据库的Java代码基本不变



### 1.2 JDBC 快速入门

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



### 1.3 JDBC API 详解

#### 1.3.1 DriverManager

* DriverManager(驱动管理类)作用：
  1. 注册驱动
  2. 获取数据库连接

1. 注册驱动

```
Class.forName("com.mysql.jdbc.Driver");
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

* MySQL 5 之后的驱动包，可以省略注册驱动的步骤
* 自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类

2. 获取连接

```
static Connection    getConnection(String url,String user,string password)
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



#### 1.3.2 Connection

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



#### 1.3.3 Statement

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



#### 1.3.4 ResultSet

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
while(rs.next()
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



#### 1.3.5 PrepareStatement

*  PrepareStatement作用：

  1. 预编译SQL语句并执行：预防SQL注入问题

  * 获取 PrepareStatement对象

  ```
  //SQL语句中的参数值，使用? 占位符替代
  String sql = "select * from user where username = ? and password = ?"
  // 通过Connection对象获取，并传入对应的sql语句
  PreparedStatement pstmt = conn.prepareStatement(sal);
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



### 1.4 数据库连接池

#### 1.4.1 简介

* 数据库连接池是个容器，负责分配、管理数据库连接(Connection)
* 他允许应用程序重复使用一个现有的数据库连接，而不是再重新创建一个
* 释放空闲时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏
* 好处：
  * 资源重用
  * 提升系统响应速度
  * 避免数据库连接遗漏



#### 1.4.2 数据库连接池实现

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



#### 1.4.3 Durid使用步骤

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



### 1.5 JDBC环境准备

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



## 2 Maven

* Maven是专门用于管理和构建Java项目的工具，他的主要功能有：
  * 提供了一套标准化的项目结构
  * 提供了一套标准化的构建流程(编译，测试，打包，发布)
  * 提供了一套依赖管理机制
* 标准化的项目结构

Maven提供了一套标准化的项目结构，所有IDE使用Maven构建的项目结构完全一样，所有IDE创建的Maven项目可以通用

![image-20230206222556129](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230206222556129.png)