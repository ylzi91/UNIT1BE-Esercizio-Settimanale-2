package yurilenzi.classi;


public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private Generi genere;


    public Videogioco(String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataGioco, Generi genere) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }


    @Override
    public void viewGame(int index) {
        System.out.println("----------------------"+ index +"------------------------");
        System.out.println("id: " + (idGioco));
        System.out.println("Titolo: " + titolo);
        System.out.println("Anno pubblicazione " + annoPubblicazione);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Piattaforma: " + piattaforma);
        System.out.println("Durata: " + durataGioco);
        System.out.println("Genere: " + genere);
        System.out.println("----------------------------------------------");
    }
}
