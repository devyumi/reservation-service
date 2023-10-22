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
import kr.or.connect.reservation.domain.Comment;
import kr.or.connect.reservation.domain.DisplayInfos;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;
import kr.or.connect.reservation.domain.Promotion;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> categoryMapper = BeanPropertyRowMapper.newInstance(Category.class); //resultSet
	private RowMapper<DisplayInfos> displayInfoMapper = BeanPropertyRowMapper.newInstance(DisplayInfos.class);
	private RowMapper<Promotion> promotionMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	private RowMapper<ProductImage> productImageMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> displayInfoImageMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> productPriceMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	private RowMapper<Comment> commentMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectCategories(){
		return jdbc.query(SELECT_CATEGORY, categoryMapper);
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
	
	public List<Promotion> selectPromotions(){
		return jdbc.query(SELECT_PROMOTION, promotionMapper);
	}
	
	public List<DisplayInfos> selectDisplayInfo(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_DISPLAY_INFO, params, displayInfoMapper);
	}
	
	public List<ProductImage> selectProductImages(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_PRODUCT_IMAGE, params, productImageMapper);
	}
	
	public List<DisplayInfoImage> selectDisplayInfoImages(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE, params, displayInfoImageMapper);
	}
	
	public List<ProductPrice> selectProductPrices(int displayInfoId){
		Map<String, Integer> params = new HashMap<>();
		params.put("display_info_id", displayInfoId);
		return jdbc.query(SELECT_PRODUCT_PRICE, params, productPriceMapper);
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