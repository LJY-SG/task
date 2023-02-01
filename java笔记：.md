# java笔记

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673248841350-23b6046e-fa9f-4509-8396-7afa1da9846e.png)

JDK是总开发环境

JVM是虚拟机利于JAVA文件的跨平台使用



## **JAVA语法的基本格式：**

public calss 类名{

public static void main() 

}

**输入：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249252578-85899ae9-7590-4ed3-9e64-c130490d8b59.png)



空常量不能直接输出



## **基本数据类型：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673248928182-3bfb3695-db51-4e4d-aeca-c6a67e54b7e7.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673248941909-52e685a2-524e-45ee-831b-4e7cbf9adca3.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673248970093-60ea35a4-5bd2-489b-9ce1-05c6513fe017.png)

**定义long类型的变量在值后加一个L**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673248988281-86088a99-4e29-4cc2-a640-567c08f3d567.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249012693-a130635d-f776-417b-9051-ac646e8927c5.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249025306-2836d087-1a27-407b-b601-edaedf91a20b.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249031613-002d7800-fab5-49d4-88a0-fec7b737d11d.png)



### **byte不能自动转为char会报错**



### **字符的"+"操作：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249061164-a5fc143e-b600-41a7-ac9e-8d930af8f663.png)



### **运算符：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249198446-bc2372b8-2a5d-43e3-a71b-ab6d96e33197.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249204426-9c9cdb2b-7a24-44f9-a7c2-fae326f21c6a.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249219861-e75312d9-230e-4f1e-adba-a4d10f2f474a.png)

三元运算符格式(例)：max =a > b ？a : b 

如果a>b成立，则把a赋给max,否则把b赋给max



## **循环：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249618723-e1975d0a-d907-42c0-8a9d-c29d0578ac8d.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249639748-e3d1995e-c6d1-4dd0-b3ec-a2ab3d62a619.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249656121-01132d09-461c-4d56-beff-d4cb660c792f.png)



## **数组：**

含义：一种用于存储多个相同类型数据的存储模型

定义格式：1.  数据类型[] 变量名  例：int[] arr;(推荐)

\2. 数据类型变量名[]  例: int arr[];

数组初始化：有动态初始化和静态初始化

动态初始化：初始化时只指定数组长度，由系统为数组分配初始值

格式：数据类型[] 变量名 = new 数据类型[数组长度];

例：int[] arr = new  int[3]

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249673531-71546d0d-d58e-47f0-a894-3b44267dd210.png)

## **JAVA内存分配：**

JAVA程序在运行时，需要在内存中分配空间。为了提高运行效率，就对空间进行了不同区域的划分，因为每一片区域都有特定的处理数据方式和内存管理方式。

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249708389-b4bd7125-ab9d-4bba-9edb-903d8de94ec6.png)

栈内存：存储局部变量（定义在方法中的变量）

堆内存：存储new出来的内容（实体，对象）每个new出来的东西都有一个地址值，使用完毕，会在垃圾回收器空闲时被回收

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249721432-685f6a06-9f25-47b7-a7bd-c31279f0c0f9.png)

多个数组指向相同，一个数组修改值，其他的也一起修改



## **数组静态初始化：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249744993-91b64c02-6d5d-48b7-ab16-67783fc28bf9.png)

索引越界：访问了数组中不存在的索引对应的元素，造成索引越界问题

空指针异常：访问的数组已经不再指向堆内存的数据，造成空指针异常

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249764895-ac70e051-7cbc-4838-987f-ea6484faf6c2.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249774279-a844581c-666d-4182-bfc5-56ba9ccffc0a.png)

#### **格式：数组名.length  范例：arr.length**



## **数组遍历：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249795657-2c926957-3006-4a99-acdf-2106de2b2932.png)



## **二维数组：**

格式1: 动态初始化

数据类型 数组名 [ ] [ ] = new 数据类型[m] [n]

数据类型[ ] [ ]  数组名 = new 数据类型[m] [n]

数据类型[ ] [ ]   数组名 [ ] = new 数据类型[m] [n]

举例：int[ ] [ ]  arr=new  int [5] [3];  也可以理解为“5行3例”

格式2: 静态初始化

数据类型[ ] [ ]   数组名 = {{元素1,元素2....},{元素1,元素2....},{元素1,元素2....}.....};

例：int[ ] [ ]  arr={{22,15,32,20,18},{12,21,25,19,33},{14,58,34,24,66},};

静态初始化可用于不规则二维数组的初始化



## **方法：**

概述：是将具有独立功能的代码块组织成为一个整体，使其具有特殊功能的代码集

### **注意：**

1. 方法必须先创建才可以拿使用，该过程
2. 
3. 称为方法的定义
4. 方法创建后并不是直接运行的，需要手动使用后执行，该过程称为方法调用

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249822345-e46e5a13-e5b1-4b01-9c35-c24ccd2de2c5.png)

调用：  格式：方法名（）  例：isEverNumber();

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249839944-14f6e047-2295-4a1f-bc37-f2d73f8d5ae7.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249846375-ed77709f-7b37-4dae-90f2-fce602a6366f.png)

形参：方法定义中的变量

实参：方法调用中的参数

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249854899-f40b5a3b-e304-4d70-87fb-f8cb5c2d81eb.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249860829-d499f674-de5a-4671-8130-0e1eb902af1c.png)

### 方法注意事项：

\1. 方法不能嵌套定义

\2. Void表示无返回值，可以省略return，也可以单独写return，后面不加数据

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249870655-9f3b4e0d-5a79-484e-aadf-e9675229ce58.png)

### 定义方法时，要做到两个明确

1. 明确返回值类型：主要是明确方法操作完毕之后是否有数据返回，如果没有，写void；如果有，写对应的数据类型

2. 明确参数；主要是明确参数的类型和数量

### 调用方法时：

1. void类的方法，直接调用即可

2. 非void类型的方法，推荐用变量接收调用



### 方法重载概述：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249895292-024ad246-9f25-4cfc-9f29-5424953ee670.png)

### **方法重载的特点：**

1. 重载仅对应方法的定义，与方法的调用无关，调用方式参照标准格式

2. 重载仅针对同一个类中方法的名称与参数进行识别，与返回值无关，换句话说不能通过返回值来判定两个方法是否相互构成重载



基本类型参数传递相当于值拷贝

引用类型参数传递相当于传地址，到对应地址的值修改（形参改变影响实参）

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673249924530-83ae806e-20df-4537-9194-6016f84b17bd.png)



### **Debug:**

如果数据来自键盘输入一定要记得输入数据，否则不能继续往下查看



## **DOC基本操作：**

\1. md创建文件(建目录）

\2. 查看当前目录的文件dir

\3. 切换到其他盘符cd /d +要切换的盘符

\4. 切换到当前盘的其他目录

绝对路径  从当前盘最上面开始定位去找对应目录  cd 当前盘：\文件名

相对路径   从当前位置开始定位，去找对应目录：cd 当前盘：\当前目录\对应目录

Tips：输入地址时可以输入前几个字符后用tab智能匹配全民

\5. 切换到上级目录  cd ..

\6. 切换到根目录   cd \

\7. 删除目录   rd +文件名

\8. 删除目录及其子文件  rd /q/s 文件名       rd带询问rd /s 文件名

\9. 将命令传到txt文件里：  echo +内容 >文件名

\10. 文件复制  copy 文件名 目标盘：\及文件(详细）

copy 文件名 盘：\目的目录\改的名

\11. 移动文件move 文件名 盘：\

\12. 删除一个文件del 文件名

\13. 删除全部文件  del *.文件后缀

\14. 清屏cls

\15. 退出doc  输入exit



##                          **面向对象：**

### 三大特征：1.继承 2.封装 3.多态



## 面向对象基础：

### **1.** **类和对象**:

对象：客观存在的事物皆为对象，能看的见摸得着的实体

类（相当于结构体）：类是对现实生活中一类具有共同属性和行为的事物的抽象

类的特点：

1. 类是对象的**数据类型**

2. 类是具有相同属性和行为的一组对象的集合

对象的属性（相当于结构体的字段）：对象具有的各种特征，每个对象的每个属性都有特定的值

对象的行为：对象能够执行的操作



### **类的定义：**

类是JAVA程序的基本组成单位

类（相当于结构体）：类是对现实生活中一类具有**共同**属性和行为的事物的抽象

类的组成：属性和行为

属性：在类中通过成员变量来体现（类中方法外的变量）

行为：在类中通过成员方法来体现（和前面的方法相比去掉static关键字即可）

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357762405-a3c4f016-b0b8-484f-8eb7-ae106b80abd6.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357796657-2a82e01a-de56-476e-bda4-03bd2e7e08c9.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357805186-f2b19a3f-767a-4f4b-bcde-26e1b33788e7.png)

注意首字母大写

可以创建多个对象

多个对象指向相同时，一个变，全都变

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357813723-064081fe-50f0-4092-833d-1361eabba38d.png)



### **成员变量和局部变量：**

成员变量：类中**方法外**的变量

局部变量：**方法中**的变量

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357830581-0890d0ed-c900-44ea-921f-6278e186c41d.png)



### **关键字:**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357841684-2a54e98a-8265-407c-bf4d-8bad2fa96af6.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357846850-c4b7aa88-b78b-4180-92a8-f9f652ebf78f.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357856252-35a7a631-cea3-4d9c-941e-ad16bdfd70ea.png)



### **封装：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357869725-3d480a22-c49c-4d55-91ad-c01caae89409.png)



### **方法构造：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357918062-f26aed94-dc12-4615-80d5-663368c9a26a.png)

### API:

概述：**应用程序编程接口**

即帮助文档

### String:

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357952057-0fdb6f1f-c073-4284-936a-d6dc6728b27b.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357959367-e477b2b7-b2b5-464c-9809-61f15aa81766.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357969141-ab43ba5a-aff5-4653-bbeb-0133b0038005.png)

**推荐使用直接赋值的方式得到字符串**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357977911-d819e846-4710-4b37-bb7e-73c37abde37a.png)



### **字符串的比较：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673357990011-43fa286d-2fe0-48e5-beb8-2d3d6ffbc23e.png)



### **遍历字符串：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358000813-163b6419-6609-412a-ba44-e33e85a8cf44.png)



### **字符串反转：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358018253-f8830804-fd44-46ee-9468-f59678854c31.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358029320-ba8fd98f-52e0-4b27-9f0e-02e0f35f3478.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358038950-19ffee72-c9be-4390-a3f0-47159070a581.png)

### **StringBuilder:**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358046856-77b7247a-e3d8-45ca-a4c0-ce22a67704e6.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358055434-4106f312-3ad1-438e-9497-0eb41343455f.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358133494-74b5d3c6-8c80-4bd9-ab1c-558f7a8e2284.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358141973-9b620a09-915b-4f36-b9d7-10c4f32d45e3.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358149117-286f7082-8bda-433f-aa4d-ccadfd1c3a97.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358083210-62e6f54d-94ee-4dbe-92f6-63d2350e737d.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358193646-140afaba-4e8f-4cfd-bb02-85e07d851ccd.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358204456-966ff615-42f9-4c7f-ab7c-f2af548ce68f.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358217074-2baee5df-4554-44e1-8c55-56cb84a099d7.png)



### **继承：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358290553-09b4f54a-fe3e-4a4c-be77-65f55e72f5ea.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358299244-6616213b-ed26-41e8-95c4-57df95765391.png)



### **继承中变量的访问特点：**

在子类方法中访问一个变量：

1. 子类局部范围找

2. 子类成员范围找

3. 父类成员范围找

4. 如果都没有就报错（不考虑父亲的父亲）......

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358309768-a1217913-da17-4a3c-834c-6f74ae131c59.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358322441-2e550670-090d-49fd-b4d9-073d82a125b8.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358333144-2d64598c-9ffc-470e-9111-229ce4dd5946.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358349690-18854d7e-df68-47aa-8215-419d1a085bc6.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358359523-e4d6aca0-967a-4894-ab49-68f71ca6b852.png)



### **包：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358369144-18fca6e1-203c-401a-bb5d-a2c8d3d10eb1.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358379415-8afa3304-52e2-465e-8566-531c535b0bcc.png)



### **修饰符**:（权限修饰符和状态修饰符）

### **权限修饰符：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358386817-49dad684-84d7-4f33-8954-41ec852ca5e5.png)



### **状态修饰符：**

final(最终态）和static（静态）

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358470692-150f1c4d-71f1-4086-9caf-5e0669130265.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358480446-6739a4e9-d018-45e8-a5da-636d8d2fd9f5.png)



### **static:**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358492823-a8e25f8c-3d28-4130-95b9-1688d24accf7.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358502670-b4de88af-3ff3-4eb8-830d-dc3d30bd492f.png)





## **多态、抽象类、形参和返回值、内部类：**



### **多态：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673445498598-3433da5f-94b3-4af9-8326-f7d3a8a8e584.png)



### **有父类指向子类对象：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673445537869-23d6bf5b-e782-4194-a0ff-5ab5e550434c.png)

**成员变量引用，编译先看父类，运行也看父类**

**成员方法编译要看父类，但运行看子类**



![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446170731-5de1e0a1-5c68-4ee0-bf28-ecf0e24ac8bd.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446197364-5a4f7519-e66c-4b52-a42f-2a9eca015fba.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446183724-0871bc91-8f10-44a9-9908-6f4d3bf11a83.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446218335-336fe133-f5a6-475c-8863-82c33e7b708c.png)

### **抽象类：（abstract）**

概述：在JAVA中，一个没有方法体的方法应该定义为抽象方法，而类中如果有抽象方法，该类必须定义为抽象类

1.抽象类不是具体的，不能创建对象（可以参照多态创建对象）

2.抽象类里可以没有抽象方法，但是抽象方法必须要在抽象类里面

3.子类要么重写抽象类里的所有方法，要么他也是个抽象类

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446236862-c7ba29c8-0d24-4bf1-80bf-ad4c1432efa4.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446268598-46601021-5ae4-4669-8ec6-5c08073f45fa.png)



### **接口：**

概述：接口就是一种公共的规范标准，只要符合规范标准，大家都可以通用JAVA中的接口更多体现在对行为的抽象

1. 接口也是抽象的，不能用继承要用实现（implement）

2. 接口的实例化（参照多态方式）通过类对象来实例化，这叫接口多态（多态形式：具体类多态，抽象类多态，接口多态）

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446605653-b3d4ab73-b4d2-4abb-8b76-618bce63d670.png)



### **类和接口的关系：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446638335-09fef8e3-5874-4f43-93cd-3e756980816d.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446647619-c0776f1b-e7a4-4757-882a-2fe2b5f22fe8.png)

抽象类是对事物的抽象，而接口是对行为的抽象

**分析：从具体到抽象**

**实现：要从抽象到具体**

**使用：使用的是具体的类的对象**



### **形参和返回值：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446666569-bea4f602-ebac-4c20-b04d-b33703e0cc35.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446725455-90f5c7dc-e504-40ef-b5b6-1cc4be4ae83f.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446734880-f81a4717-1ae2-4856-9b67-1be9ea041148.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446748842-310886c0-69af-4583-859f-66140311f1c5.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446756707-6215ce62-b3f0-4bb0-8577-eb183d3417a8.png)



### **局部内部类：**

局部内部类是在方法中定义的类，所以外界是无法直接使用，需要在方法内部创建对象并使用该类可以直接访问外部类的成员，也可以访问方法内的局部变量



### **匿名内部类：**

前提：存在一个类或者接口（这里的类可以是具体类也可以是抽象类）

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446792521-b60e3916-cf47-4e6f-af4c-d95885440e7b.png)

匿名内部类实质是子类匿名对象（可以定义接口的对象再去调用，实现匿名类内部的方法）



### Math类:

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446804650-20d01891-969d-4119-94f6-eb7d13c4707e.png)



### System类：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446812473-80a51d52-3eaa-4189-94bd-5d8d7f2c1f30.png)



### Object类：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446819047-9f41a393-8b40-4a3f-ad75-87f9fe347365.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446908046-202e0767-ad09-43ca-b3be-3fca278386f8.png)

