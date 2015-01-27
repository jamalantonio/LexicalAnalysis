package com.jamalmoir.lexicalanalysis.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Gui {
	final static JPanel myContentPane = new JPanel();
	static Map<Integer, JPanel> views = new HashMap<>();
	
	public void createAndShowGui() {
		JFrame frame = new JFrame();
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem imprt = new JMenuItem("Import");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frame.setSize(950,425);
		frame.setJMenuBar(menuBar);
		frame.setTitle("Lexical Analysis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar.add(file);
		file.add(save);
		file.add(load);
		file.add(imprt);
		
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
