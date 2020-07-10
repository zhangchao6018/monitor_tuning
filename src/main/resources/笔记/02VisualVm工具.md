mac 下载地址 https://visualvm.github.io/download.html



mac 如何打开kdk自带的jvisualvm

**访达前往/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/home/bin**

插件

https://visualvm.github.io/pluginscenters.html





### jvisualvm连接远程java进程



1.连接tomcat

需要在远程的tomcat服务器上配置

修改Catalina.sh

```
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -
Dcom.sun.management.jmxremote.port= 9004 -
Dcom.sun.management.jmxremote.authenticate=false -
Dcom.sun.management.jmxremote.ssl=false -
Djava.net.preferlPv4Stack=true -
Djava.rmi.server.hostname= 172.16.95.142"

vi ./bin/catalina.sh 
搜索 JAVA_OPTS="$JAVA_OPTS $JSSE_OPTS"  添加上方配置
./bin/startup.sh
tail -f ./logs/catalina.out
```





2.连接java进程

```

nohup java -Dcom.sun.management.jmxremote - Dcom.sun.management.jmxremote.port= 9005 - Dcom.sun.management.jmxremote.authenticate=false - Dcom.sun.management.jmxremote.ssl=false - Djava.net.preferlPv4Stack=true - Djava.rmi.server.hostname= 172.16.95.142 -jar monitor_tuning-0.0.1-SNAPSHOT.jar &
```



文档:

https://visualvm.github.io/documentation.html