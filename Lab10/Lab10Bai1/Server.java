package Lab10;

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String argv[]) throws IOException {
		DatagramSocket s = new DatagramSocket(1234);
		System.out.println(" Lắng nghe..");
		while (true) {
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			s.receive(packet);
			String message = new String(packet.getData(), 0, 0, packet.getLength());
			System.out.println("Tín hiệu từ " + packet.getAddress().getHostName() + " " + message);
		}
	}
}