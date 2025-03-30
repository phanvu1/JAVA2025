package Object;

import java.util.Scanner;

// Lớp đối tượng NhaXuatBan
public class NhaXuatBan {
    private int manxb;
    private String tennxb;
    private String diachi;
    private String sdt;

    // Constructor mặc định
    public NhaXuatBan() {}

    // Constructor đầy đủ
    public NhaXuatBan(int manxb, String tennxb, String diachi, String sdt) {
        this.manxb = manxb;
        this.tennxb = tennxb;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    // Getter và Setter
    public int getManxb() {
        return manxb;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    public String getTennxb() {
        return tennxb;
    }

    public void setTennxb(String tennxb) {
        this.tennxb = tennxb;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Phương thức nhập thông tin nhà xuất bản
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NXB: ");
        this.manxb = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên NXB: ");
        this.tennxb = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diachi = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.sdt = sc.nextLine();
    }

    // Phương thức xuất thông tin nhà xuất bản
    public void xuat() {
        System.out.println("Mã NXB: " + this.manxb);
        System.out.println("Tên NXB: " + this.tennxb);
        System.out.println("Địa chỉ: " + this.diachi);
        System.out.println("Số điện thoại: " + this.sdt);
    }
}
