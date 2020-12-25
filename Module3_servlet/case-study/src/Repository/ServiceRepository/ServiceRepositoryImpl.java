package Repository.ServiceRepository;

import Model.*;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String INSERT_SQL = "INSERT INTO service" + "  (service_name, service_area, " +
            "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, " +
            "description_other_convenience, pool_area, number_of_floors) VALUES " +
            " (?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_BY_ID = "select service.*, rent_type.*, service_type.* from service " +
            "join rent_type on service.rent_type_id = rent_type.rent_type_id " +
            "join service_type on service.service_type_id = service_type.service_type_id where service_id =?";
    private static final String SELECT_ALL = "select service.*, rent_type.*, service_type.* from service " +
            "join rent_type on service.rent_type_id = rent_type.rent_type_id " +
            "join service_type on service.service_type_id = service_type.service_type_id";
    private static final String DELETE_SQL = "delete from service where service_id = ?;";
    private static final String UPDATE_SQL = "update service set service_name = ?, service_area = ?, " +
            "service_cost = ?, service_max_people = ?, rent_type_id = ?, service_type_id = ?, standard_room = ?, " +
            "description_other_convenience = ?, pool_area = ?, number_of_floors = ? where service_id = ?;";

    @Override
    public void insert(Service service) throws SQLException {
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setString(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setInt(5, service.getRentType().getId());
            preparedStatement.setInt(6, service.getServiceType().getId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setString(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloor());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public Service select(int id) {
        Service service = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                String cost = resultSet.getString("service_cost");
                int maxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                String rentTypeCost = resultSet.getString("rent_type_cost");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floors");
                service = new Service(name, area, cost, maxPeople,
                        new RentType(rentTypeId, rentTypeName,rentTypeCost),
                        new ServiceType(serviceTypeId, serviceTypeName), standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return service;
    }

    @Override
    public List<Service> selectAll() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                String cost = rs.getString("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                String rentTypeName = rs.getString("rent_type_name");
                String rentTypeCost = rs.getString("rent_type_cost");
                int serviceTypeId = rs.getInt("service_type_id");
                String serviceTypeName = rs.getString("service_type_name");
                String standardRoom = rs.getString("standard_room");
                String descriptionOtherConvenience = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                int numberOfFloor = rs.getInt("number_of_floors");
                services.add(new Service(id, name, area, cost, maxPeople,
                        new RentType(rentTypeId, rentTypeName,rentTypeCost),
                        new ServiceType(serviceTypeId, serviceTypeName), standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return services;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionRepository.close();
        }
        return rowDelete;
    }

    @Override
    public boolean update(Service service) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setString(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setInt(5, service.getRentType().getId());
            preparedStatement.setInt(6, service.getServiceType().getId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setString(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloor());
            preparedStatement.setInt(11, service.getId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionRepository.close();
        }
        return rowUpdate;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
