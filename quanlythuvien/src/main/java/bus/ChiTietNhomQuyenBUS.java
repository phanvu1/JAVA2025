package bus;

import dao.ChiTietNhomQuyenDAO;
import dto.ChiTietNhomQuyenDTO;
import java.util.ArrayList;

public class ChiTietNhomQuyenBUS {
    private ChiTietNhomQuyenDAO dao;

    public ChiTietNhomQuyenBUS() {
        this.dao = new ChiTietNhomQuyenDAO();
    }

    public ArrayList<ChiTietNhomQuyenDTO> getAll() {
        return dao.getAll();
    }

    public boolean add(ChiTietNhomQuyenDTO ct) {
        return dao.insert(ct);
    }

    public boolean delete(int idnhomquyen, int iddanhmucchucnang) {
        return dao.delete(idnhomquyen, iddanhmucchucnang);
    }

    public ArrayList<ChiTietNhomQuyenDTO> getByNhomQuyen(int idnhomquyen) {
        return dao.getByIdNhomQuyen(idnhomquyen);
    }
    
     public boolean kiemTraQuyen(int idNhomQuyen, int idDanhMucChucNang) {
        return chiTietDAO.kiemTraQuyen(idNhomQuyen, idDanhMucChucNang);
    }

    public static ChiTietNhomQuyenBUS iBus = null;

    public static ChiTietNhomQuyenBUS gI() {
        if (iBus == null) {
            iBus = new ChiTietNhomQuyenBUS();
        }
        return iBus;
    }
}
