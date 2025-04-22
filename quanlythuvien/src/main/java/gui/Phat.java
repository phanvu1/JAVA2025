package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Phat extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField txtphat;

    /**
     * Create the frame.
     */
    public Phat() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 511, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã Phiếu Mượn");
        lblNewLabel.setEnabled(false);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(32, 42, 119, 28);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setEnabled(false);
        textField.setEditable(false);
        textField.setBounds(163, 46, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Phạt");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(32, 112, 58, 28);
        contentPane.add(lblNewLabel_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Hỏng Sách - 25k");
        chckbxNewCheckBox.setSelected(true);
        chckbxNewCheckBox.setBounds(90, 116, 113, 25);
        contentPane.add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mất Sách - 50k");
        chckbxNewCheckBox_1.setBounds(300, 116, 113, 25);
        contentPane.add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Không Đúng Sách đã mượn - 30k");
        chckbxNewCheckBox_2.setBounds(90, 159, 189, 25);
        contentPane.add(chckbxNewCheckBox_2);

        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Lý do khác");
        chckbxNewCheckBox_3.setBounds(300, 159, 113, 25);
        contentPane.add(chckbxNewCheckBox_3);

        JLabel lblNewLabel_1_1 = new JLabel("Số Tiền Phạt");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(32, 217, 106, 28);
        contentPane.add(lblNewLabel_1_1);

        ButtonGroup group = new ButtonGroup();
        group.add(chckbxNewCheckBox);
        group.add(chckbxNewCheckBox_1);
        group.add(chckbxNewCheckBox_2);
        group.add(chckbxNewCheckBox_3);

        txtphat = new JTextField();
        txtphat.setEditable(false);
        txtphat.setBounds(150, 218, 129, 28);
        contentPane.add(txtphat);
        txtphat.setColumns(10);

        JButton btnNewButton = new JButton("Lưu");
        btnNewButton.setBounds(237, 269, 97, 25);
        contentPane.add(btnNewButton);

        setLocationRelativeTo(null);
    }
}