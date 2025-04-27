package bus;

import java.sql.Connection;
import java.util.List;

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
        if (validateTacGia(tacGia)) {
            return tacGiaDAO.saveTacGia(tacGia);
        }
        System.err.println("Dữ liệu tác giả không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin tác giả
    public boolean updateTacGia(TacGiaDTO tacGia) {
        if (validateTacGia(tacGia) && tacGia.getMaTacGia() > 0) {
            return tacGiaDAO.updateTacGia(tacGia);
        }
        System.err.println("Dữ liệu tác giả không hợp lệ hoặc mã tác giả không tồn tại!");
        return false;
    }

    // Xóa tác giả theo mã tác giả
    public boolean deleteTacGia(int maTacGia) {
        if (maTacGia > 0) {
            return tacGiaDAO.deleteTacGia(maTacGia);
        }
        System.err.println("Mã tác giả không hợp lệ!");
        return false;
    }

    // Lấy danh sách tất cả tác giả
    public List<TacGiaDTO> getAllTacGia() {
        return tacGiaDAO.getAllTacGia();
    }

    // Tìm tác giả theo mã tác giả
    public TacGiaDTO findTacGiaById(int maTacGia) {
        if (maTacGia > 0) {
            return tacGiaDAO.findTacGiaById(maTacGia);
        }
        System.err.println("Mã tác giả không hợp lệ!");
        return null;
    }

    // Tìm tác giả theo tên
    public List<TacGiaDTO> findTacGiaByName(String tenTacGia) {
        if (tenTacGia != null && !tenTacGia.trim().isEmpty()) {
            return tacGiaDAO.findTacGiaByName(tenTacGia);
        }
        System.err.println("Tên tác giả không hợp lệ!");
        return null;
    }

    // Kiểm tra tính hợp lệ của dữ liệu tác giả
    private boolean validateTacGia(TacGiaDTO tacGia) {
        if (tacGia == null) {
            return false;
        }
        if (tacGia.getTenTacGia() == null || tacGia.getTenTacGia().trim().isEmpty()) {
            return false;
        }
        if (tacGia.getNamSinh() <= 0) {
            return false;
        }
        if (tacGia.getQueQuan() == null || tacGia.getQueQuan().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}