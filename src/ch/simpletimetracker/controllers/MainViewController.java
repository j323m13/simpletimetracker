package ch.simpletimetracker.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainViewController implements IController{
    FXMLLoader loader = null;
    @FXML ChoiceBox<String> categoryCombo;

    @FXML
    TextArea textAreaRemarks;
    @FXML
    TextField dateTimeField;

    /**
     * Initialize the mainview
     * @param url JavaFx parameter
     * @param resourceBundle JavaFx parameter
     */

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateTime();

    }



        private void setDateTime(){
        dateTimeField.setText(getDateAndTime());
    }


    /**
     * Create a comebox menu
     */
    public void createCombo(){
        ObservableList<String> options = FXCollections.observableArrayList(
                "Social",
                "Business",
                "Shopping",
                "Productivity",
                "Entertainment",
                "Family",
                "Health",
                "Other"
        );
        categoryCombo.setItems(options);
        categoryCombo.setValue(options.get(1));
    }



    public String getDateAndTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formaterForDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateTime.format(formaterForDateTime);
        return formattedDate;
    }

    /**
     * This method provides the loader and the stage
     * @param stage The stage to show
     * @throws IOException if loader or stage icon or stage is null
     */
    @Override
    public void getView(Stage stage) throws IOException {
        URL url = getClass().getClassLoader().getResource("fxml/MainView.fxml");
        loader = new FXMLLoader(url);
        Parent mainViewController = loader.load();
        MainViewController controller = loader.getController();
        controller.createCombo();
        controller.setDateTime();
        stage.setTitle("Welcome to SimpleTimeTracker");
        //stage.getIcons().add(new Image("logo3.png"));
        //stage.setScene(new Scene(loginViewController, 552, 371));
        stage.setScene(new Scene(mainViewController));

    }

    @Override
    public Object getController() throws IOException {
        return loader.getController();
    }

    public void onSaveStop(ActionEvent actionEvent) {
        String date = null;
        String time = null;
        date = dateTimeField.getText(0,9);
        time = dateTimeField.getText(11,18);

        System.out.println(date+"--"+time+"--"+categoryCombo.getValue()+"--"+textAreaRemarks.getText());
    }



}
