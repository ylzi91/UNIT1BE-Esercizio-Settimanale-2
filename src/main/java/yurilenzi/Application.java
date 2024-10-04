package yurilenzi;

import yurilenzi.classi.*;
import yurilenzi.classi.Collection;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        List<Gioco> giochi = aggiungiListaGiochi();
        List<GiocoDaTavolo> giochidaTavolo = List.of(aggiungiGiocoDaTavolo());
        OptionalDouble max = giochi.stream().mapToDouble(gioco -> gioco.getPrezzo()).max();
        List<Gioco> giocoAlto = giochi.stream().sorted(Comparator.comparingDouble(Gioco::getPrezzo).reversed()).limit(1).toList();
        System.out.println(giocoAlto.get(0).getTitolo() + " " + giocoAlto.get(0).getPrezzo());
        OptionalDouble media = giochi.stream().mapToDouble(Gioco::getPrezzo).average();
        System.out.println(media.getAsDouble());
        System.out.println(max.getAsDouble());
        vediListaGiochi(giochi);



        sceltamult:
        while (true){
            int scelta = 0;
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Aggiungi Gioco");
            System.out.println("2) Cerca per id");
            System.out.println("3) Filtra per prezzo");
            System.out.println("4) Filtra per numero giocatori");
            System.out.println("0) Esci");
            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta){

                case 0: {
                    break sceltamult;
                }
                case 1:{
                    try { //Qui Riccardo ho fatto una bischerata, non volevo cambiare tutto quello che avevo scritto XD
                        Gioco giocoAggiunto = Collection.addGame(scanner);
                        if(giocoAggiunto == null) System.out.println("Nessun gioco aggiunto");
                        else {
                            giochi.add(giocoAggiunto);
                            vediListaGiochi(giochi);
                        }
                    }
                    catch (NullPointerException e){
                        System.out.println("Uscita");
                    }
                    break;
                }
                case 2: {
                    case2:
                    while (true){
                        try {
                            int id = 0;
                            System.out.println("Scrivi l'id da cercare (0 per annullare)");
                            id =Integer.parseInt(scanner.nextLine());
                            if(id == 0) break case2;
                            else {
                                if (Collection.searchById(giochi, id).isEmpty()) {
                                    System.out.println("Nessun id trovato");
                                }
                                else{
                                    List<Gioco> giocoId = Collection.searchById(giochi,id);
                                    vediListaGiochi(giocoId);
                                    sceltaModRim:
                                    while (true){
                                        int sceltaModRim = 0;
                                        System.out.println("Vuoi 1) Modificare? 2) Rimuovere? -- 0 per tornare alla ricerca");
                                        sceltaModRim = Integer.parseInt(scanner.nextLine());
                                        switch (sceltaModRim){
                                            case 0: break sceltaModRim;
                                            default:
                                                System.out.println("Scelta non valida");
                                                break;
                                            case 2: {
                                                giochi.remove(giocoId.get(0));
                                                System.out.println("Elemento Rimosso");
                                                vediListaGiochi(giochi);
                                                break sceltaModRim;
                                            }
                                            case 1: {
                                                Collection.modGioco(giocoId.get(0), scanner);
                                                vediListaGiochi(giochi);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                        catch (Exception e){
                            System.out.println("Errore generico");
                        }


                    }
                    break;
                }
                case 3:{
                    while (true){
                        try{
                            double prezzo;
                            System.out.println("Per quale prezzo vuoi filtrare");
                            prezzo = Double.parseDouble(scanner.nextLine());
                            List<Gioco> priceMin = Collection.searchByPrice(giochi, prezzo);
                            if(priceMin.isEmpty()) System.out.println("Non ci sono giochi al di sotto di " +prezzo + "€");
                            else {
                                System.out.println("----------------- Prezzi a meno di " + prezzo + "€---------------------");
                            vediListaGiochi(priceMin);

                            }
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Errore generico");
                        }

                    }

                }
                case 4:
                    while (true){
                        try{
                            int nGioc;
                            System.out.println("Per quale numero di giocatori vuoi filtrare");
                            nGioc = Integer.parseInt(scanner.nextLine());
                            List<GiocoDaTavolo> filterNG = Collection.searchByNG(giochidaTavolo, nGioc);
                            if(filterNG.isEmpty()) System.out.println("Non ci sono giochi con " + nGioc + " giocatori" );
                            else {
                                System.out.println("----------------- Lista giochi con " + nGioc + " giocatori-----------------------------");
                                vediListaGiochiTavolo(filterNG);

                            }
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Errore generico");
                        }
                    }

            }
        }




    }



    public static Gioco[] aggingiVideogiochi(){
        Gioco[] games = {
                new Videogioco("The Legend of Zelda: Breath of the Wild", 2017, 59.99, "Nintendo Switch", 50, Generi.AZIONE),
                new Videogioco("God of War", 2018, 39.99, "PlayStation 4", 30, Generi.AZIONE),
                new Videogioco("Cyberpunk 2077", 2020, 49.99, "PC", 40, Generi.SPARATUTTO),
                new Videogioco("Minecraft", 2011, 26.95, "Multi-platform", 100, Generi.BUILDER),
                new Videogioco("The Witcher 3: Wild Hunt", 2015, 29.99, "PlayStation 4", 70, Generi.COMBATTIMENTO)
        };

        return games;
    }

    public static GiocoDaTavolo[] aggiungiGiocoDaTavolo(){
        GiocoDaTavolo[] tableGames = new GiocoDaTavolo[]{
                new GiocoDaTavolo("Catan", 1995, 35.99, 3, 75),
                new GiocoDaTavolo("Pandemic", 2008, 39.99, 4, 45),
                new GiocoDaTavolo("Ticket to Ride", 2004, 49.99, 5, 60),
                new GiocoDaTavolo("Carcassonne", 2000, 29.99, 5, 35),
                new GiocoDaTavolo("7 Wonders", 2010, 44.99, 7, 30)
        };
        return tableGames;
    }

    public static List<Gioco> aggiungiListaGiochi(){
        List<Gioco> giochi = new ArrayList<>();
        for (int i = 0; i < aggingiVideogiochi().length; i++) {
            giochi.add(aggingiVideogiochi()[i]);
        }
        for (int i = 0; i < aggiungiGiocoDaTavolo().length; i++) {
            giochi.add(aggiungiGiocoDaTavolo()[i]);
        }
        return giochi;
    }
    public static void vediListaGiochi(List<Gioco> giochi){
        for (int i = 0; i < giochi.size(); i++) {
            giochi.get(i).viewGame(i +1);
        }
    }public static void vediListaGiochiTavolo(List<GiocoDaTavolo> giochi){
        for (int i = 0; i < giochi.size(); i++) {
            giochi.get(i).viewGame(i +1);
        }
    }


}
