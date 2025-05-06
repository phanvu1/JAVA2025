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
    String query = "INSERT INTO nhanvien (tennv, namsinh, gioitinh, sdt, ngaybatdau, luong, diachi, mataikhoan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setString(1, nhanVien.getTenNhanVien());
        ps.setInt(2, nhanVien.getNamSinh());
        ps.setString(3, nhanVien.getGioiTinh());
        ps.setString(4, nhanVien.getSoDienThoai());
        ps.setObject(5, null); // Nếu không có giá trị cho ngaybatdau
        ps.setDouble(6, nhanVien.getLuong());
        ps.setString(7, nhanVien.getDiaChi());
        ps.setObject(8, null); // Nếu không có giá trị cho mataikhoan

        System.out.println("Query: " + ps.toString()); // In câu lệnh SQL
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Lỗi SQL: " + e.getMessage());
        e.printStackTrace();
    }
    return false;
}

    public boolean updateNhanVien(NhanVienDTO nhanVien) {
        String query = "UPDATE nhanvien SET tennv = ?, namsinh = ?, gioitinh = ?, sdt = ?, ngaybatdau = ?, luong = ?, diachi = ?, mataikhoan = ? WHERE manv = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nhanVien.getTenNhanVien());
            ps.setInt(2, nhanVien.getNamSinh());
            ps.setString(3, nhanVien.getGioiTinh());
            ps.setString(4, nhanVien.getSoDienThoai());
            ps.setString(5, nhanVien.getNgayBatDau().toString());
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