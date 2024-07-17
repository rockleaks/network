import java.io.*;
import java.net.*;

class UDPclient {
    public static DatagramSocket ds;
    public static int clientport = 8040, serverport = 8050;

    public static void main(String args[]) throws Exception {
        byte buffer[] = new byte[1024];
        ds = new DatagramSocket(clientport);
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("server waiting");
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        while (true) {
            System.out.print("Client:");
            String str = dis.readLine();
            if (str.equals("end"))
                break;
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, buffer.length, ia, serverport));
            byte[] receiverbuffer = new byte[1024];
            DatagramPacket p = new DatagramPacket(receiverbuffer, receiverbuffer.length);
            ds.receive(p);
            String psx = new String(p.getData(), 0, p.getLength());
            System.out.println("Server:" + psx + "\n");
        }
    }
}
