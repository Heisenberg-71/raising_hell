package reverse_string_client_server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String[] args)throws Exception {
        Socket socket=new Socket("localhost",678);
        Scanner s=new Scanner(System.in);
        DataInputStream in=new DataInputStream(socket.getInputStream());
        System.out.println("enter a string to reverse: ");
        String msg=s.next();
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        out.writeUTF(msg);
       String response= in.readUTF();
        System.out.println("the string from server: "+response);

    }
}
