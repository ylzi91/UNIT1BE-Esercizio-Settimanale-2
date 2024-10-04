package yurilenzi;

import yurilenzi.classi.*;
import yurilenzi.classi.Collection;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        List<Gioco> giochi = aggiungiListaGiochi();
        vediListaGiochi(giochi);


        sceltamult:
        while (true){
            int scelta = 0;
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Aggiungi Gioco");
            System.out.println("2) Cerca per id");
            System.out.println("3) Filtra per prezzo");
            System.out.println("0) Esci");
            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta){

                case 0: {
                    break sceltamult;
                }
                case 1:{
                    try {
                        giochi.add(Collection.addGame(scanner));
                        vediListaGiochi(giochi);
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
                                    vediListaGiochi(Collection.searchById(giochi, id));
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

    public static Gioco[] aggiungiGiocoDaTavolo(){
        Gioco[] tableGames = new GiocoDaTavolo[]{
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
    }


}
