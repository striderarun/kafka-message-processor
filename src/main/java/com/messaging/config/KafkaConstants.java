package com.messaging.config;

public final class KafkaConstants {

    public static final String TOPIC = "striderTopic";
    public static final String GROUP = "striderGroup";
    public static final String BROKERS= "localhost:9092";

    public static final String SERIALIZER= "org.apache.kafka.common.serialization.ByteArraySerializer";
    public static final String DESERIALIZER= "org.apache.kafka.common.serialization.ByteArrayDeserializer";

    public static final int WORKERS= 15;

}
