import java.time.LocalTime;

public class Partie {

    private Player player;
    private Post post;
    private Game game;
    private LocalTime debutTime;
    private LocalTime endTime;
    private LocalTime periode;

    public Partie(Player player, Post post, Game game, LocalTime debutTime, LocalTime periode) {
        this.player = player;
        this.post = post;
        this.game = game;
        this.debutTime = debutTime;
        this.periode = periode;
    }

    public Partie() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalTime getDebutTime() {
        return debutTime;
    }

    public void setDebutTime(LocalTime debutTime) {
        this.debutTime = debutTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getPeriode() {
        return periode;
    }

    public void setPeriode(LocalTime periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return "Partie{\n\t" +
                "player=" + player +
                ",\n\t post=" + post +
                ",\n\t chosen game=" + game +
                ",\n\t debutTime=" + debutTime +
                ",\n\t endTime=" + endTime +
                ",\n\t periode=" + periode +
                '}';
    }
}