-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 31, 2025 lúc 03:08 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietnhomquyen`
--

CREATE TABLE `chitietnhomquyen` (
  `idchitietnhomquyen` int(11) NOT NULL,
  `idquyen` int(11) NOT NULL,
  `idchucnang` int(11) NOT NULL,
  `hanhdong` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietnhomquyen`
--

INSERT INTO `chitietnhomquyen` (`idchitietnhomquyen`, `idquyen`, `idchucnang`, `hanhdong`) VALUES
(1, 1, 1, 'Thêm sản phẩm'),
(2, 1, 1, 'Xoá sản phẩm'),
(3, 1, 1, 'Sửa sản phẩm'),
(4, 1, 1, 'Xem sản phẩm'),
(5, 2, 1, 'Thêm sản phẩm'),
(6, 2, 1, 'Sửa sản phẩm'),
(7, 2, 1, 'Xóa sản phẩm'),
(8, 2, 1, 'Xem sản phẩm'),
(9, 3, 1, 'Xem sản phẩm'),
(10, 1, 2, 'Thêm tài khoản'),
(11, 1, 2, 'Xóa tài khoản'),
(12, 1, 3, 'Xem phiếu nhập'),
(13, 1, 3, 'Xem phiếu mượn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `maphieumuon` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `ngaytra` date DEFAULT NULL,
  `ghichu` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`maphieumuon`, `masach`, `ngaytra`, `ghichu`) VALUES
