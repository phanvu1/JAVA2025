package bus;

import java.sql.Connection;
import java.util.ArrayList;

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
        if (docGia.getTenDocGia() == null || docGia.getTenDocGia().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên độc giả không được để trống");
        }
        if (docGia.getGioiTinh() == null || docGia.getGioiTinh().trim().isEmpty()) {
            throw new IllegalArgumentException("Giới tính không được để trống");
        }
        if (docGia.getDiaChi() == null || docGia.getDiaChi().trim().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ không được để trống");
        }
        if (docGia.getMaThe() <= 0) {
            throw new IllegalArgumentException("Mã thẻ không hợp lệ");
        }
        return docGiaDAO.saveDocGia(docGia);
    }

    // Cập nhật thông tin độc giả
    public boolean updateDocGia(DocGiaDTO docGia) {
        if (docGia.getMaDocGia() <= 0) {
            throw new IllegalArgumentException("Mã độc giả không hợp lệ");
        }
        return docGiaDAO.updateDocGia(docGia);
    }

    // Xóa độc giả theo mã độc giả
    public boolean deleteDocGia(int maDocGia) {
        if (maDocGia <= 0) {
            throw new IllegalArgumentException("Mã độc giả không hợp lệ");
        }
        return docGiaDAO.deleteDocGia(maDocGia);
    }

    // Lấy danh sách tất cả độc giả
    public ArrayList<DocGiaDTO> getAllDocGia() {
        return docGiaDAO.getAllDocGia();
    }

    // Tìm độc giả theo mã độc giả
    public DocGiaDTO timDocGiaTheoMa(int maDocGia) {
        if (maDocGia <= 0) {
            throw new IllegalArgumentException("Mã độc giả không hợp lệ");
        }
        return docGiaDAO.findDocGiaById(maDocGia);
    }

    // Tìm độc giả theo tên
    public ArrayList<DocGiaDTO> timDocGiaTheoTen(String tenDocGia) {
        if (tenDocGia == null || tenDocGia.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên độc giả không được để trống");
        }
        return docGiaDAO.findDocGiaByName(tenDocGia);
    }

    public static DocGiaBUS iBus = null;

    public static DocGiaBUS gI() {
        if (iBus == null) {
            iBus = new DocGiaBUS(null);
        }
        return iBus;
    }
}