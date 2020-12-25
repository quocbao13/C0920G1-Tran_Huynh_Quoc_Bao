package Controller;

import Model.*;
import Repository.DivisionRepository.DivisionRepositoryImpl;
import Repository.EducationLevelRepository.EducationLevelRepositoryImpl;
import Repository.EmployeeRepository.EmployeeRepositoryImpl;
import Repository.PositionRepository.PositionRepositoryImpl;
import Repository.UserRepository.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/admin/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
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
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_brithday");
        String idCard = request.getParameter("employee_id_card");
        String salary = request.getParameter("employee_salary");
        String phone = request.getParameter("employee_phone");
        String email = request.getParameter("employee_email");
        String address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int educationLevel_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address,
                new Position(position_id),
                new EducationLevel(educationLevel_id),
                new Division(division_id),
                new User(username));
        try {
            employeeRepository.insert(employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employees/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_brithday");
        String idCard = request.getParameter("employee_id_card");
        String salary = request.getParameter("employee_salary");
        String phone = request.getParameter("employee_phone");
        String email = request.getParameter("employee_email");
        String address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int educationLevel_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address,
                new Position(position_id),
                new EducationLevel(educationLevel_id),
                new Division(division_id),
                new User(username));
        try {
            employeeRepository.update(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employees/edit.jsp");
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
        List<Employee> employees = employeeRepository.selectAll();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employees/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<EducationLevel> educationLevels = new EducationLevelRepositoryImpl().selectAll();
        List<Position> positions = new PositionRepositoryImpl().selectAll();
        List<Division> divisions = new DivisionRepositoryImpl().selectAll();
        request.setAttribute("educationLevels", educationLevels);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employees/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeRepository.select(id);
        request.setAttribute("employee", employee);
        List<EducationLevel> educationLevels = new EducationLevelRepositoryImpl().selectAll();
        List<Position> positions = new PositionRepositoryImpl().selectAll();
        List<Division> divisions = new DivisionRepositoryImpl().selectAll();
        request.setAttribute("educationLevels", educationLevels);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employees/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            employeeRepository.delete(id);
            List<Employee> employees = employeeRepository.selectAll();
            request.setAttribute("employees", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employees/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
