package com.mishadoff.randomorg;

import java.io.IOException;
import java.util.ArrayList;

import com.mishadoff.randomorg.util.HTTPUtils;

/**
 * Sequence generator part of random.org API.
 * Provides methods for generating all numbers in specified range but in random order
 * 
 * @author mishadoff
 *
 */
public class SequenceGenerator {

	private final static String SEQUENCE_QUERY = "http://random.org/sequences/?format=plain";
	private final static String SEQ_MIN = "&min=";
	private final static String SEQ_MAX = "&max=";
	private final static String SEQ_COL = "&col=";
	
	private final static int COLS = 1;
	
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
		ArrayList<String> strings = HTTPUtils.get(query);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (String str : strings) {
			numbers.add(Integer.parseInt(str));
		}
		return numbers;
	}
	
}
