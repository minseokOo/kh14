package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test06회원등록 {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("kh14");
        dataSource.setPassword("kh14");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        String id = sc.nextLine();
        String pw = sc.nextLine();
        String nickName = sc.nextLine();
        String birth = sc.nextLine();
        String contact = sc.nextLine();
        String email = sc.nextLine();
        String level = sc.nextLine();
        int point = sc.nextInt();
        sc.nextLine();
        String post = sc.nextLine();
        String address1 = sc.nextLine();
        String address2 = sc.nextLine();

        // 모든 컬럼을 포함하도록 SQL 쿼리 수정
        String sql = "insert into member(member_id, member_pw, member_nickname, member_birth, member_contact, member_email, member_level, member_point, member_post, member_address1, member_address2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] data = {id, pw, nickName, birth, contact, email, level, point, post, address1, address2};
        jdbcTemplate.update(sql, data);
        
        System.out.println("회원 등록 완료");
    }
}