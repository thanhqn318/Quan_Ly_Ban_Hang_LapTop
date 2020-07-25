Create Database LapTopStore
go
Use LapTopStore
go

CREATE TABLE KhachHang
(
	MaKH nvarchar(10) not null,
	TenKH nvarchar(50),
	DiaChi nvarchar(50),
	SDT nvarchar(15),
	GioiTinh bit,
	Email nvarchar(50),
	NgaySinh date,
	HinhAnh nvarchar(50),
	CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH),
)
go
CREATE TABLE NhanVien
(
	MaNV nvarchar(10) not null,
	TenNV nvarchar(50),
	DiaChi nvarchar(50),
	SDT nvarchar(15),
	NgaySinh date,
	GioiTinh bit,
	Email nvarchar(50),
	CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV),
)
go
CREATE TABLE LapTop
(
	MaLapTop nvarchar(10) not null,
	TenLapTop nvarchar(50),
	CauHinhCT nvarchar(200),
	Mau nvarchar(20),
	ThuongHieu nvarchar(50),
	SoLuong int,
	BaoHanh nvarchar(20),
	GiaBan money,
	HinhAnh nvarchar(50),
	CONSTRAINT PK_LapTop PRIMARY KEY (MaLapTop),
)
go

CREATE TABLE HoaDon
(
	MaHoaDon nvarchar(10) not null,
	MaKH nvarchar(10),
	MaNV nvarchar(10),
	NgayLap datetime,
	CONSTRAINT PK_HoaDon PRIMARY KEY (MaHoaDon),
	CONSTRAINT FK_HoaDon_NhanVien foreign key(MaNV) references NhanVien(MaNV),
	CONSTRAINT FK_HoaDon_KhachHang foreign key(MaKH) references KhachHang(MaKH)
)
go

CREATE TABLE ChiTietHD
(	
	MaHoaDon nvarchar(10) not null,
	MaLapTop nvarchar(10) not null,
	DonGia money,
	SoLuong int,
	GhiChu nvarchar(200),
	CONSTRAINT PK_ChiTietHD PRIMARY KEY (MaHoaDon, MaLapTop),
	CONSTRAINT FK_ChiTietHD_HoaDon foreign key(MaHoaDon) references HoaDon(MaHoaDon),
	CONSTRAINT FK_ChiTietHD_LapTop foreign key(MaLapTop) references LapTop(MaLapTop)
)
go

CREATE TABLE USERS
(
	UserName nvarchar(50) not null,
	PassWord nvarchar(50),
	Role nvarchar(50),
	constraint PK_USERS primary key(UserName)
)

INSERT INTO LapTop
VALUES (N'LT01',N'Asus Vivobook','RAM 8GB',N'Trắng','Asus',10,N'12 tháng',15000000,'Asusvivobook.jpg')