**toString()方法默认底层调用，推荐重写toString()方法**

### **源码：**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446831500-9f11cf0f-3ff6-4d88-88c0-65eca1132411.png)



### equals()方法：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446841163-44bb709c-fc83-49c3-be07-03310e807409.png)



### 需要重写equals方法

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673446883787-5af1fdc2-4ef7-4f15-82fe-c95a47cbe404.png)

## **集合：（ArrayList）**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358239104-c76e7edd-e42e-44c9-a491-d3ce45dceb9d.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358249217-a3c2beb2-d720-4050-924e-8be9b947842d.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358257280-727cd352-f649-4557-b3ae-422f896e9483.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358266056-210f95f1-bc0e-4a1c-861a-dd25a3d9c08e.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673358273531-8044a8d8-e0f7-4419-85ee-f6caf5337804.png)

Alt + Insert 根据自己需要进行选择



## Arrays：

### **冒泡排序：**

**1.** **如果有n个数据进行排序，总共需要比较n-1次**

**2.** **每一次比较完毕，下一次的比较就会少一个数据参与**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535071029-fcd739e3-63fd-44f2-81f0-44957c767df8.png)



### **基本类型包装类：**

**概述：将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据常用的操作之一；用于基本数据类型与字符串之间的转换**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535081511-4d9ce7b4-62af-42f8-8b09-1d187f1ba3a1.png)



### **Int** **与** String之间的转换:

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535094579-7a1d80f1-62eb-4ea4-9e37-d0ad0a5622ac.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535100255-ad78cc39-583d-4094-abd6-3b5818f088e9.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535107835-1afa8075-fc05-4acd-91f5-cf530e704ad8.png)

### Integer类的概述：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535118639-21962019-e6dd-477f-bb7d-fa885c88c11a.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535165043-9e6f006e-8e45-43ce-95aa-24ca3478449a.png)



### **自动装箱和拆箱：**

**装箱：把基本数据类型转换为对应的包装类类型**

**拆箱：把包装类类型转换为对应的基本数据类型**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535178111-b34a09ca-cc99-4eb9-a602-f570171860dd.png)

### Date类：

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535189319-62b28b6a-3c02-405c-a325-71947ab08e52.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535197494-2d788af5-dac5-4519-b332-40fb093089a4.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535201494-2f797ded-d5da-4b4e-9667-eb81eaddce0b.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535209046-395aab84-ccee-4658-8ccd-d5a821249d7b.png)

### **SimpleDateFormat** **类：**

**概述：**

**SimpleDateFormat****是一个具体的类，用于以区域设置敏感的方式格式化和解析日期。**

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535222873-a5de5180-0bc2-4624-809d-b231ce55e530.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535231848-fbc09680-1ac4-4c6e-8f26-6b59deaad85a.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535237817-e7dfd86e-eaf7-4157-80c0-8fef8d3c20ed.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535247881-3e5b1a93-2da1-49f9-9205-ce2545f0834c.png)

**日期解析的格式要与给定的规范一致，否则报错**



![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535264224-12123f93-9c64-4907-adbd-ff3bf30f9f43.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535271575-86c42be1-ca6c-41da-9b92-a4905e612d62.png)

![img](https://cdn.nlark.com/yuque/0/2023/png/34892625/1673535276425-4a70fe76-a1ba-4470-bc42-d0b9d09df0e8.png)



### ***\*Calender 类概述：\****

Calender为某一时刻和一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps1.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps2.png) 

#### 方法一：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps3.jpg) 

#### 方法二：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps4.jpg) 

#### 方法三：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps5.jpg) 

### ***\*二月天：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps6.jpg) 

 

## ***\*异常：\****

概述： 就是程序出现了不正常的情况

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps7.png) 

 

### JVM的默认处理方案：

如果程序出现了问题，我们没有做任何的处理，最终JVM会做默认的处理

1. 把异常的名称，异常原因及异常出现的位置等信息输出在了控制台

2. 程序停止执行

 

### 异常处理：

如果程序出现了问题，我们需要自己来处理，有两种方案：

1. try ...catch...

2. throws 

 

### try...catch...  :

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps8.png)![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps9.png) 

e是一个对象，调用对象e的方法显示错误提示

### ***\*Throwable:\****

Theowable是所有错误和异常的祖宗类，只要属于这个体系，都可以使用他的成员方法

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps10.png) 

一般使用第三个，因为返回的错误信息最全

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps11.png) 

 

编译时异常和运行时异常的区别：

运行时异常就是运行才报错，编译时异常就是编译时就有红线报错

 

### throws : 

在方法后使用throws只能把异常抛出，不会对异常进行实质性的处理，对异常进行处理还得使用try...castch...

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps12.png) 

 

### ***\*自定义异常：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps13.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps14.png) 



## ****Collection集合:

### 集合体系结构：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps15.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps16.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps17.png) 

### 常用方法：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps18.png) 

Alt + 7 可以看到类的所有信息

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps19.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps20.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps21.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps22.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps23.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps24.png) 

集合的遍历：(迭代器集合特有)

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps25.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps26.png) 

 

### ***\*List集合：\****

概述：有序集合（也称为序列），用户可以精确控制列表中每个元素的插入位置。用户可以通过整数索引访问元素，并搜索列表中的元素。

与set集合不同，列表通常允许重复的元素

#### ***\*List集合特点：\****

有序：存储和取出的元素顺序一致

可重复：存储的元素可以重复

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps27.png) 

#### 并发修改异常：

通过迭代器获取元素时，都会判断预期修改值和实际修改值是否相同，如果不同就会报错并发修改异常

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps28.png) 

 

#### ListIterator(列表迭代器):

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps29.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps30.jpg) 

***\*使用列表迭代器来添加元素不会报并发修改错误，因为底层会把实际修改值赋值给预期修改值\****![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps31.jpg)

 

增强for循环：简化数组和Collection集合的遍历：

1. 实现Iterable接口的类允许其对象成为增强型for语句的目标

2. 它是JDK5之后出现的，其内部原理是一个Iterator迭代器

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps32.png) 

## ***\*List 数据结构：\****

### ***\*数据结构：\****

***\*数据结构是\***[**\*计算机\***](https://baike.baidu.com/item/计算机/140338?fromModule=lemma_inlink)**\*存储、组织\***[**\*数据\***](https://baike.baidu.com/item/数据?fromModule=lemma_inlink)**\*的方式。数据结构是指相互之间存在一种或多种特定关系的\***[**\*数据元素\***](https://baike.baidu.com/item/数据元素/715313?fromModule=lemma_inlink)**\*的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储\***[**\*效率\***](https://baike.baidu.com/item/效率/868847?fromModule=lemma_inlink)**\*。数据结构往往同高效的检索\***[**\*算法\***](https://baike.baidu.com/item/算法/209025?fromModule=lemma_inlink)和索引技术有关。

 

 

#### ***\*常见数据结构之栈：\****

***\*栈：一端开口一端封闭（开口栈顶、封闭栈底）\****

***\*数据进入栈模型的过程称为：压/进栈\****

***\*数据离开栈模型的过程称为：弹/出栈\****

在栈底的就是栈底元素，在栈顶的就是栈底元素

栈是一种数据先进后出的模型

 

 

### ***\*常见数据结构之队列：\****

***\*队列：两端开口（一端前端，一端后端）\****

***\*数据从\*******\*后端\*******\*进入队列模型的过程为：\*******\*入队列\****

***\*数据从\*******\*前端\*******\*离开队列模型的过程称为：\*******\*出队列\****

***\*队列是一种数据先进先出的模型\****

 

 

 

### ***\*常见数据结构之数组：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps33.png) 

 

### ***\*常见数据结构之链表：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps34.png) 

 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps35.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps36.png) 

### ***\*链表特点：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps37.png) 

 

## **List集合子类特点：**

**List集合常用子类：ArrayList、LinkedList**

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps38.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps39.jpg) 

 

### ***\*LinkedList集合特有的功能：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps40.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps41.png) 

 

## ***\*Set集合：\****

### ***\*特点：\****

***\*1.不包含重复元素的集合\****

***\*2.没有带索引的方法，所以不能用普通for循环遍历\****

***\*3.HashSet对集合的迭代顺序不作保证\****

 

### ***\*哈希值：\****

***\*概念：是JDK根据对象的地址或者字符串或者数字算出来的int类型的数值\****

***\*Object类中有一个方法可以获取对象的哈希值\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps42.png) 

### ***\*对象的哈希值特点：\****

***\*1.同一个对象多次调用hashCode方法返回的哈希值是相同的\****

***\*2.默认情况下，不同对象的哈希值是不相同的，通过重写hashCode()，可以实现不同对象的哈希值是相同的\****

 

### ***\*HashSet集合的概述和特点：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps43.png) 

### ***\*HashSet集合保证元素唯一性源码分析：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps44.png) 

***\*先比较哈希值，后比较对象内容是否相同。\****

***\*HashSet集合存储元素：要保证元素唯一性，需要重写hashCode()和equals（）方法\****

 

### ***\*常见数据结构之哈希表：\****

### ***\*哈希表：\****

**1.** ***\*JDK8之前，底层采用数组+链表实现，可以说是一个元素为链表的数组\****

**2.** ***\*JDK8之后，在长度比较长的时候，底层实现了优化\****

 

 

### ***\*LinkHashSet集合的概述和特点：\****

**1.** ***\*哈希表和链表实现了\*******\*Set\*******\*接口，具有可预测的迭代次序。\****

**2.** ***\*由链表保证元素有序，也就是说元素的存储和取出顺序是一致的\****

**3.** ***\*由哈希表保证元素唯一性，也就是说没有重复的元素\****

 

 

### ***\*TreeSet集合的概述和特点：\****

**1.** ***\*元素有序，这里的顺序不是指存储和取出的顺序，而是按照一定的规则进行排序，具体排序方式取决于构造方法\****

***\*TreeSet():根据元素的自然排序进行排序\****

***\*TreeSet(Comparator comparator):根据指定的比较器进行排序\****

**2.** ***\*没有带索引的方法。所以不能使用普通for循环遍历\****

**3.** ***\*由于是Set集合，所以不包含重复元素的集合\****

 

## ***\*Comparable的使用：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps45.png) 

 

### ***\*Comparator的使用：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps46.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps47.png) 

### ***\*泛型：\****

### ***\*概述：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps48.png) 

### ***\*好处：\****

***\*1.把运行时期的问题提前到了编译期间\****

***\*2.避免了强制类型转换\****

 

### ***\*泛型类：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps49.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps50.png) 

### ***\*泛型方法：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps51.png) 

### ***\*泛型接口：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps52.png) 

### ***\*类型通配符：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps53.png) 

 

### ***\*可变参数：\****

***\*可变参数又称参数个数可变，用作方法的形参出现，那么方法参数个数就是可变的了\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps54.png) 

### ***\*注意事项：\****

***\*这里的变量a是一个数组\****

***\*一个方法有多个参数，包含可变参数，可变参数要放到最后\****

 

### ***\*可变参数的使用：\****

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps55.png) 

***\*Arrays.asList方法得到的集合，不能使用add添加和remove删除方法，因为添加和删除会改变集合的大小，但是可以使用修改方法，修改方法不影响集合大小\****

 

***\*通过List.of方法得到的集合，增删改方法都不能使用\****

***\*通过set.of得到的集合，增删方法不能使用，没有修改的方法,而且不能给重复元素\****

 

## Map集合和概述：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps56.png) 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps57.png) 

### Map集合的遍历：

#### 方式一：![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps58.jpg)

#### 方式二：

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml16880\wps59.jpg) 

### 统计字符串每个字符出现的次数:

```java
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();
        //创建HashMap集合,键是Character,值是Integer
        HashMap<Character, Integer> hm = new HashMap<>();

        //遍历字符串
        for(int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);

            //拿到的每个字符作为键到HashMap集合中找到对应的值
            Integer value = hm.get(key);
            if (value == null) {
                hm.put(key,1);
            }else {
                value++;
                hm.put(key,value);
            }
        }

        //遍历HashMap集合，得到键和值
        StringBuilder sb = new StringBuilder();
        Set<Character> keyset = hm.keySet();
        for(Character key : keyset){
            Integer value = hm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }
        String result = sb.toString();
        System.out.println(result);
    }
```



### Collections类概述和使用：

概述：是针对集合操作的工具类

![image-20230114220148471](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230114220148471.png)



### 模拟斗地主代码：

```java
public class PokerDemo01 {
    public static void main(String[] args) {
        //创建HashMap，键是编号，值是牌
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        //创建ArrayList,存储编号
        ArrayList<Integer> array = new ArrayList<Integer>();

        //定义花色数组  ♦ ♣ ♥ ♠
        String[] colors = {"♦", "♣", "♥", "♠"};
        //定义点数数组
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //往HashMap里存储编号
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;
            }
        }
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        //洗牌洗编号
        Collections.shuffle(array);

        //发牌
        TreeSet<Integer> lqxSet = new TreeSet<Integer>();
        TreeSet<Integer> lySet = new TreeSet<Integer>();
        TreeSet<Integer> fqySet = new TreeSet<Integer>();
        TreeSet<Integer> dpSet = new TreeSet<Integer>();
        
        for (int i = 0; i < array.size() - 3; i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                dpSet.add(x);
            } else if (i % 3 == 0) {
                lqxSet.add(x);
            } else if (i % 3 == 1) {
                lySet.add(x);
            } else if (i % 3 == 2) {
                fqySet.add(x);
            }
        }
            //定义方法看牌
            LookPoker("林青霞",lqxSet,hm);
            LookPoker("柳岩",lySet,hm);
            LookPoker("风清扬",fqySet,hm);
            LookPoker("底牌",dpSet,hm);
        }
        public static void LookPoker(String name,TreeSet <Integer> ts,HashMap<Integer,String> hm){
            System.out.print(name+"的牌是:");
            for(Integer key : ts){
                String poker = hm.get(key);
                System.out.print(poker+" ");
            }
            System.out.println();
        }
```



## File类概述和构造方法：

File：是文件和目录路径名的抽象表示

1.文件和目录是可以通过File封装成对象的

2.对于File而言，其封装的并不是一个真正存在的文件，仅仅是一个路径名而已，他可以是存在的，也可以是不存在的。将来是要通过具体的操作把这个路径的内容转换为具体存在的

![image-20230115131106679](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230115131106679.png)

File类创建功能：

![image-20230115131659570](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230115131659570.png)



创建文件就要用创建文件的方法，创建目录就用创建目录的方法



### File类删除功能：

![image-20230115141058958](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230115141058958.png)

绝对路径和相对路径的区别：

1.绝对路径：完整的路径名，不需要任何其他信息就可以定位它所表示的文件。例如：E：\\itcast\\java.txt

2.相对路径：必须使用取自其他路径名的信息进行解释。例如：myFile\\java.txt

删除目录时的注意事项：

如果一个目录中有内容（目录、文件），不能直接删除，应该先删除目录中的内容，最后才能删除目录。



### 递归：

概述：以编程的角度来看，递归指的是方法定义中调用方法本身的现象

用递归解决问题一定要有出口，否则会报递归太深的错误，导致内存溢出

递归解决问题的思路：

把一个复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解，递归策略只需少量的程序就可描述出解题过程所需要的多次重复计算

#### 递归解决问题要找到两个内容：

1.递归出口：否则会出现内存溢出

2.递归规则：与原问题相似的规模较小的问题



#### 遍历目录（递归）：

```java
    public static void main(String[] args){
        //根据给定路径创建一个File对象
        File srcFile = new File("E:\\itcase");

        //调用方法
        getAllFilePath(srcFile);
    }

    public static void getAllFilePath(File srcFile){
        //获取目录下所有文件和目录的数组
        File[] fileArray = srcFile.listFiles();
        //遍历该数组，得到每一个对象
        if (fileArray != null) {
            for(File file : fileArray){
                //判断是否是目录
                if (file.isDirectory()){
                    //是就递归调用
                    getAllFilePath(file);
                }else {
                    //获取绝对路径
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
```



