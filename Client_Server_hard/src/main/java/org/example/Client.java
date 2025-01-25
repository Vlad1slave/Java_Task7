package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "netology.homework";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));


            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
            String name = consoleInput.readLine();
            out.println(name);


            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
            String isChild = consoleInput.readLine();
            out.println(isChild);


            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);


            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}