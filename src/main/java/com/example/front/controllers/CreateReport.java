package com.example.front.controllers;

import com.example.front.App;
import com.example.front.dto.Report;
import com.example.front.service.CreateReportService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CreateReport {

    private final CreateReportService createReportService = new CreateReportService();
    private final ObjectMapper mapper = new ObjectMapper();

    @FXML private TableView<Report> reportTable;
    @FXML private TableColumn<Report, String> depoCodeCol;
    @FXML private TableColumn<Report, String> passportCol;
    @FXML private TableColumn<Report, String> typeCol;
    @FXML private TableColumn<Report, String> openDateCol;
    @FXML private TableColumn<Report, String> closeDateCol;
    @FXML private TableColumn<Report, BigDecimal> balanceCol;
    @FXML private TableColumn<Report, BigDecimal> accruedCol;
    @FXML private TableColumn<Report, BigDecimal> totalCol;

    @FXML
    public void yearReport() throws IOException, InterruptedException {
        loadReport("year");
    }

    @FXML
    public void monthReport() throws IOException, InterruptedException {
        loadReport("month");
    }

    private void loadReport(String period) throws IOException, InterruptedException {
        String response = createReportService.getReport(period);
        System.out.println(response);

        JsonNode rootNode = mapper.readTree(response);
        JsonNode reportArray = rootNode.get("reportResponseDTOList");

        List<Report> reports = Arrays.asList(mapper.treeToValue(reportArray, Report[].class));
        setupColumns();
        reportTable.setItems(FXCollections.observableArrayList(reports));
    }

    private void setupColumns() {
        depoCodeCol.setCellValueFactory(new PropertyValueFactory<>("depoCode"));
        passportCol.setCellValueFactory(new PropertyValueFactory<>("clientPassport"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("depositType"));
        openDateCol.setCellValueFactory(new PropertyValueFactory<>("openDate"));
        closeDateCol.setCellValueFactory(new PropertyValueFactory<>("closeDate"));
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        accruedCol.setCellValueFactory(new PropertyValueFactory<>("totalAccrued"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalTransactions"));
    }

    @FXML
    public void toMenu() throws IOException {
        App.switchScene("mainPage.fxml","Главная станица");
    }
}
