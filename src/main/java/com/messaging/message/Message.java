package com.messaging.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Immutable class representing a message and type.
 */
public final class Message implements SerializableMessage {

    private static final long serialVersionUID = 31L;

    private final byte[] message;
    private final MessageType type;

    @JsonCreator
    public Message(@JsonProperty("message") byte[] message, @JsonProperty("type") MessageType type) {
        this.message = message;
        this.type = type;
    }

    public byte[] getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }
}
