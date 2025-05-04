package dao;

import dto.TaiKhoanDTO;
import java.sql.*;
import java.util.ArrayList;

public class TaiKhoanDAO {
    private Connection conn;

    public TaiKhoanDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    // Kiểm tra tài khoản
    public int checkTaiKhoan(String username, String password) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idnhomquyen = 0;

        try {
            String sql = "SELECT idnhomquyen FROM taikhoan WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                idnhomquyen = rs.getInt("idnhomquyen");
                if (rs.wasNull()) {
                    idnhomquyen = 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong checkTaiKhoan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idnhomquyen;
    }

    // Lấy tất cả tài khoản
    public ArrayList<TaiKhoanDTO> getAll() {
        ArrayList<TaiKhoanDTO> taikhoanList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM taikhoan";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TaiKhoanDTO taikhoan = new TaiKhoanDTO();
                taikhoan.setMataikhoan(rs.getInt("mataikhoan"));
                taikhoan.setUsername(rs.getString("username"));
                taikhoan.setPassword(rs.getString("password"));
                taikhoan.setIdnhomquyen(rs.getInt("idnhomquyen"));
                taikhoanList.add(taikhoan);
            }
            System.out.println("getAll trả về " + taikhoanList.size() + " tài khoản");
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
        return taikhoanList;
    }

    // Lấy tài khoản theo mã
    public TaiKhoanDTO getById(int mataikhoan) {
        TaiKhoanDTO taikhoan = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM taikhoan WHERE mataikhoan = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mataikhoan);
            rs = stmt.executeQuery();

            if (rs.next()) {
                taikhoan = new TaiKhoanDTO();
                taikhoan.setMataikhoan(rs.getInt("mataikhoan"));
                taikhoan.setUsername(rs.getString("username"));
                taikhoan.setPassword(rs.getString("password"));
                taikhoan.setIdnhomquyen(rs.getInt("idnhomquyen"));
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
        return taikhoan;
    }

    // Thêm tài khoản mới
    public boolean insert(TaiKhoanDTO taikhoan) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO taikhoan (username, password, idnhomquyen) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, taikhoan.getUsername());
            stmt.setString(2, taikhoan.getPassword());
            stmt.setInt(3, taikhoan.getIdnhomquyen() != null ? taikhoan.getIdnhomquyen() : 0);

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

    // Cập nhật tài khoản
    public boolean update(TaiKhoanDTO taikhoan) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE taikhoan SET username = ?, password = ?, idnhomquyen = ? WHERE mataikhoan = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, taikhoan.getUsername());
            stmt.setString(2, taikhoan.getPassword());
            stmt.setInt(3, taikhoan.getIdnhomquyen() != null ? taikhoan.getIdnhomquyen() : 0);
            stmt.setInt(4, taikhoan.getMataikhoan());

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

    // Xóa tài khoản
    public boolean delete(int mataikhoan) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM taikhoan WHERE mataikhoan = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mataikhoan);

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

    // Đóng kết nối
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong TaiKhoanDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}