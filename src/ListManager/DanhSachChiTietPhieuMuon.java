package ListManager;

import java.util.*;
import java.text.*;
import Object.ChiTietPhieuMuon;

public class DanhSachChiTietPhieuMuon {
    private ArrayList<ChiTietPhieuMuon> danhSach;

    // Constructor
    public DanhSachChiTietPhieuMuon() {
        danhSach = new ArrayList<>();
    }

    // Thêm chi tiết phiếu mượn
    public void themChiTiet(ChiTietPhieuMuon ctpm) {
        danhSach.add(ctpm);
        System.out.println("Đã thêm chi tiết phiếu mượn thành công.");
    }

    // Xóa chi tiết phiếu mượn theo mã phiếu mượn và mã sách
    public void xoaChiTiet(int maphieumuon, int masach) {
        for (ChiTietPhieuMuon ctpm : danhSach) {
            if (ctpm.getMaphieumuon() == maphieumuon && ctpm.getMasach() == masach) {
                danhSach.remove(ctpm);
                System.out.println("Đã xóa chi tiết phiếu mượn thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết phiếu mượn cần xóa.");
    }

    // Tìm kiếm chi tiết phiếu mượn theo mã phiếu mượn
    public void timChiTiet(int maphieumuon) {
        boolean found = false;
        for (ChiTietPhieuMuon ctpm : danhSach) {
            if (ctpm.getMaphieumuon() == maphieumuon) {
                ctpm.xuatThongTin();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chi tiết phiếu mượn với mã: " + maphieumuon);
        }
    }

    // Hiển thị danh sách chi tiết phiếu mượn
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách chi tiết phiếu mượn trống.");
            return;
        }
        System.out.println("===== Danh Sách Chi Tiết Phiếu Mượn =====");
        for (ChiTietPhieuMuon ctpm : danhSach) {
            ctpm.xuatThongTin();
            System.out.println("----------------------");
        }
    }

    // Nhập danh sách chi tiết phiếu mượn từ bàn phím
    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng chi tiết phiếu mượn: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin chi tiết phiếu mượn thứ " + (i + 1) + ":");
            ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();

            System.out.print("Nhập mã phiếu mượn: ");
            ctpm.setMaphieumuon(scanner.nextInt());

            System.out.print("Nhập mã sách: ");
            ctpm.setMasach(scanner.nextInt());
            scanner.nextLine(); // Xóa dòng thừa

            System.out.print("Nhập ngày trả (yyyy-MM-dd): ");
            try {
                Date ngayTra = sdf.parse(scanner.nextLine());
                ctpm.setNgaytra(ngayTra);
            } catch (ParseException e) {
                System.out.println("Định dạng ngày không hợp lệ, vui lòng nhập lại.");
                i--;
                continue;
            }

            System.out.print("Nhập ghi chú: ");
            ctpm.setGhichu(scanner.nextLine());

            themChiTiet(ctpm);
        }
    }
}
