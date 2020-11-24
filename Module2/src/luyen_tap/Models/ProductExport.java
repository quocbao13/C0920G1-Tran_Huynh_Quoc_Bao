package luyen_tap.Models;

public class ProductExport extends Product{
    private String priceExport;
    private String addressExport;

    public ProductExport(){
    }

    public ProductExport(String id, String idProduct, String nameProduct, String price, String number,
                         String brand,String priceExport, String addressExport){
        super(id,idProduct,nameProduct,price,number,brand);
        this.priceExport = priceExport;
        this.addressExport = addressExport;

    }

    public String getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(String priceExport) {
        this.priceExport = priceExport;
    }

    public String getAddressExport() {
        return addressExport;
    }

    public void setAddressExport(String addressExport) {
        this.addressExport = addressExport;
    }

    @Override
    public void showInfo() {

    }
}
