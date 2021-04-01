package ch.simpletimetracker.controllers;

import ch.simpletimetracker.dao.DatabaseEntryDao;
import ch.simpletimetracker.databaseEntry.DatabaseEntry;
import ch.simpletimetracker.utils.OSBasedAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    @FXML private javafx.scene.control.TableView<DatabaseEntry> profileTable;
    @FXML private TableColumn<DatabaseEntry, String> idColumn;
    @FXML private TableColumn<DatabaseEntry, String> dateColumn;
    @FXML private TableColumn<DatabaseEntry, String> timeColumn;
    @FXML private TableColumn<DatabaseEntry, String> categoryColumn;
    @FXML private TableColumn<DatabaseEntry, String> noteColumn;
    DatabaseEntryDao mainViewHelper = new DatabaseEntryDao();
    @FXML private final ObservableList<DatabaseEntry> databaseEntries = FXCollections.observableArrayList();



    /**
     * Initialize the mainview
     * @param url JavaFx parameter
     * @param resourceBundle JavaFx parameter
     */

    public void initialize(URL url, ResourceBundle resourceBundle) throws ClassNotFoundException, SQLException, InterruptedException, IOException {
        System.out.println("inititialize");
        setupTableView();

    }

    private void setupTableView() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
        ObservableList<DatabaseEntry> databaseEntries = FXCollections.observableArrayList();
        setDateTime();
        loadDatabaseEntries(databaseEntries);
    }

    private void loadDatabaseEntries(ObservableList<DatabaseEntry> databaseEntries) throws ClassNotFoundException, SQLException, InterruptedException, IOException {
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("creationDate")
        );
        timeColumn.setCellValueFactory(
                new PropertyValueFactory<>("time")
        );
        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );
        noteColumn.setCellValueFactory(
                new PropertyValueFactory<>("note")
        );
        ObservableList<DatabaseEntry> entries = mainViewHelper.getAll();
        databaseEntries.clear();
        databaseEntries.addAll(entries);
        populateTableView(databaseEntries);

    }

    private void populateTableView(ObservableList<DatabaseEntry> entries) {
        System.out.println("checking databaseEntries size before profileTableView");
        System.out.println(entries.size());
        OSBasedAction helper = new OSBasedAction();
        for (int l = 0; l<databaseEntries.size();l++){
            helper.printDatabaseEntryObject(databaseEntries.get(l));
        }
        profileTable.setItems(entries);
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

    public void onSaveStop(ActionEvent actionEvent) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        String date = null;
        String time = null;
        String category = null;
        String remarks = null;
        setDateTime();
        date = dateTimeField.getText(0,10);
        time = dateTimeField.getText(11,19);
        category = categoryCombo.getValue();
        remarks = textAreaRemarks.getText();

        System.out.println(date+"--"+time+"--"+category+"--"+remarks);

        DatabaseEntryDao save = new DatabaseEntryDao();
        DatabaseEntry entry = new DatabaseEntry();
        entry.setCreationDate(date);
        entry.setTime(time);
        entry.setCategory(category);
        entry.setNote(remarks);
        save.save(entry);
        reloadMainView(databaseEntries);
    }

    @FXML
    private void reloadMainView(ObservableList<DatabaseEntry> databaseEntries) throws ClassNotFoundException, SQLException, InterruptedException, IOException {
        loadDatabaseEntries(databaseEntries);
    }



}
