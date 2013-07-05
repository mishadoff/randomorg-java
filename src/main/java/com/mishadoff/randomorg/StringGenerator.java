package com.mishadoff.randomorg;

import java.io.IOException;
import java.util.ArrayList;

import com.mishadoff.randomorg.util.HttpWork;

public class StringGenerator {
	
	private final String STRING_QUERY = "http://random.org/strings/?format=plain";
	
	private final String STR_NUM = "&num=";
	private final String STR_LEN = "&len=";
	private final String STR_DIGITS = "&digits=";
	private final String STR_UPPER = "&upperalpha=";
	private final String STR_LOWER = "&loweralpha=";
	private final String STR_UNIQUE = "&unique=";
	
	/**
	 * Method generates <b>count</b> number of strings with length <b>len</b>.
	 * Also have a couple of options.
	 * 
	 * At least one of the following options should be set to true:
	 * (withDigits, withUpper, withLower)
	 * 
	 * @param len
	 * @param count
	 * @param withDigits - include digits to generated strings
	 * @param withUpper - include upper alpha character to generated strings
	 * @param withLower - include lower alpha character to generated strings
	 * @param unique - all strings in one batch have unique property
	 * @return list of generated strings
	 * @throws IOException
	 */
	public ArrayList<String> generate(int len, int count, boolean withDigits,
			boolean withUpper, boolean withLower, boolean unique) throws IOException {
		String query = STRING_QUERY 
				+ STR_NUM + count
				+ STR_LEN + len
				+ STR_DIGITS + bts(withDigits)
				+ STR_UPPER + bts(withUpper)
				+ STR_LOWER + bts(withLower)
				+ STR_UNIQUE + bts(unique);
		return HttpWork.get(query);
	}
	
	private String bts(boolean b){
		return b ? "on" : "off";
	}
}
