package Object;

import java.util.Scanner;

// Lớp đối tượng TheThuVien
public class TheThuVien {
    private int mathetv;
    private String ngaybd;
    private String ngayhh;
    private String ghichu;

    // Constructor mặc định
    public TheThuVien() {}

    // Constructor đầy đủ
    public TheThuVien(int mathetv, String ngaybd, String ngayhh, String ghichu) {
        this.mathetv = mathetv;
        this.ngaybd = ngaybd;
        this.ngayhh = ngayhh;
        this.ghichu = ghichu;
    }

    // Getters và Setters
    public int getMathetv() { return mathetv; }
    public void setMathetv(int mathetv) { this.mathetv = mathetv; }
    public String getNgaybd() { return ngaybd; }
    public void setNgaybd(String ngaybd) { this.ngaybd = ngaybd; }
    public String getNgayhh() { return ngayhh; }
    public void setNgayhh(String ngayhh) { this.ngayhh = ngayhh; }
    public String getGhichu() { return ghichu; }
    public void setGhichu(String ghichu) { this.ghichu = ghichu; }

    // Nhập thông tin thẻ thư viện
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thẻ thư viện: ");
        mathetv = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập ngày bắt đầu: ");
        ngaybd = sc.nextLine();
        System.out.print("Nhập ngày hết hạn: ");
        ngayhh = sc.nextLine();
        System.out.print("Nhập ghi chú: ");
        ghichu = sc.nextLine();
    }

    // Xuất thông tin thẻ thư viện
    public void xuatThongTin() {
        System.out.println("Mã thẻ thư viện: " + mathetv);
        System.out.println("Ngày bắt đầu: " + ngaybd);
        System.out.println("Ngày hết hạn: " + ngayhh);
        System.out.println("Ghi chú: " + ghichu);
    }
}
