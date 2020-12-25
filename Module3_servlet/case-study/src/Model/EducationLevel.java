package Model;

public class EducationLevel {
    private int id;
    private String name;

    public EducationLevel() {

    }

    public EducationLevel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EducationLevel(int id) {
        this.id = id;
    }

    public EducationLevel(String name) {
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
