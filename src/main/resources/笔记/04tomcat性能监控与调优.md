# tomcat远程debug



tomcat-manager监控



官网:

https://www.ibm.com/developerworks/cn/java/j-lo-jpda3/



### tomcat配置:

/usr/local/tomcat-frontend

1. vi ./bin/startup.sh

最后一行修改成:

```
exec "$PRGDIR"/"$EXECUTABLE" jpda start "$@"
```

2. vi ./bin/catalina.sh 

搜索  :/JPDA

搜索:

 JPDA_ADDRESS=

![image-20200705232530028](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705232530028.png)

默认是8000端口debug  根据需求修改

这里为了方便调试修改成如下:

 JPDA_ADDRESS="54321"

3.重启  查看8000端口

yum install net-tools  (安装命令工具)

 netstat -nap | grep 54321

![image-20200705234725859](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705234725859.png)



4.将war包部署到tomcat

http://172.16.95.142:8080/monitor_tuning/ch5/hello

5.本机debug 远程tomcat

![image-20200705235052391](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200705235052391.png)





# tomcat-manager监控

![image-20200706003149157](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200706003149157.png)





# psi-probe监控



https://github.com/psi-probe/psi-probe





# tomcat优化

tomcat内置文档: docs/config/http.html

![image-20200706083530394](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200706083530394.png)



![image-20200706083903112](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200706083903112.png)

![image-20200706083844733](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200706083844733.png)













