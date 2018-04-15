package com.messaging.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.messaging.config.KafkaConstants.BROKERS;
import static com.messaging.config.KafkaConstants.DESERIALIZER;
import static com.messaging.config.KafkaConstants.GROUP;
import static com.messaging.config.KafkaConstants.SERIALIZER;

@Configuration
@ComponentScan("com.messaging")
public class KafkaConfig {

    @Bean
    public KafkaProducer<byte[], byte[]> kafkaProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", BROKERS);
        properties.put("key.serializer", SERIALIZER);
        properties.put("value.serializer", SERIALIZER);
        properties.put("acks", "all");
        return new KafkaProducer<>(properties);
    }

    @Bean
    public KafkaConsumer<byte[], byte[]> kafkaConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", BROKERS);
        properties.put("group.id", GROUP);
        properties.put("key.deserializer", DESERIALIZER);
        properties.put("value.deserializer", DESERIALIZER);
        return new KafkaConsumer<>(properties);
    }

}
