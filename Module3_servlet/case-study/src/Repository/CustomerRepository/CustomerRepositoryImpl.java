package Repository.CustomerRepository;

import Model.Customer;
import Model.CustomerType;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String INSERT_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name" +
            ",customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?);";
    private static final String SELECT_BY_ID = "select *, customer_type.* from customer " +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
            "where customer_id =?";
    private static final String SELECT_ALL = "select * from customer "+
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id;";
    private static final String DELETE_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_SQL = "update customer " +
            "set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?" +
            ", customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? " +
            "where customer_id = ?;";

    @Override
    public void insert(Customer customer) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerType().getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public Customer select(int id) {
        Customer customer = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int typeId = resultSet.getInt("customer_type_id");
                String typename = resultSet.getString("customer_type_name");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(new CustomerType(typeId,typename), name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String typename = rs.getString("customer_type_name");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id, new CustomerType(typeId,typename), name, birthday, gender,
                        idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return customers;
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
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setInt(1, customer.getCustomerType().getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getId());
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
