package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_CATEGORY = "SELECT category.id, category.name, count(*) as count "
			+ "FROM category "
			+ "INNER JOIN product "
			+ "ON category.id = product.category_id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "GROUP BY category.id";
	
	public static final String SELECT_DISPLAY_INFOS = "SELECT product.id, category.id as categoryId, display_info.id as displayInfoId, name, description, content, event, opening_hours as openingHours, place_name as placeName, place_lot as placeLot, place_street as placeStreet, tel, homepage, email, display_info.create_date as createDate, display_info.modify_date as modifyDate, product_image.file_id as fileId "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "INNER JOIN category "
			+ "ON product.category_id = category.id "
			+ "INNER JOIN product_image "
			+ "ON product.id = product_image.product_id "
			+ "GROUP BY product.id "
			+ "HAVING category.id = :category_id "
			+ "LIMIT :start, :limit";
	
	public static final String SELECT_DISPLAY_INFO_COUNT = "SELECT count(*) "
			+ "FROM product "
			+ "WHERE product.category_id = :category_id";
	
	public static final String SELECT_PROMOTION = "SELECT promotion.id, product.id as productId, category.id as categoryId, name as categoryName, description, file_id as fileId "
			+ "FROM promotion "
			+ "INNER JOIN product "
			+ "ON promotion.product_id = product.id "
			+ "INNER JOIN category "
			+ "ON product.category_id = category.id "
			+ "INNER JOIN product_image "
			+ "ON product.id = product_image.product_id "
			+ "WHERE type = 'ma' "
			+ "GROUP BY promotion.id";
	
	public static final String SELECT_DISPLAY_INFO = "SELECT product.id, category.id as categoryId, display_info.id as displayInfoId, name, description, content, event, opening_hours as openingHours, place_name as placeName, place_lot as placeLot, place_street as placeStreet, tel, homepage, email, display_info.create_date as createDate, display_info.modify_date as modifyDate, product_image.file_id as fileId "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "INNER JOIN category "
			+ "ON product.category_id = category.id "
			+ "INNER JOIN product_image "
			+ "ON product.id = product_image.product_id "
			+ "GROUP BY product.id "
			+ "HAVING display_info.id = :display_info_id";
	
	public static final String SELECT_PRODUCT_IMAGE = "SELECT product_image.product_id as productId, product_image.id as productImageId, type, file_info.id as fileInfoId, file_name as fileName, save_file_name as saveFileName, content_type as contentType, delete_flag as deleteFlag, product.create_date as createDate, product.modify_date as modifyDate "
			+ "FROM product_image "
			+ "INNER JOIN file_info "
			+ "ON product_image.file_id = file_info.id "
			+ "INNER JOIN product "
			+ "ON product_image.product_id = product.id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "WHERE display_info.id = :display_info_id";
	
	public static final String SELECT_DISPLAY_INFO_IMAGE = "SELECT display_info_image.id, display_info_id as displayInfoId, file_info.id as fileId, file_name as fileName, save_file_name as saveFileName, content_type as contentType, delete_flag as deleteFlag, create_date as createDate, modify_date as modifyDate "
			+ "FROM display_info_image "
			+ "INNER JOIN file_info "
			+ "ON display_info_image.file_id = file_info.id "
			+ "WHERE display_info_id = :display_info_id";
	
	public static final String SELECT_PRODUCT_PRICE = "SELECT product_price.id, product_price.product_id as productId, price_type_name as priceTypeName, price, discount_rate as discountRate, product_price.create_date as createDate, product_price.modify_date as modifyDate "
			+ "FROM product_price "
			+ "INNER JOIN product "
			+ "ON product_price.product_id = product.id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "WHERE display_info.id = :display_info_id "
			+ "ORDER BY id DESC";
	
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
