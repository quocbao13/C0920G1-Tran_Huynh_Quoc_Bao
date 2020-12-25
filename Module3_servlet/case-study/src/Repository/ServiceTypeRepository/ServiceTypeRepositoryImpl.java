package Repository.ServiceTypeRepository;

import Model.Position;
import Model.ServiceType;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private static final String INSERT_SQL = "INSERT INTO service_type" + "  (service_type_name) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from service_type where service_type_id =?";
    private static final String SELECT_ALL = "select * from service_type";
    private static final String DELETE_SQL = "delete from service_type where service_type_id = ?;";
    private static final String UPDATE_SQL = "update service_type set service_type_name = ? where service_type_id = ?;";

    @Override
    public void insert(ServiceType serviceType) throws SQLException {
        
    }

    @Override
    public ServiceType select(int id) {
        return null;
    }

    @Override
    public List<ServiceType> selectAll() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("service_type_id");
                String name = rs.getString("service_type_name");
                serviceTypes.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return serviceTypes;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ServiceType serviceType) throws SQLException {
        return false;
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
