package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.SachDTO;

/**
 *
 * @author [Your Name]
 */
public class SachDAO {
    private Connection conn;

    // Constructor: Kết nối đến cơ sở dữ liệu
    public SachDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Thêm sách mới
    public boolean insert(SachDTO sach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO sach (tensach, maloai, manxb, namxb, soluong, makesach, hinhanh) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, sach.getTenSach());
            stmt.setInt(2, sach.getMaLoai());
            stmt.setInt(3, sach.getMaNXB());
            stmt.setInt(4, sach.getMaTacGia());
            stmt.setInt(5, sach.getNamXB());
            stmt.setInt(6, sach.getSoLuong());
            stmt.setInt(7, sach.getMaKeSach());
            stmt.setString(8, sach.getHinhAnh());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    sach.setMaSach(generatedKeys.getInt(1)); // Lấy ID tự động tạo
                }
                System.out.println("Thêm sách thành công: " + sach.getMaSach());
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong insert: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Cập nhật thông tin sách
    public boolean update(SachDTO sach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE sach SET tensach = ?, maloai = ?, manxb = ?, namxb = ?, soluong = ?, makesach = ?, hinhanh = ? WHERE masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sach.getMaSach());
            stmt.setString(2, sach.getTenSach());
            stmt.setInt(3, sach.getMaLoai());
            stmt.setInt(4, sach.getMaNXB());
            stmt.setInt(5, sach.getMaTacGia());
            stmt.setInt(6, sach.getNamXB());
            stmt.setInt(7, sach.getSoLuong());
            stmt.setInt(8, sach.getMaKeSach());
            stmt.setString(9, sach.getHinhAnh());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Cập nhật sách thành công: " + sach.getMaSach());
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong update: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Xóa sách theo mã sách
    public boolean delete(int maSach) {
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
            System.err.println("Lỗi SQL trong delete: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // Lấy danh sách tất cả sách
    public ArrayList<SachDTO> getAll() {
        ArrayList<SachDTO> sachList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SachDTO sach = new SachDTO();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setMaLoai(rs.getInt("maloai"));
                sach.setMaNXB(rs.getInt("manxb"));
                sach.setMaTacGia(rs.getInt("matg"));
                sach.setNamXB(rs.getInt("namxb"));
                sach.setSoLuong(rs.getInt("soluong"));
                sach.setMaKeSach(rs.getInt("makesach"));
                sach.setHinhAnh(rs.getString("hinhanh"));
                sachList.add(sach);
            }
            System.out.println("getAll trả về " + sachList.size() + " sách");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getAll: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng để tránh null
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sachList;
    }

    // Tìm sách theo mã sách
    public SachDTO getById(int maSach) {
        SachDTO sach = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sach WHERE masach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maSach);
            rs = stmt.executeQuery();

            if (rs.next()) {
                sach = new SachDTO();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setMaLoai(rs.getInt("maloai"));
                sach.setMaNXB(rs.getInt("manxb"));
                sach.setMaTacGia(rs.getInt("matg"));
                sach.setNamXB(rs.getInt("namxb"));
                sach.setSoLuong(rs.getInt("soluong"));
                sach.setMaKeSach(rs.getInt("makesach"));
                sach.setHinhAnh(rs.getString("hinhanh"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getById: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sach;
    }

    // Tìm sách theo tên sách
    public ArrayList<SachDTO> findSachByName(String tenSach) {
        ArrayList<SachDTO> sachList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sach WHERE tensach LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenSach + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                SachDTO sach = new SachDTO();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setMaLoai(rs.getInt("maloai"));
                sach.setMaNXB(rs.getInt("manxb"));
                sach.setMaTacGia(rs.getInt("matg"));
                sach.setNamXB(rs.getInt("namxb"));
                sach.setSoLuong(rs.getInt("soluong"));
                sach.setMaKeSach(rs.getInt("makesach"));
                sach.setHinhAnh(rs.getString("hinhanh"));
                sachList.add(sach);
            }
            System.out.println("findSachByName trả về " + sachList.size() + " sách");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong findSachByName: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng để tránh null
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sachList;
    }

    public int soluongsach() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;

        try {
            String sql = "SELECT SUM(soluong) AS total FROM sach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");
            }
            System.out.println("Tổng số lượng sách: " + total);
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong soluongsach: " + e.getMessage());
            e.printStackTrace();
            return 0; // Trả về 0 nếu có lỗi
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total;
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