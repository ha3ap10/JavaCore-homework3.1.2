import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");

            out.println("Write your name");
            String userName = in.readLine();

            out.println("Are you child? (yes/no)");
            String answer = in.readLine();

            if (answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", userName));
            } else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", userName));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
