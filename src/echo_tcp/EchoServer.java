package echo_tcp;
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789); // Server listens on port 6789
        System.out.println("Echo Server started. Waiting for client...");

        Socket clientSocket = serverSocket.accept(); // Accept client connection
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String received;
        while ((received = in.readLine()) != null) {
            System.out.println("Received from client: " + received);
            out.println("Echo: " + received); // Echo back to client
        }

        clientSocket.close();
        serverSocket.close();
    }
}
