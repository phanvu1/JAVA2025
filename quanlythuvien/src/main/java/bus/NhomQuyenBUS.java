package bus;

import dao.NhomQuyenDAO;
import dto.NhomQuyenDTO;
import java.util.ArrayList;

public class NhomQuyenBUS {
    private NhomQuyenDAO dao;

    public NhomQuyenBUS() {
        this.dao = new NhomQuyenDAO();
    }

    public ArrayList<NhomQuyenDTO> getAllNhomQuyen() {
        return dao.getAll();
    }

    public boolean addNhomQuyen(NhomQuyenDTO nq) {
        return dao.insert(nq);
    }

    public boolean updateNhomQuyen(NhomQuyenDTO nq) {
        return dao.update(nq);
    }

    public boolean deleteNhomQuyen(int id) {
        return dao.delete(id);
    }

    public NhomQuyenDTO getNhomQuyenById(int id) {
        return dao.getById(id);
    }

    public static NhomQuyenBUS iBus = null;

    public static NhomQuyenBUS gI() {
        if (iBus == null) {
            iBus = new NhomQuyenBUS();
        }
        return iBus;
    }
}
