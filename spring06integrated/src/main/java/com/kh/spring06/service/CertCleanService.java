package com.kh.spring06.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//인증번호 청소 서비스
// - 정해진 시간마다 쓸모 없어진 인증번호를 삭제하는 서비스
// - 쓸모 없다는 것은 인증 시간이 만료된 데이터를 의미(현재는 10분)

@Service
public class CertCleanService {

	//정기적으로 실행할 작업에 @Scheduled를 추가하여 실행 지시
	//@Scheduled(fixedRate = 1000L)// ms 단위 
	//@Scheduled(cron = "* * * * * *")// 매초 매분 매시 매일 매월 모든요일
//	@Scheduled(cron = "*/2 * * * * *")// 매 2초마다 매분 매시 매일 매월 모든요일
//	@Scheduled(cron = "0-20 * * * * *")// 0~20초 매분 매시 매일 매월 모든요일
//	@Scheduled(cron = "0,30 * * * * *")//0,30초 매분 매시 매일 매월 모든요일
	
//	(Q) 출근시각(0930)과 퇴근시각(1830)에 한 번씩 실행
//	@Scheduled(cron = "0 30 9,18 * * *")
//	(Q) 업무시간(0930~1830) 사이의 매 정각마다 한 번씩 실행
//	@Scheduled(cron = "0 0 10-18 * * *")
//	(Q) 영업일 업무시각 정각마다 실행
//	@Scheduled(cron = "0 0 10-18 * * 1-5")//월(1), 금(5), 토(6), 일(7)
//	@Scheduled(cron = "0 0 10-18 * * mon-fri")
	
//	(Q) 매월 셋째주 목요일 오후 2시에 실행
//	@Scheduled(cron = "0 0 14 ? * 4#3")//셋째주(#3) 목요일(4), ? = 무관
//	@Scheduled(cron = "0 0 14 ? * thu#3")//셋째주(#3) 목요일(thu), ? = 무관
	
//	(Q) 매월 마지막 주 목요일 오후 2시에 실행
//	@Scheduled(cron = "0 0 14 ? * 4L")//마지막(L) 목요일(4)
	
//	(Q) 급여일(매월 25일) 오후 3시에 실행
	@Scheduled(cron = "0 0 15 25 * *")
	public void clean() {
		System.out.println("청소 시작" + LocalDateTime.now());
	}
}
