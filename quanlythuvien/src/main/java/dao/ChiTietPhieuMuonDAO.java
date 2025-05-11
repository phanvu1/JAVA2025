package dao;

import dto.ChiTietPhieuMuonDTO;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietPhieuMuonDAO {
    private Connection conn;

    public ChiTietPhieuMuonDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<ChiTietPhieuMuonDTO> getAll() {
        ArrayList<ChiTietPhieuMuonDTO> chitietphieumuonlist = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM chitietphieumuon";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietPhieuMuonDTO chitietphieumuon = new ChiTietPhieuMuonDTO();
                chitietphieumuon.setMaPhieuMuon(rs.getInt("maphieumuon"));
                chitietphieumuon.setMaSach(rs.getInt("masach"));
                chitietphieumuon.setNgayTra(rs.getDate("ngaytra"));
                chitietphieumuon.setGhiChu(rs.getString("ghichu"));
                chitietphieumuonlist.add(chitietphieumuon);
            }
            System.out.println("getAll trả về " + chitietphieumuonlist.size() + " chi tiết phiếu mượn");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getAll: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng để tránh null
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return chitietphieumuonlist;
    }

    public ChiTietPhieuMuonDTO getById(int maPhieuMuon, int maSach) {
        ChiTietPhieuMuonDTO chitietphieumuon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM chitietphieumuon WHERE maphieumuon = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);
            stmt.setInt(2, maSach);
            rs = stmt.executeQuery();

            if (rs.next()) {
                chitietphieumuon = new ChiTietPhieuMuonDTO();
                chitietphieumuon.setMaPhieuMuon(rs.getInt("maphieumuon"));
                chitietphieumuon.setMaSach(rs.getInt("masach"));
                chitietphieumuon.setNgayTra(rs.getDate("ngaytra"));
                chitietphieumuon.setGhiChu(rs.getString("ghichu"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return chitietphieumuon;
    }

    public boolean insert(ChiTietPhieuMuonDTO chitietphieumuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO chitietphieumuon (maphieumuon, masach, ngaytra, ghichu) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chitietphieumuon.getMaPhieuMuon());
            stmt.setInt(2, chitietphieumuon.getMaSach());
            if (chitietphieumuon.getNgayTra() != null) {
                stmt.setDate(3, new java.sql.Date(chitietphieumuon.getNgayTra().getTime()));
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            stmt.setString(4, chitietphieumuon.getGhiChu());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
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

    public boolean update(ChiTietPhieuMuonDTO chitietphieumuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE chitietphieumuon SET ngaytra = ?, ghichu = ? WHERE maphieumuon = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            if (chitietphieumuon.getNgayTra() != null) {
                stmt.setDate(1, new java.sql.Date(chitietphieumuon.getNgayTra().getTime()));
            } else {
                stmt.setNull(1, java.sql.Types.DATE);
            }
            stmt.setString(2, chitietphieumuon.getGhiChu());
            stmt.setInt(3, chitietphieumuon.getMaPhieuMuon());
            stmt.setInt(4, chitietphieumuon.getMaSach());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
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

    public boolean delete(int maPhieuMuon, int maSach) {
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

    public boolean deleteByMaPN(int maPhieuMuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM chitietphieumuon WHERE maphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);

            int rows = stmt.executeUpdate();
            result = rows >= 0; // Xóa thành công hoặc không có bản ghi nào cũng được coi là thành công
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong deleteByMaPN: " + e.getMessage());
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