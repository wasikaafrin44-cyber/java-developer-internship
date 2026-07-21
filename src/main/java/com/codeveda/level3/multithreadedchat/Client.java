package com.codeveda.level3.multithreadedchat;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to Chat Server");

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter writer =  new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter your name: ");
            String name = keyboard.readLine();

            writer.println(name);
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;

                    while ((message = reader.readLine()) != null) {
                        System.out.println(message);
                    }

                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            receiveThread.start();

            String message;

            while (true) {

                message = keyboard.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.println(message);
            }
            socket.close();

        } catch (IOException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }

    }
}