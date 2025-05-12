import java.io.*;
import java.net.*;

public class ReverseServer {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket=new ServerSocket(678);
        System.out.println("server is listening on port:"+serverSocket.getLocalPort());
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println("client is connected");
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            DataInputStream in=new DataInputStream(socket.getInputStream());
            String received=in.readUTF();
            System.out.println("received from client "+received);
            String reverse=new StringBuilder(received).reverse().toString();
            out.writeUTF(reverse);
            socket.close();

        }

    }
}
