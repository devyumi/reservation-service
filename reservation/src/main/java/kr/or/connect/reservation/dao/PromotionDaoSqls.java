package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
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
}