package kr.or.connect.reservation.dao;

public class DisplayDaoSqls {
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
}
