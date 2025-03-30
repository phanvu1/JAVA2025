package Object;

import java.util.Scanner;

// Lớp đối tượng DocGia
public class DocGia {
    private int madocgia;
    private String tendg;
    private String gioitinh;
    private String diachi;
    private int mathe;

    // Constructor mặc định
    public DocGia() {}

    // Constructor đầy đủ
    public DocGia(int madocgia, String tendg, String gioitinh, String diachi, int mathe) {
        this.madocgia = madocgia;
        this.tendg = tendg;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.mathe = mathe;
    }

    // Getters và Setters
    public int getMadocgia() { return madocgia; }
    public void setMadocgia(int madocgia) { this.madocgia = madocgia; }
    public String getTendg() { return tendg; }
    public void setTendg(String tendg) { this.tendg = tendg; }
    public String getGioitinh() { return gioitinh; }
    public void setGioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }
    public int getMathe() { return mathe; }
    public void setMathe(int mathe) { this.mathe = mathe; }

    // Nhập thông tin độc giả
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã độc giả: ");
        madocgia = sc.nextInt();
        sc.nextLine(); // Loại bỏ dòng thừa
        System.out.print("Nhập tên độc giả: ");
        tendg = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioitinh = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diachi = sc.nextLine();
        System.out.print("Nhập mã thẻ: ");
        mathe = sc.nextInt();
    }

    // Xuất thông tin độc giả
    public void xuatThongTin() {
        System.out.println("Mã độc giả: " + madocgia);
        System.out.println("Tên độc giả: " + tendg);
        System.out.println("Giới tính: " + gioitinh);
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("Mã thẻ: " + mathe);
    }
}
