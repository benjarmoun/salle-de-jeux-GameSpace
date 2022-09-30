import java.nio.charset.Charset;
import java.time.*;
import java.util.*;
import java.util.spi.LocaleNameProvider;

public class Main {
    static ArrayList<Partie> Queue = new ArrayList<Partie>();
    static ArrayList<Partie> schedule = new ArrayList<Partie>();
    public static void main(String[] args) {


        ApplicationMain();

    }

    public static void ApplicationMain(){



        System.out.println("choose an option");
        System.out.println("1- play a game");
        System.out.println("2- check reservations");
        System.out.println("3- check profit");
        System.out.println("4- check queue");
        System.out.println("5- Exit");
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        switch(c){

            case 1:
                Application();
                ApplicationMain();

                break;
            case 2:
                System.out.println(schedule);
                ApplicationMain();

                break;
            case 3:
//                profit(schedule);
                System.out.println("Today's total profit is: "+ profit(schedule) + "DH");

                ApplicationMain();
                break;
            case 4:
                System.out.println(Queue);
                ApplicationMain();

                break;



            default:
                System.out.println("Incorrect choice");
                break;
        }
    }
    public static void Application(){
        Player player1 = new Player("ibrahim","benjarmoun",generateRandomCode(6),1,LocalTime.parse("10:30:00"),"2h");

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
            System.out.println(i+1 +"- " + partie.getPost().getGames().get(i));
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


        System.out.println("Set how much time you want to play");

        System.out.println("1- 30 min 5DH");
        System.out.println("2- 1 heure 10DH");
        System.out.println("3- 2 heure 18DH");
        System.out.println("4- 5 heure 40 DH");
        System.out.println("5- toute la journée 65 DH");

        int t = scanner.nextInt();
        switch(t){

            case 1:
                partie.setPeriode(LocalTime.parse("00:30"));
                partie.setPrice(5);
                break;
            case 2:
                partie.setPeriode(LocalTime.parse("01:00"));
                partie.setPrice(10);
                break;
            case 3:
                partie.setPeriode(LocalTime.parse("02:00"));
                partie.setPrice(18);
                break;
            case 4:
                partie.setPeriode(LocalTime.parse("05:00"));
                partie.setPrice(40);
                break;
            case 5:
                partie.setDebutTime(LocalTime.parse("09:00"));
                partie.setPeriode(LocalTime.parse("11:00"));
                partie.setPrice(65);

                break;
            default:
                System.out.println("Incorrect choice");
                break;
        }

        if(t != 5){
            System.out.println("set start time");
            String debut = scanner.next();
            partie.setDebutTime(LocalTime.parse(debut));
        }
        partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));

        Player plyr =new Player();
        System.out.println("set the player's first name");
        String fname = scanner.next();
        System.out.println("set the player's last name");
        plyr.setPrenom(fname);
        String lname = scanner.next();
        plyr.setNom(lname);
        plyr.setPlayer_code(generateRandomCode(6));
        plyr.setPost_id(partie.getPost().getId());
        plyr.setDebutTime(partie.getDebutTime());
        plyr.setPeriode(partie.getPeriode().toString());
        partie.setPlayer(plyr);







        Partie partie1 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("10:00:00"),LocalTime.parse("00:30:00"),5);
        Partie partie2 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("11:30:00"),LocalTime.parse("00:30:00"),5);
        Partie partie3 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("15:30:00"),LocalTime.parse("00:30:00"),5);
        Partie partie4 = new Partie(player1,postes.get(1),games.get(0),LocalTime.parse("11:30:00"),LocalTime.parse("00:30:00"),5);
        partie1.setEndTime(getEndTime(partie1.getDebutTime(),partie1.getPeriode().toString()));
        partie2.setEndTime(getEndTime(partie2.getDebutTime(),partie2.getPeriode().toString()));
        partie3.setEndTime(getEndTime(partie3.getDebutTime(),partie3.getPeriode().toString()));
        partie4.setEndTime(getEndTime(partie4.getDebutTime(),partie4.getPeriode().toString()));

        reservation(partie1);
        reservation(partie2);
        reservation(partie3);
        reservation(partie4);

        //        check if available
        int p=1;
        boolean TEST = false;
        for (int i = 0; i< schedule.size() ; i++) {

            if (((partie.getDebutTime().compareTo(LocalTime.parse("09:00")) >= 0 && partie.getEndTime().compareTo(LocalTime.parse("12:00")) <= 0)
                    || (partie.getDebutTime().compareTo(LocalTime.parse("14:00")) >= 0 && partie.getEndTime().compareTo(LocalTime.parse("20:00")) <= 0))) {
                if (partie.getPost() == schedule.get(i).getPost()) {
                    if (
                            !((schedule.get(i).getDebutTime().compareTo(partie.getDebutTime()) > 0 //compared debut in schedule whit wanted start time
                                    && schedule.get(i).getDebutTime().compareTo(partie.getEndTime()) >= 0) //compared debut in schedule whit wanted END time
                                    || (schedule.get(i).getEndTime().compareTo(partie.getDebutTime()) <= 0))
                    ) {

                        System.out.println("post occupied at this period");
                        TEST = false;
                        System.out.println("join the wait list?");
                        System.out.println("1- YES");
                        System.out.println("2- NO");

                        int l;
                        l = scanner.nextInt();

                        switch(l){


                            case 1:
                                partie.setDebutTime(schedule.get(i).getEndTime());
                                partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));
                                Queue.add(partie);
                                System.out.println("you were added to the wait list successfully");
                                break;
                            case 2:
                                break;

                            default:
                                System.out.println("Incorrect choice");
                                break;
                        }

//                        checkAvailablePostAtTime(partie.getDebutTime(),partie.getEndTime(),postes);

                        break;
                    } else {
                        TEST = true;
//                        System.out.println("reservation done");
                        // reservation(partie3);

                    }
                } else {
                    p++;
                    if(p == schedule.size()){
                        System.out.println("reservation done successfully 1");
                        reservation(partie);
                        break;

                    }
                }
            } else {
                System.out.println("Period out of working time");
                break;
            }
        }
        if(TEST){
            System.out.println("reservation done successfully 2");
            reservation(partie);

        }



