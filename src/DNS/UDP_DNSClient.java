package DNS;

import java.net.*;
import java.util.Scanner;

public class UDP_DNSClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter domain name: ");
        String domain = scanner.nextLine();

        byte[] sendBuffer = domain.getBytes();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 9876;

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
        socket.send(sendPacket);

        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        String ipAddress = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Resolved IP: " + ipAddress);

        socket.close();
    }
}
