package org.suggestionForm.Model;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager implements DB_Method, DB_Properties, AutoCloseable {
	// SQLITE DB - Variables
	private Statement connStatement;
	private Connection suggestionConnection;

	public DBManager() throws Exception {
		if(!doesDBExist()) {
			doCreateSQLiteDB();
			createTable();
		}
		
		suggestionConnection = DriverManager.getConnection(sqliteURI());
		connStatement = suggestionConnection.createStatement();
	}

	@Override
	public boolean doesDBExist() {
		return Files.exists(Path.of(user_home + db_name));
	}

	@Override
	public boolean doCreateSQLiteDB() {
		try {
			System.out.println("Successfully Created " + Files.createFile(Paths.get(user_home + db_name)));
			return true;

		} catch (FileAlreadyExistsException faee) {
			return true;

		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;	
		}
	}

	/*
	 * 
	 * TABLE CRUD
	 * 
	 */

	@Override
	public boolean createTable() {
		try {
			connStatement.execute("""
						CREATE TABLE IF NOT EXISTS "Suggestions" (
							"Id"			INTEGER,
							"Title"			TEXT NOT NULL,
							"Description"	TEXT,
							"SubmittedDate"	NUMBER NOT NULL,
							PRIMARY KEY("Id" AUTOINCREMENT)
						);
					""");

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	/*
	 * 
	 * INSERT
	 * - APPEND AN ENTRY TO THE SQLITE DB.
	 * 
	 */

	@Override
	public boolean insertEntry(SuggestionEntry entry) throws SQLException {
		if(null == entry) {
			System.err.println("Invalid entry. Variable 'entry' is a null");
			return false;
		}
		
		connStatement.execute("INSERT INTO \"Suggestions\"(\"Title\", \"Description\", \"SubmittedDate\")" +
								" VALUES('"+ entry.getTitle() + "', '" + entry.getDescription() + "', '" + entry.getDateSubmitted() + "');");
		
		return true;
	}

	/*
	 * 
	 *	 
	 * 
	 */

	@Override
	public void close() throws Exception {
		connStatement.close();
		suggestionConnection.close();
	}
}
