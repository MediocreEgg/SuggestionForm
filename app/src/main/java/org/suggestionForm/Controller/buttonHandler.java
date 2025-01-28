package org.suggestionForm.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.suggestionForm.Model.DBManager;
import org.suggestionForm.Model.SuggestionEntry;

public class buttonHandler implements ActionListener {

	private JTextArea description;
	private JTextField title;
	private DBManager manager;

	public buttonHandler(JTextField title, JTextArea description) throws Exception {
		this.title = title;
		this.description = description;
		this.manager = new DBManager();
		System.out.println("buttonHandler Initiated!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (e.getActionCommand()) {
			case "Cancel":
				System.exit(0);

			case "Submit":
				if(!description.getText().isEmpty())
					manager.insertEntry(SuggestionEntry.builder().title(this.title.getText())
							.description(this.description.getText()).build());
				
				else
				{
					JOptionPane.showMessageDialog(null, "Missing Title", "Attention", 0);
				}
				System.out.println("Omit submit action");
				break;

			default:
				System.out.println("Huh?");

			}
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

}
