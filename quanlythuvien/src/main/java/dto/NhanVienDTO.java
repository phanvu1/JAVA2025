package dto;

public class NhanVienDTO {
    private int maNhanVien;
    private String tenNhanVien;
    private int namSinh;
    private String gioiTinh;
    private String soDienThoai;
    private String ngayBatDau;
    private double luong;
    private String diaChi;
    private int maTaiKhoan;

    // Constructors
    public NhanVienDTO() {}

    public NhanVienDTO(int maNhanVien, String tenNhanVien, int namSinh, String gioiTinh, String soDienThoai, 
                       String ngayBatDau, double luong, String diaChi, int maTaiKhoan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.luong = luong;
        this.diaChi = diaChi;
        this.maTaiKhoan = maTaiKhoan;
    }
    
        public NhanVienDTO(String tenNhanVien, int namSinh, String gioiTinh, String soDienThoai, 
                       String ngayBatDau, double luong, String diaChi, int maTaiKhoan) {
        this.tenNhanVien = tenNhanVien;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.luong = luong;
        this.diaChi = diaChi;
        this.maTaiKhoan = maTaiKhoan;
    }


    // Getters and Setters
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
}