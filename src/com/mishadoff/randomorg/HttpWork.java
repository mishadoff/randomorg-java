package com.mishadoff.randomorg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Low level class that handles all http work
 * for obtaining results without third-party libs.
 * 
 * @author mishadoff
 *
 */
public class HttpWork {
	
	/**
	 * Retrieves content on provided url.
	 * Recreates connection on eeach call.
	 * @param url
	 * @return BufferedReader
	 * @throws IOException 
	 */
	public BufferedReader get(String urlString) throws IOException{
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
		HttpWork httpWork = new HttpWork();
		BufferedReader br = httpWork.get("http://random.org/quota/?format=plain");
		String line;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
	}
}
