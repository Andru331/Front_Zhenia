package com.example.front.dto;

public class UserInfo {
    private static String username;
    private static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        UserInfo.role = role;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserInfo.username = username;
    }
}
