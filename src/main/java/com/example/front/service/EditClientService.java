package com.example.front.service;

import com.example.front.dto.AuthMessage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class EditClientService {
    public String changeClient(String PassportNumber, Date birthDate, String phone, String email,
                               String address) throws IOException, InterruptedException {
        String requestBody = String.format(
                "{" +
                        "\"PassportNumber\": \"%s\"," +
                        "\"birthDate\": \"%s\"," +
                        "\"phone\": \"%s\"," +
                        "\"email\": \"%s\"," +
                        "\"address\": \"%s\"" +
                        "}",
                PassportNumber,
                new SimpleDateFormat("yyyy-MM-dd").format(birthDate),
                phone,
                email,
                address
        );


        AuthMessage authMessage = new AuthMessage();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/clients/edit"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authMessage.getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
