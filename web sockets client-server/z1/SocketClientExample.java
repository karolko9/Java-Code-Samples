package z1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;

        socket = new Socket(host.getHostName(), 9876);
        System.out.println("Connected to server");

        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());

        while (true) {
            System.out.print("Client: ");
            Scanner scanner = new Scanner(System.in);
            String message_to_send = scanner.nextLine();
            oos.writeObject(message_to_send);

            if (message_to_send.equals("exit")) {
                break;
            }

            String message_received = (String) ois.readObject();
            System.out.println("Server: " + message_received);
        }

        ois.close();
        oos.close();
        socket.close();
    }
}
