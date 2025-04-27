package dao;

import dto.SachDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private Connection connection;

    // Constructor: Nhận kết nối từ bên ngoài
    public SachDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm sách mới
    public boolean saveSach(SachDTO sach) {
        String sql = "INSERT INTO sach (tensach, maloai, manxb, namxb, soluong, makesach, hinhanh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, sach.getTenSach());
            statement.setInt(2, sach.getMaLoai());
            statement.setInt(3, sach.getMaNXB());
            statement.setInt(4, sach.getNamXB());
            statement.setInt(5, sach.getSoLuong());
            statement.setInt(6, sach.getMaKeSach());
            statement.setString(7, sach.getHinhAnh());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    sach.setMaSach(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Lưu sách thành công: " + sach.getMaSach());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin sách
    public boolean updateSach(SachDTO sach) {
        String sql = "UPDATE sach SET tensach = ?, maloai = ?, manxb = ?, namxb = ?, soluong = ?, makesach = ?, hinhanh = ? WHERE masach = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sach.getTenSach());
            statement.setInt(2, sach.getMaLoai());
            statement.setInt(3, sach.getMaNXB());
            statement.setInt(4, sach.getNamXB());
            statement.setInt(5, sach.getSoLuong());
            statement.setInt(6, sach.getMaKeSach());
            statement.setString(7, sach.getHinhAnh());
            statement.setInt(8, sach.getMaSach());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật sách thành công: " + sach.getMaSach());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sách theo mã sách
    public boolean deleteSach(int maSach) {
        String sql = "DELETE FROM sach WHERE masach = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maSach);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa sách thành công: " + maSach);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả sách
    public List<SachDTO> getAllSach() {
        List<SachDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM sach";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                SachDTO sach = new SachDTO(
                        resultSet.getInt("masach"),
                        resultSet.getString("tensach"),
                        resultSet.getInt("maloai"),
                        resultSet.getInt("manxb"),
                        resultSet.getInt("namxb"),
                        resultSet.getInt("soluong"),
                        resultSet.getInt("makesach"),
                        resultSet.getString("hinhanh"));
                result.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm sách theo mã sách
    public SachDTO findSachById(int maSach) {
        String sql = "SELECT * FROM sach WHERE masach = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maSach);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new SachDTO(
                            resultSet.getInt("masach"),
                            resultSet.getString("tensach"),
                            resultSet.getInt("maloai"),
                            resultSet.getInt("manxb"),
                            resultSet.getInt("namxb"),
                            resultSet.getInt("soluong"),
                            resultSet.getInt("makesach"),
                            resultSet.getString("hinhanh"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm sách theo tên sách (phục vụ giao diện tìm kiếm)
    public List<SachDTO> findSachByName(String tenSach) {
        List<SachDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE tensach LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tenSach + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    SachDTO sach = new SachDTO(
                            resultSet.getInt("masach"),
                            resultSet.getString("tensach"),
                            resultSet.getInt("maloai"),
                            resultSet.getInt("manxb"),
                            resultSet.getInt("namxb"),
                            resultSet.getInt("soluong"),
                            resultSet.getInt("makesach"),
                            resultSet.getString("hinhanh"));
                    result.add(sach);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}