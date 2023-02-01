# 					Git&&GitHub学习笔记



## 版本控制

### 版本控制工具应该具备的功能：

* 协同修改： 多人并行不悖的修改服务器端的同一个文件

* 数据备份： 不仅保存的目录和文件的当前状态，还能够保存每一个提交过的历史状态

* 版本管理： 

  在保存每一个版本的文件信息的时候要做到不保存重复数据，以节约存储空间，提高运行效率。这方面SVN采用的是增量式管理的方式，而Git采取了文件系统快照的方式。

* 权限控制： 

  对团队中参与开发的人员进行权限控制。

  对团队外开发者贡献的代码进行审核——Git独有

* 历史记录：

  查看修改人、修改时间、修改内容、日志信息

  将本地文件恢复到某一个历史状态

* 分支管理：

  允许开发团队在工作过程中多条生产线同时推进任务，进一步提高效率



### 版本控制：

​	工程设计领域中使用版本控制管理工程蓝图的设计过程。在IT开发过程中也可以使用版本控制思想管理代码的版本迭代。



### 版本控制工具：

​	思想：版本控制

​	实现：版本控制工具

​	集中式版本控制工具：	CVS、SVN、VSS······

​		![image-20230129131201550](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129131201550.png)

缺点：如果服务器宕机或者损坏，我们的历史数据会全部丢失、本机客户端上保存的只是当前状态（单点故障问题）



​	分布式版本控制工具：Git、Mercurial、Bazzar、Darcs······

​		较集中式版本控制工具有能避免单点故障的优势

## Git简介

![image-20230129131706606](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129131706606.png)



### Git的优势：

—>大部分操作在本地完成，不需要联网

—>完整性保证

—>尽可能添加数据而不是删除或修改数据

—>分支操作非常快捷流畅

—>与Linux命令全面兼容



### Git结构：

​	历史版本——>	本地库

​									↑

​							git commit

​									 ↑

​	临时存储——>	暂存区

​									 ↑

​								git add

​									 ↑

​		写代码——>	工作区										



### Git和代码托管中心：

代码托管中心的任务：维护远程库

局域网环境下：GitLab服务器

外网环境下：

* GitHub

* 码云

  

### 本地库和远程库

—>团队内部协作

![image-20230129142745922](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129142745922.png)

——>跨团队协作

![image-20230129143141317](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129143141317.png)



## 4 Git命令行操作

命令如下：

* clone（克隆）：从远程库中克隆代码到本地库
* checkout（检出）：从本地仓库中检出一个仓库分支然后进行修订
* add（添加）：在提交前先将代码提交到暂存区
* commit（提交）：提交到本地仓库。本地仓库中保存修改的各个历史版本
* fetch（抓取）：从远程库，抓取到本地仓库，不进行任何的合并操作，一般操作比较少
* pull（拉取）：从远程库拉到本地库，自动进行合并（merge），然后放到工作区，相当于fetch+merge
* push（推送）：修改完成后，需要和团队成员共享代码时，将代码推送到远程仓库



解决gitbash乱码问题：

1.指令：git config --global core.quotepath fasle



### 4.1 获取本地库：

1.在电脑任意位置创建一个空目录，作为本地仓库

2.进入这个目录，打开gitbash窗口

3.执行命令git init

4.创建成功后可以在文件夹下看见隐藏的.git目录



### 本地库操作：

#### 4.2本地库初始化：

* 命令：git add
* 效果：![image-20230129144529162](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129144529162.png)
  
* 注意：	.git 目录中存放的是本地库相关的子目录和文件，不要删除，也不要胡乱修改。
  
