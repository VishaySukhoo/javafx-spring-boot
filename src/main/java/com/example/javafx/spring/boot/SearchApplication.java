package com.example.javafx.spring.boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class SearchApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        Create and populate stage with ui components
        URL resource = SearchApplication.class.getResource("/SearchController.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);

        scene.getStylesheets().add("/search.css");

        stage.setTitle("Search Users");
        stage.setScene(scene);
        stage.show();
    }
}
