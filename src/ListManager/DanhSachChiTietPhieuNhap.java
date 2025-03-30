package ListManager;

import java.util.*;
import Object.ChiTietPhieuNhap;

public class DanhSachChiTietPhieuNhap {
    private ArrayList<ChiTietPhieuNhap> danhSach;

    // Constructor
    public DanhSachChiTietPhieuNhap() {
        danhSach = new ArrayList<>();
    }

    // Thêm chi tiết phiếu nhập
    public void themChiTiet(ChiTietPhieuNhap ctpn) {
        danhSach.add(ctpn);
        System.out.println("Đã thêm chi tiết phiếu nhập thành công.");
    }

    // Xóa chi tiết phiếu nhập theo mã phiếu nhập và mã sách
    public void xoaChiTiet(int maphieunhap, int masach) {
        for (ChiTietPhieuNhap ctpn : danhSach) {
            if (ctpn.getMaphieunhap() == maphieunhap && ctpn.getMasach() == masach) {
                danhSach.remove(ctpn);
                System.out.println("Đã xóa chi tiết phiếu nhập thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu nhập cần xóa.");
    }

    // Tìm kiếm chi tiết phiếu nhập theo mã phiếu nhập
    public void timChiTiet(int maphieunhap) {
        boolean found = false;
        for (ChiTietPhieuNhap ctpn : danhSach) {
            if (ctpn.getMaphieunhap() == maphieunhap) {
                ctpn.xuatThongTin();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập với mã: " + maphieunhap);
        }
    }

    // Hiển thị danh sách chi tiết phiếu nhập
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách chi tiết phiếu nhập trống.");
            return;
        }
        System.out.println("===== Danh Sách Chi Tiết Phiếu Nhập =====");
        for (ChiTietPhieuNhap ctpn : danhSach) {
            ctpn.xuatThongTin();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách chi tiết phiếu nhập từ bàn phím
    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng chi tiết phiếu nhập: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin chi tiết phiếu nhập thứ " + (i + 1) + ":");
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.nhapThongTin();
            themChiTiet(ctpn);
        }
    }
}
