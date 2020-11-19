package _05_access_modifier_static_method_static_property.practice.static_property;

public class StaticProperty {
    private String name;

    private String engine;



    public static int numberOfCars;



    public StaticProperty(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
