package repository.BenhAnRepo;

import model.BenhAn;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface BenhAnRepo extends Repository<BenhAn> {

    @Override
    void insert(BenhAn benhAn) throws SQLException;

    @Override
    BenhAn select(int id);

    @Override
    List<BenhAn> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(BenhAn benhAn) throws SQLException;
}
