package z3;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class SocketClientExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Socket socket = new Socket("localhost", 9872);

        new Thread(() -> {
            try {
                readFromServer(socket);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                writeToServer(socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }



    private static void readFromServer(Socket socket) throws IOException, ClassNotFoundException {
        while (true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message_received = (String) ois.readObject();
            System.out.println("Server: " + message_received);
        }
    }

    private static void writeToServer(Socket socket) throws IOException {
        while (true) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message_to_send = scanner.nextLine();
            oos.writeObject(message_to_send);
        }
    }
}
