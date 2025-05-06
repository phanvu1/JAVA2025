package bus;

import dao.TaiKhoanDAO;
import dto.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {
    private TaiKhoanDAO taikhoandao;

    public TaiKhoanBUS() {
        this.taikhoandao = new TaiKhoanDAO();
    }

    public int checkTaiKhoan(String username, String password) {
        return taikhoandao.checkTaiKhoan(username, password);
    }

    public ArrayList<TaiKhoanDTO> getAllTaiKhoan() {
        return taikhoandao.getAll();
    }

    public boolean addTaiKhoan(TaiKhoanDTO taikhoan) {
        return taikhoandao.insert(taikhoan);
    }

    public boolean updateTaiKhoan(TaiKhoanDTO taikhoan) {
        return taikhoandao.update(taikhoan);
    }

    public boolean deleteTaiKhoan(int mataikhoan) {
        return taikhoandao.delete(mataikhoan);
    }

    public TaiKhoanDTO getTaiKhoanById(int mataikhoan) {
        return taikhoandao.getById(mataikhoan);
    }

    public boolean checkIdNhomQuyenExists(int idNhomQuyen) {
        return taikhoandao.checkIdNhomQuyenExists(idNhomQuyen);
    }

    public static TaiKhoanBUS iBus = null;

    public static TaiKhoanBUS gI() {
        if (iBus == null) {
            iBus = new TaiKhoanBUS();
        }
        return iBus;
    }
}