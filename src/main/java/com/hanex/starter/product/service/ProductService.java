package com.hanex.starter.product.service;

import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.common.security.CustomUser;
import com.hanex.starter.product.domain.Product;
import com.hanex.starter.product.dto.ProductDto;
import com.hanex.starter.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto.ProductInfoResponse> searchProduct(Pageable pageable){


        return null;
    }

    @Transactional(readOnly = true)
    public ProductDto.ProductInfoResponse findProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        return product.toDto();
    }

    @Transactional
    public void createProduct(ProductDto.SaveRequest request, CustomUser user){
        productRepository.save(request.toEntity(user));
    }

    @Transactional
    public void updateProduct(Long id,ProductDto.UpdateRequest update,CustomUser user){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        //productRepository.updateProduct(update.toEntity());
    }


    @Transactional
    public void deleteById(Long id,CustomUser user){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void selectById(Long id){

        Product product = productRepository.selectById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));

    }
}
