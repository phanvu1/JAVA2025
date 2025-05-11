package dto;

public class PhatDTO {
    private int idphieumuon;
    private double sotienphat;
    private String lydo;

    // Constructor mặc định
    public PhatDTO() {
    }

    // Constructor đầy đủ tham số
    public PhatDTO(int idphieumuon, double sotienphat, String lydo) {
        this.idphieumuon = idphieumuon;
        this.sotienphat = sotienphat;
        this.lydo = lydo;
    }

    // Phương thức thiết lập từ một PhatDTO khác
    public void setFromPhatDTO(PhatDTO other) {
        if (other != null) {
            this.idphieumuon = other.idphieumuon;
            this.sotienphat = other.sotienphat;
            this.lydo = other.lydo;
        }
    }

    // Getter và Setter cho idphieumuon
    public int getIdphieumuon() {
        return idphieumuon;
    }

    public void setIdphieumuon(int idphieumuon) {
        this.idphieumuon = idphieumuon;
    }

    // Getter và Setter cho sotienphat
    public double getSotienphat() {
        return sotienphat;
    }

    public void setSotienphat(double sotienphat) {
        this.sotienphat = sotienphat;
    }

    // Getter và Setter cho lydo
    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }
}