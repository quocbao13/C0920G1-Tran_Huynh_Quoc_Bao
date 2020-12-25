package Repository.CustomerTypeRepository;

import Model.CustomerType;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface CustomerTypeRepository extends Repository<CustomerType> {
    @Override
    void insert(CustomerType customerType) throws SQLException;

    @Override
    CustomerType select(int id);

    @Override
    List<CustomerType> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(CustomerType customerType) throws SQLException;
}
