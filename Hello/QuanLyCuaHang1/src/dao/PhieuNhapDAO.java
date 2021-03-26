package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.PhieuNhap;
import model.PhieuNhapChiTiet;

public class PhieuNhapDAO extends GenericDAO{

    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    PhieuNhapChiTietDAO phieuNhapChiTietDAO = new PhieuNhapChiTietDAO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    NhaPhanPhoiDAO nhaPhanPhoiDAO = new NhaPhanPhoiDAO();

    public List<PhieuNhap> getList(int month, int year){
        try {
            PreparedStatement pst = getPreparedStatement("select * from PhieuNhap where year(ngayNhap) = ? and month(ngayNhap) = ? and trangThai = 1");
            pst.setInt(1, year);
            pst.setInt(2, month);
            
            ResultSet rs = pst.executeQuery();
            List<PhieuNhap> listPhieuNhap = new ArrayList<>();
            
            while (rs.next()) {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setMaPhieuNhap(rs.getInt("maPhieuNhap"));
                phieuNhap.setNhanVien(nhanVienDAO.getNhanVienById(rs.getString("taiKhoan")));
                phieuNhap.setNhaPhanPhoi(nhaPhanPhoiDAO.getNhaPhanPhoiById(rs.getInt("maNhaPhanPhoi")));
                phieuNhap.setTongTien(rs.getLong("tongTien"));
                phieuNhap.setNgayNhap(rs.getDate("ngayNhap"));
                phieuNhap.setTrangThai(rs.getBoolean("trangThai"));
                phieuNhap.setGhiChu(rs.getString("ghiChu"));
                listPhieuNhap.add(phieuNhap);
            }
            return listPhieuNhap;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public void them(String taiKhoan, int maNhaPhanPhoi, long tongTien, String ngayNhap, String ghiChu, List<PhieuNhapChiTiet> listPhieuNhapChiTiet){
        boolean trangThai = true;
        
        try {
            PreparedStatement pst = getPreparedStatement("insert PhieuNhap values (?, ?, ?, ?, ?, ?)");
            pst.setString(1, taiKhoan);
            pst.setInt(2, maNhaPhanPhoi);
            pst.setLong(3, tongTien);
            pst.setDate(4, new Date(format.parse(ngayNhap).getTime()));
            pst.setBoolean(5, trangThai);
            pst.setString(6, ghiChu);
            pst.executeUpdate();
            
            int maPhieuNhap = getLastMaPhieuNhap();
            phieuNhapChiTietDAO.them(maPhieuNhap, listPhieuNhapChiTiet);
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
        
    }
	
    public int getLastMaPhieuNhap(){
        try {
            PreparedStatement pst = getPreparedStatement("select max(maPhieuNhap) as maPhieuNhap from PhieuNhap");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("maPhieuNhap");
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return -1;
    }

    public List<Integer> getListYear(){
        try {
            PreparedStatement pst = getPreparedStatement("select YEAR(ngayNhap) as year from PhieuNhap where trangThai = 1 group by YEAR(ngayNhap) order by YEAR(ngayNhap) desc");
            ResultSet rs = pst.executeQuery();
            List<Integer> listYear = new ArrayList<>();
            while(rs.next()){
                listYear.add(rs.getInt("year"));
            }
            return listYear;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    
}
