package yurilenzi.classi;

public class PrezzoException extends RuntimeException {
    public PrezzoException() {
        super("Il prezzo deve essere maggiore di 1");
    }
}
