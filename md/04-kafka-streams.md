# 04-kafka-streams.md

### 1. docker-compose for Kafka
- [docker-compose 로 Kafka, Zookeeper 설치](etc/kafka-docker-compose.yml)
docker-compose 로 Kafka , Zookeeper 를 설치합니다. (Local PC Test 용도) 

### 2. Kafka shell example
- [Kafka Command Example](etc/kafka-command-example.sh)
위 파일에서는 Topic , Message 관리 Command 를 간단히 소개합니다.


### 3. why Kafka Streams?
-[참고 java-kafka-streams-vs-kafka-consumer](https://www.baeldung.com/java-kafka-streams-vs-kafka-consumer)
-[참고 kafka-consumer-api-vs-streams-api](https://stackoverflow.com/questions/44014975/kafka-consumer-api-vs-streams-api)

### 4. spring cloud stream
- [참고](https://cloud.spring.io/spring-cloud-stream-binder-kafka/spring-cloud-stream-binder-kafka.html#_kafka_binder_properties)

- **바인더**: 외부 메시징 시스템과의 통합을 제공하는 구성 요소입니다.
- **바인딩**: 외부 메시징 시스템과 최종 사용자가 제공하는 애플리케이션 코드(생산자/소비자) 사이를 연결합니다.
- **메시지**: 생산자와 소비자가 대상 바인더(및 외부 메시징 시스템을 통한 다른 응용 프로그램)와 통신하기 위해 사용하는 표준 데이터 구조입니다.

### 5. application.yml

-------
### Order OrderItem Product 

1. createOrder > product 재고 감소    >> C
2. completeOrder > orderState 변경   >> U
3. cancleOrder > product 재고 보상    >> U
   (order > delete X)

kafka topic
1. product  Stock
2. order    State






