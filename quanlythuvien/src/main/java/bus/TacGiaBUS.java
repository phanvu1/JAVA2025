package bus;

import java.sql.Connection;
import java.util.ArrayList;

import dao.TacGiaDAO;
import dto.TacGiaDTO;

public class TacGiaBUS {

    private TacGiaDAO tacGiaDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public TacGiaBUS(Connection connection) {
        this.tacGiaDAO = new TacGiaDAO(connection);
    }

    // Thêm tác giả mới
    public boolean addTacGia(TacGiaDTO tacGia) {
        if (tacGia.getTenTacGia() == null || tacGia.getTenTacGia().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tác giả không được để trống");
        }
        if (tacGia.getNamSinh() <= 0) {
            throw new IllegalArgumentException("Năm sinh không hợp lệ");
        }
        if (tacGia.getQueQuan() == null || tacGia.getQueQuan().trim().isEmpty()) {
            throw new IllegalArgumentException("Quê quán không được để trống");
        }
        return tacGiaDAO.saveTacGia(tacGia);
    }

    // Cập nhật thông tin tác giả
    public boolean updateTacGia(TacGiaDTO tacGia) {
        if (tacGia.getMaTacGia() <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return tacGiaDAO.updateTacGia(tacGia);
    }

    // Xóa tác giả theo mã tác giả
    public boolean deleteTacGia(int maTacGia) {
        if (maTacGia <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return tacGiaDAO.deleteTacGia(maTacGia);
    }

    // Lấy danh sách tất cả tác giả
    public ArrayList<TacGiaDTO> getAllTacGia() {
        return tacGiaDAO.getAllTacGia();
    }

    // Tìm tác giả theo mã tác giả
    public TacGiaDTO timTacGiaTheoMa(int maTacGia) {
        if (maTacGia <= 0) {
            throw new IllegalArgumentException("Mã tác giả không hợp lệ");
        }
        return tacGiaDAO.findTacGiaById(maTacGia);
    }

    // Tìm tác giả theo tên
    public ArrayList<TacGiaDTO> timTacGiaTheoTen(String tenTacGia) {
        if (tenTacGia == null || tenTacGia.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tác giả không được để trống");
        }
        return tacGiaDAO.findTacGiaByName(tenTacGia);
    }

    public static TacGiaBUS iBus = null;

    public static TacGiaBUS gI() {
        if (iBus == null) {
            iBus = new TacGiaBUS(null);
        }
        return iBus;
    }

}