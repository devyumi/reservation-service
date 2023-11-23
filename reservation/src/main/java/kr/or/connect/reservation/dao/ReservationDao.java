package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.ReservationInfoDB;
import kr.or.connect.reservation.domain.ReservationInfoPriceDB;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertActionReservationInfoPrice;
	private SimpleJdbcInsert insertActionReservationInfo;
	
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
}