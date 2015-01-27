package com.jamalmoir.lexicalanalysis.gui;

import javax.swing.JPanel;

abstract class View extends JPanel {
	private String title;
	
	public View() {
		setTitle("View");
		generate();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	abstract void generate();
}
