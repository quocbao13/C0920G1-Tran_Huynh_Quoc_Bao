package case_study.furama_resort.Models;

import case_study.furama_resort.Controllers.ManagerEmployee;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackFolder {
    private static Stack<Employee> employeeStack = new Stack<>();

    public void addEmployeeToStack() {
        Map<String, Employee> employeeList = new ManagerEmployee().readEmployeeCSV();
        for (Map.Entry<String, Employee> employeeEntry : employeeList.entrySet()) {
            employeeStack.push(employeeEntry.getValue());
        }
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void searchEmployee() {
        addEmployeeToStack();
        System.out.println("Enter name employee, you want to find: ");
        String nameEmployee = getScanner().nextLine();
        boolean isHas = false;
        for (Employee e: employeeStack) {
            if (e.getNameEmployee().toLowerCase().contains(nameEmployee)){
                System.out.println(e.toString());
                isHas = true;
                break;
            }
            employeeStack.pop();

        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }

    }
}
