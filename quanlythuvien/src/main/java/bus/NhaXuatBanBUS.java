package bus;

import dto.NhaXuatBanDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.*;

public class NhaXuatBanBUS {
    private static NhaXuatBanBUS instance; // Singleton instance
    private NhaXuatBanDAO nhaxuatbanDAO;

    // Constructor
    private NhaXuatBanBUS() {
        Connection conn = DBConnect.getConnection(); // Kết nối cơ sở dữ liệu
        this.nhaxuatbanDAO = new NhaXuatBanDAO(conn);
    }

    // Singleton Pattern: Lấy instance duy nhất
    public static NhaXuatBanBUS getInstance() {
        if (instance == null) {
            instance = new NhaXuatBanBUS();
        }
        return instance;
    }

    // Lấy tất cả nhà xuất bản
    public ArrayList<NhaXuatBanDTO> getAllNhaXuatBan() {
        try {
            return nhaxuatbanDAO.getAllNhaXuatBan();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Thêm nhà xuất bản
    public boolean addNhaXuatBan(NhaXuatBanDTO nxb) {
        try {
            return nhaxuatbanDAO.addNhaXuatBan(nxb);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật nhà xuất bản
    public boolean updateNhaXuatBan(NhaXuatBanDTO nxb) {
        try {
            return nhaxuatbanDAO.updateNhaXuatBan(nxb);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa nhà xuất bản
    public boolean deleteNhaXuatBan(int manxb) {
        try {
            return nhaxuatbanDAO.deleteNhaXuatBan(manxb);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm nhà xuất bản theo mã
    public NhaXuatBanDTO findById(int manxb) {
        try {
            return nhaxuatbanDAO.findById(manxb);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}