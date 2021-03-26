package model;

import java.sql.Date;

public class PhieuNhap {

    private int maPhieuNhap;
    private NhanVien nhanVien;
    private NhaPhanPhoi nhaPhanPhoi;
    private long tongTien;
    private Date ngayNhap;
    private boolean trangThai;
    private String ghiChu;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPhieuNhap, NhanVien nhanVien, NhaPhanPhoi nhaPhanPhoi, long tongTien, Date ngayNhap, boolean trangThai, String ghiChu) {
        this.maPhieuNhap = maPhieuNhap;
        this.nhanVien = nhanVien;
        this.nhaPhanPhoi = nhaPhanPhoi;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaPhanPhoi getNhaPhanPhoi() {
        return nhaPhanPhoi;
    }

    public void setNhaPhanPhoi(NhaPhanPhoi nhaPhanPhoi) {
        this.nhaPhanPhoi = nhaPhanPhoi;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
