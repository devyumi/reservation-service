package kr.or.connect.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_AVG_SCORE = "SELECT FLOOR(AVG(score)) as avgScore "
			+ "FROM reservation_user_comment "
			+ "INNER JOIN product "
			+ "ON reservation_user_comment.product_id = product.id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "WHERE display_info.id = :display_info_id";
	
	public static final String SELECT_COMMENT = "SELECT reservation_user_comment.id, product_id as productId, reservation_user_comment.reservation_info_id as reservationInfoId, score, email as reservationEmail, comment, reservation_user_comment.create_date as createDate, reservation_user_comment.modify_date as modifyDate "
			+ "FROM reservation_user_comment "
			+ "INNER JOIN user "
			+ "ON reservation_user_comment.user_id = user.id "
			+ "GROUP BY reservation_user_comment.id "
			+ "HAVING product_id = :product_id "
			+ "ORDER BY reservation_user_comment.id DESC "
			+ "LIMIT :start, :limit";
	
	public static final String SELECT_COMMENT_COUNT = "SELECT count(*) "
			+ "FROM reservation_user_comment "
			+ "WHERE product_id = :product_id";
}