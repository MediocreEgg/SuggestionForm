package org.suggestionForm;

import javax.swing.SwingUtilities;

import org.suggestionForm.Model.DBManager;
import org.suggestionForm.Model.DB_Properties;
import org.suggestionForm.View.SuggestionFormUI;

/*
 * 	DB: SQLite
 * 	Raw: CSV
 * 
 */

public class Main implements DB_Properties{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try (DBManager sqlManager = new DBManager();){
					SuggestionFormUI app = new SuggestionFormUI();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
		});
	}
}
