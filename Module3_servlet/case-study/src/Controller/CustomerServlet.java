package Controller;

import Model.Customer;
import Model.CustomerType;
import Repository.CustomerRepository.CustomerRepositoryImpl;
import Repository.CustomerTypeRepository.CustomerTypeRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String typename = request.getParameter("customer_type_name");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Customer customer = new Customer( new CustomerType(typeId,typename), name, birthday, gender,
                idCard, phone, email, address);
        try {
            customerRepository.insert(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customers/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
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
        Customer customer = new Customer( new CustomerType(typeId,typename), name, birthday, gender,
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
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create": showCreate(request, response);
                break;
            case "edit": showUpdate(request, response);
                break;
            case "delete": delete(request, response);
                break;
            default: showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerRepository.selectAll();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypes = new CustomerTypeRepositoryImpl().selectAll();
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
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
