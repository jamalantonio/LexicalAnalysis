package com.jamalmoir.lexicalanalysis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {
	private String text;

	public Text(String text) {
		this.text = text;
	}

	public List<Word> getWords() {
		List<Word> words = new ArrayList<>();
		Scanner scan = new Scanner(text);

		while(scan.hasNext()) {
			String word = scan.next();

			if(word.length() > 1) {
				word = StringFunctions.strip(word);

				if (!word.equals(".")) words.add(new Word(word.toLowerCase()));
			} else {
				if(Character.isLetter(word.charAt(0))) words.add(new Word(word.toLowerCase()));
			}
		}

		scan.close();
		return words;
	}
}
