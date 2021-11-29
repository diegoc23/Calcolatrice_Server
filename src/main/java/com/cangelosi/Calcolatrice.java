package com.cangelosi;

public class Calcolatrice 
{
    int val1 = 0;
    int val2 = 0;
    char segno;
    int ris;
    Server server;

    //costruttore
    public Calcolatrice(String val1, String val2, String segno, String ris) 
    {
        this.val1 = convertiDaStringa(val1);
        this.val2 = convertiDaStringa(val2);
        this.segno = convertiDaStringaInChar(segno);
        this.ris = convertiDaStringa(ris);
    }

    public int somma(int val1, int val2)
    {
        ris = val1 + val2;
        return ris;
    }

    public int sottrazione(int val1, int val2)
    {
        ris = val1 - val2;
        return ris;
    }

    public int moltiplicazione(int val1, int val2)
    {
        ris = val1 * val2;
        return ris;
    }

    public int divisione(int val1, int val2)
    {
        ris = val1 / val2;
        return ris;
    }

    //metodo che tramite uno switch gestisce le possibili operazioni da effettuare
    public int operazioneDaFare()
    {
        switch(segno)
        {
            case '+':
            ris = somma(val1, val2);
            break;

            case '-':
            ris = sottrazione(val1, val2);
            break;

            case '*':
            ris = moltiplicazione(val1, val2);
            break;

            case '/':
            ris = divisione(val1, val2);
            break;

            default:
            try
            {
                server.outVersoClient.writeBytes("ERRORE: Il segno digitato non e' comprensibile.");
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
        {}

        return ris;
    }

    //metodo che converte gli oggetti da STRINGA e li rende di tipo INT 
    public int convertiDaStringa(String valore)
    {
        return Integer.parseInt(valore);
    }

    public char convertiDaStringaInChar(String valore)
    {
        return valore.charAt(0);
    }
}
