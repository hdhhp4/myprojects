## 当我从第八元素离开时必须拥有高级工程师的能力：

* 语言方面
  * 更加全面的Java基础技能
    * 多线程
    * IO
    * 通信
    * 容器
  * 掌握Python的开发能力
    * 爬虫
    * 网站开发
    * AI（尽量吧）

* 资质方面

  * 考一个软考架构师

* 运维方面
  * Linux的技能
    * 命令
    * shell脚本编写
    * 通用软件的使用

* 架构能力
  * SpringBoot
  * SpringJpa
  * SpringMvc
  * SpringData
  * Netty
  * 数据库
    * 关系数据的概念
    * nosql数据库：redis
  * 大数据方面
    * Hadoop
    * Hbase
    * Hive
    * Spark。。。。

* 常用算法

  **如果要回归合肥的话，一下是最低要求：飞友科技：**

  > 岗位职责：
  > 1、负责数据中间件设计及开发；
  > 2、负责进行系统版本迭代，确保系统稳定运行；
  > 3、完成上级及领导安排的其他相关工作。
  > 岗位要求:
  > 1、JAVA基础扎实，理解IO/NIO、多线程、集合等基础框架，对JVM原理有一定的了解；
  > 2、3年及以上开发经验，对于用过的开源框架，能了解到它的原理和机制；对 Spring,mybatis,struts,netty等开源框架熟悉；
  > 3、熟悉分布式系统的设计和应用，熟悉分布式、缓存、消息等机制；能对这些技术进行合理应用，解决问题；
  > 4、掌握多线程及高性能的设计与编码及性能调优；有高并发应用开发经验；
  > 5、对sql使用和优化有一定的经验；
  > 6、学习能力强，适应能力好；具备耐心/细心的品质。

## 笔记

### Zookeeper

* 查看节点

  ```powershell
  # 连接zookeeper server
  zkCli.cmd -server 192.168.18.191:2181
  # 查看dubbo节点
  ls /dubbo
  ```

### Redis

* 连接

  ```shell
  redis-cli # 本机连接
  redis-cli -h host -p port -a password # 远程连接
  ```

* 配置

  ```shell
  # 查看配置
  CONFIG GET loglevel
  # 查看全部配置
  CONFIG GET *
  # 设置配置项
  CONFIG SET CONFIG_SETTING_NAME NEW_CONFIG_VALUE
  ```

