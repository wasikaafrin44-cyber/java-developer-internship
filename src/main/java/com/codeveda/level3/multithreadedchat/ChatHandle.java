package com.codeveda.level3.multithreadedchat;

import java.io.*;
import java.net.Socket;

public class ChatHandle implements Runnable {

    private Socket socket;
    private BufferedReader reader;

    private PrintWriter writer;
    private String userName;


    public ChatHandle(Socket socket) {

        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true
            );

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void run() {

        try {

            userName = reader.readLine();

            System.out.println(userName + " joined the chat");

            Server.broadcastMessage(userName + " joined the chat" );

            String message;
            while ((message = reader.readLine()) != null) {

                System.out.println(userName + ": " + message);

                Server.broadcastMessage(userName + ": " + message);
            }

        } catch (IOException e) {

            System.out.println("Client disconnected");

        } finally {

            Server.removeClient(this);
            Server.broadcastMessage(userName + " left the chat");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void sendMessage(String message) {

        writer.println(message);
    }
}