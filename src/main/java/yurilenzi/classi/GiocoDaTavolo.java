package yurilenzi.classi;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int mediaMinuti;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int mediaMinuti) {
        super(titolo, annoPubblicazione, prezzo);
        if (numeroGiocatori < 2 || numeroGiocatori > 10)
            throw new NumeroGiocatoriException();
        this.numeroGiocatori = numeroGiocatori;
        this.mediaMinuti = mediaMinuti;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public int getMediaMinuti() {
        return mediaMinuti;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public void setMediaMinuti(int mediaMinuti) {
        this.mediaMinuti = mediaMinuti;
    }

    @Override
    public void viewGame(int index) {
        System.out.println("----------------------"+ index+"---------------------------");
        System.out.println("id: " + (idGioco));
        System.out.println("Titolo: " + titolo);
        System.out.println("Anno pubblicazione" + annoPubblicazione);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Numero Giocatori: " + numeroGiocatori);
        System.out.println("Durata media: " + mediaMinuti);
        System.out.println("-------------------------------------------------");
    }
}
