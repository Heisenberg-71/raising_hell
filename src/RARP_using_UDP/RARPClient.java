package RARP_using_UDP;
import java.net.*;
import java.util.Scanner;

public class RARPClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();

        System.out.print("Enter MAC Address: ");
        String macAddress = scanner.nextLine();

        InetAddress serverIP = InetAddress.getByName("localhost");
        byte[] sendData = macAddress.getBytes();
        byte[] receiveData = new byte[1024];

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received IP Address: " + response);

        clientSocket.close();
    }
}
