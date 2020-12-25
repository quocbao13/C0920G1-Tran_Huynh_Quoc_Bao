package Controller;

import Model.EducationLevel;
import Model.Position;
import Repository.EducationLevelRepository.EducationLevelRepository;
import Repository.EducationLevelRepository.EducationLevelRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EducationLevelServlet", urlPatterns = "/admin/educationLevels")
public class EducationLevelServlet extends HttpServlet {
    private EducationLevelRepositoryImpl educationLevelRepository = new EducationLevelRepositoryImpl();
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
        EducationLevel educationLevel = new EducationLevel(name);
        try {
            educationLevelRepository.insert(educationLevel);
            RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        EducationLevel educationLevel = new EducationLevel(id, name);
        try {
            educationLevelRepository.update(educationLevel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("educationLevel", educationLevel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/edit.jsp");
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
        List<EducationLevel> educationLevels = educationLevelRepository.selectAll();
        request.setAttribute("educationLevels", educationLevels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EducationLevel educationLevel = educationLevelRepository.select(id);
        request.setAttribute("educationLevel", educationLevel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            educationLevelRepository.delete(id);
            List<EducationLevel> educationLevels = educationLevelRepository.selectAll();
            request.setAttribute("educationLevels", educationLevels);
            RequestDispatcher dispatcher = request.getRequestDispatcher("educationLevels/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
