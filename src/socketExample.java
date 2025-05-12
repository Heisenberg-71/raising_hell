

import java.io.DataInputStream;
import java.net.Socket;

public class socketExample {
    public static void main(String[] args)throws Exception {
        Socket socket=new Socket("localhost",777);

        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        String msg=dataInputStream.readUTF();
        System.out.println("server: "+msg);

    }
}
