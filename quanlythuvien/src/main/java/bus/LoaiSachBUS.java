package bus;

import dao.LoaiSachDAO;
import dto.LoaiSachDTO;
import java.util.ArrayList;

public class LoaiSachBUS {
    private LoaiSachDAO loaiSachDAO;

    public LoaiSachBUS() {
        this.loaiSachDAO = new LoaiSachDAO();
    }

    // Lấy tất cả loại sách
    public ArrayList<LoaiSachDTO> getAllLoaiSach() {
        return loaiSachDAO.getAll();
    }

    // Thêm loại sách mới
    public boolean addLoaiSach(LoaiSachDTO loaiSach) {
        return loaiSachDAO.insert(loaiSach);
    }

    // Cập nhật loại sách
    public boolean updateLoaiSach(LoaiSachDTO loaiSach) {
        return loaiSachDAO.update(loaiSach);
    }

    // Xóa loại sách
    public boolean deleteLoaiSach(int maloai) {
        return loaiSachDAO.delete(maloai);
    }

    // Tìm kiếm loại sách theo mã
    public LoaiSachDTO getLoaiSachById(int maloai) {
        return loaiSachDAO.getById(maloai);
    }

    public static LoaiSachBUS iBus = null;

    public static LoaiSachBUS gI() {
        if (iBus == null) {
            iBus = new LoaiSachBUS();
        }
        return iBus;
    }
}
