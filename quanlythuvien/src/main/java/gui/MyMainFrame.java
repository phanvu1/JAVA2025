package gui;

import dao.DBConnect;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bus.SachBUS;
import bus.DocGiaBUS;
import bus.TacGiaBUS;
import dto.SachDTO;
import dto.DocGiaDTO;
import dto.TacGiaDTO;

public class MyMainFrame extends JPanel {
    private JPanel pnSach, pndocgia, pntacgia;
    private DefaultTableModel dtmsach, dtmdocgia, dtmtacgia;
    private JTable tablesach, tabledocgia, tabletacgia;
    private JTextField txttensach, txtsoluongsach, txtnamxbsach, txtTendocgia, txtgioitinhdocgia, txtdiachidocgia,
            txtsdtdocgia, txtTentacgia, txtnamsinhtacgia, txtQueQuan;

    private SachBUS sachBUS;
    private DocGiaBUS docGiaBUS;
    private TacGiaBUS tacGiaBUS;

    public MyMainFrame() {
        Connection connection = DBConnect.getConnection(); // acquire DB connection
        sachBUS = new SachBUS(connection); // Initialize BUS layers
        docGiaBUS = new DocGiaBUS(connection);
        tacGiaBUS = new TacGiaBUS(connection);
        setLayout(new CardLayout());
        pnsach();
        docgia();
        pntacgia();
        loadSachData();
        loadDocGiaData();
        loadTacGiaData();
    }

    private void loadSachData() {
        dtmsach.setRowCount(0);
        try {
            for (SachDTO sach : sachBUS.getAllSach()) {
                dtmsach.addRow(
                        new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getNamXB(), sach.getSoLuong() });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu sách: " + ex.getMessage());
        }
    }

