package luyen_tap.Models;

public class ProductImport extends Product{
    private String priceImport;
    private String addressImport;
    private String taxImport;

    public ProductImport(){
    }

    public ProductImport(String id, String idProduct, String nameProduct, String price, String number,
                  String brand,String priceImport, String addressImport, String taxImport){
        super(id,idProduct,nameProduct,price,number,brand);
        this.priceImport = priceImport;
        this.addressImport = addressImport;
        this.taxImport = taxImport;

    }



    public String getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(String priceImport) {
        this.priceImport = priceImport;
    }

    public String getAddressImport() {
        return addressImport;
    }

    public void setAddressImport(String addressImport) {
        this.addressImport = addressImport;
    }

    public String getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(String taxImport) {
        this.taxImport = taxImport;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t-priceImport: " + priceImport +
                "\t-addressImport: " + addressImport +
                "\t-taxImport: " + taxImport ;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
