package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.DisplayInfos;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfos> displayInfoMapper = BeanPropertyRowMapper.newInstance(DisplayInfos.class);
	private RowMapper<ProductImage> productImageMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> displayInfoImageMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> productPriceMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
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
}