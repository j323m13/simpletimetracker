package ch.simpletimetracker.controllers;


import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;


public interface IController<T> {
    FXMLLoader loader = null;

    void getView(Stage stage) throws IOException;
    T getController() throws IOException;
}