## IO流：

### 概述：

IO：输入（读数据）/输出（写数据）

流：是一种抽象概念，是对数据传输的总称，也就是说数据在设备间的传输称为流，流的本质是数据传输

IO流就是用来处理设备间数据传输问题的

​            常见应用：文件复制、文件上传、文件下载

### IO流分类：

按照数据的流向分为：

1.输入流：读数据

2.输出流：写数据

按照数据类型来分：

字节流：（读不懂的文件）

​             字节输入流；字节输出流

字符流：（读的懂得内容）   

​            字符输入流；字符输出流

一般来说，我们说IO流的分类是按照数据类型来分的

如果数据通过Window自带的记事本软件打开，我们还可以读懂里面的内容，就使用字符流，否则使用字节流。如果你不知道该使用哪种类型的流，就用字节流



## 字节流：

### 字节流写数据：

字节流抽象基类：

1.InputStream : 这个抽象类是表示字节输入流的所有类的超类

2.OutputStream : 这个抽象类是表示字节输出流的所有类的超类

子类名特点：子类名称都是以父类名作为子类的后缀



FileOutputStream : 文件输出流用于将数据写入File

​       FileOutputStream(String name) : 创建文件输出流以指定的名称写入文件



使用字节输出流写数据的步骤：

1.创建字节输出流对象（调用系统功能创建了文件，创建字节输出对象，让字节输出流对象指向文件）

2.调用字节输出流对象的写数据方法

3.释放资源（关闭此文件输出流并释放与此流相关联的任何系统资源）

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("E:\\JAVA\\javaproject\\fos.txt");
        /*
       做了三件事情：
       A：调用系统功能创建文件
       B：创建字节输出流对象
       C：让字节流对象指向创建好的文件
         */

        //void write(int b), 将指定的字节写入此文件输出流
        fos.write(97);
//        fos.write(57);
//        fos.write(55);

        //最后都要释放资源
        //void close(): 关闭此文件输出流并释放于此流相关联的任何系统资源
        fos.close();
    }
```



字节流写入数据的三种方法：

![image-20230115184916223](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230115184916223.png)

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //FileOutputStream (String name): 创建文件输出流以指定的名称写入文件
        FileOutputStream fos = new FileOutputStream("E:\\JAVA\\javaproject\\fos.txt");
        //new File(name)
//        FileOutputStream fos = new FileOutputStream(new File("E:\\JAVA\\javaproject\\fos.txt"));

        //FileOutputStream (File file): 创建文件输出流以写入由指定的File对象表示的文件
//        File file = new File("E:\\JAVA\\javaproject\\fos.txt");
//        FileOutputStream fos2 = new FileOutputStream(file);
        FileOutputStream fos2 = new FileOutputStream(new File("E:\\JAVA\\javaproject\\fos.txt"));

        //void write(int b): 将指定的字节写入此文件输出流
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.write(100);
        fos.write(101);

        fos.write(10);

        //void write(byte[] b): 将b.length字节从指定的字节数组写入此文件输出流
        byte[] bys = {97,98,99,100,101};
        //byte[] getBytes(): 返回字符串对应的字节数组
        byte[] bytes = "abcde".getBytes();
        fos.write(bytes);

        fos.write(10);

        //void write(byte[] b, int off, int len): 将len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流
        fos.write(bys,1,3);

        //释放资源
        fos.close();
    }
```



#### 字节流写数据的两个小问题：

1.字节流写数据如何实现换行？

写完数据后，加换行符

windows：\r\n

Linux：\n

mac：\r 



2.字节流写数据如何实现追加写入呢？

public FileOutputStream(String name,Boolean append)

创建文件输出流以指定的名称写入文件。如果第二个参数为true，则字节将写入文件的末尾而不是开头



代码实现：

```java
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
//        FileOutputStream fos = new FileOutputStream("E:\\JAVA\\javaproject\\fos.txt");
        FileOutputStream fos = new FileOutputStream("E:\\JAVA\\javaproject\\fos.txt",true);

        //写数据
        for (int i = 0; i < 10; i++){
            fos.write("hello".getBytes());
            fos.write("\n".getBytes());
        }

        //释放资源
        fos.close();
    }
```



#### 字节流写数据加异常处理：

finally：在异常处理时提供finally块来执行所有清楚操作。比如说IO流中的释放资源特点：被finally控制的语句一定会执行，除非JVM退出

```java
try{
		//可能出现异常的代码
}catch(异常类名 变量名){
		//异常的处理代码
}finally {
		//执行所有清除操作;
}
```



代码演示：

```java
public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\JAVA\\javaproject\\fos.txt");
            fos.write("hello".getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```



#### 字节流读数据：

FileInputStream：从文件系统中的文件获取输入字节

FileInputStream(String name)：通过打开与实际文件的连接来创建一个FileInputStream，该文件由文件系统中的路径名name命名



使用字节输入流读数据的步骤：

1.创建字节输入流对象

2.调用字节输入流对象的读取方法

3.释放资源



代码演示：

```java
public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        //FileInputStream(String name)
        FileInputStream fis = new FileInputStream("E:\\JAVA\\javaproject\\fos.txt");
         int by2;
        /*
            fis.read():读数据
            by=fis.read():把读取到的数据赋值给by
            by != -1,判断读取到的数据是否是-1
         */
        while ((by2 = fis.read()) != -1){
            System.out.print((char)by2);
        }
        //释放资源
        fis.close();
    }
```



复制文本文件：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //根据数据源创建字节输入流对象
        FileInputStream fis = new FileInputStream("E:\\itcase\\kk.txt");
        //根据目的地创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("E:\\MyByte\\abc.txt");

        //读写数据，复制文本文件（一次读取一个字节，一次写入一个字节）
        int by = fis.read();
        while((by=fis.read()) != -1){
            fos.write(by);
        }
        //释放资源
        fos.close();
        fis.close();
    }
```



字节流读数据（一次读一个字节数组数据）：

使用int read(byte[] b)，从该输入流读取最多b.length个字节的数据到一个字节数组

代码演示：

```java
 public static void main(String[] args) throws IOException {
        //根据数据源创建字节输入流对象
        FileInputStream fis = new FileInputStream("E:\\JAVA\\javaproject\\fos.txt");
         //使用循环读取
        byte[] bys = new byte[1024];
        int len;
        while((len=fis.read(bys)) != -1) {
            System.out.println(new String(bys,0,len));
        }
        //释放数据
        fis.close();
    }
```



复制图片：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //根据数据源创建字节输入流对象
        FileInputStream fis = new FileInputStream("E:\\itcase\\1.jpg");

        //根据目的地创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("E:\\MyByte\\1.jpg");

        //读写数据，复制图片（一次读取一个字节，一次写入一个字节）
        byte[] bys = new byte[1024];
        int len;
        while((len = fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }
        //释放资源
        fis.close();
        fos.close();
    }
```



### 字节缓冲流：

BufferOutputStream：该类实现缓冲输出流。通过设置这样的输出流，应用程序可以向底层输出流写入字节，而不必为写入的每个字节导致底层系统的调用

BufferedInputStream：创建BufferedInputStream将创建一个内部缓冲区数组。当从流中读取或跳过字节时，内部缓冲区将根据需要从所包含的输入流中重新填充，一次很多字节



构造方法：

字节缓冲输出流：BufferedOutputStream（OutputStream out）

字节缓冲输入流：BufferedInputStream（InputStream in）



为什么构造方法需要的是字节流，而不是具体的文件或者路径呢？

字节缓冲流仅仅提供缓冲区，而真正的读写数据还得依靠基本的字节流对象进行操作

代码演示：

```java
 public static void main(String[] args) throws IOException {
        //字节缓冲输出流，BufferedOutputStream(OutputStream out)
//        FileOutputStream fos = new FileOutputStream("E:\\itcase\\kk.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\itcase\\kk.txt"));
        //写数据
        bos.write("hello\n".getBytes());
        bos.write("world\n".getBytes());
        //释放资源
        bos.close();

        //字节缓冲输入流：BufferedInputStream（InputStream in）
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcase\\kk.txt"));

        //一次读取一个字节数据
//        int by;
//        while ((by = bis.read()) != -1){
//            System.out.print((char)by);
//        }
        //一次读一个字节数组数据
        byte[] bys = new byte[1024];
        int len;
        while((len = bis.read(bys)) != -1){
            System.out.print(new String(bys,0,len));
        }
        //释放资源
        bis.close();
    }
```



复制视频：

与视频复制类似。



## 字符流：

一个汉字存储：

​				如果是GBK编码，占用2个字节

​				如果是UTF-8，占用3个字节

由于字节流操作中文不是特别方便，所以JAVA就提供了字符流

1.字符流 = 字节流 + 编码表



用字节流复制文本时，文本文件也会有中文，但是没有问题，原因是最终底层操作会自动进行字节拼接成中文

如何识别中文的呢？

汉字在存储的时候，无论选择哪种编码存储，第一个字节都是负数



#### 编码表：

基础知识：

1.计算机中存储的信息都是用二进制数表示的；我们在屏幕上看到的英文、汉字等字符是二进制数转换之后的结果

2.按照某种规则，将字符存储到计算机中，称为编码，反之，将储存在计算机中的二进制数按照某种规则解析出来，称为解码。这里强调一下：按照A编码存储，必须按照A编码解析，这样才能显示正确的文本符号。否则会出现乱码现象。

​		字符编码：就是一套自然语言的字符与二进制数之间的对应规则（A—65）



#### 字符集：

1.是一个系统支持的所有字符的集合，包括各种国家的文字、标点符号、图形符号、数字等

2.计算机要准确的存储和识别各种字符集符号，就需要进行字符编码，一套字符集必然至少有一套字符编码。

常见字符集有ASCll字符集、GBXXX字符集、Unicode字符集等



#### 编码解码问题：

编码：

byte[] getBytes() ：使用平台的默认字符集将该String编码为一系列字节，将结果存储到新的字节数组中

byte[] getBytes(String charseName) ：使用指定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中



解码：

String(byte[] bytes)：通过平台使用的默认字符集解码指定的字节数组来构造新的String

String(byte[] bytes,String charseName)：通过指定的字符集解码指定的字节数组来构造新的String



代码演示：

```java
public static void main(String[] args) throws UnsupportedEncodingException {
        //定义一个字符串
        String s = "中国";

        //byte[] getBytes():使用平台的默认字符集将该String编码为一系列字节，将结果存储到新的字节数组中
        byte[] bys = s.getBytes();  //[-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bys));

        //byte[] getBytes(String charseName) ：使用指定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中
        byte[] bys2 = s.getBytes("UTF-8"); //[-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bys2));

        byte[] bys3 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bys3));

       // String(byte[] bytes)：通过平台使用的默认字符集解码指定的字节数组来构造新的String
        String ss = new String(bys);
        System.out.println(ss);

        String ss1 = new String(bys2,"UTF-8");
        System.out.println(ss1);

        String ss2 = new String(bys3,"GBK");
        System.out.println(ss1);
    }
```

注意：使用何种字符集编码就要用对应的字符集解码



#### 字符流中的编码解码问题：

字符流抽象基类：

1.Reader：字符输入流的基类

2.Writer：字符输出流的抽象类



字符流中和编码解码问题相关的两个类：

InputStreamReader

OutputStreamWriter

代码演示：

```java
  public static void main(String[] args) throws IOException {
        //OutputStreamWriter（OutputStream out）创建一个使用默认字符编码的OutputStreamWriter.
        //OutputStreamWriter(OutputStream out,String charsetName)创建一个使用命名字符集的OutputStreamWriter。
//        FileOutputStream fos = new FileOutputStream("E:\\MyByte\\abc.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        相当于OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\MyByte\\abc.txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\MyByte\\abc.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\MyByte\\abc.txt"),"GBK");
        osw.write("中国");
        osw.close();

        //InputStreamReader(InputStream in) 创建一个使用默认字符集的InputStreamReader.
        //InputStreamReader(InputStream in,String chaseName)创建一个使用命名字符集的InputStreamReader.
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\MyByte\\abc.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\MyByte\\abc.txt"),"GBK");
        //一次读取一个字符数据
        int ch;
        while ((ch=isr.read())!=-1){
            System.out.print((char)ch);
        }
        isr.close();
    }
```



字符流写数据的5种方式：

![image-20230116201926100](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230116201926100.png)

用字符流写数据先在一个缓冲区里，最终要通过字节流来写，所以要使用刷新流刷新数据才能写入，否则数据无法进去

真正往文件写数据用的是底层的字节流，字符流相对于字节流是有缓冲的



flush()方法：刷新流，还可以继续写数据

close()方法：关闭流，释放资源，但是在关闭之前会先刷新流。一旦关闭，就不能再写数据

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //OutputStreamWriter（OutputStream out）创建一个使用默认字符编码的OutputStreamWriter.
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\MyByte\\abc.txt"));

//        //void write(int c),写一个字符
//        osw.write(97);
//        //void Flush()：刷新流
//        osw.flush();
//        osw.write(98);
//        osw.flush();
//        osw.write(99);

        //void write(char[] cbuf):写入一个字符数组
        char[] chs = {'a','b','c','d','e'};
        osw.write(chs);

        //void write(char[] cbuf,int off,int len)：写入字符数组的一部分
        osw.write(chs,1,3);

        //void write(String str)：写一个字符串
        osw.write("abcde");

        //void write(String str,int off,int len)：写一个字符串的一部分
        String str = "abcde";
        osw.write(str,1,3);

        //释放资源
        osw.close();  //先刷新缓冲，再释放资源,释放资源之后不能再写入数据
//        osw.write(100);
        //Exception in thread "main" java.io.IOException: Stream closed
    }
```



字符流读数据的两种方式：

int read()方法：一次读一个字符数据

int read(char[] cbuf)方法：一次读一个字符数组数据

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //InputStreamReader（InputStream out）创建一个使用默认字符编码的InputStreamReader.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\JAVA\\javaproject\\src\\javacode\\CatDog\\Cat.java"));

        //int read()方法：一次读一个字符数据
//        int ch;
//        while ((ch= isr.read())!=-1){
//            System.out.println((char)ch);
//        }

        //int read(char[] cbuf)方法：一次读一个字符数组数据
        char[] chs = new char[1024];
        int len;
        while ((len=isr.read(chs))!=-1){
            System.out.print(new String(chs,0,len));
        }

        //释放资源
        isr.close();
    }
```



复制java文件：

代码演示：

```java
 public static void main(String[] args) throws IOException {
        //根据数据源创建字符输入流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\itcase\\Cat.java"));

        //根据目的地创建字符输出流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\MyByte\\Cat.java"));

        //读写数据，复制文件
        //一次读取一个字符数据
//        int ch;
//        while ((ch=isr.read())!=-1){
//            osw.write(ch);
//        }

        //一次读取一个字符数组的数据
        char[] chs = new char[1024];
        int len;
        while ((len=isr.read(chs))!=-1){
            osw.write(chs,0,len);
            System.out.print(new String(chs,0,len));
        }

        //释放资源
        osw.close();;
        isr.close();
    }
```



改进版复制java文件：

FileReader：用于读取字符文件的便捷类

​		FileReader(String fileName)

FileWriter：用于写入字符文件的便捷类

​		FIleWriter(String fileName)

代码演示：

```java
public static void main(String[] args) throws IOException {
        //根据数据源创建字符输入流对象FileReader(String fileName)
        FileReader fr = new FileReader("E:\\itcase\\Cat.java");

        //根据目的地创建字符输出流对象FIleWriter(String fileName)
        FileWriter fw = new FileWriter("E:\\MyByte\\Cat.java");

        //读写数据，复制文件
//        一次读取一个字符数据
//        int ch;
//        while ((ch=fr.read())!=-1){
//            fw.write(ch);
//        }
        
        //读写数据，复制文件
        char[] chs = new char[1024];
        int len;
        while ((len=fr.read(chs))!=-1){
            fw.write(chs,0,len);
            System.out.print(new String(chs,0,len));
        }
        //释放文件
        fr.close();
        fw.close();
    }
```



