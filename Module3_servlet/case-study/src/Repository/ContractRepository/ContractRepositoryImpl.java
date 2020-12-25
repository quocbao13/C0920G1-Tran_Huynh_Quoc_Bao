package Repository.ContractRepository;

import Model.*;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {

    private static final String INSERT_SQL = "INSERT INTO contract" + "  (contract_start_date, contract_end_date, " +
            "contract_deposit, contract_total_money, employee_id, customer_id, service_id) VALUES " +
            " (?,?,?,?,?,?,?);";
    private static final String SELECT_BY_ID = "select contract.*, employee.*, customer.*, service.*,positions.*, " +
            "division.*, education_degree.*, customer_type.*, service_type.*, rent_type.*, user.*  from contract " +
            " join employee on contract.employee_id = employee.employee_id " +
            "join customer on contract.customer_id = customer.customer_id " +
            "join service on contract.service_id = service.service_id " +
            "join positions on employee.position_id = positions.position_id " +
            "join division on employee.division_id = division.division_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join user on employee.username = user.username " +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
            "join service_type on service.service_type_id = service_type.service_type_id " +
            "join rent_type on service.rent_type_id = rent_type.rent_type_id " +
            "where contract_id =?";
    private static final String SELECT_ALL = "select contract.*, customer.*, employee.*, service.*, positions.*, " +
            "division.*, education_degree.*, customer_type.*, service_type.*, rent_type.*, user.* from contract " +
            "join employee on contract.employee_id = employee.employee_id " +
            "join customer on contract.customer_id = customer.customer_id " +
            "join service on contract.service_id = service.service_id " +
            "join positions on employee.position_id = positions.position_id " +
            "join division on employee.division_id = division.division_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join user on employee.username = user.username " +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
            "join service_type on service.service_type_id = service_type.service_type_id " +
            "join rent_type on service.rent_type_id = rent_type.rent_type_id";
    private static final String DELETE_SQL = "delete from contract where contract_id = ?;";
    private static final String UPDATE_SQL = "update contract set contract_start_date = ?, contract_end_date = ?, " +
            "contract_deposit = ?, contract_total_money = ?, employee_id = ?, customer_id = ?, service_id = ?" +
            " where contract_id = ?;";

    @Override
    public void insert(Contract contract) throws SQLException {
        try(Connection connection = new ConnectionRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setString(3, contract.getDeposit());
            preparedStatement.setString(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployee().getId());
            preparedStatement.setInt(6, contract.getCustomer().getId());
            preparedStatement.setInt(7, contract.getService().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionRepository.close();
        }
    }

    @Override
    public Contract select(int id) {
        Contract contract = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                String contract_deposit = resultSet.getString("contract_deposit");
                String contract_total_money = resultSet.getString("contract_total_money");

                int employee_id = resultSet.getInt("employee_id");
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

                int typeId = resultSet.getInt("customer_type_id");
                String typename = resultSet.getString("customer_type_name");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                int customer_id = resultSet.getInt("customer_id");

                String service_id = resultSet.getString("service_id");
                String service_name = resultSet.getString("service_name");
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
                contract = new Contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,
                        new Employee(name, birthday, idCard, salary, phone, email, address,
                                new Position(position_id, position_name),
                                new EducationLevel(educationLevel_id, educationLevel_name),
                                new Division(division_id, division_name),
                                new User(username, password)),
                        new Customer(new CustomerType(typeId,typename), customer_name, customer_birthday,
                                customer_gender, customer_id_card, customer_phone, customer_email, customer_address),
                        new Service(service_name, area, cost, maxPeople,
                                new RentType(rentTypeId, rentTypeName,cost),
                                new ServiceType(serviceTypeId, serviceTypeName), standardRoom, descriptionOtherConvenience,
                                poolArea, numberOfFloor)
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return contract;
    }

    @Override
    public List<Contract> selectAll() {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                String contract_deposit = resultSet.getString("contract_deposit");
                String contract_total_money = resultSet.getString("contract_total_money");

                int employee_id = resultSet.getInt("employee_id");
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

                int typeId = resultSet.getInt("customer_type_id");
                String typename = resultSet.getString("customer_type_name");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                int customer_id = resultSet.getInt("customer_id");

                String service_id = resultSet.getString("service_id");
                String service_name = resultSet.getString("service_name");
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
                contracts.add(new Contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,
                        new Employee(name, birthday, idCard, salary, phone, email, address,
                                new Position(position_id, position_name),
                                new EducationLevel(educationLevel_id, educationLevel_name),
                                new Division(division_id, division_name),
                                new User(username, password)),
                        new Customer(new CustomerType(typeId,typename), customer_name, customer_birthday,
                                customer_gender, customer_id_card, customer_phone, customer_email, customer_address),
                        new Service(service_name, area, cost, maxPeople,
                                new RentType(rentTypeId, rentTypeName,cost),
                                new ServiceType(serviceTypeId, serviceTypeName), standardRoom, descriptionOtherConvenience,
                                poolArea, numberOfFloor)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionRepository.close();
        }
        return contracts;
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
    public boolean update(Contract contract) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setString(3, contract.getDeposit());
            preparedStatement.setString(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployee().getId());
            preparedStatement.setInt(6, contract.getCustomer().getId());
            preparedStatement.setInt(7, contract.getService().getId());
            preparedStatement.setInt(8, contract.getId());
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
