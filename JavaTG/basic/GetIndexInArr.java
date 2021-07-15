import java.util.Scanner;
public class GetIndexInArr {
		public static void main (String[] args) {
				int[] arr = {1, 2, 3, 4, 5};
				// 用变量接收键盘录入要查找的数据
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入需要查看索引的元素:"); // 需要在int num之前否则开始不会显示
				int num = sc.nextInt(), index = -1;
				for(int i = 0; i < arr.length; i++){
						if(num == arr[i]) {
								index = i;
								break; // 提高效率
						}
				}
				System.out.println(index);
		}
}
