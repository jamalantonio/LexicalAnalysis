package com.lexicalanalysis;

public class Word implements Comparable<Word>{
	private String name;
	private int frequency;
	
	/**
	 * Creates a word object with the provided
	 * name and a frequency of 1.
	 * 
	 * @param name The name of the word.
	 */
	public Word(String name) {
		this.name = name;
		this.frequency = 1;
	}
	
	/**
	 * Creates a word object with the provided
	 * name and frequency.
	 * 
	 * @param name The name of the word.
	 * @param frequency The frequency of the word.
	 */
	public Word(String name, int frequency) {
		this.name = name;
		this.frequency = frequency;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	/**
	 * Increments the words frequency by 1.
	 */
	public void increment() {
		this.frequency++;
	}
	
	/**
     * Compares the current Word's frequency with specified Word's frequency.
     * return zero if frequency for both Words is same .
     * return negative if current frequency is less than specified one.
     * return positive if specified frequency is greater than specified one.
     * 
     * @param word The Word to compare current Word with.
     */
	@Override
	public int compareTo(Word word) {
		return this.getFrequency() - word.getFrequency();
	}
}
