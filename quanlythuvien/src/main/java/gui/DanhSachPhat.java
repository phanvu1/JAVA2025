package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DanhSachPhat extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel dtmdsphat;

    /**
     * Create the frame.
     */
    public DanhSachPhat() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 658, 393);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 79, 616, 201);
        contentPane.add(scrollPane);
        dtmdsphat = new DefaultTableModel();
        dtmdsphat.addColumn("Mã Phiếu Phạt");
        dtmdsphat.addColumn("Mã Phiếu Mượn");
        dtmdsphat.addColumn("Lý Do");
        dtmdsphat.addColumn("Số Tiền");
        table = new JTable(dtmdsphat);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("DANH SÁCH PHẠT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(264, 13, 145, 53);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("In danh sách");
        btnNewButton.setBounds(525, 293, 103, 40);
        contentPane.add(btnNewButton);

        setLocationRelativeTo(null);
    }
}