package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//Ăsta e partea cealaltă — dacă clientul "sună", serverul e cel care "răspunde la telefon"

public class SimpleTcpServer {
    public static void main(String[] args) throws IOException {
        int port = 5001;    //Definești pe ce port "ascultă" serverul. Același port pe care clientul îl folosește să se conecteze.

        ServerSocket serverSocket = new ServerSocket(port); //Deschizi "biroul" — serverul începe să asculte pe portul 5001.
        System.out.println("Server listening on port " + port);
        //ServerSocket ≠ Socket — acesta nu e o conexiune, e un punct de așteptare

        //Serverul rulează la infinit — e mereu disponibil pentru clienți noi.
        while (true) {
            Socket clientSocket = serverSocket.accept(); // waits for a client
            //.accept() blochează programul aici până se conectează cineva.
            System.out.println("Client connected");
            //Când vine un client → se creează un Socket nou dedicat acelui client
            //serverSocket rămâne liber să accepte alți clienți în continuare

            BufferedReader in = new BufferedReader( //Canal de citire — primești mesajele de la client
                    new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter out = new PrintWriter(  //Canal de trimitere — trimiți răspunsuri înapoi la client
                    clientSocket.getOutputStream(), true
            );

            String message;
            while ((message = in.readLine()) != null) //citești mesaje de la client până când acesta se deconectează
            {   //in.readLine() returnează null când clientul închide conexiunea
                System.out.println("Client says: " + message);
                out.println("Server received: " + message);
            }

            clientSocket.close();   //Închizi conexiunea cu clientul curent și te întorci la serverSocket.accept() să aștepți următorul client
        }
    }
}
