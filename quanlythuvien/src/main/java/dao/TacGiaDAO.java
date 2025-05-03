package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.TacGiaDTO;

public class TacGiaDAO {
    private Connection connection;

    // Constructor: Nhận kết nối từ bên ngoài
    public TacGiaDAO() {
        this.connection = DBConnect.getConnection();
        if (this.connection == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Thêm tác giả mới
    public boolean saveTacGia(TacGiaDTO tacGia) {
        String sql = "INSERT INTO tacgia (tentacgia, namsinh, quequan) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, tacGia.getTenTacGia());
            statement.setInt(2, tacGia.getNamSinh());
            statement.setString(3, tacGia.getQueQuan());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tacGia.setMaTacGia(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Lưu tác giả thành công: " + tacGia.getMaTacGia());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin tác giả
    public boolean updateTacGia(TacGiaDTO tacGia) {
        String sql = "UPDATE tacgia SET tentacgia = ?, namsinh = ?, quequan = ? WHERE matacgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tacGia.getTenTacGia());
            statement.setInt(2, tacGia.getNamSinh());
            statement.setString(3, tacGia.getQueQuan());
            statement.setInt(4, tacGia.getMaTacGia());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật tác giả thành công: " + tacGia.getMaTacGia());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa tác giả theo mã tác giả
    public boolean deleteTacGia(int maTacGia) {
        String sql = "DELETE FROM tacgia WHERE matacgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maTacGia);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa tác giả thành công: " + maTacGia);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả tác giả
    public ArrayList<TacGiaDTO> getAllTacGia() {
        ArrayList<TacGiaDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM tacgia";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TacGiaDTO tacGia = new TacGiaDTO(
                        resultSet.getInt("matacgia"),
                        resultSet.getString("tentacgia"),
                        resultSet.getInt("namsinh"),
                        resultSet.getString("quequan"));
                result.add(tacGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm tác giả theo mã tác giả
    public TacGiaDTO findTacGiaById(int maTacGia) {
        String sql = "SELECT * FROM tacgia WHERE matacgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maTacGia);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new TacGiaDTO(
                            resultSet.getInt("matacgia"),
                            resultSet.getString("tentacgia"),
                            resultSet.getInt("namsinh"),
                            resultSet.getString("quequan"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm tác giả theo tên (phục vụ giao diện tìm kiếm)
    public ArrayList<TacGiaDTO> findTacGiaByName(String tenTacGia) {
        ArrayList<TacGiaDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM tacgia WHERE tentacgia LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tenTacGia + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TacGiaDTO tacGia = new TacGiaDTO(
                            resultSet.getInt("matacgia"),
                            resultSet.getString("tentacgia"),
                            resultSet.getInt("namsinh"),
                            resultSet.getString("quequan"));
                    result.add(tacGia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đóng kết nối cơ sở dữ liệu
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối cơ sở dữ liệu thành công.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}