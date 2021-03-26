package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.HoaDonChiTiet;

public class HoaDonDAO extends GenericDAO{
    
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
   
    public List<HoaDon> getList(int month, int year){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListHoaDon ?, ?");
            pst.setInt(1, year);
            pst.setInt(2, month);
            
            ResultSet rs = pst.executeQuery();
            List<HoaDon> listHoaDon = new ArrayList<>();
            
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getInt("maHoaDon"));
                hoaDon.setNhanVien(nhanVienDAO.getNhanVienById(rs.getString("taiKhoan")));
                hoaDon.setKhachHang(khachHangDAO.getKhachHangById(rs.getInt("maKhachHang")));
                hoaDon.setTongTien(rs.getLong("tongTien"));
                hoaDon.setNgayLapHoaDon(rs.getDate("ngayLapHoaDon"));
                hoaDon.setTrangThai(rs.getBoolean("trangThai"));
                hoaDon.setGhiChu(rs.getString("ghiChu"));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    public void them(String taiKhoan, int maKhachHang, long tongTien, String ngayLapHoaDon, String ghiChu, List<HoaDonChiTiet> listHoaDonChiTiet){
        boolean trangThai = true;
        
        try {
            PreparedStatement pst = getPreparedStatement("exec themHoaDon ?, ?, ?, ?, ?, ?");
            pst.setString(1, taiKhoan);
            pst.setInt(2, maKhachHang);
            pst.setLong(3, tongTien);
            pst.setDate(4, new Date(format.parse(ngayLapHoaDon).getTime()));
            pst.setBoolean(5, trangThai);
            pst.setString(6, ghiChu);
            pst.executeUpdate();
            
            int maHoaDon = getLastMaHoaDon();
            hoaDonChiTietDAO.them(maHoaDon, listHoaDonChiTiet);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
	
    public int getLastMaHoaDon(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getLastMaHoaDon");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("maHoaDon");
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return -1;
    }
    
    public List<Integer> getListYear(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListYearHoaDon");
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
