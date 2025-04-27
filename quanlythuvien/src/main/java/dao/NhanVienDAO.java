package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.NhanVienDTO;

public class NhanVienDAO {
    private Connection connection;

    public NhanVienDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm nhân viên mới
    public boolean saveNhanVien(NhanVienDTO nhanVien) {
        String sql = "INSERT INTO nhanvien (tennv, gioitinh, namsinh, diachi, sdt) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, nhanVien.getTenNV());
            statement.setString(2, nhanVien.getGioiTinh());
            statement.setInt(3, nhanVien.getNamSinh());
            statement.setString(4, nhanVien.getDiaChi());
            statement.setString(5, nhanVien.getSDT());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    nhanVien.setMaNV(generatedKeys.getInt(1));
                }
                System.out.println("Lưu nhân viên thành công: " + nhanVien.getMaNV());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(NhanVienDTO nhanVien) {
        String sql = "UPDATE nhanvien SET tennv = ?, gioitinh = ?, namsinh = ?, diachi = ?, sdt = ? WHERE manv = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nhanVien.getTenNV());
            statement.setString(2, nhanVien.getGioiTinh());
            statement.setInt(3, nhanVien.getNamSinh());
            statement.setString(4, nhanVien.getDiaChi());
            statement.setString(5, nhanVien.getSDT());
            statement.setInt(6, nhanVien.getMaNV());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật nhân viên thành công: " + nhanVien.getMaNV());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa nhân viên theo mã nhân viên
    public boolean deleteNhanVien(int maNV) {
        String sql = "DELETE FROM nhanvien WHERE manv = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maNV);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa nhân viên thành công: " + maNV);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVienDTO> getAllNhanVien() {
        List<NhanVienDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                NhanVienDTO nhanVien = new NhanVienDTO(
                        resultSet.getInt("manv"),
                        resultSet.getString("tennv"),
                        resultSet.getString("gioitinh"),
                        resultSet.getInt("namsinh"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt"));
                result.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm nhân viên theo mã nhân viên
    public NhanVienDTO findNhanVienById(int maNV) {
        String sql = "SELECT * FROM nhanvien WHERE manv = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maNV);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new NhanVienDTO(
                            resultSet.getInt("manv"),
                            resultSet.getString("tennv"),
                            resultSet.getString("gioitinh"),
                            resultSet.getInt("namsinh"),
                            resultSet.getString("diachi"),
                            resultSet.getString("sdt"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm nhân viên theo tên (phục vụ giao diện tìm kiếm)
    public List<NhanVienDTO> findNhanVienByName(String tenNV) {
        List<NhanVienDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien WHERE tennv LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tenNV + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    NhanVienDTO nhanVien = new NhanVienDTO(
                            resultSet.getInt("manv"),
                            resultSet.getString("tennv"),
                            resultSet.getString("gioitinh"),
                            resultSet.getInt("namsinh"),
                            resultSet.getString("diachi"),
                            resultSet.getString("sdt"));
                    result.add(nhanVien);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}