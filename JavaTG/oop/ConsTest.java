public class ConsTest {
		public static void main(String args[]) {
				// noargs
				StandardClass sc = new StandardClass();
				sc.show();
				sc.setName("zyzyzy");
				sc.setAge(23);
				sc.show();
				// args
				StandardClass scc = new StandardClass("zszszs", 22);
				scc.show();
		}
}