* 设置签名：

  ——>形式：

  ​			用户名：

  ​			Email地址：

  ——>作用：区分不同开发人员的身份

  ——>辨析：这里设置的签名和登录远程库（代码托管中心）的账号、密码没有任何关系

  ——>命令：

  * 项目级别/仓库级别：仅在当前本地库范围内有效

    * 命令：git config uer.name tom_pro

    * git config user.email goodMorning_@atguigu.com

    * 信息保存位置： ./.git/config 文件

      ![image-20230129151645773](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129151645773.png)

  * 系统用户级别：登录当前操作系统的用户范围

    * 命令：git config --global user.name tom_glb

    * git config --global user.email goodMorning_@atguigu.com

    * 信息保存的位置：~/.gitconfig 文件

      ![image-20230129152342227](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129152342227.png)

  * 优先级：就近原则，项目级别优先于系统用户级别，二者都有时采用项目级别的签名

    ​				如果只有系统用户级别的签名，就以系统用户级别的签名为准

    ​				二者都没有不允许

    

#### 4.3基本操作：

基础操作指令：Git工作目录下对于文件的修改（增加、删除、更新）会存在几个状态，这些修改的状态会随着我们执行Git的命令而发生变化。

![image-20230131214452813](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230131214452813.png)



* #### 状态查看操作：

  git status     （查看工作区、暂存区状态）

* #### 添加操作：

  git add [file name]   （将工作区的“新建/修改”添加到暂存区）

* #### 提交操作：

  git commit -m "commit message" [file name]      （将暂存区的内容提交到本地库）

* #### 查看历史记录操作：

  * #### git log 

    ![image-20230129163111841](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129163111841.png)

    命令形式：git log [option]

    * options：
      * --all 显示所有分支
      * --pretty=oneline 将提交信息显示为一行
      * --abbrev-commit 使得输出的commited更简短
      * --graph 以图的形式显示

    多屏显示控制方式：

    ​	1.空格向下翻页

    ​	2.b向上翻页

    ​	3.q退出

    

  * #### git log --pretty=oneline

    ![image-20230129163415500](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129163415500.png)

    

  * #### git log --oneline

    ![image-20230129163526416](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129163526416.png)

    

    * #### git reflog（查看已经删除的提交记录）

    ![image-20230129163641481](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129163641481.png)



#### 添加文件至忽略列表

一般我们总会有些文件无需纳入Git的管理，也不希望他们总出现在未跟踪文件列表。通常都是些自动生成的文件，比如日志文件，或者编译过程中创建的临时文件等。在这种情况下，我们可以在工作目录中创建一个名为 .gitignore的文件（文件名称固定），列出要忽略的文件模式。范例：





* #### 前进后退

  * 本质：![image-20230129164014453](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129164014453.png)

    

  * 基于索引值操作[推荐]

    * git reset --hard [局部索引值]
    * 例子： git reset --hard cac4a76

  * 使用^符号：只能后退
    * git reset --hard HEAD^		
    * 注意：有几个^退几步
  * 使用~符号：只能后退
    * git reset --hard HEAD~n
    * 注意：表示后退n步



##### reset命令的三个参数对比：

* --soft 参数
  
  * 仅仅在本地库移动HEAD指针
* --mixed参数
  * 在本地库移动HEAD指针
  * 重置暂存区
* --hard参数
  * 在本地库移动HEAD指针
  * 重置暂存区
  * 重置工作区

* 删除文件并找回：

  * 前提：删除前，文件存在时的状态提交到了本地库。

  * 操作：git reset --hard [指针位置]

    * 指针位置：历史记录或当前位置

    * 删除操作已经提交到本地库：指针位置指向历史记录

    * 删除操作尚未提交到本地库：指针位置使用HEAD

      

##### 比较文件差异：

* git diff [文件名]
  * 将工作区中的文件和暂存区进行比较
* git diff [本地库中历史版本] [文件名] 
  * 将工作区中的文件和本地库历史记录比较
* 不带文件名比较多个文件
* 

#### 4.4分支管理：

* 什么是分支？

  在版本控制过程中，使用多条线同时推进多个任务

  ![image-20230129195520342](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129195520342.png)

