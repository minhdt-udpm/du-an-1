package model;

public class HangSanXuat {

    private int maHangSanXuat;
    private String tenHangSanXuat;
    private String ghiChu;

    public HangSanXuat() {
    }

    public HangSanXuat(int maHangSanXuat, String tenHangSanXuat, String ghiChu) {
        this.maHangSanXuat = maHangSanXuat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.ghiChu = ghiChu;
    }

    public int getMaHangSanXuat() {
        return maHangSanXuat;
    }

    public void setMaHangSanXuat(int maHangSanXuat) {
        this.maHangSanXuat = maHangSanXuat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
