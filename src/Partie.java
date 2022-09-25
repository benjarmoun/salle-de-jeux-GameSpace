import java.time.LocalTime;

public class Partie {
    private int id;
    private Player player;
    private Post post;
    private LocalTime debutTime;
    private String periode;

    public Partie(int id, Player player, Post post, LocalTime debutTime, String periode) {
        this.id = id;
        this.player = player;
        this.post = post;
        this.debutTime = debutTime;
        this.periode = periode;
    }
    public Partie(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalTime getDebutTime() {
        return debutTime;
    }

    public void setDebutTime(LocalTime debutTime) {
        this.debutTime = debutTime;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
}