package gui;

import bus.NhaCungCapBUS;
import dto.NhaCungCapDTO;
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

public class TableNCC extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private DefaultTableModel dtmncc;

    /**
     * Create the frame.
     */
    public TableNCC() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 775, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 154, 733, 240);
        contentPane.add(scrollPane);

        dtmncc = new DefaultTableModel();
        dtmncc.addColumn("Mã NCC");
        dtmncc.addColumn("Tên Nhà Cung Cấp");
        table = new MyTable(dtmncc);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Nhà Cung Cấp");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(306, 13, 125, 47);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(128, 94, 503, 47);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(31, 93, 85, 47);
        contentPane.add(lblNewLabel_1);

        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTimKiem.setBounds(643, 98, 97, 39);
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchNhaCungCap();
            }
        });
        contentPane.add(btnTimKiem);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLuu.setBounds(591, 397, 116, 38);
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String maNCC = dtmncc.getValueAt(i, 0).toString();
                    MainFrame.txtManccPhieuNhap.setText(maNCC);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn nhà cung cấp trong bảng");
                }
            }
        });
        contentPane.add(btnLuu);

        JButton btnDong = new JButton("Đóng");
        btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDong.setBounds(451, 397, 116, 38);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnDong);

        loadNhaCungCap();
        setLocationRelativeTo(null);
    }

    private static ArrayList<NhaCungCapDTO> nhaCungCapList = new ArrayList<NhaCungCapDTO>();

    public void loadNhaCungCap() {
        nhaCungCapList = null;
        dtmncc.setRowCount(0);
        nhaCungCapList = NhaCungCapBUS.gI().getAllNhaCungCap();
        for (NhaCungCapDTO ncc : nhaCungCapList) {
            dtmncc.addRow(new Object[]{
                ncc.getMancc(),
                ncc.getTenncc()
            });
        }
    }

    public void searchNhaCungCap() {
        String searchText = textField.getText().trim().toLowerCase();
        dtmncc.setRowCount(0);
        for (NhaCungCapDTO ncc : nhaCungCapList) {
            if (ncc.getTenncc().toLowerCase().contains(searchText) ||
                String.valueOf(ncc.getMancc()).contains(searchText)) {
                dtmncc.addRow(new Object[]{
                    ncc.getMancc(),
                    ncc.getTenncc()
                });
            }
        }
    }
}