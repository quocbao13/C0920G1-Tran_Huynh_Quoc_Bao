package case_study.furama_resort.Models;

public class Room extends Services{
    private String freeService;

    public Room() {

    }

    public Room(String id, String name, String placeArea, String price,
         String maxPeople, String rentDay, String freeService) {
        super(id, name, placeArea, price, maxPeople, rentDay);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfo() {
        System.out.println("-Id: " + super.getId()
                + "\t-Name: " + super.getName()
                + "\t-Place area: " + super.getPlaceArea()
                + "\t-Price: " + super.getPrice()
                + "\t-Max People: " + super.getMaxPeople()
                + "\t-Free service: " + getFreeService());
    }
}
