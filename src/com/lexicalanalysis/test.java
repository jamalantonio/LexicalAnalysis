package com.lexicalanalysis;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class test {

	public static void main(String[] args) throws IOException {
		List<Word> wordList = new ArrayList<Word>();

		BufferedReader br = new BufferedReader(new FileReader("inFile.txt"));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		
		LexicalAnalyser la = new LexicalAnalyser();
		
		try {

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
		} finally {
			br.close();
		}

		//wordList = WordFrequency.calculate("Hello my name is Jamal. I like to... Eat, eat  eat , sleep, lift live  can't !");
		wordList = la.calculate(sb.toString());

		for (Word word: wordList) {
			System.out.println(word.getName() + "    " + word.getFrequency());
		}
	}
}
