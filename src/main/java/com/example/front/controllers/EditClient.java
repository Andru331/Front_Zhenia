package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.EditClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditClient {
    @FXML
    public TextField PassportNumber;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public TextField address;
    @FXML
    public DatePicker birthDate;

    @FXML
    public void saveChanges() throws IOException, InterruptedException {
        EditClientService service = new EditClientService();
       String response = service.changeClient(PassportNumber.getText(),java.sql.Date.valueOf(birthDate.getValue()),phone.getText(),
                email.getText(),address.getText());
       System.out.println(response);
    }

    @FXML
    public void onMenu() throws IOException {
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
