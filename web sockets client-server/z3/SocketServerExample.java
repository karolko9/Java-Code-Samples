package z3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class SocketServerExample {

    private static ServerSocket server;
    private static int port = 9872;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server is running. Waiting for a client...");

        Socket clientSocket = server.accept();
        System.out.println("Client connected: " + clientSocket);

        new Thread(() -> {
            try {
                readFromClient(clientSocket);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                writeToClient(clientSocket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void readFromClient(Socket socket) throws IOException, ClassNotFoundException {
        while (true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message_received = (String) ois.readObject();
            System.out.println("Client: " + message_received);
        }
    }

    private static void writeToClient(Socket socket) throws IOException {
        while (true) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message_to_send = scanner.nextLine();
            oos.writeObject(message_to_send);
        }
    }
}
