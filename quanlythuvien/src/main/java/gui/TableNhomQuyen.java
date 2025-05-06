package gui;

import bus.NhomQuyenBUS;
import dto.NhomQuyenDTO;
import dto.NhomQuyenDTO;
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

public class TableNhomQuyen extends JFrame {

    private JPanel contentPane;
    private JTextField txtTim;
    private JTable table;
    private DefaultTableModel dtmNhomQuyen;

    /**
     * Create the frame.
     */
    public TableNhomQuyen() {
        setTitle("Nhóm Quyền");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Nhóm Quyền");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitle.setBounds(250, 13, 100, 35);
        contentPane.add(lblTitle);

        JLabel lblTim = new JLabel("Tìm");
        lblTim.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTim.setBounds(30, 80, 50, 35);
        contentPane.add(lblTim);

        txtTim = new JTextField();
        txtTim.setBounds(90, 74, 450, 49);
        contentPane.add(txtTim);
        txtTim.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTim.setBounds(550, 80, 80, 35);
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchNhomQuyen();
            }
        });
        contentPane.add(btnTim);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 140, 580, 200);
        contentPane.add(scrollPane);

        dtmNhomQuyen = new DefaultTableModel();
        dtmNhomQuyen.addColumn("ID Nhóm Quyền");
        dtmNhomQuyen.addColumn("Tên Nhóm Quyền");
        dtmNhomQuyen.addColumn("Mô Tả");
        table = new MyTable(dtmNhomQuyen);
        scrollPane.setViewportView(table);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLuu.setBounds(490, 360, 120, 35);
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String idNhomQuyen = dtmNhomQuyen.getValueAt(i, 0).toString();
                    MainFrame.txtIdNhomQuyen_2.setText(idNhomQuyen);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn nhóm quyền trong bảng");
                }
            }
        });
        contentPane.add(btnLuu);

        JButton btnDong = new JButton("Đóng");
        btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDong.setBounds(350, 360, 120, 35);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnDong);

        loadNhomQuyen();
        setLocationRelativeTo(null);
    }

    private static ArrayList<NhomQuyenDTO> nhomQuyenList = new ArrayList<NhomQuyenDTO>();

    public void loadNhomQuyen() {
        nhomQuyenList = null;
        dtmNhomQuyen.setRowCount(0);
        nhomQuyenList = NhomQuyenBUS.gI().getAllNhomQuyen();
        for (NhomQuyenDTO nq : nhomQuyenList) {
            dtmNhomQuyen.addRow(new Object[]{
                nq.getIdnhomquyen(),
                nq.getTennhomquyen(),
                nq.getMota()
            });
        }
    }

    public void searchNhomQuyen() {
        String searchText = txtTim.getText().trim().toLowerCase();
        dtmNhomQuyen.setRowCount(0);
        for (NhomQuyenDTO nq : nhomQuyenList) {
            if (nq.getTennhomquyen().toLowerCase().contains(searchText) ||
                String.valueOf(nq.getIdnhomquyen()).contains(searchText)) {
                dtmNhomQuyen.addRow(new Object[]{
                    nq.getIdnhomquyen(),
                    nq.getTennhomquyen(),
                    nq.getMota()
                });
            }
        }
    }
}