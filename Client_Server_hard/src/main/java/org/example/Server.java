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


                out.println("Write your name:");
                String name = in.readLine();
                System.out.println("Client name: " + name);


                out.println("Are you a child? (yes/no):");
                String isChild = in.readLine();
                System.out.println("Client is child: " + isChild);


                if (isChild.equalsIgnoreCase("yes")) {
                    out.println("Welcome to the kids area, " + name + "! Let's play!");
                } else {
                    out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                }


                out.println("Goodbye, " + name + "!");
                System.out.println("Connection with " + name + " closed.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
