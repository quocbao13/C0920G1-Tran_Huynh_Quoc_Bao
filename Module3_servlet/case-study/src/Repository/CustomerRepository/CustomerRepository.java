package Repository.CustomerRepository;

import Model.Customer;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository extends Repository<Customer> {
    @Override
    void insert(Customer customer) throws SQLException;

    @Override
    Customer select(int id);

    @Override
    List<Customer> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Customer customer) throws SQLException;
}
