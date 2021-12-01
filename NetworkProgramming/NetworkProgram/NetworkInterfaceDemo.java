package NetworkProgram;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

// Lớp này đại diện cho một Giao diện mạng được tạo thành từ tên và danh sách các địa chỉ IP 
//được gán cho giao diện này. Nó được sử dụng để xác định giao diện cục bộ mà trên đó một nhóm đa hướng được tham gia.


public class NetworkInterfaceDemo {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
			System.out.printf("Name \t Display name\n");
			for (NetworkInterface element : Collections.list(interfaceEnum)) {
				System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
	}
}
