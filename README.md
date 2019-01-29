# open office 服务
系统: Linux root 3.10.0-693.2.2.el7.x86_64 #1 SMP Tue Sep 12 22:26:13 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux
## 下载
[官网](https://www.openoffice.org/)
linux下载 Apache_OpenOffice_4.1.6_Linux_x86-64_install-rpm_zh-CN.tar.gz
## 解压安装
```
tar -zxvf Apache_OpenOffice_4.1.6_Linux_x86-64_install-rpm_zh-CN.tar.gz
```
![解压后](https://raw.githubusercontent.com/sunlggggg/images/master/software/open%20office.png)

进入RPMS，进行安装所有包

```
yum localinstall *.rpm
```
进入RPMS/desktop-integration 安装 redhat对应的包
```
yum localinstall openoffice4.1.6-redhat-menus-4.1.6-9790.noarch.rpm
```
运行
```
/opt/openoffice4/program/soffice -headless -accept="socket,host=<ip>,port=8100;urp;" -nofirststartwizard
```
**注意** *host设置时，如果是云服务器需要配置为ifconfig中的局域网IP（如果存在），否则外网无法访问。*
## 可能问题
- /opt/openoffice4/program/soffice.bin: error while loading shared libraries: **libXext.so.6**: cannot open shared object file: No such file or directory
```
yum install libXext.x86_64
```
- no suitable windowing system found, exiting.
```
yum groupinstall "X Window System"
```
- 中文支持问题
服务器安装中文支持，并重启服务器 

[参考](https://blog.csdn.net/Lucky_boy_gilr/article/details/52996198)


## 客户端调用

jar 包调用，用户文件后缀来确定转成何种格式。
```
java -jar openofficedemo.jar 127.0.0.1 8100 <infilepath> <outfilepath>
```

运行结果

``` 
连接时间:2019-01-29 20:31:06
一月 29, 2019 8:31:06 下午 com.artofsolving.jodconverter.openoffice.connection.AbstractOpenOfficeConnection connect
信息: connected
一月 29, 2019 8:31:11 下午 com.artofsolving.jodconverter.openoffice.connection.AbstractOpenOfficeConnection disposing
转换时间:2019-01-29 20:31:11
信息: disconnected
耗时:5秒
```

[github](https://github.com/sunlggggg/openofficedemo)


