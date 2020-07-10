# XX参数分类

### 1.Boolean类型

```
格式: -XX:[+-]<name>表示启用或者禁用name属性
```

如:

```
-XX:+UseConcMarkSweepGc
-XX:+useG1GC
```

### 2.非Boolean类型

```
格式: -XX:<name>=<value>表示name属性的值是value
```

如

```
 -XX:MaxGCPauseMillis=500
 XX:GCTimeRatio=19
```

### 3.-Xmx -Xms

不是X参数,而是XX参数

-Xms等价于-XX:InitialHeapSize

-Xmx等价于-XX:MaxheapSize

eg:

`jinfo -flag MaxHeapSize 19650`

`jinfo -flag ThreadStackSize 19650`





# 查看JVM运行时参数



```
-XX:+PrintFlagsInitial    初始值
-XX:+PrintFlagsFinal			最终值
-XX:+UnlockExperimentalVMoptions 解锁试验参数
-XX:+UnlockDiagnosticVMOptions	解锁诊断参数
-XX:+PrintCommandLineFlags	打印命令行参数

```



### 1.PrintFlagsFinal

=表示默认值

:=被用户或者JVVm修改后的值

![image-20200704225257920](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200704225257920.png)



java -XX:+PrintFlagsFinal -version



### **2.jps**

专门查看java进程

官方网站  搜索jps可查看命令

https://docs.oracle.com/javase/8/docs/technotes/tools/unix/index.html



### 3.jinfo

查看正在运行jvm的运行参数

eg:

`jinfo -flag MaxHeapSize 19650`

`jinfo -flags 19650`



# jstat查看JVM统计信息

类装载

垃圾收集

JIT编译



格式:

options:-class,-compiler,-gc,-printcompilation



### 垃圾收集

-gc,-gcutil,-gccause,-gcnew,-gcold

`jstat -gc 19650 1000 3`    进程id 每1000ms输出一次  总共输出三次

![image-20200704232214832](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200704232214832.png)

![image-20200704232346670](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200704232346670.png)







### JVM内存结构

...



### JIT编译

jstat -compiler p 19650





# jmap+MAT实战内存溢出



### 1.如何导出内存溢出镜像文件

##### 设置内存溢出自动导出   --异常发生后

-XX:+HeapDumpOnOutOfMemoryError

-XX:HeapDumpPath=./

##### 使用imap命令手动导出   ---文件较大时



![image-20200705001120205](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705001120205.png)

手动导出命令:

jps -l

jmap -dump:format=b,file=heap.hprof 16562   --导出到命令行所在当前目录

可看到文件:heap.hprof

### 2.MAT分析内存溢出

下载地址:https://www.eclipse.org/mat/downloads.php



# jstack实战死循环与死锁

线程的状态

https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr034.html



![image-20200705004236340](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705004236340.png)

https://mp.weixin.qq.com/s/GsxeFM7QWuR--Kbpb7At2w





1.将应用部署到服务器

mvn clean package -Dmaven.test.skip

nohup java -jar monitor_tuning-0.0.1-SNAPSHOT.jar

2.访问多次死循环接口:

http://172.16.95.142:12345/loop

3.top命令查看

![image-20200705114210383](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705114210383.png)



4.如何定位代码?

jstack 59732 > 59732.txt    将这个pid打印到txt

 top -p 59732 -H  

![image-20200705114619169](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705114619169.png)



printf "%x" 59732    -->十进制转换成16进制

见:01jstack查看死循定位代码.md





定位死锁:

http://localhost:12345/deadlock

jstack 5485 > 5485.txt 