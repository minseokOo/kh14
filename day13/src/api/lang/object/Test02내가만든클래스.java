package api.lang.object;

public class Test02내가만든클래스 {
	public static void main(String[] args) {

		//객체 생성
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.setName("피카츄");
		s1.setScore(50);
		s2.setName("피카츄");
		s2.setScore(70);

		//메소드 호출
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		System.out.println(s1 == s2); //동일한 대상일때만 true 가 나옴
		System.out.println(s1.equals(s2));
		
	}
}
