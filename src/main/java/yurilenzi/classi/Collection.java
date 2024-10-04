package yurilenzi.classi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Collection {

    public static Gioco addGame(Scanner scn) {
        sceltaGame:
        while (true) {
            byte scelta = 0;
            System.out.println("Cosa vuoi aggiungere?");
            System.out.println("1) Videogioco");
            System.out.println("2) Gioco da tavolo");
            scelta = Byte.parseByte(scn.nextLine());
            switch (scelta) {
                case 1: {
                    try {
                        System.out.println("Titolo VideoGioco");
                        String titolo = scn.nextLine();
                        System.out.println("Anno di pubblicazione");
                        int annoPubblicazione = Integer.parseInt(scn.nextLine());
                        System.out.println("Prezzo");
                        double prezzo = Double.parseDouble(scn.nextLine());
                        if (prezzo < 1) throw new PrezzoException();
                        System.out.println("Durata di gioco");
                        int durata = Integer.parseInt(scn.nextLine());
                        System.out.println("Piattaforma");
                        String piattaforoma = scn.nextLine();
                        System.out.println("Generi");
                        System.out.println(Arrays.stream(Generi.values()).toList());
                        Generi genere = Generi.valueOf(scn.nextLine());
                        if (
                                genere != Generi.AZIONE &&
                                        genere != Generi.BUILDER &&
                                        genere != Generi.HORROR &&
                                        genere != Generi.COMBATTIMENTO &&
                                        genere != Generi.SPARATUTTO) {
                            throw new GenreException();
                        }
                        Gioco newGioco = new Videogioco(titolo, annoPubblicazione, prezzo, piattaforoma, durata, genere);
                        return newGioco;
                    } catch (PrezzoException e) {
                        System.out.println(e.getMessage());
                    } catch (GenreException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Errore generico");
                    }


                }
                case 2: {
                    try {
                        System.out.println("Titolo VideoGioco");
                        String titolo = scn.nextLine();
                        System.out.println("Anno di pubblicazione");
                        int annoPubblicazione = Integer.parseInt(scn.nextLine());
                        System.out.println("Prezzo");
                        double prezzo = Double.parseDouble(scn.nextLine());
                        System.out.println("Numero di giocatori");
                        int numG = Integer.parseInt(scn.nextLine());
                        if (numG < 2 || numG > 10) throw new NumeroGiocatoriException();
                        System.out.println("Durata media");
                        int ore = Integer.parseInt(scn.nextLine());
                        Gioco newGioco = new GiocoDaTavolo(titolo, annoPubblicazione, prezzo, numG, ore);
                        return newGioco;
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Errore generico");
                    }


                }
                case 0:
                    return null;


            }

        }

    }
    public static List<Gioco> searchById(List<Gioco> giochi, int id){

       return giochi.stream().filter(gioco -> gioco.getIdGioco() == id).toList();

    }
    public static List<Gioco> searchByPrice(List<Gioco> giochi , double prezzo){
        return giochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
    }
}
