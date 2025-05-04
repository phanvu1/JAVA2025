package dao;

import dto.ThongKePhieuMuonDTO;
import java.sql.*;
import java.util.ArrayList;

public class ThongKePhieuMuonDAO {
    private Connection conn;
    
    public ThongKePhieuMuonDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }
    
    public ArrayList<ThongKePhieuMuonDTO> getAllThongKePhieuMuon() {
    ArrayList<ThongKePhieuMuonDTO> list = new ArrayList<>();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT ct.maphieumuon AS maPM, ct.masach AS maSach, " +
                    "pm.ngaymuon AS ngayMuon, ct.ngaytra AS ngayTra, " +
                    "ct.ghichu AS ghiChu " +
                    "FROM chitietphieumuon ct " +
                    "JOIN phieumuon pm ON ct.maphieumuon = pm.maphieumuon";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            ThongKePhieuMuonDTO thongKe = new ThongKePhieuMuonDTO();
            thongKe.setMaPM(rs.getInt("maPM"));
            thongKe.setMaSach(rs.getInt("maSach"));
            thongKe.setNgayMuon(rs.getDate("ngayMuon"));
            thongKe.setNgayTra(rs.getDate("ngayTra"));
            thongKe.setGhiChu(rs.getString("ghiChu"));
            list.add(thongKe);
        }
    } catch (SQLException e) {
        System.err.println("Lỗi SQL trong getAllThongKePhieuMuon: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}
    
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}