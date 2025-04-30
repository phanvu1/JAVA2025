package dao;

import dto.ChiTietPhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class ChiTietPhieuNhapDAO {
    private Connection conn;

    public ChiTietPhieuNhapDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<ChiTietPhieuNhapDTO> getAll() {
        ArrayList<ChiTietPhieuNhapDTO> chitietphieunhaplist = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM chitietphieunhap";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietPhieuNhapDTO chitietphieunhap = new ChiTietPhieuNhapDTO();
                chitietphieunhap.setMaphieunhap(rs.getInt("maphieunhap"));
                chitietphieunhap.setMasach(rs.getInt("masach"));
                chitietphieunhap.setGia(rs.getDouble("gia"));
                chitietphieunhap.setSoluong(rs.getInt("soluong"));
                chitietphieunhaplist.add(chitietphieunhap);
            }
            System.out.println("getAll trả về " + chitietphieunhaplist.size() + " chi tiết phiếu nhập");
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
        return chitietphieunhaplist;
    }

    public ChiTietPhieuNhapDTO getById(int maphieunhap, int masach) {
        ChiTietPhieuNhapDTO chitietphieunhap = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM chitietphieunhap WHERE maphieunhap = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maphieunhap);
            stmt.setInt(2, masach);
            rs = stmt.executeQuery();

            if (rs.next()) {
                chitietphieunhap = new ChiTietPhieuNhapDTO();
                chitietphieunhap.setMaphieunhap(rs.getInt("maphieunhap"));
                chitietphieunhap.setMasach(rs.getInt("masach"));
                chitietphieunhap.setGia(rs.getDouble("gia"));
                chitietphieunhap.setSoluong(rs.getInt("soluong"));
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
        return chitietphieunhap;
    }

    public boolean insert(ChiTietPhieuNhapDTO chitietphieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO chitietphieunhap (maphieunhap, masach, gia, soluong) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chitietphieunhap.getMaphieunhap());
            stmt.setInt(2, chitietphieunhap.getMasach());
            stmt.setDouble(3, chitietphieunhap.getGia());
            stmt.setInt(4, chitietphieunhap.getSoluong());

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

    public boolean update(ChiTietPhieuNhapDTO chitietphieunhap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE chitietphieunhap SET gia = ?, soluong = ? WHERE maphieunhap = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, chitietphieunhap.getGia());
            stmt.setInt(2, chitietphieunhap.getSoluong());
            stmt.setInt(3, chitietphieunhap.getMaphieunhap());
            stmt.setInt(4, chitietphieunhap.getMasach());

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

    public boolean delete(int maphieunhap, int masach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM chitietphieunhap WHERE maphieunhap = ? AND masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maphieunhap);
            stmt.setInt(2, masach);

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
                System.out.println("Đóng kết nối trong ChiTietPhieuNhapDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}