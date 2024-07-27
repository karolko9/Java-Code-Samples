package z2;

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

        for (int i = 0; i<4; i++){
            Socket socket = server.accept();
            System.out.println("Client connected - " + socket);

            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
        server.close();
    }
}
class ClientHandler implements Runnable{
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    ClientHandler(Socket s) throws IOException {
        this.socket = s;
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());

    }
    @Override
    public void run() {
        try {
            while (true){
                String message_received;
                message_received = (String) ois.readObject();

                System.out.println(socket + "-" + "Client: " + message_received);

                if (message_received.equals("exit")) {
                    break;
                }

                System.out.print("Server to "+ socket + ": ");
                Scanner scanner = new Scanner(System.in);
                String message_to_send = scanner.nextLine();
                oos.writeObject(message_to_send);
            }
                ois.close();
                oos.close();
                socket.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}