package dao;

import dto.NhaCungCapDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class NhaCungCapDAO {
    private Connection conn;

    public NhaCungCapDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<NhaCungCapDTO> getAll() {
        ArrayList<NhaCungCapDTO> nhaCungCapList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM nhacungcap";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                NhaCungCapDTO nhaCungCap = new NhaCungCapDTO();
                nhaCungCap.setMancc(rs.getInt("mancc"));
                nhaCungCap.setTenncc(rs.getString("tenncc"));
                nhaCungCapList.add(nhaCungCap);
            }
            System.out.println("getAll trả về " + nhaCungCapList.size() + " nhà cung cấp");
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
        return nhaCungCapList;
    }

    public NhaCungCapDTO getById(int mancc) {
        NhaCungCapDTO nhaCungCap = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM nhacungcap WHERE mancc = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mancc);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nhaCungCap = new NhaCungCapDTO();
                nhaCungCap.setMancc(rs.getInt("mancc"));
                nhaCungCap.setTenncc(rs.getString("tenncc"));
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
        return nhaCungCap;
    }

    public boolean insert(NhaCungCapDTO nhaCungCap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO nhacungcap (tenncc) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nhaCungCap.getTenncc());

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

    public boolean update(NhaCungCapDTO nhaCungCap) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE nhacungcap SET tenncc = ? WHERE mancc = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nhaCungCap.getTenncc());
            stmt.setInt(2, nhaCungCap.getMancc());

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

    public boolean delete(int mancc) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM nhacungcap WHERE mancc = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mancc);

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
                System.out.println("Đóng kết nối trong NhaCungCapDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
