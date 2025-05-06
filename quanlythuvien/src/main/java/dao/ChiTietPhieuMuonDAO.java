package dao;

import dto.ChiTietPhieuMuonDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author [Your Name]
 */
public class ChiTietPhieuMuonDAO {
    private Connection conn;

    public ChiTietPhieuMuonDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Thêm chi tiết phiếu mượn
    public boolean saveChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO chitietphieumuon (maphieumuon, masach, ngaytra, ghichu) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chiTiet.getMaPhieuMuon());
            stmt.setInt(2, chiTiet.getMaSach());
            if (chiTiet.getNgayTra() != null) {
                stmt.setDate(3, new java.sql.Date(chiTiet.getNgayTra().getTime()));
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            stmt.setString(4, chiTiet.getGhiChu());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong saveChiTietPhieuMuon: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Lấy chi tiết phiếu mượn theo mã phiếu mượn
    public ArrayList<ChiTietPhieuMuonDTO> getChiTietPhieuMuonByMaPhieuMuon(int maPhieuMuon) {
        ArrayList<ChiTietPhieuMuonDTO> result = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT maphieumuon, masach, ngaytra, ghichu FROM chitietphieumuon WHERE maphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietPhieuMuonDTO chiTiet = new ChiTietPhieuMuonDTO(
                        rs.getInt("maphieumuon"),
                        rs.getInt("masach"),
                        rs.getDate("ngaytra"),
                        rs.getString("ghichu"));
                result.add(chiTiet);
            }
            System.out.println("getChiTietPhieuMuonByMaPhieuMuon trả về " + result.size() + " chi tiết phiếu mượn");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getChiTietPhieuMuonByMaPhieuMuon: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về ArrayList rỗng để tránh null
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Cập nhật chi tiết phiếu mượn
    public boolean updateChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE chitietphieumuon SET masach = ?, ngaytra = ?, ghichu = ? WHERE maphieumuon = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chiTiet.getMaSach());
            if (chiTiet.getNgayTra() != null) {
                stmt.setDate(2, new java.sql.Date(chiTiet.getNgayTra().getTime()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }
            stmt.setString(3, chiTiet.getGhiChu());
            stmt.setInt(4, chiTiet.getMaPhieuMuon());
            stmt.setInt(5, chiTiet.getMaSach());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong updateChiTietPhieuMuon: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Xóa chi tiết phiếu mượn
    public boolean deleteChiTietPhieuMuon(int maPhieuMuon, int maSach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM chitietphieumuon WHERE maphieumuon = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);
            stmt.setInt(2, maSach);

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong deleteChiTietPhieuMuon: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Lấy số lượng sách đang mượn (đếm số bản ghi có ngaytra IS NULL)
    public int getSoLuongSachDangMuon() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int soLuongSach = 0;

        try {
            String sql = "SELECT COUNT(*) FROM chitietphieumuon WHERE ngaytra IS NULL";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                soLuongSach = rs.getInt(1); // Lấy số lượng bản ghi
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getSoLuongSachDangMuon: " + e.getMessage());
            e.printStackTrace();
            return 0; // Trả về 0 nếu có lỗi
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return soLuongSach;
    }

    // Đóng kết nối
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong ChiTietPhieuMuonDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}