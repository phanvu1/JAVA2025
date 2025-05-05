package dto;

public class NhomQuyenDTO {
    private int idnhomquyen;
    private String tennhomquyen;
    private String mota;

    public NhomQuyenDTO() {}

    public NhomQuyenDTO(int idnhomquyen, String tennhomquyen, String mota) {
        this.idnhomquyen = idnhomquyen;
        this.tennhomquyen = tennhomquyen;
        this.mota = mota;
    }

    public int getIdnhomquyen() {
        return idnhomquyen;
    }

    public void setIdnhomquyen(int idnhomquyen) {
        this.idnhomquyen = idnhomquyen;
    }

    public String getTennhomquyen() {
        return tennhomquyen;
    }

    public void setTennhomquyen(String tennhomquyen) {
        this.tennhomquyen = tennhomquyen;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
