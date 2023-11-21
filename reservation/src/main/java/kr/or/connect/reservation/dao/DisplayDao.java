package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.DisplayDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.DisplayInfos;

@Repository
public class DisplayDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfos> displayInfoMapper = BeanPropertyRowMapper.newInstance(DisplayInfos.class);
	
	public DisplayDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfos> selectDisplayInfos(int categoryId, int start, int limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_DISPLAY_INFOS, params, displayInfoMapper);
	}
	
	public int selectDisplayInfoCount(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("category_id", categoryId);
		return jdbc.queryForObject(SELECT_DISPLAY_INFO_COUNT, params, Integer.class);		
	}
}