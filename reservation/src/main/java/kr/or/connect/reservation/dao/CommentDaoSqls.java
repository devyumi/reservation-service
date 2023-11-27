package kr.or.connect.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_AVG_SCORE = "SELECT FLOOR(AVG(score)) as avgScore "
			+ "FROM reservation_user_comment "
			+ "INNER JOIN product "
			+ "ON reservation_user_comment.product_id = product.id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "WHERE display_info.id = :display_info_id";
	
	public static final String SELECT_COMMENT = "SELECT c.id AS id, c.product_id AS productId, c.reservation_info_id AS reservationInfoId, score, c.user_id AS userId, comment "
			+ "FROM reservation_user_comment c "
			+ "WHERE product_id = :product_id "
			+ "ORDER BY c.id DESC "
			+ "LIMIT :start, :limit";
	
	public static final String SELECT_COMMENT_COUNT = "SELECT count(*) "
			+ "FROM reservation_user_comment "
			+ "WHERE product_id = :product_id";
	
	public static final String SELECT_COMMENT_IMAGE = "SELECT c.id AS id, reservation_info_id AS reservationInfoId, reservation_user_comment_id AS reservationUserCommentId, c.file_id AS fileId, file_name AS fileName, save_file_name AS saveFileName, content_type AS contentType, delete_flag AS deleteFlag, create_date AS createDate, modify_date AS modifyDate "
			+ "FROM reservation_user_comment_image c "
			+ "INNER JOIN file_info f "
			+ "ON c.file_id = f.id "
			+ "WHERE c.reservation_user_comment_id = :reservation_user_comment_id";
}