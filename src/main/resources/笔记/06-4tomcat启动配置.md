

bin目录下 catalina.sh配置:



```

PARALLEL_OPTION="-XX+UseParallelGC -XX:+UseParalleloldGc -XX:MaxGCPauseMi1lis=200 -XX: GCTi meRatio=99"

CMS_OPTION="-XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=92 -XX:+UseCMSIniti atingOccupancyonly -XX:+UseCMSCompactAtFu11Collection -XX:CMSFullGCsBeforeCompaction=5"

G1_OPTION="-XX:+UseG1GC -XX:+UseStringDeduplication -XX: StringDeduplicationAgeThreshold=3 -XX:+UseCompressedC1assPointers -XX:MaxGCPauseMil1is=200"

JAVA_OPTS="$JAVA_OPTS -XX:+UseCopcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -verbose:gc -Xloggc:../logs/gc.log"

JAVA_OPTS="$JAVA_OPTS $JSSE_OPTS'

urity policy
JAVA_OPTS="$JAVA_OPTS -Djava.protocol.handler.pkgs=org.apache.catalina.webresources"
```



cd /usr/local/tomcat-9/1ogs/logs/

touch gc.log

chmod -R 777 gc.log





```
JAVA_OPTS="-Xms2500M -Xmx2500M -XX:MaxNewSize=512m -XX:MaxPermSize=1024m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -verbose:gc -Xloggc:./logs/gc.log"

```