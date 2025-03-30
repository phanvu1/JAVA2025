package ListManager;

import java.util.*;
import Object.NhaXuatBan;

public class DanhSachNhaXuatBan {
    private ArrayList<NhaXuatBan> danhSach;

    // Constructor
    public DanhSachNhaXuatBan() {
        danhSach = new ArrayList<>();
    }

    // Thêm nhà xuất bản vào danh sách
    public void themNhaXuatBan(NhaXuatBan nxb) {
        danhSach.add(nxb);
        System.out.println("Đã thêm nhà xuất bản thành công.");
    }

    // Xóa nhà xuất bản theo mã
    public void xoaNhaXuatBan(int manxb) {
        for (NhaXuatBan nxb : danhSach) {
            if (nxb.getManxb() == manxb) {
                danhSach.remove(nxb);
                System.out.println("Đã xóa nhà xuất bản có mã: " + manxb);
                return;
            }
        }
        System.out.println("Không tìm thấy nhà xuất bản có mã: " + manxb);
    }

    // Tìm kiếm nhà xuất bản theo mã
    public NhaXuatBan timNhaXuatBan(int manxb) {
        for (NhaXuatBan nxb : danhSach) {
            if (nxb.getManxb() == manxb) {
                return nxb;
            }
        }
        return null;
    }

    // Hiển thị danh sách nhà xuất bản
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách nhà xuất bản trống.");
            return;
        }
        System.out.println("===== Danh Sách Nhà Xuất Bản =====");
        for (NhaXuatBan nxb : danhSach) {
            nxb.xuat();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách nhà xuất bản từ bàn phím
    public void nhapDanhSachNhaXuatBan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng nhà xuất bản: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin nhà xuất bản thứ " + (i + 1) + ":");
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.nhap();
            themNhaXuatBan(nxb);
        }
    }
}
