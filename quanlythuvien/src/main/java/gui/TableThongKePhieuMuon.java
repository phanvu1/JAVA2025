package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TableThongKePhieuMuon extends JDialog {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel dtmthongkephieumuon;

    /**
     * Create the frame.
     */
    public TableThongKePhieuMuon() {
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 491);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 123, 708, 251);
        contentPane.add(scrollPane);
        dtmthongkephieumuon = new DefaultTableModel();
        dtmthongkephieumuon.addColumn("Mã CTPM");
        dtmthongkephieumuon.addColumn("Mã PM");
        dtmthongkephieumuon.addColumn("Mã Sách");
        dtmthongkephieumuon.addColumn("Ngày Mượn");
        dtmthongkephieumuon.addColumn("Ngày Trả");
        dtmthongkephieumuon.addColumn("Ghi Chú");

        table = new MyTable(dtmthongkephieumuon);
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("Xuất");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(499, 394, 97, 36);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Đóng");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.setBounds(623, 394, 97, 36);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("THỐNG KÊ SÁCH ĐÃ MƯỢN");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(201, 29, 292, 69);
        contentPane.add(lblNewLabel);

        setLocationRelativeTo(null);
    }
}