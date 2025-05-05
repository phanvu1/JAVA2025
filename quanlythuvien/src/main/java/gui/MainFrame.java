package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import java.awt.Dimension;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;

import dto.PhieuNhapDTO;
import dto.ChiTietPhieuNhapDTO;
import dto.SachDTO;
import dto.DocGiaDTO;
import dto.TacGiaDTO;
import dto.NhaCungCapDTO;
import dto.KeSachDTO;
import dto.LoaiSachDTO;
import dto.ThongKePhieuNhapDTO;

import dto.NhomQuyenDTO;
import dto.ChiTietNhomQuyenDTO;

import dto.NhaXuatBanDTO;
import dto.NhanVienDTO;
import dto.PhieuMuonDTO;



import bus.PhieuNhapBUS;
import bus.ChiTietPhieuNhapBUS;
import bus.SachBUS;
import bus.DocGiaBUS;
import bus.TacGiaBUS;
import bus.NhaCungCapBUS;
import bus.KeSachBUS;
import bus.LoaiSachBUS;
import bus.ThongKePhieuNhapBUS;
import bus.ChiTietPhieuMuonBUS;

import bus.NhomQuyenBUS;
import bus.ChiTietNhomQuyenBUS;

import bus.NhaXuatBanBUS;
import bus.NhanVienBUS;
import bus.PhieuMuonBUS;
import bus.PhieuMuonBUS;


import dao.DocGiaDAO;
import dao.SachDAO;
import dao.TacGiaDAO;
import dto.NhaXuatBanDTO;

import export.ExportEx;
import export.ImportEx;

import java.util.logging.SimpleFormatter;
import gui.LoginForm;

public class MainFrame extends JFrame {
    public static String Ma;
    private static int idnhomquyen = LoginForm.idnhomquyen;
    public static boolean isdangxuat;
    private JPanel contentPane;
    private JLabel iconsgu;
    private JLabel exit;
    private JLabel lblTitle;
    private JLabel title;
    private JPanel menuleft;
    private JLabel ThuVienSgu;
    private JLabel lblthuviensgu;
    private JPanel PanelChinh;
    private JPanel CardLayout;

    private JPanel SachPanel;
    private JPanel LoaiSach;
    private JPanel Sach;
    public static JPanel pnSach;
    private JPanel pndocgia;
    private JPanel pnnhaxuatban;
    private JPanel pntacgia;
    private JPanel pnTrangChu;
    private JPanel pnnhanvien;
    private JLabel lblphanquyen;
    private JLabel lblTenSach;
    private JLabel lblMaLoai;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblHinhAnh;
    private JLabel lbltitlepnSach;
    private JLabel lblnamxuatban;
    private JLabel lblSLng;
    private JLabel lblMaKeSach;
    private JTextField txttensach;
    private JTextField txtsoluongsach;
    private JTextField txtnamxbsach;
    private JTable tablesach;
    private DefaultTableModel dtmsach;
    private JLabel lblNewLabel;
    private JLabel lblTrangchu;
    private JLabel lblSach;
    private JLabel lbldocgia;
    private JLabel lbltacgia;
    private JLabel lblnhaxuatban;
    private JLabel lblnhanvien;
    private JPanel panelthongtindocgia;
    private JLabel lblTendocgia;
    private JLabel lbldiachidocgia;
    private JLabel lblgioitinhdocgia;
    private JLabel lblSdtdocgia;
    private JTextField txtTendocgia;
    private JTextField txtdiachidocgia;
    private JTextField txtgioitinhdocgia;
    private JTextField txtsdtdocgia;
    private JTextField txtTimkiemdocgia;
    private JButton btnTimkiemdocgia;
    private JLabel lblTimKiem;
    private JScrollPane scrollPane_1;
    private JTable tabledocgia;
    private DefaultTableModel dtmdocgia;
    private JPanel pnthongtintacgia;
    private JLabel lblTentacgia;
    private JTextField txtTentacgia;
    private JLabel lblnamsinh;
    private JTextField txtnamsinhtacgia;
    private JLabel lblTentacgia_2;
    private JTextField txtQueQuan;
    private JScrollPane scrollPane_2;
    private JTable tabletacgia;
    private DefaultTableModel dtmtacgia;
    private JButton btnThemTacgia;
    private JButton btnsuatacgia;
    private JButton btnreloadtacgia;
    private JButton btnxoatacgia;
    private JPanel panel_1;
    private JLabel lblTennhaxuatban;
    private JLabel lblaCh;
    private JLabel lblTennhaxuatban_2;
    private JTextField txtTennhaxuatban;
    private JTextField txtdiachinxb;
    private JTextField txtsdtnxb;
    private JButton btnThemnxb;
    private JButton btnsuanxb;
    private JButton btnxoanxb;
    private JButton btnreloadnxb;
    private JLabel lblTimKiemnxb;
    private JTextField txttimnxb;
    private JScrollPane scrollPane_3;
    private JTable tablenhaxuatban;
    private DefaultTableModel dtmnhaxuatban;
    public static JPanel pnPhieumuon;
    private JPanel pnPhieuNhap;
    private JPanel pnTaiKhoan;
    private JPanel pnNhomQuyen;
    private JPanel panel_2;
    private JLabel lbltennv;
    private JLabel lblnamsinhnv;
    private JLabel lblaCh_1;
    private JLabel lbltennv_3;
    private JLabel lbltennv_4;
    private JTextField txttennv;
    private JTextField txtnamsinhnv;
    private JTextField txtdiachinv;
    private JTextField txtsodienthoainv;
    private JTextField txtgioitinhnv;
    private JButton btnthemnv;
    private JButton btnsuanv;
    private JButton btnxoanv;
    private JButton btnreloadnv;
    private JLabel lbltimkiem;
    private JTextField txtTimKiemnv;
    private JScrollPane scrollPane_4;
    private JTable tablenhanvien;
    private DefaultTableModel dtmnhanvien;
    protected int y_mouse;
    protected int x_mouse;
    private JPanel pnchung;
    private JPanel panel_3;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JTextField txtmapm;
    private JButton btnthemphieumuon;
    private JButton btnsuaphieumuon;
    private JButton btnxoaphieumuon;
    private JButton btnreloadphieumuon;
    private JScrollPane scrollPane_5;
    private DefaultTableModel dtmmuon;
    private JLabel lblphieumuon;
    private JLabel lbltimkiempm;
    private JTextField txttimphieumuon;
    private JScrollPane scrollPane_6;
    private JTable tablectpm;
    private DefaultTableModel dtmctpm;
    public static JTextField txtmasachmuon;
    private JTextField txtghichuctpm;
    private JTextField txttenloai;
    private JTable tableloai;
    private JButton btnsualoai;
    private JButton btnxoaloai;
    private DefaultTableModel dtmloai;
    private JLabel lbltenncc;
    private JTextField txtNcc;
    private JButton btnThemncc;
    private JButton btnsuancc;
    private JButton btnxoancc;
    private JScrollPane scrollPane_7;
    private JTable tablencc;
    private DefaultTableModel dtmncc;
    private JLabel lblNewLabel_10;
    private JTextField txtKeSach;
    private JButton btnthemkesach;
    private JButton btnsuakesach;
    private JButton btnxoakesach;
    private JScrollPane scrollPane_8;
    private JTable tablekesach;
    private JLabel lblchung;
    private JLabel lbldangxuat;
    private DefaultTableModel dtmke;
    private JButton btnThemloai;
    private JButton btnthemdocgia;
    private JButton btnsuadocgia;
    private JButton btnxoadocgia;
    private JComboBox cmbmaloai;
    private JComboBox cmbmanhaxuatban;
    private JComboBox cmbmatg;
    private JComboBox cmbmakesach;
    private String hinhanh = null;
    private JComboBox cmbnhanvienpm;
    private JComboBox cmbmadocgiaphieumuon;
    private JDateChooser dateChooser;
    private JButton btnthemctpm;
    private JButton btnsuactpm;
    private JButton btnxoactpm;
    private JButton bnttailaictpm;
    private JDateChooser dateChooser_ngaytra;
    private JLabel lblthongke;
    private JTable tablephieunhap;
    private JTable  tableNhomQuyen;
    private DefaultTableModel dtmphieunhap;
    private DefaultTableModel dtmNhomQuyen;
    private DefaultTableModel dtmchitietphieunhap;
    private JDateChooser NgayNhapPhieuNhap;
    private JLabel lblphieunhap;
    private JButton btnmanvphieunhap;
    private JButton btnmanccphieunhap;
    private JRadioButton rdmuon;
    private JRadioButton rdtra;
    private JButton btnthemphieuphat;
    private JButton btndanhsachphat;
    private JButton btnthemphieunhap;
    private JButton btnsuaphieunhap;
    private JButton btnxoaphieunhap;
    protected int mapn;
    private JPopupMenu popupThemtaikhoanv;
    private JMenuItem mnthemtaikhoan;
    private DefaultTableModel dtmthongkesachmuon;
    private DefaultTableModel dtmthongkenhaphang;
    private ButtonGroup g;
    private JButton btnlocthongke;
    private JComboBox comboBox;
    protected String namselect = "";
    private JDateChooser ngaybd;
    private JDateChooser ngayketthuc;
    private JLabel lbltongtien;
    private JRadioButton rdloctheonam;
    private JRadioButton rdloctheongay;
    private ButtonGroup group;
    public static JLabel lblUser;
    private JLabel lblhinhanhpre;
    private JButton btnthemsach;
    private JButton btnsuasach;
    private JButton btnxoasach;
    private JButton btnloadlaitrang;
    private JPanel panelThongKe;
    private JTable tablethongkenhaphang;
    private JLabel lblNewLabel_18;
    private JLabel lblsosachdanhap;
    private JLabel lblnhomquyen;
    private JTextField txttimsach;
    private JButton btnTiLi;
    private JLabel lblTmKim;
    private JTextField txttimtacgia;
    private JButton btnTm_2;
    private JButton btntimphieunhap;
    private JButton btntailai;
    private JMenuItem mntmNewMenuItem;
    private JTable tablechitietphieunhap;
    public static JTextField txtManhanvienphieunhap;
    public static JTextField txtManccPhieuNhap;
    private JLabel lblNewLabel_12;
    public static JTextField txtMaSachctpn;
    private JButton btnmanvphieunhap_1;
    private JLabel lblNewLabel_13;
    private JTextField txtsoluongctpn;
    private JLabel lblNewLabel_14;
    private JTextField txtgianhap;
    private JLabel lblmaphieunhap;
    private JTextField txtmpnctpn;
    private JButton btnthemchitietphieunhap;
    private JButton btnsuactpn;
    private JButton btnxoactpn;
    private JPanel panel_7;
    private JLabel lblNewLabel_16;
    private JTextField txttimphieunhap;
    private JButton btninphieunhap;
    private JButton btnxuatexcel;
    private JButton btnnhapexcel;
    private JButton btnthongkesachmuon;
    private JTable tablemuon;
    public static int idtaikhoan;
    private JTextField txtTenNhomQuyen;
    private JTextField txtMoTa;
    private DefaultTableModel dtmChiTietNhomQuyen;
    private  JLabel lblIdNhomQuyen;
    private JTextField txtIdNhomQuyen;
    private JLabel lblIdDanhMucChucNang;
    private JTextField txtIdDanhMucChucNang;
    private JLabel lblTenChucNang;
    private JTextField txtTenChucNang;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, 1280, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        thanhtitle();
        menuleft();
        addEvent();
        loadphieunhap();
        loadctphieunhap();
        loadnhacungcap();
        loadkesach();
        loadloaisach();
        loadthongkephieunhap();


        loaddocgia();
        loadtacgia();
        loadsach();

