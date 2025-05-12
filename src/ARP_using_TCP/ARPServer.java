package ARP_using_TCP;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class ARPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("ARP Server is running...");

        // Simulated ARP Table
        HashMap<String, String> arpTable = new HashMap<>();
        arpTable.put("192.168.1.1", "AA:BB:CC:DD:EE:01");
        arpTable.put("192.168.1.2", "AA:BB:CC:DD:EE:02");
        arpTable.put("192.168.1.3", "AA:BB:CC:DD:EE:03");

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream in=new DataInputStream(socket.getInputStream());

            DataOutputStream out=new DataOutputStream(socket.getOutputStream());

            String ipRequest = in.readUTF();
            System.out.println("Received request for IP: " + ipRequest);

            String mac = arpTable.getOrDefault(ipRequest, "MAC address not found.");

            out.writeUTF(mac);

            socket.close();
        }
    }
}
