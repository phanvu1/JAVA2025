-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 24, 2025 lúc 06:33 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `javabanbinhnuoc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binh_nhua`
--

CREATE TABLE `binh_nhua` (
  `mabinh` int(11) NOT NULL,
  `loainhua` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binh_nuoc`
--

CREATE TABLE `binh_nuoc` (
  `mabinh` int(11) NOT NULL,
  `tenbinh` varchar(100) DEFAULT NULL,
  `dungtich` varchar(50) DEFAULT NULL,
  `mota` text DEFAULT NULL,
  `dongiaban` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `manhasx` int(11) DEFAULT NULL,
  `maloaihang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binh_thuy_tinh`
--

CREATE TABLE `binh_thuy_tinh` (
  `mabinh` int(11) NOT NULL,
  `loaithuytinh` varchar(100) DEFAULT NULL,
  `mucchiunhiet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietquyen`
--

CREATE TABLE `chitietquyen` (
  `idchitietquyen` int(11) NOT NULL,
  `idquyen` int(11) NOT NULL,
  `idchucnang` int(11) NOT NULL,
  `hanhdong` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `id` int(11) NOT NULL,
  `mahoadon` int(11) NOT NULL,
  `mabinhnuoc` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` decimal(12,2) NOT NULL,
  `thanhtien` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_phieu_nhap`
--

CREATE TABLE `chi_tiet_phieu_nhap` (
  `id` int(11) NOT NULL,
  `maphieunhap` int(11) NOT NULL,
  `mabinhnuoc` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` decimal(12,2) NOT NULL,
  `thanhtien` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucchucnang`
--

CREATE TABLE `danhmucchucnang` (
  `idchucnang` int(11) NOT NULL,
  `tenchucnang` varchar(255) NOT NULL,
  `trangthai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `mahoadon` int(11) NOT NULL,
  `ngay` date DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `makhachhang` int(11) DEFAULT NULL,
  `tongtien` decimal(12,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `makhachhang` int(11) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `diachi` text DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_hang`
--

CREATE TABLE `loai_hang` (
  `maloaihang` int(11) NOT NULL,
  `capdo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `manv` int(11) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `stk` varchar(20) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `manhacungcap` int(11) NOT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `diachi` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_san_xuat`
--

CREATE TABLE `nha_san_xuat` (
  `manhasx` int(11) NOT NULL,
  `tennhasx` varchar(100) NOT NULL,
  `quocgia` varchar(50) DEFAULT NULL,
  `mienweb` varchar(100) DEFAULT NULL,
  `diachi` text DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `idquyen` int(11) NOT NULL,
  `tenquyen` varchar(255) NOT NULL,
  `trangthai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_nhap_hang`
--

CREATE TABLE `phieu_nhap_hang` (
  `maphieunhap` int(11) NOT NULL,
  `ngay` date DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `manhacungcap` int(11) DEFAULT NULL,
  `tongtien` decimal(12,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `idtaikhoan` int(11) NOT NULL,
  `idnhanvien` int(11) DEFAULT NULL,
  `idkhachhang` int(11) DEFAULT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `idquyen` int(11) NOT NULL,
  `trangthai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Bẫy `taikhoan`
--
DELIMITER $$
CREATE TRIGGER `check_taikhoan_owner` BEFORE INSERT ON `taikhoan` FOR EACH ROW BEGIN
    IF (NEW.idnhanvien IS NOT NULL AND NEW.idkhachhang IS NOT NULL) OR 
       (NEW.idnhanvien IS NULL AND NEW.idkhachhang IS NULL) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Mỗi tài khoản chỉ thuộc nhân viên HOẶC khách hàng';
    END IF;
END
$$
DELIMITER ;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `binh_nhua`
--
ALTER TABLE `binh_nhua`
  ADD PRIMARY KEY (`mabinh`);

--
-- Chỉ mục cho bảng `binh_nuoc`
--
ALTER TABLE `binh_nuoc`
  ADD PRIMARY KEY (`mabinh`),
  ADD KEY `fk_binhnuoc_nhasanxuat` (`manhasx`),
  ADD KEY `fk_binhnuoc_loaihang` (`maloaihang`);

--
-- Chỉ mục cho bảng `binh_thuy_tinh`
--
ALTER TABLE `binh_thuy_tinh`
  ADD PRIMARY KEY (`mabinh`);

--
-- Chỉ mục cho bảng `chitietquyen`
--
ALTER TABLE `chitietquyen`
  ADD PRIMARY KEY (`idchitietquyen`),
  ADD UNIQUE KEY `idquyen` (`idquyen`,`idchucnang`,`hanhdong`),
  ADD KEY `idchucnang` (`idchucnang`);

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mahoadon` (`mahoadon`,`mabinhnuoc`),
  ADD KEY `mabinhnuoc` (`mabinhnuoc`);

--
-- Chỉ mục cho bảng `chi_tiet_phieu_nhap`
--
ALTER TABLE `chi_tiet_phieu_nhap`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `maphieunhap` (`maphieunhap`,`mabinhnuoc`),
  ADD KEY `mabinhnuoc` (`mabinhnuoc`);

--
-- Chỉ mục cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  ADD PRIMARY KEY (`idchucnang`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`mahoadon`),
  ADD KEY `manv` (`manv`),
  ADD KEY `makhachhang` (`makhachhang`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`makhachhang`);

--
-- Chỉ mục cho bảng `loai_hang`
--
ALTER TABLE `loai_hang`
  ADD PRIMARY KEY (`maloaihang`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`manv`);

--
-- Chỉ mục cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`manhacungcap`);

--
-- Chỉ mục cho bảng `nha_san_xuat`
--
ALTER TABLE `nha_san_xuat`
  ADD PRIMARY KEY (`manhasx`);

--
-- Chỉ mục cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`idquyen`);

--
-- Chỉ mục cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `manv` (`manv`),
  ADD KEY `manhacungcap` (`manhacungcap`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`idtaikhoan`),
  ADD UNIQUE KEY `tendangnhap` (`tendangnhap`),
  ADD KEY `idquyen` (`idquyen`),
  ADD KEY `idnhanvien` (`idnhanvien`),
  ADD KEY `idkhachhang` (`idkhachhang`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `binh_nuoc`
--
ALTER TABLE `binh_nuoc`
  MODIFY `mabinh` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitietquyen`
--
ALTER TABLE `chitietquyen`
  MODIFY `idchitietquyen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_phieu_nhap`
--
ALTER TABLE `chi_tiet_phieu_nhap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  MODIFY `idchucnang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `mahoadon` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `makhachhang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loai_hang`
--
ALTER TABLE `loai_hang`
  MODIFY `maloaihang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  MODIFY `manhacungcap` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nha_san_xuat`
--
ALTER TABLE `nha_san_xuat`
  MODIFY `manhasx` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `idquyen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `idtaikhoan` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `binh_nhua`
--
ALTER TABLE `binh_nhua`
  ADD CONSTRAINT `binh_nhua_ibfk_1` FOREIGN KEY (`mabinh`) REFERENCES `binh_nuoc` (`mabinh`);

--
-- Các ràng buộc cho bảng `binh_nuoc`
--
ALTER TABLE `binh_nuoc`
  ADD CONSTRAINT `fk_binhnuoc_loaihang` FOREIGN KEY (`maloaihang`) REFERENCES `loai_hang` (`maloaihang`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_binhnuoc_nhasanxuat` FOREIGN KEY (`manhasx`) REFERENCES `nha_san_xuat` (`manhasx`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `binh_thuy_tinh`
--
ALTER TABLE `binh_thuy_tinh`
  ADD CONSTRAINT `binh_thuy_tinh_ibfk_1` FOREIGN KEY (`mabinh`) REFERENCES `binh_nuoc` (`mabinh`);

--
-- Các ràng buộc cho bảng `chitietquyen`
--
ALTER TABLE `chitietquyen`
  ADD CONSTRAINT `chitietquyen_ibfk_1` FOREIGN KEY (`idquyen`) REFERENCES `nhomquyen` (`idquyen`),
  ADD CONSTRAINT `chitietquyen_ibfk_2` FOREIGN KEY (`idchucnang`) REFERENCES `danhmucchucnang` (`idchucnang`);

--
-- Các ràng buộc cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD CONSTRAINT `chi_tiet_hoa_don_ibfk_1` FOREIGN KEY (`mahoadon`) REFERENCES `hoa_don` (`mahoadon`) ON DELETE CASCADE,
  ADD CONSTRAINT `chi_tiet_hoa_don_ibfk_2` FOREIGN KEY (`mabinhnuoc`) REFERENCES `binh_nuoc` (`mabinh`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_phieu_nhap`
--
ALTER TABLE `chi_tiet_phieu_nhap`
  ADD CONSTRAINT `chi_tiet_phieu_nhap_ibfk_1` FOREIGN KEY (`maphieunhap`) REFERENCES `phieu_nhap_hang` (`maphieunhap`),
  ADD CONSTRAINT `chi_tiet_phieu_nhap_ibfk_2` FOREIGN KEY (`mabinhnuoc`) REFERENCES `binh_nuoc` (`mabinh`);

--
-- Các ràng buộc cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhan_vien` (`manv`),
  ADD CONSTRAINT `hoa_don_ibfk_2` FOREIGN KEY (`makhachhang`) REFERENCES `khach_hang` (`makhachhang`);

--
-- Các ràng buộc cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  ADD CONSTRAINT `phieu_nhap_hang_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `nhan_vien` (`manv`),
  ADD CONSTRAINT `phieu_nhap_hang_ibfk_2` FOREIGN KEY (`manhacungcap`) REFERENCES `nha_cung_cap` (`manhacungcap`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`idquyen`) REFERENCES `nhomquyen` (`idquyen`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`idnhanvien`) REFERENCES `nhan_vien` (`manv`),
  ADD CONSTRAINT `taikhoan_ibfk_3` FOREIGN KEY (`idkhachhang`) REFERENCES `khach_hang` (`makhachhang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
