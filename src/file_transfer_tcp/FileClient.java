package file_transfer_tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int port = 5000;

        Socket socket = new Socket(serverIP, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename to download: ");
        String fileName = scanner.nextLine();

        // Send file name to server
        writer.write(fileName + "\n");
        writer.flush();

        // Read response
        String response = in.readLine();
        if ("FOUND".equals(response)) {
            FileOutputStream fileOut = new FileOutputStream("downloaded_" + fileName);
            InputStream input = socket.getInputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }

            fileOut.close();
            System.out.println("File downloaded as downloaded_" + fileName);
        } else {
            System.out.println("File not found on server.");
        }

        socket.close();
    }
}
