package src.ch.simpletimetracker.main;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.ch.simpletimetracker.utils.OSBasedAction;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class Main extends Application {

    public void start(Stage stage) throws Exception {

        //check user lang and country variable. pass the result to DBConnenction
        OSBasedAction helper = new OSBasedAction();
        helper.setLocalValue();
        /*
         loginViewController lvc = new loginViewController();
        lvc.getView(stage);
         */


        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        launch(args);
    }

}