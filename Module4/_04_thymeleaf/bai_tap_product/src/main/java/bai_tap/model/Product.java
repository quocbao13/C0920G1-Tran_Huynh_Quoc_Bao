package bai_tap.model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private int idProduct;
    private String nameProduct;
    private int priceProduct;
    private MultipartFile imgProduct;
    private int quantity;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, int priceProduct, MultipartFile imgProduct, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.imgProduct = imgProduct;
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public MultipartFile getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(MultipartFile imgProduct) {
        this.imgProduct = imgProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
