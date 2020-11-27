package Bank.models;

public class SalaryBookLongTime extends SalaryBook{
    private String timeStop;
    private String sale;

    public SalaryBookLongTime() {}

    public SalaryBookLongTime(String timeStop, String sale) {
        this.timeStop = timeStop;
        this.sale = sale;
    }

    public SalaryBookLongTime(String idSalary, String idCustomer, String dayOpenSalary, String timeBegin, String saveMoney, String moneySalary, String timeStop, String sale) {
        super(idSalary, idCustomer, dayOpenSalary, timeBegin, saveMoney, moneySalary);
        this.timeStop = timeStop;
        this.sale = sale;
    }

    public String getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = timeStop;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "SalaryBookLongTime{" +
                super.toString() +
                "timeStop='" + timeStop + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }

}
