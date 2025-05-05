package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DocGiaDTO;

public class DocGiaDAO {
    private Connection conn;

    public DocGiaDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public boolean addDocGia(DocGiaDTO docGia) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO docgia (tendg, gioitinh, diachi, mathe) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, docGia.getTenDocGia());
            stmt.setString(2, docGia.getGioiTinh());
            stmt.setString(3, docGia.getDiaChi());
            stmt.setInt(4, docGia.getMaThe());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    docGia.setMaDocGia(generatedKeys.getInt(1));
                }
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateDocGia(DocGiaDTO docGia) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE docgia SET tendg = ?, gioitinh = ?, diachi = ?, mathe = ? WHERE madocgia = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, docGia.getTenDocGia());
            stmt.setString(2, docGia.getGioiTinh());
            stmt.setString(3, docGia.getDiaChi());
            stmt.setInt(4, docGia.getMaThe());
            stmt.setInt(5, docGia.getMaDocGia());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteDocGia(int maDocGia) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM docgia WHERE madocgia = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maDocGia);

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<DocGiaDTO> getAllDocGia() {
        ArrayList<DocGiaDTO> docGiaList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM docgia";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DocGiaDTO docGia = new DocGiaDTO(
                        rs.getInt("madocgia"),
                        rs.getString("tendg"),
                        rs.getString("gioitinh"),
                        rs.getString("diachi"),
                        rs.getInt("mathe"));
                docGiaList.add(docGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return docGiaList;
    }

    public DocGiaDTO findDocGiaById(int maDocGia) {
        DocGiaDTO docGia = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM docgia WHERE madocgia = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maDocGia);
            rs = stmt.executeQuery();

            if (rs.next()) {
                docGia = new DocGiaDTO(
                        rs.getInt("madocgia"),
                        rs.getString("tendg"),
                        rs.getString("gioitinh"),
                        rs.getString("diachi"),
                        rs.getInt("mathe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return docGia;
    }

    public ArrayList<DocGiaDTO> findDocGiaByName(String tenDocGia) {
        ArrayList<DocGiaDTO> docGiaList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM docgia WHERE tendg LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenDocGia + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                DocGiaDTO docGia = new DocGiaDTO(
                        rs.getInt("madocgia"),
                        rs.getString("tendg"),
                        rs.getString("gioitinh"),
                        rs.getString("diachi"),
                        rs.getInt("mathe"));
                docGiaList.add(docGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return docGiaList;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong DocGiaDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}