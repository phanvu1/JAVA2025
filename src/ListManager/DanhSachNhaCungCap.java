package Object;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhaCungCap {
    private ArrayList<NhaCungCap> danhSach;

    // Constructor
    public DanhSachNhaCungCap() {
        danhSach = new ArrayList<>();
    }

    // Thêm nhà cung cấp vào danh sách
    public void themNhaCungCap(NhaCungCap ncc) {
        danhSach.add(ncc);
        System.out.println("Đã thêm nhà cung cấp thành công.");
    }

    // Xóa nhà cung cấp theo mã
    public void xoaNhaCungCap(int mancc) {
        for (NhaCungCap ncc : danhSach) {
            if (ncc.getMancc() == mancc) {
                danhSach.remove(ncc);
                System.out.println("Đã xóa nhà cung cấp có mã: " + mancc);
                return;
            }
        }
        System.out.println("Không tìm thấy nhà cung cấp có mã: " + mancc);
    }

    // Tìm kiếm nhà cung cấp theo mã
    public NhaCungCap timNhaCungCap(int mancc) {
        for (NhaCungCap ncc : danhSach) {
            if (ncc.getMancc() == mancc) {
                return ncc;
            }
        }
        return null;
    }

    // Hiển thị danh sách nhà cung cấp
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách nhà cung cấp trống.");
            return;
        }
        System.out.println("===== Danh Sách Nhà Cung Cấp =====");
        for (NhaCungCap ncc : danhSach) {
            ncc.xuatThongTin();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách nhà cung cấp từ bàn phím
    public void nhapDanhSachNhaCungCap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng nhà cung cấp: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin nhà cung cấp thứ " + (i + 1) + ":");
            NhaCungCap ncc = new NhaCungCap();
            ncc.nhapThongTin();
            themNhaCungCap(ncc);
        }
    }
}
