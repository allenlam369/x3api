package allen.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestCallApi {

	public static void main(String[] args) throws IOException {
		String base = "http://obelix.epd.gov.hk:5050";
		URL url = new URL(base + "/tide/twoDays?stationId=1");

//		URL url = new URL(base + "/uvi/twoDays");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);

		int bufferSize = 8 * 1024;
//		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"), bufferSize);
		char[] arr = new char[bufferSize];

		int total = 0;
		int charsRead = br.read(arr, 0, bufferSize);

		while (charsRead != -1) {
			total += charsRead;
			String line = new String(arr, 0, charsRead);

			System.out.println(line);
//			sb.append(line);

			charsRead = br.read(arr, 0, bufferSize);

		}
		System.out.println("response data size = " + total);

	}

}
