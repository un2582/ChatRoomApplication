package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String echoString;
            while(true){
                echoString = input.readLine(); //read from client
                System.out.println(echoString); //outstream echoString to client's input stream
            }



        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
