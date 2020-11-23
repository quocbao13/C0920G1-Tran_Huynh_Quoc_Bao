package case_study.furama_resort.Models;

public class Employee {
    private String nameEmployee;
    private String birthDayEmployee;
    private String addressEmployee;

    public Employee(){}

    public Employee(String nameEmployee, String birthDayEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.birthDayEmployee = birthDayEmployee;
        this.addressEmployee = addressEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthDayEmployee() {
        return birthDayEmployee;
    }

    public void setBirthDayEmployee(String birthDayEmployee) {
        this.birthDayEmployee = birthDayEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return  "Name Employee='" + nameEmployee + '\'' +
                ", BirthDay Employee='" + birthDayEmployee + '\'' +
                ", Address Employee='" + addressEmployee + '\'' +
                '}';
    }
}
