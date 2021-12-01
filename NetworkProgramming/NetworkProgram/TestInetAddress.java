package NetworkProgram;

import java.net.InetAddress;
// đọc địa chia ip cảu 1 trnag web
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		InetAddress names[] = InetAddress.getAllByName("www.vnexpress.net");
		for (InetAddress element : names) {
			System.out.println(element);
		}
		System.out.println("-----------------");
		displayInetAddressInformation(names[0]);
	}

	private static void displayInetAddressInformation(InetAddress address) {
		System.out.println(address);
		System.out.println("CanonicalHostName: " + address.getCanonicalHostName());
		System.out.println("HostName: " + address.getHostName());
		System.out.println("HostAddress: " + address.getHostAddress());
	}
}