    private void loadDocGiaData() {
        dtmdocgia.setRowCount(0);
        try {
            for (DocGiaDTO docGia : docGiaBUS.getAllDocGia()) {
                dtmdocgia.addRow(new Object[] { docGia.getMaDocGia(), docGia.getTenDocGia(), docGia.getGioiTinh() });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu độc giả: " + ex.getMessage());
        }
    }

    private void loadTacGiaData() {
        dtmtacgia.setRowCount(0);
        try {
            for (TacGiaDTO tacGia : tacGiaBUS.getAllTacGia()) {
                dtmtacgia.addRow(new Object[] { tacGia.getMaTacGia(), tacGia.getTenTacGia() });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu tác giả: " + ex.getMessage());
        }
    }

    private void pnsach() {
        pnSach = new JPanel();
        pnSach.setLayout(null);

        JLabel lbltitlepnSach = new JLabel("Sách");
        lbltitlepnSach.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbltitlepnSach.setBounds(502, 0, 76, 77);
        pnSach.add(lbltitlepnSach);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(66, 77, 788, 273);
        pnSach.add(panel);
        panel.setLayout(null);

        JLabel lblTenSach = new JLabel("Tên Sách");
        lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenSach.setBounds(12, 13, 112, 34);
        panel.add(lblTenSach);

        txttensach = new JTextField();
        txttensach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttensach.setBounds(156, 14, 203, 34);
        panel.add(txttensach);
        txttensach.setColumns(10);

        JLabel lblnamxuatban = new JLabel("Năm Xuất Bản");
        lblnamxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnamxuatban.setBounds(398, 64, 112, 34);
        panel.add(lblnamxuatban);

        txtnamxbsach = new JTextField();
        txtnamxbsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtnamxbsach.setColumns(10);
        txtnamxbsach.setBounds(522, 64, 207, 34);
        panel.add(txtnamxbsach);

        JLabel lblSLng = new JLabel("Số Lượng");
        lblSLng.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSLng.setBounds(398, 111, 112, 34);
        panel.add(lblSLng);

        txtsoluongsach = new JTextField();
        txtsoluongsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsoluongsach.setBounds(522, 111, 207, 34);
        panel.add(txtsoluongsach);
        txtsoluongsach.setColumns(10);

        JButton btnthemsach = new JButton("Thêm");
        btnthemsach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnthemsach.setBounds(32, 206, 112, 53);
        panel.add(btnthemsach);

        JButton btnsuasach = new JButton("Sửa");
        btnsuasach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuasach.setBounds(213, 206, 112, 51);
        panel.add(btnsuasach);

        JButton btnxoasach = new JButton("Xoá");
        btnxoasach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoasach.setBounds(408, 206, 112, 51);
        panel.add(btnxoasach);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(39, 456, 1024, 273);
        pnSach.add(scrollPane);
        dtmsach = new DefaultTableModel();
        dtmsach.addColumn("Mã Sách");
        dtmsach.addColumn("Tên Sách");
        dtmsach.addColumn("Năm Xuất Bản");
        dtmsach.addColumn("Số Lượng");

        tablesach = new JTable(dtmsach);
        scrollPane.setViewportView(tablesach);

        // Xử lý sự kiện
        btnthemsach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SachDTO sach = new SachDTO();
                    sach.setTenSach(txttensach.getText());
                    sach.setNamXB(Integer.parseInt(txtnamxbsach.getText()));
                    sach.setSoLuong(Integer.parseInt(txtsoluongsach.getText()));
                    if (sachBUS.themSach(sach)) {
                        JOptionPane.showMessageDialog(null, "Thêm sách thành công!");
                        loadSachData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnsuasach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tablesach.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn sách để sửa!");
                        return;
                    }
                    SachDTO sach = new SachDTO();
                    sach.setMaSach((int) dtmsach.getValueAt(selectedRow, 0));
                    sach.setTenSach(txttensach.getText());
                    sach.setNamXB(Integer.parseInt(txtnamxbsach.getText()));
                    sach.setSoLuong(Integer.parseInt(txtsoluongsach.getText()));
                    if (sachBUS.suaSach(sach)) {
                        JOptionPane.showMessageDialog(null, "Sửa sách thành công!");
                        loadSachData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnxoasach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tablesach.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn sách để xóa!");
                        return;
                    }
                    int maSach = (int) dtmsach.getValueAt(selectedRow, 0);
                    if (sachBUS.xoaSach(maSach)) {
                        JOptionPane.showMessageDialog(null, "Xóa sách thành công!");
                        loadSachData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        tablesach.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablesach.getSelectedRow();
            if (selectedRow >= 0) {
                txttensach.setText(dtmsach.getValueAt(selectedRow, 1).toString());
                txtnamxbsach.setText(dtmsach.getValueAt(selectedRow, 2).toString());
                txtsoluongsach.setText(dtmsach.getValueAt(selectedRow, 3).toString());
            }
        });

        add(pnSach, "SachPanel");
    }

    private void docgia() {
        pndocgia = new JPanel();
        pndocgia.setLayout(null);

        JPanel panelthongtindocgia = new JPanel();
        panelthongtindocgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelthongtindocgia.setBounds(130, 39, 837, 252);
        pndocgia.add(panelthongtindocgia);
        panelthongtindocgia.setLayout(null);

        JLabel lblTendocgia = new JLabel("Tên Đọc Giả");
        lblTendocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTendocgia.setBounds(91, 13, 91, 36);
        panelthongtindocgia.add(lblTendocgia);

        txtTendocgia = new JTextField();
        txtTendocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTendocgia.setBounds(192, 13, 208, 36);
        panelthongtindocgia.add(txtTendocgia);
        txtTendocgia.setColumns(10);

        JLabel lblgioitinhdocgia = new JLabel("Giới Tính");
        lblgioitinhdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblgioitinhdocgia.setBounds(453, 119, 91, 36);
        panelthongtindocgia.add(lblgioitinhdocgia);

        txtgioitinhdocgia = new JTextField();
        txtgioitinhdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtgioitinhdocgia.setColumns(10);
        txtgioitinhdocgia.setBounds(569, 119, 208, 36);
        panelthongtindocgia.add(txtgioitinhdocgia);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(47, 404, 1005, 308);
        pndocgia.add(scrollPane_1);
        dtmdocgia = new DefaultTableModel();
        dtmdocgia.addColumn("Mã Đọc Giả");
        dtmdocgia.addColumn("Họ Và Tên");
        dtmdocgia.addColumn("Giới Tính");

        tabledocgia = new JTable(dtmdocgia);
        scrollPane_1.setViewportView(tabledocgia);

        // Xử lý sự kiện
        JButton btnthemdocgia = new JButton("Thêm");
        btnthemdocgia.setBounds(50, 300, 100, 30);
        pndocgia.add(btnthemdocgia);

        JButton btnsuadocgia = new JButton("Sửa");
        btnsuadocgia.setBounds(200, 300, 100, 30);
        pndocgia.add(btnsuadocgia);

        JButton btnxoadocgia = new JButton("Xóa");
        btnxoadocgia.setBounds(350, 300, 100, 30);
        pndocgia.add(btnxoadocgia);

        btnthemdocgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DocGiaDTO docGia = new DocGiaDTO();
                    docGia.setTenDocGia(txtTendocgia.getText());
                    docGia.setGioiTinh(txtgioitinhdocgia.getText());
                    if (docGiaBUS.themDocGia(docGia)) {
                        JOptionPane.showMessageDialog(null, "Thêm độc giả thành công!");
                        loadDocGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnsuadocgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabledocgia.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn độc giả để sửa!");
                        return;
                    }
                    DocGiaDTO docGia = new DocGiaDTO();
                    docGia.setMaDocGia((int) dtmdocgia.getValueAt(selectedRow, 0));
                    docGia.setTenDocGia(txtTendocgia.getText());
                    docGia.setGioiTinh(txtgioitinhdocgia.getText());
                    if (docGiaBUS.suaDocGia(docGia)) {
                        JOptionPane.showMessageDialog(null, "Sửa độc giả thành công!");
                        loadDocGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnxoadocgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabledocgia.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn độc giả để xóa!");
                        return;
                    }
                    int maDocGia = (int) dtmdocgia.getValueAt(selectedRow, 0);
                    if (docGiaBUS.xoaDocGia(maDocGia)) {
                        JOptionPane.showMessageDialog(null, "Xóa độc giả thành công!");
                        loadDocGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        tabledocgia.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tabledocgia.getSelectedRow();
            if (selectedRow >= 0) {
                txtTendocgia.setText(dtmdocgia.getValueAt(selectedRow, 1).toString());
                txtgioitinhdocgia.setText(dtmdocgia.getValueAt(selectedRow, 2).toString());
            }
        });

        add(pndocgia, "DocGiaPanel");
    }

