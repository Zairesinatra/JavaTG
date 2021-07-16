public class StandardClass {
		// 成员变量
		private String name;
		private int age;
		// method
		public StandardClass() {}
		public StandardClass(String name, int age){
				this.name = name;
				this.age = age;
		} 
		// member methods
		public void setName(String name) {
				this.name = name;
		}
		public String getName() {
				return name;
		}
		public void setAge(int age) {
				this.age = age;
		}
		public int getAge() {
				return age;
		}
		public void show() {
				System.out.println(name + "...is..." + age);
		}
}
