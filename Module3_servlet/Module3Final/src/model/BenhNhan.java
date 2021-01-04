package model;

public class BenhNhan {
    private int id;
    private String name;

    public BenhNhan() {}

    public BenhNhan(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BenhNhan(int id) {
        this.id = id;
    }

    public BenhNhan(String name) {
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