(1, 12, '2025-02-15', 'quá hạn'),
(2, 19, '2025-02-15', 'quá hạn'),
(3, 14, '2025-02-20', 'quá hạn'),
(4, 11, '2025-02-21', 'quá hạn'),
(5, 7, '2025-02-27', 'quá hạn'),
(6, 22, '2025-02-22', 'quá hạn'),
(7, 30, '2025-02-25', 'quá hạn'),
(8, 28, '2025-02-26', 'quá hạn'),
(9, 1, '2025-02-28', 'quá hạn'),
(10, 24, '2025-04-05', 'sắp đến hạn'),
(11, 17, '2025-04-06', 'sắp đến hạn'),
(12, 18, '2025-04-10', 'sắp đến hạn'),
(13, 22, '2025-04-12', 'sắp đến hạn'),
(14, 20, '2025-04-13', 'sắp đến hạn'),
(15, 13, '2025-04-14', 'sắp đến hạn'),
(16, 27, '2025-05-15', 'sắp đến hạn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `gia` decimal(12,2) NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maphieunhap`, `masach`, `gia`, `soluong`) VALUES
(1, 1, '200000.00', 10),
(2, 2, '200000.00', 10),
(3, 3, '150000.00', 20),
(4, 4, '300000.00', 20),
(5, 5, '200000.00', 10),
(6, 6, '200000.00', 10),
(7, 9, '150000.00', 10),
(8, 23, '200000.00', 10),
(9, 25, '100000.00', 10),
(10, 11, '150000.00', 20),
(11, 12, '200000.00', 10),
(12, 7, '250000.00', 10),
(13, 18, '250000.00', 10),
(14, 22, '300000.00', 10),
(15, 30, '500000.00', 10),
(16, 22, '500000.00', 10),
(17, 27, '400000.00', 10),
(18, 17, '200000.00', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucchucnang`
--

CREATE TABLE `danhmucchucnang` (
  `iddanhmucchucnang` int(11) NOT NULL,
  `tenchucnang` varchar(100) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `danhmucchucnang`
--

INSERT INTO `danhmucchucnang` (`iddanhmucchucnang`, `tenchucnang`, `trangthai`) VALUES
(1, 'Quản lý sản phẩm', 1),
(2, 'Quản lý tài khoản', 1),
(3, 'Quản lý phiếu', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `madocgia` int(11) NOT NULL,
  `tendg` varchar(100) NOT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `mathe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`madocgia`, `tendg`, `gioitinh`, `diachi`, `mathe`) VALUES
(1, 'Nguyễn Mạnh Hùng', 'Nam', 'Quận 3 TP HCM', 1),
(2, 'Bùi Xuân Huấn', 'Nam', 'Quận Gò Vấp TP HCM', 2),
(3, 'Ngô Bá Khá', 'Nam', 'Quận 5 TP HCM', 3),
(4, 'Trần Nguyễn Hồng Ngọc', 'Nữ', 'Quận 10 TP HCM', 4),
(5, 'Nguyễn Thị Thảo Vy', 'Nữ', 'Quận 1 TP HCM', 5),
(6, 'Đặng Tiến Hoàng', 'Nam', 'Quận 3 TP HCM', 6),
(7, 'Nguyễn Trà My', 'Nữ', 'Quận 4 TP HCM', 7),
(8, 'Nguyễn Hiếu', 'Nam', 'Quận 5 TP HCM', 8),
(9, 'Nguyễn Hạnh', 'Nữ', 'Quận 3 TP HCM', 9),
(10, 'Trần Hiếu Phong', 'Nam', 'Quận 1 TP HCM', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kesach`
--

CREATE TABLE `kesach` (
  `makesach` int(11) NOT NULL,
  `vitri` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `kesach`
--

INSERT INTO `kesach` (`makesach`, `vitri`) VALUES
(1, 'tầng 1'),
(2, 'tầng 1'),
(3, 'tầng 1'),
(4, 'tầng 2'),
(5, 'tầng 2'),
(6, 'tầng 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `maloai` int(11) NOT NULL,
  `tenloai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`maloai`, `tenloai`) VALUES
(1, 'Văn học'),
(2, 'Lịch sử'),
(3, 'Triết Học'),
(4, 'Thiếu nhi'),
(5, 'Ngoại văn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`) VALUES
(1, 'Nhà sách Horizon'),
(2, 'Tiki'),
(3, 'Fahasa'),
(4, 'Shopee');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `tennv` varchar(100) NOT NULL,
  `namsinh` int(11) DEFAULT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `ngaybatdau` date DEFAULT NULL,
  `luong` decimal(12,2) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `mataikhoan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `tennv`, `namsinh`, `gioitinh`, `sdt`, `ngaybatdau`, `luong`, `diachi`, `mataikhoan`) VALUES
(1, 'Nguyễn Phúc Sơn', 1999, 'Nam', '348374724', '2024-10-01', '6000000.00', 'Quận 2 TP HCM', 1),
(2, 'Nguyễn Tài Hà', 2000, 'Nam', '343824645', '2025-10-15', '550000.00', 'Quận 3 TP HCM', 2),
(3, 'Nguyễn Thúy Vi', 1999, 'Nữ', '348374724', '2024-11-20', '5000000.00', 'Quận 4 TP HCM', 3),
(4, 'Nguyễn Tuấn Anh', 2001, 'Nam', '348374724', '2024-12-01', '4500000.00', 'Quận 10 TP HCM', 4),
(5, 'Nguyễn Minh Hiếu', 2002, 'Nam', '348374724', '2025-01-01', '4000000.00', 'Quận 1 TP HCM', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `manxb` int(11) NOT NULL,
  `tennxb` varchar(100) NOT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`manxb`, `tennxb`, `diachi`, `sdt`) VALUES
(1, 'NXB Dân Trí', 'TP HCM', '84347364372'),
(2, 'NXB Tri Thức', 'Hà Nội', '84347343493'),
(3, 'NXB Văn Học', 'Hà Nội', '84327847343'),
(4, 'NXB Trẻ', 'TP HCM', '84384343455'),
(5, 'NXB Everyman Library', 'Anh', '440478346234');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `idnhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(100) NOT NULL,
  `mota` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhomquyen`
--

INSERT INTO `nhomquyen` (`idnhomquyen`, `tennhomquyen`, `mota`) VALUES
(1, 'quản trị viên', 'Quản lý đơn hàng-tài khoản-phiếu'),
(2, 'quản lý', 'Quản lý sản phẩm'),
(3, 'nhân viên', 'Quản lý sản phẩm-xem');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `maphieumuon` int(11) NOT NULL,
  `manv` int(11) DEFAULT NULL,
  `madocgia` int(11) DEFAULT NULL,
  `ngaymuon` date NOT NULL,
  `tinhtrang` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieumuon`
--

INSERT INTO `phieumuon` (`maphieumuon`, `manv`, `madocgia`, `ngaymuon`, `tinhtrang`) VALUES
(1, 1, 1, '2025-01-02', 'đã trả'),
(2, 1, 1, '2025-01-02', 'đã trả '),
(3, 1, 2, '2025-01-03', 'đã trả'),
(4, 3, 5, '2025-01-10', 'đã trả '),
(5, 2, 5, '2025-01-10', 'đã trả'),
(6, 4, 5, '2025-01-11', 'đã trả '),
(7, 3, 8, '2025-02-02', 'đã trả'),
(8, 5, 8, '2025-02-04', 'đã trả'),
(9, 5, 10, '2025-02-15', 'đã trả'),
(10, 1, 3, '2025-03-05', 'chưa trả '),
(11, 2, 4, '2025-03-06', 'chưa trả'),
(12, 3, 6, '2025-03-10', 'chưa trả'),
(13, 2, 7, '2025-03-12', 'chưa trả'),
(14, 5, 7, '2025-03-12', 'chưa trả'),
(15, 4, 7, '2025-03-12', 'chưa trả'),
(16, 3, 9, '2025-03-15', 'chưa trả');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `mancc` int(11) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `ngaynhap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maphieunhap`, `mancc`, `manv`, `ngaynhap`) VALUES
(1, 1, 1, '2024-11-10'),
(2, 1, 1, '2025-12-25'),
(3, 2, 1, '2025-01-15'),
(4, 3, 2, '2025-02-25'),
(5, 4, 2, '2025-03-01'),
(6, 3, 3, '2025-03-03'),
(7, 3, 1, '2025-03-05'),
(8, 2, 2, '2025-03-10'),
(9, 4, 3, '2025-03-15'),
(10, 2, 4, '2025-03-15'),
(11, 4, 4, '2025-03-16'),
(12, 1, 5, '2025-03-18'),
(13, 4, 5, '2025-03-18'),
(14, 4, 3, '2025-03-18'),
(15, 4, 2, '2025-03-18'),
(16, 3, 2, '2025-03-18'),
(17, 3, 4, '2025-03-18'),
(18, 2, 4, '2025-03-20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(11) NOT NULL,
  `tensach` varchar(200) NOT NULL,
  `maloai` int(11) DEFAULT NULL,
  `manxb` int(11) DEFAULT NULL,
  `matacgia` int(11) DEFAULT NULL,
  `namxb` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT 0,
  `makesach` int(11) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `maloai`, `manxb`, `matacgia`, `namxb`, `soluong`, `makesach`, `hinhanh`) VALUES
(1, 'Zarathustra dã nói như thế', 3, 1, 4, 1883, 10, 1, 'image\\1_zarathustra-da-noi-nhu-the.jpg'),
(2, 'Buổi hoàng hôn của những thần tượng', 3, 1, 4, 1988, 10, 1, 'image\\2_buoihoanghoncuanhungthantuong.jpg'),
(3, 'Bên kia thiện ác', 3, 2, 4, 1886, 20, 5, 'image\\3_benkiathienac.png'),
(4, 'Bỉ Vỏ', 1, 3, 2, 2021, 20, 5, 'image\\4_biVo.jpg'),
(5, 'Những ngày thơ ấu', 1, 3, 2, 2008, 10, 5, 'image\\5_nhungNgayThoAu.jpg'),
(6, 'Đôi lứa xứng đôi nửa đêm cười', 1, 3, 1, 2021, 10, 4, 'image\\6_doiLuaXungDoi.png'),
(7, 'Chí Phèo', 1, 3, 1, 2000, 10, 2, 'image\\7_chipheo.png'),
(8, 'Việt Nam sử lược', 2, 3, 5, 2020, 10, 3, 'image\\8_vnsuluoc.jpg'),
(9, 'Cho tôi xin một vé đi tuổi thơ', 4, 4, 3, 2008, 10, 4, 'image\\9_xin1veDiTuoiTho.jpg'),
(10, 'Có hai con mèo ngồi bên cửa sổ', 4, 4, 3, 2012, 20, 5, 'image\\10_co2ConMeoBenCS.jpg'),
(11, 'Làm bạn với bầu trời', 4, 4, 3, 2019, 20, 6, 'image\\11_lamBanVoiBauTroi.jpg'),
(12, 'Mùa hè không tên', 4, 4, 3, 2023, 10, 1, 'image\\12_muaHeKhongTen.jpg'),
(13, 'The Stranger', 5, 4, 6, 2007, 10, 2, 'image\\13_theStranger.jpg'),
(14, 'Demons', 5, 5, 10, 1995, 10, 2, 'image\\14_Demons.jpg'),
(15, 'The brother Karamazov', 5, 5, 10, 1992, 10, 3, 'image\\15_brotherKaramazov.jpg'),
(16, 'The Idiot', 5, 5, 10, 1993, 10, 3, 'image\\16_theIdiot.jpg'),
(17, 'Kẻ ngoại cuộc', 1, 1, 6, 2007, 10, 2, 'image\\17_keNgoaiCuoc.jpg'),
(18, 'Cô gái đến từ hôm qua', 1, 4, 3, 2018, 10, 4, 'image\\18_coGaiDenTuHomQua.jpg'),
(19, 'Tôi là Bê Tô', 4, 4, 3, 2015, 20, 4, 'image\\19_ToiLaBeto.jpg'),
(20, 'Tội ác và hình phạt', 1, 3, 10, 2019, 10, 4, 'image\\20_toiAcVaHinhPhat.jpg'),
(21, 'Chàng ngốc', 1, 3, 10, 2019, 20, 4, 'image\\21_changNgoc.jpg'),
(22, 'Anh em nhà Karamazov', 1, 3, 10, 2015, 10, 5, 'image\\22_anhEmNhaKaramazov.jpg'),
(23, 'The Adolescent', 5, 5, 10, 1991, 10, 5, 'image\\23_theAdolescent.jpg'),
(24, 'Crime and punishment', 5, 5, 10, 1990, 10, 6, 'image\\24_crimeAndPunishment.jpg'),
(25, 'Animal Farm', 1, 5, 9, 1991, 10, 6, 'image\\25_animalFarm.jpg'),
(26, '1984', 1, 5, 9, 1992, 10, 2, 'image\\26_1984.jpg'),
(27, 'Great expectations', 1, 5, 8, 1999, 10, 1, 'image\\27_greatExpectations.jpg'),
(28, 'David Copperfield', 5, 5, 8, 1997, 10, 3, 'image\\28_davidCopperfield.jpg'),
(29, 'Dracula', 5, 5, 7, 1998, 10, 3, 'image\\29_dracula.jpg'),
(30, 'Oliver Twist', 5, 5, 8, 1995, 10, 3, 'image\\30_oliverTwist.jpg');



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `matacgia` int(11) NOT NULL,
  `tentacgia` varchar(100) NOT NULL,
  `namsinh` int(11) DEFAULT NULL,
  `quequan` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`matacgia`, `tentacgia`, `namsinh`, `quequan`) VALUES
