package Repository.DivisionRepository;

import Model.Division;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface DivisionRepository extends Repository<Division> {
    @Override
    void insert(Division division) throws SQLException;

    @Override
    Division select(int id);

    @Override
    List<Division> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Division division) throws SQLException;
}
