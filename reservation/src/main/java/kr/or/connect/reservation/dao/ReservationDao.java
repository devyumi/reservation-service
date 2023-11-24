package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.Collections;
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

import kr.or.connect.reservation.domain.OrderInfos;
import kr.or.connect.reservation.domain.ReservationInfoDB;
import kr.or.connect.reservation.domain.ReservationInfoPriceDB;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertActionReservationInfoPrice;
	private SimpleJdbcInsert insertActionReservationInfo;
	private RowMapper<OrderInfos> orderInfosMapper = BeanPropertyRowMapper.newInstance(OrderInfos.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertActionReservationInfo = new SimpleJdbcInsert(dataSource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
		this.insertActionReservationInfoPrice = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
	}
	
	public int insertReservationInfoPrice(ReservationInfoPriceDB reservationInfoPriceDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPriceDB);
		return insertActionReservationInfoPrice.executeAndReturnKey(params).intValue();
	}

	public int insertReservationInfo(ReservationInfoDB reservationInfoDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoDB);
		return insertActionReservationInfo.executeAndReturnKey(params).intValue();
	}

	public List<OrderInfos> selectOrderInfos(int userId) {
		Map<String, Integer> params = Collections.singletonMap("user_id", userId);
		return jdbc.query(SELECT_ORDER_INFOS, params, orderInfosMapper);
	}
}