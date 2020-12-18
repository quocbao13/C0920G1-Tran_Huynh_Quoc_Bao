package Repository.PositionRepository;

import Model.Position;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface PositionRepository extends Repository<Position> {
    public void insert(Position t) throws SQLException;

    public Position select(int id);

    public List<Position> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Position t) throws SQLException;
}
