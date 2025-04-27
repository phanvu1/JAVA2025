package dto;

public class NhaXuatBanDTO{
    private int maNXB;
    private String tenNXB;
    private String diaChi;
    private String sdt;
    
    public NhaXuatBanDTO() {
    }
    
    public NhaXuatBanDTO (int maNXB, String tenNXB, String diaChi, String sdt){
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this. diaChi = diaChi;
        this.sdt = sdt;
    }
    
    public NhaXuatBanDTO (String tenNXB, String diaChi, String sdt){
        this.tenNXB = tenNXB;
        this. diaChi = diaChi;
        this.sdt = sdt;
    }
    
    //getter, setter
    public int getMaNXB(){
        return maNXB;
    }
    public void setMaNXB(int maNXB){}
    
    public String getTenNXB(){
        return tenNXB;
    }
    public void setTenNXB(String tenNXB){}
    
    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){}
    
    public String getSDT(){
        return sdt;
    }
    public void setSDT(String sdt){}
}