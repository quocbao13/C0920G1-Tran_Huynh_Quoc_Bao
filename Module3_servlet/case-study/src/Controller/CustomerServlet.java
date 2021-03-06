package Controller;


import common.Validate;
import Model.Customer;
import Model.CustomerType;
import Model.User;
import Repository.CustomerRepository.CustomerRepositoryImpl;
import Repository.CustomerTypeRepository.CustomerTypeRepositoryImpl;

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

@WebServlet(name = "CustomerServlet" , urlPatterns = "/admin/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
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
        int typeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("customer_name");
        String message = Validate.validateCustomerName(name);
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String messagePhone = Validate.validateCustomerPhone(phone);
        String email = request.getParameter("customer_email");
        String messageMail = Validate.validateCustomerEmail(email);
        String address = request.getParameter("customer_address");
        Customer customer = new Customer( new CustomerType(typeId), name, birthday, gender,
                idCard, phone, email, address);
        System.out.println(message);
        try {
            if (message == null && messagePhone == null && messageMail == null) {
                customerRepository.insert(customer);
                customer = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<CustomerType> customerTypes = new CustomerTypeRepositoryImpl().selectAll();
            List<Customer> customers = customerRepository.selectAll();
            System.out.println(message);
            request.setAttribute("customer",customer);
            request.setAttribute("message", message);
            request.setAttribute("customers", customers);
            request.setAttribute("customerTypes", customerTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customers/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String typename = request.getParameter("customer_type_name");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Customer customer = new Customer(id, new CustomerType(typeId,typename), name, birthday, gender,
                idCard, phone, email, address);
        try {
            customerRepository.update(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/edit.jsp");
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
        List<CustomerType> customerTypes = new CustomerTypeRepositoryImpl().selectAll();
        List<Customer> customers = customerRepository.selectAll();
        request.setAttribute("customers", customers);
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerRepository.select(id);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypes = new CustomerTypeRepositoryImpl().selectAll();
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerRepository.delete(id);
            List<Customer> customers = customerRepository.selectAll();
            request.setAttribute("customers", customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customers/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
