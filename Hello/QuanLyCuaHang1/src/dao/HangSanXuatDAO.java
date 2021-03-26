package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HangSanXuat;

public class HangSanXuatDAO extends GenericDAO{

    public HangSanXuat getHangSanXuatById(int maHangSanXuat){
        try {
            PreparedStatement pst = getPreparedStatement("exec getHangSanXuatById ?");
            pst.setInt(1, maHangSanXuat);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                HangSanXuat hangSanXuat = new HangSanXuat();
                hangSanXuat.setMaHangSanXuat(rs.getInt("maHangSanXuat"));
                hangSanXuat.setTenHangSanXuat(rs.getString("tenHangSanXuat"));
                hangSanXuat.setGhiChu(rs.getString("ghiChu"));
                return hangSanXuat;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<HangSanXuat> getListHangSanXuat(){
        try {
            PreparedStatement pst = getPreparedStatement("exec getListHangSanXuat");
            ResultSet rs = pst.executeQuery();
            List<HangSanXuat> listHangSanXuat = new ArrayList<>();
            
            while (rs.next()) {
                HangSanXuat hangSanXuat = new HangSanXuat();
                hangSanXuat.setMaHangSanXuat(rs.getInt("maHangSanXuat"));
                hangSanXuat.setTenHangSanXuat(rs.getString("tenHangSanXuat"));
                hangSanXuat.setGhiChu(rs.getString("ghiChu"));
                listHangSanXuat.add(hangSanXuat);
            }
            return listHangSanXuat;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public void them(String tenHangSanXuat, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("insert HangSanXuat values (?, ?)");
            pst.setString(1, tenHangSanXuat);
            pst.setString(2, ghiChu);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void sua(int maHangSanXuat, String tenHangSanXuat, String ghiChu){
        try {
            PreparedStatement pst = getPreparedStatement("update HangSanXuat set "
                                                            + "tenHangSanXuat = ?, "
                                                            + "ghiChu = ? "
                                                       + "where maHangSanXuat = ?");
            pst.setString(1, tenHangSanXuat);
            pst.setString(2, ghiChu);
            pst.setInt(3, maHangSanXuat);
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean xoa(int maHangSanXuat){
        try {
            PreparedStatement pst = getPreparedStatement("delete HangSanXuat where maHangSanXuat = ?");
            pst.setInt(1, maHangSanXuat);
            pst.executeUpdate();
            return true;
            
        } catch (SQLException sql){
            return false;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