* 分支的好处？

  同时并行推进多个功能的开发，提高开发效率

  各个分支在开发过程中，如果某个分支开发失败，不会对其他分支有任何影响。失败的分支删除重新开始即可。



* 分支操作：

  创建分支：

  git branch [分支名]

* 查看分支：

  git branch -v

  git branch

* 切换分支：

  git checkout [分支名]

  git checkout -b [分支名]：创建并切换

* 合并分支

  * 第一步：切换到接受修改的分支(被合并，增加新内容)上

    git checkout [分支名]

  * 第二部：执行merge命令

    git merge [有新内容分支名]

* 删除分支：

  * git branch -d b1	删除分支时，需要做各种检查
* git branch -D b1    不做任何检查，强制删除

* 解决冲突

  * 冲突的表现

    ![image-20230129201936375](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129201936375.png)

  * 冲突的解决

  * 当两个分支上对文件的修改可能会存在冲突，例如同时修改了一个文件的同一行，这时就需要动手解决冲突，解决冲突步骤如下：

    * 第一步：编辑文件，删除特殊符号
    * 第二步：把文件修改到满意的程度，保存退出
    * 第三步：git add [文件名]
    * 第四步：git commit -m "日志信息"
    * 注意：此时commit一定不能带具体文件名

![image-20230201151240566](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201151240566.png)



#### 开发中分支使用原则与流程

几乎所有的版本控制系统都以某种形式支持分支。使用分支意味着你可以把你的工作从开发主线上分离开来进行重大的Bug修改、开发新功能，以免影响开发主线

在开发中，一般有如下分支使用原则与流程：

* master（生产）分支：

  线上分支，主分支，中小规模项目作为线上运行的应用对应的分支；

* develop（开发）分支：

  是从master创建的分支，一般作为开发部门的主要开发分支，如果没有其他并行开发不同期上线要求，都可以在此版本进行开发，阶段开发完成后，需要是合并到master分支，准备上线。

* feature/xxxx分支：

  从develop创建的分支，一般是同期并行开发，但不同期上线时创建的分支，分支上的研发任务完成后合并到develop分支

* hotfix/xxxx分支：

  从master派生的分支，一般作为线上bug修复使用，修复完成后需要合并到master、test、develop分支。

![image-20230201152804545](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201152804545.png)



#### 远程库操作：

* git remote -v   	：查看当前所有远程地址别名

* git remote add [别名] [远程地址]     ：起别名

* git push [别名] [分支]	：推送本地分支上的内容到远程库

* git push -f [别名] [分支]（强推）（慎用）：即利用强覆盖方式用你本地的代码替代git仓库内的内容

* git clone [远程地址]        	：将远程仓库的内容克隆到本地

* git pull 远程库地址别名 远程分支名		：将远程仓库对于分支最新内容拉下来后与当前本地分支直接合并

   



## 5 Git基本原理：

### 5.1 哈希：

哈希是一个系列的加密算法，各个不同的哈希算法虽然加密强度不同，但是有以下几个共同点：

* 不管输入数据的数据量有多大，输入同一个哈希算法，得到的加密结果长度固定

* 哈希算法确定，输入数据确定，输出数据能够保证不变

* 哈希算法确定，输入数据有变化，输出数据一定有变化，而且通常变化很大

* 哈希算法不可逆

  Git底层采用的是SHA-1算法

  哈希算法可以被用来验证文件，原理如下图所示：

  ![image-20230129204642765](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129204642765.png)

Git就是靠这种机制来从根本上保持数据完整性的。

### 

### 5.2 Git保存版本的机制

#### 5.2.1 集中式版本控制工具的文件管理机制

​	以文件变更列表的方式存储信息。这类系统将他们保存的信息看作是一组基本文件和每个文件随时间逐步累积的差异

![image-20230129205502125](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129205502125.png)



#### 5.2.2 Git的文件管理机制