* 数据类型

  * String

    ```shell
    SET key value
    GET key
    GETRANGE key start end # 返回子串
    GETSET key value # 设置key的值为value，并返回旧值
    GETBIT key value # 对key所存储的字符串值，获取指定偏移量上的位
    MGET key [key2] # 获取多个key的值
    SETBIT key offset value # 对key所存储的字符串值，设置或清除指定偏移量上的位
    SETEX key seconds value # 设置值的同时设置过期时间
    setnx key value # key不存在时设置key的值
    setrange key offset value # 用value参数复写给定的key所存储的字符串值，从偏移量offset开始
    strlen key # 返回字符串长度
    mset key value [key1 value1] # 设置多个键值对
    msetnx key value [key1 value1] # 设置多个键值对（存在不设置）
    psetex key milliseconds value # 设置毫秒的失效时间
    incr key # 将key中存储的数字增一
    incrby key increment # 增加指定的值
    incrbyfloat key increment # 增加福地安置
    decr key # 减一
    decrby key decrement # 减指定值
    append key value # 字符串尾部追加
    
    ```

  * Hash

    ```shell
    HMSET name key1 value1 key2 value2
    HGET name key
    # 输出所有key和value
    hgetall name
    # 删除一个或多个字段
    hdel key field1 field2 [field3]
    # 检测字段是否存在
    hexists key field
    # 获取哈希表指定key对应的value
    hget key field
    # 为哈希表key中指定字段的整数值加上增量
    hincrby key field increment
    # 增加flaot增量
    hincryfloat key field increment
    # 获取所有的value
    hkeys key
    # 字段数量
    hlen key
    # 获取制定字段的值
    hmget key field [field1]
    # 设置指定字段的值
    hset key field value
    # 只在field不存在时设置value
    hsetnx key field value
    # 获取所有值
    hvals key
    # 迭代哈希表的键值对
    hscan key cursor [MATCH pattern] [COUNT count]
    ```

  * Set

    ```shell
    sadd key member
    smembers key
    # 获取集合的成员数
    scard key
    # 返回给定集合的差集
    sdiff key1 [key2]
    # 返回给定所有集合的差集并存储在destination中
    sdiffstore destination key1 [key2]
    # 交集
    sinter key1 [key2]
    # 交集并存储
    sinterstore destination key1 [key2]
    # 是否在集合中
    sismember key member
    # 移动成员到另一个集合
    smove source destination member
    # 移除返回第一个随机元素
    spop key
    # 返回集合中一个或多个随机数
    srandmember key [count]
    # 移除成员
    srem key member1 [member2]
    # 并集
    sunion key1 [key2]
    # 存储并集运算结果
    sunionstore destination key1 [key2]
    # 遍历集合
    sscan key cursor [MATCH pattern] [COUNT count]
    ```

  * List

    ```shell
    BLPOP key1 [key2 ] timeout 
    #移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
    BRPOP key1 [key2 ] timeout 
    #移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
    BRPOPLPUSH source destination timeout 
    #从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
    LINDEX key index 
    #通过索引获取列表中的元素
    LINSERT key BEFORE|AFTER pivot value 
    #在列表的元素前或者后插入元素
    LLEN key 
    #获取列表长度
    LPOP key 
    #移出并获取列表的第一个元素
    LPUSH key value1 [value2] 
    #将一个或多个值插入到列表头部
    LPUSHX key value 
    #将一个值插入到已存在的列表头部
    LRANGE key start stop 
    #获取列表指定范围内的元素
    LREM key count value 
    #移除列表元素
    LSET key index value 
    #通过索引设置列表元素的值
    LTRIM key start stop 
    #对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
    RPOP key 
    #移除并获取列表最后一个元素
    RPOPLPUSH source destination 
    #移除列表的最后一个元素，并将该元素添加到另一个列表并返回
    RPUSH key value1 [value2] 
    #在列表中添加一个或多个值
    RPUSHX key value 
    #为已存在的列表添加值
    ```

  * ZSet

    ```shell
    zadd key score member
    zrangebysocre key start end
    ```

* Redis keys命令

  ``` shell
  DEL key # 删除键
  DUMP key # 序列化key
  EXISTS key # 检查key是否存在
  EXPIRE key seconds # 设置过期时间
  EXPIREAT key timestamp # 设置过期时间， 时间参数是unix时间戳
  PEXPIRE key milliseconds # 设置过期时间，单位是毫秒
  PEXPIREAT key milliseconds-timestamp # 设置过期时间，时间戳以毫秒计
  KEYS pattern # 查找所有符合给定模式的key
  MOVE key db # 将当前数据库的key移动到给定的数据库中去
  PERSIST key # 移除key的过期时间，key将持久保持
  PTTL key # 以毫秒为单位返回key的剩余有效时间
  TTL key # 以秒为单位，返回key的剩余有效时间
  RANDOMKEY # 从当前数据库中随机返回一个key
  RENAME key newkey # 重命名
  RENAMENX key newkey # 当newkey不存在时，进行重命名
  TYPE key # key对应的value类型
  ```

### 正则表达式

* 元字符

  | 元字符 | 说明                         |
  | ------ | ---------------------------- |
  | .      | 匹配除换行符以外的任意字符   |
  | \w     | 匹配字母或数字或下划线或汉字 |
  | \s     | 匹配任意的空白符             |
  | \d     | 匹配数字                     |
  | \b     | 匹配单词的开始或结束         |
  | ^      | 匹配字符串的开始             |
  | $      | 匹配字符串的结束             |

* 重复限定

  | 语法  | 说明             |
  | ----- | :--------------- |
  | *     | 重复零次或更多次 |
  | +     | 重复一次或更多次 |
  | ?     | 重复零次或一次   |
  | {n}   | 重复n次          |
  | {n,}  | 重复n次或更多次  |
  | {n,m} | 重复n到m次       |

