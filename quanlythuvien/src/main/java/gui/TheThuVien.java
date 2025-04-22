package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class TheThuVien extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel dtmthetv;
    private JTextField txtmathe;
    private JTextField txtmadocgia;
    private JTextField txttendocgia;

    /**
     * Create the frame.
     */
    public TheThuVien() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 717, 634);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 342, 688, 232);
        contentPane.add(scrollPane);
        dtmthetv = new DefaultTableModel();
        dtmthetv.addColumn("Mã Thẻ Thư Viện");
        dtmthetv.addColumn("Tên Đọc Giả");
        dtmthetv.addColumn("Mã Đọc Giả");
        dtmthetv.addColumn("Ngày Bắt Đầu");
        dtmthetv.addColumn("Ngày Kết Thúc");

        table = new MyTable(dtmthetv);
        scrollPane.setViewportView(table);

        JDateChooser ngaybatdau = new JDateChooser();
        ngaybatdau.setDateFormatString("yyyy-MM-dd");
        ngaybatdau.setBounds(534, 67, 153, 32);
        contentPane.add(ngaybatdau);

        JDateChooser ngayketthuc = new JDateChooser();
        ngayketthuc.setDateFormatString("yyyy-MM-dd");
        ngayketthuc.setBounds(534, 142, 153, 32);
        contentPane.add(ngayketthuc);

        JButton btnThm = new JButton("Thêm");
        btnThm.setBounds(79, 304, 97, 25);
        contentPane.add(btnThm);

        JButton btnNewButton = new JButton("Sửa");
        btnNewButton.setBounds(208, 304, 97, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Xoá");
        btnNewButton_1.setBounds(341, 304, 97, 25);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Gia Hạn");
        btnNewButton_1_1.setBounds(470, 304, 97, 25);
        contentPane.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Tải Lại");
        btnNewButton_1_2.setBounds(603, 304, 97, 25);
        contentPane.add(btnNewButton_1_2);

        JLabel lblNewLabel = new JLabel("Thẻ Thư Viện", SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(12, 13, 688, 41);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã Thẻ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(12, 67, 69, 32);
        contentPane.add(lblNewLabel_1);

        txtmathe = new JTextField();
        txtmathe.setBounds(105, 62, 178, 37);
        contentPane.add(txtmathe);
        txtmathe.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Mã đọc giả");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(12, 142, 97, 32);
        contentPane.add(lblNewLabel_1_1);

        txtmadocgia = new JTextField();
        txtmadocgia.setBounds(105, 141, 178, 37);
        contentPane.add(txtmadocgia);
        txtmadocgia.setColumns(10);

        JLabel lblNewLabel_1_1_2 = new JLabel("Tên Đọc Giả");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_2.setBounds(12, 207, 97, 32);
        contentPane.add(lblNewLabel_1_1_2);

        txttendocgia = new JTextField();
        txttendocgia.setBounds(105, 206, 178, 37);
        contentPane.add(txttendocgia);
        txttendocgia.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Ngày Bắt Đầu");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1.setBounds(402, 67, 120, 32);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày Kết Thúc");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1_1.setBounds(402, 142, 120, 32);
        contentPane.add(lblNewLabel_1_1_1_1);

        setLocationRelativeTo(null);
    }
}