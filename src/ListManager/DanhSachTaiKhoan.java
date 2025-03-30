package ListManager;

import Object.TaiKhoan;
import java.util.*;

public class DanhSachTaiKhoan {
    private ArrayList<TaiKhoan> danhSachTK;

    // Constructor
    public DanhSachTaiKhoan() {
        danhSachTK = new ArrayList<>();
    }

    // Thêm tài khoản vào danh sách
    public void themTaiKhoan(TaiKhoan tk) {
        danhSachTK.add(tk);
        System.out.println("Đã thêm tài khoản: " + tk.getUsername());
    }

    // Xóa tài khoản theo mã
    public boolean xoaTaiKhoan(int maTK) {
        Iterator<TaiKhoan> iterator = danhSachTK.iterator();
        while (iterator.hasNext()) {
            TaiKhoan tk = iterator.next();
            if (tk.getMaTaiKhoan() == maTK) {
                iterator.remove();
                System.out.println("Đã xóa tài khoản có mã: " + maTK);
                return true;
            }
        }
        System.out.println("Không tìm thấy tài khoản có mã: " + maTK);
        return false;
    }

    // Tìm kiếm tài khoản theo mã
    public TaiKhoan timKiemTaiKhoan(int maTK) {
        for (TaiKhoan tk : danhSachTK) {
            if (tk.getMaTaiKhoan() == maTK) {
                return tk;
            }
        }
        return null;
    }

    // Hiển thị danh sách tài khoản
    public void hienThiDanhSach() {
        if (danhSachTK.isEmpty()) {
            System.out.println("Danh sách tài khoản trống.");
        } else {
            for (TaiKhoan tk : danhSachTK) {
                tk.xuat();
                System.out.println("---------------------");
            }
        }
    }
}
