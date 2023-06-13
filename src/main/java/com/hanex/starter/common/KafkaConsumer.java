package com.hanex.starter.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanex.starter.product.event.ProductChanged;
import com.hanex.starter.product.event.StreamProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaConsumer {

    @StreamListener(StreamProcessor.INPUT)
    public void productChanged(@Payload ProductChanged productChanged){

        try {
            ObjectMapper mapper = new ObjectMapper();
            log.info("productChanged StreamListener : {}",mapper.writeValueAsString(productChanged));
        } catch (JsonProcessingException e){
            log.error("json parse error {}",e);
        }

    }

//    @Bean
//    public Consumer<Message> productChangeConsume(){
//        return message -> log.info("product Change Consume :: {}",message);
//    }
}
