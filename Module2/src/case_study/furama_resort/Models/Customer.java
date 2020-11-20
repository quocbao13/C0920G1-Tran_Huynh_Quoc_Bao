package case_study.furama_resort.Models;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String birthDayCustomer;
    private String genderCustomer;
    private String idNumberCustomer;
    private String phoneCustomer;
    private String emailCustomer;
    private String typeOfCustomer;
    private String addressCustomer;
    private Services services;

    public Customer() {

    }

    public Customer(String idCustomer, String nameCustomer, String birthDayCustomer, String genderCustomer
            , String idNumberCustomer, String phoneCustomer, String emailCustomer
            , String typeOfCustomer, String addressCustomer, Services services){
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.birthDayCustomer = birthDayCustomer;
        this.genderCustomer = genderCustomer;
        this.idNumberCustomer = idNumberCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.typeOfCustomer = typeOfCustomer;
        this.addressCustomer = addressCustomer;
        this.services = services;
    }

    public Customer(String idCustomer, String nameCustomer, String birthDayCustomer, String genderCustomer
            , String idNumberCustomer, String phoneCustomer, String emailCustomer
            , String typeOfCustomer, String addressCustomer){
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.birthDayCustomer = birthDayCustomer;
        this.genderCustomer = genderCustomer;
        this.idNumberCustomer = idNumberCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.typeOfCustomer = typeOfCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthDayCustomer() {
        return birthDayCustomer;
    }

    public void setBirthDayCustomer(String birthDayCustomer) {
        this.birthDayCustomer = birthDayCustomer;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdNumberCustomer() {
        return idNumberCustomer;
    }

    public void setIdNumberCustomer(String idNumberCustomer) {
        this.idNumberCustomer = idNumberCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void checkService() {

    }

    @Override
    public String toString() {
        return "-Name Customer: " + getNameCustomer() +
                "\t-BirthDay Customer: " + getBirthDayCustomer() +
                "\t-Gender Customer: " + getGenderCustomer() +
                "\t-Id Number Customer: " + getIdNumberCustomer() +
                "\n-Phone Customer: " + getPhoneCustomer() +
                "\t-Email Customer: " + getEmailCustomer() +
                "\t-Type Of Customer: " + getTypeOfCustomer() +
                "\t-Address Customer: " + getAddressCustomer();
    }

    public void showInfo() {
        System.out.println(this.toString());
    }
}
