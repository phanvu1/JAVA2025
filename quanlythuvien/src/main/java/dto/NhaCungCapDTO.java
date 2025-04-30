package dto;

public class NhaCungCapDTO {
    private int mancc;
    private String tenncc;

    // Constructor mặc định
    public NhaCungCapDTO() {
    }

    // Constructor đầy đủ tham số
    public NhaCungCapDTO(int mancc, String tenncc) {
        this.mancc = mancc;
        this.tenncc = tenncc;
    }

    // Phương thức thiết lập từ một NhaCungCapDTO khác
    public void setFromNhaCungCapDTO(NhaCungCapDTO other) {
        if (other != null) {
            this.mancc = other.mancc;
            this.tenncc = other.tenncc;
        }
    }

    // Getter và Setter cho mancc
    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    // Getter và Setter cho tenncc
    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }
}
