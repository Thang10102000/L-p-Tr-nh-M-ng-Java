package NetworkProgram;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class TestURL {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.packtpub.com:80/books/content/support");
		displayURL(url);
	}

	private static void displayURL(URL url) {
		System.out.println("URL: " + url);
		System.out.printf(" Protocol: %-32s Host: %-32s\n", url.getProtocol(), url.getHost());
		System.out.printf(" Port: %-32d Path: %-32s\n", url.getPort(), url.getPath());
		System.out.printf(" Reference: %-32s File: %-32s\n", url.getRef(), url.getFile());
		System.out.printf(" Authority: %-32s Query: %-32s\n", url.getAuthority(), url.getQuery());
		System.out.println(" User Info: " + url.getUserInfo());
		
		System.out.println("------Retrieve data từ một URL----------- : ");
		try {
			TestURL dlr=new TestURL();
			URL url2=new
			URL("http://cdn2.tstatic.net/tribunnews/foto/bank/images/Shaila-Sabt.jpg");
			String destinationFilePath="c:/a/girl.jpg";
			long bytes=dlr.download(url2, destinationFilePath);
			System.out.printf("%d bytes downloaded",bytes);
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	public long download(URL url, String destinationFilePath)throws Exception{
		long bytes=0;
		FileOutputStream fos= new FileOutputStream(destinationFilePath);
		int len=512;
		InputStream is=url.openStream();
		byte[]buffer=new byte[512];
		while(is.available()!=0) {
		len=is.read(buffer);
		bytes+=len;
		fos.write(buffer,0,len);
		}
		fos.close();
		return bytes;
		}
}
