package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import bus.TaiKhoanBUS;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    public static boolean dangnhap = false;
    public static int idnhomquyen = 0;

    public LoginForm() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 708, 550);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 765, 590);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("LOGIN");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(468, 59, 107, 58);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("UserName");
        lblNewLabel_1_1.setFont(new Font("Consolas", Font.BOLD, 16));
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setBounds(378, 149, 107, 58);
        panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("PassWord");
        lblNewLabel_1_2.setFont(new Font("Consolas", Font.BOLD, 16));
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setBounds(378, 220, 107, 58);
        panel.add(lblNewLabel_1_2);

        txtUser = new JTextField();
        txtUser.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 128)));
        txtUser.setForeground(Color.WHITE);
        txtUser.setFont(new Font("Consolas", Font.BOLD, 18));
        txtUser.setBackground(new Color(206, 182, 149));
        txtUser.setBounds(476, 161, 170, 35);
        panel.add(txtUser);
        txtUser.setColumns(10);

        txtPass = new JPasswordField();
        txtPass.setForeground(Color.WHITE);
        txtPass.setFont(new Font("Consolas", Font.BOLD, 18));
        txtPass.setBackground(new Color(206, 182, 149));
        txtPass.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 128)));
        txtPass.setBounds(478, 232, 170, 35);
        panel.add(txtPass);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(e -> {
            String username = txtUser.getText();
            String password = new String(txtPass.getPassword());
            if (!username.equals("") && !password.equals("")) {
                try {
                    int idNhomQuyen = TaiKhoanBUS.gI().checkTaiKhoan(username, password);
                    if (idNhomQuyen > 0) {
                        dangnhap = true;
                        idnhomquyen = idNhomQuyen;
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                        setVisible(false);
                        dispose();
                        System.out.println("Đăng nhập thành công, hiển thị loading");
                        SwingUtilities.invokeLater(() -> {
                            loading load = new loading();
                            load.setVisible(true);
                            // Sử dụng Timer để tạo độ trễ 2 giây mà không chặn EDT
                            Timer timer = new Timer(2000, evt -> {
                                load.setVisible(false);
                                load.dispose();
                                System.out.println("Đóng loading, hiển thị MainFrame");
                                try {
                                    MainFrame mainFrame = new MainFrame();
                                    mainFrame.setVisible(true);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Lỗi khi khởi tạo MainFrame: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                            });
                            timer.setRepeats(false); // Chỉ chạy 1 lần
                            timer.start(); // Bắt đầu timer
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!");
                        dangnhap = false;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra tài khoản: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu!");
            }
        });
        btnNewButton.setBounds(468, 325, 119, 58);
        panel.add(btnNewButton);

        JLabel lblexit = new JLabel("");
        lblexit.setIcon(new ImageIcon("img\\Delete.png"));
        lblexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        lblexit.setBounds(613, 44, 35, 35);
        panel.add(lblexit);

        JCheckBox checkboxrm = new JCheckBox("Remember Me");
        checkboxrm.setForeground(Color.WHITE);
        checkboxrm.setBackground(new Color(0, 0, 0, 0));
        checkboxrm.setFont(new Font("Consolas", Font.BOLD, 16));
        checkboxrm.setBounds(372, 291, 203, 25);
        panel.add(checkboxrm);

        JLabel lblNewLabel = new JLabel("");
        try {
            lblNewLabel.setIcon(new ImageIcon("img\\loginform.png"));
        } catch (Exception e) {
            System.out.println("Lỗi khi tải hình nền LoginForm: " + e.getMessage());
        }
        lblNewLabel.setBounds(-25, -12, 691, 628);
        panel.add(lblNewLabel);

        setBackground(new Color(0, 0, 0, 0));
        panel.setBackground(new Color(0, 0, 0, 0));
        setSize(662, 588);
        setLocationRelativeTo(null);
    }
}