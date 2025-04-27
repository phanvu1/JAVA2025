package dto;

public class NhanVienDTO {
    private int maNV;         
    private String tenNV;     
    private String gioiTinh;  
    private int namSinh;      
    private String diaChi;    
    private String sdt;       
    
    // Constructor mặc định
    public NhanVienDTO() {
    }

    // Constructor đầy đủ tham số
    public NhanVienDTO(int maNV, String tenNV, String gioiTinh, int namSinh, String diaChi, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // Constructor không có mã nhân viên (dùng khi thêm mới, vì maNV có thể auto tăng)
    public NhanVienDTO(String tenNV, String gioiTinh, int namSinh, String diaChi, String sdt) {
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // Getter và Setter
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }
}
