package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;
import jdbc.util.PoketmonDto;
import jdbc.util.PoketmonMapper;

public class Test01포켓몬조회 {
	public static void main(String[] args) {
		//입력
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from poketmon";
		
		PoketmonMapper mapper = new PoketmonMapper();
		
		List<PoketmonDto> list = jdbcTemplate.query(sql,  mapper);
		
		//출력
		System.out.println("개수 : " + list.size());
		for(PoketmonDto dto : list) {
			System.out.println(dto.getPoketmonNo());
			System.out.println(dto.getPoketmonName());
			System.out.println(dto.getPoketmonType());
		}
		
	}
}
