package com.mishadoff.randomorg;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class SequenceGenerator {

	private final String SEQUENCE_QUERY = "http://www.random.org/sequences/?format=plain";
	private final String SEQ_MIN = "&min=";
	private final String SEQ_MAX = "&max=";
	private final String SEQ_COL = "&col=";
	
	private final int COLS = 1;
	
	/**
	 * Generate sequence of dictinct numbers between <b>min</b> and <b>max</b>
	 * inclusively.
	 * 
	 * @param min
	 * @param max
	 * @return list of distinct numbers with size <b>max - min + 1</b>
	 * @throws IOException 
	 */
	public ArrayList<Integer> generate(int min, int max) throws IOException {
		String query = SEQUENCE_QUERY
				+ SEQ_MIN + min 
				+ SEQ_MAX + max
				+ SEQ_COL + COLS;
		BufferedReader br = HttpWork.get(query);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String line = "";
		while ((line = br.readLine()) != null) {
			numbers.add(Integer.parseInt(line));
		}
		return numbers;
	}
	
}
