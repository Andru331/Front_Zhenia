package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.ChangeUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditUser {
    @FXML
    public TextField username;
    @FXML
    public TextField newPassword;
    @FXML
    public TextField newFullName;
    @FXML
    public TextField newUsername;
    @FXML
    public ComboBox<String> newRole;

    @FXML
    public void initialize() {
        newRole.getItems().addAll("USER", "ADMIN");
    }

    @FXML
    public void coomitChanges() throws IOException, InterruptedException {
        ChangeUser changeUser = new ChangeUser();
        String response = changeUser.changeUser(username.getText(),newPassword.getText(),newFullName.getText(),
                newUsername.getText(),newRole.getValue());
        System.out.println(response);
    }

    @FXML
    public void toMain() throws IOException {
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