(1, 'Nam Cao', 1917, 'Hà Nam'),
(2, 'Nguyên Hồng', 1918, 'Nam Định'),
(3, 'Nguyễn Nhật Ánh', 1955, 'Quảng Nam'),
(4, 'Nietzsche', 1844, 'Đức'),
(5, 'Trần Trọng Kim', 1883, 'Hà Tĩnh'),
(6, 'Albert Camus', 1913, 'Anh'),
(7, 'Bram Stoker', 1847, 'Anh'),
(8, 'Charles Dickens', 1812, 'Anh'),
(9, 'George Orwell', 1903, 'Anh'),
(10, 'Fyodor Dostoyevsky', 1821, 'Nga');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `mataikhoan` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `idnhomquyen` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`mataikhoan`, `username`, `password`, `idnhomquyen`) VALUES
(1, 'admin', 'admin', 1),
(2, 'quanly', 'quanly', 2),
(3, 'nhanvien3', 'nhanvien3', 3),
(4, 'nhanvien4', 'nhanvien4', 3),
(5, 'nhanvien5', 'nhanvien5', 3);


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thethuvien`
--

CREATE TABLE `thethuvien` (
  `mathetv` int(11) NOT NULL,
  `ngaybd` date NOT NULL,
  `ngayhh` date NOT NULL,
  `ghichu` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thethuvien`
