package com.example.front.service;

import com.example.front.dto.AuthMessage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CreateReportService {
    public String getReport(String period) throws IOException, InterruptedException {
        AuthMessage authMessage = new AuthMessage();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/admin/depo/report?period=" + period)) // <-- добавили параметр
                .header("Authorization", "Bearer " + authMessage.getToken())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
