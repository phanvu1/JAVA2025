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
(100414, 414414, 414, 'Thêm xóa sửa sản phẩm'),
(100515, 515515, 515, 'Thêm xóa sửa tài khoản');

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
(1012025, 425111, '2025-02-15', 'quá hạn'),
(1022025, 425112, '2025-02-15', 'quá hạn'),
(1032025, 430103, '2025-02-20', 'quá hạn'),
(1042025, 430106, '2025-02-21', 'quá hạn'),
(1052025, 425109, '2025-02-27', 'quá hạn'),
(1062025, 425111, '2025-02-22', 'quá hạn'),
(1072025, 425108, '2025-02-25', 'quá hạn'),
(1082025, 430104, '2025-02-26', 'quá hạn'),
(1092025, 430107, '2025-02-28', 'quá hạn'),
(1102025, 430105, '2025-04-05', 'sắp đến hạn'),
(1112025, 425108, '2025-04-06', 'sắp đến hạn'),
(1122025, 430106, '2025-04-10', 'sắp đến hạn'),
(1132025, 425110, '2025-04-12', 'sắp đến hạn'),
(1142025, 415101, '2025-05-15', 'sắp đến hạn');

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
(2025001, 415100, '200000.00', 10),
(2025002, 415101, '150000.00', 5),
(2025003, 420102, '200000.00', 20),
(2025004, 425108, '100000.00', 20),
(2025005, 425109, '150000.00', 5),
(2025006, 425110, '200000.00', 10),
(2025007, 425111, '250000.00', 5),
(2025008, 425112, '250000.00', 5),
(2025009, 430103, '200000.00', 10),
(2025010, 430104, '50000.00', 20),
(2025011, 430105, '50000.00', 20),
(2025012, 430106, '150000.00', 15),
(2025013, 430107, '200000.00', 10);

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
(414, 'Thêm xóa sửa sách', 1),
(515, 'Thêm xóa sửa tài khoản', 1);

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
(4001, 'Nguyễn Mạnh Hùng', 'Nam', 'Quận 3 TP HCM', 1001),
(4002, 'Bùi Xuân Huấn', 'Nam', 'Quận Gò Vấp TP HCM', 1002),
(4003, 'Ngô Bá Khá', 'Nam', 'Quận 5 TP HCM', 1003),
(4004, 'Trần Nguyễn Hồng Ngọc', 'Nữ', 'Quận 10 TP HCM', 1004),
(4005, 'Nguyễn Thị Thảo Vy', 'Nữ', 'Quận 1 TP HCM', 1005),
(4006, 'Đặng Tiến Hoàng', 'Nam', 'Quận 3 TP HCM', 1006),
(4007, 'Nguyễn Trà My', 'Nữ', 'Quận 4 TP HCM', 1007),
(4008, 'Nguyễn Hiếu', 'Nam', 'Quận 5 TP HCM', 1008),
(4009, 'Nguyễn Hạnh', 'Nữ', 'Quận 3 TP HCM', 1009),
(4010, 'Trần Hiếu Phong', 'Nam', 'Quận 1 TP HCM', 1010);

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
(101, 'tầng 1'),
(102, 'tầng 1'),
(103, 'tầng 1'),
(201, 'tầng 2'),
(202, 'tầng 2'),
(203, 'tầng 2');

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
(11, 'Văn học'),
(12, 'Lịch sử'),
(13, 'Triết Học'),
(14, 'Thiếu nhi');

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
(301, 'Nhà sách Horizon'),
(302, 'Tiki'),
(303, 'Fahasa'),
(304, 'Shopee');

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
(510101, 'Nguyễn Phúc Sơn', 1999, 'Nam', '348374724', '2025-01-01', '4000000.00', 'Quận 2 TP HCM', 410101),
(510102, 'Nguyễn Tài Hà', 2000, 'Nam', '343824645', '2025-02-01', '3500000.00', 'Quận 10 TP HCM', 410102),
(510103, 'Nguyễn Thúy Vi', 1999, 'Nữ', '348374724', '2024-10-01', '5000000.00', 'Quận 5 TP HCM', 410103);

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
(415, 'NXB Dân Trí', 'TP HCM', '347364372'),
(420, 'NXB Tri Thức', 'Hà Nội', '347343493'),
(425, 'NXB Văn Học', 'Hà Nội', '327847343'),
(430, 'NXB Trẻ', 'TP HCM', '384343455');

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
(414414, 'nhanVien', 'thêm xóa sửa sản phẩm'),
(515515, 'admin', 'thêm xóa sửa tài khoản');

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
(1012025, 510103, 4001, '2025-01-02', 'đã trả'),
(1022025, 510102, 4001, '2025-01-02', 'đã trả '),
(1032025, 510101, 4002, '2025-01-03', 'đã trả'),
(1042025, 510103, 4005, '2025-01-10', 'đã trả '),
(1052025, 510103, 4005, '2025-01-10', 'đã trả'),
(1062025, 510103, 4005, '2025-01-11', 'đã trả '),
(1072025, 510101, 4008, '2025-02-02', 'đã trả'),
(1082025, 510103, 4008, '2025-02-04', 'đã trả'),
(1092025, 510101, 4010, '2025-02-15', 'đã trả'),
(1102025, 510103, 4003, '2025-03-05', 'chưa trả '),
(1112025, 510101, 4004, '2025-03-06', 'chưa trả'),
(1122025, 510102, 4006, '2025-03-10', 'chưa trả'),
(1132025, 510102, 4007, '2025-03-12', 'chưa trả'),
(1142025, 510102, 4009, '2025-03-15', 'chưa trả');

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
(2025001, 301, 510103, '2024-11-10'),
(2025002, 303, 510101, '2025-12-25'),
(2025003, 304, 510102, '2025-01-15'),
(2025004, 302, 510103, '2025-02-25'),
(2025005, 304, 510103, '2025-03-01'),
(2025006, 301, 510101, '2025-03-03'),
(2025007, 303, 510102, '2025-03-05'),
(2025008, 302, 510102, '2025-03-10'),
(2025009, 304, 510101, '2025-03-15'),
(2025010, 302, 510103, '2025-03-15'),
(2025011, 304, 510103, '2025-03-16'),
(2025012, 301, 510101, '2025-03-18'),
(2025013, 303, 510101, '2025-03-20');

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
(415100, 'Zarathustra dã nói như thế', 13, 415, 3123, 1883, 10, 201, 'https://imgur.com/IEKaj1y'),
(415101, 'Buổi hoàng hôn của những thần tượng', 13, 415, 3123, 1988, 5, 201, 'https://imgur.com/eL7cJhr'),
(420102, 'Bên kia thiện ác', 13, 420, 3123, 1886, 20, 202, 'https://imgur.com/dcM5fhp'),
(425108, 'Bỉ Vỏ', 11, 425, 3121, 2021, 20, 202, 'https://imgur.com/dnIg4ts'),
(425109, 'Những ngày thơ ấu', 11, 425, 3121, 2008, 5, 203, 'https://imgur.com/oUpi5eR'),
(425110, 'Đôi lứa xứng đôi nửa đêm cười', 11, 425, 3120, 2021, 10, 201, 'https://imgur.com/ecS03aw'),
(425111, 'Chí Phèo', 11, 425, 3120, 2000, 5, 202, 'https://imgur.com/2sUMDEr'),
(425112, 'Việt Nam sử lược', 12, 425, 3124, 2020, 5, 101, 'https://imgur.com/ImMPzHv'),
(430103, 'Cho tôi xin một vé đi tuổi thơ', 14, 430, 3122, 2008, 10, 101, 'https://imgur.com/6SDfsAH'),
(430104, 'Có hai con mèo ngồi bên cửa sổ', 14, 430, 3122, 2012, 20, 102, 'https://imgur.com/ZC8GXcY'),
(430105, 'Làm bạn với bầu trời', 14, 430, 3122, 2019, 20, 103, 'https://imgur.com/r4HfZwf'),
(430106, 'Mùa hè không tên', 14, 430, 3122, 2023, 15, 101, 'https://imgur.com/0YeD7up'),
(430107, 'Tôi là Bê Tô', 14, 430, 3122, 2007, 10, 102, 'https://imgur.com/CP9gj3A');

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
(3120, 'Nam Cao', 1917, 'Hà Nam'),
(3121, 'Nguyên Hồng', 1918, 'Nam Định'),
(3122, 'Nguyễn Nhật Ánh', 1955, 'Quảng Nam'),
(3123, 'Nietzsche', 1844, 'Đức'),
(3124, 'Trần Trọng Kim', 1883, 'Hà Tĩnh');

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
(410101, 'nhanvien1', 'nhanvien1', 414414),
(410102, 'nhanvien2', 'nhanvien2', 414414),
(410103, 'nhanvien3', 'nhanvien3', 414414),
(450250, 'admin', 'admin', 515515);

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
(1001, '2024-11-11', '2025-11-11', 'Mượn quá hạn 2 lần'),
(1002, '2024-12-15', '2025-12-15', 'Mượn quá hạn 1 lần'),
(1003, '2024-12-01', '2025-12-01', 'Mượn quá hạn 0 lần'),
(1004, '2024-10-30', '2025-10-30', 'Mượn quá hạn 0 lần'),
(1005, '2024-06-30', '2025-06-30', 'Mượn quá hạn 3 lần'),
(1006, '2024-10-30', '2025-11-30', 'Mượn quá hạn 0 lần'),
(1007, '2024-04-28', '2025-04-28', 'Mượn quá hạn 0 lần'),
(1008, '2024-07-12', '2025-07-12', 'Mượn quá hạn 2 lần'),
(1009, '2024-05-20', '2025-05-20', 'Mượn quá hạn 0 lần'),
(1010, '2024-09-22', '2025-09-22', 'Mượn quá hạn 1 lần');

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
