```java

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

// DTO
public class PhieuNhapDTO {
    private int id;
    private String maNhanVien;
    private String maNCC;
    private String ngayNhap;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int id, String maNhanVien, String maNCC, String ngayNhap) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}

// Data Access Layer
class PhieuNhapDAO {
    private List<PhieuNhapDTO> mockDatabase = new ArrayList<>();

    public PhieuNhapDAO() {
        mockDatabase.add(new PhieuNhapDTO(1, "NV001", "NCC001", "2025-04-20"));
        mockDatabase.add(new PhieuNhapDTO(2, "NV002", "NCC002", "2025-04-21"));
    }

    public boolean savePhieuNhap(PhieuNhapDTO dto) {
        int newId = mockDatabase.size() + 1;
        dto.setId(newId);
        mockDatabase.add(dto);
        System.out.println("Lưu: " + dto.getId() + ", " + dto.getMaNhanVien() + ", " +
                dto.getMaNCC() + ", " + dto.getNgayNhap());
        return true;
    }

    public boolean updatePhieuNhap(PhieuNhapDTO dto) {
        for (int i = 0; i < mockDatabase.size(); i++) {
            if (mockDatabase.get(i).getId() == dto.getId()) {
                mockDatabase.set(i, dto);
                System.out.println("Sửa: " + dto.getId() + ", " + dto.getMaNhanVien() + ", " +
                        dto.getMaNCC() + ", " + dto.getNgayNhap());
                return true;
            }
        }
        return false;
    }

    public boolean deletePhieuNhap(int id) {
        for (int i = 0; i < mockDatabase.size(); i++) {
            if (mockDatabase.get(i).getId() == id) {
                mockDatabase.remove(i);
                System.out.println("Xóa: " + id);
                return true;
            }
        }
        return false;
    }

    public List<PhieuNhapDTO> getAllPhieuNhap() {
        return new ArrayList<>(mockDatabase);
    }

    public boolean savePhieuNhapNoDTO(String maNhanVien, String maNCC, String ngayNhap) {
        PhieuNhapDTO dto = new PhieuNhapDTO(0, maNhanVien, maNCC, ngayNhap);
        return savePhieuNhap(dto);
    }
}

// Business Logic Layer
class PhieuNhapService {
    private PhieuNhapDAO dao;

    public PhieuNhapService() {
        dao = new PhieuNhapDAO();
    }

    public boolean themPhieuNhap(PhieuNhapDTO dto) {
        if (dto.getMaNhanVien() == null || dto.getMaNhanVien().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }
        if (dto.getMaNCC() == null || dto.getMaNCC().isEmpty()) {
            throw new IllegalArgumentException("Mã NCC không được để trống");
        }
        if (dto.getNgayNhap() == null || dto.getNgayNhap().isEmpty()) {
            throw new IllegalArgumentException("Ngày nhập không được để trống");
        }
        return dao.savePhieuNhap(dto);
    }

    public boolean suaPhieuNhap(PhieuNhapDTO dto) {
        if (dto.getId() <= 0) {
            throw new IllegalArgumentException("ID không hợp lệ");
        }
        if (dto.getMaNhanVien() == null || dto.getMaNhanVien().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }
        if (dto.getMaNCC() == null || dto.getMaNCC().isEmpty()) {
            throw new IllegalArgumentException("Mã NCC không được để trống");
        }
        if (dto.getNgayNhap() == null || dto.getNgayNhap().isEmpty()) {
            throw new IllegalArgumentException("Ngày nhập không được để trống");
        }
        return dao.updatePhieuNhap(dto);
    }

    public boolean xoaPhieuNhap(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID không hợp lệ");
        }
        return dao.deletePhieuNhap(id);
    }

    public List<PhieuNhapDTO> getAllPhieuNhap() {
        return dao.getAllPhieuNhap();
    }

    public boolean themPhieuNhapNoDTO(String maNhanVien, String maNCC, String ngayNhap) {
        if (maNhanVien == null || maNhanVien.isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }
        if (maNCC == null || maNCC.isEmpty()) {
            throw new IllegalArgumentException("Mã NCC không được để trống");
        }
        if (ngayNhap == null || ngayNhap.isEmpty()) {
            throw new IllegalArgumentException("Ngày nhập không được để trống");
        }
        return dao.savePhieuNhapNoDTO(maNhanVien, maNCC, ngayNhap);
    }
}

// Presentation Layer
class PhieuNhapPanel {
    private JPanel panel;
    private JTextField txtId;
    private JTextField txtMaNhanVien;
    private JTextField txtMaNCC;
    private JDateChooser ngayNhap;
    private JTable table;
    private DefaultTableModel tableModel;
    private PhieuNhapService service;

    public PhieuNhapPanel() {
        service = new PhieuNhapService();

        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Phiếu Nhập"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(10);
        txtId.setEditable(false);
        panel.add(txtId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Mã Nhân Viên"), gbc);
        gbc.gridx = 1;
        txtMaNhanVien = new JTextField(10);
        panel.add(txtMaNhanVien, gbc);
        gbc.gridx = 2;
        panel.add(new JButton("..."), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Mã NCC"), gbc);
        gbc.gridx = 1;
        txtMaNCC = new JTextField(10);
        panel.add(txtMaNCC, gbc);
        gbc.gridx = 2;
        panel.add(new JButton("..."), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Ngày Nhập"), gbc);
        gbc.gridx = 1;
        ngayNhap = new JDateChooser();
        ngayNhap.setDateFormatString("yyyy-MM-dd");
        ngayNhap.setDate(Calendar.getInstance().getTime());
        panel.add(ngayNhap, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(e -> themPhieuNhap());
        buttonPanel.add(btnThem);
        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(e -> suaPhieuNhap());
        buttonPanel.add(btnSua);
        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(e -> xoaPhieuNhap());
        buttonPanel.add(btnXoa);
        JButton btnTaiLai = new JButton("Tải Lại");
        btnTaiLai.addActionListener(e -> loadDataToTable());
        buttonPanel.add(btnTaiLai);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        panel.add(buttonPanel, gbc);

        tableModel = new DefaultTableModel(new Object[] { "ID", "Mã Nhân Viên", "Mã NCC", "Ngày Nhập" }, 0);
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                txtId.setText(tableModel.getValueAt(selectedRow, 0).toString());
                txtMaNhanVien.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtMaNCC.setText(tableModel.getValueAt(selectedRow, 2).toString());
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ngayNhap.setDate(sdf.parse(tableModel.getValueAt(selectedRow, 3).toString()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void themPhieuNhap() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PhieuNhapDTO dto = new PhieuNhapDTO(
                    0,
                    txtMaNhanVien.getText(),
                    txtMaNCC.getText(),
                    sdf.format(ngayNhap.getDate()));
            if (service.themPhieuNhap(dto)) {
                JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công!");
                clearForm();
                loadDataToTable();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống: " + ex.getMessage());
        }
    }

    private void suaPhieuNhap() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PhieuNhapDTO dto = new PhieuNhapDTO(
                    Integer.parseInt(txtId.getText()),
                    txtMaNhanVien.getText(),
                    txtMaNCC.getText(),
                    sdf.format(ngayNhap.getDate()));
            if (service.suaPhieuNhap(dto)) {
                JOptionPane.showMessageDialog(null, "Sửa phiếu nhập thành công!");
                clearForm();
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu nhập!");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống: " + ex.getMessage());
        }
    }

    private void xoaPhieuNhap() {
        try {
            int id = Integer.parseInt(txtId.getText());
            if (service.xoaPhieuNhap(id)) {
                JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thành công!");
                clearForm();
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu nhập!");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống: " + ex.getMessage());
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<PhieuNhapDTO> list = service.getAllPhieuNhap();
        for (PhieuNhapDTO dto : list) {
            tableModel.addRow(new Object[] {
                    dto.getId(),
                    dto.getMaNhanVien(),
                    dto.getMaNCC(),
                    dto.getNgayNhap()
            });
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtMaNhanVien.setText("");
        txtMaNCC.setText("");
        ngayNhap.setDate(Calendar.getInstance().getTime());
    }
}

// Main
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý phiếu nhập");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        PhieuNhapPanel panel = new PhieuNhapPanel();
        frame.add(panel.getPanel());
        frame.setVisible(true);

        panel.loadDataToTable();
    }
}```