package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000);){
            System.out.println("Chat History:");
        while(true){
            new Echoer(serverSocket.accept()).start();
        }


        }catch(IOException e){
            System.out.println("Sever issues: " + e.getMessage());
        }
    }
}