        loadnxb();
        loadnhanvien();
        loadphieumuon();

    }

    public void thanhtitle() {
        iconsgu = new JLabel("");
        iconsgu.setIcon(null);
        iconsgu.setBounds(0, 0, 30, 34);
        contentPane.add(iconsgu);

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("img\\exiticon.png"));
        exit.setBounds(1244, 7, 24, 24);
        contentPane.add(exit);

        lblTitle = new JLabel("Qu\u1EA3n L\u00FD Th\u01B0 Vi\u1EC7n");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setBounds(535, 0, 170, 34);
        contentPane.add(lblTitle);

        title = new JLabel("");
        title.setOpaque(true);
        title.setBackground(new Color(64, 64, 64));
        title.setBounds(0, 0, 1280, 34);
        contentPane.add(title);
    }

    public void menuleft() {
        PanelChinh = new JPanel();
        PanelChinh.setBounds(187, 33, 1093, 735);
        contentPane.add(PanelChinh);
        PanelChinh.setLayout(new CardLayout(0, 0));
        pnsach();
        docgia();
        nhaxuatban();
        pntacgia();
        trangchu();
        nhanvien();
        pnPhieumuon = new JPanel();
        pnPhieuNhap = new JPanel();
        pnTaiKhoan = new JPanel();
        pnNhomQuyen = new JPanel();

        // Tạo menuleft
        menuleft = new JPanel();
        menuleft.setBounds(0, 33, 187, 734);
        menuleft.setBackground(new Color(64, 64, 64));
        contentPane.add(menuleft);
        menuleft.setLayout(new BorderLayout());

        // Tạo panel con chứa các mục menu
        JPanel menuItemsPanel = new JPanel();
        menuItemsPanel.setBackground(new Color(64, 64, 64));
        menuItemsPanel.setLayout(null);
        menuItemsPanel.setPreferredSize(new Dimension(187, 870)); // Chiều cao đủ lớn để chứa tất cả mục

        // Tạo JScrollPane
        JScrollPane scrollPane = new JScrollPane(menuItemsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        menuleft.add(scrollPane, BorderLayout.CENTER);

        // Thêm các mục menu vào menuItemsPanel
        lblthuviensgu = new JLabel("Thư Viện SGU");
        lblthuviensgu.setForeground(Color.WHITE);
        lblthuviensgu.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblthuviensgu.setIcon(new ImageIcon("img\\iconthuvien.png"));
        lblthuviensgu.setBounds(0, 13, 187, 40);
        menuItemsPanel.add(lblthuviensgu);

        ThuVienSgu = new JLabel("");
        ThuVienSgu.setBackground(new Color(255, 127, 80));
        ThuVienSgu.setOpaque(true);
        ThuVienSgu.setBounds(0, 0, 187, 62);
        menuItemsPanel.add(ThuVienSgu);

        lblTrangchu = new JLabel("  Trang Chủ");
        lblTrangchu.setBackground(new Color(64, 64, 64));
        lblTrangchu.setOpaque(true);
        lblTrangchu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTrangchu.setIcon(new ImageIcon("img\\home-icon.png"));
        lblTrangchu.setForeground(Color.WHITE);
        lblTrangchu.setBounds(0, 74, 187, 46);
        menuItemsPanel.add(lblTrangchu);

        lblSach = new JLabel("  Sách");
        lblSach.setIcon(new ImageIcon("img\\bookicon.png"));
        lblSach.setBackground(new Color(64, 64, 64));
        lblSach.setOpaque(true);
        lblSach.setForeground(Color.WHITE);
        lblSach.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSach.setBounds(0, 133, 187, 46);
        menuItemsPanel.add(lblSach);

        lbldocgia = new JLabel("  Độc Giả");
        lbldocgia.setIcon(new ImageIcon("img\\Readericon.png"));
        lbldocgia.setBackground(new Color(64, 64, 64));
        lbldocgia.setOpaque(true);
        lbldocgia.setForeground(Color.WHITE);
        lbldocgia.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbldocgia.setBounds(0, 192, 187, 46);
        menuItemsPanel.add(lbldocgia);

        lbltacgia = new JLabel("  Tác Giả");
        lbltacgia.setIcon(new ImageIcon("img\\Tacgia.png"));
        lbltacgia.setBackground(new Color(64, 64, 64));
        lbltacgia.setOpaque(true);
        lbltacgia.setForeground(Color.WHITE);
        lbltacgia.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbltacgia.setBounds(0, 251, 187, 46);
        menuItemsPanel.add(lbltacgia);

        lblnhaxuatban = new JLabel("  Nhà Xuất Bản");
        lblnhaxuatban.setIcon(new ImageIcon("img\\Company.png"));
        lblnhaxuatban.setBackground(new Color(64, 64, 64));
        lblnhaxuatban.setOpaque(true);
        lblnhaxuatban.setForeground(Color.WHITE);
        lblnhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblnhaxuatban.setBounds(0, 310, 187, 46);
        menuItemsPanel.add(lblnhaxuatban);

        lblnhanvien = new JLabel("  Nhân Viên");
        lblnhanvien.setIcon(new ImageIcon("img\\Staff.png"));
        lblnhanvien.setBackground(new Color(64, 64, 64));
        lblnhanvien.setOpaque(true);
        lblnhanvien.setForeground(Color.WHITE);
        lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblnhanvien.setBounds(0, 369, 187, 46);
        menuItemsPanel.add(lblnhanvien);

        lblphieumuon = new JLabel("  Phiếu Mượn");
        lblphieumuon.setIcon(new ImageIcon("img\\Note.png"));
        lblphieumuon.setOpaque(true);
        lblphieumuon.setForeground(Color.WHITE);
        lblphieumuon.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblphieumuon.setBackground(Color.DARK_GRAY);
        lblphieumuon.setBounds(0, 428, 187, 46);
        menuItemsPanel.add(lblphieumuon);

        lblphieunhap = new JLabel("  Phiếu Nhập");
        lblphieunhap.setIcon(new ImageIcon("img\\phieunhap.png"));
        lblphieunhap.setOpaque(true);
        lblphieunhap.setForeground(Color.WHITE);
        lblphieunhap.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblphieunhap.setBackground(Color.DARK_GRAY);
        lblphieunhap.setBounds(0, 487, 187, 46);
        menuItemsPanel.add(lblphieunhap);

        lblthongke = new JLabel("  Thống Kê");
        lblthongke.setIcon(new ImageIcon("img\\Combo Chart.png"));
        lblthongke.setOpaque(true);
        lblthongke.setForeground(Color.WHITE);
        lblthongke.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblthongke.setBackground(Color.DARK_GRAY);
        lblthongke.setBounds(0, 546, 187, 46);
        menuItemsPanel.add(lblthongke);

        lblchung = new JLabel("  Chung");
        lblchung.setIcon(new ImageIcon("img\\chungpng.png"));
        lblchung.setOpaque(true);
        lblchung.setForeground(Color.WHITE);
        lblchung.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblchung.setBackground(Color.DARK_GRAY);
        lblchung.setBounds(0, 605, 187, 46);
        menuItemsPanel.add(lblchung);
        
         // Thêm mục Phân quyền
        lblphanquyen = new JLabel("  Tài Khoản");
        lblphanquyen.setIcon(new ImageIcon("img\\authorization.png")); // Placeholder, thay bằng ảnh thực tế
        lblphanquyen.setOpaque(true);
        lblphanquyen.setForeground(Color.WHITE);
        lblphanquyen.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblphanquyen.setBackground(Color.DARK_GRAY);
        lblphanquyen.setBounds(0, 723, 187, 46);
        menuItemsPanel.add(lblphanquyen);
        
        lblnhomquyen = new JLabel("  Nhóm Quyền");
        lblnhomquyen.setIcon(new ImageIcon("img\\authorization2.png")); // Thay bằng đường dẫn tới biểu tượng thực tế
        lblnhomquyen.setOpaque(true);
        lblnhomquyen.setForeground(Color.WHITE);
        lblnhomquyen.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblnhomquyen.setBackground(Color.DARK_GRAY);
        lblnhomquyen.setBounds(0, 664, 187, 46); // Điều chỉnh vị trí y (782) để đặt sau mục "Đăng Xuất"
        menuItemsPanel.add(lblnhomquyen);

        lbldangxuat = new JLabel("  Đăng Xuất");
        lbldangxuat.setIcon(new ImageIcon("img\\Exit.png"));
        lbldangxuat.setOpaque(true);
        lbldangxuat.setForeground(Color.WHITE);
        lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbldangxuat.setBackground(Color.DARK_GRAY);
        lbldangxuat.setBounds(0, 782, 187, 46);
        menuItemsPanel.add(lbldangxuat);

        // Phần còn lại giữ nguyên
        PanelChinh.add(pnTrangChu, "name_890335498390600");

        JLabel lblNewLabel_17 = new JLabel("");
        lblNewLabel_17.setIcon(new ImageIcon("img\\iconsgu 3.png"));
        lblNewLabel_17.setBounds(346, 177, 401, 397);
        pnTrangChu.add(lblNewLabel_17);

        lblUser = new JLabel("");
        lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblUser.setForeground(Color.RED);
        lblUser.setBounds(458, 594, 159, 83);
        pnTrangChu.add(lblUser);
        PanelChinh.add(pnSach, "name_890193837575500");

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(
                new TitledBorder(null, "Hình Ảnh", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, null));
        panel_5.setBounds(856, 71, 177, 279);
        pnSach.add(panel_5);
        panel_5.setLayout(null);

        lblhinhanhpre = new JLabel("");
        lblhinhanhpre.setOpaque(true);
        lblhinhanhpre.setBounds(864, 77, 158, 252);
        pnSach.add(lblhinhanhpre);

        JLabel lblNewLabel_3_1 = new JLabel("Tìm kiếm");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(77, 387, 112, 34);
        pnSach.add(lblNewLabel_3_1);

        txttimsach = new JTextField();
        txttimsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttimsach.setColumns(10);
        txttimsach.setBounds(221, 387, 292, 34);
        pnSach.add(txttimsach);

        JButton btnTm_1 = new JButton("Tìm");
        btnTm_1.setIcon(new ImageIcon("img\\Search.png"));
        btnTm_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTm_1.setBounds(554, 380, 112, 51);
        pnSach.add(btnTm_1);

        PanelChinh.add(pndocgia, "name_890203323464100");
        PanelChinh.add(pntacgia, "name_890226525489300");

        lblTmKim = new JLabel("Tìm Kiếm");
        lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTmKim.setBounds(168, 380, 152, 37);
        pntacgia.add(lblTmKim);

        txttimtacgia = new JTextField();
        txttimtacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttimtacgia.setColumns(10);
        txttimtacgia.setBounds(301, 380, 267, 37);
        pntacgia.add(txttimtacgia);

        btnTm_2 = new JButton("Tìm ");
        btnTm_2.setIcon(new ImageIcon("img\\Search.png"));
        btnTm_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTm_2.setBounds(617, 371, 126, 54);
        pntacgia.add(btnTm_2);
        PanelChinh.add(pnnhaxuatban, "name_890210577532500");

        JButton btnTimnxb = new JButton("Tìm");
        btnTimnxb.setIcon(new ImageIcon("img\\Search.png"));
        btnTimnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTimnxb.setBounds(770, 415, 108, 47);
        pnnhaxuatban.add(btnTimnxb);
        PanelChinh.add(pnnhanvien, "name_890389477283600");

        JLabel lblNewLabel_15 = new JLabel("");
        lblNewLabel_15.setIcon(new ImageIcon("img\\searchbar-removebg-preview.png"));
        lblNewLabel_15.setBounds(268, 392, 532, 52);
        pnnhanvien.add(lblNewLabel_15);
        PanelChinh.add(pnPhieumuon, "name_901238608974900");
        pnPhieumuon.setLayout(null);

        panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(12, 13, 516, 294);
        pnPhieumuon.add(panel_3);
        panel_3.setLayout(null);

        lblNewLabel_1 = new JLabel("Mã PM");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(12, 13, 82, 36);
        panel_3.add(lblNewLabel_1);

        lblNewLabel_4 = new JLabel("Mã NV");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_4.setBounds(12, 61, 82, 36);
        panel_3.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Mã Đọc Giả");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_5.setBounds(12, 110, 97, 36);
        panel_3.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Ngày Mượn");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_6.setBounds(12, 171, 97, 36);
        panel_3.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("Tình Trạng");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_7.setBounds(12, 227, 82, 36);
        panel_3.add(lblNewLabel_7);

        txtmapm = new JTextField();
        txtmapm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtmapm.setEditable(false);
        txtmapm.setBounds(111, 14, 236, 36);
        panel_3.add(txtmapm);
        txtmapm.setColumns(10);

        btnthemphieumuon = new JButton("Thêm");
        btnthemphieumuon.setIcon(new ImageIcon("img\\Add.png"));
        btnthemphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnthemphieumuon.setBounds(380, 13, 117, 49);
        panel_3.add(btnthemphieumuon);

        btnsuaphieumuon = new JButton("Sửa");
        btnsuaphieumuon.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuaphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuaphieumuon.setBounds(380, 83, 117, 49);
        panel_3.add(btnsuaphieumuon);

        btnxoaphieumuon = new JButton("Xoá");
        btnxoaphieumuon.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoaphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoaphieumuon.setBounds(380, 155, 117, 49);
        panel_3.add(btnxoaphieumuon);

        btnreloadphieumuon = new JButton("Tải Lại");
        btnreloadphieumuon.setIcon(new ImageIcon("img\\update.png"));
        btnreloadphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnreloadphieumuon.setBounds(380, 228, 117, 49);
        panel_3.add(btnreloadphieumuon);

        cmbnhanvienpm = new JComboBox();
        cmbnhanvienpm.setBounds(111, 62, 236, 36);
        panel_3.add(cmbnhanvienpm);

        cmbmadocgiaphieumuon = new JComboBox();
        cmbmadocgiaphieumuon.setBounds(111, 114, 236, 32);
        panel_3.add(cmbmadocgiaphieumuon);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setEnabled(true);
        dateChooser.setDate(Calendar.getInstance().getTime());
        dateChooser.setBounds(111, 171, 236, 36);
        panel_3.add(dateChooser);

        rdmuon = new JRadioButton("Mượn\r\n");
        rdmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdmuon.setBounds(142, 233, 88, 25);
        panel_3.add(rdmuon);

        rdtra = new JRadioButton("Đã Trả");
        rdtra.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdtra.setBounds(245, 233, 127, 25);
        panel_3.add(rdtra);
        g = new ButtonGroup();
        g.add(rdmuon);
        g.add(rdtra);

        scrollPane_5 = new JScrollPane();
        scrollPane_5.setBounds(540, 13, 553, 294);
        pnPhieumuon.add(scrollPane_5);
        dtmmuon = new DefaultTableModel();
        dtmmuon.addColumn("Mã Phiếu Mượn");
        dtmmuon.addColumn("Mã Nhân Viên");
        dtmmuon.addColumn("Mã Đọc Giả");
        dtmmuon.addColumn("Ngày Mượn");
        dtmmuon.addColumn("Tình Trạng");

        tablemuon = new JTable(dtmmuon);
        scrollPane_5.setViewportView(tablemuon);

        lbltimkiempm = new JLabel("Tìm Kiếm");
        lbltimkiempm.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltimkiempm.setBounds(12, 331, 97, 39);
        pnPhieumuon.add(lbltimkiempm);

        txttimphieumuon = new JTextField();
        txttimphieumuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttimphieumuon.setBounds(127, 340, 317, 30);
        pnPhieumuon.add(txttimphieumuon);
        txttimphieumuon.setColumns(10);

        scrollPane_6 = new JScrollPane();
        scrollPane_6.setBounds(22, 391, 736, 331);
        pnPhieumuon.add(scrollPane_6);

        dtmctpm = new DefaultTableModel();
        dtmctpm.addColumn("Mã CTPM");
        dtmctpm.addColumn("Mã PM");
        dtmctpm.addColumn("Mã Sách");
        dtmctpm.addColumn("Ngày Trả");
        dtmctpm.addColumn("Ghi Chú");
        tablectpm = new JTable(dtmctpm);
        scrollPane_6.setViewportView(tablectpm);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(770, 391, 323, 331);
        pnPhieumuon.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_8 = new JLabel("Mã Sách");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_8.setBounds(12, 13, 91, 49);
        panel.add(lblNewLabel_8);

        txtmasachmuon = new JTextField();
        txtmasachmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtmasachmuon.setBounds(96, 21, 142, 35);
        panel.add(txtmasachmuon);
        txtmasachmuon.setColumns(10);

        JButton btnNewButton_5 = new JButton("...");
        btnNewButton_5.setBounds(263, 26, 54, 25);
        panel.add(btnNewButton_5);

        JLabel lblNewLabel_8_1 = new JLabel("Ngày Trả");
        lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_8_1.setBounds(12, 74, 91, 49);
        panel.add(lblNewLabel_8_1);

        JLabel lblNewLabel_8_1_1 = new JLabel("Ghi Chú");
        lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_8_1_1.setBounds(12, 140, 91, 49);
        panel.add(lblNewLabel_8_1_1);

        txtghichuctpm = new JTextField();
        txtghichuctpm.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtghichuctpm.setColumns(10);
        txtghichuctpm.setEditable(false);
        txtghichuctpm.setBounds(96, 148, 142, 35);
        panel.add(txtghichuctpm);

        btnthemctpm = new JButton("Thêm");
        btnthemctpm.setIcon(new ImageIcon("img\\Add.png"));
        btnthemctpm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnthemctpm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnthemctpm.setBounds(12, 227, 124, 41);
        panel.add(btnthemctpm);

        btnsuactpm = new JButton("Sửa");
        btnsuactpm.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnsuactpm.setBounds(193, 227, 124, 41);
        panel.add(btnsuactpm);

        btnxoactpm = new JButton("Xoá");
        btnxoactpm.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnxoactpm.setBounds(12, 280, 124, 41);
        panel.add(btnxoactpm);

        bnttailaictpm = new JButton("Tải Lại");
        bnttailaictpm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        bnttailaictpm.setIcon(new ImageIcon("img\\update.png"));
        bnttailaictpm.setFont(new Font("Tahoma", Font.BOLD, 13));
        bnttailaictpm.setBounds(193, 280, 121, 41);
        panel.add(bnttailaictpm);

        dateChooser_ngaytra = new JDateChooser();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(Calendar.getInstance().getTime());
        c1.roll(Calendar.DATE, 7);
        dateChooser_ngaytra.setDateFormatString("yyyy-MM-dd");
        dateChooser_ngaytra.setDate(c1.getTime());
        dateChooser_ngaytra.setBounds(96, 79, 142, 35);
        panel.add(dateChooser_ngaytra);

        btnthemphieuphat = new JButton("Phạt");
        btnthemphieuphat.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthemphieuphat.setBounds(822, 332, 117, 45);
        btnthemphieuphat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (Ma == null || Ma.isEmpty() || Ma.equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn mã phiếu mượn");
                    return;
                }
                new Phat().setVisible(true);
            }
        });
        pnPhieumuon.add(btnthemphieuphat);

        btndanhsachphat = new JButton("Danh Sách Phạt");
        btndanhsachphat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DanhSachPhat().setVisible(true);
            }
        });
        btndanhsachphat.setFont(new Font("Tahoma", Font.BOLD, 15));
        btndanhsachphat.setBounds(964, 331, 129, 47);
        pnPhieumuon.add(btndanhsachphat);

        JButton btnTimphieumuon = new JButton("Tìm");
        btnTimphieumuon.setIcon(new ImageIcon("img\\Search.png"));
        btnTimphieumuon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isNumber(txttimphieumuon.getText())) {
                    JOptionPane.showMessageDialog(null, "Phải nhập số");
                    return;
                }
                // Bỏ phần liên quan đến PhieuMuon và PhieuMuonBus
            }
        });
        btnTimphieumuon.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTimphieumuon.setBounds(472, 331, 123, 47);
        pnPhieumuon.add(btnTimphieumuon);
        PanelChinh.add(pnPhieuNhap, "name_901242535638200");
        pnPhieuNhap.setLayout(null);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Phiếu Nhập", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(22, 13, 434, 304);
        pnPhieuNhap.add(panel_6);
        panel_6.setLayout(null);

        JLabel lblNewLabel_11 = new JLabel("Mã Nhân Viên");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_11.setBounds(12, 42, 102, 33);
        panel_6.add(lblNewLabel_11);

        txtManhanvienphieunhap = new JTextField();
        txtManhanvienphieunhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtManhanvienphieunhap.setBounds(144, 43, 91, 33);
        panel_6.add(txtManhanvienphieunhap);
        txtManhanvienphieunhap.setColumns(10);

        btnmanvphieunhap = new JButton("...");
        btnmanvphieunhap.setBounds(241, 48, 48, 25);
        panel_6.add(btnmanvphieunhap);

        JLabel lblNewLabel_11_1 = new JLabel("Mã NCC");
        lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_11_1.setBounds(12, 104, 102, 33);
        panel_6.add(lblNewLabel_11_1);

        txtManccPhieuNhap = new JTextField();
        txtManccPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtManccPhieuNhap.setColumns(10);
        txtManccPhieuNhap.setBounds(144, 104, 91, 33);
        panel_6.add(txtManccPhieuNhap);

        btnmanccphieunhap = new JButton("...");
        btnmanccphieunhap.setBounds(241, 109, 48, 25);
        panel_6.add(btnmanccphieunhap);

        NgayNhapPhieuNhap = new JDateChooser();
        NgayNhapPhieuNhap.setBounds(144, 174, 145, 33);
        NgayNhapPhieuNhap.setEnabled(true);
        NgayNhapPhieuNhap.setDate(Calendar.getInstance().getTime());
        NgayNhapPhieuNhap.setDateFormatString("yyyy-MM-dd");
        panel_6.add(NgayNhapPhieuNhap);

        JLabel lblNewLabel_11_1_1 = new JLabel("Ngày Nhập");
        lblNewLabel_11_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_11_1_1.setBounds(12, 174, 102, 33);
        panel_6.add(lblNewLabel_11_1_1);

        btnthemphieunhap = new JButton("Thêm");
        btnthemphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthemphieunhap.setBounds(12, 242, 97, 46);
        panel_6.add(btnthemphieunhap);

        btnsuaphieunhap = new JButton("Sửa");
        btnsuaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnsuaphieunhap.setBounds(119, 242, 97, 46);
        panel_6.add(btnsuaphieunhap);

        btnxoaphieunhap = new JButton("Xoá");
        btnxoaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnxoaphieunhap.setBounds(226, 242, 97, 46);
        panel_6.add(btnxoaphieunhap);

        btntailai = new JButton("Tải Lại");
        btntailai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadphieunhap();
                loadctphieunhap();
            }
        });
        btntailai.setFont(new Font("Tahoma", Font.BOLD, 15));
        btntailai.setBounds(335, 242, 97, 46);
        panel_6.add(btntailai);

        JScrollPane scrollPane_9 = new JScrollPane();
        scrollPane_9.setBounds(467, 13, 614, 304);
        pnPhieuNhap.add(scrollPane_9);
        dtmphieunhap = new DefaultTableModel();
        dtmphieunhap.addColumn("Mã PN");
        dtmphieunhap.addColumn("Mã NV");
        dtmphieunhap.addColumn("Mã NCC");
        dtmphieunhap.addColumn("Mã Ngày Nhập");
        dtmphieunhap.addColumn("Tổng tiền");

        tablephieunhap = new MyTable(dtmphieunhap);
        scrollPane_9.setViewportView(tablephieunhap);

        JPanel panel_6_1 = new JPanel();
        panel_6_1.setBorder(
                new TitledBorder(null, "Chi Tiết Phiếu Nhập", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6_1.setBounds(22, 418, 422, 304);
        pnPhieuNhap.add(panel_6_1);
        panel_6_1.setLayout(null);

        lblNewLabel_12 = new JLabel("Mã Sách");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_12.setBounds(12, 60, 102, 33);
        panel_6_1.add(lblNewLabel_12);

        txtMaSachctpn = new JTextField();
        txtMaSachctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtMaSachctpn.setColumns(10);
        txtMaSachctpn.setBounds(152, 60, 91, 33);
        panel_6_1.add(txtMaSachctpn);

        btnmanvphieunhap_1 = new JButton("...");
        btnmanvphieunhap_1.setBounds(278, 65, 48, 25);
        panel_6_1.add(btnmanvphieunhap_1);

        lblNewLabel_13 = new JLabel("Số Lượng");
        lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_13.setBounds(12, 122, 102, 33);
        panel_6_1.add(lblNewLabel_13);

        txtsoluongctpn = new JTextField();
        txtsoluongctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsoluongctpn.setColumns(10);
        txtsoluongctpn.setBounds(152, 122, 91, 33);
        panel_6_1.add(txtsoluongctpn);

        lblNewLabel_14 = new JLabel("Giá Nhập");
        lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_14.setBounds(12, 183, 102, 33);
        panel_6_1.add(lblNewLabel_14);

        txtgianhap = new JTextField();
        txtgianhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtgianhap.setColumns(10);
        txtgianhap.setBounds(152, 183, 91, 33);
        panel_6_1.add(txtgianhap);

        lblmaphieunhap = new JLabel("Mã Phiếu Nhập");
        lblmaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblmaphieunhap.setBounds(12, 13, 127, 33);
        panel_6_1.add(lblmaphieunhap);

        txtmpnctpn = new JTextField();
        txtmpnctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtmpnctpn.setColumns(10);
        txtmpnctpn.setBounds(152, 13, 91, 33);
        txtmpnctpn.setEditable(false);
        txtmpnctpn.setFocusable(false);
        panel_6_1.add(txtmpnctpn);

        btnthemchitietphieunhap = new JButton("Thêm");
        btnthemchitietphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthemchitietphieunhap.setBounds(12, 245, 97, 46);
        panel_6_1.add(btnthemchitietphieunhap);

        btnsuactpn = new JButton("Sửa");
        btnsuactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnsuactpn.setBounds(138, 245, 97, 46);
        panel_6_1.add(btnsuactpn);

        btnxoactpn = new JButton("Xoá");
        btnxoactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnxoactpn.setBounds(261, 245, 97, 46);
        panel_6_1.add(btnxoactpn);

        JScrollPane scrollPane_9_1 = new JScrollPane();
        scrollPane_9_1.setBounds(456, 418, 625, 304);
        pnPhieuNhap.add(scrollPane_9_1);

        dtmchitietphieunhap = new DefaultTableModel();
        dtmchitietphieunhap.addColumn("Mã PN");
        dtmchitietphieunhap.addColumn("Mã Sách");
        dtmchitietphieunhap.addColumn("Số Lượng");
        dtmchitietphieunhap.addColumn("Đơn Giá");
        tablechitietphieunhap = new MyTable(dtmchitietphieunhap);

        scrollPane_9_1.setViewportView(tablechitietphieunhap);

        panel_7 = new JPanel();
        panel_7.setBorder(new LineBorder(new Color(253, 245, 230), 2));
        panel_7.setBounds(22, 330, 1059, 68);
        pnPhieuNhap.add(panel_7);
        panel_7.setLayout(null);

        lblNewLabel_16 = new JLabel("Tìm Kiếm");
        lblNewLabel_16.setToolTipText("Tìm Kiếm Theo Mã Phiếu Nhập");
        lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_16.setBounds(12, 17, 127, 33);
        panel_7.add(lblNewLabel_16);

        txttimphieunhap = new JTextField();
        txttimphieunhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttimphieunhap.setBounds(141, 13, 425, 42);
        panel_7.add(txttimphieunhap);
        txttimphieunhap.setColumns(10);

        // btninphieunhap = new JButton("In");
        // btninphieunhap.setIcon(new ImageIcon("img\\Print.png"));
        // btninphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        // btninphieunhap.setBounds(687, 10, 97, 46);
        // panel_7.add(btninphieunhap);

        btnxuatexcel = new JButton("Xuất\r\n");
        btnxuatexcel.setIcon(new ImageIcon("img\\Export Excel.png"));
        btnxuatexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnxuatexcel.setBounds(796, 10, 116, 46);
        panel_7.add(btnxuatexcel);

        btnnhapexcel = new JButton("Nhập");
        btnnhapexcel.setIcon(new ImageIcon("img\\Xls Import.png"));
        btnnhapexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnnhapexcel.setBounds(924, 10, 116, 46);
        panel_7.add(btnnhapexcel);

        btntimphieunhap = new JButton("");
        btntimphieunhap.setIcon(new ImageIcon("img\\Search.png"));
        btntimphieunhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isNumber(txttimphieunhap.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã Phiếu Nhập Phải Là Số");
                    return;
                }
                int mapn = Integer.parseInt(txttimphieunhap.getText());
                dtmphieunhap.setRowCount(0);
                for (PhieuNhapDTO pn : phieunhap) {
                    if (pn.getMaphieunhap() == mapn) {
                        dtmphieunhap.addRow(new Object[] {
                                pn.getMaphieunhap(),
                                pn.getManv(),
                                pn.getMancc(),
                                pn.getNgaynhap(),
                                pn.getTongTien()
                        });
                        break;
                    }
                }
            }
        });
        btntimphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btntimphieunhap.setBounds(578, 10, 97, 46);
        panel_7.add(btntimphieunhap);
        
        PanelChinh.add(pnNhomQuyen, "NhomQuyenPanel"); // Định danh rõ ràng
        pnNhomQuyen.setLayout(null);

        // Panel nhập thông tin Nhóm Quyền
        JPanel panelNhomQuyen = new JPanel();
        panelNhomQuyen.setBorder(new TitledBorder(null, "Nhóm Quyền", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelNhomQuyen.setBounds(22, 13, 434, 304);
        pnNhomQuyen.add(panelNhomQuyen);
        panelNhomQuyen.setLayout(null);

        // Nhãn và trường nhập Tên Nhóm Quyền
        JLabel lblTenNhomQuyen = new JLabel("Tên Nhóm Quyền");
        lblTenNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenNhomQuyen.setBounds(12, 42, 130, 33);
        panelNhomQuyen.add(lblTenNhomQuyen);

        txtTenNhomQuyen = new JTextField();
        txtTenNhomQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTenNhomQuyen.setBounds(144, 43, 200, 33);
        panelNhomQuyen.add(txtTenNhomQuyen);
        txtTenNhomQuyen.setColumns(10);

        // Nhãn và trường nhập Mô Tả
        JLabel lblMoTa = new JLabel("Mô Tả");
        lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMoTa.setBounds(12, 104, 102, 33);
        panelNhomQuyen.add(lblMoTa);

        txtMoTa = new JTextField();
        txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtMoTa.setBounds(144, 104, 200, 33);
        panelNhomQuyen.add(txtMoTa);
        txtMoTa.setColumns(10);

        // Các nút chức năng
        JButton btnThemNhomQuyen = new JButton("Thêm");
        btnThemNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnThemNhomQuyen.setBounds(12, 242, 97, 46);
        panelNhomQuyen.add(btnThemNhomQuyen);

        JButton btnSuaNhomQuyen = new JButton("Sửa");
        btnSuaNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSuaNhomQuyen.setBounds(119, 242, 97, 46);
        panelNhomQuyen.add(btnSuaNhomQuyen);

        JButton btnXoaNhomQuyen = new JButton("Xoá");
        btnXoaNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnXoaNhomQuyen.setBounds(226, 242, 97, 46);
        panelNhomQuyen.add(btnXoaNhomQuyen);

        JButton btnTaiLaiNhomQuyen = new JButton("Tải Lại");
        btnTaiLaiNhomQuyen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    loadNhomQuyen();
                    loadChiTietNhomQuyen();
            }
        });
        btnTaiLaiNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTaiLaiNhomQuyen.setBounds(335, 242, 97, 46);
        panelNhomQuyen.add(btnTaiLaiNhomQuyen);

        // Bảng hiển thị danh sách Nhóm Quyền
        JScrollPane scrollPaneNhomQuyen = new JScrollPane();
        scrollPaneNhomQuyen.setBounds(467, 13, 614, 304);
        pnNhomQuyen.add(scrollPaneNhomQuyen);

        dtmNhomQuyen = new DefaultTableModel();
        dtmNhomQuyen.addColumn("ID");
        dtmNhomQuyen.addColumn("Tên Nhóm Quyền");
        dtmNhomQuyen.addColumn("Mô Tả");

        tableNhomQuyen = new MyTable(dtmNhomQuyen); // Sử dụng MyTable giống pnPhieuNhap
        scrollPaneNhomQuyen.setViewportView(tableNhomQuyen);

        // Panel Chi Tiết Nhóm Quyền
        JPanel panelChiTietNhomQuyen = new JPanel();
        panelChiTietNhomQuyen.setBorder(new TitledBorder(null, "Chi Tiết Nhóm Quyền", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelChiTietNhomQuyen.setBounds(22, 418, 422, 304);
        pnNhomQuyen.add(panelChiTietNhomQuyen);
        panelChiTietNhomQuyen.setLayout(null);

        // Nhãn và trường nhập ID Nhóm Quyền (không chỉnh sửa)
        lblIdNhomQuyen = new JLabel("ID Nhóm Quyền");
        lblIdNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblIdNhomQuyen.setBounds(12, 13, 127, 33);
        panelChiTietNhomQuyen.add(lblIdNhomQuyen);

        txtIdNhomQuyen = new JTextField();
        txtIdNhomQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtIdNhomQuyen.setBounds(152, 13, 91, 33);
        txtIdNhomQuyen.setEditable(false);
        txtIdNhomQuyen.setFocusable(false);
        panelChiTietNhomQuyen.add(txtIdNhomQuyen);
        txtIdNhomQuyen.setColumns(10);

        // Nhãn và trường nhập ID Danh Mục Chức Năng
        lblIdDanhMucChucNang = new JLabel("ID Chức Năng");
        lblIdDanhMucChucNang.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblIdDanhMucChucNang.setBounds(12, 60, 102, 33);
        panelChiTietNhomQuyen.add(lblIdDanhMucChucNang);

        txtIdDanhMucChucNang = new JTextField();
        txtIdDanhMucChucNang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtIdDanhMucChucNang.setBounds(152, 60, 91, 33);
        panelChiTietNhomQuyen.add(txtIdDanhMucChucNang);
        txtIdDanhMucChucNang.setColumns(10);

        JButton btnChonChucNang = new JButton("...");
        btnChonChucNang.setBounds(278, 65, 48, 25);
        panelChiTietNhomQuyen.add(btnChonChucNang);

        // Nhãn và trường nhập Tên Chức Năng
        lblTenChucNang = new JLabel("Tên Chức Năng");
        lblTenChucNang.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenChucNang.setBounds(12, 122, 102, 33);
        panelChiTietNhomQuyen.add(lblTenChucNang);

        txtTenChucNang = new JTextField();
        txtTenChucNang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTenChucNang.setBounds(152, 122, 174, 33);
        panelChiTietNhomQuyen.add(txtTenChucNang);
        txtTenChucNang.setColumns(10);

        // Các nút chức năng cho Chi Tiết Nhóm Quyền
        JButton btnThemChiTietNhomQuyen = new JButton("Thêm");
        btnThemChiTietNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnThemChiTietNhomQuyen.setBounds(12, 245, 97, 46);
        panelChiTietNhomQuyen.add(btnThemChiTietNhomQuyen);

        JButton btnSuaChiTietNhomQuyen = new JButton("Sửa");
        btnSuaChiTietNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSuaChiTietNhomQuyen.setBounds(138, 245, 97, 46);
        panelChiTietNhomQuyen.add(btnSuaChiTietNhomQuyen);

        JButton btnXoaChiTietNhomQuyen = new JButton("Xoá");
        btnXoaChiTietNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnXoaChiTietNhomQuyen.setBounds(261, 245, 97, 46);
        panelChiTietNhomQuyen.add(btnXoaChiTietNhomQuyen);

        // Bảng hiển thị Chi Tiết Nhóm Quyền
        JScrollPane scrollPaneChiTietNhomQuyen = new JScrollPane();
        scrollPaneChiTietNhomQuyen.setBounds(456, 418, 625, 304);
        pnNhomQuyen.add(scrollPaneChiTietNhomQuyen);

        dtmChiTietNhomQuyen = new DefaultTableModel();
        dtmChiTietNhomQuyen.addColumn("ID Nhóm Quyền");
        dtmChiTietNhomQuyen.addColumn("ID Danh Mục Chức Năng");
        dtmChiTietNhomQuyen.addColumn("Tên Chức Năng");

        JTable tableChiTietNhomQuyen = new MyTable(dtmChiTietNhomQuyen);
        scrollPaneChiTietNhomQuyen.setViewportView(tableChiTietNhomQuyen);

        // Panel tìm kiếm
        JPanel panelTimKiem = new JPanel();
        panelTimKiem.setBorder(new LineBorder(new Color(253, 245, 230), 2));
        panelTimKiem.setBounds(22, 330, 1059, 68);
        pnNhomQuyen.add(panelTimKiem);
        panelTimKiem.setLayout(null);

        JLabel lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setToolTipText("Tìm Kiếm Theo Tên Nhóm Quyền");
        lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTimKiem.setBounds(12, 17, 127, 33);
        panelTimKiem.add(lblTimKiem);

        JTextField txtTimNhomQuyen = new JTextField();
        txtTimNhomQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTimNhomQuyen.setBounds(141, 13, 425, 42);
        panelTimKiem.add(txtTimNhomQuyen);
        txtTimNhomQuyen.setColumns(10);

        // Nút Tìm Kiếm
        JButton btnTimNhomQuyen = new JButton("");
        btnTimNhomQuyen.setIcon(new ImageIcon("img\\Search.png"));
        btnTimNhomQuyen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tenNhomQuyen = txtTimNhomQuyen.getText().trim();
                dtmNhomQuyen.setRowCount(0);
                // Giả sử bạn có danh sách NhomQuyenDTO
//                for (NhomQuyenDTO nq : nhomQuyen) {
//                    if (nq.getTenNhomQuyen().toLowerCase().contains(tenNhomQuyen.toLowerCase())) {
//                        dtmNhomQuyen.addRow(new Object[] {
//                            nq.getId(),
//                            nq.getTenNhomQuyen(),
//                            nq.getMoTa()
//                        });
//                    }
//                }
            }
        });
        btnTimNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTimNhomQuyen.setBounds(578, 10, 97, 46);
        panelTimKiem.add(btnTimNhomQuyen);

        // Nút Xuất Excel
        JButton btnXuatExcelNhomQuyen = new JButton("Xuất");
        btnXuatExcelNhomQuyen.setIcon(new ImageIcon("img\\Export Excel.png"));
        btnXuatExcelNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnXuatExcelNhomQuyen.setBounds(796, 10, 116, 46);
        panelTimKiem.add(btnXuatExcelNhomQuyen);

        // Nút Nhập Excel
        JButton btnNhapExcelNhomQuyen = new JButton("Nhập");
        btnNhapExcelNhomQuyen.setIcon(new ImageIcon("img\\Xls Import.png"));
        btnNhapExcelNhomQuyen.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNhapExcelNhomQuyen.setBounds(924, 10, 116, 46);
        panelTimKiem.add(btnNhapExcelNhomQuyen);
        pnchung();
        pnthongke();
    }

    private void pnchung() {
        pnchung = new JPanel();
        PanelChinh.add(pnchung, "name_903253398621700");
        pnchung.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Lo\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(69, 33, 389, 292);
        pnchung.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_9 = new JLabel("Tên Loại");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_9.setForeground(new Color(0, 0, 0));
        lblNewLabel_9.setBounds(12, 13, 79, 41);
        panel_4.add(lblNewLabel_9);

        txttenloai = new JTextField();
        txttenloai.setFont(new Font("Tahoma", Font.BOLD, 15));
        txttenloai.setBounds(120, 13, 225, 41);
        panel_4.add(txttenloai);
        txttenloai.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 142, 365, 137);
        panel_4.add(scrollPane);
        dtmloai = new DefaultTableModel();
        dtmloai.addColumn("Mã Loại");
        dtmloai.addColumn("Tên Loại");
        tableloai = new MyTable(dtmloai);
        scrollPane.setViewportView(tableloai);

        btnThemloai = new JButton("Thêm");
        btnThemloai.setBounds(12, 93, 97, 25);
        panel_4.add(btnThemloai);

        btnsualoai = new JButton("Sửa");
        btnsualoai.setBounds(149, 93, 97, 25);
        panel_4.add(btnsualoai);

        btnxoaloai = new JButton("Xoá");
        btnxoaloai.setBounds(280, 93, 97, 25);
        panel_4.add(btnxoaloai);

        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBorder(
                new TitledBorder(null, "Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4_1.setBounds(660, 33, 389, 292);
        pnchung.add(panel_4_1);
        panel_4_1.setLayout(null);

        lbltenncc = new JLabel("Tên NCC");
        lbltenncc.setForeground(Color.BLACK);
        lbltenncc.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltenncc.setBounds(12, 13, 79, 41);
        panel_4_1.add(lbltenncc);

        txtNcc = new JTextField();
        txtNcc.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtNcc.setColumns(10);
        txtNcc.setBounds(120, 13, 225, 41);
        panel_4_1.add(txtNcc);

        btnThemncc = new JButton("Thêm");
        btnThemncc.setBounds(12, 93, 97, 25);
        panel_4_1.add(btnThemncc);

        btnsuancc = new JButton("Sửa");
        btnsuancc.setBounds(149, 93, 97, 25);
        panel_4_1.add(btnsuancc);

        btnxoancc = new JButton("Xoá");
        btnxoancc.setBounds(280, 93, 97, 25);
        panel_4_1.add(btnxoancc);

        scrollPane_7 = new JScrollPane();
        scrollPane_7.setBounds(12, 147, 365, 132);
        panel_4_1.add(scrollPane_7);
        dtmncc = new DefaultTableModel();
        dtmncc.addColumn("Mã NCC");
        dtmncc.addColumn("Tên Nhà Cung Cấp");
        tablencc = new MyTable(dtmncc);
        scrollPane_7.setViewportView(tablencc);

        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBorder(new TitledBorder(null, "K\u1EC7 S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(255, 127, 80)));
        panel_4_2.setBounds(352, 408, 389, 292);
        pnchung.add(panel_4_2);
        panel_4_2.setLayout(null);

        lblNewLabel_10 = new JLabel("Tên Kệ");
        lblNewLabel_10.setForeground(Color.BLACK);
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_10.setBounds(12, 23, 79, 41);
        panel_4_2.add(lblNewLabel_10);

        txtKeSach = new JTextField();
        txtKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtKeSach.setColumns(10);
        txtKeSach.setBounds(120, 23, 225, 41);
        panel_4_2.add(txtKeSach);

        btnthemkesach = new JButton("Thêm");
        btnthemkesach.setBounds(12, 86, 97, 25);
        panel_4_2.add(btnthemkesach);

        btnsuakesach = new JButton("Sửa");
        btnsuakesach.setBounds(149, 86, 97, 25);
        panel_4_2.add(btnsuakesach);

        btnxoakesach = new JButton("Xoá");
        btnxoakesach.setBounds(280, 86, 97, 25);
        panel_4_2.add(btnxoakesach);

        scrollPane_8 = new JScrollPane();
        scrollPane_8.setBounds(12, 143, 365, 136);
        panel_4_2.add(scrollPane_8);
        dtmke = new DefaultTableModel();
        dtmke.addColumn("Mã Kệ");
        dtmke.addColumn("Tên Kệ");
        tablekesach = new MyTable(dtmke);
        scrollPane_8.setViewportView(tablekesach);

    }

    private void pnthongke() {
        panelThongKe = new JPanel();
        DefaultPieDataset p = new DefaultPieDataset();
        // Bỏ phần tính toán dùng SachBus và chitietpmbus
        int sachdamuon = ChiTietPhieuMuonBUS.getInstance().getSoLuongSachDangMuon();
        int tongsach = sachdamuon + SachBUS.gI().getTongSoLuongSach();
        float phantramsachdamuon = (float) (sachdamuon * 1.0 / tongsach * 100);
        p.setValue("Sách Đã Mượn", phantramsachdamuon); // Giá trị giả lập
        p.setValue("Sách Còn Lại", 100 - phantramsachdamuon); // Giá trị giả lập

        JFreeChart chart = ChartFactory.createPieChart3D("ấd Kê Sách Đã Mượn", p);
        TextTitle tt = new TextTitle("Thống Kê Sách Đã Mượn", new Font("Arial", Font.BOLD, 15));
        tt.setPadding(5, 5, 5, 5);
        chart.setTitle(tt);
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelFont(new Font("Arial", Font.PLAIN, 12));

        PanelChinh.add(panelThongKe, "name_8485672922600");
        panelThongKe.setLayout(null);

        btnthongkesachmuon = new JButton("Danh Sách ");
        btnthongkesachmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthongkesachmuon.setBounds(155, 347, 138, 36);
        panelThongKe.add(btnthongkesachmuon);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tabbedPane.setBounds(397, 13, 684, 709);
        panelThongKe.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Nhập Hàng", null, panel, null);
        panel.setLayout(null);
        dtmthongkenhaphang = new DefaultTableModel();
        dtmthongkenhaphang.addColumn("Mã PN");
        dtmthongkenhaphang.addColumn("Mã Sách");
        dtmthongkenhaphang.addColumn("Giá Nhập");
        dtmthongkenhaphang.addColumn("Số Lượng");
        dtmthongkenhaphang.addColumn("Thành Tiền");
        dtmthongkenhaphang.addColumn("Ngày Nhập");
        dtmthongkenhaphang.addColumn("Tên Sách");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 13, 651, 444);
        panel.add(scrollPane);
        tablethongkenhaphang = new MyTable(dtmthongkenhaphang);
        scrollPane.setViewportView(tablethongkenhaphang);

        lblNewLabel_18 = new JLabel("Lọc Theo");
        lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_18.setForeground(new Color(0, 0, 0));
        lblNewLabel_18.setBounds(27, 484, 76, 23);
        panel.add(lblNewLabel_18);

        btnlocthongke = new JButton("Lọc");
        btnlocthongke.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnlocthongke.setBounds(351, 475, 64, 40);
        panel.add(btnlocthongke);

        JLabel lblNewLabel_20 = new JLabel("Số Sách Đã Nhập");
        lblNewLabel_20.setForeground(Color.RED);
        lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_20.setBounds(448, 485, 149, 20);
        panel.add(lblNewLabel_20);

        lblsosachdanhap = new JLabel("0");
        lblsosachdanhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblsosachdanhap.setBounds(587, 484, 76, 20);
        panel.add(lblsosachdanhap);

        JLabel lblNewLabel_20_1 = new JLabel("Tổng Tiền");
        lblNewLabel_20_1.setForeground(Color.RED);
        lblNewLabel_20_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_20_1.setBounds(448, 546, 149, 20);
        panel.add(lblNewLabel_20_1);

        lbltongtien = new JLabel("0");
        lbltongtien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltongtien.setBounds(547, 546, 128, 20);
        panel.add(lbltongtien);

        comboBox = new JComboBox();
        comboBox.addItem("");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = year; i > year - 4; i--) {
            comboBox.addItem(i);
        }
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBox.getSelectedIndex() > 0) {
                    namselect = comboBox.getSelectedItem().toString();
                }
            }
        });
        comboBox.setBounds(154, 484, 149, 23);
        panel.add(comboBox);

        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setIcon(new ImageIcon("img\\update.png"));
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                loadthongkephieunhap();
            }
        });
        btnNewButton_2.setBounds(547, 605, 97, 44);
        panel.add(btnNewButton_2);

        ngaybd = new JDateChooser();
        ngaybd.setDateFormatString("yyyy-MM-dd");
        ngaybd.setBounds(154, 545, 149, 34);
        panel.add(ngaybd);

        ngayketthuc = new JDateChooser();
        ngayketthuc.setDateFormatString("yyyy-MM-dd");
        ngayketthuc.setBounds(154, 605, 149, 29);
        panel.add(ngayketthuc);

        JLabel lblNewLabel_21_1 = new JLabel("Đến");
        lblNewLabel_21_1.setForeground(Color.BLACK);
        lblNewLabel_21_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_21_1.setBounds(100, 611, 41, 23);
        panel.add(lblNewLabel_21_1);

        rdloctheonam = new JRadioButton("Năm");
        rdloctheonam.setBounds(100, 484, 92, 25);
        panel.add(rdloctheonam);

        rdloctheongay = new JRadioButton("Ngày");
        rdloctheongay.setBounds(100, 545, 76, 25);
        panel.add(rdloctheongay);
        group = new ButtonGroup();
        group.add(rdloctheonam);
        group.add(rdloctheongay);

        ChartPanel panel1 = new ChartPanel(chart);
        panel1.setBounds(12, 25, 385, 302);
        panelThongKe.add(panel1);

        panel1.setPreferredSize(new Dimension(311, 302));
        panel1.setBackground(new Color(0, 0, 0, 0));
    }

    private void nhanvien() {

        pnnhanvien = new JPanel();
        pnnhanvien.setLayout(null);

        panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(118, 51, 866, 311);
        pnnhanvien.add(panel_2);
        panel_2.setLayout(null);

        lbltennv = new JLabel("Tên");
        lbltennv.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltennv.setBounds(12, 13, 138, 39);
        panel_2.add(lbltennv);

        lblnamsinhnv = new JLabel("Năm Sinh");
        lblnamsinhnv.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnamsinhnv.setBounds(12, 83, 138, 39);
        panel_2.add(lblnamsinhnv);

        lblaCh_1 = new JLabel("Địa Chỉ");
        lblaCh_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblaCh_1.setBounds(12, 158, 138, 39);
        panel_2.add(lblaCh_1);

        lbltennv_3 = new JLabel("Giới Tính");
        lbltennv_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltennv_3.setBounds(472, 13, 138, 39);
        panel_2.add(lbltennv_3);

        lbltennv_4 = new JLabel("Số Điện Thoại");
        lbltennv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltennv_4.setBounds(472, 83, 138, 39);
        panel_2.add(lbltennv_4);

        txttennv = new JTextField();
        txttennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttennv.setBounds(162, 13, 199, 39);
        panel_2.add(txttennv);
        txttennv.setColumns(10);

        txtnamsinhnv = new JTextField();
        txtnamsinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtnamsinhnv.setColumns(10);
        txtnamsinhnv.setBounds(162, 83, 199, 39);
        panel_2.add(txtnamsinhnv);

        txtdiachinv = new JTextField();
        txtdiachinv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtdiachinv.setColumns(10);
        txtdiachinv.setBounds(162, 158, 199, 39);
        panel_2.add(txtdiachinv);

        txtsodienthoainv = new JTextField();
        txtsodienthoainv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsodienthoainv.setColumns(10);
        txtsodienthoainv.setBounds(608, 83, 199, 39);
        panel_2.add(txtsodienthoainv);

        txtgioitinhnv = new JTextField();
        txtgioitinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtgioitinhnv.setColumns(10);
        txtgioitinhnv.setBounds(608, 13, 199, 39);
        panel_2.add(txtgioitinhnv);

        btnthemnv = new JButton("Thêm");
        btnthemnv.setIcon(new ImageIcon("img\\Add.png"));
        btnthemnv.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnthemnv.setBounds(58, 245, 126, 53);
        panel_2.add(btnthemnv);

        btnsuanv = new JButton("Sửa");
        btnsuanv.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuanv.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuanv.setBounds(259, 245, 126, 53);
        panel_2.add(btnsuanv);

        btnxoanv = new JButton("Xoá\r\n");
        btnxoanv.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoanv.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoanv.setBounds(467, 245, 126, 53);
        panel_2.add(btnxoanv);

        btnreloadnv = new JButton("Tải Lại");
        btnreloadnv.setIcon(new ImageIcon("img\\update.png"));
        btnreloadnv.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnreloadnv.setBounds(688, 245, 126, 53);
        panel_2.add(btnreloadnv);

        lbltimkiem = new JLabel("Tìm kiếm");
        lbltimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltimkiem.setBounds(118, 405, 138, 39);
        pnnhanvien.add(lbltimkiem);

        txtTimKiemnv = new JTextField();
        txtTimKiemnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTimKiemnv.setBorder(new EmptyBorder(0, 0, 0, 0));
        txtTimKiemnv.setBackground(new Color(214, 217, 223));
        txtTimKiemnv.setBounds(290, 399, 425, 39);
        pnnhanvien.add(txtTimKiemnv);
        txtTimKiemnv.setColumns(10);

        scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(118, 469, 866, 253);
        pnnhanvien.add(scrollPane_4);
        dtmnhanvien = new DefaultTableModel();
        dtmnhanvien.addColumn("Mã");
        dtmnhanvien.addColumn("Họ Tên");
        dtmnhanvien.addColumn("Năm Sinh");
        dtmnhanvien.addColumn("Giới Tính");
        dtmnhanvien.addColumn("Địa Chi");
        dtmnhanvien.addColumn("SĐT");

        tablenhanvien = new MyTable(dtmnhanvien);
        scrollPane_4.setViewportView(tablenhanvien);
        popupThemtaikhoanv = new JPopupMenu();
        mnthemtaikhoan = new JMenuItem("Thêm Tài Khoản");
        mnthemtaikhoan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablenhanvien.getSelectedRow();
                if (i > -1) {
                    idtaikhoan = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
                    new TaiKhoan().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào nhân viên để thêm tài khoản");
                }

            }
        });
        mnthemtaikhoan.setBounds(0, 0, 113, 19);
        popupThemtaikhoanv.add(mnthemtaikhoan);

        addPopup(tablenhanvien, popupThemtaikhoanv);

    }

    private void nhaxuatban() {
        pnnhaxuatban = new JPanel();
        pnnhaxuatban.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(216, 64, 708, 327);
        pnnhaxuatban.add(panel_1);
        panel_1.setLayout(null);

        lblTennhaxuatban = new JLabel("Tên Nhà Xuất Bản");
        lblTennhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTennhaxuatban.setBounds(43, 38, 145, 43);
        panel_1.add(lblTennhaxuatban);

        lblaCh = new JLabel("Địa Chỉ");
        lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblaCh.setBounds(43, 104, 145, 43);
        panel_1.add(lblaCh);

        lblTennhaxuatban_2 = new JLabel("Số Điện Thoại");
        lblTennhaxuatban_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTennhaxuatban_2.setBounds(43, 172, 145, 43);
        panel_1.add(lblTennhaxuatban_2);

        txtTennhaxuatban = new JTextField();
        txtTennhaxuatban.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTennhaxuatban.setBounds(321, 44, 282, 37);
        panel_1.add(txtTennhaxuatban);
        txtTennhaxuatban.setColumns(10);

        txtdiachinxb = new JTextField();
        txtdiachinxb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtdiachinxb.setColumns(10);
        txtdiachinxb.setBounds(321, 110, 282, 37);
        panel_1.add(txtdiachinxb);

        txtsdtnxb = new JTextField();
        txtsdtnxb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsdtnxb.setColumns(10);
        txtsdtnxb.setBounds(321, 172, 282, 37);
        panel_1.add(txtsdtnxb);

        btnThemnxb = new JButton("Thêm");
        btnThemnxb.setIcon(new ImageIcon("img\\Add.png"));
        btnThemnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThemnxb.setBounds(45, 252, 108, 47);
        panel_1.add(btnThemnxb);

        btnsuanxb = new JButton("Sửa");
        btnsuanxb.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuanxb.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuanxb.setBounds(221, 252, 108, 47);
        panel_1.add(btnsuanxb);

        btnxoanxb = new JButton("Xoá");
        btnxoanxb.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoanxb.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoanxb.setBounds(387, 252, 108, 47);
        panel_1.add(btnxoanxb);

        btnreloadnxb = new JButton("Tải Lại");
        btnreloadnxb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Bỏ loadnxb()
            }
        });
        btnreloadnxb.setIcon(new ImageIcon("img\\update.png"));
        btnreloadnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnreloadnxb.setBounds(562, 252, 108, 47);
        panel_1.add(btnreloadnxb);

        lblTimKiemnxb = new JLabel("Tìm Kiếm");
        lblTimKiemnxb.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTimKiemnxb.setBounds(260, 419, 145, 43);
        pnnhaxuatban.add(lblTimKiemnxb);

        txttimnxb = new JTextField();
        txttimnxb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttimnxb.setColumns(10);
        txttimnxb.setBounds(427, 419, 282, 37);
        pnnhaxuatban.add(txttimnxb);

        scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(211, 473, 713, 249);
        pnnhaxuatban.add(scrollPane_3);
        dtmnhaxuatban = new DefaultTableModel();
        dtmnhaxuatban.addColumn("Mã Nhà Xuất Bản");
        dtmnhaxuatban.addColumn("Tên Nhà Xuất Bản");
        dtmnhaxuatban.addColumn("Địa Chỉ");
        dtmnhaxuatban.addColumn("Số Điện Thoại");
        tablenhaxuatban = new MyTable(dtmnhaxuatban);
        scrollPane_3.setViewportView(tablenhaxuatban);
    }

    private void docgia() {
        pndocgia = new JPanel();
        pndocgia.setLayout(null);

        panelthongtindocgia = new JPanel();
        panelthongtindocgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelthongtindocgia.setBounds(130, 39, 837, 252);
        pndocgia.add(panelthongtindocgia);
        panelthongtindocgia.setLayout(null);

        lblTendocgia = new JLabel("Tên Đọc Giả");
        lblTendocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTendocgia.setBounds(91, 13, 91, 36);
        panelthongtindocgia.add(lblTendocgia);

        lbldiachidocgia = new JLabel("Địa Chỉ");
        lbldiachidocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbldiachidocgia.setBounds(91, 119, 91, 36);
        panelthongtindocgia.add(lbldiachidocgia);

        lblgioitinhdocgia = new JLabel("Giới Tính");
        lblgioitinhdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblgioitinhdocgia.setBounds(453, 119, 91, 36);
        panelthongtindocgia.add(lblgioitinhdocgia);

        lblSdtdocgia = new JLabel("Số điện thoại");
        lblSdtdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSdtdocgia.setBounds(453, 13, 109, 36);
        panelthongtindocgia.add(lblSdtdocgia);

        txtTendocgia = new JTextField();
        txtTendocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTendocgia.setBounds(192, 13, 208, 36);
        panelthongtindocgia.add(txtTendocgia);
        txtTendocgia.setColumns(10);

        txtdiachidocgia = new JTextField();
        txtdiachidocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtdiachidocgia.setColumns(10);
        txtdiachidocgia.setBounds(192, 119, 208, 36);
        panelthongtindocgia.add(txtdiachidocgia);

        txtgioitinhdocgia = new JTextField();
        txtgioitinhdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtgioitinhdocgia.setColumns(10);
        txtgioitinhdocgia.setBounds(569, 119, 208, 36);
        panelthongtindocgia.add(txtgioitinhdocgia);

        txtsdtdocgia = new JTextField();
        txtsdtdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsdtdocgia.setColumns(10);
        txtsdtdocgia.setBounds(569, 13, 208, 36);
        panelthongtindocgia.add(txtsdtdocgia);

        btnthemdocgia = new JButton("Thêm");
        btnthemdocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnthemdocgia.setIcon(new ImageIcon("img\\Add.png"));
        btnthemdocgia.setBounds(84, 190, 119, 49);
        panelthongtindocgia.add(btnthemdocgia);

        btnsuadocgia = new JButton("Sửa");
        btnsuadocgia.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuadocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuadocgia.setBounds(274, 190, 119, 49);
        panelthongtindocgia.add(btnsuadocgia);

        btnxoadocgia = new JButton("Xoá");
        btnxoadocgia.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoadocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoadocgia.setBounds(496, 190, 119, 49);
        panelthongtindocgia.add(btnxoadocgia);

        btnTiLi = new JButton("Tải Lại");
        btnTiLi.setIcon(new ImageIcon("img\\update.png"));
        btnTiLi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                loaddocgia();
            }
        });
        btnTiLi.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTiLi.setBounds(693, 190, 119, 49);
        panelthongtindocgia.add(btnTiLi);

        txtTimkiemdocgia = new JTextField();
        txtTimkiemdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTimkiemdocgia.setBounds(251, 322, 442, 42);
        pndocgia.add(txtTimkiemdocgia);
        txtTimkiemdocgia.setColumns(10);

        btnTimkiemdocgia = new JButton("Tìm");
        btnTimkiemdocgia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!isNumber(txtTimkiemdocgia.getText())) {
                    JOptionPane.showMessageDialog(null, "tìm kiếm mã đọc giả phải là số");
                    return;
                }
            }
        });
        btnTimkiemdocgia.setIcon(new ImageIcon("img\\Search.png"));
        btnTimkiemdocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTimkiemdocgia.setBounds(765, 316, 120, 53);
        pndocgia.add(btnTimkiemdocgia);

        lblTimKiem = new JLabel("Tìm Kiếm");
        lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTimKiem.setBounds(98, 322, 91, 36);
        pndocgia.add(lblTimKiem);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(47, 404, 1005, 308);
        pndocgia.add(scrollPane_1);
        dtmdocgia = new DefaultTableModel();
        dtmdocgia.addColumn("Mã Đọc Giả");
        dtmdocgia.addColumn("Họ Và Tên");
        dtmdocgia.addColumn("Giới Tính");
        dtmdocgia.addColumn("Số Điện Thạoi");
        dtmdocgia.addColumn("Địa Chỉ");
        tabledocgia = new MyTable(dtmdocgia);
        scrollPane_1.setViewportView(tabledocgia);

        JPopupMenu popupMenu = new JPopupMenu();
        mntmNewMenuItem = new JMenuItem("Thẻ Thư Viện");
        mntmNewMenuItem.setBounds(0, 0, 113, 19);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tabledocgia.getSelectedRow();
                if (i > -1) {
                    int ma = Integer.parseInt(dtmdocgia.getValueAt(i, 0).toString());
                    if (false) { // Bỏ phần liên quan đến TheThuVienDAL
                        gui.TheThuVien the = new gui.TheThuVien();
                        the.setVisible(true);
                    } else {
                        int a = JOptionPane.showConfirmDialog(null,
                                "Thành Viên này chưa có thẻ bạn có muốn thêm thẻ không", "", JOptionPane.YES_NO_OPTION);
                        if (a == JOptionPane.YES_OPTION) {
                            // Bỏ phần khai báo DocGia DTO
                            gui.TheThuVien the = new gui.TheThuVien();
                            the.setVisible(true);
                        }
                    }
                }
            }
        });
        popupMenu.add(mntmNewMenuItem);
        addPopup(tabledocgia, popupMenu);
    }

    private void pntacgia() {
        pntacgia = new JPanel();
        pntacgia.setLayout(null);

        pnthongtintacgia = new JPanel();
        pnthongtintacgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnthongtintacgia.setBounds(158, 78, 607, 281);
        pntacgia.add(pnthongtintacgia);
        pnthongtintacgia.setLayout(null);

        lblTentacgia = new JLabel("Tên Tác Giả");
        lblTentacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTentacgia.setBounds(24, 51, 152, 37);
        pnthongtintacgia.add(lblTentacgia);

        txtTentacgia = new JTextField();
        txtTentacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTentacgia.setBounds(287, 51, 224, 37);
        pnthongtintacgia.add(txtTentacgia);
        txtTentacgia.setColumns(10);

        lblnamsinh = new JLabel("Năm Sinh");
        lblnamsinh.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnamsinh.setBounds(24, 116, 152, 37);
        pnthongtintacgia.add(lblnamsinh);

        txtnamsinhtacgia = new JTextField();
        txtnamsinhtacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtnamsinhtacgia.setColumns(10);
        txtnamsinhtacgia.setBounds(287, 117, 224, 37);
        pnthongtintacgia.add(txtnamsinhtacgia);

        lblTentacgia_2 = new JLabel("Quê Quán");
        lblTentacgia_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTentacgia_2.setBounds(24, 189, 152, 37);
        pnthongtintacgia.add(lblTentacgia_2);

        txtQueQuan = new JTextField();
        txtQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtQueQuan.setColumns(10);
        txtQueQuan.setBounds(287, 189, 224, 37);
        pnthongtintacgia.add(txtQueQuan);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(158, 430, 792, 281);
        pntacgia.add(scrollPane_2);

        dtmtacgia = new DefaultTableModel();
        dtmtacgia.addColumn("Mã Tác Giả");
        dtmtacgia.addColumn("Tên Tác Giả");
        dtmtacgia.addColumn("Năm Sinh");
        dtmtacgia.addColumn("Quê Quán");
        tabletacgia = new MyTable(dtmtacgia);
        scrollPane_2.setViewportView(tabletacgia);

        btnThemTacgia = new JButton("Thêm");
        btnThemTacgia.setIcon(new ImageIcon("img\\Add.png"));
        btnThemTacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThemTacgia.setBounds(819, 78, 126, 54);
        pntacgia.add(btnThemTacgia);

        btnsuatacgia = new JButton("Sửa");
        btnsuatacgia.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuatacgia.setBounds(819, 144, 126, 47);
        pntacgia.add(btnsuatacgia);

        btnxoatacgia = new JButton("Xoá");
        btnxoatacgia.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoatacgia.setBounds(819, 203, 126, 47);
        pntacgia.add(btnxoatacgia);

        btnreloadtacgia = new JButton("Tải Lại");
        btnreloadtacgia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadtacgia();
            }
        });
        btnreloadtacgia.setIcon(new ImageIcon("img\\update.png"));
        btnreloadtacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnreloadtacgia.setBounds(819, 262, 126, 47);
        pntacgia.add(btnreloadtacgia);
    }

    private void pnsach() {
        pnSach = new JPanel();
        pnSach.setLayout(null);

        lbltitlepnSach = new JLabel("Sách");
        lbltitlepnSach.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbltitlepnSach.setBounds(502, 0, 76, 77);
        pnSach.add(lbltitlepnSach);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(66, 77, 788, 273);
        pnSach.add(panel);
        panel.setLayout(null);

        lblTenSach = new JLabel("Tên Sách");
        lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenSach.setBounds(12, 13, 112, 34);
        panel.add(lblTenSach);

        lblMaLoai = new JLabel("Mã Loại");
        lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaLoai.setBounds(12, 64, 112, 34);
        panel.add(lblMaLoai);

        lblNewLabel_2 = new JLabel("Mã Nhà Xuất Bản");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(12, 111, 132, 34);
        panel.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Mã Tác Giả");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setBounds(12, 160, 112, 34);
        panel.add(lblNewLabel_3);

        lblHinhAnh = new JLabel("Hình Ảnh");
        lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblHinhAnh.setBounds(398, 13, 112, 34);
        panel.add(lblHinhAnh);

        lblnamxuatban = new JLabel("Năm Xuất Bản");
        lblnamxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnamxuatban.setBounds(398, 64, 112, 34);
        panel.add(lblnamxuatban);

        lblSLng = new JLabel("Số Lượng");
        lblSLng.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSLng.setBounds(398, 111, 112, 34);
        panel.add(lblSLng);

        lblMaKeSach = new JLabel("Mã Kệ Sách");
        lblMaKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaKeSach.setBounds(398, 160, 112, 34);
        panel.add(lblMaKeSach);

        txttensach = new JTextField();
        txttensach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txttensach.setBounds(156, 14, 203, 34);
        panel.add(txttensach);
        txttensach.setColumns(10);

        cmbmaloai = new JComboBox();
        cmbmaloai.setBounds(156, 71, 203, 27);
        cmbmaloai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbmaloai.getSelectedItem() == null) {
                    return;
                }
            }
        });
        panel.add(cmbmaloai);

        cmbmanhaxuatban = new JComboBox();
        cmbmanhaxuatban.setBounds(156, 118, 203, 27);
        cmbmanhaxuatban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbmanhaxuatban.getSelectedItem() == null) {
                    return;
                }
            }
        });
        panel.add(cmbmanhaxuatban);

        cmbmatg = new JComboBox();
        cmbmatg.setBounds(156, 160, 203, 27);
        cmbmatg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbmatg.getSelectedItem() == null) {
                    return;
                }
            }
        });
        panel.add(cmbmatg);

        cmbmakesach = new JComboBox();
        cmbmakesach.setBounds(522, 160, 207, 27);
        cmbmakesach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbmakesach.getSelectedItem() == null) {
                    return;
                }
            }
        });
        panel.add(cmbmakesach);

        txtsoluongsach = new JTextField();
        txtsoluongsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsoluongsach.setBounds(522, 111, 207, 34);
        panel.add(txtsoluongsach);
        txtsoluongsach.setColumns(10);

        txtnamxbsach = new JTextField();
        txtnamxbsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtnamxbsach.setColumns(10);
        txtnamxbsach.setBounds(522, 64, 207, 34);
        panel.add(txtnamxbsach);

        JButton btnNewButton = new JButton("Chọn Ảnh");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Bỏ xuLyChonAnh()
            }
        });
        btnNewButton.setBounds(522, 19, 112, 28);
        panel.add(btnNewButton);

        btnthemsach = new JButton("Thêm");
        btnthemsach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnthemsach.setIcon(new ImageIcon("img\\Add.png"));
        btnthemsach.setBounds(32, 206, 112, 53);
        panel.add(btnthemsach);

        btnsuasach = new JButton("Sửa");
        btnsuasach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnsuasach.setIcon(new ImageIcon("img\\Edit.png"));
        btnsuasach.setBounds(213, 206, 112, 51);
        panel.add(btnsuasach);

        btnxoasach = new JButton("Xoá");
        btnxoasach.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxoasach.setIcon(new ImageIcon("img\\Delete.png"));
        btnxoasach.setBounds(408, 206, 112, 51);
        panel.add(btnxoasach);

        btnloadlaitrang = new JButton("Tải Lại");
        btnloadlaitrang.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnloadlaitrang.setIcon(new ImageIcon("img\\update.png"));
        btnloadlaitrang.setBounds(620, 204, 112, 53);
        panel.add(btnloadlaitrang);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(39, 456, 1024, 273);
        pnSach.add(scrollPane);
        dtmsach = new DefaultTableModel();
        dtmsach.addColumn("Mã Sách");
        dtmsach.addColumn("Tên Sách");
        dtmsach.addColumn("Mã Tác Giả");
        dtmsach.addColumn("Mã Nhà Xuất Bản");
        dtmsach.addColumn("Mã Loại");
        dtmsach.addColumn("Năm Xuất Bản");
        dtmsach.addColumn("Số Lượng");
        dtmsach.addColumn("Mã Kệ");
        dtmsach.addColumn("Ảnh");

        tablesach = new MyTable(dtmsach);
        scrollPane.setViewportView(tablesach);
        JPopupMenu popupMenu = new JPopupMenu();
        mntmNewMenuItem = new JMenuItem("Thông tin chi tiết");
        mntmNewMenuItem.setBounds(0, 0, 113, 19);
        popupMenu.add(mntmNewMenuItem);

        addPopup(tablesach, popupMenu);
    }

    private void trangchu() {

        pnTrangChu = new JPanel();

        pnTrangChu.setLayout(null);

        /* PANEL NHÂN VIÊN */

        lblNewLabel = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI THƯ VIỆN TRƯỜNG ĐH SÀI GÒN");
        lblNewLabel.setForeground(new Color(255, 20, 147));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(75, 41, 945, 185);
        pnTrangChu.add(lblNewLabel);
    }

    public void addEvent() {
        btnlocthongke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int soluongsachdanhap = 0;
                int tongtien = 0;
                if (!rdloctheonam.isSelected() && !rdloctheongay.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Bạn cần chọn lọc theo ngày / năm");
                    return;
                }
                if (namselect.equals("") && ngaybd.getDate() == null && ngayketthuc.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn năm");
                    return;
                }
                if (namselect != "" && rdloctheonam.isSelected()) {
                    ngaybd.setDate(null);
                    ngayketthuc.setDate(null);
                    dtmthongkenhaphang.setRowCount(0);

                    Calendar calendar = Calendar.getInstance();
                    for (ThongKePhieuNhapDTO tk : tkpn) {
                        calendar.setTime(tk.getngaynhap());
                        if (calendar.get(Calendar.YEAR) == Integer.parseInt(namselect)) {
                            dtmthongkenhaphang.addRow(new Object[] {
                                    tk.getmaphieunhap(),
                                    tk.getmasach(),
                                    tk.getgianhap(),
                                    tk.getsoluong(),
                                    tk.getthanhtien(),
                                    tk.getngaynhap(),
                                    tk.gettensach()
                            });
                            soluongsachdanhap += tk.getsoluong();
                            tongtien += tk.getthanhtien();
                        }
                    }
                    lbltongtien.setText(tongtien + "");
                    lblsosachdanhap.setText(soluongsachdanhap + "");
                } else if (ngaybd.getDate() != null && ngayketthuc.getDate() != null && rdloctheongay.isSelected()) {
                    namselect = "";
                    comboBox.setSelectedIndex(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = ngaybd.getDate();
                    Date date2 = ngayketthuc.getDate();
                    System.out.println(date2);
                    dtmthongkenhaphang.setRowCount(0);
                    for (ThongKePhieuNhapDTO tk : tkpn) {
                        if (tk.getngaynhap().after(date1) && tk.getngaynhap().before(date2)) {
                            dtmthongkenhaphang.addRow(new Object[] {
                                    tk.getmaphieunhap(),
                                    tk.getmasach(),
                                    tk.getgianhap(),
                                    tk.getsoluong(),
                                    tk.getthanhtien(),
                                    tk.getngaynhap(),
                                    tk.gettensach()
                            });
                            soluongsachdanhap += tk.getsoluong();
                            tongtien += tk.getthanhtien();
                        }
                    }
                    lbltongtien.setText(tongtien + "");
                    lblsosachdanhap.setText(soluongsachdanhap + "");
                }
            }
        });

        btnloadlaitrang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // Bỏ loadsach()
            }
        });

        btnthongkesachmuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TableThongKePhieuMuon().setVisible(true);
            }
        });

        tablectpm.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                int i = tablectpm.getSelectedRow();
                if (i >= 0) {
                    Date date2;
                    try {
                        date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpm.getValueAt(i, 3).toString());
                        dateChooser_ngaytra.setDate(date2);
                        txtmasachmuon.setText(dtmctpm.getValueAt(i, 2).toString());
                        txtghichuctpm.setText(dtmctpm.getValueAt(i, 4).toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // btninphieunhap.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // int i = tablephieunhap.getSelectedRow();
        // if (i > -1) {
        // int ma = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
        // } else {
        // JOptionPane.showMessageDialog(null, "Bạn Chưa Click Vào Table Để Xuất Hoá
        // Đơn");
        // }
        // }
        // });

        btnxuatexcel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                export.ExportEx ex = new ExportEx();
                ex.xuatEx(tablephieunhap);

            }
        });

        btnnhapexcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                export.ImportEx ex = new ImportEx();
                ex.nhapExcel(tablephieunhap);
            }
        });

        btnmanvphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TableNhanVien().setVisible(true);
            }
        });

        btnmanccphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableNCC().setVisible(true);
            }
        });

        btnmanvphieunhap_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableSach().setVisible(true);
            }
        });

        // tablethongkenhaphang.addMouseListener(new MouseListener(){
        // @Override
        // public void mouseReleased(MouseEvent e) {
        // }
        //
        // @Override
        // public void mousePressed(MouseEvent e) {
        // }
        //
        // @Override
        // public void mouseExited(MouseEvent e) {
        // }
        //
        // @Override
        // public void mouseEntered(MouseEvent e) {
        // }
        // @Override
        // public void mouseClicked(MouseEvent e) {
        // int i = tablethongkenhaphang.getSelectedRow();
        // if (i >= 0) {
        // try {
        // txtmpnctpn.setText(dtmphieunhap.getValueAt(i, 0).toString());
        // txtManhanvienphieunhap.setText(dtmphieunhap.getValueAt(i, 1).toString());
        // txtManccPhieuNhap.setText(dtmphieunhap.getValueAt(i, 2).toString());
        // Date date2;
        // try {
        // date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dtmphieunhap.getValueAt(i,
        // 3).toString());
        // NgayNhapPhieuNhap.setDate(date2);
        // } catch (ParseException ex) {
        // ex.printStackTrace();
        // JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày nhập!", "Lỗi",
        // JOptionPane.ERROR_MESSAGE);
        // }
        // int maphieunhap = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
        // dtmchitietphieunhap.setRowCount(0);
        // for (ChiTietPhieuNhapDTO ct : ctpn) {
        // if (ct.getMaphieunhap() == maphieunhap) {
        // dtmchitietphieunhap.addRow(new Object[] {
        // ct.getMaphieunhap(),
        // ct.getMasach(),
        // ct.getSoluong(),
        // ct.getGia()
        // });
        // }
        // }
        // } catch (NumberFormatException ex) {
        // ex.printStackTrace();
        // JOptionPane.showMessageDialog(null, "Mã phiếu nhập không hợp lệ!", "Lỗi",
        // JOptionPane.ERROR_MESSAGE);
        // }
        // } else {
        // System.out.println("Không có hàng nào được chọn hoặc bảng rỗng!");
        // // Reset các trường nhập liệu
        // lblmaphieunhap.setText("Mã Phiếu Nhập");
        // txtManhanvienphieunhap.setText("");
        // txtManccPhieuNhap.setText("");
        // dtmchitietphieunhap.setRowCount(0);
        // }
        // }
        // });
        tablephieunhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablephieunhap.getSelectedRow();
                if (i >= 0) {
                    try {
                        txtmpnctpn.setText(dtmphieunhap.getValueAt(i, 0).toString());
                        txtManhanvienphieunhap.setText(dtmphieunhap.getValueAt(i, 1).toString());
                        txtManccPhieuNhap.setText(dtmphieunhap.getValueAt(i, 2).toString());
                        Date date2;
                        try {
                            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dtmphieunhap.getValueAt(i, 3).toString());
                            NgayNhapPhieuNhap.setDate(date2);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày nhập!", "Lỗi",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        int maphieunhap = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
                        dtmchitietphieunhap.setRowCount(0);
                        for (ChiTietPhieuNhapDTO ct : ctpn) {
                            if (ct.getMaphieunhap() == maphieunhap) {
                                dtmchitietphieunhap.addRow(new Object[] {
                                        ct.getMaphieunhap(),
                                        ct.getMasach(),
                                        ct.getSoluong(),
                                        ct.getGia()
                                });
                            }
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Mã phiếu nhập không hợp lệ!", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Không có hàng nào được chọn hoặc bảng rỗng!");
                    // Reset các trường nhập liệu
                    lblmaphieunhap.setText("Mã Phiếu Nhập");
                    txtManhanvienphieunhap.setText("");
                    txtManccPhieuNhap.setText("");
                    dtmchitietphieunhap.setRowCount(0);
                }
            }
        });
        tableNhomQuyen.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableNhomQuyen.getSelectedRow();
                if (i >= 0) {
                    try {
                        // Populate input fields with selected NhomQuyen data
                        txtTenNhomQuyen.setText(dtmNhomQuyen.getValueAt(i, 1).toString()); // tennhomquyen
                        txtMoTa.setText(dtmNhomQuyen.getValueAt(i, 2).toString()); // mota

                        // Get idnhomquyen of the selected row
                        int idNhomQuyen = Integer.parseInt(dtmNhomQuyen.getValueAt(i, 0).toString());

                        // Clear existing rows in ChiTietNhomQuyen table
                        dtmChiTietNhomQuyen.setRowCount(0);

                        // Populate ChiTietNhomQuyen table with matching entries
                        for (ChiTietNhomQuyenDTO ct : dsChiTietNhomQuyen) {
                            if (ct.getIdnhomquyen() == idNhomQuyen) {
                                dtmChiTietNhomQuyen.addRow(new Object[] {
                                        ct.getIdnhomquyen(),
                                        ct.getIddanhmucchucnang(),
                                        ct.getHanhdong()
                                });
                            }
                        }

                        System.out.println("Số hàng trong bảng chi tiết nhóm quyền: " + dtmChiTietNhomQuyen.getRowCount());
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Mã nhóm quyền không hợp lệ!", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Không có hàng nào được chọn hoặc bảng rỗng!");
                    // Reset input fields and ChiTietNhomQuyen table
                    txtTendocgia.setText("");
                    txtMoTa.setText("");
                    dtmChiTietNhomQuyen.setRowCount(0);
                }
            }
        });

        tablechitietphieunhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablechitietphieunhap.getSelectedRow();
                if (i >= 0) {
                    txtmpnctpn.setText(dtmchitietphieunhap.getValueAt(i, 0).toString());
                    txtMaSachctpn.setText(dtmchitietphieunhap.getValueAt(i, 1).toString());
                    txtsoluongctpn.setText(dtmchitietphieunhap.getValueAt(i, 2).toString());
                    txtgianhap.setText(dtmchitietphieunhap.getValueAt(i, 3).toString());
                }
            }
        });

        tablemuon.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                int i = tablemuon.getSelectedRow();
                if (i >= 0) {
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd")
                                .parse((String) dtmmuon.getValueAt(i, 3).toString());
                        dateChooser.setDate(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    txtmapm.setText(dtmmuon.getValueAt(i, 0).toString());
                    Ma = (dtmmuon.getValueAt(i, 0).toString());
                    String tinhtrang = dtmmuon.getValueAt(i, 4).toString();
                    if (tinhtrang.equals("Đang Mượn")) {
                        rdmuon.setSelected(true);
                    } else {
                        rdtra.setSelected(true);
                    }
                    String ngay = dtmmuon.getValueAt(i, 3).toString();
                    cmbnhanvienpm.setSelectedIndex(0);
                    cmbmadocgiaphieumuon.setSelectedIndex(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    dtmctpm.setRowCount(0);
                    Date date2;
                    try {
                        date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpm.getValueAt(0, 3).toString());
                        dateChooser_ngaytra.setDate(date2);
                        txtmasachmuon.setText(dtmctpm.getValueAt(0, 2).toString());
                        txtghichuctpm.setText(dtmctpm.getValueAt(0, 4).toString());
                    } catch (Exception e) {
                    }
                }
            }
        });
        tabledocgia.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                int i = tabledocgia.getSelectedRow();
                if (i >= 0) {
                    try {
                        txtTendocgia.setText(dtmdocgia.getValueAt(i, 1).toString());
                        txtgioitinhdocgia.setText(dtmdocgia.getValueAt(i, 2).toString());
                        txtsdtdocgia.setText(dtmdocgia.getValueAt(i, 3).toString());
                        txtdiachidocgia.setText(dtmdocgia.getValueAt(i, 4).toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu từ bảng!", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Clear the text fields if no row is selected
                    txtTendocgia.setText("");
                    txtgioitinhdocgia.setText("");
                    txtsdtdocgia.setText("");
                    txtdiachidocgia.setText("");
                }
            }
        });
        tabletacgia.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabletacgia.getSelectedRow();
                if (i >= 0) {
                    try {
                        txtTentacgia.setText(dtmtacgia.getValueAt(i, 1).toString());
                        txtnamsinhtacgia.setText(dtmtacgia.getValueAt(i, 2).toString());
                        txtQueQuan.setText(dtmtacgia.getValueAt(i, 3).toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu từ bảng!", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Clear the text fields if no row is selected
                    txtTentacgia.setText("");
                    txtnamsinhtacgia.setText("");
                    txtQueQuan.setText("");
                }
            }
        });

        lbldangxuat.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                lbldangxuat.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                lbldangxuat.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {

                setVisible(false);
                isdangxuat = true;
                new LoginForm().setVisible(true);
                return;

            }
        });
        lblchung.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                lblchung.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                lblchung.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {

                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show();
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        lblnhanvien.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

                lblnhanvien.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                lblnhanvien.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(true);
                pnPhieumuon.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });

        lblnhaxuatban.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

                lblnhaxuatban.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                lblnhaxuatban.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(true);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }

        });
        lbldocgia.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

                lbldocgia.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                lbldocgia.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(true);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });
        lblTrangchu.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                lblTrangchu.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                lblTrangchu.setBackground(Color.BLUE);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {

                pnTrangChu.show();
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show(false);
                pnPhieuNhap.show(false);
                panelThongKe.show(false);
                pnNhomQuyen.show(false);
            }
        });

        lblSach.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

                lblSach.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                lblSach.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                pnTrangChu.show(false);
                pnSach.show(true);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });
        lbltacgia.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

                lbltacgia.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                lbltacgia.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                // lblTitle.setText("Tác Giả");
                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(true);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);

                pnchung.show(false);
                panelThongKe.show(false);
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });
        lblthongke.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblthongke.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblthongke.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnchung.show(false);
                panelThongKe.show();
                pnPhieuNhap.show(false);
                pnNhomQuyen.show(false);
            }
        });

        lblphieumuon.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblphieumuon.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblphieumuon.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show();
                pnPhieuNhap.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnNhomQuyen.show(false);
            }
        });

        lblphieunhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblphieunhap.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblphieunhap.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnPhieuNhap.show();
                pnchung.show(false);
                panelThongKe.show(false);
                pnNhomQuyen.show(false);
            }
        });
        
        lblnhomquyen.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblnhomquyen.setBackground(new Color(64, 64, 64));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblnhomquyen.setBackground(Color.blue);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
