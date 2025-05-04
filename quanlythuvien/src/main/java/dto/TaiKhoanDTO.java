package dto;

public class TaiKhoanDTO {
    private int mataikhoan;
    private String username;
    private String password;
    private Integer idnhomquyen;

    // Constructor mặc định
    public TaiKhoanDTO() {
    }

    // Constructor đầy đủ tham số
    public TaiKhoanDTO(int mataikhoan, String username, String password, Integer idnhomquyen) {
        this.mataikhoan = mataikhoan;
        this.username = username;
        this.password = password;
        this.idnhomquyen = idnhomquyen;
    }

    // Constructor với 3 tham số (không có mataikhoan, gán mặc định mataikhoan = 0)
    public TaiKhoanDTO(String username, String password, Integer idnhomquyen) {
        this.mataikhoan = 0;
        this.username = username;
        this.password = password;
        this.idnhomquyen = idnhomquyen;
    }

    // Phương thức thiết lập từ một TaiKhoanDTO khác
    public void setFromTaiKhoanDTO(TaiKhoanDTO other) {
        if (other != null) {
            this.mataikhoan = other.mataikhoan;
            this.username = other.username;
            this.password = other.password;
            this.idnhomquyen = other.idnhomquyen;
        }
    }

    // Getter và Setter cho mataikhoan
    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và Setter cho idnhomquyen
    public Integer getIdnhomquyen() {
        return idnhomquyen;
    }

    public void setIdnhomquyen(Integer idnhomquyen) {
        this.idnhomquyen = idnhomquyen;
    }
}