import java.util.Random;
public class RandomBasic {
		public static void main (String[] args) {
				// 创建对象
				Random r = new Random();
				for(int i = 1; i <= 5; i++){
						// 产生0-9的随机数
						int num = r.nextInt(10);
						System.out.print(num + " ");
				}
		}
}
