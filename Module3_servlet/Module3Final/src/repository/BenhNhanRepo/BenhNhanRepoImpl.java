package repository.BenhNhanRepo;

import connection.ConnectionSQL;
import model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepoImpl implements BenhNhanRepo {

    private static final String INSERT_SQL = "INSERT INTO benhnhan" + "  (tenbenhnhan) VALUES " +
            " (?);";
    private static final String SELECT_BY_ID = "select * from benhnhan where benhnhan_id =?";
    private static final String SELECT_ALL = "select * from benhnhan";
    private static final String DELETE_SQL = "delete from benhnhan where benhnhan_id = ?;";
    private static final String UPDATE_SQL = "update benhnhan set tenbenhnhan = ? where benhnhan_id = ?;";

    @Override
    public void insert(BenhNhan benhNhan) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, benhNhan.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public BenhNhan select(int id) {
        BenhNhan benhNhan = null;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("tenbenhnhan");
                benhNhan = new BenhNhan(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionSQL.close();
        }
        return benhNhan;
    }

    @Override
    public List<BenhNhan> selectAll() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("benhnhan_id");
                String name = rs.getString("tenbenhnhan");
                benhNhans.add(new BenhNhan(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return benhNhans;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowDelete;
    }

    @Override
    public boolean update(BenhNhan benhNhan) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, benhNhan.getName());
            preparedStatement.setInt(2, benhNhan.getId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowUpdate;
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
