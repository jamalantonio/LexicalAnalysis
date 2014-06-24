package com.lexicalanalysis;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class LexicalAnalyser {

	public List<Word> calculate(String str) {
		List<String> words = getWords(str);
		List<Word> wordList = determineFrequency(words);
		
		Collections.sort(wordList, new WordCompare());
		
		return wordList;
		
	}
	
	private List<String> getWords(String str) {
		List<String> words = new ArrayList<String>();
		Scanner scan = new Scanner(str);
		
		while(scan.hasNext()) {
			String word = scan.next();
			
			if(word.length() > 1) {
				
				word = strip(word);
				
				if (!word.equals(".")) words.add(word.toLowerCase());
				
			} else {
				if(Character.isLetter(word.charAt(0))) words.add(word.toLowerCase());
			}
		}
		
		scan.close();
		return words;
	}
	
	private String strip(final String str) {
		int start = 0;
		int end = str.length() - 1;
		
		while (start < str.length() && !Character.isLetter(str.charAt(start))) {
	        start++;
	    }
		
	    while (end >= start && !Character.isLetter(str.charAt(end))) {
	        end--;
	    }

	    if (start >= end) {
	        return ".";
	    } else {
	        return str.substring(start, end + 1);
	    }
	}
	
	private List<Word> determineFrequency(final List<String> words) {
		final Map<String, Word> wordList = new HashMap<String, Word>();

	    for (final String word : words) {
	        if (!wordList.containsKey(word)) {
	            wordList.put(word, new Word(word));
	        } else {
	        	wordList.get(word).increment();
	        }
	    }

	    return new ArrayList<>(wordList.values());
	}
}
