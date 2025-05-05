package dao;

import dto.DanhMucChucNangDTO;
import java.sql.*;
import java.util.ArrayList;

public class DanhMucChucNangDAO {
    private Connection conn;

    public DanhMucChucNangDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối CSDL.");
        }
    }

    public ArrayList<DanhMucChucNangDTO> getAll() {
        ArrayList<DanhMucChucNangDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM danhmucchucnang";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DanhMucChucNangDTO dm = new DanhMucChucNangDTO();
                dm.setIddanhmucchucnang(rs.getInt("iddanhmucchucnang"));
                dm.setTenchucnang(rs.getString("tenchucnang"));
                dm.setTrangthai(rs.getInt("trangthai"));
                list.add(dm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(DanhMucChucNangDTO dm) {
        String sql = "INSERT INTO danhmucchucnang (tenchucnang, trangthai) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dm.getTenchucnang());
            stmt.setInt(2, dm.getTrangthai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DanhMucChucNangDTO dm) {
        String sql = "UPDATE danhmucchucnang SET tenchucnang = ?, trangthai = ? WHERE iddanhmucchucnang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dm.getTenchucnang());
            stmt.setInt(2, dm.getTrangthai());
            stmt.setInt(3, dm.getIddanhmucchucnang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM danhmucchucnang WHERE iddanhmucchucnang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
