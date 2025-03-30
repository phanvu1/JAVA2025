package ListManager;

import Object.TacGia;
import java.util.*;

// Lớp quản lý danh sách tác giả
public class DanhSachTacGia {
    private ArrayList<TacGia> danhSachTacGia;

    // Constructor
    public DanhSachTacGia() {
        danhSachTacGia = new ArrayList<>();
    }

    // Thêm tác giả
    public void themTacGia(TacGia tacGia) {
        danhSachTacGia.add(tacGia);
        System.out.println("Thêm tác giả thành công!");
    }

    // Tìm tác giả theo mã
    public TacGia timTacGia(int maTacGia) {
        for (TacGia tacGia : danhSachTacGia) {
            if (tacGia.getMatacgia() == maTacGia) {
                return tacGia;
            }
        }
        return null;
    }

    // Sửa thông tin tác giả
    public void suaTacGia(int maTacGia) {
        TacGia tacGia = timTacGia(maTacGia);
        if (tacGia != null) {
            tacGia.nhap();
            System.out.println("Sửa thông tin tác giả thành công!");
        } else {
            System.out.println("Không tìm thấy tác giả!");
        }
    }

    // Xóa tác giả theo mã
    public void xoaTacGia(int maTacGia) {
        TacGia tacGia = timTacGia(maTacGia);
        if (tacGia != null) {
            danhSachTacGia.remove(tacGia);
            System.out.println("Xóa tác giả thành công!");
        } else {
            System.out.println("Không tìm thấy tác giả!");
        }
    }

    // Hiển thị danh sách tác giả
    public void hienThiDanhSach() {
        if (danhSachTacGia.isEmpty()) {
            System.out.println("Danh sách tác giả trống!");
        } else {
            for (TacGia tacGia : danhSachTacGia) {
                tacGia.hienThi();
                System.out.println("--------------------");
            }
        }
    }
}