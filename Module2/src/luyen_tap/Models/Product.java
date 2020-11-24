package luyen_tap.Models;

public abstract class Product {
    private String id;
    private String idProduct;
    private String nameProduct;
    private String price;
    private String number;
    private String brand;

    public Product() {

    }

    public Product(String id, String idProduct, String nameProduct, String price, String number, String brand) {
        this.id = id;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.number = number;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract void showInfo();
}
