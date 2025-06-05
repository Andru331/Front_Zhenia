package com.example.front.controllers;

import com.example.front.App;
import com.example.front.service.CreateDepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigDecimal;

public class CreateDeposit {
    int depoTypeId;

    @FXML
    public TextField depoSum;
    @FXML
    public ComboBox<String> depoType;

    @FXML
    public void initialize() {
        depoType.getItems().addAll("До востребования", "Срочный вклад","Сберегательный вклад");
    }



    @FXML
    public void createDepo() throws IOException, InterruptedException {
        BigDecimal depoSum = new BigDecimal(this.depoSum.getText());
        CreateDepo createDepo = new CreateDepo();

        if(depoType.getValue().equals("До востребования")){
            depoTypeId = 1;
        }
        if(depoType.getValue().equals("Срочный вклад")){
            depoTypeId = 2;
        }
        if(depoType.getValue().equals("Сберегательный вклад")){
            depoTypeId = 3;
        }

        String response = createDepo.createDepo(depoSum,depoTypeId);
        System.out.println(response);
    }

    @FXML
    public void toMenu() throws IOException {
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
