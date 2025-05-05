package bus;

import dao.*;
import dto.PhieuMuonDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class PhieuMuonBUS {
    private PhieuMuonDAO phieuMuonDAO;
    private static PhieuMuonBUS instance;

    public PhieuMuonBUS(Connection connection) {
        Connection conn = DBConnect.getConnection(); // Kết nối cơ sở dữ liệu
        this.phieuMuonDAO = new PhieuMuonDAO(conn);
    }
    
    // Singleton Pattern: Lấy instance duy nhất
    public static PhieuMuonBUS getInstance() {
        if (instance == null) {
            instance = new PhieuMuonBUS();
        }
        return instance;
    }

    private PhieuMuonBUS() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<PhieuMuonDTO> getAllPhieuMuon() {
        return phieuMuonDAO.findAll();
    }

    public PhieuMuonDTO getPhieuMuonById(int maPhieuMuon) {
        return phieuMuonDAO.findById(maPhieuMuon);
    }

    public boolean addPhieuMuon(PhieuMuonDTO phieuMuon) {
        return phieuMuonDAO.insert(phieuMuon);
    }

    public boolean updatePhieuMuon(PhieuMuonDTO phieuMuon) {
        return phieuMuonDAO.update(phieuMuon);
    }

    public boolean deletePhieuMuon(int maPhieuMuon) {
        return phieuMuonDAO.delete(maPhieuMuon);
    }
}