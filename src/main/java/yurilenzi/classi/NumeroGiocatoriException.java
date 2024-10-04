package yurilenzi.classi;

public class NumeroGiocatoriException extends RuntimeException {
    public NumeroGiocatoriException() {
        super("Il numero di giocatori deve essere tra 2 e 10");
    }
}
