import ServerClient.ServerClient;
import java.io.*;
import java.net.ServerSocket;

public
class Server {
    public static
    void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server launched");

            while (true)
                try (ServerClient phone = new ServerClient(server)){
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response = "Kirov Reporting: " + "\n" + "Current Weather: " + (int)(Math.random() * 30 - 10);
                    System.out.println("Response: " + response);
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        catch (IOException exp) {
            throw new RuntimeException(exp);
        }
        finally {
            System.out.println("Server shutdown");
        }
    }
}
