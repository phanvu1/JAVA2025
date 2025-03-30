package Object;

import java.util.Scanner;

// Lớp đối tượng NhaCungCap
public class NhaCungCap {
    private int mancc;
    private String tenncc;

    // Constructor mặc định
    public NhaCungCap() {}

    // Constructor đầy đủ
    public NhaCungCap(int mancc, String tenncc) {
        this.mancc = mancc;
        this.tenncc = tenncc;
    }

    // Getters và Setters
    public int getMancc() { return mancc; }
    public void setMancc(int mancc) { this.mancc = mancc; }
    public String getTenncc() { return tenncc; }
    public void setTenncc(String tenncc) { this.tenncc = tenncc; }

    // Nhập thông tin nhà cung cấp
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp: ");
        mancc = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        tenncc = sc.nextLine();
    }

    // Xuất thông tin nhà cung cấp
    public void xuatThongTin() {
        System.out.println("Mã nhà cung cấp: " + mancc);
        System.out.println("Tên nhà cung cấp: " + tenncc);
    }
}