--

INSERT INTO `thethuvien` (`mathetv`, `ngaybd`, `ngayhh`, `ghichu`) VALUES
(1, '2024-11-11', '2025-11-11', 'Mượn quá hạn 2 lần'),
(2, '2024-12-15', '2025-12-15', 'Mượn quá hạn 1 lần'),
(3, '2024-12-01', '2025-12-01', 'Mượn quá hạn 0 lần'),
(4, '2024-10-30', '2025-10-30', 'Mượn quá hạn 0 lần'),
(5, '2024-06-30', '2025-06-30', 'Mượn quá hạn 3 lần'),
(6, '2024-10-30', '2025-11-30', 'Mượn quá hạn 0 lần'),
(7, '2024-04-28', '2025-04-28', 'Mượn quá hạn 0 lần'),
(8, '2024-07-12', '2025-07-12', 'Mượn quá hạn 2 lần'),
(9, '2024-05-20', '2025-05-20', 'Mượn quá hạn 0 lần'),
(10, '2024-05-21', '2025-05-21', 'Mượn quá hạn 0 lần'),
(11, '2024-05-22', '2025-05-22', 'Mượn quá hạn 0 lần'),
(12, '2024-09-25', '2025-09-25', 'Mượn quá hạn 1 lần');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietnhomquyen`
--
ALTER TABLE `chitietnhomquyen`
  ADD PRIMARY KEY (`idchitietnhomquyen`),
  ADD UNIQUE KEY `idquyen` (`idquyen`,`idchucnang`,`hanhdong`),
  ADD KEY `idchucnang` (`idchucnang`);

--
-- Chỉ mục cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD PRIMARY KEY (`maphieumuon`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maphieunhap`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  ADD PRIMARY KEY (`iddanhmucchucnang`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`madocgia`),
  ADD KEY `mathe` (`mathe`),
  ADD KEY `idx_docgia_tendg` (`tendg`);

