package com.hanex.starter.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hanex.starter.common.exception.Exception403;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.common.exception.Exception500;
import com.hanex.starter.common.security.CustomUser;
import com.hanex.starter.product.domain.Product;
import com.hanex.starter.product.dto.ProductDto;
import com.hanex.starter.product.event.ProductChanged;
import com.hanex.starter.product.event.StreamProcessor;
import com.hanex.starter.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.domain.Pageable;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;

import java.util.List;

@Slf4j
@EnableBinding(StreamProcessor.class)
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final StreamProcessor processor;

    @Transactional(readOnly = true)
    public List<ProductDto.ProductInfoResponse> searchProduct(Pageable pageable){


        return null;
    }

    @Transactional(readOnly = true)
    public ProductDto.ProductInfoResponse findProductById(Long id,CustomUser customUser){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));

        if (product.getCreatedBy().equals(customUser.getUserId().toString())){
            throw new Exception403("본인이 생성한 상품만 확인할 수 있습니다.");
        }
        return product.toDto();
    }

    @Transactional
    public void createProduct(ProductDto.ProductSaveRequest request, CustomUser user){
        productRepository.save(request.toEntity(user));
    }


    // TODO CustomUser > 각 entity 에 setting 하지 않고 @CreatedBy ,@LastModifiedBy (JDBC Audit 기능) 사용할 방법?
    public void updateProduct(Long id,ProductDto.ProductUpdateRequest request, CustomUser user){

        // RDB 작업
        update(id,request);

        ProductChanged productChanged = ProductChanged.builder()
                .productId(id)
                .productStock(request.getStock())
                .productName(request.getName())
                .build();

        // TODO mapper bean 으로 만드는 class 생성
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String json = "";
        try {
            json = mapper.writeValueAsString(productChanged);
        } catch (JsonProcessingException e){
            throw new Exception500("JSON format exception");
        }

        MessageChannel outputChannel = processor.output();

        outputChannel.send(MessageBuilder
                .withPayload(json)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

    @Transactional
    private void update(Long id,ProductDto.ProductUpdateRequest update){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        int affected = productRepository.updateProduct(update.getName(),update.getStock(),id);
    }


    @Transactional
    public void deleteById(Long id,CustomUser user){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        productRepository.deleteById(id);
    }


}
