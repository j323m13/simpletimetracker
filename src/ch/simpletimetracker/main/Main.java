package ch.simpletimetracker.main;


import ch.simpletimetracker.controllers.LoginViewController;
import ch.simpletimetracker.utils.OSBasedAction;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application{

    public void start(Stage stage) throws Exception {

        //check user lang and country variable. pass the result to DBConnegit ction
        OSBasedAction helper = new OSBasedAction();
        helper.setLocalValue();
        /*
         loginViewController lvc = new loginViewController();
        lvc.getView(stage);
         */
        LoginViewController loginViewController = new LoginViewController();
        loginViewController.getView(stage);

        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        launch(args);
    }

}