import ServerClient.ServerClient;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (ServerClient serverClient = new ServerClient("127.0.0.1", 8000)) {
            System.out.println("Client connected to server");

            String request = "Za rodinu!";
            System.out.println("Request: " + request);
            serverClient.writeLine(request);

            String response = serverClient.readLine();
            System.out.println("Response: \n" + "Kirov Reporting: " + "\n" + "Current Weather: " + response);
            System.out.println("\n");
        }
        catch(IOException exp){
            exp.printStackTrace();
        }
    }
}
