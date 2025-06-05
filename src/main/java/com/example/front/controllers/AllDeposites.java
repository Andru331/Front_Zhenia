package com.example.front.controllers;

import com.example.front.App;
import com.example.front.dto.Deposit;
import com.example.front.service.getDeposites;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AllDeposites {

    @FXML
    public TextField username;
    @FXML
    public TableView<Deposit> deposites;
    @FXML
    public TableColumn<Deposit, String> clienName;
    @FXML
    public TableColumn<Deposit, String> type;
    @FXML
    public TableColumn<Deposit, String> depoOpenDate;
    @FXML
    public TableColumn<Deposit, String> depoCloseDate;
    @FXML
    public TableColumn<Deposit, BigDecimal> balance;

    @FXML
    public void getDepo() throws IOException, InterruptedException {
        getDeposites d = new getDeposites();
        String response = d.getDepo(username.getText());
        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response);

        JsonNode depositsNode = rootNode.get("allDeposits");
        List<Deposit> depositList = Arrays.asList(mapper.treeToValue(depositsNode, Deposit[].class));
        deposites.setItems(FXCollections.observableArrayList(depositList));
    }

    @FXML
    public void initialize() {
        clienName.setCellValueFactory(new PropertyValueFactory<>("clienName"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        depoOpenDate.setCellValueFactory(new PropertyValueFactory<>("depoOpenDate"));
        depoCloseDate.setCellValueFactory(new PropertyValueFactory<>("depoCloseDate"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
    }

    @FXML
    public void toMenu() throws IOException {
        App.switchScene("mainPage.fxml","Главная страница");
    }
}
