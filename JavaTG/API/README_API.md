# API

------

- API (Application Programming Interface) ：应用程序编程接口
- Java 中的 API： JDK 中提供的各种功能的 Java类，这些类将底层的实现封装了起来，不需要关心这些类是如何实现的，只需要学习这些类如何使用即可，可以通过帮助文档来学习这些API如何使用。

外话：按照ANSI编码标准，标点符号、数字、大小写字母都占一个字节，汉字占2个字节。按照UNICODE标准所有字符都占2个字节。

## Scanner类

​	`next()` : 遇到了空格, 就不再录入数据了，结束标记：空格，tab键

​	`nextLine()`：可以将数据完整的接收过来，结束标记：回车换行符       

```java
import java.util.Scanner;
public class DemoScanner {
    /*
        next(): 遇到了空格,就不再录入数据了	结束标记: 空格,tab键
        nextLine(): 数据完整的接收过来	结束标记: 回车换行符
    */
    public static void main(String[] args) {
        // 1. 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        // 2. 调用nextLine方法接收字符串
        String s = sc.nextLine();
        System.out.println(s);
    }
}
```

```java
import java.util.Scanner;
public class DemoScanner {
    /*
        nextInt和nextLine方法配合使用的时候, nextLine方法就没有键盘录入的机会
        建议: 今后键盘录入数据的时候, 如果是字符串和整数一起接受, 建议使用next方法接受字符串.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数:");
        int num = sc.nextInt(); // 10 + 回车换行
        System.out.println("请输入字符串:");
        String s = sc.nextLine();
        System.out.println(num);
        System.out.println(s);
    }
}
```

## String类

String 类在 java.lang 包下，所以使用的时候不需要导包。String 类代表字符串，Java 程序中的所有字符串文字都被实现为此类的实例也就是说，Java 程序中所有的双引号字符串，都是 String 类的对象。

字符串不可变，它们的值在创建后不能被更改。虽然值不可改变，但是可以被共享。字符串效果上相当于字符数组（`char[]`），底层原理是字节数组（`byte[]`）。

### String类的构造方法

常用的构造方法（常见获取字符串方式）

| 方法名                      | 说明                                 |
| --------------------------- | ------------------------------------ |
| `public String()`           | 不包含内容的空白字符串               |
| `public String(char[] chs)` | 根据字符数组内容创建字符串对象       |
| `public String(byte[] bys)` | 根据字节数组内容创建字符串对象       |
| `String s = "zs";`          | 直接赋值方式创建字符串对象，内容"zs" |

```java
public class StringCreate {
		public static void main (String[] args) {
				// 通过 new 创建的字符串对象,每一次 new 都会申请一个内存空间,虽然内容相同,但是地址值不同
				// 不带参数
				String s1 = new String();
				System.out.println("s1:" + s1); // s1:
				// 根据字符数组创建
				char[] chs = {'z','s'};
				String s2 = new String(chs);
				System.out.println("s2:" + s2); // s2:zs
				// 字节数组创建
				// byte[] bys = {1, 2, 3, "x"}; 不能从字符串转byte
				byte[] bys = {97, 65, 30}; // A a 0 的ASCII码
				String s3 = new String(bys);
				System.out.println("s3:" + s3); // A a 0
				// 不使用构造方法-直接赋值
				// 赋值给出的字符串,只要字符序列相同(顺序和大小写),无论在程序代码中出现几次,JVM 都只会建立一个 String 对象,并在字符串池中维护
				String s4 = "zairesinatra";
				System.out.println(s4); // zairesinatra
		}
}
```

### 创建字符串对象的区别对比

- **通过构造方法创建**

  通过 new 创建的字符串对象，每一次 new 都会申请一个内存空间，虽然内容相同，但是地址值不同。

- **直接赋值方式创建**

  赋值给出的字符串，只要字符序列相同(顺序和大小写)，无论在程序代码中出现几次，JVM 都只会建立一个 String 对象，并在字符串池中维护（共享是常量池的特点）。

### 字符串的比较 

- == 比较基本数据类型：比较的是具体的值
- == 比较引用数据类型：比较的是对象地址值

在 Java 中字符串是对象，如果比较内容相同（区分大小）采用 `equals()` 方法。

```java
System.out.println(s1.equals(s2)); // true or false
```

### 用户登录demo

```java
package login;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // 1. 已知用户名和密码,定义两个字符串表示即可
        String username = "zszszs";
        String password = "123456";
        // 2. 键盘录入要登录的用户名和密码,用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        // 4. 用循环实现多次机会,这里的次数明确,采用for循环实现
        for(int i = 1; i <= 3; i++){
            System.out.println("请输入用户名:");
            String scUsername = sc.nextLine();
            System.out.println("请输入密码:");
            String scPassword = sc.nextLine();
            // 3. 拿键盘录入的用户名、密码和已知的用户名、密码进行比较,给出相应的提示
            if(username.equals(scUsername) && password.equals(scPassword)){
                System.out.println("登录成功");
                break;
            }else{
                if(i == 3){
                    System.out.println("您的登录次数已达到今日上限, 请明天再来");
                }else{
                    System.out.println("登录失败,您还剩余" + (3-i) +"次机会");
                }
            }
        }
        sc.close();
    }
}
```

### 遍历字符串demo

```java
import java.util.Scanner;

public class StringIter {
    public static void main(String[] args) {
        //  1. 录入字符串用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 遍历字符串首先要能够获取到字符串中的每一个字符
        for(int i = 0; i < s.length(); i++){
            // i : 字符串的每一个索引
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
}
```

