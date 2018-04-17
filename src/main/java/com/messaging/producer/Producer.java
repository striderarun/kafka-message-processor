package com.messaging.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.messaging.message.Message;
import com.messaging.message.MessageType;
import com.messaging.message.SerializableMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.messaging.config.KafkaConstants.TOPIC;

@Component
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaProducer<byte[], byte[]> kafkaProducer;

    public void produceMessage(SerializableMessage messageObject, MessageType messageType) {
        try {
            Message message = new Message(messageObject.toBytes(messageObject), messageType);
            kafkaProducer.send(new ProducerRecord<>(TOPIC, message.toBytes(message)));
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }

    }
}
