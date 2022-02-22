import ServerClient.ServerClient;
import java.io.*;
import java.net.ServerSocket;

public
class Server {
    public static
    void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server launched");

            while (true) {
                try (ServerClient phone = new ServerClient(server)) {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response = (int)(Math.random() * 30 - 10) + " ";
                    phone.writeLine(response);
                    Thread.sleep(4000);
                    System.out.println("Response: \n" + "Kirov Reporting: " + "\n" + "Current Weather: " + response);
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
