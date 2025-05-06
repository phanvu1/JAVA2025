package dao;

import dto.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhanVienDAO {
    private Connection connection;

    public NhanVienDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<NhanVienDTO> getAllNhanVien() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        String query = "SELECT * FROM nhanvien";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhanVienDTO nhanVien = new NhanVienDTO(
                    rs.getInt("manv"),
                    rs.getString("tennv"),
                    rs.getInt("namsinh"),
                    rs.getString("gioitinh"),
                    rs.getString("sdt"),
                    rs.getDate("ngaybatdau"),
                    rs.getDouble("luong"),
                    rs.getString("diachi"),
                    rs.getInt("mataikhoan")
                );
                list.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

public boolean addNhanVien(NhanVienDTO nhanVien) {
    String sql = "INSERT INTO nhanvien (tennv, namsinh, gioitinh, diachi, sdt, ngaybatdau, luong, mataikhoan) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, nhanVien.getTenNhanVien());
        ps.setInt(2, nhanVien.getNamSinh());
        ps.setString(3, nhanVien.getGioiTinh());
        ps.setString(4, nhanVien.getDiaChi());
        ps.setString(5, nhanVien.getSoDienThoai());
        ps.setDate(6, nhanVien.getNgayBatDau() != null ? new java.sql.Date(nhanVien.getNgayBatDau().getTime()) : null);
        ps.setDouble(7, nhanVien.getLuong());
        ps.setInt(8, nhanVien.getMaTaiKhoan());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean updateNhanVien(NhanVienDTO nhanVien) {
        String query = "UPDATE nhanvien SET tennv = ?, namsinh = ?, gioitinh = ?, sdt = ?, ngaybatdau = ?, luong = ?, diachi = ?, mataikhoan = ? WHERE manv = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nhanVien.getTenNhanVien());
            ps.setInt(2, nhanVien.getNamSinh());
            ps.setString(3, nhanVien.getGioiTinh());
            ps.setString(4, nhanVien.getSoDienThoai());
            if(nhanVien.getNgayBatDau() != null){
                 ps.setDate(5, new java.sql.Date(nhanVien.getNgayBatDau().getTime()));
            } else {
                 ps.setNull(5, java.sql.Types.DATE);
              }
            ps.setDouble(6, nhanVien.getLuong());
            ps.setString(7, nhanVien.getDiaChi());
            ps.setInt(8, nhanVien.getMaTaiKhoan());
            ps.setInt(9, nhanVien.getMaNhanVien());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNhanVien(int maNhanVien) {
        String query = "DELETE FROM nhanvien WHERE manv = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maNhanVien);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public NhanVienDTO findById(int maNhanVien) {
        String query = "SELECT * FROM nhanvien WHERE manv = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maNhanVien);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new NhanVienDTO(
                        rs.getInt("manv"),
                        rs.getString("tennv"),
                        rs.getInt("namsinh"),
                        rs.getString("gioitinh"),
                        rs.getString("sdt"),
                        rs.getDate("ngaybatdau"),
                        rs.getDouble("luong"),
                        rs.getString("diachi"),
                        rs.getInt("mataikhoan")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối cơ sở dữ liệu thành công.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}