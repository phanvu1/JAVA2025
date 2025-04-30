package dao;

import dto.PhieuNhapDTO;
import dao.ChiTietPhieuNhapDAO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class PhieuNhapDAO {
    private Connection conn;
    
    public PhieuNhapDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }
    
    public boolean updateTongTienByMaPN(int maphieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            ChiTietPhieuNhapDAO chiTietDAO = new ChiTietPhieuNhapDAO();
            double tongtien = chiTietDAO.getTongTienByMaPN(maphieunhap);

            String sql = "UPDATE phieunhap SET tongtien = ? WHERE maphieunhap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, tongtien);
            stmt.setInt(2, maphieunhap);

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong updateTongTienByMaPN: " + e.getMessage());
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
    public ArrayList<PhieuNhapDTO> getAll() {
        ArrayList<PhieuNhapDTO> phieunhaplist = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieunhap";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PhieuNhapDTO phieunhap = new PhieuNhapDTO();
                phieunhap.setMaphieunhap(rs.getInt("maphieunhap"));
                phieunhap.setMancc(rs.getInt("mancc"));
                phieunhap.setManv(rs.getInt("manv"));
                phieunhap.setNgaynhap(rs.getDate("ngaynhap"));
                phieunhap.setTongtien(rs.getDouble("tongtien")); // Thêm cột tongtien
                phieunhaplist.add(phieunhap);
            }
            System.out.println("getAll trả về " + phieunhaplist.size() + " phiếu nhập");
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
        return phieunhaplist;
    }
    
    public PhieuNhapDTO getById(int maphieunhap) {
        PhieuNhapDTO phieunhap = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieunhap WHERE maphieunhap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maphieunhap);
            rs = stmt.executeQuery();

            if (rs.next()) {
                phieunhap = new PhieuNhapDTO();
                phieunhap.setMaphieunhap(rs.getInt("maphieunhap"));
                phieunhap.setMancc(rs.getInt("mancc"));
                phieunhap.setManv(rs.getInt("manv"));
                phieunhap.setNgaynhap(rs.getDate("ngaynhap"));
                phieunhap.setTongtien(rs.getDouble("tongtien")); // Thêm cột tongtien
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
        return phieunhap;
    }

    public boolean insert(PhieuNhapDTO phieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO phieunhap (mancc, manv, ngaynhap, tongtien) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phieunhap.getMancc());
            stmt.setInt(2, phieunhap.getManv());
            stmt.setDate(3, new java.sql.Date(phieunhap.getNgaynhap().getTime()));
            stmt.setDouble(4, phieunhap.getTongTien()); // Thêm cột tongtien

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
    
    public boolean update(PhieuNhapDTO phieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE phieunhap SET mancc = ?, manv = ?, ngaynhap = ?, tongtien = ? WHERE maphieunhap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phieunhap.getMancc());
            stmt.setInt(2, phieunhap.getManv());
            stmt.setDate(3, new java.sql.Date(phieunhap.getNgaynhap().getTime()));
            stmt.setDouble(4, phieunhap.getTongTien()); // Thêm cột tongtien
            stmt.setInt(5, phieunhap.getMaphieunhap());

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
    
    public boolean delete(int maphieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM phieunhap WHERE maphieunhap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maphieunhap);

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
    
    
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong PhieuNhapDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}