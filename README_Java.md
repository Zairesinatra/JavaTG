# README

------

## Java初识：

### JavaSE下载与安装：

- 登陆 [oracle](https://www.oracle.com) 官网安装 JavaSE（Java Standard Edition Dev kit）
- MacOS 中 Java 目录

```zsh
# version:
zsxzy@zairesinatras-MBP ~ % java --version
java 11.0.11 2021-04-20 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.11+9-LTS-194)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.11+9-LTS-194, mixed mode)
```

```zsh
# default JDK path:
/Library/Java/JavaVirtualMachines/jdk-11.0.11.jdk/Contents/Home
```

|  目录   |             说明             |
| :-----: | :--------------------------: |
|   bin   | JDK工具命令、Javac与Java目录 |
|  conf   |       JDK相关配置文件        |
| include |        平台特定头文件        |
|  jmods  |         JDK各类模块          |
|  legal  |           授权文档           |
|   lib   |     JDK工具中的补充JAR包     |

```zsh
# Java
JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-11.0.11.jdk/Contents/Home"
CLASS_HOME="$JAVA_HOME/lib"
PATH=".$PATH:$JAVA_HOME/bin"
export JAVA_HOME
export CLASSPATH
export PATH
```

```zsh
zsxzy@zairesinatras-MBP ~ % echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk-11.0.11.jdk/Contents/Home
```

- `HelloWorld.java`

```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("HelloWorld");
	}
}
```

```zsh
$ javac HelloWorld.java
$ java HelloWorld
HelloWorld
```

- 文本编辑器

```zsh
# 查看预装 vim 版本
$ vim --version
VIM - Vi IMproved 8.2 (2019 Dec 12)
macOS version
# 查看预装 vim 路径
$ where vim
/usr/bin/vim
```

一般情况下，Mac OS X 自带的 vim 是不能满足需求的，所以选择 [HomeBrew](https://formulae.brew.sh/formula/neovim#default) 安装 [NeoVim](https://neovim.io/)，详情见本项目 README_VIM.md

```zsh
$ brew install neovim
$ nvim # NVIM v0.4.4
```

```zsh
# brew cask 下载目录
cd /usr/local/Caskroom && ls
# brew 下载目录
cd /usr/local/Cellar && ls
```

------

## 语法：

单行注释多行注释与 JavaScript 相同。文档注释： `/**注释信息*/`

关键字：关键字字母全小写且有特殊颜色标记

### 类型转换：

- 隐式转换：取值范围小的数据给取值范围大的类型赋值，可以直接赋值，且系统自动转换。

```java
int a = 10; // int 4 字节
double b = a; // double 8 字节
```

```java
byte => short => int => long => float(即便四个字节,取值范围) => double
				char =>
// 整型
// byte => 1个字节 8位 -128~127
// short => 2个字节 16位
// int => 4个字节 32位
// long => 8个字节 64位
// 浮点型
// float => 4字节 32位
// double => 8字节 64位
```

- 特殊细节：byte 、 short 、 char 三种数据在运算时不论更高数据类型，都会提升为 int 再进行运算

```java
byte z = 6;
byte s = 6;
int zy = z + s;
System.out.println(zy); // 12 (int)
```

- 强制转换：把一个表示数据范围大的数值或者变量赋值给另一个表示数据范围小的变量

```java
格式：目标数据类型 变量名 = （目标数据类型）值或者变量;
```

```java
double num = 6.6;
int numm = (int)num;
System.out.println(numm); // 6 => 直接暴力砍掉小数点后的数值
```

- 转换示例：

```java
public class Test {
	public static void main(String[] args){
		byte a = 3;
		byte b = 4;
		byte c = a + b; // a + b 后会变成默认整型 => (byte)(a+b)
		byte d = 3 + 4; // 常量优化机制
    long f = 1234567898776L // 需要加上L变成long类型
	}
}
```

### 常量：

**定义：**在程序运行过程中，其值不可以发生改变的量：

**分类**（**除空常量外，其他常量均可使用输出语句直接输出**）：

- 字符串常量  用双引号括起来的多个字符（可以包含0个、一个或多个），例如"a"、"zs"、"中国"等


- 整数常量  整数，例如：-10、0、88等


- 小数常量  小数，例如：-5.5、1.0、88.88等


- 字符常量  用单引号括起来的一个字符，例如：'a'、'5'、'B'、'中'等


- 布尔常量  布尔值，表示真假，只有两个值true和false


- 空常量  一个特殊的值，空值，值为null

**注意：**单引号内只能放一个字符：'10'❌、'ab'❌

### 变量：

**定义：**变量就是内存中的存储空间，空间中存储着经常发生改变的数据。本质上，变量是内存中的一块区域，其值可以在范围内变化。

```java
数据类型 变量名 = 数据值
```

#### 存储单元

无论是内存还是硬盘，计算机存储设备的**最小信息单元**叫 **位（bit）**，又称之为 **比特位** ，通常用小写的字母 **b** 表示。而计算机中**最基本的存储单元**叫 **字节（byte）**，通常用大写字母 **B** 表示，**字节是由连续的8个位组成**。

除了字节外还有一些常用的存储单位，其换算单位如下：

1B（字节） = 8bit	1KB = 1024B	1MB = 1024KB	1GB = 1024MB	1TB = 1024GB

#### 数据类型

Java是一个**强类型语言**，数据必须明确数据类型。在Java中的数据类型包括基本数据类型和引用数据类型两种。

Java中的基本数据类型：

| 数据类型 | 关键字       | 内存占用 | 取值范围                     |
| :------- | ------------ | -------- | :--------------------------- |
| 整数     | byte         | 1（8位） | -2^8~2^8-1（-128~127）       |
|          | short        | 2        | -2^15~2^15-1（-32768~32767） |
|          | int(默认)    | 4        | **-2^31~2^31-1**             |
|          | long         | 8        | -2^63~2^63-1                 |
| 浮点     | float        | 4        | 1.401298E-45到3.402823E+38   |
|          | double(默认) | 8        | 4.9000000E-324~1.797693E+308 |
| 字符     | char         | 2        | 0-65535                      |
| 布尔     | boolean      | 1        | true、false                  |

说明：

- e+38 表示是乘以10的38次方，同样，e-45表示乘以10的负45次方。
- 在 Java 中整数默认是 int 类型，浮点数默认是 double 类型。

#### 变量注意事项（理解）

1. 在同一对花括号中，变量名不能重复。
2. 变量在使用之前，必须初始化（赋值）。
3. 定义long类型的变量时，需要在整数的后面加L（大小写均可，建议大写）。因为整数默认是int类型，整数太大可能超出int范围。
4. 定义float类型的变量时，需要在小数的后面加F（大小写均可，建议大写）。因为浮点数的默认类型是double， double的取值范围是大于float的，类型不兼容。

#### 键盘录入（理解）

可以通过 Scanner 类来获取用户的输入。使用步骤如下：

```java
// 导包
import java.util.Scanner;
public class keyboardEntry {
		public static void main(String args[]) {
				// 创建对象
				Scanner sc = new Scanner(System.in);
				// 变量记录录入的数值
				int i = sc.nextInt();
				System.out.println(i);
		}
}
```

#### 标识符（理解）

**定义：**标识符是用户编程时使用的名字，用于给类、方法、变量、常量等命名。

**组成规则：**

- 由字母、数字、下划线“_”、美元符号“$”组成，第一个字符不能是数字。


- 不能使用java中的关键字作为标识符。


- 标识符对大小写敏感（区分大小写）。


**命名约定：**

- 小驼峰式命名：变量名、方法名——首字母小写，从第二个单词开始每个单词的首字母大写。
- 大驼峰式命名：类名——每个单词的首字母都大写。

### 运算符

#### 运算符和表达式（了解）

运算符：对常量或者变量进行操作的符号

表达式：用运算符把常量或者变量连接起来符合语法的式称为表达式。 不同运算符连接的表达式体现的是不同类型的表达式。

#### 算术运算符

~~~java
// 整数操作只能得到整数，要想得到小数，必须有浮点数参与运算
int a = 10;
int b = 3;
System.out.println(a / b); // 输出结果3 => /取结果的商
System.out.println(a % b); // 输出结果1 => %取结果的余数
~~~

#### 字符的 + 操作（理解）

ASCII是计算机 **字节** 到 **字符** 的一套对应关系。

char类型参与算术运算，使用的是计算机底层对应的十进制数值。需要记住三个字符对应的数值：

'a'  --  97		a-z是连续的，所以'b'对应的数值是98，'c'是99，依次递加

'A'  --  65		A-Z是连续的，所以'B'对应的数值是66，'C'是67，依次递加

'0'  --  48		0-9是连续的，所以'1'对应的数值是49，'2'是50，依次递加

~~~java
// 可以通过使用字符与整数做算术运算，得出字符对应的数值是多少
char ch1 = 'a';
System.out.println(ch1 + 1); // 输出98，97 + 1 = 98

char ch2 = 'A';
System.out.println(ch2 + 1); // 输出66，65 + 1 = 66

char ch3 = '0';
System.out.println(ch3 + 1); // 输出49，48 + 1 = 49
~~~

算术表达式中包含不同的基本数据类型的值的时候，整个算术表达式的类型会自动进行提升。

**提升规则：**

- byte、short、char类型将被提升到int类型，不管是否有其他类型参与运算。
- 整个表达式的类型自动提升到与表达式中最高等级的操作数相同的类型
- 等级顺序：byte\short\char --> int --> long --> float --> double

~~~java
byte b1 = 10;
byte b2 = 20;
// byte b3 = b1 + b2; // 该行报错，因为byte类型参与算术运算会自动提示为int，int赋值给byte可能损失精度
int i3 = b1 + b2; // 应该使用int接收
byte b3 = (byte) (b1 + b2); // 或者将结果强制转换为byte类型
-------------------------------
int num1 = 10;
double num2 = 20.0;
double num3 = num1 + num2; // 使用double接收，因为num1会自动提升为double类型
~~~

#### 字符串的“+”操作（理解）

当 + 操作中出现字符串时，表示操作连接符，而不是算术运算：

~~~java
System.out.println("zs"+ 666); // 输出：zs666
~~~

在 + 操作中，如果出现了字符串，就是连接运算符，否则就是算术运算。当连续进行 + 操作时，从左到右逐个执行。

~~~java
System.out.println(1 + 99 + "TEXAS");            // 输出：100TEXAS
System.out.println(1 + 2 + "TEXAS" + 3 + 4);   // 输出：3TEXAS34
// 可以使用小括号改变运算的优先级 
System.out.println(1 + 2 + "TEXAS" + (3 + 4)); // 输出：3TEXAS7
~~~

#### 数值拆分demo

**需求：**键盘录入一个三位数，将其拆分为个位，十位，百位，打印在控制台

```java
import java.util.Scanner;
public class NumericalSplit {
	public static void main(String[] args) {
		// 使用Scanner键盘录入一个三位数
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个三位数");
		int num = sc.nextInt();
		// 个位的计算：数值 % 10
		int ge = num % 10;		
		// 十位的计算：数值 / 10 % 10
		int shi = num / 10 % 10;	
		// 百位的计算：数值 / 100
		int bai = num / 100;
		// 将个位, 十位, 百位拼接上正确的字符串, 打印即可
		System.out.println("整数"+num+"个位为:" + ge);
		System.out.println("整数"+num+"十位为:" + shi);
		System.out.println("整数"+num+"百位为:" + bai);
	}
}
```

#### 自增自减运算符（理解）

| 符号 | 作用 | 说明        |
| ---- | ---- | ----------- |
| ++   | 自增 | 变量的值加1 |
| --   | 自减 | 变量的值减1 |

**注意事项：**

- ++和-- 既可以放在变量的后边，也可以放在变量的前边。
- 单独使用的时候， ++和-- 无论前后，结果一样。
- 参与操作时放在变量的后边，先拿变量参与操作，后拿变量做++或者--。
- 参与操作时放在变量的前边，先拿变量做++或者--，后拿变量参与操作。

```java
int i = 10;
i++; // 单独使用
System.out.println("i:" + i); // i:11

int j = 10;
++j; // 单独使用
System.out.println("j:" + j); // j:11

int x = 10;
int y = x++; // 赋值运算，++在后边，所以是使用x原来的值赋值给y，x本身自增1
System.out.println("x:" + x + ", y:" + y); // x:11，y:10

int m = 10;
int n = ++m; // 赋值运算，++在前边，所以是使用m自增后的值赋值给n，m本身自增1
System.out.println("m:" + m + ", m:" + m); // m:11，m:11
```

练习：

```java
int x = 10;
int y = x++ + x++ + x++;
System.out.println(y); // y的值是多少？
/*
解析:三个表达式都是++在后,所以每次使用的都是自增前的值,但程序自左至右执行,所以第一次自增时,使用的是10进行计算,但第二次自增时,x的值已经自增到11了,所以第二次使用的是11,然后再次自增,所以整个式子应该是：int y = 10 + 11 + 12;	输出结果为33。
*/
```

#### 赋值运算符（应用）

赋值运算符的作用是将一个表达式的值赋给左边，左边必须是可修改的，不能是常量。

| 符号 | 作用       | 说明                  |
| ---- | ---------- | --------------------- |
| =    | 赋值       | a=10，将10赋值给变量a |
| +=   | 加后赋值   | a+=b，将a+b的值给a    |
| -=   | 减后赋值   | a-=b，将a-b的值给a    |
| *=   | 乘后赋值   | a*=b，将a×b的值给a    |
| /=   | 除后赋值   | a/=b，将a÷b的商给a    |
| %=   | 取余后赋值 | a%=b，将a÷b的余数给a  |

**注意：**赋值运算符隐含了强制类型转换。

~~~java
short s = 10;
s = s + 10; // 此行代码报错,因为运算中s提升为int类型,运算结果int赋值给short可能损失精度
s += 10; // 此行代码没有问题，隐含了强制类型转换，相当于 s = (short) (s + 10);
~~~

#### 关系运算符（应用）

| 符号 | 说明                                                    |
| ---- | ------------------------------------------------------- |
| ==   | a==b，判断a和b的值是否相等，成立为true，不成立为false   |
| !=   | a!=b，判断a和b的值是否不相等，成立为true，不成立为false |
| >    | a>b，判断a是否大于b，成立为true，不成立为false          |
| >=   | a>=b，判断a是否大于等于b，成立为true，不成立为false     |
| <    | a<b，判断a是否小于b，成立为true，不成立为false          |
| <=   | a<=b，判断a是否小于等于b，成立为true，不成立为false     |

注意事项：

- 关系运算符的结果都是boolean类型，要么是true，要么是false。
- 不要把` == 误写成 =, == `是判断是否相等的关系， = 是赋值。

~~~java
int a = 10;
int b = 20;
// 关系运算的结果肯定是boolean类型，所以也可以将运算结果赋值给boolean类型的变量
boolean flag = a > b;
System.out.println(flag); // 输出false
~~~

#### 逻辑运算符（应用）

逻辑运算符把各个运算的关系表达式连接起来组成一个复杂的逻辑表达式，以判断程序中的表达式是否成立，判断的结果是 true 或 false。

| 符号 | 作用     | 说明                                         |
| ---- | -------- | -------------------------------------------- |
| &    | 逻辑与   | a&b，a和b都是true，结果为true，否则为false   |
| \|   | 逻辑或   | a\|b，a和b都是false，结果为false，否则为true |
| ^    | 逻辑异或 | a^b，a和b结果不同为true，相同为false         |
| !    | 逻辑非   | !a，结果和a的结果正好相反                    |

~~~java
//定义变量
int i = 10;
int j = 20;
int k = 30;

//& “与”，并且的关系，只要表达式中有一个值为false，结果即为false
System.out.println((i > j) & (i > k)); //false & false,输出false
System.out.println((i < j) & (i > k)); //true & false,输出false
System.out.println((i > j) & (i < k)); //false & true,输出false
System.out.println((i < j) & (i < k)); //true & true,输出true
System.out.println("--------");

//| “或”，或者的关系，只要表达式中有一个值为true，结果即为true
System.out.println((i > j) | (i > k)); //false | false,输出false
System.out.println((i < j) | (i > k)); //true | false,输出true
System.out.println((i > j) | (i < k)); //false | true,输出true
System.out.println((i < j) | (i < k)); //true | true,输出true
System.out.println("--------");

//^ “异或”，相同为false，不同为true
System.out.println((i > j) ^ (i > k)); //false ^ false,输出false
System.out.println((i < j) ^ (i > k)); //true ^ false,输出true
System.out.println((i > j) ^ (i < k)); //false ^ true,输出true
System.out.println((i < j) ^ (i < k)); //true ^ true,输出false
System.out.println("--------");

//! “非”，取反
System.out.println((i > j)); //false
System.out.println(!(i > j)); //!false，,输出true
~~~

#### 短路逻辑运算符（理解）

| 符号 | 作用   | 说明                         |
| ---- | ------ | ---------------------------- |
| &&   | 短路与 | 作用和&相同，但是有短路效果  |
| \|\| | 短路或 | 作用和\|相同，但是有短路效果 |

在逻辑与运算中，只要有一个表达式的值为false，那么结果就可以判定为false了，没有必要将所有表达式的值都计算出来，短路与操作就有这样的效果，可以提高效率。同理在逻辑或运算中，一旦发现值为true，右边的表达式将不再参与运算。

- 逻辑与&，无论左边真假，右边都要执行。

- 短路与&&，如果左边为真，右边执行；如果左边为假，右边不执行。

- 逻辑或|，无论左边真假，右边都要执行。

- 短路或||，如果左边为假，右边执行；如果左边为真，右边不执行。

~~~java
int x = 3;
int y = 4;
System.out.println((x++ > 4) & (y++ > 5)); // 两个表达都会运算 false
System.out.println(x); // 4
System.out.println(y); // 5
// ---
System.out.println((x++ > 4) && (y++ > 5)); // 左边已经可以确定结果为false，右边不参与运算
System.out.println(x); // 4
System.out.println(y); // 4
~~~

#### 三元运算符（理解）

~~~java
关系表达式 ? 表达式1 : 表达式2;
~~~

解释：问号前面的位置是判断的条件，判断结果为boolean型，为true时调用表达式1，为false时调用表达式2。其逻辑为：如果条件表达式成立或者满足则执行表达式1，否则执行第二个。

举例：

~~~java
int a = 10;
int b = 20;
int c = a > b ? a : b; // 判断 a>b 是否为真，如果为真取a的值，如果为假，取b的值
~~~

#### 三元运算符demo

**需求：**一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm，请用程序实现获取这三个和尚的最高身高。

~~~java
public class OperatorTest {
	public static void main(String[] args) {
		//1：定义三个变量用于保存和尚的身高，单位为cm，这里仅仅体现数值即可。
		int height1 = 150;
		int height2 = 210;
		int height3 = 165;	
		//2：用三元运算符获取前两个和尚的较高身高值，并用临时身高变量保存起来。
		int tempHeight = height1 > height2 ? height1 : height2;		
		//3：用三元运算符获取临时身高值和第三个和尚身高较高值，并用最大身高变量保存。
		int maxHeight = tempHeight > height3 ? tempHeight : height3;	
		//4：输出结果
		System.out.println("maxHeight:" + maxHeight);
	}
}
~~~

### 流程控制语句

...太简单，略过一些，提几点有意思的：

- 循环demo-水仙花数：

```java
public class Daffodil {
    public static void main(String[] args) {
		// 输出所有的水仙花数必然要使用到循环,遍历所有的三位数,三位数从100开始,到999结束
		for(int i=100; i<1000; i++) {
			// 在计算之前获取三位数中每个位上的值
			int ge = i%10;
			int shi = i/10%10;
			int bai = i/10/10%10;
			
			// 判定条件是将三位数中的每个数值取出来,计算立方和后与原始数字比较是否相等
			if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
				// 输出满足条件的数字就是水仙花数
				System.out.println(i);
			}
		}
    }
}
```

!**注意：**`System.out.print(打印内容);——打印后不换行	System.out.println(打印内容);——打印后换行`

