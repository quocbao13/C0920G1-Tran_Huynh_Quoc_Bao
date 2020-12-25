package Repository.EmployeeRepository;

import Model.Employee;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository extends Repository<Employee> {
    @Override
    void insert(Employee employee) throws SQLException;

    @Override
    Employee select(int id);

    @Override
    List<Employee> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Employee employee) throws SQLException;
}
