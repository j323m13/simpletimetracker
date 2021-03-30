package ch.simpletimetracker.dao;


import ch.simpletimetracker.databaseEntry.DatabaseEntry;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * The interface for DAO pattern
 * @author Jérémie Equey
 */
 interface Dao {
    default List<DatabaseEntry> getAll() throws SQLException, ClassNotFoundException, InterruptedException, IOException {
        return null;
    }

    void save(DatabaseEntry databaseEntry) throws SQLException, ClassNotFoundException, InterruptedException;
    void update(DatabaseEntry databaseEntry) throws SQLException, ClassNotFoundException;
    void delete(DatabaseEntry databaseEntry) throws SQLException, ClassNotFoundException;
    void deleteAccount() throws SQLException, InterruptedException;
    void setup() throws SQLException, InterruptedException, ClassNotFoundException;
    void connect() throws SQLException;
    void disconnect() throws SQLException;
}