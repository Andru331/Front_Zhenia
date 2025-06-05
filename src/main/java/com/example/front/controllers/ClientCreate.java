package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.ClientCreateService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ClientCreate {

    ClientCreateService clientCreateService = new ClientCreateService();


    @FXML
    public TextField passportNumber;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public TextField address;
    @FXML
    public DatePicker birthDate;

    @FXML
    public void createClient() throws IOException, InterruptedException {
        String response = clientCreateService.createClient(passportNumber.getText(),java.sql.Date.valueOf(birthDate.getValue()),
                phone.getText(),email.getText(),address.getText());
        System.out.println("response");
        System.out.println(response);
    }

    @FXML
    public void backToMenu() throws IOException {
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
