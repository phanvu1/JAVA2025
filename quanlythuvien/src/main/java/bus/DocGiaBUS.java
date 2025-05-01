package bus;

import java.sql.Connection;
import java.util.List;

import dao.DocGiaDAO;
import dto.DocGiaDTO;

public class DocGiaBUS {

    public static Object gI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private DocGiaDAO docGiaDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public DocGiaBUS(Connection connection) {
        this.docGiaDAO = new DocGiaDAO(connection);
    }

    // Thêm độc giả mới
    public boolean themDocGia(DocGiaDTO docGia) {
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
    public boolean suaDocGia(DocGiaDTO docGia) {
        if (docGia.getMaDocGia() <= 0) {
            throw new IllegalArgumentException("Mã độc giả không hợp lệ");
        }
        return themDocGia(docGia); // Tái sử dụng logic kiểm tra từ phương thức thêm
    }

    // Xóa độc giả theo mã độc giả
    public boolean xoaDocGia(int maDocGia) {
        if (maDocGia <= 0) {
            throw new IllegalArgumentException("Mã độc giả không hợp lệ");
        }
        return docGiaDAO.deleteDocGia(maDocGia);
    }

    // Lấy danh sách tất cả độc giả
    public List<DocGiaDTO> getAllDocGia() {
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
    public List<DocGiaDTO> timDocGiaTheoTen(String tenDocGia) {
        if (tenDocGia == null || tenDocGia.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên độc giả không được để trống");
        }
        return docGiaDAO.findDocGiaByName(tenDocGia);
    }

    public boolean deleteDocGia(int maDocGia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updateDocGia(DocGiaDTO docGiaSua) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addDocGia(DocGiaDTO docGiaMoi) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}