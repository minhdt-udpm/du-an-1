package model;

public class PhieuNhapChiTiet {

    private int maPhieuNhapChiTiet;
    private PhieuNhap phieuNhap;
    private SanPham sanPham;
    private int soLuong;
    private String ghiChu;
    private int tongTien;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(int maPhieuNhapChiTiet, PhieuNhap phieuNhap, SanPham sanPham, int soLuong, String ghiChu, int tongTien) {
        this.maPhieuNhapChiTiet = maPhieuNhapChiTiet;
        this.phieuNhap = phieuNhap;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
    }

    public int getMaPhieuNhapChiTiet() {
        return maPhieuNhapChiTiet;
    }

    public void setMaPhieuNhapChiTiet(int maPhieuNhapChiTiet) {
        this.maPhieuNhapChiTiet = maPhieuNhapChiTiet;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
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
