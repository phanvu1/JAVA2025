package bus;

import dao.NhaCungCapDAO;
import dto.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapBUS() {
        this.nhaCungCapDAO = new NhaCungCapDAO();
    }

    // Lấy tất cả nhà cung cấp
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap() {
        return nhaCungCapDAO.getAll();
    }

    // Thêm nhà cung cấp mới
    public boolean addNhaCungCap(NhaCungCapDTO nhaCungCap) {
        return nhaCungCapDAO.insert(nhaCungCap);
    }

    // Cập nhật nhà cung cấp
    public boolean updateNhaCungCap(NhaCungCapDTO nhaCungCap) {
        return nhaCungCapDAO.update(nhaCungCap);
    }

    // Xóa nhà cung cấp
    public boolean deleteNhaCungCap(int mancc) {
        return nhaCungCapDAO.delete(mancc);
    }

    // Tìm kiếm nhà cung cấp theo mã
    public NhaCungCapDTO getNhaCungCapById(int mancc) {
        return nhaCungCapDAO.getById(mancc);
    }

    public static NhaCungCapBUS iBus = null;

    public static NhaCungCapBUS gI() {
        if (iBus == null) {
            iBus = new NhaCungCapBUS();
        }
        return iBus;
    }
}