package case_study.furama_resort.Models;

public abstract class Services {
    private String id;
    private String name;
    private String placeArea;
    private String price;
    private String maxPeople;
    private String rentDay;

    Services(){

    }

    Services(String id, String name, String placeArea, String price, String maxPeople, String rentDay){
        this.id = id;
        this.name = name;
        this.placeArea = placeArea;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentDay = rentDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceArea() {
        return placeArea;
    }

    public void setPlaceArea(String placeArea) {
        this.placeArea = placeArea;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentDay() {
        return rentDay;
    }

    public void setRentDay(String rentDay) {
        this.rentDay = rentDay;
    }

    public abstract void showInfo();

}
