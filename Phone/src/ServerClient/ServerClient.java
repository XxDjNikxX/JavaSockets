package ServerClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient implements Closeable{
    private final Socket socket;
    private final BufferedWriter writer;
    private final BufferedReader reader;

    public ServerClient(String ip, int port) {
        try {
            this.socket = new Socket(ip,port);
            this.reader = createReader();
            this.writer = createWriter();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ServerClient(ServerSocket server) {
        try {
            this.socket = server.accept();
            this.reader = createReader();
            this.writer = createWriter();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void writeLine (String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        }
        catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }
    public String readLine () {
        try {
            return reader.readLine();
        }
        catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }
    private BufferedReader createReader() {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private BufferedWriter createWriter() {
        try {
            return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException{
        writer.close();
        reader.close();
        socket.close();
    }
}
