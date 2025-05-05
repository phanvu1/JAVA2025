package dao;

import dto.NhaXuatBanDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhaXuatBanDAO {
    private Connection conn;

    public NhaXuatBanDAO(Connection conn) {
        this.conn = conn;
    }

    // Lấy tất cả nhà xuất bản
    public ArrayList<NhaXuatBanDTO> getAllNhaXuatBan() throws SQLException {
        ArrayList<NhaXuatBanDTO> list = new ArrayList<>();
        String query = "SELECT * FROM nhaxuatban";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            NhaXuatBanDTO nxb = new NhaXuatBanDTO(
                rs.getInt("manxb"),
                rs.getString("tennxb"),
                rs.getString("diachi"),
                rs.getString("sdt")
            );
            list.add(nxb);
        }
        return list;
    }

    // Thêm nhà xuất bản
    public boolean addNhaXuatBan(NhaXuatBanDTO nxb) throws SQLException {
        String query = "INSERT INTO nhaxuatban (manxb, tennxb, diachi, sdt) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, nxb.getManxb());
        pstmt.setString(2, nxb.getTennxb());
        pstmt.setString(3, nxb.getDiachi());
        pstmt.setString(4, nxb.getSdt());
        return pstmt.executeUpdate() > 0;
    }

    // Cập nhật nhà xuất bản
    public boolean updateNhaXuatBan(NhaXuatBanDTO nxb) throws SQLException {
        String query = "UPDATE nhaxuatban SET tennxb = ?, diachi = ?, sdt = ? WHERE manxb = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, nxb.getTennxb());
        pstmt.setString(2, nxb.getDiachi());
        pstmt.setString(3, nxb.getSdt());
        pstmt.setInt(4, nxb.getManxb());
        return pstmt.executeUpdate() > 0;
    }

    // Xóa nhà xuất bản
    public boolean deleteNhaXuatBan(int manxb) throws SQLException {
        String query = "DELETE FROM nhaxuatban WHERE manxb = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, manxb);
        return pstmt.executeUpdate() > 0;
    }

    // Tìm nhà xuất bản theo mã
    public NhaXuatBanDTO findById(int manxb) throws SQLException {
        String query = "SELECT * FROM nhaxuatban WHERE manxb = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, manxb);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            return new NhaXuatBanDTO(
                rs.getInt("manxb"),
                rs.getString("tennxb"),
                rs.getString("diachi"),
                rs.getString("sdt")
            );
        }
        return null; // Không tìm thấy
    }
    
        public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong NhaXuatBanDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}