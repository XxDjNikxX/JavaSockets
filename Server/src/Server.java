import ServerClient.ServerClient;
import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {

            System.out.println("Server launched");

            while (true) {
                ServerClient phone = new ServerClient(server);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response = (int) (Math.random() * 30 - 10) + "";
                    try {
                        Thread.sleep(4000);
                    }
                    catch (InterruptedException e) {
                    }
                    phone.writeLine(response);
                    System.out.println("Response: \n" + "Kirov Reporting: " + "\n" + "Current Weather: " + response);
                    try {
                        phone.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
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
