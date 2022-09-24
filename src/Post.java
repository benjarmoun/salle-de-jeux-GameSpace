import java.util.ArrayList;

public class Post {
    private int id;
    private Console console;
    private Ecrant ecrant;
    private ArrayList<Game> games = new ArrayList<Game>();

    public Post(int id, Console console, Ecrant ecrant, ArrayList<Game> games) {
        this.id = id;
        this.console = console;
        this.ecrant = ecrant;
        this.games = games;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Ecrant getEcrant() {
        return ecrant;
    }

    public void setEcrant(Ecrant ecrant) {
        this.ecrant = ecrant;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
