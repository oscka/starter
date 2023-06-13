package com.hanex.starter.product.repository;

public class ProductSql {

	public static final String SELECT_BY_ID =  """
		SELECT
			P.id AS product_id,
			P.name AS product_name,
			P.supply_company_id,
			P.description,
			P.customer_id,
			P.created_at,
			C.customer_name,
			C.phone,
			C.customer_group,
			M.member_type,
			M.ceo_name
		FROM product_tb P 
		LEFT OUTER JOIN customer C ON C.id = P.customer_id
		LEFT OUTER JOIN member_tb M ON M.id = P.supply_company_id
		WHERE P.id = :id
	""";

	public static final String UPDATE = """
	   UPDATE product_tb P
		SET P.name = :name
			, P.stock = :stock
		WHERE P.id :=id
	""";

}
