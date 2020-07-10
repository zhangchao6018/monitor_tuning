# JVM的内存结构

![image-20200707234852189](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200707234852189.png)



![image-20200708080337583](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080337583.png)



![image-20200708080406153](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080406153.png)





![image-20200708080521418](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080521418.png)



Metaspace(java8)

![image-20200708080651496](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080651496.png)

![image-20200708080742642](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080742642.png)

![image-20200708080832654](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080832654.png)



![image-20200708080922114](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708080922114.png)



![image-20200708081959533](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708081959533.png)

![image-20200708082018104](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708082018104.png)



![image-20200708082026199](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708082026199.png)





![image-20200708202551974](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708202551974.png)





------



# 标记清除算法

#### 算法

算法分为'标记'和清除两个阶段,:首先标记出所有需要回收的对象,在标记完成之后统一回收所有

#### 缺点

效率不高.标记和清除两个过程都不高.

产生碎片.碎片过多会导致提前GC.



# 复制算法

#### 算法

它将可用内存按照容量划分为大小相等的两块,每次只使用其中一块.当这块内存用完了,九江还存活着的对象复制到另外一块上面,然后再把已使用过的内存空间一次清理掉.

#### 优缺点

实现简单,运行高效,但是空间利用率低



# 标记整理算法

#### 算法

标记过程仍然与'标记-清除'算法一样,但后续步骤不是直接对可回收对象进行清理,而是让所有存活对象都想一端移动,然后直接清理掉边界以外的内存

#### 优缺点

没有了内存碎片,但是整理内存比较耗时



# 分代垃圾回收

#### Young区用复制算法    

大部分对象生命首期都比较短

#### Old区用标记清除或者标记整理算法

生命首期都比较长,垃圾较少,用复制算法的话浪费



------











# 对象分配

![image-20200708204147448](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708204147448.png)





# 垃圾收集器

![image-20200708204428476](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708204428476.png)





### 并行与并发

![image-20200708204625504](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708204625504.png)



### 停顿时间和吞吐量



![image-20200708204815768](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708204815768.png)





# 串行收集器

![image-20200708205256584](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708205256584.png)





# 并行收集器

![image-20200708205238948](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708205238948.png)





# 并发收集器

![image-20200708205714653](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708205714653.png)





![image-20200708205927097](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708205927097.png)





![image-20200708210028073](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708210028073.png)

![image-20200708210105095](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708210105095.png)





![image-20200708210121931](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200708210121931.png)



- 1

  0 JAVA应用性能监控与调优txt x

- 2

  56 Metaspace↓

- 3

  57 http://ifeve.com/jvm-troubleshooting-guide-4/

- 4

  58压缩类空间↓

- 5

  69 https://blog.csdn.njjjwwi111/article/details/51564271

- 6

  70 CodeCache↓

- 7

  71 https://blog.csdn.net/yandaonan/article/details/50844806

- 8

  72 http://engineering.indeedblog.com/blog/2016/09/job-search-web-app-java-8-migration/

- 9

  73 GC洞代指南:↓

- 10

  74 https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/toc.html

- 11

  75 XQfJjifE4XEB↓

- 12

  76 https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/collectors.html

- 13

  7 G1最佳实践4

- 14

  78 https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/g1_gc_tuning.html#recommendations

- 15

  9G1 GC的一-些关键技术↓

- 16

  30 https://zhuanlan.zhihu.com/p/22591838

- 17

  31 CMS日志格式↓

- 18

  82 https://blogs.oracle.com/poonam/understanding-cms-gc-logs

- 19

  83 G1日志格式4

- 20

  84 https://blogs.oracle.com/poonam/understanding-g1-gc-logs

- 21

  85 GC日志分析工具↓

- 22

  86 http://gceasy.io/











99 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.2



100方法描述符+



101 https://docs.oracle.com/javase/specs/jvms/se8/htm/jvms-4.html#jvms-4.3.3



102字节码指令:↓



103 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html



104常量池:↓



105 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4



106本地变量表:↓



107 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.6.1



108 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.13



109操作数栈:↓



110 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.6.2



111 Code属性:↓



112)https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.3



113 LineNumberTable :↓



114 https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7.12↓



115常量表达式↓;



116 https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.28



117 String.internl



118 https://blog.csdn.net/goldenfish1919/article/details/80410349