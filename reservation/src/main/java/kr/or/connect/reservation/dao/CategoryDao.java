package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CategoryDaoSqls.*;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> categoryMapper = BeanPropertyRowMapper.newInstance(Category.class); //resultSet
	
	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectCategories(){
		return jdbc.query(SELECT_CATEGORY, categoryMapper);
	}
}