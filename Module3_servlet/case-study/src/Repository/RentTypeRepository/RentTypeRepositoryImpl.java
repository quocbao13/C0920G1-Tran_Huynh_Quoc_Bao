package Repository.RentTypeRepository;

import Model.RentType;
import Model.ServiceType;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    private static final String INSERT_SQL = "INSERT INTO rent_type" + "  (service_type_name) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from rent_type where rent_type_id =?";
    private static final String SELECT_ALL = "select * from rent_type";
    private static final String DELETE_SQL = "delete from rent_type where rent_type_id = ?;";
    private static final String UPDATE_SQL = "update rent_type " +
            "set rent_type_name = ?, rent_type_cost = ? where rent_type_id = ?;";

    @Override
    public void insert(RentType rentType) throws SQLException {

    }

    @Override
    public RentType select(int id) {
        return null;
    }

    @Override
    public List<RentType> selectAll() {
        List<RentType> rentTypes = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("rent_type_id");
                String name = rs.getString("rent_type_name");
                String cost = rs.getString("rent_type_cost");
                rentTypes.add(new RentType(id, name, cost));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return rentTypes;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RentType rentType) throws SQLException {
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
