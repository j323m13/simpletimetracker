package ch.simpletimetracker.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginViewController implements IController{
    FXMLLoader loader = null;
    @FXML
    private Button saveButton;
    @FXML
    private Button discardButton;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;



    /**
     * This method provides the loader and the stage
     * @param stage The stage to show
     * @throws IOException if loader or stageicon or stage is null
     */

    @Override
    public void getView(Stage stage) throws IOException {
        URL url = getClass().getClassLoader().getResource("fxml/LoginView.fxml");
        loader = new FXMLLoader(url);
        Parent loginViewController = loader.load();
        //stage stage = new Stage();
        stage.setTitle("Welcome to SimpleTimeTracker");
        //stage.getIcons().add(new Image("logo3.png"));
        //stage.setScene(new Scene(loginViewController, 552, 371));
        stage.setScene(new Scene(loginViewController));

    }

    @Override
    public Object getController() throws IOException {
        return loader.getController();
    }

    /**
     * Login action
     */
    public void onLoginButton() throws IOException {
        //TODO test login:password validity
        checkLoginInformation(emailField.getText(),passwordField.getText());
        Stage stage = new Stage();
        stage.close();
        MainViewController mainViewController = new MainViewController();
        mainViewController.getView(stage);
        stage.show();
        //TODO close windows on successful login

    }

    private void checkLoginInformation(String email, String password) {
        System.out.println(email+", "+password);
    }


    /**
     * discard action
     */
    public void onDiscardButton() {
        System.exit(0);
    }


    public void onSetNewPassword(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        SetNewPasswordViewController setNewPasswordViewController = new SetNewPasswordViewController();
        setNewPasswordViewController.getView(stage);
        stage.showAndWait();

    }


}
