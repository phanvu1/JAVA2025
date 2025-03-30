package ListManager;

import java.util.*;
import Object.TheThuVien;

// Lớp danh sách quản lý thẻ thư viện
public class DanhSachTheThuVien {
    private ArrayList<TheThuVien> danhSach;

    // Constructor
    public DanhSachTheThuVien() {
        this.danhSach = new ArrayList<>();
    }

    // Thêm thẻ thư viện
    public void themTheThuVien(TheThuVien theThuVien) {
        danhSach.add(theThuVien);
        System.out.println("Đã thêm thẻ thư viện thành công!");
    }

    // Tìm thẻ theo mã
    public TheThuVien timKiemTheoMa(int maThe) {
        for (TheThuVien ttv : danhSach) {
            if (ttv.getMathetv() == maThe) {
                return ttv;
            }
        }
        return null;
    }

    // Xóa thẻ thư viện theo mã
    public boolean xoaTheThuVien(int maThe) {
        TheThuVien ttv = timKiemTheoMa(maThe);
        if (ttv != null) {
            danhSach.remove(ttv);
            System.out.println("Đã xóa thẻ thư viện thành công!");
            return true;
        }
        System.out.println("Không tìm thấy thẻ thư viện!");
        return false;
    }

    // Cập nhật thông tin thẻ thư viện
    public boolean suaTheThuVien(int maThe) {
        TheThuVien ttv = timKiemTheoMa(maThe);
        if (ttv != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập ngày bắt đầu mới: ");
            ttv.setNgaybd(sc.nextLine());
            System.out.print("Nhập ngày hết hạn mới: ");
            ttv.setNgayhh(sc.nextLine());
            System.out.print("Nhập ghi chú mới: ");
            ttv.setGhichu(sc.nextLine());
            System.out.println("Đã cập nhật thông tin thẻ thư viện!");
            return true;
        }
        System.out.println("Không tìm thấy thẻ thư viện để sửa!");
        return false;
    }

    // Hiển thị danh sách thẻ thư viện
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách thẻ thư viện trống!");
            return;
        }
        for (TheThuVien ttv : danhSach) {
            ttv.xuatThongTin();
            System.out.println("------------------");
        }
    }
}
