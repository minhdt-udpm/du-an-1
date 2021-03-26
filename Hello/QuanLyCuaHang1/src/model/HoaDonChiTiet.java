package model;

public class HoaDonChiTiet {

    private int maHoaDonChiTiet;
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuong;
    private String ghiChu;
    private int tongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHoaDonChiTiet, HoaDon hoaDon, SanPham sanPham, int soLuong, String ghiChu, int tongTien) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
    }

    public int getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(int maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    

    
}
