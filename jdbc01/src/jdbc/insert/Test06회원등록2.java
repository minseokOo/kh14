package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test06회원등록2 {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
    	
    	System.out.println("id");
        String id = sc.nextLine();
        System.out.println("pw");
        String pw = sc.nextLine();
        System.out.println("");
        String nickName = sc.nextLine();
        System.out.println("");
        String birth = sc.nextLine();
        System.out.println("");
        String contact = sc.nextLine();
        System.out.println("");
        String email = sc.nextLine();
        System.out.println("");
        String level = sc.nextLine();
        System.out.println("");
        int point = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        String post = sc.nextLine();
        System.out.println("");
        String address1 = sc.nextLine();
        System.out.println("");
        String address2 = sc.nextLine();
        sc.close();
        // 모든 컬럼을 포함하도록 SQL 쿼리 수정
        String sql = "insert into member(member_id, member_pw, member_nickname, member_birth, member_contact, member_email, member_level, member_point, member_post, member_address1, member_address2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] data = {id, pw, nickName, birth, contact, email, level, point, post, address1, address2};
        jdbcTemplate.update(sql, data);
        
        System.out.println("회원 등록 완료");
    }
}