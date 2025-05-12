package downloads_a_web_page;
import java.io.*;
import java.net.*;

public class HTTPEchoClient {
    public static void main(String[] args) {
        String hostName = "www.siet.ac.in";  // ✅ Only domain, no "http://"
        int portNumber = 80;

        try {
            // Create socket connection to host
            Socket socket = new Socket(hostName, portNumber);

            // Prepare to send and receive
            PrintWriter out;
            out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send HTTP GET request
            out.print("GET / HTTP/1.1\r\n");
            out.print("Host: " + hostName + "\r\n");
            out.print("Connection: close\r\n");
            out.print("\r\n");  // End of request headers
            out.flush();        // Force the data to be sent

            // Print server response
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            // Close resources
            in.close();
            out.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
        } catch (IOException e) {
            System.err.println("I/O error for connection to " + hostName);
        }
    }
}
