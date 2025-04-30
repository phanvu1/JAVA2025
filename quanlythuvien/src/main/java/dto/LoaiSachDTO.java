package dto;

public class LoaiSachDTO {
    private int maloai;
    private String tenloai;

    // Constructor mặc định
    public LoaiSachDTO() {
    }

    // Constructor đầy đủ tham số
    public LoaiSachDTO(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    // Phương thức thiết lập từ một LoaiSachDTO khác
    public void setFromLoaiSachDTO(LoaiSachDTO other) {
        if (other != null) {
            this.maloai = other.maloai;
            this.tenloai = other.tenloai;
        }
    }

    // Getter và Setter cho maloai
    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    // Getter và Setter cho tenloai
    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
}