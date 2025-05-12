package DNS;
import java.net.*;

public class UDP_DNSServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        System.out.println("DNS Server is running...");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String domain = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received domain: " + domain);

            String response;
            try {
                InetAddress ip = InetAddress.getByName(domain);
                System.out.println(ip);
                response = ip.getHostAddress();
            } catch (UnknownHostException e) {
                response = "Invalid domain";
            }

            sendBuffer = response.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            socket.send(sendPacket);
        }
    }
}
