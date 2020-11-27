package Bank.models;

public class SalaryBookShortTime extends SalaryBook {
    private String timeStop;

    public SalaryBookShortTime() {

    }

    public SalaryBookShortTime(String timeStop) {
        this.timeStop = timeStop;
    }

    public SalaryBookShortTime(String idSalary, String idCustomer, String dayOpenSalary, String timeBegin, String saveMoney, String moneySalary, String timeStop) {
        super(idSalary, idCustomer, dayOpenSalary, timeBegin, saveMoney, moneySalary);
        this.timeStop = timeStop;
    }

    public String getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = timeStop;
    }

    @Override
    public String toString() {
        return "SalaryBookShortTime{" +
                super.toString()+
                "timeStop='" + timeStop + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
