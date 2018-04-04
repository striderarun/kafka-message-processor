package com.messaging.message.handler;

/**
 * Interface for processing messages.
 */
public interface MessageHandler {

    void handleMessage(byte[] message);
}
