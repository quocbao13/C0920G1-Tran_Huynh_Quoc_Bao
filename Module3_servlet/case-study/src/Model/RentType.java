package Model;

public class RentType {
    private int id;
    private String name;
    private String cost;

    public RentType() {

    }

    public RentType(int id, String name, String cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public RentType(int id) {
        this.id = id;
    }

    public RentType(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
