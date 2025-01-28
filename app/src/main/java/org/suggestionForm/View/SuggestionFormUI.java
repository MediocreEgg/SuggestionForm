package org.suggestionForm.View;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.suggestionForm.Controller.buttonHandler;

public class SuggestionFormUI implements UI_Properties {
	JFrame suggestionFrame;
	JLabel jl_descriptionBox, jl_titleBox;
	JTextField tf_titleBox;
	JTextArea ta_descriptionBox;
	JButton btn_cancel, btn_submit;
	JScrollPane ta_scrollpane;
	
	// Controller
	buttonHandler handler;
	
	SpringLayout layout;
	Container frameContainer;

	public SuggestionFormUI() {
		init_suggestionFrame();
		init_layout();
		init_buttons();
		init_textLabel();

		addComponents();
		init_constraints();
		init_controller();
		this.suggestionFrame.setVisible(true);
	}

	private void init_suggestionFrame() {
		this.suggestionFrame = new JFrame();
		this.suggestionFrame.setTitle("Java Suggestion Form");
		this.suggestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.suggestionFrame.setLocationRelativeTo(null);
		this.suggestionFrame.setUndecorated(true);
		this.suggestionFrame.setSize(WIDTH / 2, HEIGHT / 2);
	}

	private void init_layout() {
		this.frameContainer = suggestionFrame.getContentPane();
		this.layout = new SpringLayout();
		this.frameContainer.setLayout(layout);
	}

	private void init_buttons() {
		this.btn_cancel = new JButton();
		this.btn_cancel.setFocusable(false);
		this.btn_cancel.setText("Cancel");

		this.btn_submit = new JButton();
		this.btn_submit.setFocusable(false);
		this.btn_submit.setText("Submit");
	}

	private void init_textLabel() {
		this.jl_descriptionBox = new JLabel("Description:");
		this.jl_titleBox = new JLabel("Title:");

		this.ta_descriptionBox = new JTextArea();
		this.ta_descriptionBox.setWrapStyleWord(true);

		this.ta_scrollpane = new JScrollPane(ta_descriptionBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		this.tf_titleBox = new JTextField();
	}

	private void addComponents() {
		this.frameContainer.add(btn_cancel);
		this.frameContainer.add(btn_submit);
		this.frameContainer.add(jl_descriptionBox);
		this.frameContainer.add(jl_titleBox);
		this.frameContainer.add(ta_scrollpane);
		this.frameContainer.add(tf_titleBox);
	}

	private void init_constraints() {
		this.layout.putConstraint(SpringLayout.NORTH, jl_titleBox, 20, SpringLayout.NORTH, frameContainer);
		this.layout.putConstraint(SpringLayout.WEST, jl_titleBox, 10, SpringLayout.WEST, frameContainer);

		this.layout.putConstraint(SpringLayout.NORTH, tf_titleBox, 20, SpringLayout.NORTH, frameContainer);
		this.layout.putConstraint(SpringLayout.WEST, tf_titleBox, 10, SpringLayout.EAST, jl_titleBox);
		this.layout.putConstraint(SpringLayout.EAST, tf_titleBox, -10, SpringLayout.EAST, frameContainer);

		this.layout.putConstraint(SpringLayout.NORTH, jl_descriptionBox, 15, SpringLayout.SOUTH, tf_titleBox);
		this.layout.putConstraint(SpringLayout.WEST, jl_descriptionBox, 10, SpringLayout.WEST, frameContainer);

		this.layout.putConstraint(SpringLayout.SOUTH, btn_submit, -10, SpringLayout.SOUTH, frameContainer);
		this.layout.putConstraint(SpringLayout.EAST, btn_submit, -10, SpringLayout.EAST, frameContainer);

		this.layout.putConstraint(SpringLayout.SOUTH, btn_cancel, -10, SpringLayout.SOUTH, frameContainer);
		this.layout.putConstraint(SpringLayout.WEST, btn_cancel, -80, SpringLayout.WEST, btn_submit);

		this.layout.putConstraint(SpringLayout.NORTH, ta_scrollpane, 5, SpringLayout.SOUTH, jl_descriptionBox);
		this.layout.putConstraint(SpringLayout.SOUTH, ta_scrollpane, -10, SpringLayout.NORTH, btn_submit);
		this.layout.putConstraint(SpringLayout.WEST, ta_scrollpane, 10, SpringLayout.WEST, frameContainer);
		this.layout.putConstraint(SpringLayout.EAST, ta_scrollpane, -10, SpringLayout.EAST, frameContainer);
	}

	private void init_controller() {
		try {
			this.handler = new buttonHandler(tf_titleBox, ta_descriptionBox);
			this.btn_cancel.addActionListener(handler);
			this.btn_submit.addActionListener(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
