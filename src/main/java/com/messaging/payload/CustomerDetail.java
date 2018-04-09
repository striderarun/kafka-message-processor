package com.messaging.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.messaging.message.SerializableMessage;

import java.io.Serializable;

/**
 * An Immutable class which represents some data to be processed in the system.
 */
public final class CustomerDetail implements SerializableMessage {

    private static final long serialVersionUID = 31L;

    private final String accountId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    @JsonCreator
    public CustomerDetail(@JsonProperty("accountId") String accountId,
                          @JsonProperty("firstName") String firstName,
                          @JsonProperty("lastName") String lastName,
                          @JsonProperty("email") String email,
                          @JsonProperty("phone") String phone) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
