package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Models.Employee;
import case_study.furama_resort.Models.Villa;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ManagerEmployee {

    public Map<String, Employee> readEmployeeCSV() {
        Map<String, Employee> mapEmployee = new TreeMap<>();
        List<String[]> employeeList = new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Employee.csv");
        int count = 0;
        for (String[] line : employeeList) {
            count++;
            Employee employee = new Employee(line[0], line[1], line[2]);
            mapEmployee.put(String.format("%03d", count), employee);
        }
        return mapEmployee;
    }

    public void showEmployee() {
        Map<String, Employee> mapEmployee = readEmployeeCSV();
        for (Map.Entry<String, Employee> m : mapEmployee.entrySet()){
            System.out.println(m.getKey() + ", " + m.getValue().getNameEmployee() + ", "
                    + m.getValue().getBirthDayEmployee() + ", " + m.getValue().getAddressEmployee());
        }
    }
}
