package dao;

import dto.LoaiSachDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class LoaiSachDAO {
    private Connection conn;

    public LoaiSachDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<LoaiSachDTO> getAll() {
        ArrayList<LoaiSachDTO> loaiSachList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM loai";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                LoaiSachDTO loaiSach = new LoaiSachDTO();
                loaiSach.setMaloai(rs.getInt("maloai"));
                loaiSach.setTenloai(rs.getString("tenloai"));
                loaiSachList.add(loaiSach);
            }
            System.out.println("getAll trả về " + loaiSachList.size() + " loại sách");
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
        return loaiSachList;
    }

    public LoaiSachDTO getById(int maloai) {
        LoaiSachDTO loaiSach = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM loai WHERE maloai = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maloai);
            rs = stmt.executeQuery();

            if (rs.next()) {
                loaiSach = new LoaiSachDTO();
                loaiSach.setMaloai(rs.getInt("maloai"));
                loaiSach.setTenloai(rs.getString("tenloai"));
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
        return loaiSach;
    }

    public boolean insert(String loaisach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO loai (tenloai) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, loaisach);

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

    public boolean update(LoaiSachDTO loaiSach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE loai SET tenloai = ? WHERE maloai = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, loaiSach.getTenloai());
            stmt.setInt(2, loaiSach.getMaloai());

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

    public boolean delete(int maloai) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM loai WHERE maloai = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maloai);

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
                System.out.println("Đóng kết nối trong LoaiSachDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
