package Bank.models;

public abstract class SalaryBook {
    private String idSalary;
    private String idCustomer;
    private String dayOpenSalary;
    private String timeBegin;
    private String saveMoney;
    private String moneySalary;

    SalaryBook() {

    }

    public SalaryBook(String idSalary, String idCustomer, String dayOpenSalary, String timeBegin, String saveMoney, String moneySalary) {
        this.idSalary = idSalary;
        this.idCustomer = idCustomer;
        this.dayOpenSalary = dayOpenSalary;
        this.timeBegin = timeBegin;
        this.saveMoney = saveMoney;
        this.moneySalary = moneySalary;
    }

    public String getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(String idSalary) {
        this.idSalary = idSalary;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDayOpenSalary() {
        return dayOpenSalary;
    }

    public void setDayOpenSalary(String dayOpenSalary) {
        this.dayOpenSalary = dayOpenSalary;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(String saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getMoneySalary() {
        return moneySalary;
    }

    public void setMoneySalary(String moneySalary) {
        this.moneySalary = moneySalary;
    }

    @Override
    public String toString() {
        return "SalaryBook{" +
                "idSalary='" + idSalary + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", dayOpenSalary='" + dayOpenSalary + '\'' +
                ", timeBegin='" + timeBegin + '\'' +
                ", saveMoney='" + saveMoney + '\'' +
                ", moneySalary='" + moneySalary + '\'' +
                '}';
    }

    public abstract void showInfo();
}
