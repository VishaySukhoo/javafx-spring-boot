package com.example.javafx.spring.boot.view;


import com.example.javafx.spring.boot.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;

public class SearchController {

    private final ObservableList<User> masterData = FXCollections.observableArrayList();
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Label searchLabel;
    @FXML
    private TableView tableView;
    @FXML
    private VBox dataContainer;

    public SearchController() {
        masterData.add(new User(1, "John", true));
        masterData.add(new User(2, "Wick", true));
        masterData.add(new User(3, "Tim", false));
        masterData.add(new User(4, "Paul", true));
    }

    @FXML
    private void initialize() {
        // search panel
        initSearchButton();
        initSearchField();
        initTable();
    }

    private void initSearchButton() {
        searchButton.setText("Search");
        searchButton.setOnAction(event -> loadData());
        searchButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
    }

    private void initSearchField() {
        searchField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loadData();
            }
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchLabel.setText(newValue);
        });
    }

    private void initTable() {
        tableView = new TableView<>(masterData);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn employed = new TableColumn("EMPLOYED");
        employed.setCellValueFactory(new PropertyValueFactory("isEmployed"));
        tableView.getColumns().addAll(id, name, employed);

        dataContainer.getChildren().add(tableView);
    }

    private void loadData() {

        String searchText = searchField.getText();

        Task<ObservableList<User>> task = new Task<ObservableList<User>>() {
            @Override
            protected ObservableList<User> call() throws Exception {
                updateMessage("Loading data");
                return FXCollections.observableArrayList(masterData
                        .stream()
                        .filter(value -> value.getName().contains(searchText))
                        .collect(Collectors.toList()));
            }
        };


        task.setOnSucceeded(event -> {
            ObservableList<User> results = task.getValue();
            tableView.setItems(results);
        });
//        The Task is Runnable, so to start it we need just to start a new Thread with the task parameter:
        Thread th = new Thread(task);
        th.setDaemon(true); //thread will terminate after finishing the work
        th.start();
    }

}
