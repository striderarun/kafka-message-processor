package com.messaging.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public interface SerializableMessage extends Serializable {

    ObjectMapper objectMapper = new ObjectMapper();

    default byte[] toBytes(SerializableMessage message) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(message);
    }
}
