package bus;

import dto.ChiTietPhieuMuonDTO;
import java.util.ArrayList;

public class ChiTietPhieuMuonBUS {
    private ArrayList<ChiTietPhieuMuonDTO> danhSachChiTiet;
    private static ChiTietPhieuMuonBUS instance;

    public ChiTietPhieuMuonBUS() {
        danhSachChiTiet = new ArrayList<>();
    }

    // Singleton Pattern: Lấy instance duy nhất
    public static ChiTietPhieuMuonBUS getInstance() {
        if (instance == null) {
            instance = new ChiTietPhieuMuonBUS();
        }
        return instance;
    }

    public ArrayList<ChiTietPhieuMuonDTO> getAllChiTietPhieuMuon() {
        return danhSachChiTiet;
    }

    public boolean addChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        for (ChiTietPhieuMuonDTO ct : danhSachChiTiet) {
            if (ct.getMaPhieuMuon() == chiTiet.getMaPhieuMuon() && ct.getMaSach() == chiTiet.getMaSach()) {
                return false; // Tránh trùng lặp
            }
        }
        danhSachChiTiet.add(chiTiet);
        return true;
    }

    public boolean updateChiTietPhieuMuon(ChiTietPhieuMuonDTO chiTiet) {
        for (ChiTietPhieuMuonDTO ct : danhSachChiTiet) {
            if (ct.getMaPhieuMuon() == chiTiet.getMaPhieuMuon() && ct.getMaSach() == chiTiet.getMaSach()) {
                ct.setNgayTra(chiTiet.getNgayTra());
                ct.setGhiChu(chiTiet.getGhiChu());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChiTietPhieuMuon(int maPhieuMuon, int maSach) {
        return danhSachChiTiet.removeIf(ct -> ct.getMaPhieuMuon() == maPhieuMuon && ct.getMaSach() == maSach);
    }
    
        // Hàm trả về tổng số lượng sách đang mượn
    public int getSoLuongSachDangMuon() {
        int soLuong = 0;
        for (ChiTietPhieuMuonDTO chiTiet : danhSachChiTiet) {
            if (chiTiet.getNgayTra() == null) { // Nếu ngày trả là null, sách đang được mượn
                soLuong++;
            }
        }
        return soLuong;
    }
}