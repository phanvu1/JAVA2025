package gui;

import bus.SachBUS;
import dto.SachDTO;
import static gui.MainFrame.txtMaSachctpn;
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

public class TableSach extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private DefaultTableModel dtmsach;

    /**
     * Create the frame.
     */
    public TableSach() {
        setTitle("Chọn Loại Sách");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 857, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sách");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(391, 13, 53, 35);
        contentPane.add(lblNewLabel);

        JLabel lblTm = new JLabel("Tìm");
        lblTm.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTm.setBounds(85, 88, 53, 35);
        contentPane.add(lblTm);

        textField = new JTextField();
        textField.setBounds(160, 82, 477, 49);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTim.setBounds(669, 88, 118, 35);
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchSach();
            }
        });
        contentPane.add(btnTim);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(46, 165, 750, 211);
        contentPane.add(scrollPane);

        dtmsach = new DefaultTableModel();
        dtmsach.addColumn("Mã Sách");
        dtmsach.addColumn("Tên Sách");
        dtmsach.addColumn("Mã Loại");
        dtmsach.addColumn("Mã NXB");
        dtmsach.addColumn("Mã Tác Giả");
        dtmsach.addColumn("Năm Xuất Bản");
        dtmsach.addColumn("Số Lượng");
        dtmsach.addColumn("Mã Kệ");
        table = new MyTable(dtmsach);
        scrollPane.setViewportView(table);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLuu.setBounds(664, 389, 132, 33);
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String maSach = dtmsach.getValueAt(i, 0).toString();
                    MainFrame.txtMaSachctpn.setText(maSach);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn sách trong bảng");
                }
            }
        });
        contentPane.add(btnLuu);

        JButton btnDong = new JButton("Đóng");
        btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDong.setBounds(524, 389, 132, 33);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnDong);

        loadSach();
        setLocationRelativeTo(null);
    }

    private static ArrayList<SachDTO> sachList = new ArrayList<SachDTO>();

    public void loadSach() {
        sachList = null;
        dtmsach.setRowCount(0);
        sachList = SachBUS.gI().getAllSach();
        for (SachDTO sach : sachList) {
            dtmsach.addRow(new Object[]{
                sach.getMaSach(),
                sach.getTenSach(),
                sach.getMaLoai(),
                sach.getMaNXB(),
                sach.getMaTacGia(),
                sach.getNamXB(),
                sach.getSoLuong(),
                sach.getMaKeSach()
            });
        }
    }

    public void searchSach() {
        String searchText = textField.getText().trim().toLowerCase();
        dtmsach.setRowCount(0);
        for (SachDTO sach : sachList) {
            if (sach.getTenSach().toLowerCase().contains(searchText) ||
                String.valueOf(sach.getMaSach()).contains(searchText)) {
                dtmsach.addRow(new Object[]{
                    sach.getMaSach(),
                    sach.getTenSach(),
                    sach.getMaLoai(),
                    sach.getMaNXB(),
                    sach.getMaTacGia(),
                    sach.getNamXB(),
                    sach.getSoLuong(),
                    sach.getMaKeSach()
                });
            }
        }
    }
}