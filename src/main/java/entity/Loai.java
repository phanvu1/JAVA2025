package entity;

import java.util.Scanner;
import jakarta.persistence.*;

@Entity

// Lớp Loai
public class Loai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maloai;
    
    private String tenloai;

    // Constructors
    public Loai() {}

    public Loai(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    // Getters and Setters
    public int getMatheloai() { return maloai; }
    public void setMatheloai(int maloai) { this.maloai = maloai; }

    public String getTentheloai() { return tenloai; }
    public void setTentheloai(String tenloai) { this.tenloai = tenloai; }

    // Input and Output Methods
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã thể loại: ");
        this.maloai = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên thể loại: ");
        this.tenloai = scanner.nextLine();
    }

    public void hienThi() {
        System.out.println("Mã loại: " + maloai);
        System.out.println("Tên loại: " + tenloai);
    }
}
