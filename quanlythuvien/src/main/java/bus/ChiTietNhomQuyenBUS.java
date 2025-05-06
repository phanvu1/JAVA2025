package bus;

import dao.ChiTietNhomQuyenDAO;
import dto.ChiTietNhomQuyenDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        return dao.kiemTraQuyen(idNhomQuyen, idDanhMucChucNang);
    }

    public boolean deleteByIdNhomQuyen(int idnhomquyen) {
            return dao.deleteByIdNhomQuyen(idnhomquyen);
    }
    
    public boolean update(ChiTietNhomQuyenDTO ct) {
        try {
            boolean success = dao.update(ct);
            if (!success) {
                JOptionPane.showMessageDialog(null, "Cập nhật chi tiết nhóm quyền thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật chi tiết nhóm quyền: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public static ChiTietNhomQuyenBUS iBus = null;

    public static ChiTietNhomQuyenBUS gI() {
        if (iBus == null) {
            iBus = new ChiTietNhomQuyenBUS();
        }
        return iBus;
    }
}