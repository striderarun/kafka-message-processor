package com.messaging.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.messaging.message.SerializableMessage;

import java.io.Serializable;

/**
 * An Immutable class which represents some data to be processed in the system.
 */
public final class ProductDetail implements SerializableMessage {

    private static final long serialVersionUID = 31L;

    private final String id;
    private final String name;
    private final String category;
    private final Integer cost;

    @JsonCreator
    public ProductDetail(@JsonProperty("id") String id,
                         @JsonProperty("name") String name,
                         @JsonProperty("category") String category,
                         @JsonProperty("cost") Integer cost) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getCost() {
        return cost;
    }
}
