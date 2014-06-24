package com.lexicalanalysis;

import javax.swing.JPanel;

abstract class View extends JPanel {
	
	private String title;
	
	public View() {
		setTitle("View");
		generate();
	}
	
	abstract void generate();
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
