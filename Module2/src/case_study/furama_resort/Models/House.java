package case_study.furama_resort.Models;

public class House extends Services{
    private String standardRoom;
    private String differentUseful;
    private String numFloors;

    public House() {

    }

    public House(String id, String name, String placeArea, String price,
          String maxPeople, String rentDay, String standardRoom,
          String differentUseful, String numFloors) {
        super(id, name, placeArea, price, maxPeople, rentDay);
        this.standardRoom = standardRoom;
        this.differentUseful = differentUseful;
        this.numFloors = numFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDifferentUseful() {
        return differentUseful;
    }

    public void setDifferentUseful(String differentUseful) {
        this.differentUseful = differentUseful;
    }

    public String getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(String numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public void showInfo() {
        System.out.println("-Id: " + super.getId()
                + "\t-Name: " + super.getName()
                + "\t-Place area: " + super.getPlaceArea()
                + "\t-Price: " + super.getPrice()
                + "\t-Max People: " + super.getMaxPeople()
                + "\t-Standard room: " + getStandardRoom()
                + "\t-Different useful: " + getDifferentUseful()
                + "\t-Number floors: " + getNumFloors());
    }
}
