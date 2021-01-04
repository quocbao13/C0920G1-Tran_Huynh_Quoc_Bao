package repository.BenhAnRepo;

import connection.ConnectionSQL;
import model.BenhAn;
import model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepoImpl implements BenhAnRepo {

    private static final String INSERT_SQL = "INSERT INTO benhan" + "  (ngaynhapvien, ngayravien," +
            " lydonhapvien, benhnhan_id) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select benhan.*, benhnhan.* from benhan join benhnhan " +
            "on benhan.benhnhan_id = benhnhan.benhnhan_id where benhan_id =?";
    private static final String SELECT_ALL = "select  benhan.*, benhnhan.* from benhan join benhnhan " +
            "on benhan.benhnhan_id = benhnhan.benhnhan_id";
    private static final String DELETE_SQL = "delete from benhan where benhan_id = ?;";
    private static final String UPDATE_SQL = "update benhan set ngaynhapvien = ?, ngayravien = ?," +
            " lydonhapvien = ?, benhnhan_id = ? where benhan_id = ?;";
    @Override
    public void insert(BenhAn benhAn) throws SQLException {
        System.out.println(INSERT_SQL);
        try(Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, benhAn.getNgayVao());
            preparedStatement.setString(2, benhAn.getNgayRa());
            preparedStatement.setString(3, benhAn.getLyDoNhapVien());
            preparedStatement.setInt(4, benhAn.getBenhNhan().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ignored){
            printSQLException(ignored);
        }finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public BenhAn select(int id) {
        BenhAn benhAn = null;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ngayVao = resultSet.getString("ngaynhapvien");
                String ngayRa = resultSet.getString("ngayravien");
                String lyDo = resultSet.getString("lydonhapvien");
                String tenbenhnhan = resultSet.getString("tenbenhnhan");
                int benhnhan_id = resultSet.getInt("benhnhan_id");
                benhAn = new BenhAn(id, ngayVao, ngayRa, lyDo, new BenhNhan(benhnhan_id, tenbenhnhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionSQL.close();
        }
        return benhAn;
    }

    @Override
    public List<BenhAn> selectAll() {
        List<BenhAn> benhAns = new ArrayList<>();
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("benhan_id");
                String ngayVao = resultSet.getString("ngaynhapvien");
                String ngayRa = resultSet.getString("ngayravien");
                String lyDo = resultSet.getString("lydonhapvien");
                String tenbenhnhan = resultSet.getString("tenbenhnhan");
                int benhnhan_id = resultSet.getInt("benhnhan_id");
                benhAns.add(new BenhAn(id, ngayVao, ngayRa, lyDo, new BenhNhan(benhnhan_id, tenbenhnhan)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return benhAns;
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
    public boolean update(BenhAn benhAn) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, benhAn.getNgayVao());
            preparedStatement.setString(2, benhAn.getNgayRa());
            preparedStatement.setString(3, benhAn.getLyDoNhapVien());
            preparedStatement.setInt(4, benhAn.getBenhNhan().getId());
            preparedStatement.setInt(5, benhAn.getId());
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
