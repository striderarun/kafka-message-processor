package com.messaging.payload;

public final class CustomerDetail {

    private final String accountId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public CustomerDetail(String accountId, String firstName, String lastName, String email, String phone) {
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
