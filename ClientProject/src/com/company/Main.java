package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write your name here: ");
            String name = scanner.nextLine();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String echoString;
            do{
                System.out.print("Send Message: ");
                echoString = scanner.nextLine(); //put your input into echoString
                output.println(name + ": " + echoString); //Outstream to server's input stream
                System.out.println(echoString);


            }while(!echoString.equals("exit"));
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }

    }
}
