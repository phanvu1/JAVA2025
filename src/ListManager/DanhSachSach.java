package ListManager;

import java.util.*;
import Object.Sach;

public class DanhSachSach {
    private List<Sach> danhSachSach;

    public DanhSachSach() {
        this.danhSachSach = new ArrayList<>();
    }

    // Thêm sách vào danh sách
    public void themSach(Sach sach) {
        danhSachSach.add(sach);
        System.out.println("Đã thêm sách thành công!");
    }

    // Tìm sách theo mã
    public Sach timSach(int masach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMasach() == masach) {
                return sach;
            }
        }
        return null;
    }

    // Sửa thông tin sách theo mã
    public boolean suaSach(int masach) {
        Sach sach = timSach(masach);
        if (sach != null) {
            sach.nhapSach();
            System.out.println("Đã cập nhật thông tin sách!");
            return true;
        }
        System.out.println("Không tìm thấy sách có mã: " + masach);
        return false;
    }

    // Xóa sách theo mã
    public boolean xoaSach(int masach) {
        Sach sach = timSach(masach);
        if (sach != null) {
            danhSachSach.remove(sach);
            System.out.println("Đã xóa sách thành công!");
            return true;
        }
        System.out.println("Không tìm thấy sách để xóa!");
        return false;
    }

    // Hiển thị danh sách sách
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách sách trống!");
        } else {
            for (Sach sach : danhSachSach) {
                sach.hienThiSach();
                System.out.println("--------------------------");
            }
        }
    }
}
