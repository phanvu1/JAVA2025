package bus;

import dao.SachDAO;
import dto.SachDTO;
import java.util.ArrayList;

public class SachBUS {
    private SachDAO sachDAO;

    public SachBUS() {
        this.sachDAO = new SachDAO();
    }

    // Lấy tất cả sách
    public ArrayList<SachDTO> getAllSach() {
        return sachDAO.getAllSach();
    }

    // Thêm sách mới
    public boolean addSach(SachDTO sach) {
        return sachDAO.saveSach(sach);
    }

    // Cập nhật sách
    public boolean updateSach(SachDTO sach) {
        return sachDAO.updateSach(sach);
    }

    // Xóa sách
    public boolean deleteSach(int maSach) {
        return sachDAO.deleteSach(maSach);
    }

    // Tìm kiếm sách theo mã
    public SachDTO getSachById(int maSach) {
        return sachDAO.findSachById(maSach);
    }

    // Tìm sách theo tên
    public ArrayList<SachDTO> findSachByName(String tenSach) {
        return sachDAO.findSachByName(tenSach);
    }

    // Lấy tổng số lượng sách
    public int soluongsach() {
        return sachDAO.getsoluongallsach();
    }

    public static SachBUS iBus = null;

    public static SachBUS gI() {
        if (iBus == null) {
            iBus = new SachBUS();
        }
        return iBus;
    }
}