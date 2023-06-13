# 04-kafka-streams.md

### 1. docker-compose for Kafka
- [docker-compose 로 Kafka, Zookeeper 설치](etc/kafka-docker-compose.yml)

docker-compose 로 Kafka , Zookeeper 를 설치합니다. (Local PC Test 용도) 
사전에 docker-compose 가 설치돼있어야합니다.

```shell
# docker-compose command
docker-compose -f kafka-docker-compose.yml up -d
```

### 2. Kafka shell example
- [Kafka Command Example](etc/kafka-command-example.sh)  

위 파일에서는 Topic , Message 관리 Command 를 간단히 소개합니다.


### 3. Why Kafka Streams?
1) [Kafka 공식 문서 - Kafka Streams 란](https://kafka.apache.org/26/documentation/streams/core-concepts)
1) [java example - Kafka Streams VS Kafka Consumer](https://www.baeldung.com/java-kafka-streams-vs-kafka-consumer)
2) [kafka Consumer api vs Streams api](https://stackoverflow.com/questions/44014975/kafka-consumer-api-vs-streams-api)

  
Kafka Streams 는 Kafka 에 저장된 데이터를 처리하고 분석하기 위한 클라이언트 라이브러리이다.  

Kafka (pub/sub) 방식으로 데이터 변환 작업을 개발할경우 application 개발자가 전부 코딩으로 구현해야하지만,  
Kafka Streams 로 구현할 경우  ```group By, count, filter, join, aggregate``` 등 스트림 프로세싱 API 제공하기 때문에 더 빠르고 편리하게 개발을 진행할 수 있다.  





### 4. spring cloud stream 용어 및 개념
- [Spring 공식 문서 - Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream-binder-kafka/spring-cloud-stream-binder-kafka.html#_kafka_binder_properties)

Spring Cloud Stream 은 Spring Cloud 에서 제공하는 메시징 시스템 프레임워크이다.

RabbitMQ, Apache Kafka, Kafka Streams, Amazon Kinesis 등 다양한 binder 를 제공하고 있다.


- **바인더 (Binder)**
  - 외부 메시징 시스템과의 통합을 제공하는 구성 요소
- **바인딩 (Binding)**
  - 외부 메시징 시스템과 최종 사용자가 제공하는 애플리케이션 코드(생산자/소비자) 사이를 연결한다.
- **메시지**
  - 생산자와 소비자가 대상 바인더(및 외부 메시징 시스템을 통한 다른 응용 프로그램)와 통신하기 위해 사용하는 표준 데이터 구조
- 

### 5. application.yml (Spring Cloud Stream Kafka)
[Spring 공식문서 - application.yml 속성](https://cloud.spring.io/spring-cloud-stream-binder-kafka/spring-cloud-stream-binder-kafka.html)

```yaml
spring:
  cloud:
    stream:
      kafka:
        binder:
          brokers: localhost:9092
      bindings:
        input:
          group: product
          destination: order
          contentType: application/json # 인바운드 역직렬화
        output:
          destination: order
          contentType: application/json # 아웃바운드 직렬화
```
- spring.cloud.stream.kafka.binder.brokers
  - Kafka 바인더가 연결되는 브로커 목록
- spring.cloud.stream.bindings.output.contentType: application/json
  - 기본 인코딩이 비활성화된 경우(기본값) 프레임워크는 사용자가 설정한 contentType을 사용하여 메시지를 변환

### 6. 해당 프로젝트에서 사용한 sample code flow
1. ChangeProductEvent > product 정보 변경시 event 발생







