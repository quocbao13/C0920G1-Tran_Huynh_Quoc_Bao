package Model;

public class Division {
    private int id;
    private String name;

    Division(){}

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Division(int id) {
        this.id = id;
    }

    public Division(String name) {
        this.name = name;
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
}
