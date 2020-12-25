package Repository.AttachServiceRepository;

import Model.AttachService;
import Model.Division;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepositoryImpl implements AttachServiceRepository {

    private static final String INSERT_SQL = "INSERT INTO attach_service" + "  (attach_service_name, " +
            "attach_service_cost, attach_service_unit, attach_service_status) VALUES " +
            " (?,?,?,?);";
    private static final String SELECT_BY_ID = "select * from attach_service where attach_service_id =?";
    private static final String SELECT_ALL = "select * from attach_service";
    private static final String DELETE_SQL = "delete from attach_service where attach_service_id = ?;";
    private static final String UPDATE_SQL = "update attach_service set attach_service_name = ?," +
            "attach_service_cost = ?, attach_service_unit = ?, attach_service_status = ? where attach_service_id = ?;";

    @Override
    public void insert(AttachService attachService) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, attachService.getName());
            preparedStatement.setString(2, attachService.getCost());
            preparedStatement.setInt(3, attachService.getUnit());
            preparedStatement.setString(4, attachService.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public AttachService select(int id) {
        AttachService attachService = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("attach_service_name");
                String cost = resultSet.getString("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                attachService = new AttachService(name, cost, unit, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return attachService;
    }

    @Override
    public List<AttachService> selectAll() {
        List<AttachService> attachServices = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("attach_service_id");
                String name = rs.getString("attach_service_name");
                String cost = rs.getString("attach_service_cost");
                int unit = rs.getInt("attach_service_unit");
                String status = rs.getString("attach_service_status");
                attachServices.add(new AttachService(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return attachServices;
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
    public boolean update(AttachService attachService) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, attachService.getName());
            preparedStatement.setString(2, attachService.getCost());
            preparedStatement.setInt(3, attachService.getUnit());
            preparedStatement.setString(4, attachService.getStatus());
            preparedStatement.setInt(5, attachService.getId());
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
