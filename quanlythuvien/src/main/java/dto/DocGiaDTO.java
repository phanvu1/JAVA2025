package dto;

public class DocGiaDTO {
    private int maDocGia;
    private String tenDocGia;
    private String gioiTinh;
    private String diaChi;
    private int maThe;

    // Constructor mặc định
    public DocGiaDTO() {
    }

    // Constructor đầy đủ tham số
    public DocGiaDTO(int maDocGia, String tenDocGia, String gioiTinh, String diaChi, int maThe) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.maThe = maThe;
    }

    // Constructor không có mã độc giả (dùng khi thêm mới)
    public DocGiaDTO(String tenDocGia, String gioiTinh, String diaChi, int maThe) {
        this.tenDocGia = tenDocGia;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.maThe = maThe;
    }

    public DocGiaDTO(int i, String tenDocGia, String gioiTinh, String soDienThoai, String diaChi) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getter và Setter
    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public Object getSoDienThoai() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}