### 字符缓冲流：

BufferedWriter：将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入，可以指定缓冲区的大小。默认值足够大，可用于大多用途

BufferedWriter：从字符输入流读取文本，缓冲字符，以提供字符，数组和行的高效读取，可以指定缓冲区大小，或者可以使用默认的大小。默认值足够大，可用于大多用途

构造方法：

BufferedWrite(Writer out)

BufferedReader(Reader in) 

代码演示：

```java
    public static void main(String[] args) throws IOException {
//        BufferedWriter(Writer out)
//        FileWriter fw = new FileWriter("E:\\itcase\\kk.txt");
//        BufferedWriter bw = new BufferedWriter(fw);
//        //相当于BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));
//
//        bw.write("hello\n");
//        bw.write("world\n");

        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));
        //一次读取一个字符数据
//        int ch;
//        while ((ch=br.read())!=-1){
//            System.out.print((char) ch);
//        }

        //一次读取一个字符数组数据
        char[] chs = new char[1024];
        int len;
        while ((len=br.read(chs))!=-1){
            System.out.print(new String(chs,0,len));
        }
        
        //释放资源
//        bw.close();
        br.close();
    }
```



复制java文件（字符缓冲流改进版）

代码演示：

```java
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\MyByte\\abc.txt"));

        //读写数据，复制文件
        //一次读取一个字符数据
        int ch;
        while ((ch=br.read())!=-1){
          bw.write((char)ch);
        }
        
        //一次读取一个字符数组数据
//        char[] chs = new char[1024];
//        int len;
//        while ((len=br.read(chs))!=-1){
//            bw.write(chs,0,len);
//        }

        //释放资源
        bw.close();
        br.close();
    }
```



字符缓冲流特有功能

BufferedWriter：

​		void newLine()：写一行行分隔符，行分隔符字符串由系统属性定义



BufferedReader：

​		public String readLine()：读一行文字。结果包含行的内容的字符串，不包括任何行终止字符，如果流的结尾已经到达则为null

代码演示：

```java
    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\MyByte\\abc.txt"));

        //写数据
        for(int i = 0; i < 10; i++){
            bw.write("hello" + i);
//            bw.write("\n");
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
        */

        //创建字符缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\MyByte\\abc.txt"));

        //public String readLine():读一行文字,只读内容，不读换行符号
        String line;
        while ((line=br.readLine()) != null){
            System.out.println(line);
        }

        //释放资源
        br.close();
    }
```



复制java文件（字符缓冲流特有功能改进版）

代码演示：

```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\MyByte\\abc.txt"));

        //读写数据，复制文件
        //使用字符缓冲流特有的功能实现
        String line;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        bw.close();
    }
```



### IO流小结：

#### 字节流：

![image-20230117114219561](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230117114219561.png)

![image-20230117113809178](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230117113809178.png)



#### 字符流：

![image-20230117122421278](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230117122421278.png)

![image-20230117122655280](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230117122655280.png)



## 集合与文件：

### 集合到文件：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //创建ArrayList集合
        ArrayList<String> array = new ArrayList<String>();

        //往集合中存储字符串元素
        array.add("hello");
        array.add("world");
        array.add("java");

        //创建字符缓冲输出流对象
        BufferedWriter bw  = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));

        //遍历集合，得到每一个字符串数据
        for(String s : array){
            //使用字符缓冲流对象的方法写入数据
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
```



### 文件到集合：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));

        //创建结合对象
        ArrayList<String> array = new ArrayList<String>();

        //读写数据，复制文件
        //使用字符缓冲流特有的功能实现
        String line;
        while ((line=br.readLine()) != null){
                array.add(line);
        }

        //遍历集合对象
        for(String s : array){
            System.out.println(s);
        }

        //释放资源
        br.close();
    }
```

### 点名器：

```java
    public static void main(String[] args) throws IOException {
        //创建字符流输出对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));

        //创建集合对象
        ArrayList<String> array = new ArrayList<String>();

        //使用字符缓冲流特有的功能实现
        String line;
        while ((line=br.readLine()) != null){
            array.add(line);
        }

        for (int i = 0; i < 10; i++) {
            //创建随机数对象
            Random r = new Random();
            int n = r.nextInt(array.size());

            //获取学生名字
            String s = array.get(n);
            System.out.println(s);
        }
        //释放资源
        br.close();
    }
```



### 集合到文件（改进版）：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //创建学生对象
        Student s1 = new Student("itheima001","林青霞",30,"西安");
        Student s2 = new Student("itheima002","张曼玉",35,"北京");
        Student s3 = new Student("itheima003","王祖贤",33,"香港");

        //创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //将学生对象添加到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //创建字符缓冲输出流对象
        BufferedWriter bw  = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));

        //遍历集合,将数据写入文件
        for(Student stu : array){
            //把学生对象的数据拼接成指定格式的字符串
            StringBuilder sb = new StringBuilder();
            sb.append(stu.getSid()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress());
            //用字符缓冲输出流对象的方法写数据
            //            bw.write(stu.getSid()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
```



### 文件到集合（改进版）：

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //创建字符输入流对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\kk.txt"));

        //使用字符缓冲流特有的功能实现
        String line;
        while ((line=br.readLine()) != null){
            //把读取到的字符串数据用split()方法进行分割，得到一个字符串数组
            String[] strArray = line.split(",");

            //创建学生对象
            Student s = new Student();
            //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
            s.setSid(strArray[0]);
            s.setName(strArray[1]);
            s.setAge(Integer.parseInt(strArray[2]));
            s.setAddress(strArray[3]);

            //把学生对象添加到集合
            array.add(s);
        }
        //释放资源
        br.close();

        //遍历集合
        for(Student s : array){
            System.out.println(s.getSid()+","+s.getName()+"s"+s.getAge()+","+s.getAddress());
        }
    }
```



### 集合到文件数据排序改进版：

```java
    public static void main(String[] args) throws IOException {
        //创建TreeSet集合,通过比较器排序进行排序
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //成绩从高到低
                int num = s2.getSum() - s1.getSum();
                //次要条件
                int num2 = num ==0 ? s1.getChinese()-s2.getChinese():num;
                int num3 = num2 == 0 ? s1.getMath()-s2.getMath():num2;
                int  num4 = num3==0 ? s1.getName().compareTo(s2.getName()):num3;
                return num4;
            }
        });

        //键盘输入学生数据
        for(int i=0; i<5; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第"+(i+1)+"个学生的信息");
            System.out.println("姓名:");
            String name = sc.nextLine();
            System.out.println("语文成绩");
            int chinese = sc.nextInt();
            System.out.println("数学成绩");
            int math = sc.nextInt();
            System.out.println("英语成绩");
            int english = sc.nextInt();

            //创建学生对象
            Student s = new Student(name,chinese,math,english);

            //把学生对象添加到TreeSet集合中
            ts.add(s);
        }

        //创建字符缓冲输出流对象
        BufferedWriter bw  = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));

        //遍历集合，得到每一个学生对象
        for(Student s : ts){
            //把学生对象的数据拼接成指定格式的字符串
            //格式：姓名，语文成绩，数学成绩，英语成绩
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getChinese()).append(",").append(s.getMath()).append(",").append(s.getEnglish()).append(",").append(s.getSum());
            //用字符缓冲输出流对象的方法写数据
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
```



### 复制单级文件夹：

代码演示：

```java
public static void main(String[] args) throws IOException {
        //创建数据源目录对象，路径是E:\\itcase
        File srcFloder = new File("E:\\itcase");

        //获取数据源目录File对象的名称（itcase）
        String srcFolderName = srcFloder.getName();

        //创建目的地目录对象，路径名是模块名+itcast组成（E:\\MyByte\\itcast）
        File destFolder = new File("E:\\MyByte",srcFolderName);

        //判断目的地目录对应的itcast是否存在，如果不存在，就创建
        if(!destFolder.exists()){
            destFolder.mkdir();
        }

        //获取数据源目录下所有文件的File数组
        File[] listFiles = srcFloder.listFiles();

        //遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
        for (File srcFile : listFiles){
            //数据源文件:E:\\itcase\\1.jpg
            //获取数据源文件File对象的名称（1.jpg）
            String srcFileName = srcFile.getName();
            //创建目的地文件File对象，路径名是目的地目录+1.jpg组成(E:\\MyByte\\itcast\\1.jpg)
            File destFile = new File(destFolder,srcFileName);
            //复制文件
            copyFile(srcFile,destFile);
        }
```

```java
private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
```



### 复制多级文件夹：

代码实现：

```java
 public static void main(String[] args) throws IOException {
       //创建数据源File对象，路径是E:\\itcase
       File srcFile = new File("E:\\itcase");
       //创建目的地File对象，路径是E:\\MyByte
        File destFile = new File("E:\\MyByte");

        //写方法实现文件夹的复制，参数作为数据源File对象和目的地File对象
        copyFolder(srcFile,destFile);
    }
```

```java
//复制文件夹
private static void copyFolder(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()){
            //在目的地下创建和数据源File一样的目录
            String srcFileName= srcFile.getName();
            File newFolder = new File(destFile,srcFileName);
            if (!newFolder.exists()){
                newFolder.mkdir();
            }
            //获取数据源File下所有文件或者目录的File数组
            File[] fileArray = srcFile.listFiles();

            //遍历该File数组，得到每一个File对象
            for (File file: fileArray){
                //把该File作为数据源File对象，递归调用复制文件夹的方法
                copyFolder(file,newFolder);
            }
        }else {
            //说明是文件，直接复制，用字节流
            File newFile = new File(destFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }
```

```java
    //字节流复制文件
    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
```



### 复制文件的异常处理：

使用try...catch...finally的做法：

```java
try{
		//可能出现异常的代码
}catch(异常类名 变量名){
		//异常的处理代码
}finally {
		//执行所有清除操作;
}
```

```java
 public static void methods(){
        FileReader fr = null;
        FileWriter fw = null;
        try{
        fr = new FileReader("fr.txt");
        fw = new FileWriter("fw.txt");

        char[] chs = new char[1024];
        int len;
        while ((len=fr.read())!=-1){
            fw.write(chs,0,len);
        }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (fw != null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
```

JDK7改进方案：

```java
try(定义流对象){
		//可能出现异常的代码
}catch(异常类名 变量名){
		//异常的处理代码
}
		
		自动释放资源
```

```java
public static void methods(){
        try(FileReader fr = new FileReader("fr.txt");
            FileWriter fw = new FileWriter("fw.txt");){

        char[] chs = new char[1024];
        int len;
        while ((len=fr.read())!=-1){
            fw.write(chs,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
```

JDK9改进方案：

```java
定义输入流对象;
定义输出流对象;
try(输入流对象;输出流对象){
		//可能出现异常的代码
}catch(异常类名 变量名){
		//异常的处理代码
}
		
		自动释放资源
```

```java
public static void methods() throws IOException {
        FileReader fr = new FileReader("fr.txt");
        FileWriter fw = new FileWriter("fw.txt");
        try(fr;fw){
        char[] chs = new char[1024];
        int len;
        while ((len=fr.read())!=-1){
            fw.write(chs,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
```

JDK7方案较好。



## 特殊操作流：

### 标准输入输出流：

System类中有两个静态的成员变量：

public static final InputStream in：标准输入流。通常该流对应于键盘输入或由主机环境或用户指定的另一个输入源

public static final PrintSream out：标准输出流。通常该流对应于显示输出或由主机环境或用户指定的另一个输出目标

#### 标准输入流：

代码演示：

```java
 public static void main(String[] args) throws IOException {
        //public static final InputStream in：标准输入流。
        InputStream is = System.in;

//        int by;
//        while ((by=is.read())!=-1){
//            System.out.print((char)by);
//        }

        //如何把字节流转换为字符流？用转换流
//        InputStreamReader isr = new InputStreamReader(is);
        //使用字符流能不能实现一次读取一行数据呢？可以
        //但是，一次读取一行数据的方法是字符缓冲输入流的特有方法
//        BufferedReader br = new BufferedReader(isr); 与下面一行相等
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串:");
        String line = br.readLine();
        System.out.println("你输入的字符串是:"+line);

        System.out.println("请输入一个整数:");
        int i = Integer.parseInt(br.readLine());
        System.out.println("你输入的整数是:"+i);
    }
```

自己实现键盘录入数据：

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```



写起来太麻烦，java就提供了换一个类实现键盘录入：

Scanner sc = new Scanner(System.in);



#### 标准输出流：

输出语句的本质：是一个标准的输出流

PrintStream ps = System.out;

PrintStream类有的方法，System.out都可以使用



### 打印流：

打印流分类：

​		字节打印流：PrintStream

​		字符打印流：PrintWriter



打印流的特点：

1.只负责输出数据，不负责读取数据

2.有自己的特有方法



#### 字节打印流：

PrintStream(String fileName)：使用指定的文件名创建新的打印流

使用继承父类的方法写数据，查看的时候会转码；使用自己特有的方法写数据，查看的数据原样输出



#### 字符打印流：

![image-20230117213300516](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230117213300516.png)

代码演示：

```java
    public static void main(String[] arsg) throws IOException {
        //PrintWriter(String fileName): 使用指定的文件名创建一个新的PrintWriter，而不是
//        PrintWriter pw = new PrintWriter("E:\\itcase\\kkk.txt");

//        pw.write("hello");
//        pw.write("\n");
//        pw.flush();
//        pw.write("hello");
//        pw.write("\n");
//        pw.flush();

//        pw.println("hello");
//        /*
//           pw.write("hello");   相当于这两步
//           pw.write("\n");
//         */
//        pw.flush();
//        pw.println("world");
//        pw.println();

        PrintWriter pw = new PrintWriter(new FileWriter("E:\\itcase\\kkk.txt"),true);

        pw.println("hello");
        /*
            pw.flush();
            pw.println("world");
            pw.println();
         */
        pw.println("world");
        
        pw.close();
    }
```



复制java文件（打印流改进版）：

```java
public static void main(String[] args) throws IOException {
    /*
    //根据数据源创建字符输入连对象
    BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\Cat.java"));

    //根据目的地创建字符输出流对象
    BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\MyByte\\Cat.java"));

    //读写数据复制文件
    String line;
    while ((line=br.readLine())!=null){
        bw.write(line);
        bw.newLine();
        bw.flush();
    }
    //释放资源
    bw.close();
    br.close();
    */

    //根据数据源创建字符输入连对象
    BufferedReader br = new BufferedReader(new FileReader("E:\\itcase\\Cat.java"));
    //根据目的地创建字符输出流对象
    PrintWriter pw = new PrintWriter(new FileWriter("E:\\MyByte\\Cat.java"),true);

    //读写数据复制文件
    String line;
    while ((line=br.readLine())!=null){
        pw.println(line);
    }

    //释放资源
    pw.close();
    br.close();
}
```



#### 对象序列化流：

对象序列化：就是将对象保存到磁盘中，或者在网络中传输对象

这种机制就是使用一个字节序列表示一个对象，该字节序列包含：对象的类型，对象的数据和对象中存储的属性等信息。字节序列写到文件之后，相当于文件中持久保存了一个对象的信息。

反之，该字节序列还可以从文件中读取回来，重构对象，对他进行反序列化



要实现序列化和反序列化就是要使用对象序列化流和对象反序列化流：

对象序列化流：ObjectOutputStream

对象反序列化流：ObjectInputStream



##### 对象序列化流：ObjectOutputStream:

将java对象的原始数据类型和图形写入OutputStream。可以使用ObjectInputSream读取（重构）对象。可以通过使用流的文件来实现对象的持久存储。如果流是网络套接字流，则可以在另一个主机上或另一个进程中重构对象

构造方法：

ObjectOutputStream(OutputStream out)：创建一个写入指定的OutputStream的ObjectOutputStream

序列化对象的方法：

void writeObject(Object obj)：将指定的对象写入ObjectOutputStream



代码演示：

```java
public static void main(String[] args) throws IOException {
    //ObjectOutputStream(OutputStream out)：创建一个写入指定的OutputStream的ObjectOutputSream
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\itcase\\kk.txt"));

    //创建对象
    Student s = new Student("林青霞",30);

    //void writeObject(Object obj):将指定的对象写入ObjectOutputStream
    oos.writeObject(s);

    //释放资源
    oos.close();
```

注意：

一个对象要想被序列化，该对象所属的类必须实现Serializable接口

Serializable是一个标记接口，实现该类接口，不需要重写任何方法



##### 对象反序列化流：ObjectInputStream：

ObjectInputStream反序列化先前使用ObjectOutputSream编写的原始数据和对象



构造方法：

ObjectInputStream(InputStream in)：创建从指定的InputStream读取的ObjectInputStream



反序列化对象的方法：

ObjectreadObject()：从ObjectInputStream读取一个对象

代码演示：

```java
public static void main(String[] args) throws IOException, ClassNotFoundException {
    //ObjectInputStream(InputStream in)：创建从指定的InputStream读取的ObjectInputStream
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\itcase\\kk.txt"));

    //ObjectreadObject()：从ObjectInputStream读取一个对象
    Object obj = ois.readObject();

    Student s = (Student) obj;
    System.out.println(s.getName()+','+s.getAge());

    //释放资源
    ois.close();
}
```



用对象序列化流序列化了一个对象后，假如我们修改了对象所属的类文件，读取数据会不会出问题呢？

会出问题：会抛出InvalidClassException异常:
    	当序列化运行时检测到类中的一下问题之一时抛出：
        		类的串行版本与从流中读取的类描述符的类型不匹配
       		 该类包含未知的数据类型
        		该类没有课访问的无参数构造函数



如果出问题了，应该怎么解决？
    给对象所属的类加一个值：private static final long serialVersionUID = 42L;
    
 如果一个对象中的某个成员变量的值不想被序列化，又该如何实现呢？

​	给该成员变量加transient关键字修饰，该关键字标记的成员变量不参与序列化过程

   private transient int age;
     使用transient关键字修饰

代码演示：

```java
   public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }
        //序列化:
    public static void write() throws IOException {
        //ObjectOutputStream(OutputStream out)：创建一个写入指定的OutputStream的ObjectOutputSream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\itcase\\kk.txt"));
        //创建对象
        Student s = new Student("林青霞",30);
        //void writeObject(Object obj):将指定的对象写入ObjectOutputStream
        oos.writeObject(s);
        //释放资源
        oos.close();
    }
    //反序列化:
    public static void read() throws IOException, ClassNotFoundException {
        //ObjectInputStream(InputStream in)：创建从指定的InputStream读取的ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\itcase\\kk.txt"));
        //ObjectreadObject()：从ObjectInputStream读取一个对象
        Object obj = ois.readObject();
        Student s = (Student) obj;
        System.out.println(s.getName()+','+s.getAge());
        //释放资源
        ois.close();
    }
```



#### Properties：

概述：

1.是一个Map体系的集合类

2.Properties可以保存到流中或从流中加载

代码演示：

```java
public static void main(String[] args){
    //创建集合对象
    Properties prop = new Properties();

    //存储元素
    prop.put("itheima001","林青霞");
    prop.put("itheima002","张曼玉");
    prop.put("itheima003","王祖贤");

    //遍历集合
    Set<Object> keySet = prop.keySet();
    for(Object key : keySet){
        Object value = prop.get(key);
        System.out.println(key+","+value);
    }
}
```



Properties作为集合的特有方法：

![image-20230118124224679](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118124224679.png)

```java
 public static void main(String[] args){
        //创建集合对象
        Properties prop = new Properties();

        //Object setProperty(String key,String value):设置集合的键和值，都是String类型，底层调用Hashtable方法put
        prop.setProperty("itheima001","林青霞");
        prop.setProperty("itheima002","张曼玉");
        prop.setProperty("itheima003","王祖贤");

        //String getProperty(String key)：使用此属性列表中指定的键来搜索属性
//        System.out.println(prop.getProperty("itheima001"));

//        System.out.println(prop);

        //Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
        Set<String> names = prop.stringPropertyNames();
        for(String key : names){
//            System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(key+","+value);
        }
    }
```



#### Properties和IO流结合的方法：

![image-20230118130522673](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118130522673.png)

代码演示：

```java
 public static void main(String[] args) throws IOException {
        //把集合中的数据保存到文件
//        myStore();

        //把文件中的数据加载到集合
        myLoad();
    }

    private static void myLoad() throws IOException {
        Properties prop = new Properties();

        //void Load(Reader reader)：
        FileReader fr = new FileReader("E:\\itcase\\kk.txt");
        prop.load(fr);
        fr.close();
        System.out.println(prop);
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("itheima001","林青霞");
        prop.setProperty("itheima002","张曼玉");
        prop.setProperty("itheima003","王祖贤");

        //void store(Writer writer,String comments)：
        FileWriter fw = new FileWriter("E:\\itcase\\kk.txt");
        prop.store(fw,null);
        fw.close();
    }
```



游戏次数：

代码演示：

```java
public static void main(String[] args) throws IOException {
        Properties prop = new Properties();

        //void Load(Reader reader)：
        FileReader fr = new FileReader("E:\\itcase\\game.txt");
        prop.load(fr);
        fr.close();
        //通过集合获取玩游戏的次数
    String count = prop.getProperty("count");
    int num = Integer.parseInt(count);
    if (num>=3){
        System.out.println("游戏试玩已结束，想玩请充值(www.itcast.cn)");
    }else {
        //玩游戏
        Game.start();

        //次数加1，写回文件
        num++;
        prop.setProperty("count",String.valueOf(num));
        FileWriter fw = new FileWriter("E:\\itcase\\game.txt");
        prop.store(fw,null);
        fw.close();
    }
}
```

```java
public static void start(){
    Random r = new Random();
    int num = r.nextInt(100)+1;
    while(true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要猜的数字");
        int guessnum = sc.nextInt();
        if (guessnum>num){
            System.out.println("你猜的数字"+guessnum+"大了");
        }else if(guessnum<num){
            System.out.println("你猜的数字"+guessnum+"小了");
        }else {
            System.out.println("恭喜你猜对了");
            break;
        }
    }
}
```



## 多线程：

### 进程：

进程：是正在运行的程序

1.是系统进行资源分配和调用的独立单位

2.每一个进程都有它自己的内存空间和系统资源



### 线程：

线程：是进程中的单个顺序控制流，是一条执行路径

单线程：一个进程如果只有一条执行路径，则称为单线程程序

多线程：一个变进程如果有多条执行路径，则称为多线程程序

举例：

记事本程序（单线程）：点开页面设置就必须把页面设置做完，才能进行下一步操作。

扫雷程序（多线程）：一点击游戏开始了时间就一直在跑



### 实现多线程：

#### 方式一：继承Thread类

1.定义一个类MyThread继承Thread类

2.在MyThread类中重写run()方法

3.创建MyThread类的对象

4.启动线程



优缺点：

优点：编码简单

缺点：线程类已经继承Thread，无法继承其他类，不利于拓展



代码演示：

```java
public void run() {
    for (int i=0; i<100; i++){
        System.out.println(i);
    }
}
```

```java
public static void main(String[] args){
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();

//        my1.run();
//        my2.run();
        //void start()导致此线程开始执行;java虚拟机调用此线程的run方法
        my1.start();
        my2.start();
    }
```



两个小问题：

1.为什么重写run()方法？

​		因为run()是用来封装被线程执行的代码

2.run()方法和start()方法的区别？

​		run()：封装线程执行的代码，直接调用，相当于普通方法的调用，这样会相当于还是单线程执行

​		start()：启动线程，然后由JVM调用此线程的run()方法



注意：不能把主线程任务放在子线程之前，否则主线程一直是先跑完的，相当于是一个单线程的效果





#### 设置和获取线程的名称：

Thread类中设置和获取线程名称的方法：

void setName(String name)：将此线程的名称更改为等于参数name

String getName()：返回此线程的名称

通过构造方法也可以设置线程名称



如何获取main()方法所在的线程名称？

public static Thread currentThread()：返回对当前正在执行的线程对象的引用



代码演示：

```java
    public static void main(String[] args){
//        MyThread my1 = new MyThread();
//        MyThread my2 = new MyThread();
//
//        //void setName(String name):将此线程的名称更替为等于参数name
//        my1.setName("高铁");
//        my2.setName("飞机");
//
//        MyThread my1 = new MyThread("高铁");
//        MyThread my2 = new MyThread("飞机");
//
//        my1.start();
//        my2.start();

        //static Thread currentThread()：返回对当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());
    }
```

```java
public class MyThread extends Thread{
    public MyThread(){}
    public MyThread(String name){
        super(name);
    }
    public void run() {
        for (int i=0; i<100; i++){
            System.out.println(getName()+":"+i);
        }
    }
}
```



#### 线程调度：

线程有两种调度模型：

1.分时调度模型：所有线程轮流使用CPU的使用权，平均分配每一个线程占用CPU的时间片

2.抢占式调度模型：优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机选择一个。优先级高的线程，获取的CPU时间片相对多一些

Java使用的是抢占式调度模型



假如计算机只有一个CPU，那么在某一个时刻只能执行一条指令，线程只有得到CPU时间片，也就是使用权，才可以执行指令。所以说多线程程序的执行是有随机性的，因为谁抢到CPU的使用权是不一定的。

Thread类中设置和获取线程优先级的方法：

public final int getPriority()：返回此线程的优先级

public final void setPriority(int newPriority)：更改此线程的优先级

​			线程默认优先级是5；线程优先级的范围是10；

​			线程优先级高仅仅表示线程获取的CPU时间片的几率高，但是要在次数比较多，或者多次运行的时候才能看到你想要的效果

代码演示：

```java
    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();
        tp1.setName("高铁");
        tp2.setName("飞机");
        tp3.setName("汽车");
        //public final int getPriority()：返回此线程的优先级
//        System.out.println(tp1.getPriority());  //5
//        System.out.println(tp2.getPriority());  //5
//        System.out.println(tp3.getPriority());  //5
        //public final void setPriority(int newPriority)：更改此线程的优先级
//        tp1.setPriority(10000);  //IllegalArgumentException
//        System.out.println(Thread.MAX_PRIORITY);  //10
//        System.out.println(Thread.MIN_PRIORITY);  // 1
//        System.out.println(Thread.NORM_PRIORITY);   //5
        //设置正确优先级
        tp1.setPriority(5);
        tp2.setPriority(10);
        tp3.setPriority(1);
        tp1.start();
        tp2.start();
        tp3.start();
    }
