package yurilenzi.classi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Collection {

    public static Gioco addGame(Scanner scn) {
        sceltaGame:
        while (true) {
            byte scelta = 0;
            System.out.println("Cosa vuoi aggiungere? 0 per annullare");
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

    public static List<Gioco> searchById(List<Gioco> giochi, int id) {

        return giochi.stream().filter(gioco -> gioco.getIdGioco() == id).toList();

    }

    public static List<Gioco> searchByPrice(List<Gioco> giochi, double prezzo) {
        return giochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
    }

    public static List<GiocoDaTavolo> searchByNG(List<GiocoDaTavolo> giochidaTavolo, int nGioc) {
        return giochidaTavolo.stream().filter(giocoDaTavolo -> giocoDaTavolo.getNumeroGiocatori() == nGioc).toList();
    }

    public static Gioco modGioco(Gioco gioco, Scanner scanner) {
        if (gioco instanceof GiocoDaTavolo) {
            while (true) {
                try {
                    System.out.println("Modifica titolo: ");
                    gioco.setTitolo(scanner.nextLine());
                    System.out.println("Modifica prezzo");
                    gioco.setPrezzo(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Modifica numero giocatori");
                    ((GiocoDaTavolo) gioco).setNumeroGiocatori(Integer.parseInt(scanner.nextLine()));
                    if (((GiocoDaTavolo) gioco).getNumeroGiocatori() < 2 || ((GiocoDaTavolo) gioco).getNumeroGiocatori() > 10)
                        throw new NumeroGiocatoriException();
                    break;
                } catch (NumeroGiocatoriException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Errore nell' inserimento");
                }

            }
        }
        else if (gioco instanceof Videogioco){
            while (true){
                try {
                    System.out.println("Modifica titolo: ");
                    gioco.setTitolo(scanner.nextLine());
                    System.out.println("Modifica prezzo");
                    gioco.setPrezzo(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Modifica durata gioco");
                    ((Videogioco) gioco).setDurataGioco(Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Errore nell' inserimento");
                }
            }
        }
        return gioco;
    }
}