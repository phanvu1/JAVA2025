package dto;

public class ChiTietPhieuNhapDTO {
    private int maphieunhap;
    private int masach;
    private double gia;
    private int soluong;

    // Constructor mặc định
    public ChiTietPhieuNhapDTO() {
    }

    // Constructor đầy đủ tham số
    public ChiTietPhieuNhapDTO(int maphieunhap, int masach, double gia, int soluong) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.gia = gia;
        this.soluong = soluong;
    }

    // Phương thức thiết lập từ một ChiTietPhieuNhapDTO khác
    public void setFromChiTietPhieuNhapDTO(ChiTietPhieuNhapDTO other) {
        if (other != null) {
            this.maphieunhap = other.maphieunhap;
            this.masach = other.masach;
            this.gia = other.gia;
            this.soluong = other.soluong;
        }
    }

    // Getter và Setter cho maphieunhap
    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    // Getter và Setter cho masach
    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    // Getter và Setter cho gia
    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    // Getter và Setter cho soluong
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}