```



#### 线程控制：

![image-20230118143855066](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118143855066.png)

方法1：

代码演示：

```java
public void run() {
    for (int i=0; i<100; i++){
        System.out.println(getName()+":"+i);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

方法2：

代码演示：

```java
public static void main(String[] args) throws InterruptedException {
    ThreadSleep tp1 = new ThreadSleep();
    ThreadSleep tp2 = new ThreadSleep();
    ThreadSleep tp3 = new ThreadSleep();

    tp1.setName("康熙");
    tp2.setName("四阿哥");
    tp3.setName("八阿哥");

    tp1.start();
    tp1.join();
    tp2.start();
    tp3.start();
}
```

等tp1执行完毕后，才执行tp2,和tp3,等待线程死亡即等待线程执行完毕

方法3：

代码演示：

```java
public static void main(String[] args){
    ThreadSleep tp1 = new ThreadSleep();
    ThreadSleep tp2 = new ThreadSleep();

    tp1.setName("关羽");
    tp2.setName("张飞");

    //设置主线程为刘备
    Thread.currentThread().setName("刘备");

    //设置守护线程
    tp1.setDaemon(true);
    tp2.setDaemon(true);

    tp1.start();
    tp2.start();

    for (int i=0 ; i<10; i++){
        System.out.println(Thread.currentThread().getName()+":"+i);
    }
}
```

守护线程：主线程执行完毕，守护线程也停止执行



#### 线程生命周期：

![image-20230118150603395](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118150603395.png)



#### 方式二：实现Runnable接口：

1.定义一个类MyRunnable实现Runnable接口

2.在MyRunnable类中重写run()方法

3.创建MyRunnable类的对象

4.创建Thread类的对象，把MyRunnable对象作为构造方法的参数

5.启动线程



优缺点：

优点：线程任务类只是实现接口，可以继续继承类和实现接口，拓展性强

缺点：编程多一层对象包装，如果有执行结果是不可以直接返回的





代码演示：

```java
    public static void main(String[] args){
        MyRunnable my = new MyRunnable();

        //4.创建Thread类的对象，把MyRunnable对象作为构造方法的参数
        //Thread(Runnable target)
//        Thread t1 = new Thread(my);
//        Thread t2 = new Thread(my);

        //Thread(Runnable target,String name)
        Thread t1 = new Thread(my,"高铁");
        Thread t2 = new Thread(my,"飞机");

        //启动线程
        t1.start();
        t2.start();
    }
```

```java
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0; i< 100; i++){
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}
```



多线程的实现方法有三种：

1.继承Thread类

2.实现Runnable接口

3.通过Callable和Future接口创建线程



相比继承Thread类，实现Runnable接口的好处

1.避免了Java单继承的局限性

2.适合多个相同程序的代码去处理同一个资源的情况，把线程和程序的代码、数据有效分离，较好的体现了面向对象的设计思想



#### 方式三：实现Callable接口

前两种线程创建方式都存在一个问题：

​	重写的run方法均不能直接返回结果

​	不适合需要线程执行结果的业务场景

解决方式：JDK5.0提供了Callable和FutureTask来实现



步骤：

（1）得到任务对象

​		1.定义类实现Callable接口，重写call方法，封装要做的事情

​		2.用FutureTask把Callable对象封装成线程任务对象

（2）把线程任务对象交给Thread处理

（3）调用Thread的start方法启动线程，执行任务

（4）线程执行完毕后，通过FutureTask的get方法去获取任务执行的结果



public FutureTask<>(Callable call)：把Callable对象封装成FutureTask对象

public V get() throws Exception：获取线程执行call方法返回的结果



方式三优缺点：

优点：

​	线程任务只是实现接口，可以继续继承类和实现接口，扩展性强

​	可以在线程执行完毕后去获取线程执行的结果

缺点：

​	编码复杂一点



![image-20230124193735872](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230124193735872.png)



### 线程同步：

卖票代码实现：

```java
public static void main(String[] args){
    //创建SellTicket类对象
    SellTicket st = new SellTicket();

    //创建三个Thread类对象
    Thread t1 = new Thread(st,"窗口1");
    Thread t2 = new Thread(st,"窗口2");
    Thread t3 = new Thread(st,"窗口3");

    //启动线程
    t1.start();
    t2.start();
    t3.start();
}
```

```java
public void run() {
    while ((true)) {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
            tickets--;
        }
    }
}
```



卖票出现了问题：

相同的票出现了多次

出现了负数的票



问题原因：

线程执行的随机性导致的



为什么出现问题？（这也是我们判断多线程程序是否会有数据安全问题的标准）

1.是否是多线程环境

2.是否有共享数据

3.是否有多条语句操作共享数据



如何解决多线程安全问题呢？

基本思想：让程序没有安全问题的环境



怎么实现呢？

把多条语句操作共享数据的代码给锁起来，让任意时刻只能有一个线程执行即可。

java提供了同步代码块解决



锁多条语句操作共享数据，可以使用同步代码块实现

格式：synchronized(任意对象){

​	多条语句操作共享数据的代码

}

对于实例方法建议使用this作为锁对象

对于静态方法建议使用字节码（类名.class）对象作为锁对象

synchronized(任意对象)：就相当于给代码加锁了，任意对象就可以看做是一把锁

代码演示：

```java
public class SellTicket implements Runnable{
    private int tickets = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while ((true)) {
            synchronized (obj) {
                if (tickets > 0) {
                    //通过sleep（）方法来模拟出票时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
            }
        }
    }
}
```

加锁，一个线程进去之后，代码就会锁住，另一个线程就进不去，除非等到加锁的线程执行完毕，出去之后，锁会被释放，才会让下一个线程进去执行代码



同步的好处和弊端：

好处：解决了多线程的数据安全问题

弊端：当线程很多时，因为每一个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率



同步方法：就是把synchronized关键字加到方法上

格式：

修饰符sychronized返回值类型方法名（方法参数）{ 	}



同步方法的锁对象是什么呢？

this



同步静态方法：就是把synchronized关键字加到静态方法上

格式： 修饰符static synchronized返回值类型方法名（方法参数）{    }



同步静态方法的锁对象是什么呢？

类名.class

代码演示：

```java
private static synchronized void sellTicket(){
    if (tickets > 0) {
        //通过sleep（）方法来模拟出票时间
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
        tickets--;
    }
}
```

```java
public void run() {
    while ((true)) {
        synchronized (SellTicket.class) {
            sellTicket();
        }
    }
}
```



### 线程安全的类：

StringBuffer：

线程安全，可变的字符序列

从版本JDK5开始，被StringBuilder替代。通常应该使用StringBuilder类，因为他支持所有相同的操作，但他更快，因为他不执行同步



Vector：

从Java 2 平台v1.2开始，该类改进了List接口，使其成为Java Collections Framework的成员。与新的集合实现不同，Vector被同步。如果不需要线程安全的实现，建议使用ArrayList代替Vector



Hashtable：

该类实现了一个哈希表，他将键影射到值。任何非null对象都可以用作键或者值

从Java 2 平台v1.2开始，该类进行了改进，实现了Map接口，使其成为Java Collections Framework的成员。与新的集合实现不同，Hashtable被同步。如果不需要线程安全的实现，建议使用HashMap替代Hashtable



### Lock锁：

虽然 我们可以理解同步代码和同步方法的锁对象问题，但是我们并没有直接看到在哪里上了锁，在哪里释放了锁，为了更清晰的表达如何加锁和释放锁，JDK5之后提供了一个新的锁对象Lock



Lock实现提供比使用synchronized方法和语句可以获得更广泛的锁定操作

Lock中提供了获得锁和释放锁的方法

void lock()：获得锁

void unlock()：释放锁



Lock是接口不能直接实例化，这里采用他的实现类ReentrantLock来实例化

ReentrantLock的构造方法：

ReentrantLock()：创建一个ReentrantLock的实例

代码演示：

lock和unlock一般与try...finally{	}一起使用：

```java
public void run() {
    while ((true)) {
        try {
            lock.lock();
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                tickets--;
            }
        }finally {
            lock.unlock();
            }
        }
    }
```



### 生产者消费者：

概述：生产者消费者模式是一个十分经典的多线程协作的模式，弄懂生产者消费者问题能够让我们对多线编程的理解更加深刻

所谓生产者消费者问题，实际上主要是包含了两类线程：

一类是生产者线程用于生产数据

一类是消费者线程用于消费数据



为了解耦生产者和消费者直接的关系，通常会采用共享的数据区域，就像是一个仓库

生产者生产数据之后直接放置在共享数据区中，并不需要关心消费者的行为

消费者只需要从共享数据区中去获取数据，并不需要关心生产者的行为

![image-20230118192605869](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118192605869.png)



为了体现生产和消费过程中的等待和唤醒，Java就提供了几个方法供我们使用，这几个方法在Object类中，Object类的等待和唤醒方法：

![image-20230118192637023](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118192637023.png)



生产者消费者案例：

代码演示：

```java
public class Box {
    private int milk;  //表示第x瓶奶
    private boolean state = false;
    //存储牛奶
    public synchronized void put(int milk){
        //如果有牛奶，等待消费
        if (state){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就生产牛奶
        this.milk = milk;
        System.out.println("送奶工将第"+this.milk+"瓶奶放入奶箱");
        //生产完毕之后，修改奶箱状态
        state = true;
        //唤醒其他等待的线程
        notifyAll();
    }
    public synchronized void get(){
        //如果没有牛奶，等待生产
        if (!state){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //如果有牛奶，就消费牛奶
        System.out.println("用户拿到第"+this.milk+"瓶奶");
        //消费完毕之后，修改奶箱状态
        state = false;
        //唤醒其他等待的线程
        notifyAll();
    }
}
```

```java
public class Customer implements Runnable{
    public Box b;
    public Customer(Box b) {
        this.b = b;
    }
    public void run() {
        while(true){
            b.get();
        }
    }
}
```

```java
public class Producer implements Runnable{
    private Box b;
    public Producer(Box b) {
        this.b = b;
    }
    public void run() {
        for (int i=1; i<=5; i++){
            b.put(i);
        }
    }
}
```

```java
public class BoxDemo {
    public static void main(String[] args){
        //创建奶箱对象
        Box b = new Box();
        //创建生产者对象
        Producer p = new Producer(b);
        //创建消费者对象
        Customer c = new Customer(b);
        //创建两个线程对象
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        //启动线程
        t1.start();
        t2.start();
    }
}
```



### 线程池：

ExecutorService接口代表线程池



临时线程什么时候创建？

·新任务提交时发现核心线程都在忙，任务队列满了，并且还可以创建临时线程，此时才会创建临时线程

什么时候会开始拒绝任务？

核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始任务拒绝

## 网络编程：

概述：

计算机网络：是指将地理位置不同的具有独立功能的多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统

网络编程：在网络通信协议下，实现网络互联的不同计算机上运行的程序间可以进行数据交换



### 网络编程的三要素：

1、IP地址

要想让网络中的计算机能够互相通信，必须为每台计算机指定一个标识号，通过这个标识号来指定要接收数据的计算机和识别发送的计算机，而IP地址就是这个标识号。也就是设备的标识

2、端口

网络的通信，本质上是两个应用程序的通信。
如果说IP地址可以唯一标识网络中的设备，那么端口号就可以唯一标识设备中的应用程序了。也就是应用程序的标识

3、协议

通过计算机网络可以使多台计算机实现连接，位于同一个网络中的计算机在进行连接和通信时需要遵守一定的规则
在计算机网络中，这些连接和通信的规则被称为网络通信协议，它对数据的传输格式、传输速率、传输步骤等做了统一规定，通信双方必须同时遵守才能完成数据交换。常见的协议有UDP协议和TCP协议



#### IP地址：

IP地址：是网络中设备的唯一标识

IP地址分为两大类：

IPv4：是给每个连接在网络上的主机分配一个32bit地址。按照TCP/IP规定，IP地址用二进制来表示，每一个IP地址长32bit，也就是4个字节。例如一个采用二进制形式的IP地址是“11000000 10100000 00000001 01000010”，这么长的地址，处理起来太费劲了。为了方便使用，IP地址经常被写成十进制的形式，中间使用符号 “.” 分隔不同的字节。于是，上面的IP地址可以表示为“192.168.1.66"。IP地址的这种表示法叫做“点分十进制表示法”，这显然比0和1容易记忆的多。



IPv6：由于互联网的蓬勃发展，IP地址的需求量愈来愈大，但是网络地址资源有限，使得IP的分配越发紧张。为了扩大地址空间，通过IPv6重新定义地址空间，采用128位地址长度，每16位一组，分成8组十六进制数，这样就解决了网络地址资源数量不够的问题。

 

常用命令：

ipconfig：查看本机IP地址

ping IP地址：检查网络是否连通



特殊IP地址：

127.0.0.1：是回送地址，可以代表本机地址，一般用来测试使用



InetAddress的使用：

为了方便我们对IP地址的获取和操作，Java提供了一个类InetAddress供我们使用



InetAddress：此类表示Internet协议（IP）地址

![image-20230118204138969](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230118204138969.png)

代码演示：

```java
    public static void main(String[] args) throws UnknownHostException {
        //public static InetAddress getByName(String host)：确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
//        InetAddress address = InetAddress.getByName("CHINAMI-67M20DP");
        InetAddress address = InetAddress.getByName("192.168.136.1");

        //public String getHostName()：获取此IP地址的主机名
        String name = address.getHostName();
        //public String getHostAddress()：返回文本显示中的IP地址字符串
        String ip = address.getHostAddress();

        System.out.println("主机名"+name);
        System.out.println("IP地址"+ip);
    }
```



#### 端口：

端口：设备上应用程序的唯一标识

端口号：用两个字节表示的整数，他的取值范围是0~65535.其中，0~1023之间的端口号用于一些知名的网络服务和应用，普通的应用程序需要使用1024以上的端口号。如果端口号被另一个服务或应用所占用，会导致当前程序启动失败



#### 协议：

协议：计算机网络中，连接和通信的规则被称为网络通信协议

UDP协议：

用户数据报协议

UDP是无法连接通信协议，即在数据传输时，数据的发送端和接收端不建立逻辑连接。简单来说，当一台计算机向另一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据。

由于使用UDP协议消耗资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输

例如视频会议通常采用UDP协议，因为这种情况即使偶尔丢失一两个数据包，也不会对接收结果产生太大影响。但是在使用UDP协议传送数据时，由于UDP的面向无连续性，不能保证数据的完整性，因此在传输重要数据时，不建议使用UDP协议



TCP协议：

传输控制协议

TCP协议是面向连接的通信协议，即传输数据之前，在发送端和接收端建立逻辑连接，然后再传输数据，他提供了两台计算机之间无可靠差错的数据传输。在TCP连接中必须要明确客户端和服务器端，由客户端向服务器端发出连接请求，每次连接的创建都需要经过“三次握手”

“三次握手”：TCP协议中，在发送数据的准备阶段，客户端和服务器之间的三次交互，以保证连接的可靠

​	第一次握手，客户端向服务器端发出连接的请求，等待服务器确认

​	第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求

​	第三次握手，客户端再次向服务器端发送确认信息，确认连接

![image-20230119132356737](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230119132356737.png)



完成”三次握手“，连接建立后，客户端和服务器就可以开始进行数据传输了。由于这种面向连接的特性，TCP协议可以保证传输数据的安全，所以应用十分广泛。例如上传文件、下载文件、浏览网页等。



### UDP通信程序：

UDP通信原理：

UDP协议是一种不可靠的网络协议，他在通信的两端各建立一个Socket对象，但是这两个Socket只是发送，接收数据的对象

因此对于基于UDP协议的通信双方而言，没有所谓的额客户端和服务器的概念

Java提供了DatagramSocket类作为基于UDP协议的Socket



UDP发送数据：

步骤：

1.创建发送端的Socket对象(DatagramSocket)

2.创建数据，并把数据打包

3.调用DatagramSocket对象的方法发送数据

4.关闭发送端

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //1.创建发送端的Socket对象(DatagramSocket)
        //DatagramSocket()构造方法报套接字并将其绑定到本地主机上的任何可用端口
        DatagramSocket ds = new DatagramSocket();

        //2.创建数据，并把数据打包
        //DatagramPacket(byte[] buf,int length,InetAddress address, int port)
        //构造一个数据包，发送长度为length的数据包到指定主机上的指定端口号
        byte[] bys = "hello,udp,我来了".getBytes();
//        int length = bys.length;
//        InetAddress address = InetAddress.getByName("192.168.136.1");
//        int port = 10086;
//        DatagramPacket dp = new DatagramPacket(bys,length,address,port);
        DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("192.168.136.1"),10086);

        //3.调用DatagramSocket对象的方法发送数据
        //void send(DatagramSocket p)从此套接字发送数据报包
        ds.send(dp);
        
        //4.关闭发送端
        ds.close();
    }
