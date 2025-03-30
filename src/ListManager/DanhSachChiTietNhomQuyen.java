package ListManager;

import java.util.*;
import Object.ChiTietNhomQuyen;

public class DanhSachChiTietNhomQuyen {
    private ArrayList<ChiTietNhomQuyen> danhSach;

    // Constructor
    public DanhSachChiTietNhomQuyen() {
        danhSach = new ArrayList<>();
    }

    // Thêm chi tiết nhóm quyền
    public void themChiTiet(ChiTietNhomQuyen ctnq) {
        danhSach.add(ctnq);
        System.out.println("Đã thêm chi tiết nhóm quyền thành công.");
    }

    // Xóa chi tiết nhóm quyền theo ID chi tiết nhóm quyền
    public void xoaChiTiet(int idchitietnhomquyen) {
        for (ChiTietNhomQuyen ctnq : danhSach) {
            if (ctnq.getIdChiTietNhomQuyen() == idchitietnhomquyen) {
                danhSach.remove(ctnq);
                System.out.println("Đã xóa chi tiết nhóm quyền thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết nhóm quyền cần xóa.");
    }

    // Tìm kiếm chi tiết nhóm quyền theo ID quyền
    public void timChiTiet(int idquyen) {
        boolean found = false;
        for (ChiTietNhomQuyen ctnq : danhSach) {
            if (ctnq.getIdQuyen() == idquyen) {
                ctnq.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chi tiết nhóm quyền với ID quyền: " + idquyen);
        }
    }

    // Hiển thị danh sách chi tiết nhóm quyền
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách chi tiết nhóm quyền trống.");
            return;
        }
        System.out.println("===== Danh Sách Chi Tiết Nhóm Quyền =====");
        for (ChiTietNhomQuyen ctnq : danhSach) {
            ctnq.xuat();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách chi tiết nhóm quyền từ bàn phím
    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng chi tiết nhóm quyền: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin chi tiết nhóm quyền thứ " + (i + 1) + ":");
            ChiTietNhomQuyen ctnq = new ChiTietNhomQuyen();
            ctnq.nhap();
            themChiTiet(ctnq);
        }
    }
}