    private void pntacgia() {
        pntacgia = new JPanel();
        pntacgia.setLayout(null);

        JPanel pnthongtintacgia = new JPanel();
        pnthongtintacgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnthongtintacgia.setBounds(158, 78, 607, 281);
        pntacgia.add(pnthongtintacgia);
        pnthongtintacgia.setLayout(null);

        JLabel lblTentacgia = new JLabel("Tên Tác Giả");
        lblTentacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTentacgia.setBounds(24, 51, 152, 37);
        pnthongtintacgia.add(lblTentacgia);

        txtTentacgia = new JTextField();
        txtTentacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTentacgia.setBounds(287, 51, 224, 37);
        pnthongtintacgia.add(txtTentacgia);
        txtTentacgia.setColumns(10);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(158, 430, 792, 281);
        pntacgia.add(scrollPane_2);

        dtmtacgia = new DefaultTableModel();
        dtmtacgia.addColumn("Mã Tác Giả");
        dtmtacgia.addColumn("Tên Tác Giả");

        tabletacgia = new JTable(dtmtacgia);
        scrollPane_2.setViewportView(tabletacgia);

        // Xử lý sự kiện
        JButton btnthemtacgia = new JButton("Thêm");
        btnthemtacgia.setBounds(50, 300, 100, 30);
        pntacgia.add(btnthemtacgia);

        JButton btnsuatacgia = new JButton("Sửa");
        btnsuatacgia.setBounds(200, 300, 100, 30);
        pntacgia.add(btnsuatacgia);

        JButton btnxoatacgia = new JButton("Xóa");
        btnxoatacgia.setBounds(350, 300, 100, 30);
        pntacgia.add(btnxoatacgia);

        btnthemtacgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TacGiaDTO tacGia = new TacGiaDTO();
                    tacGia.setTenTacGia(txtTentacgia.getText());
                    if (tacGiaBUS.themTacGia(tacGia)) {
                        JOptionPane.showMessageDialog(null, "Thêm tác giả thành công!");
                        loadTacGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnsuatacgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabletacgia.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả để sửa!");
                        return;
                    }
                    TacGiaDTO tacGia = new TacGiaDTO();
                    tacGia.setMaTacGia((int) dtmtacgia.getValueAt(selectedRow, 0));
                    tacGia.setTenTacGia(txtTentacgia.getText());
                    if (tacGiaBUS.suaTacGia(tacGia)) {
                        JOptionPane.showMessageDialog(null, "Sửa tác giả thành công!");
                        loadTacGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        btnxoatacgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabletacgia.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả để xóa!");
                        return;
                    }
                    int maTacGia = (int) dtmtacgia.getValueAt(selectedRow, 0);
                    if (tacGiaBUS.xoaTacGia(maTacGia)) {
                        JOptionPane.showMessageDialog(null, "Xóa tác giả thành công!");
                        loadTacGiaData();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        tabletacgia.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tabletacgia.getSelectedRow();
            if (selectedRow >= 0) {
                txtTentacgia.setText(dtmtacgia.getValueAt(selectedRow, 1).toString());
            }
        });

        add(pntacgia, "TacGiaPanel");
    }
}