```



UDP接收数据：

步骤：

1.创建接收端的Socket对象（DatagramSocket）

2.创建一个数据包，用于接收数据

3.调用DatagramSocket对象的方法接收数据

4.解析数据包，并把数据在控制台显示

5.关闭数据端

代码演示：

```java
    public static void main(String[] args) throws IOException {
        //1.创建接收端的Socket对象（DatagramSocket）
        //DatagramSocket(int port)狗早安数据报套接字并将其绑定到本地主机上的指定端口
        DatagramSocket ds = new DatagramSocket(10086);

        //创建一个数据包，用于接收数据
        //DatagramPacket (byte[] buf, int length)构造一个DatagramPacket用于接收长度为length数据包
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        //3.调用DatagramSocket对象的方法接收数据
        ds.receive(dp);

        //4.解析数据包，并把数据在控制台显示
        //byte[] getData()返回数据缓冲区
        byte[] datas = dp.getData();  //拿到的是数据缓冲区
        //int getlength()返回要发送的数据的长度或接收到的数据的长度
        int len = dp.getLength();  //拿到的是实际发送的数据
//        String dataString = new String(datas,0,len);
//        System.out.println("数据时"+dataString);
        System.out.println("数据是:"+new String(dp.getData(),0,dp.getLength()));

        //关闭接收端
        ds.close();
    }
```



### TCP通信程序：

TCP通信协议是一种可靠的网络协议，它在通信的两端各建立一个Socket对象，从而在通信的；两端形成网络虚拟链路。一旦建立了虚拟的网络链路，两端的程序就可以通过虚拟链路进行通信

Java对基于TCP协议的网络提供了良好的封装，使用Socket对象来代表两端的通信端口，并通过Socket产生IO流来进行网络通信

Java为客户端提供了Socket类，为服务器端提供了ServerSocket类



TCP发送数据：

步骤：

1.创建客户端的Socket对象			Socket(String host,int port)

2.获取输出流，写数据			OutputStream    getOutputStream()

3.释放资源   			void close()



代码演示：

```java
public static void main(String[] args) throws IOException {
        //1.创建客户端的Socket对象
        //Socket(InetAddress address,int port)创建流套接字并将其连接到指定IP地址的指定端口号
//        Socket s = new Socket(InetAddress.getByName("192.168.136.1"),10000);
        //Socket(String host, int port)创建流套接字并将其连接到指定主机上的指定端口号
        Socket s = new Socket("192.168.136.1",5000);

        //获取输出流，写数据
        //OutputStream getOutputStream()返回此套接字的输出流
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //释放资源
        s.close();
    }
```



TCP接收数据：

步骤：

1.创建服务器端的Socket对象(ServerSocket)  		SeverSocket(int port)

2.监听客户端链接，返回一个Socket对象		Socket accept()

3.获取输入流，读数据，并把数据显示在控制台		InputStream 	getInputStream()

4.释放资源		void close()



代码演示：

```java
public static void main(String[] args) throws IOException {
    //创建服务器端的Socket对象（ServerSocket）
    //ServerSocket(int port)创建绑定到指定端口的服务器套接字
    ServerSocket ss = new ServerSocket(5000);

    //Socket accept()倾听要连接到此套接字并接受他
    Socket s = ss.accept();

    //2.获取输入流，读数据，并把数据显示在控制台
    InputStream is = s.getInputStream();
    byte[] bys = new byte[1024];
    int len = is.read(bys);
    String data = new String(bys,0,len);
    System.out.println("数据是:"+data);

    //释放资源
    s.close();
    ss.close();
}
```



客户端先写数据后读数据，服务端先读数据后写数据



练习一：

服务端：

```java
public static void main(String[] args) throws IOException {
    //1.创建服务器端的Socket对象(ServerSocket)         SeverSocket(int port)
    ServerSocket ss = new ServerSocket(5000);

    //2.监听客户端链接，返回一个Socket对象      Socket accept()
    Socket s = ss.accept();

    //3.获取输入流，读数据，并把数据显示在控制台      InputStream    getInputStream()
    InputStream is = s.getInputStream();
    byte[] bys = new byte[1024];
    int len = is.read(bys);
    String data = new String(bys,0,len);
    System.out.println("数据是:"+data);

    //给出反馈
    OutputStream os = s.getOutputStream();
    os.write("数据已经收到".getBytes());

    //4.释放资源      void close()
    ss.close();
}
```

客户端：

```java
public static void main(String[] args) throws IOException {
    ////1.创建客户端的Socket对象
    Socket s = new Socket("192.168.136.1",5000);

    //获取输出流，写数据
    OutputStream os = s.getOutputStream();
    os.write("hello,tcp,我来了".getBytes());

    //接收服务器反馈
    InputStream is = s.getInputStream();
    byte[] bys = new byte[1024];
    int len = is.read(bys);
    String data = new String(bys,0,len);
    System.out.println("客户端:"+data);

    //释放资源
    s.close();
}
```



练习二：

客户端：

```java
public static void main(String[] args) throws IOException {
        ////1.创建客户端的Socket对象
        Socket s = new Socket("192.168.136.1",5000);

        //数据来自键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象       字节流转换为字符流再包装
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line = br.readLine())!=null) {
            if ("886".equals(line)) {
                break;
            }
            //获取输出流，写数据
//            OutputStream os = s.getOutputStream();
//            os.write(line.getBytes());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        s.close();
    }
