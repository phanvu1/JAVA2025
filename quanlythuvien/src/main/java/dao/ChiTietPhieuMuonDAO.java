package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.ChiTietPhieuMuonDTO;

public class ChiTietPhieuMuonDAO {
    private Connection connection;

    public ChiTietPhieuMuonDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm chi tiết phiếu mượn
    public boolean saveChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        String sql = "INSERT INTO chitietphieumuon (maphieumuon, masach, ngaytra, ghichu) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chiTiet.getMaPhieuMuon());
            statement.setInt(2, chiTiet.getMaSach());
            statement.setDate(3, new java.sql.Date(chiTiet.getNgayTra().getTime()));
            statement.setString(4, chiTiet.getGhiChu());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy chi tiết phiếu mượn theo mã phiếu mượn
    public List<ChiTietPhieuMuonDTO> getChiTietPhieuMuonByMaPhieuMuon(int maPhieuMuon) {
        List<ChiTietPhieuMuonDTO> result = new ArrayList<>();
        String sql = "SELECT maphieumuon, masach, ngaytra, ghichu FROM chitietphieumuon WHERE maphieumuon = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maPhieuMuon);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ChiTietPhieuMuonDTO chiTiet = new ChiTietPhieuMuonDTO(
                            resultSet.getInt("maphieumuon"),
                            resultSet.getInt("masach"),
                            resultSet.getDate("ngaytra"),
                            resultSet.getString("ghichu"));
                    result.add(chiTiet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Cập nhật chi tiết phiếu mượn
    public boolean updateChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        String sql = "UPDATE chitietphieumuon SET masach = ?, ngaytra = ?, ghichu = ? WHERE maphieumuon = ? AND masach = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chiTiet.getMaSach());
            statement.setDate(2, new java.sql.Date(chiTiet.getNgayTra().getTime()));
            statement.setString(3, chiTiet.getGhiChu());
            statement.setInt(4, chiTiet.getMaPhieuMuon());
            statement.setInt(5, chiTiet.getMaSach()); // Điều kiện WHERE cần cả maphieumuon và masach
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa chi tiết phiếu mượn (cần cả maphieumuon và masach để xác định duy nhất)
    public boolean deleteChiTietPhieuMuon(int maPhieuMuon, int maSach) {
        String sql = "DELETE FROM chitietphieumuon WHERE maphieumuon = ? AND masach = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maPhieuMuon);
            statement.setInt(2, maSach);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}