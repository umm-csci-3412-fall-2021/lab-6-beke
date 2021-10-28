package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    // REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.start();
    }

    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                Thread clientThread = new Thread(() -> {
                    int i;

                    // socket streams
                    try {
                        InputStream streamFromSocket = socket.getInputStream();
                        OutputStream streamToSocket = socket.getOutputStream();
                        // while loop that continuously reads one byte from
                        // the socket, and writes one byte to the socket.
                        while ((i = streamFromSocket.read()) != -1)
                        // read one byte from the socket
                        {
                            // write one byte to the socket
                            streamToSocket.write(i);
                            streamToSocket.flush();

                        }

                        socket.shutdownOutput();

                        // Close the client socket since we're done.
                        socket.close();

                        System.out.println("Client disconnected.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                clientThread.start();

            }

            // *Very* minimal error handling.
        } catch (Exception ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}