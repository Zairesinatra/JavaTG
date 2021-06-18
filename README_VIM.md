# README

------

**命令模式与编辑模式：**`i` 、 `esc` 、 `wq zs.java`

**vim 设置语法高亮：**命令模式下 `:syntax on`

**vim 设置行号：**命令模式下 `:set number`

**在 `.vimrc` 配置文件保存配置：**`mvim ~/.vimrc`

```zsh
syntax on
set number
```

**方向移动：**⬅️↕️➡️、`H`、`J`、`K`、`L`

**词汇跳跃：**`w` =word=> 下跃、 `b` =back=> 回跳

**翻页跳跃：**`ctrl` + `F` = forward 、  `ctrl` + `B`

**指定跳跃：**`Number` + `gg`

**指定行跳跃：**`Number` + `j` \ `k`

**错误命令清除：**`esc`

**定位查找：**命令模式下 `/what` 回车则全局开启指定词汇高亮 （注意这里不要 `:`）且此时跳跃下一处高亮位按下 `n` = next ; 回退为 `shift` + `n`

<img src="./assets/find.png" width="50%" />

完成后按下 `esc` + `i` 即可继续进行书写

**剪切行：** `cc` （这里注意使用后会跳入编辑模式）、**恢复剪切：**`u` = undo

**剪切 n 行：** `c` + Number + `c`

**粘贴此前被剪切的行：** `p` 、 **撤销粘贴：** `u` = undo

