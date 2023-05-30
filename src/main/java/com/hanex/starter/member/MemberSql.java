package com.hanex.starter.member;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.*;

public class MemberSql {


    public static String SELECT_BY_ID_WITH_CLIENT(Sort sort){
        return """
                SELECT 
                     m.id 
                     , m.name 
                     , m.manager_name 
                     , m.member_code 
                     , m.ceo_name 
                     , m.registration_number
                     , m.phone 
                     , m.memo 
                     , m.client_id 
                     , m.email
                     , m.created_by
                     , m.created_at
                     , m.updated_by
                     , m.updated_at
                FROM member_tb m 
                """
                +
                whereAnd (
                        notEmpty(":clientId","client_id :clientId")
                )
                +
                " ORDER BY " + orderBy(sort)
                +
                " LIMIT :pageSize OFFSET :offset"
                ;
    }


    public static String COUNT_BY_ID_WITH_CLIENT(){
        return """
            SELECT
                COUNT(*)
            FROM member_tb m
                """
                +
                whereAnd (
                        notEmpty(":clientId","client_id :clientId")
                )
                ;
    }

    private static String notEmpty(String param, String condition) {
        return StringUtils.isEmpty(param)? null: condition;
    }

    private static String whereAnd(String ... conditions) {
        //List<String> finalCond = conditions.findAll({it != null});
        List<String> finalCond = Collections.singletonList(firstNonBlank(conditions));
        Assert.notEmpty(finalCond);
        //return "WHERE " + finalCond.join("\nAND ");
        return " WHERE " + String.join(finalCond + "\nAND");
    }


    private static String orderBy(Sort sort) {
        return sort.stream()
                .map(order -> order.getProperty() + " " + order.getDirection().name())
                .collect(joining(", "));
    }
}
