package ListManager;

import java.util.*;
import Object.PhieuNhap;

public class DanhSachPhieuNhap {
    private ArrayList<PhieuNhap> danhSach;

    // Constructor
    public DanhSachPhieuNhap() {
        danhSach = new ArrayList<>();
    }

    // Thêm phiếu nhập vào danh sách
    public void themPhieuNhap(PhieuNhap pn) {
        danhSach.add(pn);
        System.out.println("Đã thêm phiếu nhập thành công.");
    }

    // Xóa phiếu nhập theo mã
    public void xoaPhieuNhap(int maphieunhap) {
        for (PhieuNhap pn : danhSach) {
            if (pn.getMaphieunhap() == maphieunhap) {
                danhSach.remove(pn);
                System.out.println("Đã xóa phiếu nhập có mã: " + maphieunhap);
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập có mã: " + maphieunhap);
    }

    // Tìm kiếm phiếu nhập theo mã
    public PhieuNhap timPhieuNhap(int maphieunhap) {
        for (PhieuNhap pn : danhSach) {
            if (pn.getMaphieunhap() == maphieunhap) {
                return pn;
            }
        }
        return null;
    }

    // Hiển thị toàn bộ danh sách phiếu nhập
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách phiếu nhập trống.");
            return;
        }
        System.out.println("===== Danh Sách Phiếu Nhập =====");
        for (PhieuNhap pn : danhSach) {
            pn.xuatThongTin();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách phiếu nhập từ bàn phím
    public void nhapDanhSachPhieuNhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phiếu nhập: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin phiếu nhập thứ " + (i + 1) + ":");
            PhieuNhap pn = new PhieuNhap();
            pn.nhapThongTin();
            themPhieuNhap(pn);
        }
    }
}
