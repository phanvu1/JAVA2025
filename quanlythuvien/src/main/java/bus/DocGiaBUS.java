package bus;

import java.sql.Connection;
import java.util.List;

import dao.DocGiaDAO;
import dto.DocGiaDTO;

public class DocGiaBUS {
    private DocGiaDAO docGiaDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public DocGiaBUS(Connection connection) {
        this.docGiaDAO = new DocGiaDAO(connection);
    }

    // Thêm độc giả mới
    public boolean addDocGia(DocGiaDTO docGia) {
        if (validateDocGia(docGia)) {
            return docGiaDAO.saveDocGia(docGia);
        }
        System.err.println("Dữ liệu độc giả không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin độc giả
    public boolean updateDocGia(DocGiaDTO docGia) {
        if (validateDocGia(docGia) && docGia.getMaDocGia() > 0) {
            return docGiaDAO.updateDocGia(docGia);
        }
        System.err.println("Dữ liệu độc giả không hợp lệ hoặc mã độc giả không tồn tại!");
        return false;
    }

    // Xóa độc giả theo mã độc giả
    public boolean deleteDocGia(int maDocGia) {
        if (maDocGia > 0) {
            return docGiaDAO.deleteDocGia(maDocGia);
        }
        System.err.println("Mã độc giả không hợp lệ!");
        return false;
    }

    // Lấy danh sách tất cả độc giả
    public List<DocGiaDTO> getAllDocGia() {
        return docGiaDAO.getAllDocGia();
    }

    // Tìm độc giả theo mã độc giả
    public DocGiaDTO findDocGiaById(int maDocGia) {
        if (maDocGia > 0) {
            return docGiaDAO.findDocGiaById(maDocGia);
        }
        System.err.println("Mã độc giả không hợp lệ!");
        return null;
    }

    // Tìm độc giả theo tên
    public List<DocGiaDTO> findDocGiaByName(String tenDocGia) {
        if (tenDocGia != null && !tenDocGia.trim().isEmpty()) {
            return docGiaDAO.findDocGiaByName(tenDocGia);
        }
        System.err.println("Tên độc giả không hợp lệ!");
        return null;
    }

    // Kiểm tra tính hợp lệ của dữ liệu độc giả
    private boolean validateDocGia(DocGiaDTO docGia) {
        if (docGia == null) {
            return false;
        }
        if (docGia.getTenDocGia() == null || docGia.getTenDocGia().trim().isEmpty()) {
            return false;
        }
        if (docGia.getGioiTinh() == null || docGia.getGioiTinh().trim().isEmpty()) {
            return false;
        }
        if (docGia.getDiaChi() == null || docGia.getDiaChi().trim().isEmpty()) {
            return false;
        }
        if (docGia.getMaThe() <= 0) {
            return false;
        }
        return true;
    }
}