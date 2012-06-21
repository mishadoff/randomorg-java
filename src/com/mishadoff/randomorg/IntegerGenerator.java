package com.mishadoff.randomorg;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Integer generator part of random.org API.
 * Provides methods for random integer number generating.
 * @author mishadoff
 *
 */
public class IntegerGenerator {
	
	private final String INTEGER_QUERY = "http://random.org/integers/?format=plain";
	private final String INT_MIN = "&min=";
	private final String INT_MAX = "&max=";
	private final String INT_NUM = "&num=";
	private final String INT_BASE = "&base=";
	private final String INT_COL = "&col=";
	
	private final int BASE = 10;
	private final int COLS = 1;
	
	/**
	 * Generate <b>count</b> numbers between <b>min</b> and <b>max</b> inclusively.
	 * Similar behavior to Arrays.shuffle().
	 * 
	 * @param min
	 * @param max
	 * @param count
	 * @return list of numbers
	 * @throws IOException
	 */
	public ArrayList<Integer> generate(int min, int max, int count) throws IOException {
		String query = INTEGER_QUERY 
						+ INT_MIN + min 
						+ INT_MAX + max
						+ INT_NUM + count
						+ INT_BASE + BASE
						+ INT_COL + COLS;
		ArrayList<String> strings = HttpWork.get(query);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (String str : strings) {
			numbers.add(Integer.parseInt(str, BASE));
		}
		return numbers;
	}
}
