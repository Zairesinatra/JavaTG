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
