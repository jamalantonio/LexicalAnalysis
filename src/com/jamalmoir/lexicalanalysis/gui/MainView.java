package com.jamalmoir.lexicalanalysis.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jamalmoir.lexicalanalysis.tool.Frequency;
import com.jamalmoir.lexicalanalysis.util.Text;
import com.jamalmoir.lexicalanalysis.util.Word;

public class MainView extends View{
	JTextArea input;
	JTextArea output;
	
	@Override
	void generate() {
		input = new JTextArea("Enter text to analyse here", 20, 50);
		output = new JTextArea("Analysis will appear here", 20, 30);
		
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		
		JButton getFrequencyButton = new JButton("Get Frequency");
		JScrollPane inputScroll = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(inputScroll);
		this.add(outputScroll);
		this.add(getFrequencyButton);
		
		getFrequencyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
				List<Word> frequencyList;
				try {
					frequencyList = Frequency.getList(new Text(input.getText()));
					
					for(Word word: frequencyList) {
						out += "    " + word.getWord() + ":\t\t" + word.getFrequency() + "\n\r";
					}
				} catch (Exception e1) {
					out += "    No words Found.\n\r";
				}
				
				try {
					out += "    Highest Frequency:\t" 
							+ Frequency.getMostFrequent(new Text(input.getText())).getWord() + "\n\r";
				} catch (Exception e) {
					out += "    Highest Frequency:\tNot Found\n\r";
				}
				
				try {
					out += "    Lowest Frequency:\t" 
							+ Frequency.getLeastFrequent(new Text(input.getText())).getWord() + "\n\r";
				} catch (Exception e) {
					out += "    Lowest Frequency:\tNot Found\n\r";
				}
				
				output.setText(out);
			}
		});
	}
}
