package bus;

import dao.TaiKhoanDAO;
import dto.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {
    private TaiKhoanDAO taikhoandao;

    public TaiKhoanBUS() {
        this.taikhoandao = new TaiKhoanDAO();
    }

    // Kiểm tra tài khoản
    public int checkTaiKhoan(String username, String password) {
        return taikhoandao.checkTaiKhoan(username, password);
    }

    // Lấy tất cả tài khoản
    public ArrayList<TaiKhoanDTO> getAllTaiKhoan() {
        return taikhoandao.getAll();
    }

    // Thêm tài khoản mới
    public boolean addTaiKhoan(TaiKhoanDTO taikhoan) {
        return taikhoandao.insert(taikhoan);
    }

    // Cập nhật tài khoản
    public boolean updateTaiKhoan(TaiKhoanDTO taikhoan) {
        return taikhoandao.update(taikhoan);
    }

    // Xóa tài khoản
    public boolean deleteTaiKhoan(int mataikhoan) {
        return taikhoandao.delete(mataikhoan);
    }

    // Tìm kiếm tài khoản theo mã
    public TaiKhoanDTO getTaiKhoanById(int mataikhoan) {
        return taikhoandao.getById(mataikhoan);
    }

    public static TaiKhoanBUS iBus = null;

    public static TaiKhoanBUS gI() {
        if (iBus == null) {
            iBus = new TaiKhoanBUS();
        }
        return iBus;
    }
}