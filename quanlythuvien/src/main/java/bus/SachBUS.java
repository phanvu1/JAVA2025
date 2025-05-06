package bus;

import java.util.ArrayList;

import dao.SachDAO;
import dto.SachDTO;

public class SachBUS {
    private SachDAO sachDAO;
    private ArrayList<SachDTO> sachList;

    // Constructor: Khởi tạo SachDAO và danh sách sách
    public SachBUS() {
        this.sachDAO = new SachDAO();
        this.sachList = sachDAO.getAll();
    }

    // Lấy tất cả sách (có thể từ cache)
    public ArrayList<SachDTO> getAllSach() {
        if (sachList == null || sachList.isEmpty()) {
            sachList = sachDAO.getAll();
        }
        return sachList;
    }

    // Lấy tổng số lượng sách trong hệ thống
    public int getTongSoLuongSach() {
        try {
            return sachDAO.soluongsach();
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tổng số lượng sách: " + e.getMessage());
            return 0;
        }
    }

    // Thêm sách mới
    public boolean addSach(SachDTO sach) {
        validateSach(sach);
        boolean result = sachDAO.insert(sach);
        if (result) {
            sachList = sachDAO.getAll(); // Refresh danh sách
        }
        return result;
    }

    // Cập nhật thông tin sách
    public boolean updateSach(SachDTO sach) {
        validateSach(sach);
        if (sach.getMaSach() <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        boolean result = sachDAO.update(sach);
        if (result) {
            sachList = sachDAO.getAll(); // Refresh danh sách
        }
        return result;
    }

    // Xóa sách
    public boolean deleteSach(int maSach) {
        if (maSach <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        boolean result = sachDAO.delete(maSach);
        if (result) {
            sachList = sachDAO.getAll(); // Refresh danh sách
        }
        return result;
    }

    // Tìm kiếm sách theo mã
    public SachDTO getSachById(int maSach) {
        if (maSach <= 0) {
            throw new IllegalArgumentException("Mã sách không hợp lệ");
        }
        return sachList.stream()
                .filter(s -> s.getMaSach() == maSach)
                .findFirst()
                .orElseGet(() -> sachDAO.getById(maSach));
    }

    // Tìm kiếm sách theo tên (từ cache)
    public ArrayList<SachDTO> getSachByName(String tenSach) {
        if (tenSach == null || tenSach.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
        return sachList.stream()
                .filter(s -> s.getTenSach().toLowerCase().contains(tenSach.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // Validate dữ liệu sách
    private void validateSach(SachDTO sach) {
        if (sach.getTenSach() == null || sach.getTenSach().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
        if (sach.getMaLoai() <= 0 || sach.getMaNXB() <= 0 || sach.getMaKeSach() <= 0) {
            throw new IllegalArgumentException("Mã loại, mã NXB hoặc mã kệ sách không hợp lệ");
        }
        if (sach.getNamXB() <= 0 || sach.getSoLuong() < 0) {
            throw new IllegalArgumentException("Năm xuất bản hoặc số lượng không hợp lệ");
        }
    }

    // Singleton pattern
    private static SachBUS instance;

    public static SachBUS gI() {
        if (instance == null) {
            instance = new SachBUS();
        }
        return instance;
    }
}