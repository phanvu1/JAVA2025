package ui;

import entity.ChiTietPhieuNhap;
import entity.DocGia;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.PhieuNhap;
import entity.TheThuVien;

public class Test {
    public static void main(String[] args) {
        // Test NhaCungCap
        System.out.println("=== Test NhaCungCap ===");
        NhaCungCap ncc = new NhaCungCap();
        ncc.nhapThongTin();
        System.out.println("Thông tin vừa nhập:");
        ncc.xuatThongTin();
        NhaCungCap nccCopy = new NhaCungCap(ncc);
        System.out.println("Thông tin bản sao:");
        nccCopy.xuatThongTin();

        // Test TheThuVien
        System.out.println("\n=== Test TheThuVien ===");
        TheThuVien the = new TheThuVien();
        the.nhapThongTin();
        System.out.println("Thông tin vừa nhập:");
        the.xuatThongTin();
        TheThuVien theCopy = new TheThuVien(the);
        System.out.println("Thông tin bản sao:");
        theCopy.xuatThongTin();

        // Test PhieuNhap
        System.out.println("\n=== Test PhieuNhap ===");
        PhieuNhap pn = new PhieuNhap();
        pn.nhapThongTin();
        System.out.println("Thông tin vừa nhập:");
        pn.xuatThongTin();
        PhieuNhap pnCopy = new PhieuNhap(pn);
        System.out.println("Thông tin bản sao:");
        pnCopy.xuatThongTin();

        // Test NhaXuatBan
        System.out.println("\n=== Test NhaXuatBan ===");
        NhaXuatBan nxb = new NhaXuatBan();
        nxb.nhap();
        System.out.println("Thông tin vừa nhập:");
        nxb.xuat();
        NhaXuatBan nxbCopy = new NhaXuatBan(nxb);
        System.out.println("Thông tin bản sao:");
        nxbCopy.xuat();

        // Test DocGia
        System.out.println("\n=== Test DocGia ===");
        DocGia dg = new DocGia();
        dg.nhapThongTin();
        System.out.println("Thông tin vừa nhập:");
        dg.xuatThongTin();
        DocGia dgCopy = new DocGia(dg);
        System.out.println("Thông tin bản sao:");
        dgCopy.xuatThongTin();

        // Test ChiTietPhieuNhap
        System.out.println("\n=== Test ChiTietPhieuNhap ===");
        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
        ctpn.nhapThongTin();
        System.out.println("Thông tin vừa nhập:");
        ctpn.xuatThongTin();
        ChiTietPhieuNhap ctpnCopy = new ChiTietPhieuNhap(ctpn);
        System.out.println("Thông tin bản sao:");
        ctpnCopy.xuatThongTin();
    }
}