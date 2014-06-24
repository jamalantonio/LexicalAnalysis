package com.lexicalanalysis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainView extends View{
	
	JTextArea input;
	JTextArea output;
	
	@Override
	void generate() {
		
		input = new JTextArea("Enter text to analyse here", 20, 50);
		output = new JTextArea("Analysis will appear here", 20, 30);
		
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		
		JButton analyse = new JButton("Analyse!");
		JScrollPane inputScroll = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(inputScroll);
		this.add(outputScroll);
		this.add(analyse);
		
		analyse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LexicalAnalyser la = new LexicalAnalyser();
				List<Word> wordList = la.calculate(input.getText());
				String out = "";
				
				for(Word word: wordList) {
					out += word.getName() + "    " + word.getFrequency() + "\n\r";
				}
				
				output.setText(out);
				
			}
			
		});
	}

}
