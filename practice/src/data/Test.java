package data;

public class Test {
	public static void main(String[] args) {
		
		Person a = new Person(){};
		Person b = new Person(){};
		a.setting("김민석", 24);
		b.setting("asdf", 12, "공부");
		a.info();
		b.info();
	}
}
