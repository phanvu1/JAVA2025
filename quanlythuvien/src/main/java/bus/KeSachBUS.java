package bus;

import dao.KeSachDAO;
import dto.KeSachDTO;
import java.util.ArrayList;

public class KeSachBUS {
    private KeSachDAO keSachDAO;

    public KeSachBUS() {
        this.keSachDAO = new KeSachDAO();
    }

    // Lấy tất cả kệ sách
    public ArrayList<KeSachDTO> getAllKeSach() {
        return keSachDAO.getAll();
    }

    // Thêm kệ sách mới
    public boolean addKeSach(String keSach) {
        return keSachDAO.insert(keSach);
    }

    // Cập nhật kệ sách
    public boolean updateKeSach(KeSachDTO keSach) {
        return keSachDAO.update(keSach);
    }

    // Xóa kệ sách
    public boolean deleteKeSach(int makesach) {
        return keSachDAO.delete(makesach);
    }

    // Tìm kiếm kệ sách theo mã
    public KeSachDTO getKeSachById(int makesach) {
        return keSachDAO.getById(makesach);
    }

    public static KeSachBUS iBus = null;

    public static KeSachBUS gI() {
        if (iBus == null) {
            iBus = new KeSachBUS();
        }
        return iBus;
    }
}