```

服务器端：

```java
public static void main(String[] args) throws IOException {
    //1.创建服务器端的Socket对象(ServerSocket)         SeverSocket(int port)
    ServerSocket ss = new ServerSocket(5000);

    //2.监听客户端链接，返回一个Socket对象      Socket accept()
    Socket s = ss.accept();

        //3.获取输入流，读数据，并把数据显示在控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line=br.readLine()) != null){
            System.out.println(line);
        }
    //4.释放资源      void close()
    ss.close();
}
```



练习三：

服务器端：

```java
public static void main(String[] args) throws IOException {
    //1.创建服务器端的Socket对象(ServerSocket)         SeverSocket(int port)
    ServerSocket ss = new ServerSocket(5000);

    //2.监听客户端链接，返回一个Socket对象      Socket accept()
    Socket s = ss.accept();

        //3.获取输入流，读数据，并把数据显示在控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\JAVA\\javaproject\\fos.txt"));
        String line;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
            System.out.println(line);
        }
    //4.释放资源      void close()
        ss.close();
        bw.close();
}
```

客户端：与上相同



练习四：

客户端：

```java
    public static void main(String[] args) throws IOException {
        ////1.创建客户端的Socket对象
        Socket s = new Socket("192.168.136.1",5000);

        //数据来自键盘录入
        BufferedReader br = new BufferedReader(new FileReader("E:\\JAVA\\javaproject\\fos.txt"));
        //封装输出流对象       字节流转换为字符流再包装
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line = br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        s.close();
    }
```

服务器端：与上相同



练习五：

出现问题：程序一直等待

原因：读数据的方法是阻塞式的

解决方法：自定义结束标记；使用shutdownOutput()方法(推荐)

代码演示：

服务器端：

```java
    public static void main(String[] args) throws IOException {
        //1.创建服务器端的Socket对象(ServerSocket)         SeverSocket(int port)
        ServerSocket ss = new ServerSocket(5000);

        //2.监听客户端链接，返回一个Socket对象      Socket accept()
        Socket s = ss.accept();

            //3.获取输入流，读数据，并把数据显示在控制台
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));
            String line;
            while ((line=br.readLine()) != null){
//                if ("886".equals(line)){
//                    break;
//                }
                bw.write(line);
                bw.newLine();
                bw.flush();
                System.out.println(line);
            }
        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();
        //4.释放资源      void close()
            ss.close();
            bw.close();
    }
```

客户端：

```java
    public static void main(String[] args) throws IOException {
        ////1.创建客户端的Socket对象
        Socket s = new Socket("192.168.136.1",5000);

        //数据来自键盘录入
        BufferedReader br = new BufferedReader(new FileReader("E:\\JAVA\\javaproject\\fos.txt"));
        //封装输出流对象       字节流转换为字符流再包装
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line = br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
//        //自定义结束标记
//        bw.write("886");
//        bw.newLine();
//        bw.flush();

        //public void shutdownOutput()
        s.shutdownOutput();

        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();
        System.out.println("服务器的反馈:"+data);
        //释放资源
        br.close();
        s.close();
    }
