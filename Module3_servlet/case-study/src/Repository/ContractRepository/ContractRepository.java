package Repository.ContractRepository;

import Model.Contract;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository extends Repository<Contract> {
    @Override
    void insert(Contract contract) throws SQLException;

    @Override
    Contract select(int id);

    @Override
    List<Contract> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Contract contract) throws SQLException;
}