* 分组

  ```js
  /^(ab)*/
  ```

* 转义

  ```js
  /^(\(ab\))*/
  ```

* 条件或

  ```js
  /^(130|131|132|155|156|185|186|145|176)\d{8}$/
  ```

* 区间

  ```js
  /^((13[0-2])|(15[56])|(18[5-6])|145|176)\d{8}$/
  ```

### Linux

#### 启动过程

* 内核引导
* 运行init进程
* 系统初始化
* 建立终端
* 用户登录系统

#### 内核引导

```
当计算机打开电源后，首先是BIOS开机自检，按照BIOS中设置的启动设备（通常是硬盘）来启动。
操作系统接管硬件以后，首先读入 /boot 目录下的内核文件。
```

#### 运行init进程

```
init 进程是系统所有进程的起点，你可以把它比拟成系统所有进程的老祖宗，没有这个进程，系统中任何进程都不会启动。
init 程序首先是需要读取配置文件 /etc/inittab。
```

* 运行级别

  *NFS*: **网络文件系统**

  ```
  针对不同场景，分配不同的开机启动程序-->'运行级别'
  ```

  * 运行级别0

    系统停机状态，系统默认运行级别不能设为0，否则不能正常启动

  * 运行级别1

    单用户工作状态，root权限，用于系统维护，禁止远程登陆

  * 运行级别2

    多用户状态(没有NFS)

  * 运行级别3

    完全的多用户状态(有NFS)，登陆后进入控制台命令行模式

  * 运行级别4

    系统未使用，保留

  * 运行级别5

    X11控制台，登陆后进入图形GUI模式

  * 运行级别6

    系统正常关闭并重启，默认运行级别不能设为6，否则不能正常启动

#### VI使用

* 删除多行

  ```shell
  # 进入命令模式
  :set nu // 显示行号
  :1,14d // 删除多行
  :u // 撤销删除
  
  ```

#### Shell

```shell
#!/bin/bash
read -p 'input your name' name
echo "my name is $name"
```

