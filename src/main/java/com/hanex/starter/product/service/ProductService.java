package com.hanex.starter.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    public ProductDto.ProductInfoResponse findProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        return product.toDto();
    }

    @Transactional
    public void createProduct(ProductDto.ProductSaveRequest request, CustomUser user){
        productRepository.save(request.toEntity(user));
    }


    @Transactional
    public void updateProduct(Long id,ProductDto.ProductUpdateRequest update, CustomUser user){

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


        try {
            Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
            int affected = productRepository.updateProduct(update.getName(),update.getStock(),id);

            log.info(mapper.writeValueAsString(product));
            log.info("affected : {}",affected);

            ProductChanged productChanged = ProductChanged.builder()
                    .productId(id)
                    .productStock(update.getStock())
                    .productName(update.getName())
                    .build();


            String json = null;
            try {
                json = mapper.writeValueAsString(productChanged);
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
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    @Transactional
    public void deleteById(Long id,CustomUser user){
        Product product = productRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 상품입니다."));
        productRepository.deleteById(id);
    }


}
