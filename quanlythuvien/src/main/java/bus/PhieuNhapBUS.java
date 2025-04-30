package bus;

import dao.PhieuNhapDAO;
import dto.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    private PhieuNhapDAO phieunhapdao;

    public PhieuNhapBUS() {
        this.phieunhapdao = new PhieuNhapDAO();
    }

    // Lấy tất cả phiếu nhập
    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        return phieunhapdao.getAll();
    }

    // Thêm phiếu nhập mới
    public boolean addPhieuNhap(PhieuNhapDTO phieunhap) {
        return phieunhapdao.insert(phieunhap);
    }

    // Cập nhật phiếu nhập
    public boolean updatePhieuNhap(PhieuNhapDTO phieunhap) {
        return phieunhapdao.update(phieunhap);
    }
    
    public boolean updateTongTienByMaPN(int maphieunhap) {
        return phieunhapdao.updateTongTienByMaPN(maphieunhap);
    }

    // Xóa phiếu nhập
    public boolean deletePhieuNhap(int maphieunhap) {
        return phieunhapdao.delete(maphieunhap);
    }

    // Tìm kiếm phiếu nhập theo mã
    public PhieuNhapDTO getPhieuNhapById(int maphieunhap) {
        return phieunhapdao.getById(maphieunhap);
    }

    public static PhieuNhapBUS iBus = null;

    public static PhieuNhapBUS gI() {
        if (iBus == null) {
            iBus = new PhieuNhapBUS();
        }
        return iBus;
    }
}