//                if (idnhomquyen!=1){
//                    JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập");
//                } else {
                loadNhomQuyen();
                loadChiTietNhomQuyen();
                pnTrangChu.show(false);
                pnSach.show(false);
                pndocgia.show(false);
                pntacgia.show(false);
                pnnhaxuatban.show(false);
                pnnhanvien.show(false);
                pnPhieumuon.show(false);
                pnPhieuNhap.show(false);
                pnchung.show(false);
                panelThongKe.show(false);
                pnNhomQuyen.show();
//                }
               
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent arg0) {
                x_mouse = arg0.getX();
                y_mouse = arg0.getY();
            }

            @Override
            public void mouseDragged(MouseEvent arg0) {
                moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());
            }
        });

        tableloai.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableloai.getSelectedRow();
                if (i >= 0) {
                    txttenloai.setText(dtmloai.getValueAt(i, 1).toString());
                }
            }
        });

        tablesach.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                int selectedRow = tablesach.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        txttensach.setText(dtmsach.getValueAt(selectedRow, 1).toString());
                        cmbmaloai.setSelectedItem(dtmsach.getValueAt(selectedRow, 2).toString());
                        cmbmanhaxuatban.setSelectedItem(dtmsach.getValueAt(selectedRow, 3).toString());
                        cmbmatg.setSelectedItem(dtmsach.getValueAt(selectedRow, 4).toString());
                        cmbmakesach.setSelectedItem(dtmsach.getValueAt(selectedRow, 7).toString());
                        txtnamxbsach.setText(dtmsach.getValueAt(selectedRow, 5).toString());
                        txtsoluongsach.setText(dtmsach.getValueAt(selectedRow, 6).toString());
                        hinhanh = dtmsach.getValueAt(selectedRow, 8).toString();
                        lblhinhanhpre.setIcon(getAnhSP(hinhanh));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu từ bảng: " + ex.getMessage(), "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào trong bảng!", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        tablencc.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablencc.getSelectedRow();
                if (i >= 0) {
                    txtNcc.setText(dtmncc.getValueAt(i, 1).toString());
                }
            }
        });

        tablekesach.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablekesach.getSelectedRow();
                if (i >= 0) {
                    txtKeSach.setText("" + dtmke.getValueAt(i, 1));
                }
            }
        });

        btnthemkesach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtKeSach.getText().isEmpty()) {
                    thongbao("Kệ sách");
                }
                boolean i = KeSachBUS.gI().addKeSach(txtKeSach.getText());
                if (i) {
                    loadkesach();
                }
            }
        });

        btnsuakesach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tablekesach.getSelectedRow();
                if (i >= 0) {
                    if (txtKeSach.getText().isEmpty()) {
                        thongbao("Tên kệ sách");
                    }
                    int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
                    String tenkemoi = txtKeSach.getText();
                    KeSachDTO kesachmoi = new KeSachDTO(vitri, tenkemoi);
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa ma loai " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = KeSachBUS.gI().updateKeSach(kesachmoi);
                        if (j) {
                            loadkesach();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại nào");
                }
            }
        });

        btnxoakesach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tablekesach.getSelectedRow();
                if (i >= 0) {
                    if (txtKeSach.getText().isEmpty()) {
                        thongbao("Tên kệ sách");
                    }
                    int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ma kệ sách " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = KeSachBUS.gI().deleteKeSach(vitri);
                        if (j) {
                            loadkesach();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại nào");
                }
            }
        });

        btnxoaloai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableloai.getSelectedRow();
                if (i >= 0) {
                    int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ma loai " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = LoaiSachBUS.gI().deleteLoaiSach(vitri);
                        if (j) {
                            loadloaisach();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại nào");
                }
            }
        });

        btnThemloai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txttenloai.getText().isEmpty()) {
                    thongbao("Tên loại");
                }
                boolean i = LoaiSachBUS.gI().addLoaiSach(txttenloai.getText());
                if (i) {
                    loadloaisach();
                }
            }
        });
        btnsualoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableloai.getSelectedRow();
                if (i >= 0) {
                    if (txttenloai.getText().isEmpty()) {
                        thongbao("Tên loại");
                    }
                    int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
                    String tenloaimoi = txttenloai.getText();
                    LoaiSachDTO loaisachmoi = new LoaiSachDTO(vitri, tenloaimoi);
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa ma loại " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = LoaiSachBUS.gI().updateLoaiSach(loaisachmoi);
                        if (j) {
                            loadloaisach();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại nào");
                }
            }
        });

        btnxoancc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tablencc.getSelectedRow();
                if (i >= 0) {
                    int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ma nhà cung cấp " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = NhaCungCapBUS.gI().deleteNhaCungCap(vitri);
                        if (j) {
                            loadnhacungcap();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp nào");
                }
            }
        });

        btnThemncc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNcc.getText().isEmpty()) {
                    thongbao("Tên nhà cung cấp");
                }
                boolean i = NhaCungCapBUS.gI().addNhaCungCap(txtNcc.getText());
                if (i) {
                    loadnhacungcap();
                }
            }
        });

        btnsuancc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tablencc.getSelectedRow();
                if (i >= 0) {
                    if (txtNcc.getText().isEmpty()) {
                        thongbao("Tên nhà cung cấp");
                    }
                    int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
                    String tennccmoi = txtNcc.getText();
                    NhaCungCapDTO nhaccmoi = new NhaCungCapDTO(vitri, tennccmoi);
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa ma nhà cung cấp " + vitri, "",
                            JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = NhaCungCapBUS.gI().updateNhaCungCap(nhaccmoi);
                        if (j) {
                            loadnhacungcap();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp nào");
                }
            }
        });

        tablenhanvien.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                int i = tablenhanvien.getSelectedRow();
                if (i >= 0) {
                    try {
                        txttennv.setText(dtmnhanvien.getValueAt(i, 1).toString());
                        txtnamsinhnv.setText(dtmnhanvien.getValueAt(i, 2).toString());
                        txtgioitinhnv.setText(dtmnhanvien.getValueAt(i, 3).toString());
                        txtdiachinv.setText(dtmnhanvien.getValueAt(i, 4).toString());
                        txtsodienthoainv.setText(dtmnhanvien.getValueAt(i, 5).toString());
                   } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu từ bảng!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnsuanv.addActionListener(e -> {
    int i = tablenhanvien.getSelectedRow();
    if (i >= 0) {
        String tenNhanVien = txttennv.getText();
        String namSinh = txtnamsinhnv.getText();
        String gioiTinh = txtgioitinhnv.getText();
        String diaChi = txtdiachinv.getText();
        String soDienThoai = txtsodienthoainv.getText();

        if (tenNhanVien.isEmpty() || namSinh.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty() || soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        try {
            int namSinhInt = Integer.parseInt(namSinh);
            int maNhanVien = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
            NhanVienDTO nhanVienSua = new NhanVienDTO(maNhanVien, tenNhanVien, namSinhInt, gioiTinh, soDienThoai, null, 0.0, diaChi, 0);
            boolean result = NhanVienBUS.getInstance().updateNhanVien(nhanVienSua);

            if (result) {
                JOptionPane.showMessageDialog(contentPane, "Sửa nhân viên thành công!");
                loadnhanvien();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Sửa nhân viên thất bại!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(contentPane, "Năm sinh phải là số!");
        }
    } else {
        JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
    }
});

        btnthemnv.addActionListener(e -> {
    String tenNhanVien = txttennv.getText();
    String namSinh = txtnamsinhnv.getText();
    String gioiTinh = txtgioitinhnv.getText();
    String diaChi = txtdiachinv.getText();
    String soDienThoai = txtsodienthoainv.getText();

    if (tenNhanVien.isEmpty() || namSinh.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty() || soDienThoai.isEmpty()) {
        JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
        return;
    }

    try {
        int namSinhInt = Integer.parseInt(namSinh);
        NhanVienDTO nhanVienMoi = new NhanVienDTO(0, tenNhanVien, namSinhInt, gioiTinh, soDienThoai, null, 0.0, diaChi, 0);
        boolean result = NhanVienBUS.getInstance().addNhanVien(nhanVienMoi);

        if (result) {
            JOptionPane.showMessageDialog(contentPane, "Thêm nhân viên thành công!");
            loadnhanvien();
        } else {
            JOptionPane.showMessageDialog(contentPane, "Thêm nhân viên thất bại!");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(contentPane, "Năm sinh phải là số!");
    }
});

       btnxoanv.addActionListener(e -> {
    int i = tablenhanvien.getSelectedRow();
    if (i >= 0) {
        int maNhanVien = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá?", "", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean result = NhanVienBUS.getInstance().deleteNhanVien(maNhanVien);

            if (result) {
                JOptionPane.showMessageDialog(contentPane, "Xoá nhân viên thành công!");
                loadnhanvien();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Xoá nhân viên thất bại!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
    }
});

        txtTimKiemnv.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent arg0) {
                searchNv();
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                searchNv();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                searchNv();
            }

            public void searchNv() {
                try {
                    dtmnhanvien.setRowCount(0);
                    if (txtTimKiemnv.getText().isEmpty()) {
                        return;
                    }
                    String s = txtTimKiemnv.getText().toLowerCase();
                } catch (Exception e) {
                }
            }
        });

        tablenhaxuatban.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                int i = tablenhaxuatban.getSelectedRow();
                if (i >= 0) {
                    txtTennhaxuatban.setText(dtmnhaxuatban.getValueAt(i, 1).toString());
                    txtdiachinxb.setText(dtmnhaxuatban.getValueAt(i, 2).toString());
                    txtsdtnxb.setText(dtmnhaxuatban.getValueAt(i, 3).toString());
                }
            }
 
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int selectedRow = tablenhaxuatban.getSelectedRow();
                if (selectedRow >= 0) {
                    txtTennhaxuatban.setText(dtmnhaxuatban.getValueAt(selectedRow, 1).toString());
                    txtdiachinxb.setText(dtmnhaxuatban.getValueAt(selectedRow, 2).toString());
                    txtsdtnxb.setText(dtmnhaxuatban.getValueAt(selectedRow, 3).toString());
                }
            }
        });

       btnThemnxb.addActionListener(e -> {
    String tennxb = txtTennhaxuatban.getText();
    String diachi = txtdiachinxb.getText();
    String sdt = txtsdtnxb.getText();

    if (tennxb.isEmpty() || diachi.isEmpty() || sdt.isEmpty()) {
        JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
        return;
    }

    try {
        NhaXuatBanDTO nxbMoi = new NhaXuatBanDTO(0, tennxb, diachi, sdt);
        boolean result = NhaXuatBanBUS.getInstance().addNhaXuatBan(nxbMoi);

        if (result) {
            JOptionPane.showMessageDialog(contentPane, "Thêm nhà xuất bản thành công!");
            loadnxb();
        } else {
            JOptionPane.showMessageDialog(contentPane, "Thêm nhà xuất bản thất bại!");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi: " + ex.getMessage());
    }
});

        
        btnsuanxb.addActionListener(e -> {
    int i = tablenhaxuatban.getSelectedRow();
    if (i >= 0) {
        String tennxb = txtTennhaxuatban.getText();
        String diachi = txtdiachinxb.getText();
        String sdt = txtsdtnxb.getText();

        if (tennxb.isEmpty() || diachi.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        try {
            int manxb = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
            NhaXuatBanDTO nxbSua = new NhaXuatBanDTO(manxb, tennxb, diachi, sdt);
            boolean result = NhaXuatBanBUS.getInstance().updateNhaXuatBan(nxbSua);

            if (result) {
                JOptionPane.showMessageDialog(contentPane, "Sửa nhà xuất bản thành công!");
                loadnxb();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Sửa nhà xuất bản thất bại!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
    }
});
        
        btnxoanxb.addActionListener(e -> {
    int i = tablenhaxuatban.getSelectedRow();
    if (i >= 0) {
        int maNXB = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá?", "", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean result = NhaXuatBanBUS.getInstance().deleteNhaXuatBan(maNXB);

            if (result) {
                JOptionPane.showMessageDialog(contentPane, "Xoá nhà xuất bản thành công!");
                loadnxb();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Xoá nhà xuất bản thất bại!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
    }
});
        
        
        btnThemTacgia.addActionListener(e -> {
            String tenTacGia = txtTentacgia.getText();
            String namSinh = txtnamsinhtacgia.getText();
            String queQuan = txtQueQuan.getText();

            if (tenTacGia.isEmpty() || namSinh.isEmpty() || queQuan.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
                return;
            }

            try {
                int namSinhInt = Integer.parseInt(namSinh);
                TacGiaDTO tacGiaMoi = new TacGiaDTO(0, tenTacGia, namSinhInt, queQuan);
                boolean result = TacGiaBUS.gI().addTacGia(tacGiaMoi);

                if (result) {
                    JOptionPane.showMessageDialog(contentPane, "Thêm tác giả thành công!");
                    loadtacgia();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Thêm tác giả thất bại!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(contentPane, "Năm sinh phải là số!");
            }
        });

        btnsuatacgia.addActionListener(e -> {
            int i = tabletacgia.getSelectedRow();
            if (i >= 0) {
                String tenTacGia = txtTentacgia.getText();
                String namSinh = txtnamsinhtacgia.getText();
                String queQuan = txtQueQuan.getText();

                if (tenTacGia.isEmpty() || namSinh.isEmpty() || queQuan.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
                    return;
                }

                try {
                    int namSinhInt = Integer.parseInt(namSinh);
                    int maTacGia = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
                    TacGiaDTO tacGiaSua = new TacGiaDTO(maTacGia, tenTacGia, namSinhInt, queQuan);
                    boolean result = TacGiaBUS.gI().updateTacGia(tacGiaSua);

                    if (result) {
                        JOptionPane.showMessageDialog(contentPane, "Sửa tác giả thành công!");
                        loadtacgia();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Sửa tác giả thất bại!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Năm sinh phải là số!");
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
            }
        });

        btnxoatacgia.addActionListener(e -> {
            int i = tabletacgia.getSelectedRow();
            if (i >= 0) {
                int maTacGia = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá?", "", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    boolean result = TacGiaBUS.gI().deleteTacGia(maTacGia);

                    if (result) {
                        JOptionPane.showMessageDialog(contentPane, "Xoá tác giả thành công!");
                        loadtacgia();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Xoá tác giả thất bại!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào bảng!");
            }
        });

        // Thêm độc giả
        btnthemdocgia.addActionListener(e -> {
            try {
                String tenDocGia = txtTendocgia.getText().trim();
                String gioiTinh = txtgioitinhdocgia.getText().trim();
                String soDienThoai = txtsdtdocgia.getText().trim();
                String diaChi = txtdiachidocgia.getText().trim();

                if (tenDocGia.isEmpty() || gioiTinh.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
                    return;
                }

                DocGiaDTO docGiaMoi = new DocGiaDTO(0, tenDocGia, gioiTinh, soDienThoai, diaChi);
                boolean result = DocGiaBUS.gI().addDocGia(docGiaMoi);

                if (result) {
                    JOptionPane.showMessageDialog(contentPane, "Thêm độc giả thành công!");
                    loaddocgia();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Thêm độc giả thất bại!");
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(contentPane, "Dữ liệu không hợp lệ: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi không xác định: " + ex.getMessage());
            }
        });

        // Sửa độc giả
        btnsuadocgia.addActionListener(e -> {
            int selectedRow = tabledocgia.getSelectedRow();
            if (selectedRow >= 0) {
                try {
                    int maDocGia = Integer.parseInt(dtmdocgia.getValueAt(selectedRow, 0).toString());
                    String tenDocGia = txtTendocgia.getText().trim();
                    String gioiTinh = txtgioitinhdocgia.getText().trim();
                    String soDienThoai = txtsdtdocgia.getText().trim();
                    String diaChi = txtdiachidocgia.getText().trim();

                    if (tenDocGia.isEmpty() || gioiTinh.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin!");
                        return;
                    }

                    DocGiaDTO docGiaSua = new DocGiaDTO(maDocGia, tenDocGia, gioiTinh, soDienThoai, diaChi);
                    boolean result = DocGiaBUS.gI().updateDocGia(docGiaSua);

                    if (result) {
                        JOptionPane.showMessageDialog(contentPane, "Sửa độc giả thành công!");
                        loaddocgia();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Sửa độc giả thất bại!");
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Dữ liệu không hợp lệ: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi không xác định: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một độc giả trong bảng để sửa!");
            }
        });

        // Xóa độc giả
        btnxoadocgia.addActionListener(e -> {
            int selectedRow = tabledocgia.getSelectedRow();
            if (selectedRow >= 0) {
                int maDocGia = Integer.parseInt(dtmdocgia.getValueAt(selectedRow, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá độc giả này?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        boolean result = DocGiaBUS.gI().deleteDocGia(maDocGia);

                        if (result) {
                            JOptionPane.showMessageDialog(contentPane, "Xoá độc giả thành công!");
                            loaddocgia();
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Xoá độc giả thất bại!");
                        }
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(contentPane, "Dữ liệu không hợp lệ: " + ex.getMessage());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi không xác định: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một độc giả trong bảng để xoá!");
            }
        });

        btnthemsach.addActionListener(e -> {
            String tensach = txttensach.getText();
            int namxb;
            try {
                namxb = Integer.parseInt(txtnamxbsach.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Năm xuất bản phải là số");
                return;
            }
            int soluong;
            try {
                soluong = Integer.parseInt(txtsoluongsach.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Số lượng phải là số");
                return;
            }
            String maloai = cmbmaloai.getSelectedItem().toString().split(" - ")[0];
            String manxb = cmbmanhaxuatban.getSelectedItem().toString().split(" - ")[0];
            String matg = cmbmatg.getSelectedItem().toString().split(" - ")[0];
            String make = cmbmakesach.getSelectedItem().toString().split(" - ")[0];

            if (tensach.isEmpty() || maloai.isEmpty() || manxb.isEmpty() || matg.isEmpty() || make.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
                return;
            }

            SachDTO sach = new SachDTO(0, tensach, maloai, manxb, matg, namxb, soluong, make, hinhanh);
            try {
                boolean result = SachBUS.gI().addSach(sach);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Thêm sách thành công");
                    loadsach();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm sách thất bại");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage());
            }
        });

        // Thêm sách
        btnthemsach.addActionListener(e -> {
            try {
                String tensach = txttensach.getText().trim();
                int namxb = Integer.parseInt(txtnamxbsach.getText().trim());
                int soluong = Integer.parseInt(txtsoluongsach.getText().trim());
                String maloai = cmbmaloai.getSelectedItem().toString().split(" - ")[0];
                String manxb = cmbmanhaxuatban.getSelectedItem().toString().split(" - ")[0];
                String matg = cmbmatg.getSelectedItem().toString().split(" - ")[0];
                String make = cmbmakesach.getSelectedItem().toString().split(" - ")[0];

                if (tensach.isEmpty() || maloai.isEmpty() || manxb.isEmpty() || matg.isEmpty() || make.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                    return;
                }

                SachDTO sach = new SachDTO(0, tensach, Integer.parseInt(maloai), Integer.parseInt(manxb), namxb,
                        soluong, Integer.parseInt(make), hinhanh);
                boolean result = SachBUS.gI().addSach(sach);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Thêm sách thành công!");
                    loadsach();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm sách thất bại!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Năm xuất bản và số lượng phải là số!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage());
            }
        });

        // Sửa sách
        btnsuasach.addActionListener(e -> {
            int selectedRow = tablesach.getSelectedRow();
            if (selectedRow >= 0) {
                try {
                    int masach = Integer.parseInt(dtmsach.getValueAt(selectedRow, 0).toString());
                    String tensach = txttensach.getText().trim();
                    int namxb = Integer.parseInt(txtnamxbsach.getText().trim());
                    int soluong = Integer.parseInt(txtsoluongsach.getText().trim());
                    String maloai = cmbmaloai.getSelectedItem().toString().split(" - ")[0];
                    String manxb = cmbmanhaxuatban.getSelectedItem().toString().split(" - ")[0];
                    String matg = cmbmatg.getSelectedItem().toString().split(" - ")[0];
                    String make = cmbmakesach.getSelectedItem().toString().split(" - ")[0];

                    if (tensach.isEmpty() || maloai.isEmpty() || manxb.isEmpty() || matg.isEmpty() || make.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                        return;
                    }

                    SachDTO sach = new SachDTO(masach, tensach, Integer.parseInt(maloai), Integer.parseInt(manxb),
                            namxb, soluong, Integer.parseInt(make), hinhanh);
                    boolean result = SachBUS.gI().updateSach(sach);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Sửa sách thành công!");
                        loadsach();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa sách thất bại!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Năm xuất bản và số lượng phải là số!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một sách trong bảng để sửa!");
            }
        });

        // Xóa sách
        btnxoasach.addActionListener(e -> {
            int selectedRow = tablesach.getSelectedRow();
            if (selectedRow >= 0) {
                int masach = Integer.parseInt(dtmsach.getValueAt(selectedRow, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá sách này?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        boolean result = SachBUS.gI().deleteSach(masach);
                        if (result) {
                            JOptionPane.showMessageDialog(null, "Xoá sách thành công!");
                            loadsach();
                        } else {
                            JOptionPane.showMessageDialog(null, "Xoá sách thất bại!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một sách trong bảng để xoá!");
            }
        });

        btnsuaphieumuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablemuon.getSelectedRow();
                if (i >= 0) {
                    if (dateChooser.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngày");
                        return;
                    }
                    if (!rdmuon.isSelected() && !rdtra.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa chọn tình trạng");
                        return;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String ngaymuon = sdf.format(dateChooser.getDate());
                    int vitri = Integer.parseInt(dtmmuon.getValueAt(i, 0).toString());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });

        btnxoaphieumuon.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int i = tablemuon.getSelectedRow();
        if (i >= 0) {
            int maPhieuMuon = Integer.parseInt(dtmmuon.getValueAt(i, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá phiếu mượn này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    boolean result = PhieuMuonBUS.getInstance().deletePhieuMuon(maPhieuMuon);
                    if (result) {
                        JOptionPane.showMessageDialog(contentPane, "Xóa phiếu mượn thành công!");
                        loadphieumuon(); // Tải lại danh sách phiếu mượn
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Xóa phiếu mượn thất bại!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(contentPane, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn phiếu mượn nào trong bảng!");
        }
    }
});
        btnthemctpm.addActionListener(new ActionListener() {
            private String ngaymuon2;

            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String ngaytra;
                try {
                    ngaytra = sdf.format(dateChooser_ngaytra.getDate());
                    ngaymuon2 = sdf.format(dateChooser.getDate());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Ngày sai");
                    return;
                }
                if (!isNumber(txtmapm.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu mượn sai");
                    return;
                }
                if (!isNumber(txtmapm.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu mượn sai");
                    return;
                }
                if (!isNumber(txtmasachmuon.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã sách mượn sai");
                    return;
                }
            }
        });

        btnsuactpm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablectpm.getSelectedRow();
                if (i >= 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String ngaymuon2;
                    String ngaytra;
                    try {
                        ngaytra = sdf.format(dateChooser_ngaytra.getDate());
                        ngaymuon2 = sdf.format(dateChooser.getDate());
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Ngày sai");
                        return;
                    }
                    int mactpm = Integer.parseInt(dtmctpm.getValueAt(i, 0).toString());
                    int mapm = Integer.parseInt(dtmctpm.getValueAt(i, 1).toString());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });

        btnxoactpm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablectpm.getSelectedRow();
                if (i >= 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String ngaytra = sdf.format(dateChooser_ngaytra.getDate());
                    int mactpm = Integer.parseInt(dtmctpm.getValueAt(i, 0).toString());
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá", "", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        // Không có thông báo GUI ở đây
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });

        btnthemphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (txtManhanvienphieunhap.getText().isEmpty()) {
                    thongbao("Mã nhân viên");
                    return;
                }
                if (txtManccPhieuNhap.getText().isEmpty()) {
                    thongbao("Mã NCC");
                    return;
                }
                if (NgayNhapPhieuNhap.getDate() == null) {
                    thongbao("Ngày Nhập");
                    return;
                }

                PhieuNhapDTO phieunhapmoi = new PhieuNhapDTO();
                phieunhapmoi.setNgaynhap(NgayNhapPhieuNhap.getDate());
                phieunhapmoi.setManv(Integer.parseInt(txtManhanvienphieunhap.getText()));
                phieunhapmoi.setMancc(Integer.parseInt(txtManccPhieuNhap.getText()));
                boolean i = PhieuNhapBUS.gI().addPhieuNhap(phieunhapmoi);
                if (i) {
                    loadphieunhap();
                    dtmchitietphieunhap.setRowCount(0);
                    txtMaSachctpn.requestFocusInWindow();
                }
                // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                // String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
                // int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
                // int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
            }
        });

        btnsuaphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablephieunhap.getSelectedRow();
                if (i >= 0) {
                    if (txtManhanvienphieunhap.getText().isEmpty()) {
                        thongbao("Mã nhân viên");
                        return;
                    }
                    if (txtManccPhieuNhap.getText().isEmpty()) {
                        thongbao("Mã nhà cung cấp");
                        return;
                    }
                    if (NgayNhapPhieuNhap.getDate() == null) {
                        thongbao("Ngày nhập");
                        return;
                    }

                    int maphieunhap = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
                    int manv = Integer.parseInt(txtManhanvienphieunhap.getText());
                    int mancc = Integer.parseInt(txtManccPhieuNhap.getText());
                    Date ngaysua = NgayNhapPhieuNhap.getDate();
                    PhieuNhapDTO phieunhapsua = new PhieuNhapDTO(maphieunhap, mancc, manv, ngaysua);
                    boolean j = PhieuNhapBUS.gI().updatePhieuNhap(phieunhapsua);
                    if (j) {
                        loadphieunhap();
                        txtMaSachctpn.requestFocusInWindow();
                        JOptionPane.showMessageDialog(contentPane, "Đã sửa phiếu nhập có mã " + mapn);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });

        btnxoaphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablephieunhap.getSelectedRow();
                if (i >= 0) {
                    int mapn = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
                    if (JOptionPane.showConfirmDialog(contentPane, "Bạn chắc chắn xóa", "",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        boolean t = ChiTietPhieuNhapBUS.gI().deleteByMaPN(mapn);
                        boolean j = PhieuNhapBUS.gI().deletePhieuNhap(mapn);

                        if (j) {
                            loadphieunhap();
                            JOptionPane.showMessageDialog(contentPane, "Đã xóa phiếu nhập có mã " + mapn);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn cột nào");
                }
            }
        });

        btnthemchitietphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (txtmpnctpn.getText().isEmpty()) {
                    thongbao("Hãy chọn mã phiếu nhập mà bạn cần thêm chi tiết phiếu nhập");
                    return;
                }
                if (txtMaSachctpn.getText().isEmpty()) {
                    thongbao("Mã sách");
                    return;
                }
                if (!isNumber(txtsoluongctpn.getText())) {
                    JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
                    return;
                }
                if (txtsoluongctpn.getText().isEmpty()) {
                    thongbao("Số lượng");
                    return;
                }
                if (!isNumber(txtgianhap.getText())) {
                    JOptionPane.showMessageDialog(null, "Giá nhập phải là số");
                    return;
                }
                if (txtgianhap.getText().isEmpty()) {
                    thongbao("Giá nhập");
                    return;
                }
                int mapn = Integer.parseInt(txtmpnctpn.getText());
                int masach = Integer.parseInt(txtMaSachctpn.getText());
                int sl = Integer.parseInt(txtsoluongctpn.getText());
                double gia = Double.parseDouble(txtgianhap.getText());

                ChiTietPhieuNhapDTO ctpnmoi = new ChiTietPhieuNhapDTO(mapn, masach, gia, sl);
                boolean j = ChiTietPhieuNhapBUS.gI().addChiTietPhieuNhap(ctpnmoi);
                if (j) {
                    ctpn.add(ctpnmoi);
                    boolean t = PhieuNhapBUS.gI().updateTongTienByMaPN(mapn);
                    loadphieunhap();
                    dtmchitietphieunhap.setRowCount(0);
                    for (ChiTietPhieuNhapDTO ct : ctpn) {
                        if (ct.getMaphieunhap() == mapn) {
                            dtmchitietphieunhap.addRow(new Object[] {
                                    ct.getMaphieunhap(),
                                    ct.getMasach(),
                                    ct.getSoluong(),
                                    ct.getGia()
                            });
                        }
                    }
                }
            }
        });

        btnxoactpn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablechitietphieunhap.getSelectedRow();
                if (i >= 0) {
                    int mapn = Integer.parseInt(txtmpnctpn.getText());
                    int masach = Integer.parseInt(txtMaSachctpn.getText());
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá", "", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        boolean j = ChiTietPhieuNhapBUS.gI().deleteChiTietPhieuNhap(mapn, masach);
                        if (j) {
                            ctpn.removeLast();
                            boolean t = PhieuNhapBUS.gI().updateTongTienByMaPN(mapn);
                            loadphieunhap();
                            dtmchitietphieunhap.setRowCount(0);
                            for (ChiTietPhieuNhapDTO ct : ctpn) {
                                if (ct.getMaphieunhap() == mapn) {
                                    dtmchitietphieunhap.addRow(new Object[] {
                                            ct.getMaphieunhap(),
                                            ct.getMasach(),
                                            ct.getSoluong(),
                                            ct.getGia()
                                    });
                                }
                            }
                            JOptionPane.showMessageDialog(contentPane,
                                    "Đã xóa sản phẩm có mã phiếu nhập " + mapn + " và mã sách " + masach);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });

        btnsuactpn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tablechitietphieunhap.getSelectedRow();
                if (i >= 0) {
                    if (txtMaSachctpn.getText().isEmpty()) {
                        thongbao("Mã sách");
                        return;
                    }
                    if (!isNumber(txtsoluongctpn.getText())) {
                        JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
                        return;
                    }
                    if (txtsoluongctpn.getText().isEmpty()) {
                        thongbao("Số lượng");
                        return;
                    }
                    if (!isNumber(txtgianhap.getText())) {
                        JOptionPane.showMessageDialog(null, "Giá nhập phải là số");
                        return;
                    }
                    if (txtgianhap.getText().isEmpty()) {
                        thongbao("Giá nhập");
                        return;
                    }
                    int mapn = Integer.parseInt(txtmpnctpn.getText());
                    int masach = Integer.parseInt(dtmchitietphieunhap.getValueAt(i, 1).toString());
                    int sl = Integer.parseInt(txtsoluongctpn.getText());
                    double gia = Double.parseDouble(txtgianhap.getText());

                    ChiTietPhieuNhapDTO ctpnmoi = new ChiTietPhieuNhapDTO(mapn, masach, gia, sl);
                    boolean j = ChiTietPhieuNhapBUS.gI().updateChiTietPhieuNhap(ctpnmoi);
                    if (j) {
                        boolean t = PhieuNhapBUS.gI().updateTongTienByMaPN(mapn);
                        loadphieunhap();
                        loadctphieunhap();
                        dtmchitietphieunhap.setRowCount(0);
                        for (ChiTietPhieuNhapDTO ct : ctpn) {
                            if (ct.getMaphieunhap() == mapn) {
                                dtmchitietphieunhap.addRow(new Object[] {
                                        ct.getMaphieunhap(),
                                        ct.getMasach(),
                                        ct.getSoluong(),
                                        ct.getGia()
                                });
                            }
                        }
                        JOptionPane.showMessageDialog(contentPane,
                                "Đã sửa sản phẩm có mã phiếu nhập " + mapn + " và mã sách " + masach);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
                }
            }
        });
    }

    private void moveFrame(int x, int y) {
        this.setLocation(x - x_mouse, y - y_mouse);
    }

    public static ArrayList<LoaiSachDTO> loasachlist = new ArrayList<LoaiSachDTO>();

    public void loadloaisach() {
        System.out.println("Đã gọi loadloaisach");
        dtmloai.setRowCount(0); // Xóa tất cả hàng hiện tại trong bảng
        cmbmaloai.removeAllItems(); // Xóa tất cả mục trong combobox
        loasachlist = LoaiSachBUS.gI().getAllLoaiSach(); // Lấy danh sách loại sách

        for (LoaiSachDTO loai : loasachlist) {
            // Thêm vào bảng dtmloai
            dtmloai.addRow(new Object[] {
                    loai.getMaloai(),
                    loai.getTenloai()
            });
            // Thêm vào combobox cmbmaloai
            cmbmaloai.addItem(loai.getMaloai() + " - " + loai.getTenloai());
        }
        System.out.println("Số hàng trong bảng: " + dtmloai.getRowCount());
    }

    public void loadnxb() {
    System.out.println("Đã gọi loadNhaXuatBan");
    dtmnhaxuatban.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng
    cmbmanhaxuatban.removeAllItems(); // Xóa tất cả mục trong combobox

    try {
        ArrayList<NhaXuatBanDTO> listNhaXuatBan; // Lấy danh sách từ BUS
        listNhaXuatBan = NhaXuatBanBUS.getInstance().getAllNhaXuatBan();

        if (listNhaXuatBan == null || listNhaXuatBan.isEmpty()) {
            System.out.println("Không có dữ liệu nhà xuất bản!");
            JOptionPane.showMessageDialog(null, "Không có nhà xuất bản nào để hiển thị!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (NhaXuatBanDTO nxb : listNhaXuatBan) {
            dtmnhaxuatban.addRow(new Object[] {
                nxb.getManxb(),
                nxb.getTennxb(),
                nxb.getDiachi(),
                nxb.getSdt()
            });
            cmbmanhaxuatban.addItem(nxb.getManxb() + " - " + nxb.getTennxb());
        }
        System.out.println("Số hàng trong bảng: " + dtmnhaxuatban.getRowCount());
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu nhà xuất bản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    
    public static ArrayList<NhaCungCapDTO> ncclist = new ArrayList<NhaCungCapDTO>();

    public void loadnhacungcap() {
        System.out.println("Đã gọi loadnhacungcap");
        dtmncc.setRowCount(0); // Xóa tất cả hàng hiện tại
        ncclist = NhaCungCapBUS.gI().getAllNhaCungCap(); // Lấy danh sách nhà cung cấp

        for (NhaCungCapDTO ncc : ncclist) {
            dtmncc.addRow(new Object[] {
                    ncc.getMancc(),
                    ncc.getTenncc()
            });
        }
        System.out.println("Số hàng trong bảng: " + dtmncc.getRowCount());
    }

    public static ArrayList<KeSachDTO> kesach = new ArrayList<KeSachDTO>();

    public void loadkesach() {
        System.out.println("Đã gọi loadkesach");
        dtmke.setRowCount(0); // Xóa tất cả hàng hiện tại trong bảng
        cmbmakesach.removeAllItems(); // Xóa tất cả mục trong combobox
        kesach = KeSachBUS.gI().getAllKeSach(); // Lấy danh sách kệ sách

        for (KeSachDTO ke : kesach) {
            // Thêm vào bảng dtmke
            dtmke.addRow(new Object[] {
                    ke.getMakesach(),
                    ke.getVitri()
            });
            // Thêm vào combobox cmbmakesach
            cmbmakesach.addItem(ke.getMakesach() + " - " + ke.getVitri());
        }
        System.out.println("Số hàng trong bảng: " + dtmke.getRowCount());
    }

    public void loadnhanvien() {
    System.out.println("Đã gọi loadnhanvien");
    dtmnhanvien.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

    try {
        ArrayList<NhanVienDTO> listNhanVien = NhanVienBUS.getInstance().getAllNhanVien(); // Lấy danh sách nhân viên từ BUS

        if (listNhanVien == null || listNhanVien.isEmpty()) {
            System.out.println("Không có dữ liệu nhân viên!");
            JOptionPane.showMessageDialog(null, "Không có nhân viên nào để hiển thị!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (NhanVienDTO nhanVien : listNhanVien) {
            dtmnhanvien.addRow(new Object[] {
                    nhanVien.getMaNhanVien(),
                    nhanVien.getTenNhanVien(),
                    nhanVien.getNamSinh(),
                    nhanVien.getGioiTinh(),
                    nhanVien.getDiaChi(),
                    nhanVien.getSoDienThoai()
            });
        }
        System.out.println("Số hàng trong bảng: " + dtmnhanvien.getRowCount());
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    public void loadtacgia() {
        System.out.println("Đã gọi loadtacgia");
        dtmtacgia.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

        try {
            ArrayList<TacGiaDTO> listTacGia = TacGiaBUS.gI().getAllTacGia(); // Lấy danh sách tác giả từ BUS

            if (listTacGia == null || listTacGia.isEmpty()) {
                System.out.println("Không có dữ liệu tác giả!");
                JOptionPane.showMessageDialog(null, "Không có tác giả nào để hiển thị!", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (TacGiaDTO tacGia : listTacGia) {
                dtmtacgia.addRow(new Object[] {
                        tacGia.getMaTacGia(),
                        tacGia.getTenTacGia(),
                        tacGia.getNamSinh(),
                        tacGia.getQueQuan()
                });
            }
            System.out.println("Số hàng trong bảng: " + dtmtacgia.getRowCount());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu tác giả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loaddocgia() {
        System.out.println("Đã gọi loaddocgia");
        dtmdocgia.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

        try {
            // Lấy danh sách độc giả từ lớp BUS
            ArrayList<DocGiaDTO> listDocGia = DocGiaBUS.gI().getAllDocGia();

            if (listDocGia == null || listDocGia.isEmpty()) {
                System.out.println("Không có dữ liệu độc giả!");
                JOptionPane.showMessageDialog(null, "Không có độc giả nào để hiển thị!", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Duyệt qua danh sách độc giả và thêm vào bảng
            for (DocGiaDTO docGia : listDocGia) {
                dtmdocgia.addRow(new Object[] {
                        docGia.getMaDocGia(),
                        docGia.getTenDocGia(),
                        docGia.getGioiTinh(),
                        docGia.getDiaChi(),
                        docGia.getMaThe()
                });
            }
            System.out.println("Số hàng trong bảng: " + dtmdocgia.getRowCount());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu độc giả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadsach() {
        System.out.println("Đã gọi loadsach");
        dtmsach.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

        try {
            // Lấy danh sách sách từ lớp BUS
            ArrayList<SachDTO> listSach = SachBUS.gI().getAllSach();

            if (listSach == null || listSach.isEmpty()) {
                System.out.println("Không có dữ liệu sách!");
                JOptionPane.showMessageDialog(null, "Không có sách nào để hiển thị!", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Duyệt qua danh sách sách và thêm vào bảng
            for (SachDTO sach : listSach) {
                dtmsach.addRow(new Object[] {
                        sach.getMaSach(),
                        sach.getTenSach(),
                        sach.getMaLoai(),
                        sach.getMaNXB(),
                        sach.getNamXB(),
                        sach.getSoLuong(),
                        sach.getMaKeSach(),
                        sach.getHinhAnh()
                });
            }
            System.out.println("Số hàng trong bảng: " + dtmsach.getRowCount());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadphieumuon() {
    dtmmuon.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng
    try {
        ArrayList<PhieuMuonDTO> listPhieuMuon = PhieuMuonBUS.getInstance().getAllPhieuMuon(); // Lấy danh sách phiếu mượn từ BUS

        if (listPhieuMuon == null || listPhieuMuon.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không có phiếu mượn nào để hiển thị!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (PhieuMuonDTO pm : listPhieuMuon) {
            dtmmuon.addRow(new Object[] {
                pm.getMaPhieuMuon(),
                pm.getMaNV(),
                pm.getMaDocGia(),
                pm.getNgayMuon(),
                pm.getTinhTrang()
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu phiếu mượn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    public void loadctphieumuon() {
        dtmctpm.setRowCount(0);
    }

    public static ArrayList<PhieuNhapDTO> phieunhap = new ArrayList<PhieuNhapDTO>();

    public void loadphieunhap() {
        phieunhap = null;
        System.out.println("Đã gọi loadphieunhap");
        dtmphieunhap.setRowCount(0); // Xóa tất cả hàng hiện tại
        phieunhap = PhieuNhapBUS.gI().getAllPhieuNhap(); // Lấy danh sách phiếu nhập

        if (phieunhap == null || phieunhap.isEmpty()) {
            System.out.println("Không có dữ liệu phiếu nhập!");
            JOptionPane.showMessageDialog(null, "Không có phiếu nhập nào để hiển thị!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            // Reset các trường nhập liệu
            lblmaphieunhap.setText("Mã Phiếu Nhập");
            txtManhanvienphieunhap.setText("");
            txtManccPhieuNhap.setText("");
            NgayNhapPhieuNhap.setDate(null);
            dtmchitietphieunhap.setRowCount(0);
            return;
        }

        for (PhieuNhapDTO pn : phieunhap) {
            dtmphieunhap.addRow(new Object[] {
                    pn.getMaphieunhap(),
                    pn.getManv(),
                    pn.getMancc(),
                    pn.getNgaynhap(),
                    pn.getTongTien()
            });
        }
        System.out.println("Số hàng trong bảng: " + dtmphieunhap.getRowCount());
    }
    
    public static ArrayList<NhomQuyenDTO> dsNhomQuyen = new ArrayList<NhomQuyenDTO>();

    public void loadNhomQuyen() {
        dsNhomQuyen = null;
        System.out.println("Đã gọi loadNhomQuyen");
        dtmNhomQuyen.setRowCount(0); // Xoá tất cả dòng hiện tại trong bảng

        dsNhomQuyen = NhomQuyenBUS.gI().getAllNhomQuyen(); // Lấy danh sách nhóm quyền

        if (dsNhomQuyen == null || dsNhomQuyen.isEmpty()) {
            System.out.println("Không có dữ liệu nhóm quyền!");
            JOptionPane.showMessageDialog(null, "Không có nhóm quyền nào để hiển thị!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            // Reset các trường nhập liệu nếu cần
            txtTendocgia.setText("");
            txtMoTa.setText("");
            return;
        }

        for (NhomQuyenDTO nq : dsNhomQuyen) {
            dtmNhomQuyen.addRow(new Object[] {
                    nq.getIdnhomquyen(),
                    nq.getTennhomquyen(),
                    nq.getMota()
            });
        }
        System.out.println("Số hàng trong bảng nhóm quyền: " + dtmNhomQuyen.getRowCount());
    }
    public static ArrayList<ChiTietNhomQuyenDTO> dsChiTietNhomQuyen = new ArrayList<ChiTietNhomQuyenDTO>();
    public void loadChiTietNhomQuyen() {
        dsChiTietNhomQuyen = null;
        System.out.println("Đã gọi loadChiTietNhomQuyen");
        dtmChiTietNhomQuyen.setRowCount(0); // Xoá dữ liệu cũ trong bảng

        dsChiTietNhomQuyen = ChiTietNhomQuyenBUS.gI().getAll(); // Lấy danh sách từ BUS

        if (dsChiTietNhomQuyen == null || dsChiTietNhomQuyen.isEmpty()) {
            System.out.println("Không có dữ liệu chi tiết nhóm quyền!");
            JOptionPane.showMessageDialog(null, "Không có chi tiết nhóm quyền nào để hiển thị!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            // Reset giao diện nếu cần
            txtIdNhomQuyen.setText("");
            txtIdDanhMucChucNang.setText("");
            txtTenChucNang.setText("");
            return;
        }

        for (ChiTietNhomQuyenDTO ct : dsChiTietNhomQuyen) {
            dtmChiTietNhomQuyen.addRow(new Object[] {
                    ct.getIdnhomquyen(),
                    ct.getIddanhmucchucnang(),
                    ct.getHanhdong()
            });
        }

        System.out.println("Số hàng trong bảng chi tiết nhóm quyền: " + dtmChiTietNhomQuyen.getRowCount());
    }

    

    public static ArrayList<ThongKePhieuNhapDTO> tkpn = new ArrayList<ThongKePhieuNhapDTO>();

    public void loadthongkephieunhap() {
        tkpn = null;
        System.out.println("Đã gọi load chi tiết phiếu nhập");
        dtmthongkenhaphang.setRowCount(0);
        tkpn = ThongKePhieuNhapBUS.gI().getAllThongKe();
        int soluongsachdanhap = 0;
        int tongtien = 0;
        for (ThongKePhieuNhapDTO ct : tkpn) {
            dtmthongkenhaphang.addRow(new Object[] {
                    ct.getmaphieunhap(),
                    ct.getmasach(),
                    ct.getgianhap(),
                    ct.getsoluong(),
                    ct.getthanhtien(),
                    ct.getngaynhap(),
                    ct.gettensach()
            });
            soluongsachdanhap += ct.getsoluong();
            tongtien += ct.getthanhtien();
        }
        lblsosachdanhap.setText(soluongsachdanhap + "");
        lbltongtien.setText(tongtien + "");
    }

    public static ArrayList<ChiTietPhieuNhapDTO> ctpn = new ArrayList<ChiTietPhieuNhapDTO>();

    public void loadctphieunhap() {
        ctpn = null;
        dtmchitietphieunhap.setRowCount(0);
        ctpn = ChiTietPhieuNhapBUS.gI().getAllChiTietPhieuNhap();

        for (ChiTietPhieuNhapDTO ct : ctpn) {
            dtmchitietphieunhap.addRow(new Object[] {
                    ct.getMaphieunhap(),
                    ct.getMasach(),
                    ct.getSoluong(),
                    ct.getGia()
            });
        }
    }

    public String tinhtrangmuon() {
        if (rdmuon.isSelected()) {
            return "Đang Mượn";
        }
        return "Đã Trả";
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void xuLyChonAnh() {
        JFileChooser fileChooser = new JFileChooser("img/sach/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp hình ảnh", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String name = fileChooser.getSelectedFile().getName();
            hinhanh = name;
            lblhinhanhpre.setIcon(getAnhSP(name));
            System.out.println(name);
        }
    }

    File fileAnhSP;

    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        BufferedImage img = null;
        File fileImg = new File("img/sach/" + src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("img/sach/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File("img/sach/" + src);
        } catch (IOException e) {
            fileAnhSP = new File("img/sach/default.png");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }
        return null;
    }

    public static void thongbao(String s) {
        JOptionPane.showMessageDialog(null, s + " không được bỏ trống");
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
