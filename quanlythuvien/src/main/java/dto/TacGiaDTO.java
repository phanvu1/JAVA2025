package dto;

public class TacGiaDTO {
    private int maTacGia;
    private String tenTacGia;
    private int namSinh;
    private String queQuan;

    // Constructor mặc định
    public TacGiaDTO() {
    }

    // Constructor đầy đủ tham số
    public TacGiaDTO(int maTacGia, String tenTacGia, int namSinh, String queQuan) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }

    // Constructor không có mã tác giả (dùng khi thêm mới)
    public TacGiaDTO(String tenTacGia, int namSinh, String queQuan) {
        this.tenTacGia = tenTacGia;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }

    // Getter và Setter
    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
}