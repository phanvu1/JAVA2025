package gui;

import bus.DanhMucChucNangBUS;
import dto.DanhMucChucNangDTO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TableDanhMucChucNang extends JFrame {

    private JPanel contentPane;
    private JTextField txtTim;
    private JTable table;
    private DefaultTableModel dtmDanhMuc;

    /**
     * Create the frame.
     */
    public TableDanhMucChucNang() {
        setTitle("Danh Mục Chức Năng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Danh Mục Chức Năng");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitle.setBounds(200, 13, 200, 35);
        contentPane.add(lblTitle);

        JLabel lblTim = new JLabel("Tìm");
        lblTim.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTim.setBounds(30, 80, 50, 35);
        contentPane.add(lblTim);

        txtTim = new JTextField();
        txtTim.setBounds(90, 74, 400, 49);
        contentPane.add(txtTim);
        txtTim.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTim.setBounds(500, 80, 80, 35);
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDanhMuc();
            }
        });
        contentPane.add(btnTim);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 140, 530, 200);
        contentPane.add(scrollPane);

        dtmDanhMuc = new DefaultTableModel();
        dtmDanhMuc.addColumn("ID Chức Năng");
        dtmDanhMuc.addColumn("Tên Chức Năng");
        dtmDanhMuc.addColumn("Trạng Thái");
        table = new MyTable(dtmDanhMuc);
        scrollPane.setViewportView(table);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLuu.setBounds(440, 360, 120, 35);
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String idDanhMuc = dtmDanhMuc.getValueAt(i, 0).toString();
                    MainFrame.txtIdDanhMucChucNang.setText(idDanhMuc);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn danh mục chức năng trong bảng");
                }
            }
        });
        contentPane.add(btnLuu);

        JButton btnDong = new JButton("Đóng");
        btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDong.setBounds(300, 360, 120, 35);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnDong);

        loadDanhMuc();
        setLocationRelativeTo(null);
    }

    private static ArrayList<DanhMucChucNangDTO> danhMucList = new ArrayList<DanhMucChucNangDTO>();

    public void loadDanhMuc() {
        danhMucList = null;
        dtmDanhMuc.setRowCount(0);
        danhMucList = DanhMucChucNangBUS.gI().getAll();
        for (DanhMucChucNangDTO dm : danhMucList) {
            dtmDanhMuc.addRow(new Object[]{
                dm.getIddanhmucchucnang(),
                dm.getTenchucnang(),
                dm.getTrangthai()
            });
        }
    }

    public void searchDanhMuc() {
        String searchText = txtTim.getText().trim().toLowerCase();
        dtmDanhMuc.setRowCount(0);
        for (DanhMucChucNangDTO dm : danhMucList) {
            if (dm.getTenchucnang().toLowerCase().contains(searchText) ||
                String.valueOf(dm.getIddanhmucchucnang()).contains(searchText)) {
                dtmDanhMuc.addRow(new Object[]{
                    dm.getIddanhmucchucnang(),
                    dm.getTenchucnang(),
                    dm.getTrangthai()
                });
            }
        }
    }
}