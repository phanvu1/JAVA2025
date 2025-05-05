package dao;

import dto.PhieuMuonDTO;

import java.sql.*;
import java.util.ArrayList;

public class PhieuMuonDAO {
    private Connection connection;

    public PhieuMuonDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<PhieuMuonDTO> findAll() {
        ArrayList<PhieuMuonDTO> list = new ArrayList<>();
        String query = "SELECT * FROM phieumuon";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PhieuMuonDTO phieuMuon = new PhieuMuonDTO(
                        rs.getInt("maphieumuon"),
                        rs.getInt("manv"),
                        rs.getInt("madocgia"),
                        rs.getDate("ngaymuon"),
                        rs.getString("tinhtrang")
                );
                list.add(phieuMuon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public PhieuMuonDTO findById(int maPhieuMuon) {
        String query = "SELECT * FROM phieumuon WHERE maphieumuon = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maPhieuMuon);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PhieuMuonDTO(
                            rs.getInt("maphieumuon"),
                            rs.getInt("manv"),
                            rs.getInt("madocgia"),
                            rs.getDate("ngaymuon"),
                            rs.getString("tinhtrang")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(PhieuMuonDTO phieuMuon) {
        String query = "INSERT INTO phieumuon (manv, madocgia, ngaymuon, tinhtrang) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, phieuMuon.getMaNV());
            ps.setInt(2, phieuMuon.getMaDocGia());
            ps.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            ps.setString(4, phieuMuon.getTinhTrang());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(PhieuMuonDTO phieuMuon) {
        String query = "UPDATE phieumuon SET manv = ?, madocgia = ?, ngaymuon = ?, tinhtrang = ? WHERE maphieumuon = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, phieuMuon.getMaNV());
            ps.setInt(2, phieuMuon.getMaDocGia());
            ps.setDate(3, new java.sql.Date(phieuMuon.getNgayMuon().getTime()));
            ps.setString(4, phieuMuon.getTinhTrang());
            ps.setInt(5, phieuMuon.getMaPhieuMuon());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int maPhieuMuon) {
        String query = "DELETE FROM phieumuon WHERE maphieumuon = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maPhieuMuon);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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