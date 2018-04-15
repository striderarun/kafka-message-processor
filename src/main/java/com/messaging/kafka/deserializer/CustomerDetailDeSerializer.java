package com.messaging.kafka.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messaging.payload.CustomerDetail;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CustomerDetailDeSerializer implements Deserializer<CustomerDetail> {

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {

    }

    @Override
    public CustomerDetail deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDetail user = null;
        try {
            user = mapper.readValue(arg1, CustomerDetail.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return user;
    }

}
