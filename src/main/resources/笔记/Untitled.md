```
#导入jdk home路径
export JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home
export JAVA_11_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.7.jdk/Contents/Home
 #申明别名，用于切换使用系统的jdk环境
alias jdk8="export JAVA_HOME=$JAVA_8_HOME"
alias jdk11="export JAVA_HOME=$JAVA_11_HOME"
 #修改系统的JAVA_HOME
export JAVA_HOME=$JAVA_8_HOME
export PATH="${JAVA_HOME}:${PATH}"


```