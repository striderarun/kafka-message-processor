package com.messaging.message.handler;

import com.messaging.message.MessageType;
import com.messaging.message.handler.impl.CustomerDetailMessageHandler;
import com.messaging.message.handler.impl.ProductDetailMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class MessageHandlerFactory {

    @Autowired
    private CustomerDetailMessageHandler customerDetailMessageHandler;

    @Autowired
    private ProductDetailMessageHandler productDetailMessageHandler;

    public final MessageHandler getMessageHandler(MessageType messageType) {
        switch (messageType) {
            case PRODUCT: {
                return productDetailMessageHandler;
            }
            case CUSTOMER:{
                return customerDetailMessageHandler;
            }
            default: {
                throw new IllegalArgumentException("Invalid message type");
            }
        }
    }
}
