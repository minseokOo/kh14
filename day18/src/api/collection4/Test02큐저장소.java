package api.collection4;

import java.util.LinkedList;
import java.util.Queue;

public class Test02큐저장소 {
	public static void main(String[] args) {
		// 큐(Queue)
		// - 사용법이 정해져 있는 인터페이스
		// - 먼저 들어온 데이터가 먼저 나가는 구조(FIFO, First-In-First-Out)
		// - 대기줄 구현을 위한 구조
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("뽀로로");
		queue.offer("크롱");
		queue.offer("루피");
		queue.offer("패티");
		
		//맨 앞 데이터 확인 - peek()
		System.out.println("맨 앞 = " + queue.peek());
		
		//데이터 제거 - poll() (앞에서 부터 제거)
		queue.poll();
		queue.poll();
		System.out.println(queue.peek());
		
		
	}
}
