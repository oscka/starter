# kafka-command-example.sh
# docker-compose 로 띄운 Kafka 에서 사용하는 간단한 Command

# Create Topic (토픽 생성)
docker exec kafka kafka-topics --create --topic my-topic --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1

# Describe Topic (생성된 토픽 확인)
docker exec kafka kafka-topics --describe --topic my-topic --bootstrap-server kafka:9092

# Remove Topic (토픽 삭제)
docker exec kafka kafka-topics --delete --topic my-topic --bootstrap-server kafka:9092

# Show List Topic (토픽 리스트 확인)
docker exec kafka kafka-topics --list --bootstrap-server kafka:9092

# 컨슈머 실행
## 1) 컨테이너 내부의 쉘로 접속
docker exec -it kafka bash

## 2) 컨슘할 토픽을 지정하고, 브로커를 지정하기 위해서 --bootstrap-server 를 이용
# [appuser@c0715a9c629a ~]$ kafka-console-consumer --topic my-topic --bootstrap-server kafka:9092
kafka-console-consumer --topic my-topic --bootstrap-server kafka:9092

# 프로듀서 실행하기
## 1) 컨테이너 내부의 쉘로 접속
docker exec -it kafka bash
## 2)
kafka-console-producer --topic my-topic --broker-list kafka:9092
## 3) > 가 나오면 write 할 메세지를 적으면 된다.
