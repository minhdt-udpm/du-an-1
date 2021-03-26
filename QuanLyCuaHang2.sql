USE [master]
GO
CREATE DATABASE [QuanLyCuaHang]
GO
USE [QuanLyCuaHang]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[maChucVu] [int] IDENTITY(1,1) NOT NULL,
	[tenChucVu] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[maChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChucVu_Quyen]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChucVu_Quyen](
	[maChucVu] [int] NOT NULL,
	[maQuyen] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ChucVu_Quyen] PRIMARY KEY CLUSTERED 
(
	[maChucVu] ASC,
	[maQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HangSanXuat]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangSanXuat](
	[maHangSanXuat] [int] IDENTITY(1,1) NOT NULL,
	[tenHangSanXuat] [nvarchar](100) NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_HangSanXuat] PRIMARY KEY CLUSTERED 
(
	[maHangSanXuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[taiKhoan] [varchar](20) NOT NULL,
	[maKhachHang] [int] NOT NULL,
	[tongTien] [bigint] NOT NULL,
	[ngayLapHoaDon] [date] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[maHoaDonChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[maHoaDon] [int] NOT NULL,
	[maSanPham] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
	[tongTien] [int] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[maHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[soDienThoai] [varchar](10) NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoaiSanPham] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiSanPham] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[maLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[taiKhoan] [varchar](20) NOT NULL,
	[matKhau] [varchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[maChucVu] [int] NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[soDienThoai] [varchar](10) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaPhanPhoi]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaPhanPhoi](
	[maNhaPhanPhoi] [int] IDENTITY(1,1) NOT NULL,
	[tenNhaPhanPhoi] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[soDienThoai] [varchar](10) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_NhaPhanPhoi] PRIMARY KEY CLUSTERED 
(
	[maNhaPhanPhoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[maPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[taiKhoan] [varchar](20) NOT NULL,
	[maNhaPhanPhoi] [int] NOT NULL,
	[tongTien] [bigint] NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuNhapChiTiet]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapChiTiet](
	[maPhieuNhapChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[maPhieuNhap] [int] NOT NULL,
	[maSanPham] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
	[tongTien] [int] NULL,
 CONSTRAINT [PK_PhieuNhapChiTiet] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhapChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Quyen](
	[maQuyen] [varchar](50) NOT NULL,
	[tenQuyen] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[maQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 20-Dec-19 8:45:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [int] IDENTITY(1,1) NOT NULL,
	[tenSanPham] [nvarchar](100) NULL,
	[maLoaiSanPham] [int] NOT NULL,
	[maHangSanXuat] [int] NOT NULL,
	[giaNhap] [int] NOT NULL,
	[giaBan] [int] NOT NULL,
	[tonKho] [int] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[imagePath] [nvarchar](250) NULL,
	[ghiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (1, N'Giám đốc', N'Toàn bộ các quyền')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (2, N'Cửa hàng trưởng', N'')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (3, N'Nhân viên bán hàng', N'')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (5, N'Không có', N'Dành cho Nhân Viên bị xóa')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (7, N'Quản lý kho', N'')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [ghiChu]) VALUES (13, N'Kế Toán', N'')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_BAN_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_CHUC_VU')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_DOANH_THU')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_KHACH_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_NHA_PHAN_PHOI')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_NHAN_VIEN')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_NHAP_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (1, N'QL_SAN_PHAM')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_BAN_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_KHACH_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_NHA_PHAN_PHOI')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_NHAN_VIEN')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_NHAP_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (2, N'QL_SAN_PHAM')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (3, N'QL_BAN_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (3, N'QL_SAN_PHAM')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (7, N'QL_NHAP_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (7, N'QL_SAN_PHAM')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (13, N'QL_BAN_HANG')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (13, N'QL_DOANH_THU')
INSERT [dbo].[ChucVu_Quyen] ([maChucVu], [maQuyen]) VALUES (13, N'QL_NHAP_HANG')
SET IDENTITY_INSERT [dbo].[HangSanXuat] ON 

INSERT [dbo].[HangSanXuat] ([maHangSanXuat], [tenHangSanXuat], [ghiChu]) VALUES (1, N'Samsung', N'ss')
INSERT [dbo].[HangSanXuat] ([maHangSanXuat], [tenHangSanXuat], [ghiChu]) VALUES (2, N'Apple', NULL)
INSERT [dbo].[HangSanXuat] ([maHangSanXuat], [tenHangSanXuat], [ghiChu]) VALUES (3, N'Sony', NULL)
INSERT [dbo].[HangSanXuat] ([maHangSanXuat], [tenHangSanXuat], [ghiChu]) VALUES (4, N'LG', NULL)
INSERT [dbo].[HangSanXuat] ([maHangSanXuat], [tenHangSanXuat], [ghiChu]) VALUES (5, N'Xiaomi', NULL)
SET IDENTITY_INSERT [dbo].[HangSanXuat] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (1, N'admin', 1, 11000000, CAST(0x3D400B00 AS Date), 1, NULL)
INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (2, N'admin', 2, 11000000, CAST(0x82400B00 AS Date), 1, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (4, N'admin', 9, 23000000, CAST(0x84400B00 AS Date), 1, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (5, N'admin', 10, 10000000, CAST(0x84400B00 AS Date), 1, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (6, N'admin', 8, 16700000, CAST(0x84400B00 AS Date), 1, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [taiKhoan], [maKhachHang], [tongTien], [ngayLapHoaDon], [trangThai], [ghiChu]) VALUES (7, N'admin', 13, 12500000, CAST(0x84400B00 AS Date), 1, N'')
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (1, 1, 1, 1, NULL, 11000000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (2, 2, 1, 1, NULL, 11000000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (9, 4, 9, 1, NULL, 10000000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (10, 4, 2, 1, NULL, 13000000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (11, 5, 9, 1, NULL, 10000000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (12, 6, 11, 1, NULL, 16700000)
INSERT [dbo].[HoaDonChiTiet] ([maHoaDonChiTiet], [maHoaDon], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (13, 7, 10, 1, NULL, 12500000)
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (1, N'hoang', 1, N'0123456789', 0, NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (2, N'nam', 1, N'0123456788', 1, N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (3, N'hà', 0, N'0123456787', 1, NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (4, N'huy', 1, N'0123456786', 1, NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (5, N'trang', 0, N'0123456785', 1, N'123')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (6, N'tuấn', 1, N'0123456784', 0, NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (8, N'Nguyen Van Hung', 1, N'0123456789', 1, N'kh')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (9, N'Trần Thu Hà', 0, N'0987654321', 1, N'123123')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (10, N'Vũ Thu Trang', 0, N'0123654853', 1, N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (11, N'Nguyễn Tuấn Anh', 1, N'0987489659', 1, N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (12, N'Nguyễn Văn Nam', 1, N'049876542', 1, N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [trangThai], [ghiChu]) VALUES (13, N'Vinh', 1, N'0654987125', 1, N'')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham], [ghiChu]) VALUES (1, N'Điện thoại thông minh', N'')
INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham], [ghiChu]) VALUES (2, N'Đồng hồ thông minh', N'')
INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham], [ghiChu]) VALUES (3, N'Phụ kiện', NULL)
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'admin', N'21232f297a57a5a743894a0e4a801fc3', N'Hg', CAST(0xEA1F0B00 AS Date), 1, CAST(0x66330B00 AS Date), 1, N'HN', N'0123456789', N'hg@hg.hg', 1, N'10-10-2010')
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'hoangnq', N'f5bb0c8de146c67b44babbf4e6584cc0', N'Hg', CAST(0xDA310B00 AS Date), 1, CAST(0xD03E0B00 AS Date), 3, N'HN', N'0123654987', N'gh@gh.gh', 1, NULL)
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'namnv', N'dfcb608f03547ba821285047a8c8eb6c', N'Nguyễn Văn Nam', CAST(0xF3230B00 AS Date), 1, CAST(0x81400B00 AS Date), 5, N'123zxc', N'1231231230', N'22@22.22', 0, N'17-12-2019')
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'namnv2', N'dfcb608f03547ba821285047a8c8eb6c', N'Nguyễn Văn Nam', CAST(0x1F1E0B00 AS Date), 1, CAST(0x83400B00 AS Date), 3, N'HN', N'0987456321', N'nam@123.123', 1, N'')
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'namtt', N'dfcb608f03547ba821285047a8c8eb6c', N'Trần Thành Nam', CAST(0x14270B00 AS Date), 1, CAST(0x84400B00 AS Date), 13, N'abc', N'098768962', N'22@22.22', 1, N'123')
INSERT [dbo].[NhanVien] ([taiKhoan], [matKhau], [hoTen], [ngaySinh], [gioiTinh], [ngayVaoLam], [maChucVu], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (N'trangnt', N'dfcb608f03547ba821285047a8c8eb6c', N'Nguyễn Thu Trang', CAST(0xBB200B00 AS Date), 0, CAST(0x81400B00 AS Date), 3, N'HN', N'0123456789', N'22@22.22', 1, N'123123')
SET IDENTITY_INSERT [dbo].[NhaPhanPhoi] ON 

INSERT [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi], [tenNhaPhanPhoi], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (1, N'NPP 1', N'HN', N'0987654321', N'nn@nn.nn', 1, N'')
INSERT [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi], [tenNhaPhanPhoi], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (2, N'NPP 2', N'HCM', N'0987654322', N'gg@gg.gg', 1, NULL)
INSERT [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi], [tenNhaPhanPhoi], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (3, N'NPP 3', N'DN', N'0987654323', N'hh@hh.hh', 1, N'')
INSERT [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi], [tenNhaPhanPhoi], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (4, N'NPP 4', N'Huế', N'0987456123', N'h123@123.123', 1, N'2')
INSERT [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi], [tenNhaPhanPhoi], [diaChi], [soDienThoai], [email], [trangThai], [ghiChu]) VALUES (5, N'NPP 4', N'HN', N'0658968958', N'44@55.66', 1, N'')
SET IDENTITY_INSERT [dbo].[NhaPhanPhoi] OFF
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 

INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [taiKhoan], [maNhaPhanPhoi], [tongTien], [ngayNhap], [trangThai], [ghiChu]) VALUES (1, N'admin', 1, 100000000, CAST(0x7A400B00 AS Date), 1, NULL)
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [taiKhoan], [maNhaPhanPhoi], [tongTien], [ngayNhap], [trangThai], [ghiChu]) VALUES (6, N'admin', 3, 549000000, CAST(0x82400B00 AS Date), 1, N'')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [taiKhoan], [maNhaPhanPhoi], [tongTien], [ngayNhap], [trangThai], [ghiChu]) VALUES (7, N'admin', 3, 144000000, CAST(0x84400B00 AS Date), 1, N'')
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
SET IDENTITY_INSERT [dbo].[PhieuNhapChiTiet] ON 

INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (1, 1, 1, 10, NULL, 100000000)
INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (2, 6, 2, 12, NULL, 144000000)
INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (3, 6, 1, 15, NULL, 150000000)
INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (4, 6, 9, 20, NULL, 180000000)
INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (5, 6, 11, 5, NULL, 75000000)
INSERT [dbo].[PhieuNhapChiTiet] ([maPhieuNhapChiTiet], [maPhieuNhap], [maSanPham], [soLuong], [ghiChu], [tongTien]) VALUES (6, 7, 10, 12, NULL, 144000000)
SET IDENTITY_INSERT [dbo].[PhieuNhapChiTiet] OFF
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_BAN_HANG', N'Quản lý bán hàng', N'Bán hàng, ghi đơn hàng')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_CHUC_VU', N'Quản lý chức vụ', N'Thêm sửa xóa chức vụ, quản lý quyền')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_DOANH_THU', N'Quản lý doanh thu', N'Xem doanh thu')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_KHACH_HANG', N'Quản lý khách hàng', N'Thêm sửa xóa khách hàng')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_NHA_PHAN_PHOI', N'Quản lý nhà phân phối', N'Thêm sửa xóa nhà phân phối')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_NHAN_VIEN', N'Quản lý nhân viên', N'Thêm sửa xóa nhân viên')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_NHAP_HANG', N'Quản lý nhập hàng', N'Quản lý nhập sản phẩm vào kho, ghi phiếu nhập')
INSERT [dbo].[Quyen] ([maQuyen], [tenQuyen], [ghiChu]) VALUES (N'QL_SAN_PHAM', N'Quản lý sản phẩm', N'Thêm sửa xóa sản phẩm, loại sản phẩm, hãng sản xuất')
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (1, N'SP 1', 1, 1, 10000000, 11000000, 23, 1, N'', N'')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (2, N'SP 2', 1, 2, 12000000, 13000000, 11, 1, N'', N'')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (3, N'SP 3', 1, 1, 9000000, 10000000, 0, 1, N'', N'')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (4, N'SP 4', 3, 3, 12000000, 15000000, 0, 1, N'', N'note')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (7, N'SP 5', 1, 2, 15000000, 16000000, 0, 1, N'', N'a')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (8, N'SP 6', 1, 1, 14000000, 15000000, 0, 1, N'', N'')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (9, N'SP 7', 1, 4, 9000000, 10000000, 18, 1, N'', N'')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (10, N'SP 8', 1, 1, 12000000, 12500000, 11, 1, N'', N'123abc')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (11, N'SP 10', 1, 1, 15000000, 16700000, 4, 1, N'', N'123')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [maLoaiSanPham], [maHangSanXuat], [giaNhap], [giaBan], [tonKho], [trangThai], [imagePath], [ghiChu]) VALUES (12, N'SP 11', 2, 2, 12000000, 15000000, 0, 1, N'', N'')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
ALTER TABLE [dbo].[ChucVu_Quyen]  WITH CHECK ADD  CONSTRAINT [FK_ChucVu_Quyen_ChucVu] FOREIGN KEY([maChucVu])
REFERENCES [dbo].[ChucVu] ([maChucVu])
GO
ALTER TABLE [dbo].[ChucVu_Quyen] CHECK CONSTRAINT [FK_ChucVu_Quyen_ChucVu]
GO
ALTER TABLE [dbo].[ChucVu_Quyen]  WITH CHECK ADD  CONSTRAINT [FK_ChucVu_Quyen_Quyen] FOREIGN KEY([maQuyen])
REFERENCES [dbo].[Quyen] ([maQuyen])
GO
ALTER TABLE [dbo].[ChucVu_Quyen] CHECK CONSTRAINT [FK_ChucVu_Quyen_Quyen]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[NhanVien] ([taiKhoan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPham]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([maChucVu])
REFERENCES [dbo].[ChucVu] ([maChucVu])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[NhanVien] ([taiKhoan])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi] FOREIGN KEY([maNhaPhanPhoi])
REFERENCES [dbo].[NhaPhanPhoi] ([maNhaPhanPhoi])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhap] FOREIGN KEY([maPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([maPhieuNhap])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhap]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_SanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_HangSanXuat] FOREIGN KEY([maHangSanXuat])
REFERENCES [dbo].[HangSanXuat] ([maHangSanXuat])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_HangSanXuat]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([maLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([maLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO


--
--PROCEDURE
--
CREATE PROCEDURE checkDangNhap 
@taiKhoan nvarchar(20), 
@matKhau nvarchar(50)
AS (
	select * from NhanVien where trangThai = 1 and taiKhoan = @taiKhoan and matKhau = @matKhau
)
GO
--

CREATE PROCEDURE getChucVuById
@maChucVu int
AS (
	select * from ChucVu where maChucVu = @maChucVu
)
GO

CREATE PROCEDURE getListChucVu 
AS (
	select * from ChucVu where maChucVu != 5
)
GO

CREATE PROCEDURE getQuyenByMaChucVu
@maChucVu int 
AS (
	select Quyen.maQuyen, tenQuyen, ghiChu from ChucVu_Quyen inner join Quyen on ChucVu_Quyen.maQuyen = Quyen.maQuyen where maChucVu = @maChucVu
)
GO

CREATE PROCEDURE checkExistChucVu
@maChucVu int 
AS (
	select taiKhoan from NhanVien where maChucVu = @maChucVu
)
GO

CREATE PROCEDURE xoaChucVu
@maChucVu int 
AS 
begin
	delete ChucVu_Quyen where maChucVu = @maChucVu
	delete ChucVu where maChucVu = @maChucVu
end
GO

CREATE PROCEDURE themChucVu
@tenChucVu nvarchar(50),
@ghiChu nvarchar(100)
AS 
begin
	insert ChucVu values (@tenChucVu, @ghiChu)
end
go

CREATE PROCEDURE suaChucVu
@tenChucVu nvarchar(50),
@ghiChu nvarchar(100),
@maChucVu int
AS 
begin
	update ChucVu set tenChucVu = @tenChucVu, ghiChu = @ghiChu 
	where maChucVu = @maChucVu
end
go

CREATE PROCEDURE getLastMaChucVu 
AS (
	select max(maChucVu) as maChucVu from ChucVu
)
GO

--

CREATE PROCEDURE getHangSanXuatById 
@maHangSanXuat int
AS (
	select * from HangSanXuat where maHangSanXuat = @maHangSanXuat
)
GO

CREATE PROCEDURE getListHangSanXuat 
AS (
	select * from HangSanXuat
)
GO

--

CREATE PROCEDURE getListHoaDonChiTiet 
@maHoaDon int
AS (
	select * from HoaDonChiTiet where maHoaDon = @maHoaDon
)
GO

CREATE PROCEDURE getHoaDonById 
@maHoaDon int
AS (
	select * from HoaDon where maHoaDon = @maHoaDon
)
GO

CREATE PROCEDURE themHoaDonChiTiet 
@maHoaDon int,
@maSanPham int,
@soLuong int,
@ghiChu nvarchar(100),
@tongTien int
AS 
begin
	insert HoaDonChiTiet values (@maHoaDon, @maSanPham, @soLuong, @ghiChu, @tongTien)
end
GO

--

CREATE PROCEDURE getListHoaDon 
@year int,
@month int
AS (
	select * from HoaDon where year(ngayLapHoaDon) = @year and month(ngayLapHoaDon) = @month and trangThai = 1
)
GO

CREATE PROCEDURE themHoaDon
@taiKhoan varchar(20),
@maKhachHang int,
@tongTien bigint,
@ngayLapHoaDon date,
@trangThai bit,
@ghiChu nvarchar(100)
AS 
begin
	insert HoaDon values (@taiKhoan, @maKhachHang, @tongTien, @ngayLapHoaDon, @trangThai, @ghiChu)
end
GO

CREATE PROCEDURE getLastMaHoaDon 
AS (
	select max(maHoaDon) as maHoaDon from HoaDon
)
GO

CREATE PROCEDURE getListYearHoaDon 
AS 
begin
	select YEAR(ngayLapHoaDon) as year from HoaDon where trangThai = 1 group by YEAR(ngayLapHoaDon) order by YEAR(ngayLapHoaDon) desc
end
GO

CREATE PROCEDURE loadDoanhThuThang
@year int,
@month int
AS 
begin
	select HoaDonChiTiet.maSanPham, tenSanPham, tenHangSanXuat, sum(HoaDonChiTiet.soLuong) as soLuong, sum(HoaDonChiTiet.tongTien) as doanhThuSP
	from HoaDon inner join HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon
				inner join SanPham on HoaDonChiTiet.maSanPham = SanPham.maSanPham
				inner join HangSanXuat on HangSanXuat.maHangSanXuat = SanPham.maHangSanXuat
	where month(ngayLapHoaDon) = @month and year(ngayLapHoaDon) = @year
	group by HoaDonChiTiet.maSanPham, tenSanPham, tenHangSanXuat
end
GO

--

CREATE PROCEDURE getKhachHangById
@maKhachHang int
AS 
begin
	select * from KhachHang where maKhachHang = @maKhachHang
end
GO

CREATE PROCEDURE getListKhachHang
AS 
begin
	select * from KhachHang where trangThai = 1
end
GO

CREATE PROCEDURE themKhachHang
@tenKhachHang nvarchar(50),
@gioiTinh bit,
@soDienThoai varchar(10),
@trangThai bit,
@ghiChu nvarchar(100)
AS 
begin
	insert KhachHang values (@tenKhachHang, @gioiTinh, @soDienThoai, @trangThai, @ghiChu)
end
GO

CREATE PROCEDURE suaKhachHang
@tenKhachHang nvarchar(50),
@gioiTinh bit,
@soDienThoai varchar(10),
@ghiChu nvarchar(100),
@maKhachHang int
AS 
begin
	update KhachHang set tenKhachHang = @tenKhachHang, gioiTinh = @gioiTinh, soDienThoai = @soDienThoai, ghiChu = @ghiChu 
	where maKhachHang = @maKhachHang
end
GO

CREATE PROCEDURE xoaKhachHang
@trangThai bit,
@maKhachHang int
AS 
begin
	update KhachHang set trangThai = @trangThai where maKhachHang = @maKhachHang
end
GO

CREATE PROCEDURE timKiemKhachHang
@text nvarchar(50)
AS 
begin
	select * from KhachHang where (tenKhachHang like @text or soDienThoai like @text) and trangThai = 1
end
Go

CREATE PROCEDURE getLastMaKhachHang
AS 
begin
	select max(maKhachHang) as maKhachHang from KhachHang
end
GO

--

CREATE PROCEDURE getLoaiSanPhamById
@maLoaiSanPham int
AS 
begin
	select * from LoaiSanPham where maLoaiSanPham = @maLoaiSanPham
end
GO

CREATE PROCEDURE getListLoaiSanPham
AS 
begin
	select * from LoaiSanPham
end
GO

CREATE PROCEDURE getListNhaPhanPhoi
AS 
begin
	select * from NhaPhanPhoi where trangThai = 1
end
GO

--

CREATE PROCEDURE getListNhanVien
AS 
begin
	select * from NhanVien where trangThai = 1
end
GO

CREATE PROCEDURE getNhanVienById
@taiKhoan varchar(20)
AS 
begin
	select * from NhanVien where taiKhoan = @taiKhoan
end
GO

CREATE PROCEDURE themNhanVien
@taiKhoan varchar(20),
@matKhau varchar(50),
@hoTen nvarchar(50),
@ngaySinh date,
@gioiTinh bit,
@ngayVaoLam date,
@maChucVu int,
@diaChi nvarchar(100),
@soDienThoai varchar(10),
@email varchar(50),
@trangThai bit,
@ghiChu nvarchar(100)
AS 
begin
	insert NhanVien values (@taiKhoan, @matKhau, @hoTen, @ngaySinh, @gioiTinh, @ngayVaoLam, @maChucVu, @diaChi, @soDienThoai, @email, @trangThai, @ghiChu)
end
GO

CREATE PROCEDURE suaNhanVien
@hoTen nvarchar(50),
@ngaySinh date,
@gioiTinh bit,
@ngayVaoLam date,
@maChucVu int,
@diaChi nvarchar(100),
@soDienThoai varchar(10),
@email varchar(50),
@ghiChu nvarchar(100),
@taiKhoan varchar(20)
AS 
begin
	update NhanVien set hoTen = @hoTen, ngaySinh = @ngaySinh, gioiTinh = @gioiTinh, ngayVaoLam = @ngayVaoLam, maChucVu = @maChucVu, diaChi = @diaChi, soDienThoai = @soDienThoai, email = @email, ghiChu = @ghiChu 
	where taiKhoan = @taiKhoan
end
GO

CREATE PROCEDURE doiMatKhau
@matKhau varchar(50),
@taiKhoan varchar(20)
AS 
begin
	update NhanVien set matKhau = @matKhau where taiKhoan = @taiKhoan
end
GO

CREATE PROCEDURE getListSanPham
AS 
begin
	select * from SanPham where trangThai = 1
end
GO

