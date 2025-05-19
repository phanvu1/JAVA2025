package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class loading extends JFrame {
    private JPanel contentPane;

    public loading() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 659, 465);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        try {
            lblNewLabel.setIcon(new ImageIcon("img\\unnamed.gif"));
        } catch (Exception e) {
            System.out.println("Lỗi khi tải file GIF: " + e.getMessage());
        }
        lblNewLabel.setBounds(230, 73, 294, 272);
        contentPane.add(lblNewLabel);
        contentPane.setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
    }
}