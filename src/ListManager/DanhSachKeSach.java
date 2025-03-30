package ListManager;

import java.util.*;
import Object.KeSach;

public class DanhSachKeSach {
    private ArrayList<KeSach> danhSach;

    // Constructor
    public DanhSachKeSach() {
        danhSach = new ArrayList<>();
    }

    // Thêm kệ sách mới
    public void themKeSach(KeSach keSach) {
        danhSach.add(keSach);
        System.out.println("Đã thêm kệ sách thành công.");
    }

    // Xóa kệ sách theo mã
    public void xoaKeSach(int makesach) {
        for (KeSach keSach : danhSach) {
            if (keSach.getMakesach() == makesach) {
                danhSach.remove(keSach);
                System.out.println("Đã xóa kệ sách có mã: " + makesach);
                return;
            }
        }
        System.out.println("Không tìm thấy kệ sách có mã: " + makesach);
    }

    // Tìm kiếm kệ sách theo mã
    public KeSach timKeSach(int makesach) {
        for (KeSach keSach : danhSach) {
            if (keSach.getMakesach() == makesach) {
                return keSach;
            }
        }
        return null;
    }

    // Hiển thị danh sách kệ sách
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách kệ sách trống.");
            return;
        }
        System.out.println("===== Danh Sách Kệ Sách =====");
        for (KeSach keSach : danhSach) {
            keSach.xuat();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách kệ sách từ bàn phím
    public void nhapDanhSachKeSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng kệ sách: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin kệ sách thứ " + (i + 1) + ":");
            KeSach keSach = new KeSach();
            keSach.nhap();
            themKeSach(keSach);
        }
    }
}
