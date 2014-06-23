package com.wordfrequency;

public class Word {
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
}
