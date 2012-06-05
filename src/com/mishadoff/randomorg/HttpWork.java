package com.mishadoff.randomorg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Low level class-util that handles all http work
 * for obtaining results without third-party libs.
 * 
 * @author mishadoff
 *
 */
public final class HttpWork {
	
	private HttpWork(){}
	
	/**
	 * Retrieves content on provided url.
	 * Recreates connection on eeach call.
	 * @param url
	 * @return BufferedReader
	 * @throws IOException 
	 */
	public static BufferedReader get(String urlString) throws IOException{
		// TODO handle 503 response
		HttpURLConnection connection;
		BufferedReader rd;
		URL url = new URL(urlString);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		return rd;
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		BufferedReader br = get("http://random.org/quota/?format=plain");
		String line;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
	}
}
