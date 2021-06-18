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

一般情况下，Mac OS X 自带的 vim 是不能满足需求的，所以选择 [HomeBrew](https://formulae.brew.sh/formula/neovim#default) 安装 [NeoVim](https://neovim.io/)

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

安装 vim-plug：

**Vim**-**plug**是一个免费、开源、非常快速和极简的 **vim 插件** 管理器。 它可以并行安装或更新 **插件**。 可以回滚更新，创建浅克隆以最大限度地减少磁盘空间使用和下载时间。

```zsh
sh -c 'curl -fLo "${XDG_DATA_HOME:-$HOME/.local/share}"/nvim/site/autoload/plug.vim --create-dirs \
       https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim'
```

这样，这个`~/.local/share/nvim/site/autoload/plug.vim`就会在你的目录下，并且vim会被调用。

### 语法：

单行注释多行注释与 JavaScript 相同。文档注释： `/**注释信息*/`

关键字：关键字字母全小写且有特殊颜色标记

常量：