//        Player player1 = new Player("ibrahim","benjarmoun","generated_code",1,LocalTime.parse("10:30:00"),"2h");
//
////        LocalTime currentTime = LocalTime.parse("03:15");
////        System.out.println(currentTime);
//
//        ArrayList<Ecrant> ecrants = addEcrant();
////        afficherEcrant(ecrants);
////        ecrants.get(0).setQuantity(5);
//        ArrayList<Game> games = addGame();
////        afficherGame(games);
////
//        ArrayList<Console> consoles =addConsole();
////        afficherConsole(consoles);
////        afficherConsolesDispo(consoles);
//
//        ArrayList<Post> postes= addPost(consoles,ecrants,games);
////        afficherPost(postes);
////        generateRandomCode(8);
////        Partie partie = createPartie();
//
//
//        Partie partie = new Partie();
//
//
//
//        System.out.println("\n\t\tPlease choose a poste ");
//        afficherPost(postes);
//        System.out.println("\n10- Cancel");
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        switch(x){
//
//            case 1:
//                partie.setPost(postes.get(0));
//                break;
//            case 2:
//                partie.setPost(postes.get(1));
//                break;
//            case 3:
//                partie.setPost(postes.get(2));
//                break;
//            case 4:
//                partie.setPost(postes.get(3));
//                break;
//            case 5:
//                partie.setPost(postes.get(4));
//                break;
//            case 6:
//                partie.setPost(postes.get(5));
//                break;
//            case 7:
//                partie.setPost(postes.get(6));
//                break;
//            case 8:
//                partie.setPost(postes.get(7));
//                break;
//            case 9:
//                partie.setPost(postes.get(8));
//                break;
//            case 10:
//                ApplicationMain();
//                break;
//            default:
//                System.out.println("Incorrect choice");
//                break;
//        }
//
////        System.out.println(partie.getPost());
//        System.out.println("Please choose a game");
//        for(int i=0 ; i< partie.getPost().getGames().size() ; i++){
//            System.out.println(i+1+"- " + partie.getPost().getGames().get(i));
//        }
//        int y = scanner.nextInt();
//        switch(y){
//
//            case 1:
//                partie.setGame(partie.getPost().getGames().get(y-1));
//                break;
//            case 2:
//                partie.setGame(partie.getPost().getGames().get(y-1));
//                break;
//            case 3:
//                partie.setGame(partie.getPost().getGames().get(y-1));
//                break;
//            case 4:
//                partie.setGame(partie.getPost().getGames().get(y-1));
//                break;
//            default:
//                System.out.println("Incorrect choice");
//                break;
//        }
//
//        System.out.println("Set how much time you want to play");
//
//        System.out.println("1- 30 min 5DH");
//        System.out.println("2- 1 heure 10DH");
//        System.out.println("3- 2 heure 18DH");
//        System.out.println("4- 5 heure 40 DH");
//        System.out.println("5- toute la journée 65 DH");
//
//        int t = scanner.nextInt();
//        switch(t){
//
//            case 1:
//                partie.setPeriode(LocalTime.parse("00:30"));
//                break;
//            case 2:
//                partie.setPeriode(LocalTime.parse("01:00"));
//                break;
//            case 3:
//                partie.setPeriode(LocalTime.parse("02:00"));
//                break;
//            case 4:
//                partie.setPeriode(LocalTime.parse("05:00"));
//                break;
//            case 5:
//                partie.setDebutTime(LocalTime.parse("09:00"));
//                partie.setPeriode(LocalTime.parse("11:00"));
//                break;
//            default:
//                System.out.println("Incorrect choice");
//                break;
//        }
//
//        if(t != 5){
//            System.out.println("set start time");
//            String debut = scanner.next();
//            partie.setDebutTime(LocalTime.parse(debut));
//        }
//        partie.setEndTime(getEndTime(partie.getDebutTime(),partie.getPeriode().toString()));
////        System.out.println(partie.getGame());
////        System.out.println(partie);
//
//
////        Partie partie1 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("10:30:00"),LocalTime.parse("00:30:00"));
////        Partie partie3 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("11:30:00"),LocalTime.parse("00:30:00"));
////        Partie partie4 = new Partie(player1,postes.get(0),games.get(0),LocalTime.parse("15:30:00"),LocalTime.parse("00:30:00"));
////        Partie partie2 = new Partie(player1,postes.get(1),games.get(0),LocalTime.parse("11:30:00"),LocalTime.parse("00:30:00"));
////        partie1.setEndTime(getEndTime(partie1.getDebutTime(),partie1.getPeriode().toString()));
////        partie2.setEndTime(getEndTime(partie2.getDebutTime(),partie2.getPeriode().toString()));
////        partie3.setEndTime(getEndTime(partie3.getDebutTime(),partie3.getPeriode().toString()));
////        partie4.setEndTime(getEndTime(partie4.getDebutTime(),partie4.getPeriode().toString()));
////
////        reservation(partie1);
////        reservation(partie2);
////        reservation(partie3);
////        reservation(partie4);
//
//        //        check if available
//        int p=1;
//        boolean TEST = false;
//        for (int i = 0; i< schedule.size() ; i++) {
////            System.out.println(schedule.get(i));
//
//            if (((partie.getDebutTime().compareTo(LocalTime.parse("09:00")) >= 0 && partie.getEndTime().compareTo(LocalTime.parse("12:00")) <= 0)
//                    || (partie.getDebutTime().compareTo(LocalTime.parse("14:00")) >= 0 && partie.getEndTime().compareTo(LocalTime.parse("20:00")) <= 0))) {
//                if (partie.getPost() == schedule.get(i).getPost()) {
//                    if (
//                            !((schedule.get(i).getDebutTime().compareTo(partie.getDebutTime()) > 0 //compared debut in schedule whit wanted start time
//                                    && schedule.get(i).getDebutTime().compareTo(partie.getEndTime()) >= 0) //compared debut in schedule whit wanted END time
//                                    || (schedule.get(i).getEndTime().compareTo(partie.getDebutTime()) <= 0))
//                    ) {
//
//
//                        System.out.println("post occupied at this period");
//                        TEST = false;
//                        break;
//                    } else {
//                        TEST = true;
//                    }
//                } else {
//                    p++;
//                    if(p == schedule.size()){
//                        System.out.println("reservation done 2");
//                        reservation(partie);
//
//                    }
//                }
//            } else {
//                System.out.println("Period not available");
//            }
//        }
//
//        if(TEST){
//            System.out.println("reservation done 3");
//            reservation(partie);
//        }

    }
    public static void checkAvailablePostAtTime(LocalTime start, LocalTime end, ArrayList<Post> postes){

        for(Post post:postes) {
            for (int i = 0; i < schedule.size(); i++) {
                if (post == schedule.get(i).getPost()) {
                    if (
                            ((schedule.get(i).getDebutTime().compareTo(start) > 0 //compared debut in schedule whit wanted start time
                                    && schedule.get(i).getDebutTime().compareTo(end) >= 0) //compared debut in schedule whit wanted END time
                                    || (schedule.get(i).getEndTime().compareTo(start) <= 0))
                    ) {
                        System.out.println("post :" +post);
                    }
                }
            }
        }
    }
    public static int profit(ArrayList<Partie> schedule){
        int profitTotal = 0;
        for (Partie prf:schedule){
            profitTotal += prf.getPrice();
        }
        return profitTotal;

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

    public static void reservation(Partie partie){

        schedule.add(partie);
    }

    public static String generateRandomCode(int n)
    {
        String Code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(Code.length() * Math.random());
            sb.append(Code.charAt(index));
        }
//        System.out.println(sb.toString());
        return sb.toString();
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
            for(int i=0; i< pst.getGames().size(); i++) {
                System.out.print(pst.getGames().get(i).getId()+"- " +pst.getGames().get(i).getName()+" ");
            }
            System.out.print("\n");
        }
    }
}