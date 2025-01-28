package org.suggestionForm.Model;

import java.sql.SQLException;

interface DB_Method {

	boolean doesDBExist();

	boolean doCreateSQLiteDB();

	boolean createTable();

	// CRUD [ C - Create; R - Read; U - Update; D - Delete]
	boolean insertEntry(SuggestionEntry entry) throws SQLException;
}
