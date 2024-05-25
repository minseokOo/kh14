package data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ㅇㅁㄴㄹ {

	public static void main(String[] args) {
		

		        // 복리 계산기

		        // 입력
		        int amount = 1600000; // 투자 금액
		        int interestRate = 20; // 연 이자율
		        double monthlyInterestRate = 1 + (double) interestRate / 100;

		        // 시작 날짜
		        LocalDate startDate = LocalDate.of(2024, 5, 25);

		        // 종료 날짜
		        LocalDate endDate = LocalDate.of(2024, 7, 26);

		        // 시작일과 종료일 출력
		        System.out.println("시작일 : " + startDate);
		        System.out.println("종료일 : " + endDate);

		        // 기간 계산
		        long periodInMonths = ChronoUnit.MONTHS.between(
		            startDate.withDayOfMonth(1),
		            endDate.withDayOfMonth(1)
		        );
		        boolean isExactMonthEnd = startDate.plusMonths(periodInMonths).withDayOfMonth(startDate.getDayOfMonth()).equals(endDate);

		        // 복리 계산
		        double finalRate = Math.pow(monthlyInterestRate, periodInMonths);
		        double finalMoney = amount * finalRate;

		        // 결과 출력
		        if (!isExactMonthEnd) {
		            finalMoney /= monthlyInterestRate; // Adjust if the end date is not exactly after a whole number of months
		        }
		        System.out.println("총 금액 : " + (int) finalMoney + "원");
		    }
		}
        

