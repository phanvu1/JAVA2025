package dto;

public class KeSachDTO {
    private int makesach;
    private String vitri;

    // Constructor mặc định
    public KeSachDTO() {
    }

    // Constructor đầy đủ tham số
    public KeSachDTO(int makesach, String vitri) {
        this.makesach = makesach;
        this.vitri = vitri;
    }

    // Phương thức thiết lập từ một KeSachDTO khác
    public void setFromKeSachDTO(KeSachDTO other) {
        if (other != null) {
            this.makesach = other.makesach;
            this.vitri = other.vitri;
        }
    }

    // Getter và Setter cho makesach
    public int getMakesach() {
        return makesach;
    }

    public void setMakesach(int makesach) {
        this.makesach = makesach;
    }

    // Getter và Setter cho vitri
    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
}
