package file_transfer_tcp;

import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

            String fileName = reader.readLine();
            File file = new File(fileName);

            if (file.exists()) {
                out.write("FOUND\n".getBytes());
                FileInputStream fileIn = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileIn.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                fileIn.close();
                System.out.println("File sent: " + fileName);
            } else {
                out.write("NOT_FOUND\n".getBytes());
                System.out.println("File not found: " + fileName);
            }

            out.flush();
            socket.close();
        }
    }
}
