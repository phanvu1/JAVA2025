package dao;

import dto.NhomQuyenDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhomQuyenDAO {
    private Connection conn;

    public NhomQuyenDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<NhomQuyenDTO> getAll() {
        ArrayList<NhomQuyenDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM nhomquyen";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NhomQuyenDTO nq = new NhomQuyenDTO();
                nq.setIdnhomquyen(rs.getInt("idnhomquyen"));
                nq.setTennhomquyen(rs.getString("tennhomquyen"));
                nq.setMota(rs.getString("mota"));
                list.add(nq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(NhomQuyenDTO nq) {
        String sql = "INSERT INTO nhomquyen (tennhomquyen, mota) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nq.getTennhomquyen());
            stmt.setString(2, nq.getMota());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhomQuyenDTO nq) {
        String sql = "UPDATE nhomquyen SET tennhomquyen = ?, mota = ? WHERE idnhomquyen = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nq.getTennhomquyen());
            stmt.setString(2, nq.getMota());
            stmt.setInt(3, nq.getIdnhomquyen());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM nhomquyen WHERE idnhomquyen = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhomQuyenDTO getById(int id) {
        String sql = "SELECT * FROM nhomquyen WHERE idnhomquyen = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NhomQuyenDTO(
                        rs.getInt("idnhomquyen"),
                        rs.getString("tennhomquyen"),
                        rs.getString("mota")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
