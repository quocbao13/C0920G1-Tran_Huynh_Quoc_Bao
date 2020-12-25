package Repository.EducationLevelRepository;

import Model.EducationLevel;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface EducationLevelRepository extends Repository<EducationLevel> {
    @Override
    void insert(EducationLevel educationLevel) throws SQLException;

    @Override
    EducationLevel select(int id);

    @Override
    List<EducationLevel> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(EducationLevel educationLevel) throws SQLException;
}
