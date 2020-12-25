package Repository.RentTypeRepository;

import Model.RentType;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface RentTypeRepository extends Repository<RentType> {
    @Override
    void insert(RentType rentType) throws SQLException;

    @Override
    RentType select(int id);

    @Override
    List<RentType> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(RentType rentType) throws SQLException;
}
