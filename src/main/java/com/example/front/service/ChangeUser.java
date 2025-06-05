package com.example.front.service;

import com.example.front.dto.AuthMessage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChangeUser {
    public String changeUser(String username,String newPassword,String newFullName,String newUsername,
                             String newRole) throws IOException, InterruptedException {
        String requestBody = String.format(
                "{" +
                        "\"username\": \"%s\"," +
                        "\"newPassword\": \"%s\"," +
                        "\"newFullName\": \"%s\"," +
                        "\"newUsername\": \"%s\"," +
                        "\"newRole\": \"%s\"" +
                        "}",
                username,
                newPassword,
                newFullName,
                newUsername,
                newRole
        );


        AuthMessage authMessage = new AuthMessage();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/user/edit"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authMessage.getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
