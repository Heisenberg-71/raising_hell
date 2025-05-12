package RARP_using_UDP;

import java.net.*;
import java.util.HashMap;

public class RARPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        // Sample MAC-to-IP mapping
        HashMap<String, String> macToIp = new HashMap<>();
        macToIp.put("AA:BB:CC:DD:EE:01", "192.168.1.10");
        macToIp.put("AA:BB:CC:DD:EE:02", "192.168.1.20");

        System.out.println("RARP Server running on port 9876...");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String macAddress = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received MAC: " + macAddress);

            String ip = macToIp.getOrDefault(macAddress, "IP Not Found");

            sendData = ip.getBytes();
            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
            serverSocket.send(sendPacket);
        }
    }
}
