package bus;

import dao.*;
import dto.NhanVienDTO;
import java.sql.Connection;
import java.util.ArrayList;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO;
    private static NhanVienBUS instance; // Singleton instance

    public NhanVienBUS(Connection connection) {
        this.nhanVienDAO = new NhanVienDAO(connection);
    }
    
    private NhanVienBUS() {
        Connection conn = DBConnect.getConnection(); // Kết nối cơ sở dữ liệu
        this.nhanVienDAO = new NhanVienDAO(conn);
    }
    
    // Singleton Pattern: Lấy instance duy nhất
    public static NhanVienBUS getInstance() {
        if (instance == null) {
            instance = new NhanVienBUS();
        }
        return instance;
    }

    public ArrayList<NhanVienDTO> getAllNhanVien() {
        return nhanVienDAO.getAllNhanVien();
    }

    public boolean addNhanVien(NhanVienDTO nhanVien) {
        return nhanVienDAO.addNhanVien(nhanVien);
    }

    public boolean updateNhanVien(NhanVienDTO nhanVien) {
        return nhanVienDAO.updateNhanVien(nhanVien);
    }

    public boolean deleteNhanVien(int maNhanVien) {
        return nhanVienDAO.deleteNhanVien(maNhanVien);
    }
    
    public NhanVienDTO findById(int maNhanVien){
        return nhanVienDAO.findById(maNhanVien);
    }
}