import ServerClient.ServerClient;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (ServerClient serverClient = new ServerClient("127.0.0.1", 8000)) {
            System.out.println("Client connected to server");
            String request = "Za rodinu!";
            String response = serverClient.readLine() + "\n" + serverClient.readLine();
            System.out.println("Response: " + response);
        }
        catch(IOException exp){
            exp.printStackTrace();
        }
    }
}
