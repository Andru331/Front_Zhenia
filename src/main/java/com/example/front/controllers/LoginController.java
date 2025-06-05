package com.example.front.controllers;

import com.example.front.App;
import com.example.front.dto.UserInfo;
import com.example.front.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.front.dto.AuthMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private final AuthService regService = new AuthService();

    ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    public Label errorMassege;
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
        UserInfo.setUsername(usernameField.getText());


        String response = regService.userAuth(usernameField.getText(),passwordField.getText());

        AuthMessage authMessage = objectMapper.readValue(response, AuthMessage.class);
        System.out.println(authMessage.getMessage());

        if(authMessage.getMessage().equals("User could not be signed in!") ||
        authMessage.getMessage().equals("Invalid username or password")) {
            System.out.println("User could not be signed in!");
            errorMassege.setVisible(true);
            errorMassege.setText("Username or password is incorrect!");
            return;
        }
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
