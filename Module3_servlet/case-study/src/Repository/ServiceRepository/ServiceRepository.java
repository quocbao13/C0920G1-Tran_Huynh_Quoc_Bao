package Repository.ServiceRepository;

import Model.Service;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository extends Repository<Service> {
    @Override
    void insert(Service service) throws SQLException;

    @Override
    Service select(int id);

    @Override
    List<Service> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Service service) throws SQLException;
}