* 变量

  * 用户自定义变量

    ```shell
    a='hedonghong'
    b="hello, $a"
    c="hello, ${a}teacher"
    d=`ls` === d=$(ls)
    ```

  * 位置变量

  * 预定义的特殊变量

    ```shell
    # 当前进程号
    $$
    # 上一个后台命令对应的进程号
    $!
    # 上一条命令执行后的返回码
    $?
    # 除脚本名外，命令行上参数的个数
    $#
    # 表示在命令行上实际给出的所有实参。
    # "$1 $2 $3 ..."
    $*
    # 与$*功能相同，但"$@"和"$*"显示不同，"$@"参数是彼此分离的。
    # "$1" "$2" "$3" ...
    $@
    ```

    * 1、变量名为0的值代表正在执行的脚本名称
    * 2、变量名为1到99的值代表命令行传入的参数
    * 3、变量名大于10时，必须用{}括起来
    * 4、内置命令shift：造成参数变量号码偏移
    * 5、shift 等价于 shift 1

  * 环境变量

    **之能被子进程所继承的变量。子进程指挥继承父进程的环境变量** 

    ```shell
    # 查看当前环境下所有环境变量及其值
    env
    # 导出环境变量
    export HOME PATH PSI
    ```

  * 算术运算

    * 加减乘除、取余

      ```shell
      echo $(($a+$b))
      ```

    * declare命令

      ```shell
      declare -i a=10
      declare -i b=20
      declare -i c=$a+$b
      echo c
      ```

  * 用户交互

    * read命令

      ```shell
      # 
      read -p a
      read -t b
      ```

  * 逻辑判断

    * &&：逻辑与

    * ||：逻辑或

    * [ ]

      **真是0，假是1**

      ```reStructuredText
      -f 检测文件是否存在且是普通文件
      -d 检测目录是否存在
      -e 检测文件是否存在，可以是任何类型文件
      -r 文件对于该用户是否具备可读属性
      -w 是否可写
      -x 是否可执行
      -eq 等于
      -ne 不等于
      -lt 小于
      -gt 大于
      -le 小于等于
      -ge 大于等于
      ```

      ```shell
      test -f ~/.aaa.aaa
      [ -f ~/aaa.aaa ]
      ```

      ```
      == 字符串相同为真
      != 字符串不同为真
      -z $str 长度等于0为真
      -n $str 长度大于0为真，-n可去掉
      -a 左右两条语句都成立时为真
      -o 任意一条语句为真就为真
      !  取反状态
      ```

  * 条件语句：IF,case

    ```shell
    #!/bin/bash
    if [ $# == 0 ]
    then
       echo "请输入参数！"
       exit 1;
    elif [ $# != 1 ] 
    then
       echo "命令参数必须是一个！"
       exit 1;
    else
       echo "进入命令。。。"
    fi
    read -p "请输入数字a：" var1
    read -p "请输入数字b：" var2
    
    case $1 in
       1)
         echo "a + b = " $(($var1+$var2))
         ;;
       2)
         echo "a - b = " $(($var1-$var2))
         ;;
       3)
         echo "a * b = " $(($var1*$var2))
         ;;
       4) 
         echo "a / b = " $(($var1/$var2))
         ;;
       5)
         echo "a % b = " $(($var1%$var2))
         ;;
       *)
         echo "无效参数"
    esac	
    ```

  * 循环:FOR,WHILE,UTIL

    ```shell
    #!/bin/bash
    if [ $# == 0 ] 
    then
    	echo "no params"
    	exit 1;
    fi
    
    sum=0
    for((i=0;i<$1;i++))
    do
    	sum=$(($sum+$i))
    done
    
    echo "final result: $sum"
    ```

    ```shell
    #!/bin/bash
    # for loop
    sum=0
    for i in $1 $2 $3 $4 $5
    	do
    		sum=$(($sum+$i))
    	done
    echo "final result: $sum"
    read -p "Please input start value: " sum
    for i in $*
    	do
    		sum=$(($sum+$i))
    	done
    echo "final result: $sum"
    # while loop
    while [ $sum -gt 0 ]
    	do
    		if [ $sum == 10 ]
    		then
    			echo "break loop"
    			break;
    		fi
    		sum=$(($sum-1))
    		echo "print in loop: $sum"
    	done
    read -p "Reinput start value: " sum
    until [ $sum == 0 ]
    	do
    		#if [ $sum == 10 ]
    		#then
    		#	echo "continue next"
    		#	continue;
    		#fi
    		sum=$(($sum-1))
    		echo "print in loop: $sum"
    	done
    ```

  * 脚本调试

    * ` bash [-nvx] script `

      ```
      -n 不执行脚本，只检查脚本的语法，若没有语法错误，则不会显示任何信息
      -v 执行脚本前，把每行脚本都输出到屏幕
      -x 执行脚本，显示脚本每一行脚本的执行情况。
      ```

  * 函数

### Python

#### 字符串

* 表示

  ```python
  s1 = 'Hello, world'
  s2 = 'hello, \'Adam\''
  s3 = r'Hello, "Bart"'
  s4 = '''Hello, 
  
  Lisa!'''
  ```

* 编码

  ```python
  # python 3字符串以Unicode编码
  # 字符转整数
  ord('A')
  # 整数转字符
  cha(65)
  ```

  *Python字符串在内存中以Unicode表示，保存在磁盘或传输时以字节为单位* 

  ```python
  # bytes类型即字节
  x=b'ABC'
  # 字符串类型
  x='ABC'
  # 字符串编码为bytes
  'ABC'.encode('ascii')
  '中文'.encode('utf-8')
  # 解码
  b'ABC'.decode('ascii')
  b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8')
  ```

  如果`bytes`中包含无法解码的字节，`decode()`方法会报错：

  ```
  >>> b'\xe4\xb8\xad\xff'.decode('utf-8')
  Traceback (most recent call last):
    ...
  UnicodeDecodeError: 'utf-8' codec can't decode byte 0xff in position 3: invalid start byte
  ```

  如果`bytes`中只有一小部分无效的字节，可以传入`errors='ignore'`忽略错误的字节：

  ```python
  >>> b'\xe4\xb8\xad\xff'.decode('utf-8', errors='ignore')
  '中'
  ```

  要计算`str`包含多少个字符，可以用`len()`函数：

  ```python
  len('ABCDEFG')
  len(b'ABC')
  len('中文'.encode('utf-8'))
  ```

