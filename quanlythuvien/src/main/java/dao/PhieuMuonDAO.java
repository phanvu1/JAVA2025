package dao;

import dto.PhieuMuonDTO;
import java.sql.*;
import java.util.ArrayList;

public class PhieuMuonDAO {
    private Connection conn;
    
    public PhieuMuonDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }
    
    public ArrayList<PhieuMuonDTO> getAll() {
        ArrayList<PhieuMuonDTO> phieuMuonList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieumuon";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PhieuMuonDTO phieuMuon = new PhieuMuonDTO();
                phieuMuon.setMaPM(rs.getInt("mapm"));
                phieuMuon.setMaNV(rs.getInt("manv"));
                phieuMuon.setMaDocGia(rs.getInt("madocgia"));
                phieuMuon.setNgayMuon(rs.getDate("ngaymuon"));
                phieuMuon.setTinhTrang(rs.getString("tinhtrang"));
                phieuMuonList.add(phieuMuon);
            }
            System.out.println("getAll trả về " + phieuMuonList.size() + " phiếu mượn");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getAll: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return phieuMuonList;
    }
    
    public PhieuMuonDTO getById(int maPM) {
        PhieuMuonDTO phieuMuon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieumuon WHERE mapm = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPM);
            rs = stmt.executeQuery();

            if (rs.next()) {
                phieuMuon = new PhieuMuonDTO();
                phieuMuon.setMaPM(rs.getInt("mapm"));
                phieuMuon.setMaNV(rs.getInt("manv"));
                phieuMuon.setMaDocGia(rs.getInt("madocgia"));
                phieuMuon.setNgayMuon(rs.getDate("ngaymuon"));
                phieuMuon.setTinhTrang(rs.getString("tinhtrang"));
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
        return phieuMuon;
    }

    public boolean insert(PhieuMuonDTO phieuMuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO phieumuon (manv, madocgia, ngaymuon, tinhtrang) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, phieuMuon.getMaNV());
            stmt.setInt(2, phieuMuon.getMaDocGia());
            stmt.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            stmt.setString(4, phieuMuon.getTinhTrang());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    phieuMuon.setMaPM(generatedKeys.getInt(1));
                }
                result = true;
            }
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
    
    public boolean update(PhieuMuonDTO phieuMuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE phieumuon SET manv = ?, madocgia = ?, ngaymuon = ?, tinhtrang = ? WHERE mapm = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phieuMuon.getMaNV());
            stmt.setInt(2, phieuMuon.getMaDocGia());
            stmt.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            stmt.setString(4, phieuMuon.getTinhTrang());
            stmt.setInt(5, phieuMuon.getMaPM());

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
    
    public boolean delete(int maPM) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM phieumuon WHERE mapm = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPM);

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
    
    public ArrayList<PhieuMuonDTO> search(String keyword) {
        ArrayList<PhieuMuonDTO> result = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieumuon WHERE mapm LIKE ? OR manv LIKE ? OR madocgia LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                PhieuMuonDTO phieuMuon = new PhieuMuonDTO();
                phieuMuon.setMaPM(rs.getInt("mapm"));
                phieuMuon.setMaNV(rs.getInt("manv"));
                phieuMuon.setMaDocGia(rs.getInt("madocgia"));
                phieuMuon.setNgayMuon(rs.getDate("ngaymuon"));
                phieuMuon.setTinhTrang(rs.getString("tinhtrang"));
                result.add(phieuMuon);
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
        return result;
    }
    
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong PhieuMuonDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}