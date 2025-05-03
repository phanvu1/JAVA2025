package dao;

import dto.SachDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author [Your Name]
 */
public class SachDAO {
    private Connection conn;

    public SachDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Thêm sách mới
    public boolean saveSach(SachDTO sach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO sach (tensach, maloai, manxb, namxb, soluong, makesach, hinhanh) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, sach.getTenSach());
            stmt.setInt(2, sach.getMaLoai());
            stmt.setInt(3, sach.getMaNXB());
            stmt.setInt(4, sach.getNamXB());
            stmt.setInt(5, sach.getSoLuong());
            stmt.setInt(6, sach.getMaKeSach());
            stmt.setString(7, sach.getHinhAnh());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    sach.setMaSach(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Lưu sách thành công: " + sach.getMaSach());
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong saveSach: " + e.getMessage());
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

    // Cập nhật thông tin sách
    public boolean updateSach(SachDTO sach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE sach SET tensach = ?, maloai = ?, manxb = ?, namxb = ?, soluong = ?, makesach = ?, hinhanh = ? WHERE masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sach.getTenSach());
            stmt.setInt(2, sach.getMaLoai());
            stmt.setInt(3, sach.getMaNXB());
            stmt.setInt(4, sach.getNamXB());
            stmt.setInt(5, sach.getSoLuong());
            stmt.setInt(6, sach.getMaKeSach());
            stmt.setString(7, sach.getHinhAnh());
            stmt.setInt(8, sach.getMaSach());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Cập nhật sách thành công: " + sach.getMaSach());
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong updateSach: " + e.getMessage());
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

    // Xóa sách theo mã sách
    public boolean deleteSach(int maSach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM sach WHERE masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maSach);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Xóa sách thành công: " + maSach);
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong deleteSach: " + e.getMessage());
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

    // Lấy danh sách tất cả sách
    public ArrayList<SachDTO> getAllSach() {
        ArrayList<SachDTO> result = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SachDTO sach = new SachDTO(
                        rs.getInt("masach"),
                        rs.getString("tensach"),
                        rs.getInt("maloai"),
                        rs.getInt("manxb"),
                        rs.getInt("namxb"),
                        rs.getInt("soluong"),
                        rs.getInt("makesach"),
                        rs.getString("hinhanh"));
                result.add(sach);
            }
            System.out.println("getAllSach trả về " + result.size() + " sách");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getAllSach: " + e.getMessage());
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

    // Tìm sách theo mã sách
    public SachDTO findSachById(int maSach) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SachDTO sach = null;

        try {
            String sql = "SELECT * FROM sach WHERE masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maSach);
            rs = stmt.executeQuery();

            if (rs.next()) {
                sach = new SachDTO(
                        rs.getInt("masach"),
                        rs.getString("tensach"),
                        rs.getInt("maloai"),
                        rs.getInt("manxb"),
                        rs.getInt("namxb"),
                        rs.getInt("soluong"),
                        rs.getInt("makesach"),
                        rs.getString("hinhanh"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong findSachById: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sach;
    }

    // Tìm sách theo tên sách (phục vụ giao diện tìm kiếm)
    public ArrayList<SachDTO> findSachByName(String tenSach) {
        ArrayList<SachDTO> result = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sach WHERE tensach LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenSach + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                SachDTO sach = new SachDTO(
                        rs.getInt("masach"),
                        rs.getString("tensach"),
                        rs.getInt("maloai"),
                        rs.getInt("manxb"),
                        rs.getInt("namxb"),
                        rs.getInt("soluong"),
                        rs.getInt("makesach"),
                        rs.getString("hinhanh"));
                result.add(sach);
            }
            System.out.println("findSachByName trả về " + result.size() + " sách");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong findSachByName: " + e.getMessage());
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

    // Lấy tổng số lượng sách
    public int getsoluongallsach() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int tongsach = 0;

        try {
            String sql = "SELECT SUM(soluong) FROM sach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                tongsach = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getsoluongallsach: " + e.getMessage());
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
        return tongsach;
    }

    // Đóng kết nối
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong SachDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}