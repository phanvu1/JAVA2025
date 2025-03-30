package ListManager;

import java.util.*;
import Object.Loai;

public class DanhSachLoai {
    private ArrayList<Loai> danhSach;

    // Constructor
    public DanhSachLoai() {
        danhSach = new ArrayList<>();
    }

    // Thêm loại mới
    public void themLoai(Loai loai) {
        danhSach.add(loai);
        System.out.println("Đã thêm loại thành công.");
    }

    // Xóa loại theo mã
    public void xoaLoai(int maloai) {
        for (Loai loai : danhSach) {
            if (loai.getMatheloai() == maloai) {
                danhSach.remove(loai);
                System.out.println("Đã xóa loại có mã: " + maloai);
                return;
            }
        }
        System.out.println("Không tìm thấy loại có mã: " + maloai);
    }

    // Tìm kiếm loại theo mã
    public Loai timLoai(int maloai) {
        for (Loai loai : danhSach) {
            if (loai.getMatheloai() == maloai) {
                return loai;
            }
        }
        return null;
    }

    // Hiển thị danh sách loại
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách loại trống.");
            return;
        }
        System.out.println("===== Danh Sách Loại =====");
        for (Loai loai : danhSach) {
            loai.hienThi();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách loại từ bàn phím
    public void nhapDanhSachLoai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng loại: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin loại thứ " + (i + 1) + ":");
            Loai loai = new Loai();
            loai.nhap();
            themLoai(loai);
        }
    }
}