--
-- Chỉ mục cho bảng `kesach`
--
ALTER TABLE `kesach`
  ADD PRIMARY KEY (`makesach`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`maloai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `mataikhoan` (`mataikhoan`);

--
-- Chỉ mục cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`manxb`);

--
-- Chỉ mục cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`idnhomquyen`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`maphieumuon`),
  ADD KEY `manv` (`manv`),
  ADD KEY `idx_phieumuon_madocgia` (`madocgia`),
  ADD KEY `idx_phieumuon_ngaymuon` (`ngaymuon`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `mancc` (`mancc`),
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`),
  ADD KEY `maloai` (`maloai`),
  ADD KEY `makesach` (`makesach`),
  ADD KEY `idx_sach_tensach` (`tensach`),
  ADD KEY `idx_sach_matacgia` (`matacgia`),
  ADD KEY `idx_sach_manxb` (`manxb`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`matacgia`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`mataikhoan`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `idnhomquyen` (`idnhomquyen`);

--
-- Chỉ mục cho bảng `thethuvien`
--
ALTER TABLE `thethuvien`
  ADD PRIMARY KEY (`mathetv`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietnhomquyen`
--
ALTER TABLE `chitietnhomquyen`
  MODIFY `idchitietnhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100516;

--
-- AUTO_INCREMENT cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  MODIFY `iddanhmucchucnang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=920;

--
-- AUTO_INCREMENT cho bảng `docgia`
--
ALTER TABLE `docgia`
  MODIFY `madocgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4011;

--
-- AUTO_INCREMENT cho bảng `kesach`
--
ALTER TABLE `kesach`
  MODIFY `makesach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `maloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=305;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=510104;

--
-- AUTO_INCREMENT cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  MODIFY `manxb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=436;

--
-- AUTO_INCREMENT cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `idnhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=717920;

--
-- AUTO_INCREMENT cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  MODIFY `maphieumuon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1172026;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2025014;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=430108;

--
-- AUTO_INCREMENT cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `matacgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3126;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `mataikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=450251;

--
-- AUTO_INCREMENT cho bảng `thethuvien`
--
ALTER TABLE `thethuvien`
  MODIFY `mathetv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1011;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietnhomquyen`
--
ALTER TABLE `chitietnhomquyen`
  ADD CONSTRAINT `chitietnhomquyen_ibfk_1` FOREIGN KEY (`idquyen`) REFERENCES `nhomquyen` (`idnhomquyen`),
  ADD CONSTRAINT `chitietnhomquyen_ibfk_2` FOREIGN KEY (`idchucnang`) REFERENCES `danhmucchucnang` (`iddanhmucchucnang`);

--
-- Các ràng buộc cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`maphieumuon`) REFERENCES `phieumuon` (`maphieumuon`),
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD CONSTRAINT `docgia_ibfk_1` FOREIGN KEY (`mathe`) REFERENCES `thethuvien` (`mathetv`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`mataikhoan`) REFERENCES `taikhoan` (`mataikhoan`);

--
-- Các ràng buộc cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`madocgia`) REFERENCES `docgia` (`madocgia`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`maloai`) REFERENCES `loai` (`maloai`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`manxb`) REFERENCES `nhaxuatban` (`manxb`),
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`matacgia`) REFERENCES `tacgia` (`matacgia`),
  ADD CONSTRAINT `sach_ibfk_4` FOREIGN KEY (`makesach`) REFERENCES `kesach` (`makesach`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`idnhomquyen`) REFERENCES `nhomquyen` (`idnhomquyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
