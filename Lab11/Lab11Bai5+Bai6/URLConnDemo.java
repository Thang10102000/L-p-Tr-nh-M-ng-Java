package Lab11.Bai6;

import java.net.*;

import java.util.Scanner;

import java.io.*;

public class URLConnDemo

{
	public static void main(String[] args)
	{
		try
		{   System.out.println("nhập http:// cần kiểm tra :");
			Scanner input = new Scanner(System.in);
			String s = input.nextLine();
			URL url = new URL(s);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = null;
			if (urlConnection instanceof HttpURLConnection)
			{
				connection = (HttpURLConnection) urlConnection;
			}
			else
			{
				System.out.println("Please enter an HTTP URL.");
				return;
			}
			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null)
			{
				urlString += current;
			}
			System.out.println(urlString);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
