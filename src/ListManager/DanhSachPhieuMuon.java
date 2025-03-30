package ListManager;

import java.util.*;
import Object.PhieuMuon;

public class DanhSachPhieuMuon {
    private ArrayList<PhieuMuon> danhSach;

    // Constructor
    public DanhSachPhieuMuon() {
        danhSach = new ArrayList<>();
    }

    // Thêm phiếu mượn vào danh sách
    public void themPhieuMuon(PhieuMuon pm) {
        danhSach.add(pm);
        System.out.println("Đã thêm phiếu mượn thành công.");
    }

    // Xóa phiếu mượn theo mã
    public void xoaPhieuMuon(int maphieumuon) {
        for (PhieuMuon pm : danhSach) {
            if (pm.getMaphieumuon() == maphieumuon) {
                danhSach.remove(pm);
                System.out.println("Đã xóa phiếu mượn có mã: " + maphieumuon);
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu mượn có mã: " + maphieumuon);
    }

    // Tìm kiếm phiếu mượn theo mã
    public PhieuMuon timPhieuMuon(int maphieumuon) {
        for (PhieuMuon pm : danhSach) {
            if (pm.getMaphieumuon() == maphieumuon) {
                return pm;
            }
        }
        return null;
    }

    // Hiển thị toàn bộ danh sách phiếu mượn
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách phiếu mượn trống.");
            return;
        }
        System.out.println("===== Danh Sách Phiếu Mượn =====");
        for (PhieuMuon pm : danhSach) {
            pm.xuat();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách phiếu mượn từ bàn phím
    public void nhapDanhSachPhieuMuon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phiếu mượn: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin phiếu mượn thứ " + (i + 1) + ":");
            PhieuMuon pm = new PhieuMuon();
            pm.nhap();
            themPhieuMuon(pm);
        }
    }
}
