package org.suggestionForm.Model;

public interface DB_Properties {
	String db_uri = "jdbc:sqlite:";
	String user_home = System.getProperty("user.home")+"\\Documents\\";
	String db_name = "SuggestionBox.db";
	int attemptLIMIT = 5;
	
	default String sqliteURI() {
		return db_uri + user_home + db_name;
	}

}
	