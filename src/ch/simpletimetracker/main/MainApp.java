package src.ch.simpletimetracker.main;


import java.io.IOException;
import java.sql.SQLException;

/**
 * This class calls the class Main.class. We use it to create the jar-file.
 */
public class MainApp {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        src.ch.simpletimetracker.main.Main.main(args);
    }
}