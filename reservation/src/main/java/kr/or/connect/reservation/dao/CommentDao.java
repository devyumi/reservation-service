package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CommentDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Comment;
import kr.or.connect.reservation.domain.CommentDB;
import kr.or.connect.reservation.domain.CommentImage;
import kr.or.connect.reservation.domain.CommentImageDB;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertActionComment;
	private SimpleJdbcInsert insertActionCommentImage;
	private RowMapper<Comment> commentMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	private RowMapper<CommentImage> commentImageMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertActionComment = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment").usingGeneratedKeyColumns("id");
		this.insertActionCommentImage = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment_image").usingGeneratedKeyColumns("id");
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
	
	public int insertComment(CommentDB commentDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(commentDB);
		return insertActionComment.executeAndReturnKey(params).intValue();
	}
	
	public int insertCommentImage(CommentImageDB commentImageDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(commentImageDB);
		return insertActionCommentImage.executeAndReturnKey(params).intValue();
	}
	
	public List<CommentImage> selectCommentImages(int reservationUserCommentId){
		Map<String, Integer> params = Collections.singletonMap("reservation_user_comment_id", reservationUserCommentId);
		return jdbc.query(SELECT_COMMENT_IMAGE, params, commentImageMapper);
	}
}