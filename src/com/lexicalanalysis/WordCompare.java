package com.lexicalanalysis;

import java.util.Comparator;

public class WordCompare implements Comparator<Word> {
	
	@Override
	public int compare(Word word1, Word word2) {
		return word1.compareTo(word2);
	}

}
