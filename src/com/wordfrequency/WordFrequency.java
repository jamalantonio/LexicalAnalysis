package com.wordfrequency;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFrequency {

	public static List<Word> calculate(String str) {
		List<String> words = getWords(str);
		List<Word> wordList = sort(words);
		
		return wordList;
		
	}
	
	private static List<String> getWords(String str) {
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
		
		return words;
	}
	
	private static String strip(String str) {
		boolean letterFront = false;
		boolean letterBack = false;
		
		while(!letterFront) {
			char first = str.charAt(0);
			
			if(Character.isLetter(first)){
				letterFront = true;
			} else {
				if(str.length() == 1) return ".";
				
				str = str.substring(1);
			}
		}
		
		while(!letterBack) {
			char last = str.charAt(str.length() - 1);
			
			if(Character.isLetter(last)){
				letterBack = true;
			} else {
				if(str.length() == 1) return ".";
				
				str = str.substring(0, str.length() - 1);
			}
		}
		
		return str;
	}
	
	private static List<Word> sort(List<String> words) {
		List<Word> wordList = new ArrayList<Word>();
		boolean exists = false;
		
		for (String word : words) {
			exists = false;
			
			for (Word wordobj: wordList) {
				if (wordobj.getName().equals(word) && !exists) {
					
					wordobj.increment();
					exists = true;
				}
			}
			
			if (!exists) wordList.add(new Word(word));
		}
		
		return wordList;
	}
}
