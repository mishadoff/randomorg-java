package com.mishadoff.randomorg.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Low level class-util that handles all http work
 * for obtaining results without third-party libs.
 * 
 * @author mishadoff
 *
 */
public final class HTTPUtils {
	
	private final static String GET = "GET";
	
	private HTTPUtils(){}
	
	/**
	 * Retrieves content on provided url.
	 * Recreates connection on each call.
	 * @param urlString
	 * @return BufferedReader
	 * @throws IOException 
	 */
	public static ArrayList<String> get(String urlString) throws IOException{
		// TODO handle 503 response
		// TODO add timeout functionality
		HttpURLConnection connection;
		BufferedReader rd = null;
		ArrayList<String> strings = new ArrayList<String>();
		try {
			URL url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(GET);
			rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					strings.add(line);
				}
		} finally {
			if (rd != null) {
				rd.close();
			}
		}
		return strings;
	}
}
