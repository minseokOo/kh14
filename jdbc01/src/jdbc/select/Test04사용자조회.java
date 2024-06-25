package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;
import jdbc.util.MemberDto;
import jdbc.util.MemberMapper;

public class Test04사용자조회 {
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from member";
		
		MemberMapper mapper = new MemberMapper();
		List<MemberDto> list = jdbcTemplate.query(sql, mapper);
		
		System.out.println(list.size());
		
		for(MemberDto dto:list) {
			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			System.out.println(dto.getNickname());
			System.out.println(dto.getBirth());
			System.out.println(dto.getContact());
			System.out.println(dto.getEmail());
			System.out.println(dto.getLevel());
			System.out.println(dto.getPoint());
			System.out.println(dto.getPost());
			System.out.println(dto.getAddress1());
			System.out.println(dto.getAddress2());
			System.out.println(dto.getJoin());
			System.out.println(dto.getLogin());
		}
	}
}
