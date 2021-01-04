package controller;

import common.Validate;
import model.BenhAn;
import model.BenhNhan;
import repository.BenhAnRepo.BenhAnRepoImpl;
import repository.BenhNhanRepo.BenhNhanRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = "/benhans")
public class BenhAnServlet extends HttpServlet {
    private BenhAnRepoImpl benhAnRepo = new BenhAnRepoImpl();
    private BenhNhanRepoImpl benhNhanRepo = new BenhNhanRepoImpl();
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

        String ngaynhapvien = request.getParameter("ngaynhapvien");
        String ngayravien = request.getParameter("ngayravien");
        String lydonhapvien = request.getParameter("lydonhapvien");

        int benhnhan_id = Integer.parseInt(request.getParameter("benhnhan_id"));
        BenhAn benhAn = new BenhAn(ngaynhapvien, ngayravien, lydonhapvien, new BenhNhan(benhnhan_id));
        try {
            benhAnRepo.insert(benhAn);
            RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/create.jsp");
            request.setAttribute("message", "Da xoa");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String ngaynhapvien = request.getParameter("ngaynhapvien");
        String ngayravien = request.getParameter("ngayravien");
        String lydonhapvien = request.getParameter("lydonhapvien");
        String tenbenhnhan = request.getParameter("tenbenhnhan");
        int benhnhan_id = Integer.parseInt(request.getParameter("benhnhan_id"));
        String messageTen = Validate.validateCustomerName(tenbenhnhan);
        String messageLyDo = Validate.validateCustomerLyDo(lydonhapvien);
        BenhNhan benhNhan = new BenhNhan(benhnhan_id, tenbenhnhan);
        BenhAn benhAn = new BenhAn(id, ngaynhapvien, ngayravien, lydonhapvien, benhNhan);
        try {
            if (messageTen == null && messageLyDo == null) {
                benhAnRepo.update(benhAn);
                benhNhanRepo.update(benhNhan);
                benhAn = null;
                benhNhan= null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("benhAn", benhAn);
        request.setAttribute("benhNhan", benhNhan);
        request.setAttribute("messageTen", messageTen);
        request.setAttribute("messageLyDo", messageLyDo);
        request.setAttribute("message", "Da sua");
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/edit.jsp");
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
        List<BenhAn> benhAns = benhAnRepo.selectAll();
        request.setAttribute("benhAns", benhAns);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<BenhNhan> benhNhans = benhNhanRepo.selectAll();
        request.setAttribute("benhNhans", benhNhans);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BenhAn benhAn = benhAnRepo.select(id);
        request.setAttribute("benhAn", benhAn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            benhAnRepo.delete(id);
            List<BenhAn> benhAns = benhAnRepo.selectAll();
            request.setAttribute("benhAns", benhAns);
            RequestDispatcher dispatcher = request.getRequestDispatcher("benhan/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
