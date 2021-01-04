package repository.BenhNhanRepo;

import model.BenhNhan;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface BenhNhanRepo extends Repository<BenhNhan> {
    @Override
    void insert(BenhNhan benhNhan) throws SQLException;

    @Override
    BenhNhan select(int id);

    @Override
    List<BenhNhan> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(BenhNhan benhNhan) throws SQLException;
}
