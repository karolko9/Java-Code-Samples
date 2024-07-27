package z1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerExample {

    private static ServerSocket server;
    private static int port = 9876;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        System.out.println("Server started. Waiting for the client request");

        Socket socket = server.accept();
        System.out.println("Client connected");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        while (true) {
            String message_received = (String) ois.readObject();
            System.out.println("Client: " + message_received);

            if (message_received.equals("exit")) {
                break;
            }

            System.out.print("Server: ");
            Scanner scanner = new Scanner(System.in);
            String message_to_send = scanner.nextLine();
            oos.writeObject(message_to_send);
        }

        ois.close();
        oos.close();
        socket.close();
        server.close();
    }
}
