/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fumagalli.luca
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("192.168.1.112", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            boolean fine = false;
            String messaggio = null;
            while (!fine) {
                System.out.println("Cosa vuoi comunicare al server?");
                messaggio = tastiera.next();
                if (messaggio.equals("fine")) {
                    fine = true;
                }
                out.println(messaggio);
                System.out.println("Il server ha risposto: " + in.readLine());
            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}