import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            if (in.readLine().equals("Write your name")) {
                out.println("Alexey");
            }

            if (in.readLine().equals("Are you child? (yes/no)")) {
                out.println("no");
            }

            String message = in.readLine();

            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
