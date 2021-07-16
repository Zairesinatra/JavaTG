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
				System.out.println(s4);
		}
}
