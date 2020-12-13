import java.sql.*;

public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/furamaresort?";
    private static String user = "root", pw = "a123123";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection( url, user, pw);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from khachhang");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println( "Id: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
