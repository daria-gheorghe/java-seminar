package org.example;

import java.io.*;
import java.net.*;

public class SimpleTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);  //Te conectezi la server

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //Canal de trimitere spre server.
        BufferedReader in = new BufferedReader( //Canal de primire de la server
                new InputStreamReader(socket.getInputStream())
        );

        out.println("Hello Georgel");   //Trimiți un singur mesaj fix către server

        String response = in.readLine();    //Aștepți un singur răspuns de la server și îl afișezi.
        System.out.println(response);

        socket.close();
    }
}
