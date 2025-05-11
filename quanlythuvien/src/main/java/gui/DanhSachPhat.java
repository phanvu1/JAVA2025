package gui;

import bus.PhatBUS;
import dto.PhatDTO;
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

public class DanhSachPhat extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private DefaultTableModel dtmdsphat;

    /**
     * Create the frame.
     */
    public DanhSachPhat() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 775, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 154, 733, 240);
        contentPane.add(scrollPane);

        dtmdsphat = new DefaultTableModel();
        dtmdsphat.addColumn("Mã Phiếu Phạt");
        dtmdsphat.addColumn("Mã Phiếu Mượn");
        dtmdsphat.addColumn("Lý Do");
        dtmdsphat.addColumn("Số Tiền");
        table = new JTable(dtmdsphat);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("DANH SÁCH PHẠT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(306, 13, 163, 47);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(128, 94, 503, 47);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Theo Mã Phiếu Mượn");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(31, 93, 200, 47);
        contentPane.add(lblNewLabel_1);

        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTimKiem.setBounds(643, 98, 97, 39);
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPhat();
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
                    String idPhieuMuon = dtmdsphat.getValueAt(i, 1).toString(); // Cột 1 là Mã Phiếu Mượn
                    // Giả định có trường trong MainFrame để lưu idPhieuMuon
                    // MainFrame.txtIdPhieuMuon.setText(idPhieuMuon);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Chưa chọn bản ghi phạt trong bảng");
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

        JButton btnInDanhSach = new JButton("In danh sách");
        btnInDanhSach.setBounds(525, 293, 116, 40);
        btnInDanhSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contentPane, "Chức năng in danh sách chưa được triển khai!");
                // Thêm logic in danh sách tại đây nếu cần
            }
        });
        contentPane.add(btnInDanhSach);

        loadPhat();
        setLocationRelativeTo(null);
    }

    private static ArrayList<PhatDTO> phatList = new ArrayList<PhatDTO>();

    public void loadPhat() {
        phatList = null;
        dtmdsphat.setRowCount(0);
        phatList = PhatBUS.gI().getAllPhat();
        for (PhatDTO phat : phatList) {
            dtmdsphat.addRow(new Object[]{
                phat.getIdphieumuon(), // Sử dụng idphieumuon làm Mã Phiếu Phạt
                phat.getIdphieumuon(), // Sử dụng idphieumuon làm Mã Phiếu Mượn
                phat.getLydo(),
                phat.getSotienphat()
            });
        }
    }

    public void searchPhat() {
        String searchText = textField.getText().trim().toLowerCase();
        dtmdsphat.setRowCount(0);
        for (PhatDTO phat : phatList) {
            String idPhieuMuon = String.valueOf(phat.getIdphieumuon()).toLowerCase();
            if (idPhieuMuon.contains(searchText)) {
                dtmdsphat.addRow(new Object[]{
                    phat.getIdphieumuon(),
                    phat.getIdphieumuon(),
                    phat.getLydo(),
                    phat.getSotienphat()
                });
            }
        }
    }
}