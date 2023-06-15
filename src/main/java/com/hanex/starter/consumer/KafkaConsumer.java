package com.hanex.starter.consumer;

import com.hanex.starter.product.event.ProductChanged;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Slf4j
@Configuration
public class KafkaConsumer {

    @Bean
    Consumer<Message<ProductChanged>> productUpdate() {
        log.info("KafkaConsumer >  productUpdate ----------------------------------------------------------");


        return ((input) ->{
           try {

               log.info(input.getHeaders().toString());
               log.info(String.valueOf(input.getPayload()));
               Acknowledgment acknowledgment = input.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
               if(acknowledgment != null){
                   acknowledgment.acknowledge();
               }
               log.info("KafkaConsumer >  productUpdateEvent ----------------------------------------------------------");
           }catch (Exception e){
               e.printStackTrace();
           }
        });

    }


//    @StreamListener(StreamProcessor.INPUT)
//    public void productChanged(@Payload ProductChanged productChanged){
//        try {
//            log.info("productChanged StreamListener : {}", new CustomObjectMapper().writeValueAsString(productChanged));
//        } catch (Exception e){
//            log.error("json parse error {}",e);
//        }
//    }

//    @Bean
//    public Consumer<Message> productUpdateEvent(){
//        return message -> log.info("product Change Consume :: {}",message);
//    }
}
