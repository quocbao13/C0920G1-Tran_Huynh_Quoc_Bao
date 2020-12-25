package Controller;

import Model.Position;
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

@WebServlet(name = "PositionServlet", urlPatterns = "/admin/positions")
public class PositionServlet extends HttpServlet {
    private PositionRepositoryImpl positionRepository = new PositionRepositoryImpl();
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
        Position position = new Position(name);
        try {
            positionRepository.insert(position);
            RequestDispatcher dispatcher = request.getRequestDispatcher("positions/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Position position = new Position(id, name);
        try {
            positionRepository.update(position);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("position", position);
        RequestDispatcher dispatcher = request.getRequestDispatcher("positions/edit.jsp");
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
        List<Position> positions = positionRepository.selectAll();
        request.setAttribute("positions", positions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("positions/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("positions/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Position position = positionRepository.select(id);
        request.setAttribute("position", position);
        RequestDispatcher dispatcher = request.getRequestDispatcher("positions/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            positionRepository.delete(id);
            List<Position> positions = positionRepository.selectAll();
            request.setAttribute("positions", positions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("positions/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
