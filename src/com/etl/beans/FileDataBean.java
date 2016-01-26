package com.etl.beans;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author NISHANT VAIDYA
 * version 1.0
 *
 */
public class FileDataBean extends MessageBean {
	
	private ArrayList<String> data;
	
	private Map<String, Integer> words;

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public Map<String, Integer> getWords() {
		return words;
	}

	public void setWords(Map<String, Integer> words) {
		this.words = words;
	}


	
	

}
