package Repository.ServiceTypeRepository;

import Model.ServiceType;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface ServiceTypeRepository extends Repository<ServiceType> {
    @Override
    void insert(ServiceType serviceType) throws SQLException;

    @Override
    ServiceType select(int id);

    @Override
    List<ServiceType> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(ServiceType serviceType) throws SQLException;
}