* 字符串格式化
  * 占位符
     ```python
     'Hello, %s' % 'world'
     'Hi, %s, you have $%d.' % ('Michael', 1000000)
     ```

     | 占位符 | 替换内容     |
     | ------ | ------------ |
     | %d     | 整数         |
     | %f     | 浮点数       |
     | %s     | 字符串       |
     | %x     | 十六进制整数 |

        ```
     print('%2d-%02d' % (3, 1))
     print('%.2f' % 3.1415926)
        ```

    **转译`%`:`%%`**

  * format()

  ```
  'Hello, {0}, 成绩提升了 {1:.1f}%'.format('小明', 17.125)
  ```

#### 列表（list）

```python
# 定义列表
classmates=['michael', 'Bob', 'Tracy']
# 取列表长度
len(classmates)
# 取最后一个元素
classmates[len(classmates) - 1]
classmates[-1]
# 添加元素
classmates.append('Lisa')
classmates.insert(1, 'Jack')
# 删除元素
classmates.pop()
classmates.pop(1)
# 更新列表
classmates[1] = 'Other Name'
# 存储不同类型
classmates = ['Lisa', 10, "abc", [10, 20]]

```

#### 元组（pule）

*和list很相似，但tuple一旦初始化就不能修改(内部元素是引用类型的话可以修改)* 

```python
# 定义元组（tuple)
classmates = ('Lisa', 'Bob', 'Jack')
```

**tuple的陷阱：当你定义一个tuple时，在定义的时候，tuple的元素就必须被确定下来**

**tuple只有一个元素时要加逗号：**

```python
t=(1,) # 元组
t=(1) # 数字1
```

#### 字典（dict）

```python
# -*- coding: utf-8 -*-
# dict
d = {'a': 10, 'b': 20, 'c': 30}

if 'd' in d:
    print(d['d'])

print(d.get('d', False))

d.pop('a')
d['d'] = ['a', 'b', 'c']
for key in d:
    print(key, ':', d[key])
```

#### 集合（set）

```python
# set
s = set([1,2,3,1])
s1 = {1, 3, 5}
print(s)
s.add(4)
s.remove(1)
print(s)
print(s & s1)
print(s | s1)
print(s - s1)
```

#### 函数

```python
# -*- coding: utf-8 -*-
import math

'''函数定义'''
def my_abs(x):
    if(x >= 0):
        return x
    else:
        return -x
# 函数调用
print(my_abs(-1))
# 空函数
def nop():
    pass

# 参数类型检查
def my_abs_check(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    my_abs(x)
# print(my_abs_check('a'))

# 返回多个值
# 返回的其实是一个元组而已
def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y + step * math.sin(angle)
    return nx, ny
x, y = move(100, 100, 60, math.pi / 6)

def equation(a, b, c=0):
    return 'y = %sx^2 + %sx + %d' % (a, b, c)
print(equation(1, 2, 4))

# 可变参数
def sum(*numbers):
    total = 0
    for num in numbers:
        total += num
    return total
print(sum(1, 2, 3, 4))

# 关键字参数
def person(name, age, **kw):
    for key in kw:
        print('%s: %s' % (key, kw[key]))
    print('name: ', name, '; age: ', age, '; kw: ', kw)

person('hedonghong', 26, home='anhui', company='zhejianghongcheng')
d = {'home': 'anhui', 'company':'zjhcsoft', 'job':'java'}
person('hedonghong', 26, **d)

# 命名关键字参数（限制关键字）
def people(name, age, *, city, job):
    print("name: %s, age: %s, city: %s, job: %s" % (name, age, city, job))
people('hedonghong', 26, city='anhui', job='java')

# 可变参数+关键字命名参数
def people(name, age, *args, city, job):
    print(name, age, args, city, job)

def fact(n):
    if n == 1:
        return 1
    return n * fact(n - 1)
print(fact(5))

# 尾递归
def fact1(n):
    fact_iter(n, 1)

def fact_iter(n, product):
    if n == 1:
        return product
    else:
        return fact_iter(n - 1, n * product)
        
# print(fact1(1000))
```

