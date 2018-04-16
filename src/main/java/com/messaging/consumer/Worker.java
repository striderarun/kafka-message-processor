package com.messaging.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messaging.message.Message;
import com.messaging.message.handler.MessageHandler;
import com.messaging.message.handler.MessageHandlerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;

import static com.messaging.config.KafkaConstants.TOPIC;

@Component
@Scope("prototype")
public class Worker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private KafkaConsumer<byte[], byte[]> kafkaConsumer;

    @Autowired
    private MessageHandlerFactory messageHandlerFactory;

    public void run() {
        LOGGER.info("Worker Thread instantiated: " + Thread.currentThread().getName());
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
        while (true) {
            ConsumerRecords<byte[], byte[]> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<byte[], byte[]> record : records) {
                LOGGER.info(MessageFormat.format("Received message: {0}, Partition: {1}, Offset: {2}, ThreadID: {3}",
                        record.value(), record.partition(), record.offset(), Thread.currentThread().getName()));
                try {
                    Message message = objectMapper.readValue(record.value(), Message.class);
                    MessageHandler messageHandler = messageHandlerFactory.getMessageHandler(message.getType());
                    messageHandler.handleMessage(message.getMessage());
                } catch (IOException exception) {
                   LOGGER.error(exception.getMessage());
                } catch (Exception exception) {
                    LOGGER.error(exception.getMessage());
                }
            }
        }

    }


}