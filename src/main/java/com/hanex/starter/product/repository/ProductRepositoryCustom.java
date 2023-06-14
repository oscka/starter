package com.hanex.starter.product.repository;

import com.hanex.starter.product.domain.Product;

import java.util.UUID;

public interface ProductRepositoryCustom {

    void deleteById(UUID id);

    void delete(Product product);



}
