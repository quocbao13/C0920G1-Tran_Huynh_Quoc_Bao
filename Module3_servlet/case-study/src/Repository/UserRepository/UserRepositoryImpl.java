package Repository.UserRepository;

import Model.Position;
import Model.User;
import Repository.ConnectionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private static final String INSERT_SQL = "INSERT INTO user" + "  (username) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from user where username =?";
    private static final String SELECT_ALL = "select * from user";
    private static final String DELETE_SQL = "delete from user where username = ?;";
    private static final String UPDATE_SQL = "update user set password = ? where username = ?;";

    @Override
    public void insert(User user) throws SQLException {

    }

    @Override
    public User select(String username) {
        User user = null;
        try (Connection connection = new ConnectionRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username1 = resultSet.getString("username");
                String password = resultSet.getString("password");
                user = new User(username1, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionRepository.close();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }
}
