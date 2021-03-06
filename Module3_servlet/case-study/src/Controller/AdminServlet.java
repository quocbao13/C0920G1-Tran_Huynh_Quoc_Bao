package Controller;

import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(request, response);
        }else {
            String action = request.getParameter("action");
            if (action == null){
                action = "";
            }
            switch (action) {
                default: showAdmin(request, response);
                    break;
            }
        }

    }

    private void showAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/homeAdmin.jsp");
        dispatcher.forward(request, response);
    }
}
