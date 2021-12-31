package allen;

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

			System.err.println(line);
//			sb.append(line);

			charsRead = br.read(arr, 0, bufferSize);

		}
		System.out.println("response data size = " + total);

//		System.out.println(sb.toString());

//		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
//			StringBuilder response = new StringBuilder();

//			int charsRead = br.read(chars, 0, length);

//			String result;
//			if (charsRead != -1) {
//				result = new String(chars, 0, charsRead);
//			} else {
//				result = "";
//			}

//			for (int i = 0; i < 100; i++) {
//				char c = (char) br.read();
//				System.err.println(c);
//				response.append(c);
//
//			}

//			String line = br.readLine();
//			System.err.println("getting response, line=" + line);
//
//			String responseLine = null;
//			while ((responseLine = br.readLine()) != null) {
//				System.err.println(responseLine);
//				response.append(responseLine.trim());
//			}
//			String resp = response.toString();
//
//			System.out.println(resp);
//			System.err.println("response echoed");

//			return response.toString();
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
	}

}
