package Controller;

import Model.CustomerType;
import Model.RentType;
import Model.Service;
import Model.ServiceType;
import Repository.CustomerTypeRepository.CustomerTypeRepositoryImpl;
import Repository.RentTypeRepository.RentTypeRepositoryImpl;
import Repository.ServiceRepository.ServiceRepositoryImpl;
import Repository.ServiceTypeRepository.ServiceTypeRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/admin/services")
public class ServiceServlet extends HttpServlet {
    private ServiceRepositoryImpl serviceRepository = new ServiceRepositoryImpl();
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
        String name = request.getParameter("service_name");
        int area = Integer.parseInt(request.getParameter("service_area"));
        String cost = request.getParameter("service_cost");
        int maxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        String poolArea = request.getParameter("pool_area");
        int numberOfFloor = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(name, area, cost, maxPeople,
                new RentType(rentTypeId),
                new ServiceType(serviceTypeId), standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloor);
        try {
            serviceRepository.insert(service);
            RequestDispatcher dispatcher = request.getRequestDispatcher("services/create.jsp");
            request.setAttribute("message", "Created");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("service_name");
        int area = Integer.parseInt(request.getParameter("service_area"));
        String cost = request.getParameter("service_cost");
        int maxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        String poolArea = request.getParameter("pool_area");
        int numberOfFloor = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(id, name, area, cost, maxPeople,
                new RentType(rentTypeId),
                new ServiceType(serviceTypeId), standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloor);
        try {
            serviceRepository.update(service);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("services/edit.jsp");
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
        List<Service> services = serviceRepository.selectAll();
        request.setAttribute("services", services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("services/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypes = new RentTypeRepositoryImpl().selectAll();
        List<ServiceType> serviceTypes = new ServiceTypeRepositoryImpl().selectAll();
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("services/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceRepository.select(id);
        request.setAttribute("service", service);
        List<RentType> rentTypes = new RentTypeRepositoryImpl().selectAll();
        List<ServiceType> serviceTypes = new ServiceTypeRepositoryImpl().selectAll();
        request.setAttribute("rentTypes", rentTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("services/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void  delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            serviceRepository.delete(id);
            List<Service> services = serviceRepository.selectAll();
            request.setAttribute("services", services);
            RequestDispatcher dispatcher = request.getRequestDispatcher("services/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
