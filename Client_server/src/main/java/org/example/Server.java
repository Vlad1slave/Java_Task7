package org.example;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection accepted");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String name = in.readLine();
                System.out.println("Received from client: " + name + " from port " + clientSocket.getPort());

                out.println("Hi " + name + ", your port is " + clientSocket.getPort());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}