package dto;

public class DanhMucChucNangDTO {
    private int iddanhmucchucnang;
    private String tenchucnang;
    private int trangthai;

    public DanhMucChucNangDTO() {}

    public DanhMucChucNangDTO(int iddanhmucchucnang, String tenchucnang, int trangthai) {
        this.iddanhmucchucnang = iddanhmucchucnang;
        this.tenchucnang = tenchucnang;
        this.trangthai = trangthai;
    }

    public int getIddanhmucchucnang() {
        return iddanhmucchucnang;
    }

    public void setIddanhmucchucnang(int iddanhmucchucnang) {
        this.iddanhmucchucnang = iddanhmucchucnang;
    }

    public String getTenchucnang() {
        return tenchucnang;
    }

    public void setTenchucnang(String tenchucnang) {
        this.tenchucnang = tenchucnang;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
