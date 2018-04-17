package com.messaging.message.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messaging.message.handler.MessageHandler;
import com.messaging.payload.ProductDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;

@Component
public class ProductDetailMessageHandler implements MessageHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailMessageHandler.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleMessage(byte[] message) {
        try {
            ProductDetail productDetail = objectMapper.readValue(message, ProductDetail.class);
            LOGGER.info(MessageFormat.format("Processed Product with ID: {0}", productDetail.getId()));
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
