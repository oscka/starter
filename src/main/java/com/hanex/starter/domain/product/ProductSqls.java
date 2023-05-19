package com.hanex.starter.domain.product;

public class ProductSqls {

	public static final String SELECT_BY_ID =  """
		SELECT
			P.id AS product_id, P.name AS product_name, P.price, P.desc, P.owner_id, P.created_at,
			S.name AS owner_name, S.tel_no, S.address, S.homepage
		FROM product P LEFT OUTER JOIN seller S ON S.id = P.owner_id
		WHERE P.id = :id
	""";
}
