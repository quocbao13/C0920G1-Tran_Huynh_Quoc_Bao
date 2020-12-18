package Repository.PositionRepository;

import Model.Position;
import Repository.ConnectionRepository;
import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository{
    private static final String INSERT_SQL = "INSERT INTO positions" + "  (position_name) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from positions where position_id =?";
    private static final String SELECT_ALL = "select * from positions";
    private static final String DELETE_SQL = "delete from positions where position_id = ?;";
    private static final String UPDATE_SQL = "update users set position_name = ? where position_id = ?;";

    @Override
    public void insert(Position t) throws SQLException {
        System.out.println(INSERT_SQL);
        Connection connection = new ConnectionRepository().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, t.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }
    }

    @Override
    public Position select(int id) {
        return null;
    }

    @Override
    public List<Position> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Position t) throws SQLException {
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