​	Git把数据看作是小型文件系统的一组快照。每次提交更新Git都会对当前的全部文件制作一个快照并保存这个快照的索引。为了高效，如果文件没有修改，Git不再重新存储该文件，而是保留一个链接指向之前存储的文件。所以Git的工作方式可以被称之为快照流。

![image-20230129205908374](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129205908374.png)



#### 5.5.3 Git文件管理机制细节

* Git的 “提交对象”

  ![image-20230129210045114](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129210045114.png)

* 提交对象及其父对象形参的链条

  ![image-20230129210805823](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129210805823.png)



### 5.3 Git分支管理机制

#### 5.3.1	分支的创建

![image-20230129211008072](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129211008072.png)



#### 5.3.2	分支的切换

![image-20230129211236825](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129211236825.png)



![image-20230129211345717](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129211345717.png)



![image-20230129211632197](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129211632197.png)



![image-20230129211806754](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230129211806754.png)





## 6 GitHub

### 6.3 创建远程库地址

Repositories→New



### 6.4 推送

​									git push [别名] [分支名]

![image-20230130125157603](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130125157603.png)

如遇本地库与远程库不一致情况时，先执行： git pull --rebase origin master 再推送

* 命令git push [-f] [--set-upstream] [远端名称[本地分支名][：远端分支名]]

  * 如果远程分支名和本地分支名称相同，则可以只写本地分支
    * git push origin master
  * -f 表示强制覆盖（慎用）

  * --set-upstream推送到远端的同时并且建立起和远端分支的关联关系
    * git push --set-upstream origin master
  * 如果当前分支已经和远端分支关联，则可以省略分支名和远端名
    * git push 将master分支推送到已关联的远端分支。

* ### 查看远程仓库：git remote 

  

### 6.5 克隆

* 命令

  *  git origin [远程地址] 

    ![image-20230130125436995](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130125436995.png)

* 效果：

  * 完整地把远程库下载到本地
  * 创建origin远程地址别名
  * 初始化本地库



### 6.6 邀请成员加入团队

​	远程库——>setting ——>Collaborator



### 6.7 抓取和拉取

远程分支和本地的分支一样，我们可以进行merge操作，只是需要先把远程仓库里的更新都下载到本地，再进行操作。

* 抓取命令：git fetch [remote name] [branch name]
  * 抓取指令就是你将仓库里的更新都抓取到本地，不会进行合并
  * 如果不指定远端名称和分支名，则抓取所有分支

*  拉取命令：git pull [远程库地址别名] [远程分支名]    （pull = fetch + merge）
   * 拉取指令就是将远端仓库的修改拉到本地仓库并自动进行合并，等同于fetch+merge
   * 如果不指定远端名称和分支名，则抓取所有并更新当前分支
* git merge [远程库地址别名/远程分支名]



### 6.8 解决合并冲突

在一段时间，A、B用户修改了同一个文件，且修改了同一行位置的代码，此时会发生合并冲突。

A用户在本地修改代码后优先推送到远程仓库，此时B用户在本地修订代码，提交到本地仓库后，也需要推送到远程仓库，此时B用户晚于A用户，故需要先拉取远程仓库的提交，经过合并后才能推送到远端分支，如下图：

![image-20230201172239682](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201172239682.png)







* 要点：
  * 如果不是基于GitHub远程库的最新版所做的修改，不能推送，必须先拉取。
  * 拉取下来后如果进入冲突状态，则按照“分支冲突解决” 操作解决即可。
* 类比：
  * 债权人：老王
  * 债务人：小刘
  * 老王说：十天后归还。小刘接受，双方达成一致
  * 老王媳妇说：5天后归还，小刘不能接受。老王媳妇需要找老王确认后再执行。



### 6.9跨团队协作

* Fork

  ![image-20230130213203169](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130213203169.png)

* 本地修改：然后推送到远程库

