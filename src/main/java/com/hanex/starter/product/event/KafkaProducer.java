package com.hanex.starter.product.event;

import com.hanex.starter.common.exception.Exception500;
import com.hanex.starter.common.util.CustomObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

import java.util.UUID;

// @EnableBinding(value= {StreamProcessor.class})
@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducer {
    //private final StreamProcessor processor;

    private final StreamBridge streamBridge;

    public void updateProduct(ProductChanged productChanged){
        try {


            String payload = new CustomObjectMapper().writeValueAsString(productChanged);

            // 방법 1)
//        MessageChannel outputChannel = processor.output();
//        outputChannel.send(MessageBuilder
//                .withPayload(payload)
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build());

            // 방법 2)
            boolean result = streamBridge.send("productUpdate-out-0", MessageBuilder
                .withPayload(productChanged)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build());
            log.info("result : {}",result);

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception500(e.getMessage());
        }
    }
}
