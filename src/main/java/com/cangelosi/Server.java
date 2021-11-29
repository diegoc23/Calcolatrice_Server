package com.cangelosi;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server 
{
    ServerSocket server = null;
    Socket client = null;
    Calcolatrice calcolatrice = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    String val1 = null;
    String val2 = null;
    String ris = null;
    String segno = null;

    String utile = null; //assume il valore di "Y" o "N" in base alla richiesta, serve per capire se la connessione deve essere interrota o meno

    public Socket attendi()
    {
        try
        {
            System.out.println("1 Server partito in esecuzione...");
            server = new ServerSocket(1234);
            client = server.accept();
            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("ERRORE durante la creazione del server!");
            System.exit(1);
        }
        return client;
    }

    public void comunica()
    {
        try
        {
            //digitazione dei valori
            System.out.println("Client, digita il primo valore: ");
            val1 = inDalClient.readLine();

            System.out.println("Client, digita il secondo valore: ");
            val2 = inDalClient.readLine();

            outVersoClient.writeBytes("Digitare il segno in base all'operazione che si desidera effettuare: +, - , *, /");
            segno = inDalClient.readLine();

            calcolatrice = new Calcolatrice(val1, val2, segno, ris);

            outVersoClient.writeBytes("Continuare la connessione?\nY--> yes\nN--> no\n");
            utile = inDalClient.readLine();
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    try
    {

    }
    catch(Exception e)
    {
        System.err.println(e.getMessage());
    }
}
