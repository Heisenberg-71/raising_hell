

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serversocketEx {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket=new ServerSocket(777);

        Socket socket=serverSocket.accept();
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF("hi");
        dataOutputStream.close();
    }
}