#### 切片

```python
L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']
# 取前n个元素
L[0:3]
L[:3]
# 取后n个元素
L[-2:0]
L[-2:]
# 前n个数，每两个取一个
L[0:10:2]
L[:10:2]
# 所有数，每5个取一个
L[::5]
# 复制原list
L[:]
```

#### 迭代

* for...in

  ```python
  l = [1, 2, 3, 4]
  for i in l:
  	print i
  ```

* enumerate

  ```python
  for i, value in enumerate([1, 2, 3, 4]):
  	print(i, value)
  ```

```python
def max(*numbers):
    max = numbers[0]
    for num in numbers:
        if max < num:
            max = num
    return max

def min(*numbers):
    min = numbers[0]
    index = 0
    for i, value in enumerate(numbers):
        if min > value:
            min = value
            index = i
    return min, index

arr = [1, 2, 4, 5, 0, 100, 66]
print(max(*arr))
print(min(*arr))
```

#### 列表生成式

```python
# -*- coding: utf-8 -*-
L1 = ['Hello', 'World', 18, 'Apple', None]

L2 = [item for item in L1 if isinstance(item, str)]
print(L2)

d = {'a': 1, 'b': 2, 'c': 3}
l = ['%s/%d' % (k, v) for k, v in d.items()]

print(l)

```

#### 生成器（generator）

```python
# 利用列表生成式定义生成器
g = (x*x for x in range(10))
next(g)
for x in g:
    print(x)
# 利用函数定义生成器
def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b, n = b, a + b, n + 1
    return 'done'
g1 = fib(10)
for x in g1:
    print(x)
```

#### 迭代器

*可以被`next()`函数调用并不断返回下一个值的对象称为迭代器：`Iterator`*

*可以直接作用于`for`循环的对象统称为可迭代对象：`Iterable`*

*用`iter()`将`Iterable`转为`Iterator`*

**为什么`list`、`dict`、`str`等数据类型不是`Iterator`？**

*因为Python的`Iterator`对象表示的是一个数据流，Iterator对象可以被`next()`函数调用并不断返回下一个数据，直到没有数据时抛出`StopIteration`错误。可以把这个数据流看做是一个有序序列，但我们却不能提前知道序列的长度，只能不断通过`next()`函数实现按需计算下一个数据，所以`Iterator`的计算是惰性的，只有在需要返回下一个数据时它才会计算。`Iterator`甚至可以表示一个无限大的数据流，例如全体自然数。而使用list是永远不可能存储全体自然数的* 

#### 函数式编程

        函数是Python内建支持的一种封装，我们通过把大段代码拆成函数，通过一层一层的函数调用，就可以把复杂任务分解成简单的任务，这种分解可以称之为面向过程的程序设计。函数就是面向过程的程序设计的基本单元。
    
    而函数式编程（请注意多了一个“式”字）——Functional Programming，虽然也可以归结到面向过程的程序设计，但其思想更接近数学计算。
    
    我们首先要搞明白计算机（Computer）和计算（Compute）的概念。
    
    在计算机的层次上，CPU执行的是加减乘除的指令代码，以及各种条件判断和跳转指令，所以，汇编语言是最贴近计算机的语言。
    
    而计算则指数学意义上的计算，越是抽象的计算，离计算机硬件越远。
    
    对应到编程语言，就是越低级的语言，越贴近计算机，抽象程度低，执行效率高，比如C语言；越高级的语言，越贴近计算，抽象程度高，执行效率低，比如Lisp语言。
    
    函数式编程就是一种抽象程度很高的编程范式，纯粹的函数式编程语言编写的函数没有变量，因此，任意一个函数，只要输入是确定的，输出就是确定的，这种纯函数我们称之为没有副作用。而允许使用变量的程序设计语言，由于函数内部的变量状态不确定，同样的输入，可能得到不同的输出，因此，这种函数是有副作用的。
    
    函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数！
    
    Python对函数式编程提供部分支持。由于Python允许使用变量，因此，Python不是纯函数式编程语言。

