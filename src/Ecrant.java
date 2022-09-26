public class Ecrant {
    private int id;
    private String make;
    private int quantity;

    public Ecrant(int id, String make, int quantity) {
        this.id = id;
        this.make = make;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ecrant{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
