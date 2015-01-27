package com.jamalmoir.lexicalanalysis.tool;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.jamalmoir.lexicalanalysis.util.Text;
import com.jamalmoir.lexicalanalysis.util.Word;
import com.jamalmoir.lexicalanalysis.util.WordCompare;

public class Frequency {

	public static List<Word> getList(Text text) throws Exception {
		List<Word> frequencyList = determineFrequency(text);

		if (frequencyList.size() > 0) {
			return frequencyList;
		} else {
			throw new Exception("No Words Found");
		}
	}

	public static Word getMostFrequent(Text text) throws Exception {
		List<Word> frequencyList = determineFrequency(text);

		if (frequencyList.size() > 0) {
			return frequencyList.get(0);
		} else {
			throw new Exception("No Words Found");
		}
	}

	public static Word getLeastFrequent(Text text) throws Exception {
		List<Word> frequencyList = determineFrequency(text);
		
		if (frequencyList.size() > 0) {
			return frequencyList.get(frequencyList.size() - 1);
		} else {
			throw new Exception("No Words Found");
		}
	}

	private static List<Word> determineFrequency(Text text) {
		final List<Word> words = text.getWords();
		final Map<String, Word> wordList = new HashMap<>();

		for (final Word word : words) {
			if (!wordList.containsKey(word.getWord())) {
				wordList.put(word.getWord(), word);
			} else {
				wordList.get(word.getWord()).increment();
			}
		}

		ArrayList<Word> frequencyList = new ArrayList<>(wordList.values());

		Collections.sort(frequencyList, new WordCompare());

		return frequencyList;
	}
}
