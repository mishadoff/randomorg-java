package com.mishadoff.randomorg;

import java.io.IOException;
import java.util.ArrayList;

import com.mishadoff.randomorg.util.HTTPUtils;

/**
 * Quota checker part of random.org API.
 * Provides methods for checking how many bits allowed for generation left.
 * 
 * @author mishadoff
 *
 */
public class QuotaChecker {

	private final static String QUOTA_QUERY = "http://random.org/quota/?format=plain";
	private final static String QUOTA_QUERY_IP = "&ip=";
	
	/**
	 * Retrieves current remaining quota for requester IP
	 * @return value in bits
	 * @throws IOException 
	 */
	public long quota() throws IOException {
		ArrayList<String> strings = HTTPUtils.get(QUOTA_QUERY);
		return Long.parseLong(strings.get(0));
	}
	
	/**
	 * Retrieves current remaining quota for specified IP
	 * @param 
	 * @return value in bits
	 * @throws IOException 
	 */
	public long quota(String ip) throws IOException{
		ArrayList<String> strings = HTTPUtils.get(QUOTA_QUERY + QUOTA_QUERY_IP + ip);
		return Long.parseLong(strings.get(0));
	}
}
