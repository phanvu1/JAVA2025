package bus;

import dao.ThongKePhieuMuonDAO;
import dto.ThongKePhieuMuonDTO;
import java.util.ArrayList;

public class ThongKePhieuMuonBUS {
    private ThongKePhieuMuonDAO thongKeDAO;

    public ThongKePhieuMuonBUS() {
        this.thongKeDAO = new ThongKePhieuMuonDAO();
    }

    // Lấy tất cả thống kê phiếu mượn
    public ArrayList<ThongKePhieuMuonDTO> getAllThongKe() {
        return thongKeDAO.getAllThongKePhieuMuon();
    }

    // Singleton pattern
    private static ThongKePhieuMuonBUS instance;

    public static ThongKePhieuMuonBUS getInstance() {
        if (instance == null) {
            instance = new ThongKePhieuMuonBUS();
        }
        return instance;
    }

    // Đóng kết nối
    public void close() {
        thongKeDAO.close();
    }
}