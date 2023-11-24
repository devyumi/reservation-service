package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.UserDaoSqls.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.User;

import javax.sql.DataSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public User getMemberByEmail(String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		
		return jdbc.queryForObject(UserDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
	
	public int selectIdByEmail(String email) {
		Map<String, String> params = Collections.singletonMap("email", email);
		return jdbc.queryForObject(SELECT_ID_BY_EMAIL, params, Integer.class);
	}
}