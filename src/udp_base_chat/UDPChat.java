package udp_base_chat;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPChat {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Setup
        System.out.print("Enter your listening port: ");
        int myPort = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter recipient IP address: ");
        String remoteIP = scanner.nextLine();

        System.out.print("Enter recipient port: ");
        int remotePort = scanner.nextInt();
        scanner.nextLine();  // consume newline

        DatagramSocket socket = new DatagramSocket(myPort);

        // Receiver Thread
        Thread receiver = new Thread(() -> {
            byte[] buffer = new byte[1024];
            while (true) {
                try {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String msg = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("\n[Friend]: " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Sender Thread
        Thread sender = new Thread(() -> {
            while (true) {
                try {
                    String message = scanner.nextLine();
                    byte[] data = message.getBytes();
                    InetAddress address = InetAddress.getByName(remoteIP);
                    DatagramPacket packet = new DatagramPacket(data, data.length, address, remotePort);
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        receiver.start();
        sender.start();
    }
}
