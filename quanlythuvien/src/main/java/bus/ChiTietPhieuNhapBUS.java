package bus;

import dao.ChiTietPhieuNhapDAO;
import dto.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

public class ChiTietPhieuNhapBUS {
    private ChiTietPhieuNhapDAO chitietphieunhapdao;

    public ChiTietPhieuNhapBUS() {
        this.chitietphieunhapdao = new ChiTietPhieuNhapDAO();
    }

    // Lấy tất cả chi tiết phiếu nhập
    public ArrayList<ChiTietPhieuNhapDTO> getAllChiTietPhieuNhap() {
        return chitietphieunhapdao.getAll();
    }

    // Thêm chi tiết phiếu nhập mới
    public boolean addChiTietPhieuNhap(ChiTietPhieuNhapDTO chitietphieunhap) {
        return chitietphieunhapdao.insert(chitietphieunhap);
    }

    // Cập nhật chi tiết phiếu nhập
    public boolean updateChiTietPhieuNhap(ChiTietPhieuNhapDTO chitietphieunhap) {
        return chitietphieunhapdao.update(chitietphieunhap);
    }

    // Xóa chi tiết phiếu nhập
    public boolean deleteChiTietPhieuNhap(int maphieunhap, int masach) {
        return chitietphieunhapdao.delete(maphieunhap, masach);
    }

    // Tìm kiếm chi tiết phiếu nhập theo mã
    public ChiTietPhieuNhapDTO getChiTietPhieuNhapById(int maphieunhap, int masach) {
        return chitietphieunhapdao.getById(maphieunhap, masach);
    }
    
    public boolean deleteByMaPN(int maphieunhap) {
        return chitietphieunhapdao.deleteByMaPN(maphieunhap);
    }

    public static ChiTietPhieuNhapBUS iBus = null;

    public static ChiTietPhieuNhapBUS gI() {
        if (iBus == null) {
            iBus = new ChiTietPhieuNhapBUS();
        }
        return iBus;
    }
}