* Pull Request

  ![image-20230130213705828](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130213705828.png)

* ![image-20230130213747414](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130213747414.png)



* 点commit看具体提交，看File changes看做了什么修改
* 审核代码
* 合并代码
* 添加相关信息
* Confirm merge
* 将远程库修改，拉取到本地



### 6.10 SSH登录

* 进入当前用户的家目录
  * cd ~
* 删除.ssh目录
  * rm -rvf .ssh
* 运行命令生成.ssh密钥目录
  * ssh-keygen -t rsa -C 邮箱号
* 进去.ssh目录查看文件列表
  * cd .ssh
  * ls -lF
* 查看id_rsa.pub文件内容
  * cat id_rsa.pub
* 复制id_rsa.pub 文件内容，登录GitHub，点击用户头像→Setting→SSH and GPG keys
* New SSH Key
* 输入复制的密钥信息
* 回到Git bash创建远程地址别名
  * git remote add origin_ssh SSH地址
* 推送文件进行操作
* 







## 7 在Idea中使用Git

### 7.1 在Idea中配置Git

如果Git安装在默认路径下，那么idea会自动找到Git的位置，如果更改了Git的安装位置则需要手动配置下Git的路径。选择File→Setting打开设置窗口，找到Version Control下的git选项：

![image-20230201174303028](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201174303028.png)



### 7.2  在Idea中操作Git

场景：本地已经有一个项目，但是并不是Git项目，我们需要将这个方法GitHub仓库里，和其他开发人员继续一起协作开发。



#### 7.2.1创建项目远程仓库（参考6.3）



### 7.3 IDEA常用GIT操作入口

![image-20230201203517150](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201203517150.png)

![image-20230201204449345](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201204449345.png)



### 7.4 场景分析：

1.由组长 ，基于本项目创建本地仓库；创建远程仓库，推送项目至远程仓库

![image-20230201205101392](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201205101392.png)

2.没一位组员从远程克隆项目呢到idea中，这样每位同学在自己电脑上就有了一个工作副本，可以正式的开始开发了。我们模拟两个组员（组员A、组员B），克隆两个工作区

![image-20230201205129306](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201205129306.png)

3.组员A修改工作区，提交到本地库，再推送到远程仓库。组员B可以直接从远程仓库获取最新的代码

![image-20230201205301037](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201205301037.png)

4.组员A和组员B修改了同一个文件的同一行，提交到本地没有问题，但是推送到远程仓库时，后一个推送操作就会失败

​		解决方法：

需要先获取远程库的代码到本地仓库，编辑冲突，提交并推送代码

![image-20230201205504864](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201205504864.png)

* ### 附：几条铁令：

* 切换分支前先提交本地的修改

* 代码及时提交，提交过了就不会丢

* 遇到任何问题都不要删除文件目录，第一时间找老师



* ### 附：疑难问题解决：

* Windows下看不到隐藏文件（.bashrc/.gitignore）

![image-20230201205911327](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201205911327.png)

* windows下无法创建.ignore|.bashrc文件

  * 以创建.ignore文件为例：

    * 在git目录下打开gitbash

    * 执行指令touch .gitignore

      ![image-20230201210234563](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201210234563.png)

      ![image-20230201210254492](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201210254492.png)

* 附：IDEA集成GitBash作为Terminal

  ![image-20230201210505261](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230201210505261.png)

## 

## 总结：

* 工作区—>暂存区		git add 

* 暂存区—>本地库         git commit -m "commit message 01"

* 查看状态          git status

* 查看提交记录      git log 

* 版本回退（理解即可）     git reset --hard <commitID>

* 查看分支        git branch 

* 创建并切换分支         git checkout -b 分支名

* 分支合并            git merge

  ​					—首先切换到目标分支上

* 远程仓库

  * remote add
  * push 
  * clone
  * fetch
  * pull(fetch + merge)

* idea操作

  * 找到适合自己的操作方式

