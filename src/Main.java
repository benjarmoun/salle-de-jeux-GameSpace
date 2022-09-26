import java.nio.charset.Charset;
import java.time.*;
import java.util.*;
import java.util.spi.LocaleNameProvider;

public class Main {

    Player[] queue;
    ArrayList<Partie> schedule ;
    public static void main(String[] args) {

        Player player1 = new Player("ibrahim","benjarmoun","generated_code",1,LocalTime.parse("10:30:00"),"2h");

        LocalTime currentTime = LocalTime.parse("03:15");
        System.out.println(currentTime);

        ArrayList<Ecrant> ecrants = addEcrant();
//        afficherEcrant(ecrants);
//        ecrants.get(0).setQuantity(5);
        ArrayList<Game> games = addGame();
//        afficherGame(games);
//
        ArrayList<Console> consoles =addConsole();
//        afficherConsole(consoles);
//        afficherConsolesDispo(consoles);

        ArrayList<Post> postes= addPost(consoles,ecrants,games);
//        afficherPost(postes);
//        generateRandomCode(8);
//        Partie partie = createPartie();


        Partie partie = new Partie();
        System.out.println("\n\t\tPlease choose a poste ");
        afficherPost(postes);
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch(x){

            case 1:
                partie.setPost(postes.get(0));
                break;
            case 2:
                partie.setPost(postes.get(1));
                break;
            case 3:
                partie.setPost(postes.get(2));
                break;
            case 4:
                partie.setPost(postes.get(3));
                break;
            case 5:
                partie.setPost(postes.get(4));
                break;
            case 6:
                partie.setPost(postes.get(5));
                break;
            case 7:
                partie.setPost(postes.get(6));
                break;
            case 8:
                partie.setPost(postes.get(7));
                break;
            case 9:
                partie.setPost(postes.get(8));
                break;
            default:
        System.out.println("Incorrect choice");
                break;
        }

//        System.out.println(partie.getPost());
        System.out.println("Please choose a game");
        for(int i=0 ; i< partie.getPost().getGames().size() ; i++){
            System.out.println(partie.getPost().getGames().get(i));
        }
        int y = scanner.nextInt();
        switch(y){

            case 1:
                partie.setGame(partie.getPost().getGames().get(y-1));
                break;
            case 2:
                partie.setGame(partie.getPost().getGames().get(y-1));
                break;
            case 3:
                partie.setGame(partie.getPost().getGames().get(y-1));
                break;
            case 4:
                partie.setGame(partie.getPost().getGames().get(y-1));
                break;
            default:
                System.out.println("Incorrect choice");
                break;
        }

        System.out.println("set start time");
        String debut = scanner.next();
        partie.setDebutTime(LocalTime.parse(debut));
        System.out.println("set period time");

        String periode = scanner.next();
        partie.setPeriode(LocalTime.parse(periode));
        partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));

//        System.out.println(partie.getGame());
        System.out.println(partie);
        partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));

            //        check if available








    }

    public static LocalTime getEndTime(LocalTime debutTime, String periode){
        String[] time = periode.split(":");
        debutTime = debutTime.plusHours(Integer.parseInt(time[0]));
        debutTime = debutTime.plusMinutes(Integer.parseInt(time[1]));
        return debutTime;
    }
    public static Partie createPartie(){
        Partie partie = new Partie();
//        Partie partie1 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("10:30:00"),LocalTime.parse("30:00"));
//        partie.setPlayer(player1);
//        partie.setPost(postes.get(0));
        partie.setDebutTime(LocalTime.parse("10:30:00"));
        partie.setPeriode(LocalTime.parse("00:30"));
        partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));
        LocalTime endTime= getEndTime(LocalTime.parse("10:30:00"),"00:30" );
        System.out.println(partie.toString());

        return partie ;
    }

    public  void reservation(Partie partie){



        this.schedule.add(partie);
    }

    public static void generateRandomCode(int n)
    {
        String Code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(Code.length() * Math.random());
            sb.append(Code.charAt(index));
        }
        System.out.println(sb.toString());
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
            System.out.println("\n"+pst.getId()+"- console: "+pst.getConsole().getName()+" ecrant: "+pst.getEcrant().getMake());
            System.out.print("Games: ");
            for(int i=0; i< pst.getGames().size(); i++)
            System.out.print(pst.getGames().get(i).getId()+"- " +pst.getGames().get(i).getName()+" ");
            System.out.print("\n");
        }
    }
}