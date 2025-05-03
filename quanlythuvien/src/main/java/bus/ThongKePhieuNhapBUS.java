package bus;

import dao.ThongKePhieuNhapDAO;
import dto.ThongKePhieuNhapDTO;
import java.util.ArrayList;

public class ThongKePhieuNhapBUS {
    private ThongKePhieuNhapDAO thongkedao;

    public ThongKePhieuNhapBUS() {
        this.thongkedao = new ThongKePhieuNhapDAO();
    }

    // Lấy tất cả thống kê phiếu nhập
    public ArrayList<ThongKePhieuNhapDTO> getAllThongKe() {
        return thongkedao.getAll();
    }

    public static ThongKePhieuNhapBUS iBus = null;

    public static ThongKePhieuNhapBUS gI() {
        if (iBus == null) {
            iBus = new ThongKePhieuNhapBUS();
        }
        return iBus;
    }
}