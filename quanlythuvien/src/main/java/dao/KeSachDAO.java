package dao;

import dto.KeSachDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class KeSachDAO {
    private Connection conn;

    public KeSachDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<KeSachDTO> getAll() {
        ArrayList<KeSachDTO> keSachList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM makesach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                KeSachDTO keSach = new KeSachDTO();
                keSach.setMakesach(rs.getInt("makesach"));
                keSach.setVitri(rs.getString("vitri"));
                keSachList.add(keSach);
            }
            System.out.println("getAll trả về " + keSachList.size() + " kệ sách");
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
        return keSachList;
    }

    public KeSachDTO getById(int makesach) {
        KeSachDTO keSach = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM makesach WHERE makesach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, makesach);
            rs = stmt.executeQuery();

            if (rs.next()) {
                keSach = new KeSachDTO();
                keSach.setMakesach(rs.getInt("makesach"));
                keSach.setVitri(rs.getString("vitri"));
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
        return keSach;
    }

    public boolean insert(KeSachDTO keSach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO makesach (vitri) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, keSach.getVitri());

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

    public boolean update(KeSachDTO keSach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE makesach SET vitri = ? WHERE makesach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, keSach.getVitri());
            stmt.setInt(2, keSach.getMakesach());

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

    public boolean delete(int makesach) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM makesach WHERE makesach = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, makesach);

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
                System.out.println("Đóng kết nối trong KeSachDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
