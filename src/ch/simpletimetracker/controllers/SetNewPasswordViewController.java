package ch.simpletimetracker.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SetNewPasswordViewController implements IController{
    FXMLLoader loader = null;
    @FXML
    private Button loginButton;
    @FXML
    private Button discardButton;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField repeatNewPassword;


    @Override
    public void getView(Stage stage) throws IOException {
        URL url = getClass().getClassLoader().getResource("fxml/SetPasswordView.fxml");
        loader = new FXMLLoader(url);
        Parent setNewPasswordViewController = loader.load();
        stage.setTitle("Welcome to SimpleTimeTracker");
        stage.setScene(new Scene(setNewPasswordViewController));
    }

    @Override
    public Object getController() throws IOException {
        return null;
    }

    /**
     * Login action
     */
    public void onSaveButton() throws IOException {
        saveNewPassword();


        //TODO test login:password validity
        Stage stage = new Stage();
        MainViewController mainViewController = new MainViewController();
        mainViewController.getView(stage);
        stage.show();
        //Button.getScene().getWindow().getOnCloseRequest();
        //stage.close();
    }

    private void saveNewPassword() {
        String plain = null;
        plain = newPassword.getText();
        System.out.println(plain);
        System.out.println(repeatNewPassword.getText());
    }


    /**
     * discard action
     */
    public void onDiscardButton() {
        Stage stage = new Stage();
        stage = (Stage) discardButton.getScene().getWindow();
        stage.close();

    }
}
