package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CommentDaoSqls.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Comment> commentMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int selectScoreAvg(int displayInfoId) {
		Map<String, Integer> params = Collections.singletonMap("display_info_id", displayInfoId);
		return jdbc.queryForObject(SELECT_AVG_SCORE, params, Integer.class);
	}
	
	public List<Comment> selectComments(int productId, int start, int limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("product_id", productId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_COMMENT, params, commentMapper);
	}
	
	public int selectCommentCount(int productId) {
		Map<String, Integer> params = Collections.singletonMap("product_id", productId);
		return jdbc.queryForObject(SELECT_COMMENT_COUNT, params, Integer.class);
	}
}