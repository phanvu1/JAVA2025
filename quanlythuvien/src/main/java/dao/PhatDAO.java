package dao;

import dto.PhatDTO;
import java.sql.*;
import java.util.ArrayList;

public class PhatDAO {
    private Connection conn;

    public PhatDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<PhatDTO> getAll() {
        ArrayList<PhatDTO> phatList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phat";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PhatDTO phat = new PhatDTO();
                phat.setIdphieumuon(rs.getInt("idphieumuon"));
                phat.setSotienphat(rs.getDouble("sotienphat"));
                phat.setLydo(rs.getString("lydo"));
                phatList.add(phat);
            }
            System.out.println("getAll trả về " + phatList.size() + " bản ghi phạt");
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
        return phatList;
    }

    public PhatDTO getById(int idphieumuon) {
        PhatDTO phat = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phat WHERE idphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idphieumuon);
            rs = stmt.executeQuery();

            if (rs.next()) {
                phat = new PhatDTO();
                phat.setIdphieumuon(rs.getInt("idphieumuon"));
                phat.setSotienphat(rs.getDouble("sotienphat"));
                phat.setLydo(rs.getString("lydo"));
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
        return phat;
    }

    public boolean insert(PhatDTO phat) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO phat (idphieumuon, sotienphat, lydo) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phat.getIdphieumuon());
            stmt.setDouble(2, phat.getSotienphat());
            if (phat.getLydo() != null) {
                stmt.setString(3, phat.getLydo());
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }

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

    public boolean update(PhatDTO phat) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE phat SET sotienphat = ?, lydo = ? WHERE idphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, phat.getSotienphat());
            if (phat.getLydo() != null) {
                stmt.setString(2, phat.getLydo());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }
            stmt.setInt(3, phat.getIdphieumuon());

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

    public boolean delete(int idphieumuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM phat WHERE idphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idphieumuon);

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
                System.out.println("Đóng kết nối trong PhatDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}