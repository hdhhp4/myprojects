# NodeJs

## 浏览器的组成

* 人机交互部分（UI）
* 网络请求部分（Socket）
* JavaScript引擎部分（解析执行JavaScript)
* 渲染引擎部分（渲染html、css等）
* 数据存储部分（cookie、HTML5中的本地存储LocalStorage、SessionStorage）

### 主流渲染引擎

1. 渲染引擎又叫排版引擎或浏览器内核
2. 主流的渲染引擎有
   * Chrome: Blink引擎（WebKit的一个分支）
   * Safari浏览器：WebKit引擎
   * FireFox：Gecko引擎
   * Opera：Blink引擎
   * Internet Explorer：Trident引擎
   * Microsoft Edge：EdgeHTML引擎（Trident的一个分支）

### 工作原理

1. 解析HTML构建Dom树（Document Object Model，文档对象模型），DOM是W3C组织推荐的处理可扩展标记语言的编程接口。
2. 构建*渲染树* ，*渲染树* 并不等同于*DOM树* ，*渲染树* 不包含`header`和`display:none`的元素。

### Npm自定义模块下载位置

```shell
npm config set prefix "D:\nodejs\npm"
npm config set cache "D:\nodejs\npm-cache"
```

### Npm设置淘宝镜像

```shell
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

# Docker命令

* #### 进入容器

  ```shell
  docker exec -it some-mysql bash
  ```

* mysql 安装问题：

  * 2059

    ```mysql
    mysql -uroot -p
    use mysql;
    ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
    ```

  * 1130

    ```mysql
    mysql -uroot -p
    use mysql;
    update user set host='%' where user='root';
    flush privileges;
    ```

* 在其他机器访问连接visual box中的docker容器的方法

  * docker toobox 中配置好容器的端口和虚拟机的端口映射；
  * 在visual box中做端口转发（注意：必须配置好明确的ip地址，保证端口没有冲突）

### 邮箱账号

 * 网易邮箱

   `hedonliberty@yeah.net`



