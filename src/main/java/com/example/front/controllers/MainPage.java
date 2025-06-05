package com.example.front.controllers;

import com.example.front.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainPage {

    @FXML
    private void becameClient() throws IOException {
        App.switchScene("clientCreate.fxml","Создание клиента");
    }

    @FXML
    public void toDepo() throws IOException {
        App.switchScene("createDeposit.fxml","Создание депозита");
    }

    @FXML
    public void toLookDepo(ActionEvent actionEvent) throws IOException {
        App.switchScene("allDeposites.fxml","Все депозиты");
    }

    @FXML
    public void toEditUser() throws IOException {
        App.switchScene("editUser.fxml","Изменение пользователя");
    }

    @FXML
    public void toEditClient() throws IOException {
        App.switchScene("editClient.fxml","Изменение пользователя");
    }

    @FXML
    public void createReport() throws IOException {
        App.switchScene("createReport.fxml","Создание отчёта");
    }
}
