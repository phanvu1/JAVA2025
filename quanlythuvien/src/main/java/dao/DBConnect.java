package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection connection;

    // Thông tin kết nối cơ sở dữ liệu
    private static final String url = "jdbc:mysql://127.0.0.1:3306/quanlythuvien";
    private static final String username = "root";
    private static final String password = "";

    // Constructor private để ngăn tạo đối tượng từ bên ngoài
    private DBConnect() {}

    // Phương thức lấy kết nối (Singleton)
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Kết nối cơ sở dữ liệu thành công!");
            } catch (SQLException e) {
                System.err.println("Kết nối cơ sở dữ liệu thất bại!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Phương thức đóng kết nối
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối cơ sở dữ liệu thành công!");
            } catch (SQLException e) {
                System.err.println("Đóng kết nối cơ sở dữ liệu thất bại!");
                e.printStackTrace();
            }
        }
    }
}