package ListManager;


import java.util.*;
import Object.NhanVien;

public class DanhSachNhanVien {
    
    private final ArrayList<NhanVien> danhSachNV;

    // Constructor
    public DanhSachNhanVien() {
        danhSachNV = new ArrayList<>();
    }

    // Thêm nhân viên vào danh sách
    public void themNhanVien(NhanVien nv) {
        danhSachNV.add(nv);
        System.out.println("Đã thêm nhân viên: " + nv.getTennv());
    }

    // Xóa nhân viên theo mã nhân viên
    public boolean xoaNhanVien(int manv) {
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv() == manv) {
                danhSachNV.remove(nv);
                System.out.println("Đã xóa nhân viên có mã: " + manv);
                return true;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã: " + manv);
        return false;
    }

    // Sửa thông tin nhân viên theo mã nhân viên
    public boolean suaNhanVien(int manv) {
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv() == manv) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập tên mới: ");
                nv.setTennv(sc.nextLine());
                System.out.print("Nhập năm sinh mới: ");
                nv.setNamsinh(sc.nextInt());
                sc.nextLine();
                System.out.print("Nhập giới tính mới: ");
                nv.setGioitinh(sc.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                nv.setSdt(sc.nextLine());
                System.out.print("Nhập ngày bắt đầu mới: ");
                nv.setNgaybatdau(sc.nextLine());
                System.out.print("Nhập lương mới: ");
                nv.setLuong(sc.nextDouble());
                sc.nextLine();
                System.out.print("Nhập địa chỉ mới: ");
                nv.setDiachi(sc.nextLine());
                System.out.print("Nhập mã tài khoản mới: ");
                nv.setMataikhoan(sc.nextInt());

                System.out.println("Cập nhật thành công!");
                return true;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã: " + manv);
        return false;
    }

    // Tìm nhân viên theo mã nhân viên
    public NhanVien timKiemNhanVien(int manv) {
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv() == manv) {
                return nv;
            }
        }
        return null;
    }

    // Hiển thị danh sách nhân viên
    public void hienThiDanhSach() {
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            for (NhanVien nv : danhSachNV) {
                nv.xuatThongTin();
                System.out.println("----------------------");
            }
        }
    }
}
