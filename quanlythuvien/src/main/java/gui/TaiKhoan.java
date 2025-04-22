package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TaiKhoan extends JDialog {

    private JTextField txtusername;
    private JTextField txtpass;
    private JTextField txtquyen;

    /**
     * Create the frame.
     */
    public TaiKhoan() {
        setBounds(100, 100, 621, 455);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel UserName = new JLabel("UserName");
        UserName.setFont(new Font("Tahoma", Font.BOLD, 15));
        UserName.setBounds(82, 61, 93, 39);
        getContentPane().add(UserName);

        txtusername = new JTextField();
        txtusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtusername.setBounds(206, 61, 284, 39);
        getContentPane().add(txtusername);
        txtusername.setColumns(10);

        JLabel lblPass = new JLabel("Pass");
        lblPass.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPass.setBounds(82, 140, 93, 39);
        getContentPane().add(lblPass);

        txtpass = new JPasswordField();
        txtpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpass.setBounds(206, 141, 284, 39);
        getContentPane().add(txtpass);
        txtpass.setColumns(10);

        JLabel lblNewLabel = new JLabel("Quyền");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(82, 223, 68, 32);
        getContentPane().add(lblNewLabel);

        txtquyen = new JTextField();
        txtquyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtquyen.setBounds(206, 221, 284, 39);
        getContentPane().add(txtquyen);
        txtquyen.setColumns(10);

        JButton btnNewButton = new JButton("Lưu");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(266, 309, 97, 39);
        getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("THÊM TÀI KHOẢN");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(241, 0, 162, 45);
        getContentPane().add(lblNewLabel_1);

        setLocationRelativeTo(null);
    }
}