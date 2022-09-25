import java.time.*;
public class Player {
    private String prenom;
    private String nom;
    private int post_id;
    private LocalTime debutTime;
    private String periode;

    public Player(String prenom, String nom, int post_id, LocalTime debutTime, String periode) {
        this.prenom = prenom;
        this.nom = nom;
        this.post_id = post_id;
        this.debutTime = debutTime;
        this.periode = periode;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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
