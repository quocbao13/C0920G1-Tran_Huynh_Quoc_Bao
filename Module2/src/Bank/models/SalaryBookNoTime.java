package Bank.models;

public class SalaryBookNoTime extends SalaryBook{

    public SalaryBookNoTime() {

    }

    public SalaryBookNoTime(String idSalary, String idCustomer, String dayOpenSalary, String timeBegin, String saveMoney, String moneySalary) {
        super(idSalary, idCustomer, dayOpenSalary, timeBegin, saveMoney, moneySalary);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }


}
