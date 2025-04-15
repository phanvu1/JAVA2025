package entity;

import java.util.Scanner;
import jakarta.persistence.*;

@Entity
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masach;
    
    
    private String tensach;
    private int maloai;
    private int manxb;
    private int matacgia;
    private int namxb;
    private int soluong;
    private int makesach;
    private String hinhanh;

    // Constructors
    public Sach() {}

    public Sach(int masach, String tensach, int maloai, int manxb, int matacgia, int namxb, int soluong, int makesach, String hinhanh) {
        this.masach = masach;
        this.tensach = tensach;
        this.maloai = maloai;
        this.manxb = manxb;
        this.matacgia = matacgia;
        this.namxb = namxb;
        this.soluong = soluong;
        this.makesach = makesach;
        this.hinhanh = hinhanh;
    }

    // Getters and Setters
    public int getMasach() { return masach; }
    public void setMasach(int masach) { this.masach = masach; }

    public String getTensach() { return tensach; }
    public void setTensach(String tensach) { this.tensach = tensach; }

    public int getMaloai() { return maloai; }
    public void setMaloai(int maloai) { this.maloai = maloai; }

    public int getManxb() { return manxb; }
    public void setManxb(int manxb) { this.manxb = manxb; }

    public int getMatacgia() { return matacgia; }
    public void setMatacgia(int matacgia) { this.matacgia = matacgia; }

    public int getNamxb() { return namxb; }
    public void setNamxb(int namxb) { this.namxb = namxb; }

    public int getSoluong() { return soluong; }
    public void setSoluong(int soluong) { this.soluong = soluong; }

    public int getMakesach() { return makesach; }
    public void setMakesach(int makesach) { this.makesach = makesach; }

    public String getHinhanh() { return hinhanh; }
    public void setHinhanh(String hinhanh) { this.hinhanh = hinhanh; }

    // Input/Output methods
    public void nhapSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        this.masach = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập tên sách: ");
        this.tensach = scanner.nextLine();
        System.out.print("Nhập mã loại: ");
        this.maloai = scanner.nextInt();
        System.out.print("Nhập mã nhà xuất bản: ");
        this.manxb = scanner.nextInt();
        System.out.print("Nhập mã tác giả: ");
        this.matacgia = scanner.nextInt();
        System.out.print("Nhập năm xuất bản: ");
        this.namxb = scanner.nextInt();
        System.out.print("Nhập số lượng: ");
        this.soluong = scanner.nextInt();
        System.out.print("Nhập mã kệ sách: ");
        this.makesach = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập đường dẫn hình ảnh: ");
        this.hinhanh = scanner.nextLine();
    }

    public void hienThiSach() {
        System.out.println("Mã sách: " + masach);
        System.out.println("Tên sách: " + tensach);
        System.out.println("Mã loại: " + maloai);
        System.out.println("Mã nhà xuất bản: " + manxb);
        System.out.println("Mã tác giả: " + matacgia);
        System.out.println("Năm xuất bản: " + namxb);
        System.out.println("Số lượng: " + soluong);
        System.out.println("Mã kệ sách: " + makesach);
        System.out.println("Hình ảnh: " + hinhanh);
    }
}
