package dao;

import dto.ChiTietNhomQuyenDTO;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietNhomQuyenDAO {
    private Connection conn;

    public ChiTietNhomQuyenDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<ChiTietNhomQuyenDTO> getAll() {
        ArrayList<ChiTietNhomQuyenDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM chitietnhomquyen";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChiTietNhomQuyenDTO ct = new ChiTietNhomQuyenDTO();
                ct.setIdnhomquyen(rs.getInt("idnhomquyen"));
                ct.setIddanhmucchucnang(rs.getInt("iddanhmucchucnang"));
                ct.setHanhdong(rs.getString("hanhdong"));
                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(ChiTietNhomQuyenDTO ct) {
        String sql = "INSERT INTO chitietnhomquyen (idnhomquyen, iddanhmucchucnang, hanhdong) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ct.getIdnhomquyen());
            stmt.setInt(2, ct.getIddanhmucchucnang());
            stmt.setString(3, ct.getHanhdong());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int idnhomquyen, int iddanhmucchucnang) {
        String sql = "DELETE FROM chitietnhomquyen WHERE idnhomquyen = ? AND iddanhmucchucnang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idnhomquyen);
            stmt.setInt(2, iddanhmucchucnang);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChiTietNhomQuyenDTO> getByIdNhomQuyen(int idnhomquyen) {
        ArrayList<ChiTietNhomQuyenDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM chitietnhomquyen WHERE idnhomquyen = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idnhomquyen);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ChiTietNhomQuyenDTO ct = new ChiTietNhomQuyenDTO();
                    ct.setIdnhomquyen(rs.getInt("idnhomquyen"));
                    ct.setIddanhmucchucnang(rs.getInt("iddanhmucchucnang"));
                    ct.setHanhdong(rs.getString("hanhdong"));
                    list.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean kiemTraQuyen(int idNhomQuyen, int idDanhMucChucNang) {
        String sql = "SELECT COUNT(*) FROM chitietnhomquyen WHERE idnhomquyen = ? AND iddanhmucchucnang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idNhomQuyen);
            stmt.setInt(2, idDanhMucChucNang);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi kiểm tra quyền: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }  
}
