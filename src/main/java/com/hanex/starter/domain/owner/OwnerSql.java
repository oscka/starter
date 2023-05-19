package com.hanex.starter.domain.owner;

public class OwnerSql {

    public static final String SELECT_BY_ID_WITH_PRODUCT =  """
                SELECT
                    o.order_id
                    , o.member_id
                    , o.order_code
                    , o.company_order_code
                    , o.receiver_name
                    , o.phone
                    , o.order_status
                    , o.order_date
                    , o.memo
                    , o.channel_id
                    , s.shipping_method_id
                    , s.shipping_address
                    , s.request_shipping_dt
                    , s.shipping_message
                    , p.sales_product_code	
                    , oi.sales_product_id
                    , oi.quantity
                FROM tb_order o
                    LEFT OUTER JOIN tb_member m m.id = o.member_id
                    LEFT OUTER JOIN tb_product p p.id = o.product_id
                    LEFT OUTER JOIN tb_shipping s s.id = o.shipping_id
                    LEFT OUTER JOIN order_item oi oi.order_id = o.id
                WHERE o.member_id = :memberId
                ORDER BY order_id
                LIMIT 0 OFFSET 10
            """;
}
