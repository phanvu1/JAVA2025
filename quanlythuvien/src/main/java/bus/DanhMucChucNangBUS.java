package bus;

import dao.DanhMucChucNangDAO;
import dto.DanhMucChucNangDTO;
import java.util.ArrayList;

public class DanhMucChucNangBUS {
    private DanhMucChucNangDAO dao;

    public DanhMucChucNangBUS() {
        this.dao = new DanhMucChucNangDAO();
    }

    public ArrayList<DanhMucChucNangDTO> getAll() {
        return dao.getAll();
    }

    public boolean add(DanhMucChucNangDTO dm) {
        return dao.insert(dm);
    }

    public boolean update(DanhMucChucNangDTO dm) {
        return dao.update(dm);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public static DanhMucChucNangBUS iBus = null;

    public static DanhMucChucNangBUS gI() {
        if (iBus == null) {
            iBus = new DanhMucChucNangBUS();
        }
        return iBus;
    }
}
