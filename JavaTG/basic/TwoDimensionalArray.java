public class TwoDimensionalArray {
		public static void main (String[] args) {
				int[] arr1 = {1, 2, 3};
				int[] arr2 = {4, 5, 6};
				int[] arr3 = {7, 8, 9, 10};
				int[][] arr = new int[3][3];
				// 访问不存在索引必定有问题
				// arr[2][3] = 10;
				arr[0] = arr1;
				arr[1] = arr2;
				arr[2] = arr3; // 内存地址发生替换
				System.out.println(arr[1][2]); // 6
				System.out.println(arr[2][3]); // 10
		}
}
