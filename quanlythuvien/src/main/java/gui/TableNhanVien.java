package gui;

import bus.NhanVienBUS;
import dto.NhanVienDTO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TableNhanVien extends JFrame {

    private JPanel contentPane;
    private JTable tablenhanvien;
    private JTextField txttim;
    private DefaultTableModel dtmnhanvien;

    /**
     * Create the frame.
     */
    public TableNhanVien() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 863, 497);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 194, 775, 195);
        contentPane.add(scrollPane);

        dtmnhanvien = new DefaultTableModel();
        dtmnhanvien.addColumn("Mã");
        dtmnhanvien.addColumn("Họ Tên");
        dtmnhanvien.addColumn("Năm Sinh");
        dtmnhanvien.addColumn("Giới Tính");
        dtmnhanvien.addColumn("Địa Chỉ");
        dtmnhanvien.addColumn("SĐT");
        tablenhanvien = new MyTable(dtmnhanvien);

        scrollPane.setViewportView(tablenhanvien);

        JLabel lblNewLabel = new JLabel("Nhân Viên");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(379, 13, 107, 32);
        contentPane.add(lblNewLabel);

        txttim = new JTextField();
        txttim.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttim.setBounds(122, 72, 581, 48);
        contentPane.add(txttim);
        txttim.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Tìm");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(35, 72, 56, 48);
        contentPane.add(lblNewLabel_1);

        JButton btntimnv = new JButton("Tìm");
        btntimnv.setFont(new Font("Tahoma", Font.BOLD, 15));
        btntimnv.setBounds(715, 78, 95, 37);
        btntimnv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchNhanVien();
            }
        });
        contentPane.add(btntimnv);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLuu.setBounds(686, 411, 124, 38);
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = tablenhanvien.getSelectedRow();
                if (i >= 0) {
                    String maNhanVien = dtmnhanvien.getValueAt(i, 0).toString();
                    MainFrame.txtManhanvienphieunhap.setText(maNhanVien);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn nhân viên trong bảng");
                }
            }
        });
        contentPane.add(btnLuu);

        JButton btnDong = new JButton("Đóng");
        btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDong.setBounds(546, 411, 124, 38);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnDong);

        loadNhanVien();
        setLocationRelativeTo(null);
    }

    private static ArrayList<NhanVienDTO> nhanVienList = new ArrayList<NhanVienDTO>();

    public void loadNhanVien() {
        nhanVienList = null;
        dtmnhanvien.setRowCount(0);
        nhanVienList = NhanVienBUS.getInstance().getAllNhanVien();
        for (NhanVienDTO nv : nhanVienList) {
            dtmnhanvien.addRow(new Object[]{
                nv.getMaNhanVien(),
                nv.getTenNhanVien(),
                nv.getNamSinh(),
                nv.getGioiTinh(),
                nv.getDiaChi(),
                nv.getSoDienThoai()
            });
        }
    }

    public void searchNhanVien() {
        String searchText = txttim.getText().trim().toLowerCase();
        dtmnhanvien.setRowCount(0);
        for (NhanVienDTO nv : nhanVienList) {
            if (nv.getTenNhanVien().toLowerCase().contains(searchText) ||
                String.valueOf(nv.getMaNhanVien()).contains(searchText)) {
                dtmnhanvien.addRow(new Object[]{
                    nv.getMaNhanVien(),
                    nv.getTenNhanVien(),
                    nv.getNamSinh(),
                    nv.getGioiTinh(),
                    nv.getDiaChi(),
                    nv.getSoDienThoai()
                });
            }
        }
    }
}