#### map/reduce

* map

  作用于序列的每一个元素

* reduce

  作用于整个序列（如求和操作）

```python
from functools import reduce

def f(x):
return x * x


def add(x, y):
return x + y


r = map(f, list(range(10)))
print(reduce(add, list(r)))

def normalize(name):
    return '%s%s' % (name[:1].upper(), name[1:].lower())
L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print(L2)

def prod(*numbers):
    def multi(x, y):
        return x * y
    print(reduce(multi, numbers))
prod(*[x for x in list(range(10)) if x != 0])


```

#### filter

#### sorted

```python
L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]

def by_name(a):
    return a[0]

print(sorted(L, key=lambda x: x[1], reverse=True))
```

#### 返回函数

* 闭包

  *返回闭包时牢记一点：返回函数不要引用任何循环变量，或者后续会发生变化的变量* 

#### 匿名函数（lambda）

#### 装饰器

```python
'''
Created on 2018年9月19日

@author: hedonghong
'''
import functools

def metric(param):
    def decorator(fn):
        @functools.wraps(fn)
        def wrapper(*args, **kw):
            print('begin %s function %s' % (param, fn.__name__))
            return fn(*args, **kw)
            print('end %s function %s' % (param, fn.__name__))
        return wrapper
    return decorator

@metric('execute')
def my_abs(x):
    if x >= 0:
        return x
    else:
        return -x
        
print(my_abs(-1))
```

*像java的动态代理，**但有返回值的函数如何增强执行后的日志记录操作？***

#### 偏函数

把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单。

```python
import functools
int2 = functools.partial(int, base=2)
int2('10000')
int2('11111', 8)
```

#### 面向对象

```python
class Student(object):
    count = 0
    def __init__(self, name):
        # 用self调用貌似不共享
        Student.count += 1
        self.__name = name

    def get_name(self):
        return self.__name
    
    def set_name(self, name):
        self.__name = name

# 测试:
if Student.count != 0:
    print('测试失败!')
else:
    bart = Student('Bart')
    if Student.count != 1:
        print('测试失败!')
    else:
        lisa = Student('Bart')
        if Student.count != 2:
            print('测试失败!')
        else:
            print('Students:', Student.count)
            print('测试通过!')
```

#### `__slots__`

限制对类实例的属性的随意添加

#### @property

```python
class Screen(object):

    @property
    def width(self):
        return self.__width

    @width.setter
    def width(self, width):
        self.__width = width

    @property
    def height(self):
        return self.__width

    @height.setter
    def height(self, height):
        self.__height = height

    @property
    def resolution(self):
        return self.__width * self.__height

# 测试:
s = Screen()
s.width = 1024
s.height = 768
print('resolution =', s.resolution)
if s.resolution == 786432:
    print('测试通过!')
else:
    print('测试失败!')
```



#### 多重继承

```python
class Animal(object):
    pass

# 大类:
class Mammal(Animal):
    pass

class Bird(Animal):
    pass

class Runnable(object):
    def run(self):
        print('Running...')

class Flyable(object):
    def fly(self):
        print('Flying...')
        
class Dog(Mammal, Runnable):
    pass
```

#### 定制类

* `__str__`
* `__slots__`
* `__iter__`&`__next__`
* `__getitem___`
* `__getattr__`
* `__call__`

