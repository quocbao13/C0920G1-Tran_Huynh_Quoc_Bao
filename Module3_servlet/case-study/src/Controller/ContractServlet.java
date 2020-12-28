package Controller;

import Model.*;
import Repository.ContractRepository.ContractRepositoryImpl;
import Repository.CustomerRepository.CustomerRepositoryImpl;
import Repository.DivisionRepository.DivisionRepositoryImpl;
import Repository.EmployeeRepository.EmployeeRepositoryImpl;
import Repository.ServiceRepository.ServiceRepositoryImpl;
import Repository.ServiceTypeRepository.ServiceTypeRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/admin/contracts")
public class ContractServlet extends HttpServlet {
    private ContractRepositoryImpl contractRepository = new ContractRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":create(request, response);
                break;
            case "edit": update(request, response);
                break;
            default: showList(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        String contract_deposit = request.getParameter("contract_deposit");
        String contract_total_money = request.getParameter("contract_total_money");
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                new Employee(employee_id),
                new Customer(customer_id),
                new Service(service_id));
        try {
            contractRepository.insert(contract);
            RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        String contract_deposit = request.getParameter("contract_deposit");
        String contract_total_money = request.getParameter("contract_total_money");
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                new Employee(employee_id),
                new Customer(customer_id),
                new Service(service_id));
        try {
            contractRepository.update(contract);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("contract", contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("../login/login.jsp");
            dispatcher.forward(request, response);
        }else {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                case "edit":
                    showUpdate(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    showList(request, response);
                    break;
            }
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contracts = contractRepository.selectAll();
        request.setAttribute("contracts", contracts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = new EmployeeRepositoryImpl().selectAll();
        List<Customer> customers = new CustomerRepositoryImpl().selectAll();
        List<Service> services = new ServiceRepositoryImpl().selectAll();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractRepository.select(id);
        request.setAttribute("contract", contract);
        List<Employee> employees = new EmployeeRepositoryImpl().selectAll();
        List<Customer> customers = new CustomerRepositoryImpl().selectAll();
        List<Service> services = new ServiceRepositoryImpl().selectAll();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            contractRepository.delete(id);
            List<Contract> contracts = contractRepository.selectAll();
            request.setAttribute("contracts", contracts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("contracts/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
