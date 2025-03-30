package Object;

import java.util.Scanner;

// Lớp đối tượng KeSach
public class KeSach {
    private int makesach;
    private String vitri;

    // Constructor mặc định
    public KeSach() {}

    // Constructor đầy đủ
    public KeSach(int makesach, String vitri) {
        this.makesach = makesach;
        this.vitri = vitri;
    }

    // Getters và Setters
    public int getMakesach() {
        return makesach;
    }

    public void setMakesach(int makesach) {
        this.makesach = makesach;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã kệ sách: ");
        makesach = scanner.nextInt();
        scanner.nextLine(); // Xử lý trôi lệnh
        System.out.print("Nhập vị trí kệ sách: ");
        vitri = scanner.nextLine();
    }

    // Phương thức xuất dữ liệu
    public void xuat() {
        System.out.println("Mã kệ sách: " + makesach);
        System.out.println("Vị trí kệ sách: " + vitri);
    }
}
