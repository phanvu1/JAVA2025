package gui;

import bus.PhatBUS;
import dto.PhatDTO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Phat extends JFrame {

    private JPanel contentPane;
    public static JTextField textField;
    private JTextField txtphat;

    // Khai báo các JCheckBox làm biến thành viên
    private JCheckBox chckbxHongSach;
    private JCheckBox chckbxMatSach;
    private JCheckBox chckbxSaiSach;
    private JCheckBox chckbxLyDoKhac;

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
        textField.setEnabled(true);
        textField.setEditable(true);
        textField.setBounds(163, 46, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Phạt");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(32, 112, 58, 28);
        contentPane.add(lblNewLabel_1);

        chckbxHongSach = new JCheckBox("Hỏng Sách - 25k");
        chckbxHongSach.setSelected(true);
        chckbxHongSach.setBounds(90, 116, 113, 25);
        contentPane.add(chckbxHongSach);

        chckbxMatSach = new JCheckBox("Mất Sách - 50k");
        chckbxMatSach.setBounds(300, 116, 113, 25);
        contentPane.add(chckbxMatSach);

        chckbxSaiSach = new JCheckBox("Không Đúng Sách đã mượn - 30k");
        chckbxSaiSach.setBounds(90, 159, 189, 25);
        contentPane.add(chckbxSaiSach);

        chckbxLyDoKhac = new JCheckBox("Lý do khác");
        chckbxLyDoKhac.setBounds(300, 159, 113, 25);
        contentPane.add(chckbxLyDoKhac);

        JLabel lblNewLabel_1_1 = new JLabel("Số Tiền Phạt");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(32, 217, 106, 28);
        contentPane.add(lblNewLabel_1_1);

        ButtonGroup group = new ButtonGroup();
        group.add(chckbxHongSach);
        group.add(chckbxMatSach);
        group.add(chckbxSaiSach);
        group.add(chckbxLyDoKhac);

        txtphat = new JTextField();
        txtphat.setEditable(true);
        txtphat.setBounds(150, 218, 129, 28);
        contentPane.add(txtphat);
        txtphat.setColumns(10);

        // Thêm ActionListener cho các checkbox để tính tiền
        ActionListener checkboxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePhat();
            }
        };
        chckbxHongSach.addActionListener(checkboxListener);
        chckbxMatSach.addActionListener(checkboxListener);
        chckbxSaiSach.addActionListener(checkboxListener);
        chckbxLyDoKhac.addActionListener(checkboxListener);

        JButton btnNewButton = new JButton("Lưu");
        btnNewButton.setBounds(237, 269, 97, 25);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePhat();
            }
        });
        contentPane.add(btnNewButton);

        setLocationRelativeTo(null);
    }

    // Getter cho textField
    public JTextField getTextField() {
        return textField;
    }

    private void calculatePhat() {
        double total = 0.0;
        if (chckbxHongSach.isSelected()) total += 25000.0;
        if (chckbxMatSach.isSelected()) total += 50000.0;
        if (chckbxSaiSach.isSelected()) total += 30000.0;
        if (chckbxLyDoKhac.isSelected()) {
            // Có thể thêm logic để nhập số tiền tùy chỉnh nếu cần
            total += 0.0; // Mặc định 0 nếu không có logic nhập thêm
        }
        txtphat.setText(String.format("%,.2f", total) + " VNĐ");
    }

    private String getSelectedLyDo() {
        if (chckbxHongSach.isSelected()) return "Hỏng Sách - 25k";
        if (chckbxMatSach.isSelected()) return "Mất Sách - 50k";
        if (chckbxSaiSach.isSelected()) return "Không Đúng Sách đã mượn - 30k";
        if (chckbxLyDoKhac.isSelected()) return "Lý do khác";
        return "";
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void savePhat() {
        // Kiểm tra mã phiếu mượn
        String idPhieuMuonStr = textField.getText().trim();
        if (idPhieuMuonStr.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập mã phiếu mượn!");
            return;
        }
        if (!isNumber(idPhieuMuonStr)) {
            JOptionPane.showMessageDialog(contentPane, "Mã phiếu mượn phải là số!");
            return;
        }
        int idPhieuMuon = Integer.parseInt(idPhieuMuonStr);

        // Kiểm tra số tiền phạt
        String soTienPhatStr = txtphat.getText().replace(" VNĐ", "").replace(",", "").trim();
        if (soTienPhatStr.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn lý do phạt để tính số tiền!");
            return;
        }
        double soTienPhat;
        try {
            soTienPhat = Double.parseDouble(soTienPhatStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(contentPane, "Số tiền phạt không hợp lệ!");
            return;
        }

        // Kiểm tra lý do
        String lyDo = getSelectedLyDo();
        if (lyDo.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn lý do phạt!");
            return;
        }

        // Tạo PhatDTO và thêm vào cơ sở dữ liệu
        PhatDTO phat = new PhatDTO(idPhieuMuon, soTienPhat, lyDo);
        boolean success = PhatBUS.gI().addPhat(phat);
        if (success) {
            JOptionPane.showMessageDialog(contentPane, "Thêm phiếu phạt thành công!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(contentPane, "Thêm phiếu phạt thất bại! Kiểm tra mã phiếu mượn có tồn tại không.");
        }
    }
}