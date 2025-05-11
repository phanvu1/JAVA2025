package bus;

import dao.PhatDAO;
import dto.PhatDTO;
import java.util.ArrayList;

public class PhatBUS {
    private PhatDAO phatDAO;

    public PhatBUS() {
        this.phatDAO = new PhatDAO();
    }

    // Lấy tất cả bản ghi phạt
    public ArrayList<PhatDTO> getAllPhat() {
        return phatDAO.getAll();
    }

    // Thêm bản ghi phạt mới
    public boolean addPhat(PhatDTO phat) {
        return phatDAO.insert(phat);
    }

    // Cập nhật bản ghi phạt
    public boolean updatePhat(PhatDTO phat) {
        return phatDAO.update(phat);
    }

    // Xóa bản ghi phạt
    public boolean deletePhat(int idphieumuon) {
        return phatDAO.delete(idphieumuon);
    }

    // Tìm kiếm bản ghi phạt theo mã
    public PhatDTO getPhatById(int idphieumuon) {
        return phatDAO.getById(idphieumuon);
    }

    public static PhatBUS iBus = null;

    public static PhatBUS gI() {
        if (iBus == null) {
            iBus = new PhatBUS();
        }
        return iBus;
    }
}