package org.example;

import java.io.*;
import java.net.*;

//Ce protocol folosește Socket în Java? → TCP
//Ce se întâmplă când utilizatorul scrie "exit"? → se iese din buclă și socket.close() închide conexiunea
//De ce se folosește BufferedReader în loc de citire directă? → eficiență, citește linie cu linie

public class InteractiveTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        //Socket = conexiunea TCP.
        //Dacă serverul nu e pornit → excepție imediată, conexiunea eșuează

        //Creezi un canal de citire — prin el primești mesajele de la server.
        BufferedReader serverIn = new BufferedReader
                (
                new InputStreamReader(socket.getInputStream())  //InputStreamReader = transformă bytes în caractere
        );

        //Creezi un canal de trimitere — prin el trimiți mesaje către server.
        PrintWriter serverOut = new PrintWriter(
                socket.getOutputStream(), true  //true = auto-flush: trimite mesajul imediat, nu îl ține în buffer
        );

        //Creezi un canal de citire de la tastatură.
        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String userMessage; //O variabilă goală în care vei stoca ce scrie utilizatorul.

        while (true) {
            System.out.print("You: ");  //Afișează You:  în consolă (fără enter la sfârșit)

            userMessage = userInput.readLine();//Așteaptă să scrii ceva și să apeși Enter
            //Ce ai scris se salvează în userMessage

            if (userMessage.equalsIgnoreCase("exit")) //Dacă ai scris exit (sau EXIT, Exit — nu contează majusculele) → ieși din buclă.
            {
                break;
            }

            serverOut.println(userMessage); //Trimiți mesajul la server prin canalul creat mai devreme

            String response = serverIn.readLine();  //Aștepți răspunsul de la server (programul se blochează aici până vine ceva)
            System.out.println("Server: " + response);
        }

        socket.close(); //Închizi conexiunea — cum închizi telefonul după convorbire. Eliberezi resursele.
    }
}

//Tu scrii → serverOut → [RETEA] → Server
//                                   ↓
//Tu citești ← serverIn ← [RETEA] ← Server răspunde
