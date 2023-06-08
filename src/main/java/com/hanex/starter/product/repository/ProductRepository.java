package com.hanex.starter.product.repository;

import com.hanex.starter.product.domain.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> ,ProductRepositoryCustom {


    @Query(ProductSql.SELECT_BY_ID)
    Optional<Product> selectById(Long id);


}
