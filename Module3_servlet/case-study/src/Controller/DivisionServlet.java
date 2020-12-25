package Controller;

import Model.Division;
import Model.Position;
import Repository.DivisionRepository.DivisionRepository;
import Repository.DivisionRepository.DivisionRepositoryImpl;
import Repository.PositionRepository.PositionRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DivisionServlet", urlPatterns = "/admin/divisions")
public class DivisionServlet extends HttpServlet {
    private DivisionRepositoryImpl divisionRepository = new DivisionRepositoryImpl();
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
        Division division = new Division(name);
        try {
            divisionRepository.insert(division);
            RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Division division = new Division(id, name);
        try {
            divisionRepository.update(division);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("division", division);
        RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/edit.jsp");
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
        List<Division> divisions = divisionRepository.selectAll();
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Division division = divisionRepository.select(id);
        request.setAttribute("division", division);
        RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            divisionRepository.delete(id);
            List<Division> divisions = divisionRepository.selectAll();
            request.setAttribute("divisions", divisions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("divisions/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
