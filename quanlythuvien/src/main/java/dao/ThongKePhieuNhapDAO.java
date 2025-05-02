package dao;

import dto.ThongKePhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author phanv
 */
public class ThongKePhieuNhapDAO {
    private Connection conn;

    public ThongKePhieuNhapDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<ThongKePhieuNhapDTO> getAll() {
        ArrayList<ThongKePhieuNhapDTO> thongkeList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT chitietphieunhap.*, phieunhap.ngaynhap, sach.tensach " +
                         "FROM chitietphieunhap " +
                         "INNER JOIN phieunhap ON chitietphieunhap.maphieunhap = phieunhap.maphieunhap " +
                         "INNER JOIN sach ON chitietphieunhap.masach = sach.masach";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ThongKePhieuNhapDTO thongke = new ThongKePhieuNhapDTO();
                thongke.setmaphieunhap(rs.getInt("maphieunhap"));
                thongke.setmasach(rs.getInt("masach"));
                thongke.setgianhap(rs.getDouble("gia"));
                thongke.setsoluong(rs.getInt("soluong"));
                thongke.setthanhtien(rs.getDouble("gia") * rs.getInt("soluong")); // Tính toán thanhtien
                thongke.setngaynhap(rs.getDate("ngaynhap"));
                thongke.settensach(rs.getString("tensach"));
                thongkeList.add(thongke);
            }
            System.out.println("getAll trả về " + thongkeList.size() + " bản ghi thống kê phiếu nhập");
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
        return thongkeList;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong ThongKePhieuNhapDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}