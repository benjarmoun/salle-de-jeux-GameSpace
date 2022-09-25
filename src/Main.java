import java.time.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player[] queue;


        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        ArrayList<Ecrant> ecrants = addEcrant();
//        afficherEcrant(ecrants);
//        ecrants.get(0).setQuantity(5);
//        afficherEcrant(ecrants);
//
        ArrayList<Game> games = addGame();
//        afficherGame(games);
//
        ArrayList<Console> consoles =addConsole();
//        afficherConsole(consoles);
//        afficherConsolesDispo(consoles);

        ArrayList<Post> postes= addPost(consoles,ecrants,games);
        afficherPost(postes);


    }

    public static void afficherEcrant(ArrayList<Ecrant> ecr){
        for (Ecrant one: ecr) {
            System.out.println(one.getId());
            System.out.println(one.getMake());
            System.out.println(one.getQuantity()+"\n");
        }
    }
    public static void afficherEcrantsDispo(ArrayList<Ecrant> ecr){
        for (Ecrant one: ecr) {
            if (one.getQuantity() > 0) {
                System.out.println(one.getId());
                System.out.println(one.getMake());
                System.out.println(one.getQuantity() + "\n");
            }
        }
    }
    public static void afficherGame(ArrayList<Game> games){
        for (Game one: games) {
            System.out.println(one.getName());
            System.out.println(one.getCategory()+"\n");
        }
    }
    public static void afficherConsole(ArrayList<Console> consoles){
        for (Console one: consoles) {
            System.out.println(one.getQuantity());
            System.out.println(one.getName()+"\n");
        }
    }
    public static void afficherConsolesDispo(ArrayList<Console> consoles){

        for (Console one: consoles) {
            if (one.getQuantity() > 0){
            System.out.println(one.getQuantity());
            System.out.println(one.getName()+"\n");
            }
        }
    }

    public static ArrayList<Ecrant> addEcrant(){
        ArrayList<Ecrant> Ecrants= new ArrayList<>();
        Ecrants.add(new Ecrant(1 , "dell", 3));
        Ecrants.add(new Ecrant(2 , "HP", 1));
        Ecrants.add(new Ecrant(3 , "Asus", 3));
        Ecrants.add(new Ecrant(4 , "Samsung", 2));
        return Ecrants;
    }

    public static ArrayList<Game> addGame(){
        ArrayList<Game> Games = new ArrayList<Game>();
        Games.add(new Game(1,"fifa","football"));
        Games.add(new Game(2,"pes","football"));
        Games.add(new Game(3,"Counter-Strike","Guerre"));
        Games.add(new Game(4,"Assassin's Creed","Guerre"));
        return Games;
    }

    public static ArrayList<Console> addConsole(){
        ArrayList<Console> Consoles =new ArrayList<Console>();
        Console cc = new Console(1,"Xbox",4);
        Consoles.add(cc);
        Consoles.add(new Console(1,"PlayStation5",3));
        Consoles.add(new Console(1,"Nintendo switch",2));

        return Consoles;
    }
    public static ArrayList<Post> addPost(ArrayList<Console> consoles, ArrayList<Ecrant> ecrants, ArrayList<Game> games){
        ArrayList<Post> Posts =new ArrayList<Post>();
        Posts.add(new Post(1,consoles.get(0),ecrants.get(0),games));
        Posts.add(new Post(2,consoles.get(0),ecrants.get(0),games));
        Posts.add(new Post(3,consoles.get(0),ecrants.get(0),games));
        Posts.add(new Post(4,consoles.get(0),ecrants.get(1),games));
        Posts.add(new Post(5,consoles.get(1),ecrants.get(2),games));
        Posts.add(new Post(6,consoles.get(1),ecrants.get(2),games));
        Posts.add(new Post(7,consoles.get(1),ecrants.get(2),games));
        Posts.add(new Post(8,consoles.get(2),ecrants.get(3),games));
        Posts.add(new Post(9,consoles.get(2),ecrants.get(3),games));

        return Posts;
    }
    public static void afficherPost(ArrayList<Post> postes){
        for (Post pst:postes){
            System.out.println("\n\n"+pst.getId()+"- console: "+pst.getConsole().getName()+" ecrant: "+pst.getEcrant().getMake());
            System.out.print("Games: ");
            for(int i=0; i< pst.getGames().size(); i++)
            System.out.print(pst.getGames().get(i).getId()+"- " +pst.getGames().get(i).getName()+" ");
        }
    }

}