package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.front.dto.AuthMessage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private final AuthService regService = new AuthService();
    ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    public TextField passwordField;
    @FXML
    private TextField usernameField;

    @FXML
    private void toRegistaration() throws IOException {
        App.switchScene("registration.fxml","Регистрация");
    }

    @FXML
    private void onLogin() throws IOException, InterruptedException {
        String response = regService.userAuth(usernameField.getText(),passwordField.getText());
        System.out.println(response);
        AuthMessage authMessage = objectMapper.readValue(response, AuthMessage.class);
        System.out.println(authMessage.getToken());

    }
}
