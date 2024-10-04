package yurilenzi.classi;

import java.util.Random;

public abstract class Gioco {
    public static int count = 0;
    protected int idGioco;
    protected String titolo;
    protected int annoPubblicazione;
    protected double prezzo;

    public Gioco(String titolo, int annoPubblicazione, double prezzo) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        if (prezzo < 1){
           throw new PrezzoException();
        }
        this.prezzo = prezzo;
        count++;
        idGioco = count;

    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }


    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public abstract void viewGame(int index);

}
