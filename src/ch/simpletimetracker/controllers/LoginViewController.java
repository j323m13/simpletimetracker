package ch.simpletimetracker.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginViewController implements IController{
    FXMLLoader loader = null;




    /**
     * This method provides the loader and the stage
     * @param stage The stage to show
     * @throws IOException if loader or stageicon or stage is null
     */

    @Override
    public void getView(Stage stage) throws IOException {
        URL url = getClass().getClassLoader().getResource("resources/fxml/simpleTimeTracker.fxml");
        loader = new FXMLLoader(url);
        Parent loginViewController = loader.load();
        //stage stage = new Stage();
        stage.setTitle("Welcome to SimpleTimeTracker");
        //stage.getIcons().add(new Image("logo3.png"));
        stage.setScene(new Scene(loginViewController, 552, 371));

    }

    @Override
    public Object getController() throws IOException {
        return loader.getController();
    }


}
