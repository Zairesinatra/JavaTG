public class ArrayBasic {
		public static void main (String[] args) {
				// 数据类型[] 数组名 = new 数据类型[数组的长度];
				int[] arr = new int[5];
				// 打印数组变量的时候, 会打印出数组的内存地址
				System.out.println(arr); // [I@6504e3b2
				// @: 分隔符
				// [: 当前的空间是一个数组类型
				// I: 当前数组容器中所存储的数据类型
				// 6504e3b2: 十六进制内存地址

				// 数组名[索引]  访问数组容器中的空间位置
				// 0  系统自动分配的默认初始化值 => 数组在创建完毕后, 即使没有赋值, 元素也可以取出, 但取出的元素都是默认初始化值.
				System.out.print(arr[0] + " "); // 0 
				System.out.print(arr[1] + " "); // 0
				System.out.print(arr[2] + " "); // 0

				System.out.print(" -------------- ");

				// 数组名[索引]
				arr[0] = 1;
				arr[1] = 2;
				arr[2] = 3;

				System.out.print(arr[0]); // 1
				System.out.print(arr[1]); // 2
				System.out.println(arr[2]); // 3

				// static array
				// 数据类型[] 数组名 = new 数据类型[]{数据1,数据2,数据3...};
				int[] arrr = new int[]{111,222,333};
				System.out.print("-" + arrr[0]);
				System.out.print("-" + arrr[1]);
				System.out.print("-" + arrr[2]);

				// 数据类型[] 数组名 = {数据1,数据2,数据3...};
				// 编译器会自动补上代码;
				int[] arr2 = {444,555,666};
				System.out.print("-" + arr2);
				System.out.print("-" + arr2[0]);
				System.out.print("-" + arr2[1]);
				System.out.print("-" + arr2[2]);
		}
}
