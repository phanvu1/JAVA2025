package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DocGiaDTO;

public class DocGiaDAO {
    private Connection connection;

    // Constructor: Nhận kết nối từ bên ngoài
    public DocGiaDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm độc giả mới
    public boolean saveDocGia(DocGiaDTO docGia) {
        String sql = "INSERT INTO docgia (tendg, gioitinh, diachi, mathe) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, docGia.getTenDocGia());
            statement.setString(2, docGia.getGioiTinh());
            statement.setString(3, docGia.getDiaChi());
            statement.setInt(4, docGia.getMaThe());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    docGia.setMaDocGia(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Lưu độc giả thành công: " + docGia.getMaDocGia());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin độc giả
    public boolean updateDocGia(DocGiaDTO docGia) {
        String sql = "UPDATE docgia SET tendg = ?, gioitinh = ?, diachi = ?, mathe = ? WHERE madocgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, docGia.getTenDocGia());
            statement.setString(2, docGia.getGioiTinh());
            statement.setString(3, docGia.getDiaChi());
            statement.setInt(4, docGia.getMaThe());
            statement.setInt(5, docGia.getMaDocGia());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật độc giả thành công: " + docGia.getMaDocGia());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa độc giả theo mã độc giả
    public boolean deleteDocGia(int maDocGia) {
        String sql = "DELETE FROM docgia WHERE madocgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maDocGia);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa độc giả thành công: " + maDocGia);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả độc giả
    public List<DocGiaDTO> getAllDocGia() {
        List<DocGiaDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM docgia";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DocGiaDTO docGia = new DocGiaDTO(
                        resultSet.getInt("madocgia"),
                        resultSet.getString("tendg"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("diachi"),
                        resultSet.getInt("mathe"));
                result.add(docGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm độc giả theo mã độc giả
    public DocGiaDTO findDocGiaById(int maDocGia) {
        String sql = "SELECT * FROM docgia WHERE madocgia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maDocGia);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new DocGiaDTO(
                            resultSet.getInt("madocgia"),
                            resultSet.getString("tendg"),
                            resultSet.getString("gioitinh"),
                            resultSet.getString("diachi"),
                            resultSet.getInt("mathe"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm độc giả theo tên (phục vụ giao diện tìm kiếm)
    public List<DocGiaDTO> findDocGiaByName(String tenDocGia) {
        List<DocGiaDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM docgia WHERE tendg LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tenDocGia + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DocGiaDTO docGia = new DocGiaDTO(
                            resultSet.getInt("madocgia"),
                            resultSet.getString("tendg"),
                            resultSet.getString("gioitinh"),
                            resultSet.getString("diachi"),
                            resultSet.getInt("mathe"));
                    result.add(docGia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}