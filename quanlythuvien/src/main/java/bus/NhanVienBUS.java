package bus;

import java.sql.Connection;
import java.util.List;

import dao.NhanVienDAO;
import dto.NhanVienDTO;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO;

    // Constructor: Nhận kết nối từ bên ngoài và khởi tạo DAO
    public NhanVienBUS(Connection connection) {
        this.nhanVienDAO = new NhanVienDAO(connection);
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVienDTO> getAllNhanVien() {
        return nhanVienDAO.getAllNhanVien();
    }

    // Tìm nhân viên theo mã
    public NhanVienDTO findNhanVienById(int maNV) {
        if (maNV > 0) {
            return nhanVienDAO.findNhanVienById(maNV);
        }
        System.err.println("Mã nhân viên không hợp lệ!");
        return null;
    }

    // Tìm nhân viên theo tên
    public List<NhanVienDTO> findNhanVienByName(String tenNV) {
        if (tenNV != null && !tenNV.trim().isEmpty()) {
            return nhanVienDAO.findNhanVienByName(tenNV);
        }
        System.err.println("Tên nhân viên không hợp lệ!");
        return null;
    }

    // Thêm nhân viên mới
    public boolean addNhanVien(NhanVienDTO nhanVien) {
        if (validateNhanVien(nhanVien)) {
            return nhanVienDAO.saveNhanVien(nhanVien);
        }
        System.err.println("Dữ liệu nhân viên không hợp lệ!");
        return false;
    }

    // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(NhanVienDTO nhanVien) {
        if (validateNhanVien(nhanVien) && nhanVien.getMaNV() > 0) {
            return nhanVienDAO.updateNhanVien(nhanVien);
        }
        System.err.println("Dữ liệu nhân viên không hợp lệ hoặc mã nhân viên không tồn tại!");
        return false;
    }

    // Xóa nhân viên theo mã
    public boolean deleteNhanVien(int maNV) {
        if (maNV > 0) {
            // Có thể thêm kiểm tra nghiệp vụ ở đây, ví dụ: kiểm tra xem nhân viên này có đang quản lý phiếu mượn nào không trước khi xóa
            return nhanVienDAO.deleteNhanVien(maNV);
        }
        System.err.println("Mã nhân viên không hợp lệ!");
        return false;
    }

    // Kiểm tra tính hợp lệ của dữ liệu nhân viên
    private boolean validateNhanVien(NhanVienDTO nhanVien) {
        if (nhanVien == null) {
            return false;
        }
        if (nhanVien.getTenNV() == null || nhanVien.getTenNV().trim().isEmpty()) {
            return false;
        }
        if (nhanVien.getGioiTinh() == null || nhanVien.getGioiTinh().trim().isEmpty()) {
            return false;
        }
        if (nhanVien.getDiaChi() == null || nhanVien.getDiaChi().trim().isEmpty()) {
            return false;
        }
        if (nhanVien.getSDT() == null || nhanVien.getSDT().trim().isEmpty()) {
            return false;
        }
        if (nhanVien.getNamSinh() <= 0) {
            return false;
        }
        // Có thể thêm các kiểm tra định dạng khác cho số điện thoại, năm sinh nếu cần
        return true;
    }
}