package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.DisplayInfo;
import kr.or.connect.reservation.domain.Promotion;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> categoryMapper = BeanPropertyRowMapper.newInstance(Category.class); //resultSet
	private RowMapper<DisplayInfo> displayInfoMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	private RowMapper<Promotion> promotionMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectCategories(){
		return jdbc.query(SELECT_CATEGORY, categoryMapper);
	}
	
	public List<DisplayInfo> selectDisplayInfos(int categoryId, int start, int limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_DISPLAY_INFO, params, displayInfoMapper);
	}
	
	public int selectDisplayInfoCount(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("category_id", categoryId);
		return jdbc.queryForObject(SELECT_DISPLAY_INFO_COUNT, params, Integer.class);		
	}
	
	public List<Promotion> selectPromotions(){
		return jdbc.query(SELECT_PROMOTION, promotionMapper);
	}
}