```python
class Screen(object):

    # 限制属性，防止运行时随意增加属性
    __slots__ = ('_width', '_height', '_resolution')

    # 构造器
    def __init__(self, width=0, height=0):
        self._width = width
        self._height = height
        self._resolution = width * height
    
    @property
    def width(self):
        return self._width

    @width.setter
    def width(self, width):
        self._width = width

    @property
    def height(self):
        return self._width

    @height.setter
    def height(self, height):
        self._height = height

    @property
    def resolution(self):
        return self._width * self._height

    def __str__(self):
        return '%s;%s;%s' % (self._width, self._height, self._resolution)

    # 返回一个可迭代的对象
    def __iter__(self):
        return self

    def __next__(self):
        pass
    
    def __getitem___(self):
        pass
	# 当获取不存在的属性有避免程序抛异常
    def __getattr__(self, attr):
        if not attr in self.__slots__:
            return 'has no this attr'
    # 实例可自身调用
    def __call__(self):
        print(str(self))

# 测试:
s = Screen(1024, 768)
print('resolution =', s.resolution)
print(s.name)
print(s.width)
s()
if s.resolution == 786432:
    print(str(s))
    print('测试通过!')
else:
    print('测试失败!')
```

#### 枚举

```python
from enum import Enum, unique

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))

a = Month.Jan
print(a.value)

for name, member in Month.__members__.items():
    print('%s=>%s,%s' % (name, member, member.value))

# 自定义Enum派生类
@unique
class Weekday(Enum):
    Sun = 0
    Mon = 1
    Tue = 2
    Wen = 3
    Thu = 4
    Fri = 5
    Sat = 6

@unique
class Gender(Enum):
    Male = 0
    Female = 1
    Other = 2

class Student(object):
    __slots__=('_name', '_gender')
    def __init__(self, name, gender):
        self._name = name
        self._gender = gender
    
    @property
    def gender(self):
        return self._gender
    @gender.setter
    def gender(self, value):
        self._gender = value

# 测试:
bart = Student('Bart', Gender.Male)
if bart.gender == Gender.Male:
    print('测试通过!')
else:
    print('测试失败!')
```

#### 元类

```python
def fn(self, name='world'):
    print('Hello, %s.' % name)
Hello = type('Hello', (object,), dict(hello=fn))

h = Hello()
h.hello()

class ListMetaclass(type):
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)

class MyList(list, metaclass=ListMetaclass):
    pass

L = MyList()
L.add(1)
print(L)
```

#### 错误、调试和测试

* try

  ```python
  try:
      print('try...')
      r = 10 / int('a')
      print('result:', r)
  except ValueError as e:
      print('ValueError:', e)
  except ZeroDivisionError as e:
      print('ZeroDivisionError:', e)
  finally:
      print('finally...')
  else:
      print('no error!')
  print('END')
  ```

* demo

  ```python
  # -*- coding: utf-8 -*-
  from functools import reduce
  
  # def str2num(s):
  #     try:
  #         return int(s)
  #     except ValueError as e:
  #         return float(s)
  #     finally:
  #         pass
  def str2num(s):
      if isinstance(s, int):
          return int(s)
      else:
          return float(s)
          
  def calc(exp):
      ss = exp.split('+')
      ns = map(str2num, ss)
      return reduce(lambda acc, x: acc + x, ns)
  
  def main():
      r = calc('100 + 200 + 345')
      print('100 + 200 + 345 =', r)
      r = calc('99 + 88 + 7.6')
      print('99 + 88 + 7.6 =', r)
  
  main()
  ```
* 断言
  ```python
  def foo(s):
    n = int(s)
    assert n != 0, 'n is zero!'
    return 10 / n
  
  def main():
    foo('0')
  ```

* logging

  ```python
  import logging
  
  s = '0'
  n = int(s)
  logging.info('n = %d' % n)
  print(10 / n)
  ```

#### IO

```python
from io import StringIO
from io import BytesIO

file_content = ''
with open('./demo.txt', 'r', 1024, 'utf-8') as file:
    lines = file.readlines()
    for line in lines:
        file_content += line

with open('./demo.txt', 'w', 1024, 'utf-8') as file:
    file_content += "\nI'm hedonghong, I'm a new guy"
    file.write(file_content)

# 后续写入会覆盖初始化时放入的内容，但多次写入不会覆盖
f = StringIO('abcdefghijklmn')
f.write('abcdefghijklmn')
f.write('opqrst')
f.write('uvwxyz')
print(f.getvalue())

while True:
    s = f.readline()
    if s == '':
        break
    print(s.strip())

b = BytesIO()
b.write('中文'.encode('utf-8'))
print(b.getvalue().decode('utf-8'))
```