# ngx_http_stub_status配置--内置





首先在ngixn/sbin 目录下查看nginx编译参数:

./nginx -V

nginx version: nginx/1.16.1
built by gcc 4.8.5 20150623 (Red Hat 4.8.5-39) (GCC) 
configure arguments: --prefix=/usr/local/nginx --pid-path=/var/run/nginx/nginx.pid --lock-path=/var/lock/nginx.lock --error-log-path=/var/log/nginx/error.log --http-log-path=/var/log/nginx/access.log --with-http_gzip_static_module --http-client-body-temp-path=/var/temp/nginx/client --http-proxy-temp-path=/var/temp/nginx/proxy --http-fastcgi-temp-path=/var/temp/nginx/fastcgi --http-uwsgi-temp-path=/var/temp/nginx/uwsgi --http-scgi-temp-path=/var/temp/nginx/scgi



搜索:stub_status





# ngxtop安装--插件



 yum install epel-release

yum install python-pip

pip install ngxtop



官网:

https://github.com/lebinh/ngxtop



# Nginx-rrd监控--图形化





# Nginx优化

增加工作线程数和并发连接数

启用长连接

启用缓存,压缩

操作系统优化



1.增加工作线程数和并发连接数

```
worker_processes  1; #cpu 
events {
    worker_connections  1024; #每一个进程打开的最大连接数,包含了nginx客户端和nginx与upstream之间的连接
    multi_accept on; #可以一次建立多个连接
    use epoll; #连接模型
}

```

2.

 keepalive_timeout  65;

![image-20200707234247449](/Users/zhangchao/Library/Application Support/typora-user-images/image-20200707234247449.png)

配置当前nginx服务器与被代理的机器之间长连接的值