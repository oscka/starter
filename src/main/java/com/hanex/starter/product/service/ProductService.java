package com.hanex.starter.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanex.starter.common.exception.Exception400;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.common.exception.Exception500;
import com.hanex.starter.common.security.CustomUser;
import com.hanex.starter.product.domain.Product;
import com.hanex.starter.product.dto.ProductDto;
import com.hanex.starter.product.event.ProductChangeEvent;
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
    public ProductDto.ProductInfoResponse findProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        return product.toDto();
    }

    @Transactional
    public void createProduct(ProductDto.SaveRequest request, CustomUser user){
        Product product = productRepository.save(request.toEntity(user));
    }


    @Transactional
    public void updateProduct(Long id,ProductDto.UpdateRequest update,CustomUser user){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        productRepository.updateProduct(update.getName(),update.getStock(),id);

        ProductChangeEvent productChanged = ProductChangeEvent.builder()
                .productId(product.getId())
                .productStock(product.getStock())
                .productName(product.getName())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(productChanged);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception500("JSON format exception");
        }

        MessageChannel outputChannel = processor.output();
        outputChannel.send(MessageBuilder
                .withPayload(json)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

        log.info(json);
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
