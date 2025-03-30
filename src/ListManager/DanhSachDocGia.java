package ListManager;

import java.util.*;
import Object.DocGia;

public class DanhSachDocGia {
    private ArrayList<DocGia> danhSach;

    // Constructor
    public DanhSachDocGia() {
        danhSach = new ArrayList<>();
    }

    // Thêm độc giả mới
    public void themDocGia(DocGia docGia) {
        danhSach.add(docGia);
        System.out.println("Đã thêm độc giả thành công.");
    }

    // Xóa độc giả theo mã
    public void xoaDocGia(int madocgia) {
        for (DocGia docGia : danhSach) {
            if (docGia.getMadocgia() == madocgia) {
                danhSach.remove(docGia);
                System.out.println("Đã xóa độc giả có mã: " + madocgia);
                return;
            }
        }
        System.out.println("Không tìm thấy độc giả có mã: " + madocgia);
    }

    // Tìm kiếm độc giả theo mã
    public DocGia timDocGia(int madocgia) {
        for (DocGia docGia : danhSach) {
            if (docGia.getMadocgia() == madocgia) {
                return docGia;
            }
        }
        return null;
    }

    // Hiển thị danh sách độc giả
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách độc giả trống.");
            return;
        }
        System.out.println("===== Danh Sách Độc Giả =====");
        for (DocGia docGia : danhSach) {
            docGia.xuatThongTin();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách độc giả từ bàn phím
    public void nhapDanhSachDocGia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng độc giả: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin độc giả thứ " + (i + 1) + ":");
            DocGia docGia = new DocGia();
            docGia.nhapThongTin();
            themDocGia(docGia);
        }
    }
}
