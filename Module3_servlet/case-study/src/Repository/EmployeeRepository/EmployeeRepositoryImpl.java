package Repository.EmployeeRepository;

import Model.*;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String INSERT_SQL = "INSERT INTO employee"
            + " (employee_name, employee_brithday, employee_id_card, employee_salary"
            +", employee_phone, employee_email, employee_address, position_id, education_degree_id"+
            ", division_id, username) VALUES " +
            " (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_BY_ID = "select * from employee " +
            "join positions on employee.position_id = positions.position_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join division on employee.division_id = division.division_id " +
            "join user on employee.username = user.username where employee_id =?";
    private static final String SELECT_ALL = "select employee.*, positions.*, education_degree.*, division.*, user.*" +
            " from employee "+
            "join positions on employee.position_id = positions.position_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join division on employee.division_id = division.division_id " +
            "join user on employee.username = user.username;";
    private static final String DELETE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_SQL = "update employee set employee_name = ?, employee_brithday = ?," +
            " employee_id_card = ?, employee_salary = ?" +
            " , employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, " +
            " education_degree_id = ?" +
            " , division_id = ?, username = ? where employee_id = ?;";

    @Override
    public void insert(Employee employee) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getDivision().getId());
            preparedStatement.setInt(9, employee.getEducationLevel().getId());
            preparedStatement.setInt(10, employee.getDivision().getId());
            preparedStatement.setString(11, employee.getUser().getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public Employee select(int id) {
        Employee employee = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_brithday");
                String idCard = resultSet.getString("employee_id_card");
                String salary = resultSet.getString("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                int educationLevel_id = resultSet.getInt("education_degree_id");
                String educationLevel_name = resultSet.getString("education_degree_name");
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                employee = new Employee(name, birthday, idCard, salary, phone, email, address,
                        new Position(position_id, position_name),
                        new EducationLevel(educationLevel_id, educationLevel_name),
                        new Division(division_id, division_name),
                        new User(username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_brithday");
                String idCard = rs.getString("employee_id_card");
                String salary = rs.getString("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                String position_name = rs.getString("position_name");
                int educationLevel_id = rs.getInt("education_degree_id");
                String educationLevel_name = rs.getString("education_degree_name");
                int division_id = rs.getInt("division_id");
                String division_name = rs.getString("division_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                employees.add(new Employee(id, name, birthday, idCard, salary, phone, email, address,
                        new Position(position_id, position_name),
                        new EducationLevel(educationLevel_id, educationLevel_name),
                        new Division(division_id, division_name),
                        new User(username, password)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return employees;
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
    public boolean update(Employee employee) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPosition().getId());
            preparedStatement.setInt(9, employee.getEducationLevel().getId());
            preparedStatement.setInt(10, employee.getDivision().getId());
            preparedStatement.setString(11, employee.getUser().getName());
            preparedStatement.setInt(12, employee.getId());
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
