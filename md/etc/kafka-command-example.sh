# kafka-command-example.sh

# Run Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Run Kafka
bin/kafka-server-start.sh config/server.properties

# Create Topic
bin/kafka-topics.sh --create --topic coupon --bootstrap-server 127.0.0.1:9092

# Show List Topic
bin/kafka-topics.sh --list --zookeeper localhost:2181

# Describe Topic
bin/kafka-topics.sh --describe --topic coupon --bootstrap-server 127.0.0.1:9092

# Write Message
bin/kafka-console-producer.sh --topic coupon --bootstrap-server 127.0.0.1:9092

# Read Message
bin/kafka-console-consumer.sh --topic coupon --from-beginning --bootstrap-server 127.0.0.1:9092

# Remove Topic
bin/kafka-topics.sh --delete --topic coupon --bootstrap-server 127.0.0.1:9092
