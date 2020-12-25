package Repository.AttachServiceRepository;

import Model.AttachService;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface AttachServiceRepository extends Repository<AttachService> {
    @Override
    void insert(AttachService attachService) throws SQLException;

    @Override
    AttachService select(int id);

    @Override
    List<AttachService> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(AttachService attachService) throws SQLException;
}
