package com.mishadoff.randomorg;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Quota checker part of random.org API.
 * Provides methods for checking how many bits allowed for generation left.
 * @author mishadoff
 *
 */
public class QuotaChecker {

	private final String QUOTA_QUERY = "http://random.org/quota/?format=plain";
	
	/**
	 * Retrieves current remaining quota for requester IP
	 * @return value in bits
	 * @throws IOException 
	 */
	public long quota() throws IOException {
		BufferedReader br = HttpWork.get(QUOTA_QUERY);
		return Long.parseLong(br.readLine());
	}
	
	/**
	 * Retrieves current remaining quota for specified IP
	 * @param 
	 * @return value in bits
	 */
	private long quota(String ip){
		throw new UnsupportedOperationException(
				"Not implemented yet");
	}
}
