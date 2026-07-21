package com.codeveda.level3.multithreadedchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<ChatHandle> clients = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Chat Server Started...");
            System.out.println("Port 5000");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected: " + socket.getInetAddress());

                ChatHandle clientHandler = new ChatHandle(socket);

                clients.add(clientHandler);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
    public static void broadcastMessage(String message) {

        for (ChatHandle client : clients) {
            client.sendMessage(message);
        }
    }
    public static void removeClient(ChatHandle client) {

        clients.remove(client);
    }
}