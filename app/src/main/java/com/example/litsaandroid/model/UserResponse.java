package com.example.litsaandroid.model;

public class UserResponse {
    private static String token;

    public static String getToken() {
        return token;
    }

    public void setToken(String token) {
        UserResponse.token = token;
    }

    public UserResponse() {
    }
}
