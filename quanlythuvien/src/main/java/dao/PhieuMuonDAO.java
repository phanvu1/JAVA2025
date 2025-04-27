package dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import dto.PhieuMuonDTO;

public class PhieuMuonDAO {
    private Connection connection;

    public PhieuMuonDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm phiếu mượn mới
    public boolean savePhieuMuon(PhieuMuonDTO phieuMuon) {
        String sql = "INSERT INTO phieumuon (manv, madocgia, ngaymuon, tinhtrang) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, phieuMuon.getMaNV());
            statement.setInt(2, phieuMuon.getMaDocGia());
            statement.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            statement.setString(4, phieuMuon.getTinhTrang());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    phieuMuon.setMaPM(generatedKeys.getInt(1));
                }
                System.out.println("Lưu phiếu mượn thành công: " + phieuMuon.getMaPM());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin phiếu mượn
    public boolean updatePhieuMuon(PhieuMuonDTO phieuMuon) {
        String sql = "UPDATE phieumuon SET manv = ?, madocgia = ?, ngaymuon = ?, tinhtrang = ? WHERE mapm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, phieuMuon.getMaNV());
            statement.setInt(2, phieuMuon.getMaDocGia());
            statement.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            statement.setString(4, phieuMuon.getTinhTrang());
            statement.setInt(5, phieuMuon.getMaPM());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật phiếu mượn thành công: " + phieuMuon.getMaPM());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa phiếu mượn theo mã phiếu mượn
    public boolean deletePhieuMuon(int maPM) {
        String sql = "DELETE FROM phieumuon WHERE mapm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maPM);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa phiếu mượn thành công: " + maPM);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả phiếu mượn
    public List<PhieuMuonDTO> getAllPhieuMuon() {
        List<PhieuMuonDTO> result = new ArrayList<>();
        String sql = "SELECT mapm, manv, madocgia, ngaymuon, tinhtrang FROM phieumuon";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PhieuMuonDTO phieuMuon = new PhieuMuonDTO(
                        resultSet.getInt("mapm"),
                        resultSet.getInt("manv"),
                        resultSet.getInt("madocgia"),
                        resultSet.getDate("ngaymuon"),
                        resultSet.getString("tinhtrang"));
                result.add(phieuMuon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm phiếu mượn theo mã phiếu mượn
    public PhieuMuonDTO findPhieuMuonById(int maPM) {
        String sql = "SELECT mapm, manv, madocgia, ngaymuon, tinhtrang FROM phieumuon WHERE mapm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maPM);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PhieuMuonDTO(
                            resultSet.getInt("mapm"),
                            resultSet.getInt("manv"),
                            resultSet.getInt("madocgia"),
                            resultSet.getDate("ngaymuon"),
                            resultSet.getString("tinhtrang"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm kiếm phiếu mượn (có thể mở rộng với các tiêu chí khác)
    public List<PhieuMuonDTO> searchPhieuMuon(String keyword) {
        List<PhieuMuonDTO> result = new ArrayList<>();
        String sql = "SELECT mapm, manv, madocgia, ngaymuon, tinhtrang FROM phieumuon WHERE mapm LIKE ? OR manv LIKE ? OR madocgia LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PhieuMuonDTO phieuMuon = new PhieuMuonDTO(
                            resultSet.getInt("mapm"),
                            resultSet.getInt("manv"),
                            resultSet.getInt("madocgia"),
                            resultSet.getDate("ngaymuon"),
                            resultSet.getString("tinhtrang"));
                    result.add(phieuMuon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}