```java
import java.util.Scanner;

public class JudgeStr {
    public static void main(String[] args) {
        //  1. 键盘录入字符串用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 将字符串拆分为字符数组
        char[] chars = s.toCharArray();
        // 3. 遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
```

### 统计字符次数demo

```java
package countStr;
import java.util.Scanner;
public class CountStr {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String line = sc.nextLine();
		int UpperCase = 0, LowCase = 0, Num = 0;
		for(int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				UpperCase++;
			} else if (ch >= 'a' && ch <= 'z') {
				LowCase++;
			} else {
				Num++;
			}
		}
		sc.close();
		System.out.println("大写字母:" + UpperCase);
		System.out.println("小写字母:" + LowCase);
		System.out.println("数字:" + Num);
	}
}
```

### 手机号屏蔽-字符串截取

```java
import java.util.Scanner;
public class Phone {
    public static void main(String[] args) {
        // 1. 键盘录入字符串用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号:");
        String telString = sc.nextLine();
        // 2. 截取字符串前三位
        String start = telString.substring(0,3);
        // 3. 截取字符串后四位
        String end = telString.substring(7);
        // 4. 将截取后的两个字符串中间加上****进行拼接，输出结果
        System.out.println(start + "****" + end);
    }
}
```

### 敏感词替换-字符串替换

```java
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 替换敏感词
        String result = s.replace("TMD","***");
        // 3. 输出结果
        System.out.println(result);
    }
}
```

### 切割字符串

```java
import java.util.Scanner;

public class Splittt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息:"); // stuInfo = "zs,23";
        String stuInfo = sc.nextLine();
        String[] sArr = stuInfo.split(",");
        Student stu = new Student(sArr[0],sArr[1]);
        // 调用对象getXxx方法取出数据并打印。
        System.out.println(stu.getName() + "..." + stu.getAge());
    }
}
```

### String 方法小结

| 方法名                                                       | 说明                                         |
| ------------------------------------------------------------ | -------------------------------------------- |
| `public boolean equals(Object anObject)`                     | 比较字符串的内容，严格区分大小写             |
| `public boolean equalsIgnoreCase(String anotherString) `     | 比较字符串的内容，忽略大小写                 |
| `public int length() `                                       | 返回此字符串的长度                           |
| `public char charAt(int index)`                              | 返回指定索引处的 char 值                     |
| `public char[] toCharArray()`                                | 将字符串拆分为字符数组后返回                 |
| `public String substring(int beginIndex, int endIndex) `     | 根据开始和结束索引进行截取，得到新的字符串   |
| `public String substring(int beginIndex)`                    | 从传入的索引处截取到末尾，得到新的字符串     |
| `public String replace(CharSequence target, CharSequence replacement) ` | 用新值，将字符串中的旧值替换，得到新的字符串 |
| `public String[] split(String regex)`                        | 根据传入的规则切割字符串，得到字符串数组     |

## 3 StringBuilder类

### 3.1 StringBuilder类概述

​	**概述 :** StringBuilder 是一个可变的字符串类，我们可以把它看成是一个容器，这里的可变指的是 StringBuilder 对象中的内容是可变的

### 3.2 StringBuilder类和String类的区别

- **String类：**内容是不可变的
- **StringBuilder类：**内容是可变的

### 3.3StringBuilder类的构造方法

**常用的构造方法**

| 方法名                             | 说明                                       |
| ---------------------------------- | ------------------------------------------ |
| public StringBuilder()             | 创建一个空白可变字符串对象，不含有任何内容 |
| public StringBuilder(String   str) | 根据字符串的内容，来创建可变字符串对象     |

**示例代码**

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.length():" + sb.length());

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());
    }
}
```

### 3.4 StringBuilder常用的成员方法

- **添加和反转方法**

  | 方法名                                  | 说明                     |
  | --------------------------------------- | ------------------------ |
  | public StringBuilder   append(任意类型) | 添加数据，并返回对象本身 |
  | public StringBuilder   reverse()        | 返回相反的字符序列       |

- **示例代码**

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();

        //public StringBuilder append(任意类型)：添加数据，并返回对象本身
//        StringBuilder sb2 = sb.append("hello");
//
//        System.out.println("sb:" + sb);
//        System.out.println("sb2:" + sb2);
//        System.out.println(sb == sb2);

//        sb.append("hello");
//        sb.append("world");
//        sb.append("java");
//        sb.append(100);

        //链式编程
        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);
    }
}
```

### 3.5StringBuilder和String相互转换【应用】

- **StringBuilder转换为String**

  ​        public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String

- **String转换为StringBuilder**

  ​        public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder

- **示例代码**

```java
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        /*
        //StringBuilder 转换为 String
        StringBuilder sb = new StringBuilder();
        sb.append("hello");

        //String s = sb; //这个是错误的做法

        //public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
        String s = sb.toString();
        System.out.println(s);
        */

        //String 转换为 StringBuilder
        String s = "hello";

        //StringBuilder sb = s; //这个是错误的做法

        //public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
        StringBuilder sb = new StringBuilder(s);

        System.out.println(sb);
    }
}
```

### 3.6 StringBuilder拼接字符串案例

**案例需求 :** 

​	定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，

​	并在控制台输出结果。例如，数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

**实现步骤 :** 

1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
2. 定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。
        返回值类型 String，参数列表 int[] arr
3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
4. 调用方法，用一个变量接收结果
5. 输出结果

**代码实现 :** 

```java
/*
    思路：
        1:定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        2:定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。
          返回值类型 String，参数列表 int[] arr
        3:在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);

    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");

        String s = sb.toString();

        return  s;
    }
}
```



