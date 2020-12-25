package Repository.EducationLevelRepository;

import Model.EducationLevel;
import Model.Position;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationLevelRepositoryImpl implements EducationLevelRepository {

    private static final String INSERT_SQL = "INSERT INTO education_degree" + "  (education_degree_name) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from education_degree where education_degree_id =?";
    private static final String SELECT_ALL = "select * from education_degree";
    private static final String DELETE_SQL = "delete from education_degree where education_degree_id = ?;";
    private static final String UPDATE_SQL = "update education_degree set education_degree_name = ? where education_degree_id = ?;";

    @Override
    public void insert(EducationLevel educationLevel) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, educationLevel.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public EducationLevel select(int id) {
        EducationLevel educationLevel = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("education_degree_name");
                educationLevel = new EducationLevel(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return educationLevel;
    }

    @Override
    public List<EducationLevel> selectAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<EducationLevel> educationLevels = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = new ConnectionRepository().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("education_degree_id");
                String name = rs.getString("education_degree_name");
                educationLevels.add(new EducationLevel(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return educationLevels;
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
    public boolean update(EducationLevel educationLevel) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, educationLevel.getName());
            preparedStatement.setInt(2, educationLevel.getId());
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
