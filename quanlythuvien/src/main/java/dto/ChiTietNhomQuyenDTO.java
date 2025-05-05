package dto;

public class ChiTietNhomQuyenDTO {
    private int idnhomquyen;
    private int iddanhmucchucnang;
    private String hanhdong;

    public ChiTietNhomQuyenDTO() {}

    public ChiTietNhomQuyenDTO(int idnhomquyen, int iddanhmucchucnang, String hanhdong) {
        this.idnhomquyen = idnhomquyen;
        this.iddanhmucchucnang = iddanhmucchucnang;
        this.hanhdong = hanhdong;
    }

    public int getIdnhomquyen() {
        return idnhomquyen;
    }

    public void setIdnhomquyen(int idnhomquyen) {
        this.idnhomquyen = idnhomquyen;
    }

    public int getIddanhmucchucnang() {
        return iddanhmucchucnang;
    }

    public void setIddanhmucchucnang(int iddanhmucchucnang) {
        this.iddanhmucchucnang = iddanhmucchucnang;
    }

    public String getHanhdong() {
        return hanhdong;
    }

    public void setHanhdong(String hanhdong) {
        this.hanhdong = hanhdong;
    }
}
