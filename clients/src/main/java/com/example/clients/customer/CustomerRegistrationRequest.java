package com.example.clients.customer;

public record CustomerRegistrationRequest(
        String firstName, String lastName, String email
) {
}
