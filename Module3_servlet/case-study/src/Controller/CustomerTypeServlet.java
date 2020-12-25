package Controller;

import Model.CustomerType;
import Model.Division;
import Repository.CustomerTypeRepository.CustomerTypeRepositoryImpl;
import Repository.DivisionRepository.DivisionRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerTypeServlet", urlPatterns = "/admin/customerTypes")
public class CustomerTypeServlet extends HttpServlet {
    private CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();
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
        String name = request.getParameter("name");
        CustomerType customerType = new CustomerType(name);
        try {
            customerTypeRepository.insert(customerType);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        CustomerType customerType = new CustomerType(id, name);
        try {
            customerTypeRepository.update(customerType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("customerType", customerType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/edit.jsp");
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
        List<CustomerType> customerTypes = customerTypeRepository.selectAll();
        request.setAttribute("customerTypes", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerType customerType = customerTypeRepository.select(id);
        request.setAttribute("customerType", customerType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerTypeRepository.delete(id);
            List<CustomerType> customerTypes = customerTypeRepository.selectAll();
            request.setAttribute("customerTypes", customerTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerTypes/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
