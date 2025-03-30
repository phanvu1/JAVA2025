package ListManager;

import java.util.*;
import Object.NhomQuyen;

public class DanhSachNhomQuyen {
    private ArrayList<NhomQuyen> danhSach;

    // Constructor
    public DanhSachNhomQuyen() {
        danhSach = new ArrayList<>();
    }

    // Thêm nhóm quyền vào danh sách
    public void themNhomQuyen(NhomQuyen nq) {
        danhSach.add(nq);
        System.out.println("Đã thêm nhóm quyền thành công.");
    }

    // Xóa nhóm quyền theo ID
    public void xoaNhomQuyen(int id) {
        for (NhomQuyen nq : danhSach) {
            if (nq.getIdNhomQuyen() == id) {
                danhSach.remove(nq);
                System.out.println("Đã xóa nhóm quyền có ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy nhóm quyền có ID: " + id);
    }

    // Tìm kiếm nhóm quyền theo ID
    public NhomQuyen timNhomQuyen(int id) {
        for (NhomQuyen nq : danhSach) {
            if (nq.getIdNhomQuyen() == id) {
                return nq;
            }
        }
        return null;
    }

    // Hiển thị danh sách nhóm quyền
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách nhóm quyền trống.");
            return;
        }
        System.out.println("===== Danh Sách Nhóm Quyền =====");
        for (NhomQuyen nq : danhSach) {
            nq.xuat();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách nhóm quyền từ bàn phím
    public void nhapDanhSachNhomQuyen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng nhóm quyền: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin nhóm quyền thứ " + (i + 1) + ":");
            NhomQuyen nq = new NhomQuyen();
            nq.nhap();
            themNhomQuyen(nq);
        }
    }
}
