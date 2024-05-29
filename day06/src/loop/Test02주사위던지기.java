package loop;

import java.util.Random;

public class Test02주사위던지기 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		//for( 1; 2; 3){ 4 }
		// 1. 선언부 - 반복에 사용할 변수를 만드는 공간
		// 2. 조건부 - 실행 가능한 상태를 논리로 작성하는 공간
		// 3. 증감부 - 1에서 만든 변수에 대한 변화를 작성하는 공간
		// 4. 실행코드 -반복적으로 실행할 코드
		
		for(int i=0; i <10; i++){
		int dice = r.nextInt(6) + 1;
		System.out.println(dice);
		}
	}
}
