package echo_tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789); // Connect to server at localhost and port 6789
        Scanner scanner = new Scanner(System.in);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Connected to server. Type messages:");

        while (true) {
            System.out.print("You: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) break;

            out.println(message); // Send message to server
            String response = in.readLine(); // Read echo from server
            System.out.println(response);    // Print echo
        }

        socket.close();
    }
}