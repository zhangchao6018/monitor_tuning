https://github.com/btraceio/btrace

https://github.com/btraceio/btrace/releases/tag/v1.3.11



有点类似于拦截器

可用于生产环境,拦截各种方法,拿到方法参数,返回值,异常等

1.配置环境变量

sudo vi ~/.bash_profile

```
https://blog.csdn.net/qq_33430322/article/details/106826984?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-2

vim ~/.bash_profile

#Btrace
BTRACE_HOME=/Users/zhangchao/develop/btrace/btrace
export BTRACE_HOME
export PATH=${PATH}:${BTRACE_HOME}/bin

source ~/.bash_profile
```

2.btrace脚本所在项目pom导入jar包

启动项目

jps -l 找到进程号

输入:

btrace <进程号> <脚本名称>.java

btrace 2414 PrintArgSimple.java



3.访问需要btrace追踪的接口

http://localhost:12345/ch4/arg1/?name=zhangsan



4.查看第2步命令行

![image-20200705192442396](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705192442396.png)



### 拦截方法(以上已经演示)



### 拦截构造函数

btrace 2414 PrintConstructor.java

 http://localhost:12345/ch4/constructor/?name=zhangsan&id=1

![image-20200705193148138](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705193148138.png)



### 拦截方法重载

http://localhost:12345/ch4/same3/?id=666

btrace 2414 PrintSame.java





# 拦截时机

![image-20200705200207949](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705200207949.png)



拦截异常信息

btrace 3231 PrintOnThrow.java

http://localhost:12345/ch4/exception





![image-20200705202444926](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705202444926.png)



拦截异常抛出的行号

btrace 3231 PrintLine.java



### 拦截this



### 获取对象的值(反射)

http://localhost:12345/ch4/arg2/?name=zhangsan&id=9

btrace -cp "/Users/zhangchao/code/imooc/monitor_tuning/target/classes" 3271 PrintArgComplex.java

![image-20200705204706849](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705204706849.png)





### 问题

默认只能本地运行

生产可以使用,但是被修改后的字节码不会被还原

