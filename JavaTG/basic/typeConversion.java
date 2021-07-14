public class typeConversion {
		// 类似于 500ml 咖啡可以倒入 1l 的容器
		public static void main(String[] args) {
				int a = 6;
				double b = a;
				System.out.println(b); // 6.0 系统自动隐式转换,看不见
				// 特殊细节: byte、short、char
				byte z = 6;
				byte s = 6;
				int zy = z + s;
				System.out.println(zy);
				// int隐式转换为double
				int c = 10; double d = 12.2;
				double e = c + d;
				System.out.println(e);
				// 强制类型转换-大的给小的赋值
				int f = 10; // int 4个字节
				byte g = (byte)f; // byte 1个字节 - 若不加强制转换则会因不兼容的类型损失精度错误
				System.out.println(g);
				// 示范精度损失
				double num = 6.6;
				int numm = (int)num;
				System.out.println(numm); // 6 => 直接暴力砍掉小数点后的数值
				// 常量优化机制
				// 编译时就会让常量相加,并自动判断取值是否在byte的取值范围之内?通过编译:编译出错
				byte h = 4 + 22;
				System.out.println(h);
		}
}
