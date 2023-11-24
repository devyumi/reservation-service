package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_ORDER_INFOS = "SELECT r.id AS id, r.product_id AS productId, r.display_info_id AS displayInfoId, r.cancel_flag AS cancelFlag, p.description AS productDescription, p.content AS productContent, r.user_id AS userId, SUM(pp.price * rip.count) AS sumPrice, r.reservation_date AS reservationDate, r.create_date AS createDate, r.modify_date AS modifyDate "
			+ "FROM reservation_info r "
			+ "INNER JOIN reservation_info_price rip "
			+ "ON r.id = rip.reservation_info_id "
			+ "INNER JOIN product p "
			+ "ON r.product_id = p.id "
			+ "INNER JOIN product_price pp "
			+ "ON rip.product_price_id = pp.id "
			+ "WHERE r.user_id = :user_id "
			+ "GROUP BY r.id "
			+ "ORDER BY r.id DESC";
	
	public static final String UPDATE_CANCEL_FLAG = "UPDATE reservation_info "
			+ "SET cancel_flag = 1 "
			+ "WhERE id = :reservation_id AND user_id = :user_id";
}
