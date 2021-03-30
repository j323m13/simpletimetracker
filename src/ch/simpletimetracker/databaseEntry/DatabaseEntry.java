package ch.simpletimetracker.databaseEntry;


import javafx.beans.property.SimpleStringProperty;

/**
 * Data model.
 * @author Jérémie Equey
 */
public class DatabaseEntry {

    private SimpleStringProperty id;
    private SimpleStringProperty username;
    private SimpleStringProperty time;
    private SimpleStringProperty creationDate;
    private SimpleStringProperty lastUpdate;
    private SimpleStringProperty category;
    private SimpleStringProperty note;
    private String dummyId;

    /**
     * empty contructor
     */
    public DatabaseEntry() {
        this.id = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
        this.time = new SimpleStringProperty();
        this.creationDate = new SimpleStringProperty();
        this.lastUpdate = new SimpleStringProperty();
        this.note = new SimpleStringProperty();
        this.category = new SimpleStringProperty();
        dummyId = null;
    }

    /**
     * the contructor
     * @param id an id set by the database
     * @param dummyId the index of all the entries out of the database. it is used to have a better display in tableView
     * @param username username
     * @param creationDate date of creation of the entry (getDateTime() from this class)
     * @param lastUpdate date of last update (first time is the same date as date of creation)
     * @param note a note of the user.
     */
    public DatabaseEntry(String id, String dummyId, String username, String time, String creationDate,
                         String lastUpdate, String note) {
        this.id = new SimpleStringProperty(id);
        this.dummyId = dummyId;
        this.username = new SimpleStringProperty(username);
        this.time = new SimpleStringProperty(time);
        this.creationDate = new SimpleStringProperty(creationDate);
        this.lastUpdate = new SimpleStringProperty(lastUpdate);
        this.note = new SimpleStringProperty(note);

    }


    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(String creationDate) {
        this.creationDate.set(creationDate);
    }

    public String getLastUpdate() {
        return lastUpdate.get();
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate.set(lastUpdate);
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public String getDummyId() {
        return dummyId;
    }

    public void setDummyId(String dummyId) {
        this.dummyId = dummyId;
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        System.out.print(category);
        this.category.set(category.toString());
    }
}