```



练习六：

客户端与上同

服务端：

```java
public static void main(String[] args) throws IOException {
    //1.创建服务器端的Socket对象(ServerSocket)         SeverSocket(int port)
    ServerSocket ss = new ServerSocket(5000);

    while(true) {
        //2.监听客户端链接，返回一个Socket对象      Socket accept()
        Socket s = ss.accept();
        //为每一个客户端开启一个线程
        new Thread(new ServerThread(s)).start();
    }
}
```

线程：

```java
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\itcase\\kk.txt"));
            //解决名称冲突问题
            int count=0;
            File file = new File("E:\\itcase\\kk["+count+"].txt");
            while (file.exists()){
                count++;
                file = new File("E:\\itcase\\kk["+count+"].txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            String line;
            while ((line=br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                bw.flush();
                System.out.println(line);
            }
            //给出反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```



## Lambda表达式：

函数式编程思想概述：

在数学中，函数就是有输入量，输入量的一套计算方案，也就是“拿数据做操作”

面向对象思想强调“必须通过对象的形式来做事情”

函数式思想则尽量忽略面向对象的复杂语法：“强调做什么，而不是以什么形式去做”

Lambda表达式就是函数式思想的体现



需求：启动一个线程，在控制台输出一句话：多线程程序启动了

方式一：

1.定义一个类MyRunnable实现Runnable接口，重写run（）方法

2.创建MyRunnable类的对象

3.创建Thread类的对象，把MyRunnable的对象作为构造参数传递

4.启动线程



方式二：

使用匿名内部类的方式改进

代码演示：

```java
public static void main(String[] args){
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("多线程程序启动了");
        }
    }).start();
    }
```



方式三：

lambda表达式改进

代码演示：

```java
public static void main(String[] args){
    //Lambda表达式：
    new Thread( () -> {
        System.out.println("多线程程序启动了");
    }).start();
}
```



### Lambda表达式的标准格式：

 new Thread( () -> {
        System.out.println("多线程程序启动了");
    }).start();

分析：

（）：里面没有内容，可以看成是方法形式参数为空

->：用箭头指向后面要做的事情

{  }：包含一段代码，我们称之为代码块，可以看成是方法体中的内容



组成Lambda表达式的三要素：形式参数，箭头，代码块



Lambda表达式的格式：

格式：（形式参数）->{  代码块   }

形式参数：如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可

->：用英文中划线和大于符号组成，固定写法，代表指向动作

代码块：是我们具体要做的事情，也就是以前我们写的方法体内容



练习一：

```java
public static void main(String[] args){
    Eatable e = new EatableImpl();
    useEatable(e);

    //匿名内部类
    useEatable(new Eatable() {
        @Override
        public void eat() {
            System.out.println("一天一苹果，医生远离我");
        }
    });

    //Lambda表达式：
    useEatable( () -> {
        System.out.println("一天一苹果，医生远离我");
    } );
}
```



练习二：与一类似



练习三：与二类似



### Lambda表达式的省略模式：

省略规则：

参数类型可以省略。但是有多个参数的情况下，不能只省略一个

如果参数有且只有一个，那么小括号可以省略

如果代码块的语句只有一条，可以省略大括号和分号，甚至是return



### Lambda表达式注意事项：

注意事项：

使用Lambda必须要有接口，并且要求接口中有且仅有一个抽象方法

必须有上下文环境，才能推导出Lambda对应的接口

​	根据局部变量的赋值得知Lambda对应的接口：Runnable r = () -> System.out.println("Lambda表达式");

​	根据调用方法的参数得知Lambda对应的接口：new Thread（() -> System.out.println("Lambda表达式")）.start();



### Lambda表达式和匿名内部类的区别：

1.所需类型不同：

匿名内部类：可以是接口，也可以是抽象类，还可以是具体类

Lambda表达式：只能是接口



2.使用限制不同

如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类

如果接口中多与一个抽象方法，只能使用匿名内部类，二不能使用Lambda表达式



3.实现原理不同：

匿名内部类：编译之后，产生一个单独的 .class 字节码文件

Lambda表达式：编译之后，没有一个单独的 .class 字节码文件。对应的字节码会在运行的时候动态生成



## 接口组成更新：

概述：

接口的组成：

常量	public static final

抽象方法 	public abstract 

默认方法（Java8）

静态方法（Java8）

私有方法（Java9）



### 接口中的默认方法：

接口中默认方法的定义格式：

格式：public default 返回值类型方法名(参数列表) {  }

范例：public default void show3() {	}



接口中默认方法的注意事项：

默认方法不是抽象方法，所以不强制被重写。但是可以被重写，重写的时候去掉default关键字

public可以省略，default不能省略



### 接口中的静态方法：

定义格式：Public static 返回值类型 方法名(参数列表){	}

范例：public static void show() {	}



接口中静态方法的注意事项：

静态方法只能通过接口名调用，不能通过实现类名或者对象名调用

public 可以省略，statisq不能省略



### 接口中的私有方法：

Java 9 中新增了带方法体的私有方法，这其实在Java 8中就埋下了伏笔：java8 允许在接口中定义带方法体的默认方法和静态方法。这样可能就会引发一个问题：当两个默认方法或者静态方法中包含一端相同的代码实现时，程序必然考虑将这段实现代码抽取成一个共性方法，而这个共性方法是不需要让别人使用的，因此用私有给隐藏起来，这就是Java 9增加带私有方法的必然性



私有方法的定义格式：

格式1：private返回值类型 方法名（参数列表）{	}

范例1：private void show(){	}

格式2：private static 返回值类型 方法名（参数列表）{	}

范例2：private static void method(){	}



接口中私有方法的注意事项：

默认方法可以调用私有的静态方法和非静态方法

静态方法只能调用私有的静态方法



## 方法引用：

方法引用符：

:: 该符号为引用运算符，而他所在的表达式被称为方法引用

Lambda表达式：usePrintable(s -> System.out.println(s));

分析：拿到参数s之后通过Lambda表达式，传递给System.out.pritnln方法去处理

方法引用：usePrintable(System.out::println);

分析：直接使用System.out中的println方法来取代Lambda，代码更加的简洁



推导与省略：

如果使用lambda表达式，那么根据“可推导就是可省略”的原则，无需指定参数类型，也无需制定本的重载形式，他们都将被自动推导

如果使用方法引用，也是同样可以根据上下文进行推导

方法引用是Lambda表达式



#### Lambda表达式支持的方法引用：

常见的引用方法：

引用类方法

引用对象的实例方法

引用类的实例方法

引用构造器



##### 引用类方法：

引用类方法，其实就是引用类的静态方法：

格式：类名::静态方法

范例：Integer::parseInt

​		Integer类的方法：public static int parseInt(String s)将此String转换为int类型数据



##### 引用对象的实例方法：

引用对象的实例方法，其实就是引用类中的成员方法

格式：对象::成员方法

范例："Hello World"::toUpperCase

String类中的方法：public String toUpperCase()将此String所有字符转换为大写

Lambda表达式被对象的实例方法替代的时候，他的形式参数全部传递给该方法作为参数



##### 引用类的实例方法：

引用类的实例方法，其实就是引用类中的成员方法

格式：类名::成员方法

范例：String::substring

String类中的方法：public String substring(int beginIndex,int endIndex)

从beginIndex开始到endIndex结束，截取字符串。返回一个子串，子串的长度为endIndex-beginIndex

Lambda表达式被类的实例方法替代的时候，第一个参数作为调用者，后面的参数全部传递给该方法作为参数



##### 引用构造器：

引用构造器，其实就是引用构造方法

格式：类名::new

范例：Student::new 

Lambda表达式被构造器替代的时候，他的形式参数全部传递给构造器作为参数



## 函数式接口：

### 概述：

函数式接口：有且仅有一个抽象方法的接口

Java中的函数式编程体现的就是Lambda表达式，所以函数式接口就是可以适用于Lambda使用的接口，只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导



如何检测一个接口是不是函数式接口？

·@FunctionalInterface

·放在接口定义的上方：如果是函数式接口，编译通过；如果不是，编译失败



注意：

·我们自己定义函数式接口的时候，@FunctionalInterface是可选的，就算不写这个注解，只要保证满足函数式接口定义的条件，也照样是函数式接口，但是，建议加上该注解



### 函数式接口作为方法的参数：

需求：

·定义一个类（RunnableDemo），在类中提供两个方法

一个方法是：startThread(Runnable r)	方法参数Runnable是一个函数式接口

一个方法是主方法，在主方法中调用startThread方法



如果方法是一个函数式接口，我们可以使用Lambda表达式作为参数传递

·startThread(() -> System.out.println(Thread.currentThread().getName()+"线程启动了"));

代码演示：

```java
public class RunnableDemo {
    public static void main(String[] args){
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动了");
            }
        });

        startThread(() -> System.out.println(Thread.currentThread().getName()+"线程启动了"));

    }
    private static void startThread(Runnable r){
//        Thread t = new Thread(r);
//        t.start();
        new Thread(r).start();
    }
}
```



### 函数式接口作为方法的返回值

定义一个类(ComparatorDemo),在类中提供两个方法

​	一个方法是：Comparator<String>getComparator()	方法返回值Comparator是一个函数式接口

​	一个方法是主方法，在主方法中调用getcomparator方法



如果方法的返回值是一个函数式接口，我们可以使用Lambda表达式作为结果返回

· private static Comparator<String> getComparator(){

return (s1,s2) -> s1.length()-s2.length();
}

```java
public class ComparatorDemo {
    public static void main(String[] args){
        //构造使用场景
        //定义集合,存储字符串元素
        ArrayList<String> array = new ArrayList<String>();

        array.add("cccc");
        array.add("aa");
        array.add("b");
        array.add("ddd");

        System.out.println("排序前:"+array);

//        Collections.sort(array);
        Collections.sort(array,getComparator());
        System.out.println("排序后:"+array);

    }

    private static Comparator<String> getComparator(){
//        //匿名内部类的方式实现
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
//        return comp;
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
//    }
            //Lambda表达式作为接口返回
//        return (String s1,String s2) -> {
//        return s1.length()-s2.length();
//        };

        return (s1,s2) -> s1.length()-s2.length();
    }
}
```



### 常用的函数式接口

包含：Supplier接口、Consumer接口、Predicate接口、Function接口

#### Supplier接口：

Supplier<T>：包含一个无参的方法

·T get()：获得结果

·该方法不需要参数，他会按照某种实现逻辑（由Lambda表达式实现）返回一个数据

·Supplier<T>接口也被称为生产接口，如果我们指定了接口的泛型是什么类型，那么接口中的get()方法就会产生什么类型的数据供我们使用



代码演示：

```java
public class SupplierDemo {
    public static void main(String[] args){
//        String s =getString( () -> {
//            return "林青霞";
//        });

        String s = getString( () -> "林青霞");
        System.out.println(s);

//        Integer i = getInteger( () -> {
//            return 30;
//        });
        Integer i = getInteger( () -> 30);
        System.out.println(i);
    }
    //定义一个方法，返回一个整数数据
    private static Integer getInteger(Supplier<Integer> sup){
        return sup.get();
    }
    //定义一个方法，返回一个字符串数据
    private static String getString(Supplier<String> sup){
        return sup.get();
    }
}
```



练习：

定义一个类（SupplierTest），在类中提供两个方法

一个方法是：int getMax(Supplier<Integer> sup) 用于返回一个int数组中的最大值

一个方法是主方法，调用getMax方法

代码：

```java
public class SupperlierTest {
    public static void main(String[] args) {
        int[] arr = {19,50,28,37,46};
        Integer n = getMax( () -> {
            int max = arr[0];
            for (int i=0 ; i<arr.length - 1; i++){
                max = arr[i] > max ? arr[i] : max;
            }
            return max;
        });
        System.out.println(n);
        }
    private static Integer getMax(Supplier<Integer> sup){
            return sup.get();
    }
}
```



#### Consumer接口

Consumer<T>：包含两个方法

·void accept(T t)：对给定的参数执行此操作

·default Consumer<T> andThen(Consumer after)：返回一个组合的Consumer，依次执行此操作，然后执行after操作

·Consumer<T>接口也被称为消费型接口，他消费的数据的数据类型由泛型指定

代码演示：

```java
public class ConsumerDemo {
    public static void main(String[] args){
//        operatorString("林青霞",(String s) -> {
//            System.out.println(s);
//        });

        operatorString("林青霞",s -> System.out.println(s));
        //方法引用:
//        operatorString("林青霞",System.out::println);

//        operatorString("林青霞",s -> {
//            System.out.println(new StringBuilder(s).reverse().toString());
//        });
        operatorString("林青霞",s -> System.out.println(new StringBuilder(s).reverse().toString()));
        System.out.println("===========================================");

        operatorString("林青霞",s -> System.out.println(s),s -> System.out.println(new StringBuilder(s).reverse().toString()));
    }

    //定义一个方法，消费一个字符串数据
    private static void operatorString(String name, Consumer<String> con){
        con.accept(name);
    }

    //定义一个方法，用不同方式消费同一个字符串数据两次
    private static void operatorString(String name, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }
}
```

练习：

代码演示：

视频写的：

```java
public class ConsumerTest {
    public static void main(String[] args){
        String[] strArray={"林青霞,30","张曼玉,35","王祖贤,33"};

//        printInfo(strArray,(String str) -> {
//            String name = str.split(",")[0];
//            System.out.print("姓名："+name);
//        },(String str) -> {
//            int age = Integer.parseInt(str.split(",")[1]);
//            System.out.println(",年龄："+age);
//        });
        printInfo(strArray,str -> System.out.print("姓名:"+str.split(",")[0]),
                str -> System.out.println(",年龄"+Integer.parseInt(str.split(",")[1])));
    }
    private static void printInfo(String[] strArray, Consumer<String> con1, Consumer<String> con2){
        for (String str : strArray){
            con1.andThen(con2).accept(str);
        }
    }
}
```

自己写的：

```java
public class ConsumerDemo01 {
    public static void main(String[] args){
        String[] strArray={"林青霞,30","张曼玉,35","王祖贤,33"};
        for (int i = 0; i < strArray.length; i++){
            operatorString(strArray[i],s -> System.out.print("姓名:"+new StringBuilder(s.substring(0,3))+"\t"),ss -> System.out.print("年龄"+new StringBuilder(ss.substring(4))));
            System.out.println();
        }
    }
    private static void operatorString(String name, Consumer<String> con1, Consumer<String> con2){
        con1.andThen(con2).accept(name);
    }
}
```



#### Predicate接口

Predicate<T>：常用的四个方法

·boolean test(T t)：对给定的参数进行判断(判断逻辑由Lambda表达式实现)，实现一个布尔值

·default Predicate<T> negate()：返回一个逻辑的否定，对应逻辑非

·default Predicate<T> and(Predicate other)：返回一个组合判断，对应短路与

·default Predicate<T> or(Predicate other)：返回一个组合判断，对应短路或

·Predicate<T>接口通常用于判断参数是否满足指定的条件



代码演示：

```java
public class PredicateDemo01 {
    public static void main(String[] args){
//        boolean b1 = checkString("hello",(String s) ->{
//            return s.length()>8;
//        } );
        boolean b1 = checkString("hello",s -> s.length()>8);
        System.out.println(b1);
        boolean b2 = checkString("helloworld",s -> s.length()>8);
        System.out.println(b2);
    }
    //判断给定的字符串是否满足要求
    private static boolean checkString(String s, Predicate<String> pre){
//        return pre.test(s);
//        return !pre.test(s);
        return pre.negate().test(s);
    }
}
```

```java
public class PredicateDemo02 {
    public static void main(String[] args){
        boolean b1 = checkString("hello",s -> s.length()>8);
        System.out.println(b1);
        boolean b2 = checkString("helloworld",s -> s.length()>8);
        System.out.println(b2);

        boolean b3 = checkString("hello",s -> s.length() > 8,s -> s.length() < 15);
        System.out.println(b3);

        boolean b4 = checkString("helloworld",s -> s.length() > 8,s -> s.length() < 15);
        System.out.println(b4);
    }

    //同一个字符串给出两个不同的判断条件，最后把这两个判断的结果做逻辑与运算的结果作为最终的结果
    private static boolean checkString(String s,Predicate<String> pre1,Predicate<String> pre2){
//        boolean b1 = pre1.test(s);
//        boolean b2 = pre2.test(s);
//        boolean b = b1 && b2;
//        return b;
//        return pre1.and(pre2).test(s);
        return pre1.or(pre2).test(s);
    }
    private static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }
}
```



练习：

视频的：

```java
public class PredicateTestTeacher {
    public static void main(String[] args){
        String[] strArray = {"林青霞,30","柳岩,34","张曼玉,35","貂蝉,31","王祖贤,33"};
        ArrayList<String> array = new ArrayList<String>();
        array = myFilter(strArray,s -> s.split(",")[0].length() > 2,
                s -> Integer.parseInt(s.split(",")[1]) > 33);
        for (String str : array){
            System.out.println(str);
        }
    }
    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2){
        //定义一个集合
        ArrayList<String> array = new ArrayList<String>();

        for (String str : strArray){
            if (pre1.and(pre2).test(str)){
                array.add(str);
            }
        }
        return array;
    }
}
```



自己写的：

```java
public class PredicateTest {
    public static void main(String[] args){
        String[] strArray = {"林青霞,30","柳岩,34","张曼玉,35","貂蝉,31","王祖贤,33"};
        ArrayList<String> as = new ArrayList<String>();
        for (String s : strArray) {
            boolean b = checkString(s,ss -> ss.split(",")[0].length() > 2,
            ss -> Integer.parseInt(ss.split(",")[1]) > 33);
            if (b) {
                as.add(s);
            }
        }
        System.out.println(as);
    }
    private static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.and(pre2).test(s);
    }
}
```



#### Function接口

Function<T,R>：常用的两个方法

·R apply(T t)：将此函数应用于给定的参数

·default<V> Function and Then(Function after)：返回一个组合函数，首先将该函数应用于输入，然后将after函数应用于结果

·Function<T,R>接口通常用于对参数进行处理，转换（处理逻辑由Lambda表达式实现），然后返回一个新的值

代码演示：

```java
public class FunctionDemo {
    public static void main(String[] args){
//        convert("100",(String s) -> {
//            return Integer.parseInt(s);
//        });
        convert("100",s -> Integer.parseInt(s));
        convert("100",Integer::parseInt);

        convert(100,i -> String.valueOf(i+566));

        convert("100",s -> Integer.parseInt(s),i -> String.valueOf(i+566));
    }
    //定义一个方法，把一个字符串转换为int类型，在控制台输出
    private static void convert(String s, Function<String,Integer> fun){
//        Integer i = fun.apply(s);
        int i = fun.apply(s);
        System.out.println(i);
    }

    //定义一个方法，把一个int 类型的数据加上一个整数后，转为字符串在控制台输出
    private static void convert(int i,Function<Integer,String> fun){
        String s = fun.apply(i);
        System.out.println(s);
    }

    //定义一个方法，把一个int类型的数据加上一个整数之后，转为字符串在控制台输出
    private static void convert(String s,Function<String,Integer> fun1,Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }
}
```



练习：

自己写：

```java
public class FunctionTest {
    public static void main(String[] args){
        convert("林青霞,30",ss -> Integer.parseInt(ss));
    }
    private static void convert(String s, Function<String,Integer> fun){
        System.out.println(fun.apply(s.split(",")[1]) + 70);
    }
}
```



## Stream流：

#### Stream流的生成方式：

·生成流

​	通过数据源（集合，数组等）生成流

​	list.stream()

·中间操作

​	一个流后面可以跟随零个或多个中间操作，其目的主要是打开流，做出某种程度的数据过滤/映射，然后返回一个新的流，交给下一个操作使用

​	filter()

·终结操作

​	一个流只能有一个终结流操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作

​	forEach()



Stream流的常见生成方式

·Collection体系的集合可以使用默认方法stream()生成流

​	defaultStream<E> stream()

·Map体系的集合间接的生成流

·数组可以通过Stream接口的静态方法of(T...values)生成流



代码演示：

```java
public static void main(String[] args){
    //Collection体系的集合可以使用默认方法stream()生成流
    List<String> list = new ArrayList<String>();
    Stream<String> listStream = list.stream();

    Set<String> set = new HashSet<String>();
    Stream<String> setStream = set.stream();

    //Map体系的集合间接的生成流
    Map<String,Integer> map = new HashMap<String,Integer>();
    Stream<String> keyStream = map.keySet().stream();
    Stream<Integer> valueStream = map.values().stream();
    Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

    //数组可以通过Stream接口的静态方法of(T...values)生成流
    String[] strArray = {"hello","world","java"};
    Stream<String> strArrayStream = Stream.of(strArray);
    Stream<String> strArrayStream2 = Stream.of("hello", "world", "java");
    Stream<Integer> intStream = Stream.of(10, 20, 30);
}
```



#### Stream流的常见中间操作方法

·Stream<T> filter(Predocate predicate)：用于对流中的数据进行过滤

​	Predicate接口中的方法 					boolean test(T t)：对给定的参数进行判断，返回一个布尔值

代码演示：

```java
    public static void main(String[] args){
    //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        //需求1：把List集合中以张开头的元素在控制台输出
//        list.stream().filter( (String s) -> {
//            return s.startsWith("张");
//        }).forEach(System.out::println);
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
        System.out.println("======================");

        //需求2：把List集合中长度为3的元素在控制台输出
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);
        System.out.println("=========================");

        //需求3：把List集合中以张开头的，长度为3的元素在控制台输出
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
```



·Stream<T> limit(long maxSize)：返回此流中的元素组成的流，截取前指定参数个数的数据

·Stream<T> skip(long n)：跳过指定参数个数的数据，返回由该流的剩余元素组成的流

代码演示：

```java
public static void main(String[] args){
    //创建一个集合，存储多个字符串元素
    ArrayList<String> list = new ArrayList<String>();

    list.add("林青霞");
    list.add("张曼玉");
    list.add("王祖贤");
    list.add("柳岩");
    list.add("张敏");
    list.add("张无忌");

    //需求1：取前3个数据在控制台输出
    list.stream().limit(3).forEach(System.out::println);
    System.out.println("===================");

    //需求2：跳过3个元素，把剩下的元素在控制台输出
    list.stream().skip(3).forEach(System.out::println);
    System.out.println("========================");

    //需求3：跳过2个元素，把剩下的元素中前两个在控制台输出
    list.stream().skip(2).limit(2).forEach(System.out::println);
}
```



·static <T> Stream<T> concat(Stream a,Stream b)：合并a和b两个流为一个流

·Stream<T> distinct()：返回由该流的不同元素（根据Object.equals(Object))组成的流

```java
    public static void main(String[] artgs){
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        //需求1：取前四个数据组成一个流
        Stream<String> s1 =list.stream().limit(4);

        //需求2：跳过2个数据组成一个流
        Stream<String> s2 = list.stream().skip(2);

        //需求3：合并需求1和需求2得到的流，并把结果在控制台输出
//        Stream.concat(s1,s2).forEach(System.out::println);

        //需求4：合并需求1和需求2得到的流，并把结果在控制台输出，要求字符串元素不能重复
        Stream.concat(s1,s2).distinct().forEach(System.out::println);
    }
```



·Stream<T> sorted()：返回由此流的元素组成的流，根据自然顺序排序

·Stream<T> sorted(Comparator comparator)：返回该流的元素组成的流，根据提供的Comparator进行排序

代码演示：

```java
 public static void main(String[] args){
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("linqingxia");
        list.add("zhangmanyu");
        list.add("wangzuxian");
        list.add("liuyan");
        list.add("zhangmin");
        list.add("zhangwuji");

        //需求1：按照字母顺序把数据在控制台输出
//        list.stream().sorted().forEach(System.out::println);

        //需求2：按照字符串长度把数据在控制台输出
//        list.stream().sorted((s1,s2) -> s1.length()-s2.length()).forEach(System.out::println);

        list.stream().sorted((s1,s2) -> {
            int num = s1.length() - s2.length();
            int num2 = num == 0 ? s1.compareTo(s2):num;
            return num2;
        }).forEach(System.out::println);
    }
```



·<R> Stream<R> map(Function mapper)：返回由给定函数应用于此流的元素的结果组成的流

​	Function接口中的方法		R apply(T t)

·IntStream map ToInt(ToIntFunction mapper)：返回一个IntStream其中包含将给定函数应用于此流的元素的结果

​	IntStream：表示原始int流

​	ToIntFunction接口中的方法		int applyAsInt(T value)

代码演示：

```java
    public static void main(String[] args){
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");

        //需求将集合中的字符串数据转换为整数之后在控制台输出
//        list.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
//        list.stream().map(Integer::parseInt).forEach(System.out::println);

//            list.stream().mapToInt(Integer::parseInt).forEach(System.out::println);

        //int sum() 返回此流中元素的总和
        int result = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(result);
    }
```



#### Stream流中的常见终结操作方法

Stream流的常见终结操作方法

·void forEach(Consumer action)：对此流的每个元素执行操作

·Consumer接口中的方法		void accept(T t)：对给定的参数执行此操作

·long count()：返回此流中的元素数

代码演示：

```java
public static void main(String[] args){
    //创建一个集合，存储多个字符串元素
    ArrayList<String> list = new ArrayList<String>();

    list.add("林青霞");
    list.add("张曼玉");
    list.add("王祖贤");
    list.add("柳岩");
    list.add("张敏");
    list.add("张无忌");

    //需求1：把集合中的元素在控制台中输出
    list.stream().forEach(System.out::println);

    //需求2：统计集合中有几个以张开头的元素，并把统计结果在控制台输出
    long count = list.stream().filter(s -> s.startsWith("张")).count();
    System.out.println(count);
}
```



#### Stream流练习:

```java
    public static void main(String[] args){
        //创建两个集合
        ArrayList<String> manList = new ArrayList<String>();
        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");

        ArrayList<String> womanList = new ArrayList<String>();
        womanList.add("林心如");
        womanList.add("张曼玉");
        womanList.add("林青霞");
        womanList.add("柳岩");
        womanList.add("林志玲");
        womanList.add("王祖贤");

//        //男演员只要名字为三个字的前三人
//        Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);
//
//        //女演员只要姓林的，并且不要第一个
//        Stream<String> womanStream = womanList.stream().filter(s -> s.startsWith("林")).skip(1);
//
//        //把过滤后的男演员姓名和女演员姓名合并在一起
//        Stream<String> stream = Stream.concat(manStream, womanStream);
//
//        //把上一步操作后的元素作为构造方法的参数创建演员对象，遍历数据
////        stream.map(Actor::new).forEach(System.out::println);
//        stream.map(Actor::new).forEach(s -> System.out.println(s.getName()));
        Stream.concat(manList.stream().filter(s -> s.length()==3).limit(3),
                womanList.stream().filter(s->s.startsWith("林")).skip(1)).map(Actor::new).forEach(s -> System.out.println(s.getName()));
    }
```



#### Stream流的收集操作

对数据使用Stream流的方式操作完毕后，我想把流的数据收集到集合中，该怎么办呢？

Stream流的收集方法

·R collect(Collector collector)

·但是这个收集方法的参数是一个Collector接口



工具类Collectors提供了具体的收集方式

·public static <T> Collector toList()：把元素收集到List集合中

·public static <T> Collector toSet()：把元素收集到Set集合中

·public static Collector toMap(Function keyMapper,Function valueMapper)：把元素收集到Map集合中

```java
 public static void main(String[] args) {
        /*
        //创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");

        //需求1：得到名字为三个字的流
        Stream<String> listStream = list.stream().filter(s -> s.length() == 3);

        //需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历
        List<String> names = listStream.collect(Collectors.toList());
        for (String name : names){
            System.out.println(name);
        }
        */
/*
        //Set集合对象
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);

        //需求3：得到年龄大于25的流
        Stream<Integer> setStream = set.stream().filter(age -> age > 25);
        Set<Integer> ages = setStream.collect(Collectors.toSet());
        for (Integer age : ages){
            System.out.println(age);
        }
    */

        //定义一个字符串数组，每一个字符串数据由姓名数据和年龄数据组合而成
        String[] strArray = {"林青霞,30","张曼玉,35","王祖贤,33","柳岩,25"};

        //需求5：得到字符串中年龄数据大于28的流
        Stream<String> ages = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28);

        //需求6：把使用Stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名作键，年龄做值
        Map<String, Integer> map = ages.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));

        Set<String> keySet = map.keySet();
        for (String key : keySet){
            Integer value = map.get(key);
            System.out.println(key+","+value);
        }
    }
```



