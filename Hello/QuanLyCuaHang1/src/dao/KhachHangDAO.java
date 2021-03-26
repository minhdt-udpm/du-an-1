package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

public class KhachHangDAO extends GenericDAO{
    
    public KhachHang getKhachHangById(int maKhachHang){
        try {
            PreparedStatement pst = getPreparedStatement("exec getKhachHangById ?");
            pst.setInt(1, maKhachHang);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getInt("maKhachHang"));
                khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
                khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
                khachHang.setSoDienThoai(rs.getString("soDienThoai"));
                khachHang.setGhiChu(rs.getString("ghiChu"));
                return khachHang;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<KhachHang> getList(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListKhachHang");
            ResultSet rs = pst.executeQuery();
            List<KhachHang> listKhachHang = new ArrayList<>();
            
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getInt("maKhachHang"));
                khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
                khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
                khachHang.setSoDienThoai(rs.getString("soDienThoai"));
                khachHang.setGhiChu(rs.getString("ghiChu"));
                listKhachHang.add(khachHang);
            }
            return listKhachHang;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
	
    public void them(String tenKhachHang, boolean gioiTinh, String soDienThoai, String ghiChu){
        boolean trangThai = true;
        try {
            PreparedStatement pst = getPreparedStatement("exec themKhachHang ?, ?, ?, ?, ?");
            pst.setString(1, tenKhachHang);
            pst.setBoolean(2, gioiTinh);
            pst.setString(3, soDienThoai);
            pst.setBoolean(4, trangThai);
            pst.setString(5, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void sua(int maKhachHang, String tenKhachHang, boolean gioiTinh, String soDienThoai, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("exec suaKhachHang ?, ?, ?, ?, ?");
            pst.setString(1, tenKhachHang);
            pst.setBoolean(2, gioiTinh);
            pst.setString(3, soDienThoai);
            pst.setString(4, ghiChu);
            pst.setInt(5, maKhachHang);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void xoa(int maKhachHang){
        try {
            PreparedStatement pst = getPreparedStatement("exec xoaKhachHang ?, ?");
            pst.setBoolean(1, false);
            pst.setInt(2, maKhachHang);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<KhachHang> timKiem(String text){
        try {
            List<KhachHang> listKhachHang = new ArrayList<>();
            PreparedStatement pst = getPreparedStatement("exec timKiemKhachHang ?");
            pst.setString(1, "%"+text+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getInt("maKhachHang"));
                khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
                khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
                khachHang.setSoDienThoai(rs.getString("soDienThoai"));
                khachHang.setGhiChu(rs.getString("ghiChu"));
                listKhachHang.add(khachHang);
            }
            return listKhachHang;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public int getLastMaKhachHang(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getLastMaKhachHang");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("maKhachHang");
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return -1;
    }
}
