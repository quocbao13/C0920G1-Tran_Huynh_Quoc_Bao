package Repository.UserRepository;

import Model.User;
import Repository.Repository;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository{
    void insert(User user) throws SQLException;

    User select(String username);

    List<User> selectAll();

    boolean delete(int id) throws SQLException;

    boolean update(User user) throws SQLException;
}
