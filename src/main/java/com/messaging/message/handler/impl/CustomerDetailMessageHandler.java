package com.messaging.message.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messaging.message.handler.MessageHandler;
import com.messaging.payload.CustomerDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;

@Component
public class CustomerDetailMessageHandler implements MessageHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailMessageHandler.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleMessage(byte[] message) {
        try {
            CustomerDetail customerDetail = objectMapper.readValue(message, CustomerDetail.class);
            LOGGER.info(MessageFormat.format("Processed Customer with ID: {0}", customerDetail.getAccountId()));
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
