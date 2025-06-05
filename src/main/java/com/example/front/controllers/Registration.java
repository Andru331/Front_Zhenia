package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.RegService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Registration {
    private final RegService regService = new RegService();

    @FXML
    public ComboBox<String> myComboBox;
    @FXML
    public Label errrorMessage;

    @FXML
    public void initialize() {
        myComboBox.getItems().addAll("USER", "ADMIN");
    }

    @FXML
    public TextField login;
    @FXML
    public TextField password;
    @FXML
    public TextField fullname;


    @FXML
    protected void registration() throws IOException, InterruptedException {
        System.out.println(
                regService.userAuth(login.getText(),password.getText(),fullname.getText(),myComboBox.getValue()));
        App.switchScene("authorization.fxml","Авторизация");
    }

    @FXML
    protected void toAuth() throws IOException {
        App.switchScene("authorization.fxml","Авторизация");
    }

}
