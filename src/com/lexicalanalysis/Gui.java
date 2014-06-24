package com.lexicalanalysis;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
	
	final static JPanel myContentPane = new JPanel();
	static Map<Integer, JPanel> views = new HashMap<>();
	
	public void createAndShowGui() {
		JFrame frame = new JFrame();
		
		frame.setSize(950,405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myContentPane.setLayout(new BorderLayout());
		frame.setContentPane(myContentPane);
		
		views.put(1, new MainView());
		
		setCurrentScreen(1);
		
		frame.setVisible(true);
	}
	
	private void setCurrentScreen(int view) {
		
		myContentPane.removeAll();
		myContentPane.add((Component) views.get(view));
		myContentPane.revalidate();
		myContentPane.repaint();
	}

}
