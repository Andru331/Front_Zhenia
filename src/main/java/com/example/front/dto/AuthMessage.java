package com.example.front.dto;

public class AuthMessage {
    private static String token;
    private static String message;

    public AuthMessage() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        AuthMessage.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        AuthMessage.message = message;
    }
}
