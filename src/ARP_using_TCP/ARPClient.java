package ARP_using_TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ARPClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter IP address to resolve: ");
        String ip = scanner.nextLine();

        Socket socket = new Socket("localhost", 5000);
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        DataInputStream in=new DataInputStream(socket.getInputStream());

        out.writeUTF(ip);
        String response = in.readUTF();

        System.out.println("MAC address: " + response);

        socket.close();
        scanner.close();
    }
}
