package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.NhaXuatBanDTO;

public class NhaXuatBanDAO {
    private Connection connection;

    // Constructor: Nhận kết nối từ bên ngoài
    public NhaXuatBanDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm nhà xuất bản mới
    public boolean saveNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        String sql = "INSERT INTO nhaxuatban (tennxb, diachi, sodienthoai) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, nhaXuatBan.getTenNXB());
            statement.setString(2, nhaXuatBan.getDiaChi());
            statement.setString(3, nhaXuatBan.getSDT());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    nhaXuatBan.setMaNXB(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Lưu nhà xuất bản thành công: " + nhaXuatBan.getMaNXB());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin nhà xuất bản
    public boolean updateNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        String sql = "UPDATE nhaxuatban SET tennxb = ?, diachi = ?, sodienthoai = ? WHERE manxb = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nhaXuatBan.getTenNXB());
            statement.setString(2, nhaXuatBan.getDiaChi());
            statement.setString(3, nhaXuatBan.getSDT());
            statement.setInt(4, nhaXuatBan.getMaNXB());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật nhà xuất bản thành công: " + nhaXuatBan.getMaNXB());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa nhà xuất bản theo mã nhà xuất bản
    public boolean deleteNhaXuatBan(int maNXB) {
        String sql = "DELETE FROM nhaxuatban WHERE manxb = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maNXB);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa nhà xuất bản thành công: " + maNXB);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả nhà xuất bản
    public List<NhaXuatBanDTO> getAllNhaXuatBan() {
        List<NhaXuatBanDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM nhaxuatban";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(
                        resultSet.getInt("manxb"),
                        resultSet.getString("tennxb"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sodienthoai"));
                result.add(nhaXuatBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm nhà xuất bản theo mã nhà xuất bản
    public NhaXuatBanDTO findNhaXuatBanById(int maNXB) {
        String sql = "SELECT * FROM nhaxuatban WHERE manxb = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maNXB);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new NhaXuatBanDTO(
                            resultSet.getInt("manxb"),
                            resultSet.getString("tennxb"),
                            resultSet.getString("diachi"),
                            resultSet.getString("sodienthoai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm nhà xuất bản theo tên (phục vụ giao diện tìm kiếm)
    public List<NhaXuatBanDTO> findNhaXuatBanByName(String tenNXB) {
        List<NhaXuatBanDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM nhaxuatban WHERE tennxb LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tenNXB + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(
                            resultSet.getInt("manxb"),
                            resultSet.getString("tennxb"),
                            resultSet.getString("diachi"),
                            resultSet.getString("sodienthoai"));
                    result.add(nhaXuatBan);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}