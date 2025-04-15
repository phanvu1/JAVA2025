package entity;

import java.util.Scanner;
import jakarta.persistence.*;

@Entity
// Lớp TacGia
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matacgia;
    
    private String tentacgia;
    private int namsinh;
    private String quequan;

    // Constructors
    public TacGia() {}

    public TacGia(int matacgia, String tentacgia, int namsinh, String quequan) {
        this.matacgia = matacgia;
        this.tentacgia = tentacgia;
        this.namsinh = namsinh;
        this.quequan = quequan;
    }

    // Getters and Setters
    public int getMatacgia() { return matacgia; }
    public void setMatacgia(int matacgia) { this.matacgia = matacgia; }

    public String getTentacgia() { return tentacgia; }
    public void setTentacgia(String tentacgia) { this.tentacgia = tentacgia; }

    public int getNamsinh() { return namsinh; }
    public void setNamsinh(int namsinh) { this.namsinh = namsinh; }

    public String getQuequan() { return quequan; }
    public void setQuequan(String quequan) { this.quequan = quequan; }

    // Input and Output Methods
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tác giả: ");
        this.matacgia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên tác giả: ");
        this.tentacgia = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        this.namsinh = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập quê quán: ");
        this.quequan = scanner.nextLine();
    }

    public void hienThi() {
        System.out.println("Mã tác giả: " + matacgia);
        System.out.println("Tên tác giả: " + tentacgia);
        System.out.println("Năm sinh: " + namsinh);
        System.out.println("Quê quán: " + quequan);
    }
}
