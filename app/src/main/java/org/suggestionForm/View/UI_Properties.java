package org.suggestionForm.View;

public interface UI_Properties {
	int WIDTH = 640;
	int HEIGHT = 500;

	/*
	 * 	Converts from INT to DOUBLE
	 */
	
	default double dWidth() {
		return (double) WIDTH;
	}
	
	default double dHeight() {
		return (double) HEIGHT;
	}
}
