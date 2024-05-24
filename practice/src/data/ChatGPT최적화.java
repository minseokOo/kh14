package data;

public class ChatGPT최적화 {

    public static void main(String[] args) {
        // 급여와 보험료 비율 상수 선언
        final int money = 3000000; // 급여
        final double gmygRate = 4.5; // 국민연금 비율 (%)
        final double ggbhRate = 7.09; // 건강보험료 비율 (%)
        final double yybhRate = 12.81; // 요양보험료 비율 (%)
        final double gybhRate = 0.9; // 고용보험료 비율 (%)

        // 보험료 계산
        double gmygP = calculateInsurancePayment(money, gmygRate);
        double ggbhP = calculateInsurancePayment(money, ggbhRate);
        double yybhP = calculateInsurancePayment(ggbhP, yybhRate);
        double gybhP = calculateInsurancePayment(money, gybhRate);

        // 반올림 처리
        int a = (int) Math.round(gmygP);
        int b = (int) Math.round(ggbhP);
        int c = (int) Math.round(yybhP);
        int d = (int) Math.round(gybhP);

        // 총 납부 금액 계산
        int total = a + b + c + d;

        // 실 급여 계산
        int finMoney = money - total;

        // 결과 출력
        System.out.println("급여 : " + money + "원");
        System.out.println("-----------------------------------");
        System.out.println("국민연금 납부 금액 : " + a + "원");
        System.out.println("건강보험 납부 금액 : " + b + "원");
        System.out.println("요양보험 납부 금액 : " + c + "원");
        System.out.println("고용보험 납부 금액 : " + d + "원");
        System.out.println("-----------------------------------");
        System.out.println("총 납부 금액 : " + total + "원");
        System.out.println("-----------------------------------");
        System.out.println("실 급여 : " + finMoney + "원");
    }

    // 보험료를 계산하는 메서드
    private static double calculateInsurancePayment(double salary, double rate) {
        return salary * (rate / 100);
    }
}
